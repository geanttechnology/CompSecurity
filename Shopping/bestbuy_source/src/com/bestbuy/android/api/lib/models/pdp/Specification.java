// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class Specification
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String definition;
    private String displayName;
    private String value;

    public Specification()
    {
    }

    public String getDefinition()
    {
        return definition;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getValue()
    {
        return value;
    }

    public void setDefinition(String s)
    {
        definition = s;
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
