// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class BundleDescriptions
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String longName;

    public BundleDescriptions()
    {
    }

    public String getLongName()
    {
        return longName;
    }

    public void setLongName(String s)
    {
        longName = s;
    }
}
