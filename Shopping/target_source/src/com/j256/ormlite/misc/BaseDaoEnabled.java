// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;

public abstract class BaseDaoEnabled
{

    protected transient Dao dao;

    public BaseDaoEnabled()
    {
    }

    private void checkForDao()
        throws SQLException
    {
        if (dao == null)
        {
            throw new SQLException((new StringBuilder()).append("Dao has not been set on ").append(getClass()).append(" object: ").append(this).toString());
        } else
        {
            return;
        }
    }

    public int create()
        throws SQLException
    {
        checkForDao();
        return dao.create(this);
    }

    public int delete()
        throws SQLException
    {
        checkForDao();
        return dao.delete(this);
    }

    public Object extractId()
        throws SQLException
    {
        checkForDao();
        return dao.extractId(this);
    }

    public Dao getDao()
    {
        return dao;
    }

    public String objectToString()
    {
        try
        {
            checkForDao();
        }
        catch (SQLException sqlexception)
        {
            throw new IllegalArgumentException(sqlexception);
        }
        return dao.objectToString(this);
    }

    public boolean objectsEqual(Object obj)
        throws SQLException
    {
        checkForDao();
        return dao.objectsEqual(this, obj);
    }

    public int refresh()
        throws SQLException
    {
        checkForDao();
        return dao.refresh(this);
    }

    public void setDao(Dao dao1)
    {
        dao = dao1;
    }

    public int update()
        throws SQLException
    {
        checkForDao();
        return dao.update(this);
    }

    public int updateId(Object obj)
        throws SQLException
    {
        checkForDao();
        return dao.updateId(this, obj);
    }
}
