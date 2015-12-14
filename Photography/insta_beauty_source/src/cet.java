// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

class cet
    implements Runnable
{

    final String a;
    final cew b;
    final ces c;

    cet(ces ces1, String s, cew cew)
    {
        c = ces1;
        a = s;
        b = cew;
        super();
    }

    public void run()
    {
        RuntimeException runtimeexception;
        try
        {
            byte abyte0[] = c.a(a);
            ces.a(c).post(new ceu(this, abyte0));
            return;
        }
        catch (Exception exception)
        {
            runtimeexception = new RuntimeException(exception);
        }
        ces.a(c).post(new cev(this, runtimeexception));
    }
}
