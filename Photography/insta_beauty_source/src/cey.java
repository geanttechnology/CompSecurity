// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

class cey
    implements Runnable
{

    final String a;
    final cfb b;
    final cex c;

    cey(cex cex1, String s, cfb cfb)
    {
        c = cex1;
        a = s;
        b = cfb;
        super();
    }

    public void run()
    {
        Error error;
        try
        {
            String s = cex.a(c, a);
            cex.b(c).post(new cez(this, s));
            return;
        }
        catch (Exception exception)
        {
            error = new Error("error");
        }
        cex.b(c).post(new cfa(this, error));
    }
}
