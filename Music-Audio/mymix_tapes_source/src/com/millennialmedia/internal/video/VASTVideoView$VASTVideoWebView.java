// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.content.Context;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView, MMVideoView

public class lastUpdateTime extends MMWebView
{

    volatile int lastUpdateTime;
    final VASTVideoView this$0;
    int updateTimeInterval;

    public void close()
    {
        VASTVideoView.access$400(VASTVideoView.this);
    }

    public void pause()
    {
        if (VASTVideoView.access$200(VASTVideoView.this) != 2)
        {
            VASTVideoView.access$300(VASTVideoView.this).pause();
        }
    }

    public void play()
    {
        if (VASTVideoView.access$200(VASTVideoView.this) != 2)
        {
            VASTVideoView.access$300(VASTVideoView.this).start();
        }
    }

    public void restart()
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            final VASTVideoView.VASTVideoWebView this$1;

            public void run()
            {
                VASTVideoView.access$800(this$0);
            }

            
            {
                this$1 = VASTVideoView.VASTVideoWebView.this;
                super();
            }
        });
    }

    public void seek(int i)
    {
        if (VASTVideoView.access$200(VASTVideoView.this) != 2)
        {
            VASTVideoView.access$300(VASTVideoView.this).seekTo(i);
        }
    }

    public void setTimeInterval(int i)
    {
        updateTimeInterval = i;
    }

    public void skip()
    {
        if (VASTVideoView.access$200(VASTVideoView.this) != 2)
        {
            VASTVideoView.access$502(VASTVideoView.this, true);
            ThreadUtils.runOnUiThread(new Runnable() {

                final VASTVideoView.VASTVideoWebView this$1;

                public void run()
                {
                    VASTVideoView.access$600(this$0);
                    VASTVideoView.access$700(this$0);
                }

            
            {
                this$1 = VASTVideoView.VASTVideoWebView.this;
                super();
            }
            });
        }
    }

    public void triggerTimeUpdate()
    {
        callJavascript("MmJsBridge.vast.setCurrentTime", new Object[] {
            Integer.valueOf(VASTVideoView.access$300(VASTVideoView.this).getCurrentPosition())
        });
    }

    void updateTime(int i)
    {
        if (updateTimeInterval != -1 && (lastUpdateTime == 0 || lastUpdateTime + updateTimeInterval <= i))
        {
            lastUpdateTime = i;
            callJavascript("MmJsBridge.vast.setCurrentTime", new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    _cls2.this._cls1(Context context, boolean flag, com.millennialmedia.internal.bView bview)
    {
        this$0 = VASTVideoView.this;
        super(context, true, flag, bview);
        updateTimeInterval = -1;
        lastUpdateTime = 0;
    }
}
