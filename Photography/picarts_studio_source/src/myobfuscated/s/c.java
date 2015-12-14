// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import android.graphics.Bitmap;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.s:
//            r, e, k

final class c
    implements r
{

    private final e a = new e();
    private final k b = new k();

    c()
    {
    }

    static String c(int i, int l, android.graphics.Bitmap.Config config)
    {
        return (new StringBuilder("[")).append(i).append("x").append(l).append("], ").append(config).toString();
    }

    public final Bitmap a()
    {
        return (Bitmap)b.a();
    }

    public final Bitmap a(int i, int l, android.graphics.Bitmap.Config config)
    {
        config = a.a(i, l, config);
        return (Bitmap)b.a(config);
    }

    public final void a(Bitmap bitmap)
    {
        d d = a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        b.a(d, bitmap);
    }

    public final String b(int i, int l, android.graphics.Bitmap.Config config)
    {
        return c(i, l, config);
    }

    public final String b(Bitmap bitmap)
    {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public final int c(Bitmap bitmap)
    {
        return j.a(bitmap);
    }

    public final String toString()
    {
        return (new StringBuilder("AttributeStrategy:\n  ")).append(b).toString();
    }
}
