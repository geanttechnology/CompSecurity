// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


class ObjectAndStatic
{

    private final boolean mIsStatic;
    private final Object mObject;

    ObjectAndStatic(Object obj, boolean flag)
    {
        mObject = obj;
        mIsStatic = flag;
    }

    public Object getObject()
    {
        return mObject;
    }

    public boolean isStatic()
    {
        return mIsStatic;
    }
}
