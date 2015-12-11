// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;


public class Margins
{

    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public Margins()
    {
        this(0);
    }

    public Margins(int i)
    {
        bottom = i;
        right = i;
        top = i;
        left = i;
    }

    public Margins(int i, int j, int k, int l)
    {
        left = i;
        top = j;
        right = k;
        bottom = l;
    }

    public Margins(Margins margins)
    {
        left = margins.left;
        top = margins.top;
        right = margins.right;
        bottom = margins.bottom;
    }

    public int getBottom()
    {
        return bottom;
    }

    public int getLeft()
    {
        return left;
    }

    public int getRight()
    {
        return right;
    }

    public int getTop()
    {
        return top;
    }
}
