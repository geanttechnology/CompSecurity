// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.util.Iterator;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, Dao, CloseableIterator

public class RuntimeExceptionDao
    implements CloseableIterable
{

    private static final com.j256.ormlite.logger.Log.Level LOG_LEVEL;
    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/dao/RuntimeExceptionDao);
    private Dao dao;

    public RuntimeExceptionDao(Dao dao1)
    {
        dao = dao1;
    }

    public CloseableIterator closeableIterator()
    {
        return dao.closeableIterator();
    }

    public CloseableIterator iterator()
    {
        return dao.iterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    static 
    {
        LOG_LEVEL = com.j256.ormlite.logger.Log.Level.DEBUG;
    }
}
