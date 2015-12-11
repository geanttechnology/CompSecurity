// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class Names
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x3763872448a976b0L;
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
}
