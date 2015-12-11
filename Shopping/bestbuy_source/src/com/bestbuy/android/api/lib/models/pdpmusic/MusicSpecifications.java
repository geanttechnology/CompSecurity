// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmusic;

import gu;
import java.io.Serializable;

public class MusicSpecifications
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String value;

    public MusicSpecifications()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getValue()
    {
        return value;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
