// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;


public class TaggedItem
{

    private Object item;
    public Object tag;

    public TaggedItem(Object obj, Object obj1)
    {
        item = obj;
        tag = obj1;
    }

    public String toString()
    {
        return item.toString();
    }
}
