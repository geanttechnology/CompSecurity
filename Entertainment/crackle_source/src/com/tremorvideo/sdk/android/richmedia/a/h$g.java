// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.app.Activity;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

class a extends TimerTask
{

    String a;
    final h b;

    public void run()
    {
        b.h.purge();
        b.h.cancel();
        b.h = null;
        b.g.runOnUiThread(new Runnable() {

            final h.g a;

            public void run()
            {
                if (!a.b.d)
                {
                    a.b.loadUrl(a.a);
                }
            }

            
            {
                a = h.g.this;
                super();
            }
        });
    }

    public _cls1.a(h h1, String s)
    {
        b = h1;
        super();
        a = s;
    }
}
