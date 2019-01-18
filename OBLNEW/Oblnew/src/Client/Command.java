package Client;
import java.io.Serializable;


/**
 * Uses for hands all the commands that will use for client requests and server handling
 *
 */
public enum Command implements Serializable
{
	getMembers,
	getMemberByuId,
	getMemberByIdAndPass,
	getBookByName,
	getBookByAauthor,
	getBookByGenre,
	getBookByText,
	getPassByMemberID,
	getMemberByIdAndGraduation,
	searchBook,
	

}
