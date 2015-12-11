// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Arrays;

// Referenced classes of package jumiomobile:
//            ig, ii, ao, q

class ih extends Thread
{

    final ig a;
    private byte b[];

    public ih(ig ig1, byte abyte0[])
    {
        a = ig1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
    }

    public void run()
    {
        a.d.a(0.0F);
        a.d.c(false);
        android.graphics.Bitmap bitmap = q.a(b, a.c.f(), a.b, true, 1000);
        a.d.a(bitmap, bitmap, true);
        a.d.c();
        b = null;
        System.gc();
    }
}
