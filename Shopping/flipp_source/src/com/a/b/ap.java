// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import android.net.Uri;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.a.b:
//            ao

public final class ap
{

    int a;
    public Bitmap b;
    public byte c[];
    public int d;
    public AtomicInteger e;
    private Uri f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private List o;

    ap(Uri uri)
    {
        f = uri;
        g = 0;
    }

    public final ap a(int i1, int j1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("Width must be positive number.");
        }
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("Height must be positive number.");
        } else
        {
            a = i1;
            h = j1;
            return this;
        }
    }

    public final boolean a()
    {
        return f != null || g != 0;
    }

    public final ao b()
    {
        if (j && i)
        {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        }
        if (i && a == 0)
        {
            throw new IllegalStateException("Center crop requires calling resize.");
        }
        if (j && a == 0)
        {
            throw new IllegalStateException("Center inside requires calling resize.");
        } else
        {
            return new ao(f, g, o, a, h, i, j, k, l, m, n, b, c, d, e, (byte)0);
        }
    }
}
