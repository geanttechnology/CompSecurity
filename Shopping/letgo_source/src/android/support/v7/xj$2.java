// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            xj

class b
    implements Runnable
{

    final String a;
    final byte b[];
    final xj c;

    public void run()
    {
        c.b(a, b);
    }

    (xj xj1, String s, byte abyte0[])
    {
        c = xj1;
        a = s;
        b = abyte0;
        super();
    }
}
