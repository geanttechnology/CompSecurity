// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package a.a:
//            ds, en, ac, cq, 
//            cr, aa

public final class ag extends BroadcastReceiver
{

    private aa a;
    private String b;
    private ac c;

    public ag(Context context, aa aa1)
    {
        a = aa1;
        context = new ds(context);
        b = context.b();
        c = context.a();
    }

    public final void onReceive(Context context, Intent intent)
    {
        (new StringBuilder("CrittercismReceiver: INTENT ACTION = ")).append(intent.getAction());
        en.b();
        context = new ds(context);
        intent = context.a();
        if (c != intent && intent != ac.c)
        {
            if (intent == ac.d)
            {
                a.a(new cq(cr.b));
            } else
            if (c == ac.d || c == ac.c)
            {
                a.a(new cq(cr.a));
            }
            c = intent;
        }
        context = context.b();
        if (!context.equals(b))
        {
            if (b.equals("unknown") || b.equals("disconnected"))
            {
                if (!context.equals("unknown") && !context.equals("disconnected"))
                {
                    a.a(new cq(cr.c, context));
                }
            } else
            if (context.equals("disconnected"))
            {
                a.a(new cq(cr.d, b));
            } else
            if (!context.equals("unknown"))
            {
                a.a(new cq(cr.e, b, context));
            }
            b = context;
        }
    }
}
