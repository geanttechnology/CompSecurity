// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.a;

import android.app.Activity;
import android.webkit.WebView;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.a:
//            b

class a extends TimerTask
{

    String a;
    final b b;

    public void run()
    {
        b.e.purge();
        b.e.cancel();
        b.e = null;
        com.tremorvideo.sdk.android.a.b.b(b).runOnUiThread(new Runnable() {

            final b.a a;

            public void run()
            {
                com.tremorvideo.sdk.android.a.b.c(a.b).loadUrl(a.a);
            }

            
            {
                a = b.a.this;
                super();
            }
        });
    }

    public _cls1.a(b b1, String s)
    {
        b = b1;
        super();
        a = s;
    }
}
