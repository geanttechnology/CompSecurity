// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.support.v7.agt;
import android.support.v7.agv;
import android.support.v7.agx;
import android.util.Log;
import java.util.TimerTask;

// Referenced classes of package com.kahuna.sdk:
//            p, m

private class d extends TimerTask
{

    final p a;
    private String b;
    private String c;
    private boolean d;

    public void run()
    {
        agx agx1;
        agx1 = new agx();
        agx1.a("key", b);
        agx1.a("dev_id", c);
        String s;
        if (d)
        {
            s = "s";
        } else
        {
            s = "p";
        }
        try
        {
            agx1.a("env", s);
            long l = System.currentTimeMillis() / 1000L;
            agx1.a("monitoring_key", (new StringBuilder()).append(l + 0x15180L).append("kah").toString());
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Sending monitor request: ").append(agx1).toString());
            }
            p.a(a).a("https://tap-nexus.appspot.com/monitor_device", agx1, new agv() {

                final p.b a;

                public void a(String s1)
                {
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Successfully sent monitor request: ").append(s1).toString());
                    }
                }

                public void a(Throwable throwable, String s1)
                {
                    super.a(throwable, s1);
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Failed to send monitor request: ").append(s1).toString(), throwable);
                    }
                }

            
            {
                a = p.b.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Send Monitor Request Task handler: ").append(exception).toString());
            }
        }
        return;
    }

    public agv(p p1, String s, String s1, boolean flag)
    {
        a = p1;
        super();
        b = s;
        c = s1;
        d = flag;
    }
}
