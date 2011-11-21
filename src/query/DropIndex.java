package query;

import global.Minibase;
import parser.AST_DropIndex;

/**
 * Execution plan for dropping indexes.
 */
class DropIndex implements Plan {

	/**
	 * Optimizes the plan, given the parsed query.
	 * 
	 * @throws QueryException if index doesn't exist
	 */
	protected String fileName;

	public DropIndex(AST_DropIndex tree) throws QueryException {
		fileName = tree.getFileName();
		QueryCheck.fileNotExists(fileName);
	} // public DropIndex(AST_DropIndex tree) throws QueryException

	/**
	 * Executes the plan and prints applicable output.
	 */
	public void execute() {
		Minibase.SystemCatalog.dropIndex(fileName);
		// print the output message
		System.out.println("Index deleted");

	} // public void execute()

} // class DropIndex implements Plan
