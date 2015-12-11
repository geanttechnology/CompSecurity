// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.ui.BottomToolBar;
import com.amazon.mShop.util.DBException;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawerView, ViewItSlidingDrawerBrowser

class val.dialog
    implements android.view.idingDrawerView._cls3
{

    final ViewItSlidingDrawerView this$0;
    final AmazonAlertDialog val$dialog;

    public void onClick(View view)
    {
        ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).deleteAllObjects();
        ViewItSlidingDrawerView.access$100(ViewItSlidingDrawerView.this);
        ViewItSlidingDrawerView.access$200(ViewItSlidingDrawerView.this).setVisibility(0);
        ViewItSlidingDrawerView.access$400(ViewItSlidingDrawerView.this).setToolBarItemEnabled(ViewItSlidingDrawerView.access$300(ViewItSlidingDrawerView.this), false);
        ViewItSlidingDrawerView.access$500(ViewItSlidingDrawerView.this).notifyDataSetChanged();
        animateClose();
        val$dialog.dismiss();
        return;
        view;
        view.printStackTrace();
        val$dialog.dismiss();
        return;
        view;
        val$dialog.dismiss();
        throw view;
    }

    ewItSlidingDrawerItemAdapter()
    {
        this$0 = final_viewitslidingdrawerview;
        val$dialog = AmazonAlertDialog.this;
        super();
    }
}
