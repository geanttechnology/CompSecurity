// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.clientlib.impl.livenessAndTM.PixelFormatType;

// Referenced classes of package jumiomobile:
//            in

class iq
{

    final in a;
    private byte b[];
    private int c;
    private int d;
    private int e;
    private int f;
    private PixelFormatType g;

    public iq(in in1, byte abyte0[], int i, int j, int k, PixelFormatType pixelformattype, int l)
    {
        a = in1;
        super();
        b = in.a(in1, abyte0);
        c = i;
        d = j;
        e = k;
        g = pixelformattype;
        f = l;
    }

    static int a(iq iq1)
    {
        return iq1.e;
    }

    static byte[] b(iq iq1)
    {
        return iq1.b;
    }

    static PixelFormatType c(iq iq1)
    {
        return iq1.g;
    }

    static int d(iq iq1)
    {
        return iq1.c;
    }

    static int e(iq iq1)
    {
        return iq1.d;
    }

    static int f(iq iq1)
    {
        return iq1.f;
    }
}
