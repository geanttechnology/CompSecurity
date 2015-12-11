// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Arrays;

// Referenced classes of package jumiomobile:
//            iu, ii

class iw extends Thread
{

    final iu a;
    private byte b[];

    public iw(iu iu1, byte abyte0[])
    {
        a = iu1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
    }

    public void run()
    {
        a.d.a(0.0F);
        a.d.c(false);
        a.d.a(b);
        a.d.c();
        b = null;
        System.gc();
    }
}
