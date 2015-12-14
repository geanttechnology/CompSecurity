// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.nativeads:
//            NativeImageHelper

static final class val.imageView
    implements com.mopub.volley.toolbox.tener
{

    final ImageView val$imageView;

    public void onErrorResponse(VolleyError volleyerror)
    {
        MoPubLog.d("Failed to load image.", volleyerror);
        val$imageView.setImageDrawable(null);
    }

    public void onResponse(com.mopub.volley.toolbox.tainer tainer, boolean flag)
    {
        if (!flag)
        {
            MoPubLog.d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
        }
        val$imageView.setImageBitmap(tainer.getBitmap());
    }

    geContainer(ImageView imageview)
    {
        val$imageView = imageview;
        super();
    }
}
