// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.groupon.view.DealDetailsTemporaryImage;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class this._cls0
    implements Callback
{

    final HotelDetails this$0;

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(ImageView imageview)
    {
        temporaryDealImageView.animate().alpha(0.0F).setDuration(200L).setStartDelay(400L);
    }

    yImage()
    {
        this$0 = HotelDetails.this;
        super();
    }
}
