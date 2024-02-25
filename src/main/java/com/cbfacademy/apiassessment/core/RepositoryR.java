package com.cbfacademy.apiassessment.core;

import javax.persistence.PersistenceException;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public interface RepositoryR<T, ID> extends Serializable  {

// <T> meaning type which will be replaced by Recipe
// <ID> meaning ID  which will be the unique identifier (ID) for the entities

/**
 * Retrieves all entities from the repository.
 * 
 * @return a list of all entities
 */
    
 List<T> findAll() throws PersistenceException;


 /**
  * Finds an entity by its unique identifier.

  * @param id the identifier of the entity
  * @return the found entity, or null if no such entity exists
  */

  T findbyId(UUID id); 

/**
 * Saves/create/add a new entity in the repository.
 * 
 * @param entity the (@code <T>) to save/create/add
 *  @return the saved/created entity.
 */
    
  T createRecipe(T entity) throws PersistenceException;

  /**
   *  Updates an existing entity in the repository.
   * T update(T entity)
   * @param entity to update
   * return updated entity 
   */
   T updateRecipe(T entity) throws IllegalArgumentException, PersistenceException;

  /**
   * Deletes an entity from the repository based on its uniqe identifier.
   * 
   * @param id the id of the entity to delete 
   * 
   */
    
   void deleteRecipe(ID id) throws IllegalArgumentException, PersistenceException;


} 
