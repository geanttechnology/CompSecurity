// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.net.Uri;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMWebView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView, MMVideoView

class this._cls0
    implements Runnable
{

    final InlineWebVideoView this$0;

    public void run()
    {
label0:
        {
            MMWebView mmwebview = (MMWebView)InlineWebVideoView.access$700(InlineWebVideoView.this).get();
            if (mmwebview != null)
            {
                mmwebview.invokeCallback(InlineWebVideoView.access$800(InlineWebVideoView.this), new Object[] {
                    getTag(), "stateChange", "loading"
                });
                mmwebview.invokeCallback(InlineWebVideoView.access$800(InlineWebVideoView.this), new Object[] {
                    getTag(), "updateVideoURL", InlineWebVideoView.access$2000(InlineWebVideoView.this).toString()
                });
                mmwebview.invokeCallback(InlineWebVideoView.access$800(InlineWebVideoView.this), new Object[] {
                    getTag(), "durationChange", Integer.valueOf(InlineWebVideoView.access$600(InlineWebVideoView.this).getDuration())
                });
                if (mmwebview.getWidth() - InlineWebVideoView.access$1300(InlineWebVideoView.this) < InlineWebVideoView.access$1400(InlineWebVideoView.this) || mmwebview.getHeight() - InlineWebVideoView.access$1500(InlineWebVideoView.this) < InlineWebVideoView.access$1600(InlineWebVideoView.this))
                {
                    break label0;
                }
                InlineWebVideoView.access$1700(InlineWebVideoView.this, mmwebview);
            }
            return;
        }
        MMLog.e(InlineWebVideoView.access$1800(), "Cannot attach the inline video; it will not fit within the anchor view.");
    }

    ()
    {
        this$0 = InlineWebVideoView.this;
        super();
    }
}
