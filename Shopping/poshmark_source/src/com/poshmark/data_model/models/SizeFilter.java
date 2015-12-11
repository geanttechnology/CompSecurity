// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.ArrayList;
import java.util.List;

public class SizeFilter
{

    List include;
    boolean my_size_v2;

    public SizeFilter()
    {
        my_size_v2 = false;
    }

    public SizeFilter(SizeFilter sizefilter)
    {
        my_size_v2 = false;
        if (sizefilter != null && sizefilter.getSizes() != null)
        {
            include = new ArrayList(sizefilter.getSizes());
        }
        my_size_v2 = sizefilter.my_size_v2;
    }

    public void addSize(String s)
    {
        if (include == null)
        {
            include = new ArrayList();
        }
        include.add(s);
    }

    public void enableMySize(boolean flag)
    {
        my_size_v2 = flag;
    }

    public boolean getMySizeFlag()
    {
        return my_size_v2;
    }

    public List getSizes()
    {
        return include;
    }
}
