// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemBase, GNOItemAdapter, GNODrawerFakeExpandCollapseLayout, GNODrawerItem, 
//            GNODrawerItemHideable

private class this._cls0 extends GNODrawerItemBase
{

    private Runnable mEndActionRunnable;
    private boolean mIsExpanding;
    private boolean mShouldShowExpandingArea;
    final GNOItemAdapter this$0;

    public String getId()
    {
        return "GNOItemAdapter.FakeExpandCollapseItem";
    }

    public this._cls0 getType()
    {
        return this._fld0;
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        Object obj;
        if (view == null)
        {
            view = new GNODrawerFakeExpandCollapseLayout(viewgroup.getContext());
        } else
        {
            view = (GNODrawerFakeExpandCollapseLayout)view;
        }
        obj = getItem(GNOItemAdapter.access$400(GNOItemAdapter.this));
        viewgroup = new ArrayList();
        obj = ((GNODrawerItem) (obj)).getChildren().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            GNODrawerItem gnodraweritem = (GNODrawerItem)((Iterator) (obj)).next();
            if (!(gnodraweritem instanceof GNODrawerItemHideable) || !((this._cls0)gnodraweritem)._mth0())
            {
                viewgroup.add(gnodraweritem);
            }
        } while (true);
        view.setItems(viewgroup);
        view.startExpandCollapseAnimation(mIsExpanding, mShouldShowExpandingArea, new Runnable() {

            final GNOItemAdapter.FakeExpandCollapseDrawerItem this$1;

            public void run()
            {
                GNOItemAdapter.access$602(this$0, false);
                if (!mIsExpanding)
                {
                    GNOItemAdapter.access$402(this$0, null);
                }
                updateVisibleItems();
                if (mEndActionRunnable != null)
                {
                    mEndActionRunnable.run();
                }
            }

            
            {
                this$1 = GNOItemAdapter.FakeExpandCollapseDrawerItem.this;
                super();
            }
        });
        return view;
    }

    public void setAnimationType(boolean flag, boolean flag1, Runnable runnable)
    {
        mIsExpanding = flag;
        mShouldShowExpandingArea = flag1;
        mEndActionRunnable = runnable;
    }



    public _cls1.this._cls1()
    {
        this$0 = GNOItemAdapter.this;
        super();
    }
}
