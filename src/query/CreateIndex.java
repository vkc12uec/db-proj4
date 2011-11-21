package query;

import global.Minibase;

import java.util.HashMap;

import parser.AST_CreateIndex;
import parser.ParseException;
import relop.Schema;

/**
 * Execution plan for creating indexes.
 */
class CreateIndex implements Plan {

	/**
	 * Optimizes the plan, given the parsed query.
	 * 
	 * @throws QueryException if index already exists or table/column invalid
	 */
	/** Name of the index to create. */
	protected String name_index;
	protected String name_table;
	protected String name_column;

	/** Schema of the table to create. */
	protected Schema schema;

	public CreateIndex(AST_CreateIndex tree) throws QueryException {
		name_index = tree.getFileName();
		QueryCheck.fileNotExists(name_index);

		name_table = tree.getIxTable();
		name_column = tree.getIxColumn();
	} // public CreateIndex(AST_CreateIndex tree) throws QueryException

	/**
	 * Executes the plan and prints applicable output.
	 */
	public void execute() {
		HashMap <Integer, String> hm = new HashMap <Integer, String>();
		//TODO: Check if this hm method is correct

		Minibase.SystemCatalog.createIndex(name_index, name_table, name_column);

		// print the output message
		System.out.println("Index created ");

	} // public void execute()

} // class CreateIndex implements Plan
