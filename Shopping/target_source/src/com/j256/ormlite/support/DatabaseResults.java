// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

public interface DatabaseResults
{

    public abstract void close()
        throws SQLException;

    public abstract void closeQuietly();

    public abstract int findColumn(String s)
        throws SQLException;

    public abstract boolean first()
        throws SQLException;

    public abstract BigDecimal getBigDecimal(int i)
        throws SQLException;

    public abstract InputStream getBlobStream(int i)
        throws SQLException;

    public abstract boolean getBoolean(int i)
        throws SQLException;

    public abstract byte getByte(int i)
        throws SQLException;

    public abstract byte[] getBytes(int i)
        throws SQLException;

    public abstract char getChar(int i)
        throws SQLException;

    public abstract int getColumnCount()
        throws SQLException;

    public abstract String[] getColumnNames()
        throws SQLException;

    public abstract double getDouble(int i)
        throws SQLException;

    public abstract float getFloat(int i)
        throws SQLException;

    public abstract int getInt(int i)
        throws SQLException;

    public abstract long getLong(int i)
        throws SQLException;

    public abstract ObjectCache getObjectCache();

    public abstract short getShort(int i)
        throws SQLException;

    public abstract String getString(int i)
        throws SQLException;

    public abstract Timestamp getTimestamp(int i)
        throws SQLException;

    public abstract boolean last()
        throws SQLException;

    public abstract boolean moveAbsolute(int i)
        throws SQLException;

    public abstract boolean moveRelative(int i)
        throws SQLException;

    public abstract boolean next()
        throws SQLException;

    public abstract boolean previous()
        throws SQLException;

    public abstract boolean wasNull(int i)
        throws SQLException;
}
