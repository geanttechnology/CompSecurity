// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import java.util.UUID;

class aqs
    implements Runnable
{

    final String a;
    final Context b;
    final String c;
    final aqu d;
    final aqr e;

    aqs(aqr aqr1, String s, Context context, String s1, aqu aqu1)
    {
        e = aqr1;
        a = s;
        b = context;
        c = s1;
        d = aqu1;
        super();
    }

    public void run()
    {
        String s;
        s = UUID.randomUUID().toString();
        s = (new StringBuilder()).append(aqr.a()).append(s).toString();
        e.a(a, s);
        aqx.a(b, aqr.b, c, s);
        aqr.a(e).post(new aqt(this, s));
_L1:
        return;
        Exception exception;
        exception;
        if (d != null)
        {
            d.a(exception);
            return;
        }
          goto _L1
    }
}
