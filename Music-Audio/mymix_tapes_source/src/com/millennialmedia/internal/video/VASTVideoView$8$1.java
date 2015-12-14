// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class 
    implements Runnable
{

    final .content this$1;
    final com.millennialmedia.internal.utils. val$response;

    public void run()
    {
        vastVideoWebView.setContent(val$response.content);
    }

    ()
    {
        this$1 = final_;
        val$response = com.millennialmedia.internal.utils..this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$8

/* anonymous class */
    class VASTVideoView._cls8
        implements Runnable
    {

        final VASTVideoView this$0;
        final String val$uri;
        final VASTVideoView.VASTVideoWebView val$vastVideoWebView;

        public void run()
        {
            com.millennialmedia.internal.utils.HttpUtils.Response response1 = HttpUtils.getContentFromGetRequest(uri);
            if (response1.code == 200 && !Utils.isEmpty(response1.content))
            {
                ThreadUtils.runOnUiThread(response1. new VASTVideoView._cls8._cls1());
            }
        }

            
            {
                this$0 = final_vastvideoview;
                uri = s;
                vastVideoWebView = VASTVideoView.VASTVideoWebView.this;
                super();
            }
    }

}
