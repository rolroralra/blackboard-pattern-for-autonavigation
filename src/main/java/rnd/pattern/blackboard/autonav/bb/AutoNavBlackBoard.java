package rnd.pattern.blackboard.autonav.bb;

import rnd.pattern.blackboard.framework.AbstractBlackBoard;
import rnd.pattern.blackboard.framework.BlackBoardObject;

import java.time.LocalDateTime;

public class AutoNavBlackBoard extends AbstractBlackBoard { 

     public void addBlackBoardObject(BlackBoardObject bbo) {
    	 
          System.out.printf("[%s] [%s] Blackboard received BBO %s%n", LocalDateTime.now(), Thread.currentThread().getId(), bbo.getClass().getName());

          super.addBlackBoardObject(bbo);
     }
}
