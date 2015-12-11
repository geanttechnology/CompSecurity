// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            aij, aiu, ait, aix, 
//            ajj

public class aje
{

    private final String a;
    private final String b;
    private final String c;
    private final aiu d;
    private final ait e;
    private final aix f;
    private final ajj g;
    private final Object h;
    private final boolean i;
    private final android.graphics.BitmapFactory.Options j = new android.graphics.BitmapFactory.Options();

    public aje(String s, String s1, String s2, aiu aiu, aix aix, ajj ajj, aij aij1)
    {
        a = s;
        b = s1;
        c = s2;
        d = aiu;
        e = aij1.j();
        f = aix;
        g = ajj;
        h = aij1.n();
        i = aij1.m();
        a(aij1.k(), j);
    }

    private void a(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inDensity = options.inDensity;
        options1.inDither = options.inDither;
        options1.inInputShareable = options.inInputShareable;
        options1.inJustDecodeBounds = options.inJustDecodeBounds;
        options1.inPreferredConfig = options.inPreferredConfig;
        options1.inPurgeable = options.inPurgeable;
        options1.inSampleSize = options.inSampleSize;
        options1.inScaled = options.inScaled;
        options1.inScreenDensity = options.inScreenDensity;
        options1.inTargetDensity = options.inTargetDensity;
        options1.inTempStorage = options.inTempStorage;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            b(options, options1);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c(options, options1);
        }
    }

    private void b(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    private void c(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inBitmap = options.inBitmap;
        options1.inMutable = options.inMutable;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public aiu c()
    {
        return d;
    }

    public ait d()
    {
        return e;
    }

    public aix e()
    {
        return f;
    }

    public ajj f()
    {
        return g;
    }

    public Object g()
    {
        return h;
    }

    public boolean h()
    {
        return i;
    }

    public android.graphics.BitmapFactory.Options i()
    {
        return j;
    }
}
