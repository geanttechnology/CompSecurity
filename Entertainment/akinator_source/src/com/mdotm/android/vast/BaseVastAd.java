// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import java.io.Serializable;

public class BaseVastAd
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected int adType;

    public BaseVastAd()
    {
    }

    public int getAdType()
    {
        return adType;
    }

    public void setAdType(int i)
    {
        adType = i;
    }
}
