import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
class ElectionData {
private Scanner keyboard = new Scanner(System.in);
  
  private HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
  private HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
  private HashMap<String, Integer> hash3 = new HashMap<String, Integer>();
  
  LinkedList<String> ballot = new LinkedList<String>(hash1.keySet());
  
  public LinkedList<String> getterBallot(){
	  return new LinkedList<String>(hash1.keySet());
  }
  
  /**
	 * adds candidate to the candidate list in the system
	 * @param String person
	 * @return void
	 * @throws CandidateExistsException if the candidate is already in the system 
	 */
public void addCandidate(String person) throws CandidateExistsException{
	  if (hash1.equals(person) != true){
		  hash1.put(person,0);
		  hash2.put(person,0);
		  hash3.put(person,0);
	  }
	  else {
		  throw new CandidateExistsException(person);
	  }
}
  
  /**
	 * take three places and processes the votes in the system
	 * @param String place1
	 * @param String place2
	 * @param String place3
	 * @return void
	 * @throws UnknownCandidateException when the candidate given is not one of the candidates
	 * @throws DuplicateVotesException when the input is one of more of the same candidates of each round
	 */
  
  public void processVote (String place1, String place2, String place3) throws UnknownCandidateException, DuplicateVotesException{
	  LinkedList<String> candidate = new LinkedList<>();
	  candidate.add(place1);
	  candidate.add(place2);
	  candidate.add(place3);
	  
	  for (String names: candidate) {
		  
		  if (hash1.containsKey(names) != true ) {
			  
			  throw new UnknownCandidateException(names);
		  }
	  }
	  if (place1.equals(place2)) {
		  throw new DuplicateVotesException(place1);		  
	  }
	  else if (place2.equals(place3)) {
		  throw new DuplicateVotesException(place1);		  
	  }
	  else if (place3.equals(place1)) {
		  throw new DuplicateVotesException(place1);		  
	  }
	  else {
		  hash1.replace(place1, (hash1.get(place1)+1));
		  hash2.replace(place2, (hash2.get(place2)+1));
		  hash3.replace(place3, (hash3.get(place3)+1));
  		}
  }

  /**
 	 * the winner is the candidate with more than 50% of first place votes.
 	 * @return String
 	 */  
  public String findWinnerMostFirstVotes() {
	  LinkedList<String> place = new LinkedList<String>(hash1.keySet());
	  double count = 0;
	  double max = 0;
	  String runOff = "";
	  boolean shouldReturn = false;
	  
	  for (String name:place) {
		  count = count + hash1.get(name);
		  
		  
		  if (hash1.get(name)> max) {
			 max = hash1.get(name);
			  runOff = name;
			  shouldReturn = false;
		  }
		  if (hash1.get(name) == max) {
			  shouldReturn = true;
		  }
		  
	  }
	 
	  if ((max/count) >= .50) {
		  return runOff;
	  }
	  if (shouldReturn == true) {
		  return "Runoff required";
	  }
	  return "Runoff required";
  }
  

  
  /**
	 * returns winner(s) with most points 
	 * @return String
	 */ 
  public String findWinnerMostPoints() {
	  LinkedList<String> key = new LinkedList<String>(hash1.keySet());
	  String winner = "";
	  int count = 0;
	  String name = "";
	  int  total = 0;
	  for(String person : key) {
		  total = 0;
		  total = ((hash1.get(person)*3)+
				  (hash2.get(person)*2)+
				  (hash3.get(person)*1));
		  name = person;
	  }
	  if (total>count) {
		  winner = name;
		  
	  } 
	  return winner; 		  
  }
 
}
