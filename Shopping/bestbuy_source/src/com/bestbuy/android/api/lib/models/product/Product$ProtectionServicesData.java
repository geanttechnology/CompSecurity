// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;

public class description
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String description;
    private String title;
    private String value;

    public String getDescription()
    {
        return description;
    }

    public String getTitle()
    {
        return title;
    }

    public String getValue()
    {
        return value;
    }

    public (String s, String s1, String s2)
    {
        title = s;
        value = s1;
        description = s2;
    }
}
