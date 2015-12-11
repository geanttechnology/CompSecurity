// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;
import java.util.ArrayList;

public class AppliedFacets
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String id;
    private ArrayList values;

    public AppliedFacets()
    {
    }

    public String getId()
    {
        return id;
    }

    public ArrayList getValues()
    {
        return values;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setValues(ArrayList arraylist)
    {
        values = arraylist;
    }
}
