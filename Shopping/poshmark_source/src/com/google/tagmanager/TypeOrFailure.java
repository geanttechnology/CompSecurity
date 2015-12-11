// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


class TypeOrFailure
{

    private LoadCallback.Failure mFailure;
    private Object mType;

    public TypeOrFailure(LoadCallback.Failure failure)
    {
        mFailure = failure;
    }

    public TypeOrFailure(Object obj)
    {
        mType = obj;
    }

    public LoadCallback.Failure getFailure()
    {
        return mFailure;
    }

    public Object getType()
    {
        return mType;
    }
}
