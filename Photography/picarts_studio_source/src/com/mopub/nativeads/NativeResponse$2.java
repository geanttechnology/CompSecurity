// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.nativeads:
//            NativeResponse

class val.imageView
    implements com.mopub.volley.toolbox.Listener
{

    final NativeResponse this$0;
    final ImageView val$imageView;

    public void onErrorResponse(VolleyError volleyerror)
    {
        MoPubLog.d("Failed to load image.", volleyerror);
        val$imageView.setImageDrawable(null);
    }

    public void onResponse(com.mopub.volley.toolbox.Container container, boolean flag)
    {
        if (!flag)
        {
            MoPubLog.d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
        }
        val$imageView.setImageBitmap(container.getBitmap());
    }

    ImageContainer()
    {
        this$0 = final_nativeresponse;
        val$imageView = ImageView.this;
        super();
    }
}
