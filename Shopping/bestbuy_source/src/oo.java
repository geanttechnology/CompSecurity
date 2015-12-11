// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ay;

public final class oo
{

    public static final oo a = new oo(320, 50, "320x50_mb");
    public static final oo b = new oo(468, 60, "468x60_as");
    public static final oo c = new oo(320, 100, "320x100_as");
    public static final oo d = new oo(728, 90, "728x90_as");
    public static final oo e = new oo(300, 250, "300x250_as");
    public static final oo f = new oo(160, 600, "160x600_as");
    public static final oo g = new oo(-1, -2, "smart_banner");
    private final int h;
    private final int i;
    private final String j;

    public oo(int k, int l)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (k == -1)
        {
            s = "FULL";
        } else
        {
            s = String.valueOf(k);
        }
        stringbuilder = stringbuilder.append(s).append("x");
        if (l == -2)
        {
            s = "AUTO";
        } else
        {
            s = String.valueOf(l);
        }
        this(k, l, stringbuilder.append(s).append("_as").toString());
    }

    oo(int k, int l, String s)
    {
        if (k < 0 && k != -1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid width for AdSize: ").append(k).toString());
        }
        if (l < 0 && l != -2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid height for AdSize: ").append(l).toString());
        } else
        {
            h = k;
            i = l;
            j = s;
            return;
        }
    }

    public int a()
    {
        return i;
    }

    public int a(Context context)
    {
        if (i == -2)
        {
            return ay.b(context.getResources().getDisplayMetrics());
        } else
        {
            return aca.a(context, i);
        }
    }

    public int b()
    {
        return h;
    }

    public int b(Context context)
    {
        if (h == -1)
        {
            return ay.a(context.getResources().getDisplayMetrics());
        } else
        {
            return aca.a(context, h);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof oo))
            {
                return false;
            }
            obj = (oo)obj;
            if (h != ((oo) (obj)).h || i != ((oo) (obj)).i || !j.equals(((oo) (obj)).j))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return j.hashCode();
    }

    public String toString()
    {
        return j;
    }

}
