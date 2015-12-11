// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.shop;

import com.target.mothership.model.page_item.interfaces.CardSize;
import com.target.mothership.model.page_item.interfaces.PageItem;

public class a
{

    private int mGridHeight;
    private int mGridPositionColumn;
    private int mGridPositionRow;
    private int mGridWidth;
    private PageItem mPageItem;

    public a(PageItem pageitem)
    {
        mGridHeight = 1;
        mGridWidth = 1;
        mPageItem = pageitem;
        a(mPageItem.b().a());
        d(mPageItem.b().b());
    }

    public PageItem a()
    {
        return mPageItem;
    }

    public void a(int i)
    {
        mGridHeight = i;
    }

    public int b()
    {
        return mGridHeight;
    }

    public void b(int i)
    {
        mGridPositionRow = i;
    }

    public int c()
    {
        return mGridPositionRow;
    }

    public void c(int i)
    {
        mGridPositionColumn = i;
    }

    public int d()
    {
        return mGridPositionColumn;
    }

    public void d(int i)
    {
        mGridWidth = i;
    }

    public int e()
    {
        return mGridWidth;
    }

    public boolean f()
    {
        return mGridHeight == 1 && mGridWidth == 1;
    }

    public boolean g()
    {
        return mGridHeight > 1 || mGridWidth > 1;
    }
}
