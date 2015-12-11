// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemView, ViewItSlidingDrawerBrowser

class this._cls0
    implements android.view.ner
{

    final ViewItItemView this$0;

    public void onClick(View view)
    {
        showItemContent();
        if (ViewItItemView.access$300(ViewItItemView.this) != null)
        {
            ViewItItemView.access$300(ViewItItemView.this).recoverUndo(ViewItItemView.access$000(ViewItItemView.this));
        }
    }

    erBrowser()
    {
        this$0 = ViewItItemView.this;
        super();
    }
}
