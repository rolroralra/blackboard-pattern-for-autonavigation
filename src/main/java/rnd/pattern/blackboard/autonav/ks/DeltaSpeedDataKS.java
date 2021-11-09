package rnd.pattern.blackboard.autonav.ks;

import rnd.pattern.blackboard.autonav.bbo.BrakePedalBBO;
import rnd.pattern.blackboard.autonav.bbo.DeltaSpeedDataBBO;
import rnd.pattern.blackboard.framework.AbstractKnowledgeSource;
import rnd.pattern.blackboard.framework.BlackBoard;
import rnd.pattern.blackboard.framework.BlackBoardObject;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The DeltaSpeedDataKS is an implementation of {@link AbstractKnowledgeSource}
 * This knowledge source operates on blackboard objects of the type DeltaSpeedDataBBO
 * It transforms the DeltaSpeedDataBBO into the BrakePedalBBO and adds it to the blackboard.
 * Also sets the isReady flag to true to indicate that a decision point has been reached
 * 
 * The process method in this class is just printing a message for now
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 *
 */
public class DeltaSpeedDataKS extends AbstractKnowledgeSource {

     // Condition
     public boolean isInterested(BlackBoardObject bbo, BlackBoard bb) {

          if (bbo instanceof DeltaSpeedDataBBO) {
        	  
               this.bbo = bbo;
               this.bb = bb;

               return true;
          }
          return false;
     }

     // Exec Action
     public BlackBoardObject process(BlackBoardObject bbo) {
          BrakePedalBBO brakePedalBBO = new BrakePedalBBO();
          
          brakePedalBBO.setReady(true);

          System.out.printf("[%s] [%s] DeltaSpeedDataKS processed DeltaSpeedDataBBO%n", LocalDateTime.now(), Thread.currentThread().getId() );
          return brakePedalBBO;

     }
}
