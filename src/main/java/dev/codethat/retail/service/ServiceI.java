/**
 * 
 */
package dev.codethat.retail.service;

/**
 * @author Bharath
 *
 */
public interface ServiceI<T, U> {
	
	U get(T request);
	
	boolean update(T request);
}
