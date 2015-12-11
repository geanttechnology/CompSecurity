// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class Descriptions
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xacd009f2cc3ccfebL;
    private String shortDesc;

    public Descriptions()
    {
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String s)
    {
        shortDesc = s;
    }
}
