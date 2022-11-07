import java.util.LinkedList;
import java.util.Scanner;

public class VotingMachine {
	Scanner keyboard = new Scanner(System.in);
	private ElectionData electionData;
	VotingMachine(){
		electionData = new ElectionData();
	}
	public VotingMachine (ElectionData electionData) {
		this.electionData = electionData;
	
	}
	
	/**
 	 * returns Election Data
 	 * @return ElectionData
 	 * @throws CandidateExistsException if the candidate is already in the system 
 	 */
	public  ElectionData getterelectionVoter() {
		return(this.electionData);
	}
	
	  /**
	 	 * prints the ballot
	 	 * @return void 
	 	 */
	  public void printBallot() {
		  LinkedList<String> ballot = new LinkedList<String>(electionData.getterBallot());
		  System.out.println("The candidates are ");
		  for (String s : ballot) {
			  System.out.println(s);
		  }
	  }
	  /**
	 	 * adds votes and processes votes as an output
	 	 * @return void
	 	 * @throws DuplicateVotessException if the candidate is entered twice
	 	 * @throws UnknownCandidateException when an unknown candidate is not in the ballot
	 	 */ 
		  public void screen() {
		    this.printBallot();
		    Scanner keyboard = new Scanner(System.in);
		    ElectionData electionData = new ElectionData();
		    VotingMachine C = new VotingMachine();
		
		    System.out.println("Who do you want to vote for?");
		    String candidate = keyboard.next();
		    String candidate2 = keyboard.next();
		    String candidate3 = keyboard.next();
		    try {
		    electionData.processVote(candidate,candidate2,candidate3);;
		    }
		    catch(UnknownCandidateException unkown){
		    	 System.out.println("Do you want to add this person to the ballot?");
		    	 String answer = keyboard.next();
		    	 if(answer.equals("Y")) {
		    		 C.addWriteIn(); 
		    	 }
		    	 return;
		    	
		    }
		    catch(DuplicateVotesException dup ) {
		    	System.out.println("Candidate already exists");
	    		return;
		    }
		    
		    C.addWriteIn();
		    System.out.println("You voted for " + candidate);
		  }
	
		  /**
		 	 * See if candidate exists
		 	 * @return void
		 	 * @throws CandidateExistsException if the candidate is already in the system 
		 	 */
	public void addWriteIn() {
		    String cand = keyboard.next();
		    	try {
		    		electionData.addCandidate(cand);
		    	}
		    	catch (CandidateExistsException candidate) {
		    		System.out.println("Candidate already exists");
		    		return;
		    	}
		    	System.out.println("Candidate was added successfully");
		    }
	
		    
	    }
	


