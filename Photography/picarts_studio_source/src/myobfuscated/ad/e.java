// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bumptech.glide.request.b;
import java.util.Iterator;
import java.util.List;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.ad:
//            h, c, n

public final class e
    implements h
{

    final c a;
    boolean b;
    private final Context c;
    private boolean d;
    private final BroadcastReceiver e = new BroadcastReceiver() {

        private e a;

        public final void onReceive(Context context1, Intent intent)
        {
            boolean flag = a.b;
            a.b = e.a(context1);
            if (flag != a.b)
            {
                context1 = a.a;
                if (a.b)
                {
                    context1 = ((c) (context1)).a;
                    intent = j.a(((n) (context1)).a).iterator();
                    do
                    {
                        if (!intent.hasNext())
                        {
                            break;
                        }
                        b b1 = (b)intent.next();
                        if (!b1.f() && !b1.h())
                        {
                            b1.c();
                            if (!((n) (context1)).c)
                            {
                                b1.a();
                            } else
                            {
                                ((n) (context1)).b.add(b1);
                            }
                        }
                    } while (true);
                }
            }
        }

            
            {
                a = e.this;
                super();
            }
    };

    public e(Context context, c c1)
    {
        c = context.getApplicationContext();
        a = c1;
    }

    static boolean a(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public final void d()
    {
        if (!d)
        {
            b = a(c);
            c.registerReceiver(e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            d = true;
        }
    }

    public final void e()
    {
        if (d)
        {
            c.unregisterReceiver(e);
            d = false;
        }
    }

    public final void f()
    {
    }
}
