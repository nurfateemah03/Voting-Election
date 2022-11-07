import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Examples {
	  // method to set up a ballot and cast votes

	  ElectionData Setup1 () {

	    ElectionData ED = new ElectionData();
	  
	    // put candidates on the ballot
	    try {

	       ED.addCandidate("gompei");
	       ED.addCandidate("husky");
	       ED.addCandidate("ziggy");

	    } catch (Exception e) {}

	    // cast votes

	    try {

	      ED.processVote("gompei", "husky", "ziggy");
	      ED.processVote("gompei", "ziggy", "husky");
	      ED.processVote("husky", "gompei", "ziggy");

	    } catch (Exception e) {}

	    return(ED);

	  }
	  ElectionData Setup2 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("bob");
		       ED.addCandidate("sam");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		    	  ED.processVote("sam", "bob", "gompei");
			      ED.processVote("sam", "gompei", "bob");
			      ED.processVote("sam", "gompei", "bob");
		    

		    } catch (Exception e) {}

		    return(ED);

		  }
	  ElectionData Setup3 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("blue");
		       ED.addCandidate("red");
		       ED.addCandidate("green");

		    } catch (Exception e) {}

		    // cast votes

		    try {
		       	ED.processVote("red", "blue", "green");
			      ED.processVote("green", "red", "blue");
			      ED.processVote("blue", "green", "red");
			   
		    } catch (Exception e) {}

		    return(ED);

		  }

	  // now run a test on a specific election
	  @Test
	  public void testMostFirstWinner () {
	    assertEquals ("gompei", Setup1().findWinnerMostFirstVotes());
	  }
	  @Test
	  public void testMostFirstWinner1 () {
	    assertEquals ("Runoff required", Setup3().findWinnerMostFirstVotes());
	  }
	  @Test
	  public void testfindWinnerMostPoints () {
	    assertEquals ("gompei", Setup1().findWinnerMostPoints());
	  }
	  @Test
	  public void testfindWinnerMostPoints1 () {
	    assertEquals ("sam", Setup2().findWinnerMostPoints());
	  }
	  @Test
	  public void testfindWinnerMostPoints3 () {
	    assertEquals ("blue", Setup3().findWinnerMostPoints());
	  }
	  
	  @Test(expected=UnknownCandidateException.class)
	  public void testUnknownCandidateException() throws UnknownCandidateException,DuplicateVotesException
	  {
	  Setup2().processVote("e", "3", "r");
	  }
	  @Test(expected=DuplicateVotesException.class)
	  public void testDuplicateVotesException() throws UnknownCandidateException,DuplicateVotesException
	  {
	  Setup1().processVote("gompei", "ziggy", "ziggy");
	  }
	  @Test(expected=CandidateExistsException.class)
	  public void CandidateExistsException() throws CandidateExistsException
	  {
	  Setup1().addCandidate("gompei");
	  }
}


