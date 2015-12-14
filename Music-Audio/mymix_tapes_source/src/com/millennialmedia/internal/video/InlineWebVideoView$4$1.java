// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.net.Uri;
import android.widget.ImageView;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class val.response
    implements Runnable
{

    final ss._cls1800 this$1;
    final com.millennialmedia.internal.utils.ss._cls1800 val$response;

    public void run()
    {
label0:
        {
            MMWebView mmwebview = (MMWebView)InlineWebVideoView.access$700(_fld0).get();
            if (mmwebview != null)
            {
                InlineWebVideoView.access$1200(_fld0).setImageBitmap(val$response.ap);
                if (mmwebview.getWidth() - InlineWebVideoView.access$1300(_fld0) < InlineWebVideoView.access$1400(_fld0) || mmwebview.getHeight() - InlineWebVideoView.access$1500(_fld0) < InlineWebVideoView.access$1600(_fld0))
                {
                    break label0;
                }
                InlineWebVideoView.access$1700(_fld0, mmwebview);
            }
            return;
        }
        MMLog.e(InlineWebVideoView.access$1800(), "Cannot attach the inline video; it will not fit within the anchor view.");
    }

    l.uri()
    {
        this$1 = final_uri;
        val$response = com.millennialmedia.internal.utils.val.response.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$4

/* anonymous class */
    class InlineWebVideoView._cls4
        implements Runnable
    {

        final InlineWebVideoView this$0;
        final Uri val$uri;

        public void run()
        {
            com.millennialmedia.internal.utils.HttpUtils.Response response1 = HttpUtils.getBitmapFromGetRequest(uri.toString());
            if (response1 != null && response1.code == 200 && response1.bitmap != null)
            {
                ThreadUtils.runOnUiThread(response1. new InlineWebVideoView._cls4._cls1());
            }
        }

            
            {
                this$0 = final_inlinewebvideoview;
                uri = Uri.this;
                super();
            }
    }

}
