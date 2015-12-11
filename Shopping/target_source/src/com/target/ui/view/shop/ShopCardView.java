// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ShopCardView extends FrameLayout
    implements com.target.ui.layout_manager.CascadeLayoutManager.a
{

    private Rect mDefaultAdditionalMargins;
    private int mGridHeight;
    private int mGridPositionColumn;
    private int mGridPositionRow;
    private int mGridWidth;

    public ShopCardView(Context context)
    {
        super(context);
        mGridHeight = 1;
        mGridPositionColumn = 0;
        mGridPositionRow = 0;
        mGridWidth = 1;
        mDefaultAdditionalMargins = new Rect(0, 0, 0, 0);
    }

    public ShopCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mGridHeight = 1;
        mGridPositionColumn = 0;
        mGridPositionRow = 0;
        mGridWidth = 1;
        mDefaultAdditionalMargins = new Rect(0, 0, 0, 0);
    }

    public ShopCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mGridHeight = 1;
        mGridPositionColumn = 0;
        mGridPositionRow = 0;
        mGridWidth = 1;
        mDefaultAdditionalMargins = new Rect(0, 0, 0, 0);
    }

    public Rect getAdditionalMargins()
    {
        return mDefaultAdditionalMargins;
    }

    public int getGridHeight()
    {
        return mGridHeight;
    }

    public int getGridPositionColumn()
    {
        return mGridPositionColumn;
    }

    public int getGridPositionRow()
    {
        return mGridPositionRow;
    }

    public int getGridWidth()
    {
        return mGridWidth;
    }

    public void setGridHeight(int i)
    {
        mGridHeight = i;
    }

    public void setGridPositionColumn(int i)
    {
        mGridPositionColumn = i;
    }

    public void setGridPositionRow(int i)
    {
        mGridPositionRow = i;
    }

    public void setGridWidth(int i)
    {
        mGridWidth = i;
    }
}
