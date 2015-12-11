// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

public class Names
    implements gu, Serializable
{

    private String shortName;

    public Names()
    {
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String s)
    {
        shortName = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [short = ").append(shortName).append("]").toString();
    }
}
