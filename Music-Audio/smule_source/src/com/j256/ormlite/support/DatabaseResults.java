// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.InputStream;
import java.sql.Timestamp;

public interface DatabaseResults
{

    public abstract int findColumn(String s);

    public abstract InputStream getBlobStream(int i);

    public abstract boolean getBoolean(int i);

    public abstract byte getByte(int i);

    public abstract byte[] getBytes(int i);

    public abstract char getChar(int i);

    public abstract int getColumnCount();

    public abstract double getDouble(int i);

    public abstract float getFloat(int i);

    public abstract int getInt(int i);

    public abstract long getLong(int i);

    public abstract ObjectCache getObjectCache();

    public abstract short getShort(int i);

    public abstract String getString(int i);

    public abstract Timestamp getTimestamp(int i);

    public abstract boolean next();

    public abstract boolean wasNull(int i);
}
