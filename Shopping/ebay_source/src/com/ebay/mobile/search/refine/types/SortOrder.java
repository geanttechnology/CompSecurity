// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;


public class SortOrder
{

    public String Label;
    public String sortOrder;

    public SortOrder(String s, String s1)
    {
        Label = s;
        sortOrder = s1;
    }

    public String toString()
    {
        return Label;
    }
}
