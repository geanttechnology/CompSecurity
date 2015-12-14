// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class STVideoWebView
    implements Runnable
{

    final VASTVideoView this$0;
    final String val$uri;
    final STVideoWebView val$vastVideoWebView;

    public void run()
    {
        final com.millennialmedia.internal.utils.se response = HttpUtils.getContentFromGetRequest(val$uri);
        if (response.code == 200 && !Utils.isEmpty(response.content))
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final VASTVideoView._cls8 this$1;
                final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                public void run()
                {
                    vastVideoWebView.setContent(response.content);
                }

            
            {
                this$1 = VASTVideoView._cls8.this;
                response = response1;
                super();
            }
            });
        }
    }

    STVideoWebView()
    {
        this$0 = final_vastvideoview;
        val$uri = s;
        val$vastVideoWebView = STVideoWebView.this;
        super();
    }
}
