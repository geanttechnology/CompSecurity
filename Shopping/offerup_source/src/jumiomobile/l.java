// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.PixelFormat;
import java.io.Serializable;

// Referenced classes of package jumiomobile:
//            n

public class l
    implements Serializable
{

    public n a;
    public n b;
    public n c;
    public boolean d;
    public int e;
    public int f;

    public l()
    {
        f = 17;
    }

    public l a()
    {
        l l1 = new l();
        l1.a = a.a();
        l1.b = b.a();
        l1.c = c.a();
        l1.d = d;
        l1.e = e;
        return l1;
    }

    public float b()
    {
        return (float)a.a / (float)c.a;
    }

    public float c()
    {
        PixelFormat pixelformat = new PixelFormat();
        PixelFormat.getPixelFormatInfo(f, pixelformat);
        return (float)pixelformat.bitsPerPixel / 8F;
    }
}
