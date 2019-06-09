/**
 * 
 */
package dev.codethat.retail.adapter;

/**
 * @author Bharath
 *
 */
public interface ServiceAdapterI<T, U> {
	
	U get(T id);
}
