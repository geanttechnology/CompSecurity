// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import dau;

public abstract class BaseRequestBuilderTask extends dau
{

    private static final boolean DBG = false;
    private final String mTag;

    public BaseRequestBuilderTask(String s)
    {
        super(s, new int[0]);
        mTag = s;
    }

    public abstract Object build();

    public Object call()
    {
        return build();
    }
}
