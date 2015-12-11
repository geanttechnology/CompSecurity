// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class this._cls0
    implements android.view.er
{

    final VideoActivity this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
label0:
        {
label1:
            {
                if (keyevent.getAction() != 0 || i != 4 || !VideoActivity.access$5(VideoActivity.this).canGoBack())
                {
                    break label0;
                }
                VideoActivity.access$5(VideoActivity.this).goBack();
                if (VideoActivity.access$5(VideoActivity.this).getUrl().contains("//m.youtube.com"))
                {
                    if (!VideoActivity.access$5(VideoActivity.this).getUrl().contains("v="))
                    {
                        break label1;
                    }
                    view = new Message();
                    view.what = 1;
                    hander.sendMessage(view);
                }
                return true;
            }
            view = new Message();
            view.what = 2;
            hander.sendMessage(view);
            return true;
        }
        return false;
    }

    ()
    {
        this$0 = VideoActivity.this;
        super();
    }
}
