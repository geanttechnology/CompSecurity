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

class val.uri
    implements Runnable
{

    final InlineWebVideoView this$0;
    final Uri val$uri;

    public void run()
    {
        final com.millennialmedia.internal.utils.val.uri response = HttpUtils.getBitmapFromGetRequest(val$uri.toString());
        if (response != null && response.de == 200 && response.tmap != null)
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final InlineWebVideoView._cls4 this$1;
                final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                public void run()
                {
label0:
                    {
                        MMWebView mmwebview = (MMWebView)InlineWebVideoView.access$700(this$0).get();
                        if (mmwebview != null)
                        {
                            InlineWebVideoView.access$1200(this$0).setImageBitmap(response.bitmap);
                            if (mmwebview.getWidth() - InlineWebVideoView.access$1300(this$0) < InlineWebVideoView.access$1400(this$0) || mmwebview.getHeight() - InlineWebVideoView.access$1500(this$0) < InlineWebVideoView.access$1600(this$0))
                            {
                                break label0;
                            }
                            InlineWebVideoView.access$1700(this$0, mmwebview);
                        }
                        return;
                    }
                    MMLog.e(InlineWebVideoView.access$1800(), "Cannot attach the inline video; it will not fit within the anchor view.");
                }

            
            {
                this$1 = InlineWebVideoView._cls4.this;
                response = response1;
                super();
            }
            });
        }
    }

    _cls1.val.response()
    {
        this$0 = final_inlinewebvideoview;
        val$uri = Uri.this;
        super();
    }
}
