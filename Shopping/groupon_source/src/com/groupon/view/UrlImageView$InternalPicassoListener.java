// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.widget.ImageView;
import com.groupon.tracking.mobile.sdk.Logger;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view:
//            UrlImageView

private class <init>
    implements Callback
{

    final UrlImageView this$0;

    public void onError(ImageView imageview)
    {
        Logger logger = UrlImageView.access$400();
        String s1 = UrlImageView.access$200(UrlImageView.this);
        String s;
        int i;
        if (UrlImageView.access$300())
        {
            s = "device_is_at_or_below_2012";
        } else
        {
            s = "device_is_above_2012";
        }
        if (UrlImageView.enable565Bitmap1506)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        logger.logGeneralEvent("image_request_failed", s1, s, i, Logger.NULL_NST_FIELD);
        if (UrlImageView.access$100(UrlImageView.this) != null)
        {
            UrlImageView.access$100(UrlImageView.this).onError(imageview);
        }
    }

    public void onSuccess(ImageView imageview)
    {
        if (UrlImageView.access$100(UrlImageView.this) != null)
        {
            UrlImageView.access$100(UrlImageView.this).onSuccess(imageview);
        }
    }

    private ()
    {
        this$0 = UrlImageView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
