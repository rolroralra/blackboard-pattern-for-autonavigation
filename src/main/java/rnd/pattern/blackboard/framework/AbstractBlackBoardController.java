package rnd.pattern.blackboard.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The AbstractBlackBoardController implements {@link BlackBoardController}
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 */
public abstract class AbstractBlackBoardController implements BlackBoardController {
     protected List<KnowledgeSource> knowledgeSourceList = new ArrayList<>();

     protected ExecutorService executorService;

     @Override
     public void update(Observable blackBoard, Object blackBoardObject) {

          if (((BlackBoardObject) blackBoardObject).isReady())
               this.execOutcome((BlackBoardObject) blackBoardObject);
          else {
               for (KnowledgeSource knowledgeSource : knowledgeSourceList) {
                    if (knowledgeSource.isInterested((BlackBoardObject) blackBoardObject, (AbstractBlackBoard) blackBoard)) {
                         this.enrollKnowledgeSource(knowledgeSource, executorService);
                         break;
                    }
               }
          }
     }

     public void setKnowledgeSourceList(List<KnowledgeSource> knowledgeSourceList) {
          this.knowledgeSourceList = knowledgeSourceList;
     }

     // https://codechacha.com/ko/java-executors/
     public void enrollKnowledgeSource(KnowledgeSource knowledgeSource, ExecutorService executorService) {

          executorService = Executors.newFixedThreadPool(1);
          executorService.submit(knowledgeSource);
          executorService.shutdown();

     }

}
