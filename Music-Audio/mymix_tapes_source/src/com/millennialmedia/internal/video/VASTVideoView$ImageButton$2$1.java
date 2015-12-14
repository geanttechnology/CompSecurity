// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class val.response
    implements Runnable
{

    final val.response this$2;
    final com.millennialmedia.internal.utils.val.response val$response;

    public void run()
    {
        mageBitmap(val$response.response);
    }

    is._cls1()
    {
        this$2 = final__pcls1;
        val$response = com.millennialmedia.internal.utils.val.response.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$ImageButton$2

/* anonymous class */
    class VASTVideoView.ImageButton._cls2
        implements Runnable
    {

        final VASTVideoView.ImageButton this$1;

        public void run()
        {
            com.millennialmedia.internal.utils.HttpUtils.Response response1 = HttpUtils.getBitmapFromGetRequest(button.staticResource.uri);
            if (response1 != null && response1.code == 200)
            {
                ThreadUtils.runOnUiThread(response1. new VASTVideoView.ImageButton._cls2._cls1());
            }
        }

            
            {
                this$1 = VASTVideoView.ImageButton.this;
                super();
            }
    }

}
