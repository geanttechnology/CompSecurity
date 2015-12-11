// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.c;

import android.graphics.Color;
import android.support.v4.b.a;
import java.util.Arrays;

// Referenced classes of package android.support.v7.c:
//            c

public static final class b
{

    public final int a;
    final int b;
    private final int c;
    private final int d;
    private final int e;
    private boolean f;
    private int g;
    private int h;
    private float i[];

    private void b()
    {
        int j;
        int k;
label0:
        {
            if (!f)
            {
                j = android.support.v4.b.a.a(-1, a, 4.5F);
                k = android.support.v4.b.a.a(-1, a, 3F);
                if (j == -1 || k == -1)
                {
                    break label0;
                }
                h = android.support.v4.b.a.b(-1, j);
                g = android.support.v4.b.a.b(-1, k);
                f = true;
            }
            return;
        }
        int i1 = android.support.v4.b.a.a(0xff000000, a, 4.5F);
        int l = android.support.v4.b.a.a(0xff000000, a, 3F);
        if (i1 != -1 && i1 != -1)
        {
            h = android.support.v4.b.a.b(0xff000000, i1);
            g = android.support.v4.b.a.b(0xff000000, l);
            f = true;
            return;
        }
        if (j != -1)
        {
            j = android.support.v4.b.a.b(-1, j);
        } else
        {
            j = android.support.v4.b.a.b(0xff000000, i1);
        }
        h = j;
        if (k != -1)
        {
            j = android.support.v4.b.a.b(-1, k);
        } else
        {
            j = android.support.v4.b.a.b(0xff000000, l);
        }
        g = j;
        f = true;
    }

    public final float[] a()
    {
        if (i == null)
        {
            i = new float[3];
            android.support.v4.b.a.a(c, d, e, i);
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = ()obj;
            if (b != ((b) (obj)).b || a != ((a) (obj)).a)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return a * 31 + b;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder(getClass().getSimpleName())).append(" [RGB: #").append(Integer.toHexString(a)).append(']').append(" [HSL: ").append(Arrays.toString(a())).append(']').append(" [Population: ").append(b).append(']').append(" [Title Text: #");
        b();
        stringbuilder = stringbuilder.append(Integer.toHexString(g)).append(']').append(" [Body Text: #");
        b();
        return stringbuilder.append(Integer.toHexString(h)).append(']').toString();
    }

    public (int j, int k)
    {
        c = Color.red(j);
        d = Color.green(j);
        e = Color.blue(j);
        a = j;
        b = k;
    }
}
