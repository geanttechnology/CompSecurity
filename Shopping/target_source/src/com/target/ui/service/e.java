// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.mothership.model.a.c;
import com.target.mothership.model.d;

public class e
{

    private static e sInstance;
    private c mDepartmentAdjacencyManager;

    private e()
    {
        mDepartmentAdjacencyManager = new c();
    }

    public static e a()
    {
        if (sInstance == null)
        {
            sInstance = new e();
        }
        return sInstance;
    }

    public void a(d d)
    {
        mDepartmentAdjacencyManager.a(d);
    }
}
