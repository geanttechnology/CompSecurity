// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import java.math.BigDecimal;

public final class hp
{

    public final ComponentName a;
    public final long b;
    public final float c;

    public hp(ComponentName componentname, long l, float f)
    {
        a = componentname;
        b = l;
        c = f;
    }

    public hp(String s, long l, float f)
    {
        this(ComponentName.unflattenFromString(s), l, f);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (hp)obj;
            if (a == null)
            {
                if (((hp) (obj)).a != null)
                {
                    return false;
                }
            } else
            if (!a.equals(((hp) (obj)).a))
            {
                return false;
            }
            if (b != ((hp) (obj)).b)
            {
                return false;
            }
            if (Float.floatToIntBits(c) != Float.floatToIntBits(((hp) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        return ((i + 31) * 31 + (int)(b ^ b >>> 32)) * 31 + Float.floatToIntBits(c);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        stringbuilder.append("; activity:").append(a);
        stringbuilder.append("; time:").append(b);
        stringbuilder.append("; weight:").append(new BigDecimal(c));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
