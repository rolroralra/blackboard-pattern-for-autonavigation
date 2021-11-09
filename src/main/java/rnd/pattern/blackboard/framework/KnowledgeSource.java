package rnd.pattern.blackboard.framework;

/**
 * The BlackBoard notifies the BlackBoardController whenever it receives a BlackBoardObject
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 *
 */
public interface KnowledgeSource extends Runnable {

     boolean isInterested(BlackBoardObject bbo, BlackBoard bb);

     BlackBoardObject process(BlackBoardObject bbo);

     void updateBlackBoardObject(BlackBoardObject bbo);
}
