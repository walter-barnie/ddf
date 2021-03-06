/**
 * Copyright (c) Codice Foundation
 * <p/>
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */

package org.codice.ddf.persistence.attributes;

import org.codice.ddf.persistence.PersistenceException;

public interface AttributesStore {
    public static final String DATA_USAGE_KEY = "data_usage";

    public static final String USER_KEY = "user";

    /**
     * Returns the user's current data usage from the persistent store
     *
     * @param username
     * @return data usage
     * @throws PersistenceException
     */
    public long getCurrentDataUsageByUser(String username) throws PersistenceException;

    /**
     * Adds the specified data usage in bytes to the user's data usage in the persistent store
     *
     * @param username
     * @param dataUsage
     * @throws PersistenceException
     */
    public void updateUserDataUsage(String username, long dataUsage) throws PersistenceException;

    /**
     * Resets the user's data usage in the persistent store to the usage specified in bytes
     *
     * @param username
     * @param dataUsage
     * @throws PersistenceException
     */
    public void setDataUsage(String username, long dataUsage) throws PersistenceException;

}
