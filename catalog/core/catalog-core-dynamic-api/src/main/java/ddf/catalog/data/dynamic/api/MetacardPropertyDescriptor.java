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
package ddf.catalog.data.dynamic.api;

import java.io.Serializable;

import ddf.catalog.data.AttributeType;

/**
 * The MetacardPropertyDescriptorImpl interface encompasses the methods used to describe a property
 * of a DynamicMetacard instance. The methods defined here provide the ability to interrogate the
 * property and discover operational characteristics (indexed or stored by the catalog, etc.)
 */
public interface MetacardPropertyDescriptor extends Serializable {
    /**
     * Returns whether this property should be indexed by the underlying catalog source.
     * @return whether this property should be indexed by the underlying catalog source
     */
    boolean isIndexedBySource();

    /**
     * Set the flag for this attribute indicating if this attribute should be indexed by the
     * underlying catalog source.
     * @param indexedBySource true if this attribute should be indexed
     */
    void setIndexedBySource(boolean indexedBySource);

    /**
     * Indicates that this is a tokenized representation of the data. If
     * true, the attribute should be tokenized before storing.
     * @return true if the attribute data is received in a tokenized format
     */
    boolean isTokenized();

    /**
     * Set the flag indicating that this attribute is a tokenized representation of the data. If
     * true, the attribute should be tokenized before storing.
     * @param tokenized true if this attribute data is tokenized upon receipt
     */
    void setTokenized(boolean tokenized);

    /**
     * Indicates that the catalog source should storing the value of this property.
     * @return true if the catalog source should be storing the value of this property
     */
    boolean isStored();

    /**
     * Sets the flag indicating that the catalog source should store the value of this property.
     */
    void setStored(boolean stored);

    /**
     * Returns the attribute format for this property. Especially useful for properties with the
     * same underlying class type (e.g., STRING, GEOMETRY, XML).
     * @return the {@link ddf.catalog.data.AttributeType.AttributeFormat} for this property
     */
    AttributeType.AttributeFormat getFormat();

    /**
     * Sets the attribute format for this property. This is useful when the property has a common
     * representation class but is semantically different from other types, e.g. STRING, GEOMETRY,
     * XML all use String.class as their representation, but the format should be set as STRING,
     * GEOMETRY, and XML to enable code to recognize the different formats.
     * @param format the format of this property
     */
    void setFormat(AttributeType.AttributeFormat format);

    // Add the methods from the DynaProperty class

    /**
     * Gets the (optional) type of the indexed content for DynaProperty's that support this feature.
     * @return the Class for the content type if this is an indexed DynaProperty and this feature is supported. Otherwise null.
     */
    Class<?> getContentType();

    /**
     * Get the name of this property.
     * @return the name of the property
     */
    String getName();

    /**
     * Gets the Java class representing the data type of the underlying property values.
     * @return the property type
     */
    Class<?> getType();

    /**
     * Does this property represent an indexed value (ie an array or List)?
     * @return true if the property is indexed (i.e. is a List or array), otherwise false
     */
    boolean isIndexed();

    /**
     * Does this property represent a mapped value (ie a Map)?
     * @return true if the property is a Map otherwise false
     */
    boolean isMapped();
}
