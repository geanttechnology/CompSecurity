// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoCloseButtonWidget

class val.imageUrl
    implements com.mopub.volley.toolbox.mageUrl
{

    final VastVideoCloseButtonWidget this$0;
    final String val$imageUrl;

    public void onErrorResponse(VolleyError volleyerror)
    {
        MoPubLog.d("Failed to load image.", volleyerror);
    }

    public void onResponse(com.mopub.volley.toolbox.mageUrl mageurl, boolean flag)
    {
        mageurl = mageurl.tBitmap();
        if (mageurl != null)
        {
            VastVideoCloseButtonWidget.access$000(VastVideoCloseButtonWidget.this).setImageBitmap(mageurl);
            return;
        } else
        {
            MoPubLog.d(String.format("%s returned null bitmap", new Object[] {
                val$imageUrl
            }));
            return;
        }
    }

    er()
    {
        this$0 = final_vastvideoclosebuttonwidget;
        val$imageUrl = String.this;
        super();
    }
}
