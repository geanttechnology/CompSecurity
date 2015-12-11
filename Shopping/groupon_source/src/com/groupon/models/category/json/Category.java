// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.category.json;

import java.util.ArrayList;
import java.util.List;

public class Category
{
    public static class List
    {

        public java.util.List categories;

        public List()
        {
        }
    }


    public java.util.List children;
    public int count;
    public String friendlyName;
    public String friendlyNameShort;
    public String guid;
    public String id;
    public String name;

    public Category()
    {
        children = new ArrayList();
    }
}
