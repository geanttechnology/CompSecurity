// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class this._cls1
    implements Runnable
{

    final _cls1.val.response this$1;

    public void run()
    {
        final com.millennialmedia.internal.utils.this._cls1 response = HttpUtils.getBitmapFromGetRequest(tton.urce.i);
        if (response != null && response.i == 200)
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final VASTVideoView.ImageButton._cls2 this$2;
                final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                public void run()
                {
                    setImageBitmap(response.bitmap);
                }

            
            {
                this$2 = VASTVideoView.ImageButton._cls2.this;
                response = response1;
                super();
            }
            });
        }
    }

    _cls1.val.response()
    {
        this$1 = this._cls1.this;
        super();
    }
}
