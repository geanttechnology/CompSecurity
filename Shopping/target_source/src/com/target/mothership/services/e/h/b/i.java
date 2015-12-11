// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.h.b;

import java.util.ArrayList;

public class i
{

    private ArrayList mDeletedLocations;
    private ArrayList mLocations;
    private int mVersion;

    public i()
    {
        mLocations = new ArrayList();
        mDeletedLocations = new ArrayList();
    }

    public int a()
    {
        return mVersion;
    }

    public ArrayList b()
    {
        return mLocations;
    }

    public ArrayList c()
    {
        return mDeletedLocations;
    }
}
