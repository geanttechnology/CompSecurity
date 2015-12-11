// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.browse;

import java.io.Serializable;
import java.util.List;

public class UberCategoryList
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private List header;

    public UberCategoryList()
    {
    }

    public List getHeader()
    {
        return header;
    }

    public void setHeader(List list)
    {
        header = list;
    }
}
