package rnd.pattern.blackboard.autonav.controller;

import rnd.pattern.blackboard.framework.AbstractBlackBoardController;
import rnd.pattern.blackboard.framework.BlackBoardObject;

import java.time.LocalDateTime;

/**
 * This blackboard controller gets notified when one or
 * more blackboard objects are added to the blackboard
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 * 
 */
public class AutoNavBBController extends AbstractBlackBoardController {

     public void execOutcome(BlackBoardObject bbo) {
          System.out.printf("[%s] [%s] Operating brake pedal [%s]%n", LocalDateTime.now(), Thread.currentThread().getId(), bbo.getClass().getSimpleName());
     }
}
