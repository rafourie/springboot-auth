package com.sb.user.dao;

/*import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;*/

import com.sb.user.model.System;

/*@Repository*/
public interface SystemRepository /*extends CrudRepository<System,Long>*/ {

  com.sb.user.model.System findByName(final String name);
}
