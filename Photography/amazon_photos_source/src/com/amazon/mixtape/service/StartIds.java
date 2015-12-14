// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.app.Service;
import java.util.Collection;
import java.util.HashSet;

public class StartIds
{

    private Collection mIds;
    private int mMostRecentStartId;
    private Service mService;

    public StartIds(Service service)
    {
        mIds = new HashSet();
        mService = service;
    }

    public void add(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mIds.add(Integer.valueOf(i));
        mMostRecentStartId = Math.max(mMostRecentStartId, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void remove(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mIds.remove(Integer.valueOf(i));
        if (mIds.isEmpty())
        {
            mService.stopSelf(mMostRecentStartId);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
