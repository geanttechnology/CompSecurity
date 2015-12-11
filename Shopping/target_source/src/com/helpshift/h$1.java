// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            h, l, x

class init>
    implements Runnable
{

    final h a;

    public void run()
    {
        Looper.prepare();
        h.a(a, new Handler() {

            final h._cls1 a;

            public void handleMessage(Message message)
            {
                a.a.runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        h.a(a.a.a, h.a(a.a.a).B());
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = h._cls1.this;
                super();
            }
        });
        (new Runnable() {

            final h._cls1 a;

            public void run()
            {
                try
                {
                    h.a(a.a).c(h.b(a.a), new Handler());
                }
                catch (JSONException jsonexception)
                {
                    x.b("HelpShiftDebug", "get issues", jsonexception);
                }
                h.b(a.a).postDelayed(this, 3000L);
            }

            
            {
                a = h._cls1.this;
                super();
            }
        }).run();
        Looper.loop();
    }

    init>(h h1)
    {
        a = h1;
        super();
    }
}
