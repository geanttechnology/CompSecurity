// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import nativead.WebBrowerActivity;

class cek
    implements Runnable
{

    final String a;
    final String b;
    final String c;
    final String d;
    final String e;
    final cej f;

    cek(cej cej1, String s, String s1, String s2, String s3, String s4)
    {
        f = cej1;
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        super();
    }

    public void run()
    {
        try
        {
            f.a(a, b, c, d, e);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        f.b.runOnUiThread(new cel(this));
    }
}
