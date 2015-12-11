// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.app.Activity;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ag

public class WebViewEmbedJSCallHandler
{

    ag a;

    public WebViewEmbedJSCallHandler(ag ag1)
    {
        a = ag1;
    }

    public void reportProgressTime(int i)
    {
        a.a(i);
    }

    public void videoPlaying()
    {
        a.l = ag.b;
    }

    public void videoStart()
    {
        ((Activity)a.getContext()).runOnUiThread(new Runnable() {

            final WebViewEmbedJSCallHandler a;

            public void run()
            {
                a.a.e();
            }

            
            {
                a = WebViewEmbedJSCallHandler.this;
                super();
            }
        });
    }
}
