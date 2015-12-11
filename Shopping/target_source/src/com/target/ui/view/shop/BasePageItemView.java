// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.util.AttributeSet;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.ui.model.shop.a;

// Referenced classes of package com.target.ui.view.shop:
//            ShopCardView

public abstract class BasePageItemView extends ShopCardView
{

    private boolean mImageNeedsUpdating;
    private PageItem mPageItem;

    public BasePageItemView(Context context)
    {
        super(context);
        mImageNeedsUpdating = false;
    }

    public BasePageItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mImageNeedsUpdating = false;
    }

    public BasePageItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mImageNeedsUpdating = false;
    }

    protected abstract void a();

    public PageItem getPageItem()
    {
        return mPageItem;
    }

    public void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (mImageNeedsUpdating)
        {
            mImageNeedsUpdating = false;
            a();
        }
    }

    public void setPageItemElement(a a1)
    {
        setGridHeight(a1.b());
        setGridPositionColumn(a1.d());
        setGridPositionRow(a1.c());
        setGridWidth(a1.e());
        mPageItem = a1.a();
        mImageNeedsUpdating = true;
    }
}
