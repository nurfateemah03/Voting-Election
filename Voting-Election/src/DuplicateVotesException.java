public class DuplicateVotesException extends Exception{
	private String person;
	
	public DuplicateVotesException(String c){
		this.person = c;
	}
	
	public String getCandidate() {
		return this.getCandidate();
	}
}