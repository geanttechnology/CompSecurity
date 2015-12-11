// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.ebay.mobile.viewitem.ItemViewPhotoGalleryActivity;

// Referenced classes of package com.ebay.android.widget:
//            ImageViewPager

class val.imagePosition
    implements android.view.rAdapter._cls1
{

    final this._cls0 this$0;
    final Context val$context;
    final int val$imagePosition;

    public void onClick(View view)
    {
        if (val$context instanceof Activity)
        {
            ItemViewPhotoGalleryActivity.StartActivity((Activity)val$context, Integer.valueOf(val$imagePosition), cess._mth000(this._cls0.this));
        }
    }

    ()
    {
        this$0 = final_;
        val$context = context1;
        val$imagePosition = I.this;
        super();
    }
}
