// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;

public abstract class BaseDaoEnabled
{

    protected transient Dao dao;

    public BaseDaoEnabled()
    {
    }

    public void setDao(Dao dao1)
    {
        dao = dao1;
    }
}
