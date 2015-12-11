// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

// Referenced classes of package com.smule.pianoandroid.data.db:
//            CascadableEntity

public class CascadableDao extends BaseDaoImpl
{

    public CascadableDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        super(connectionsource, databasetableconfig);
    }

    public CascadableDao(ConnectionSource connectionsource, Class class1)
    {
        super(connectionsource, class1);
    }

    public CascadableDao(Class class1)
    {
        super(class1);
    }

    public int create(CascadableEntity cascadableentity)
    {
        int i = super.create(cascadableentity);
        if (i < 0)
        {
            return i;
        } else
        {
            cascadableentity.postCreate();
            return i;
        }
    }

    public volatile int create(Object obj)
    {
        return create((CascadableEntity)obj);
    }

    public int delete(CascadableEntity cascadableentity)
    {
        int i = super.delete(cascadableentity);
        if (i < 0)
        {
            return i;
        } else
        {
            cascadableentity.preDelete();
            return i;
        }
    }

    public volatile int delete(Object obj)
    {
        return delete((CascadableEntity)obj);
    }

    public int update(CascadableEntity cascadableentity)
    {
        int i = super.update(cascadableentity);
        if (i < 0)
        {
            return i;
        } else
        {
            cascadableentity.postUpdate();
            return i;
        }
    }

    public volatile int update(Object obj)
    {
        return update((CascadableEntity)obj);
    }
}
