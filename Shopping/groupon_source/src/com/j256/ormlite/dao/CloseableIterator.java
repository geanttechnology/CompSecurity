// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Iterator;

public interface CloseableIterator
    extends Iterator
{

    public abstract void close()
        throws SQLException;

    public abstract void moveToNext();

    public abstract Object nextThrow()
        throws SQLException;
}
