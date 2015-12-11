// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import com.bitstrips.imoji.ui.views.ImojiWithBadgeView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            ImageAdapter

class 
    implements Callback
{

    final ImageAdapter this$0;
    final ImojiWithBadgeView val$view;

    public void onError()
    {
    }

    public void onSuccess()
    {
        val$view.setScaleType(android.widget.Type.FIT_CENTER);
    }

    ()
    {
        this$0 = final_imageadapter;
        val$view = ImojiWithBadgeView.this;
        super();
    }
}
