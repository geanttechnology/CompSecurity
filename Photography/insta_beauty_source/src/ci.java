// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ci
    implements Comparable
{

    public final ResolveInfo a;
    public float b;
    final cg c;

    public ci(cg cg, ResolveInfo resolveinfo)
    {
        c = cg;
        super();
        a = resolveinfo;
    }

    public int a(ci ci1)
    {
        return Float.floatToIntBits(ci1.b) - Float.floatToIntBits(b);
    }

    public int compareTo(Object obj)
    {
        return a((ci)obj);
    }

    public boolean equals(Object obj)
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
            obj = (ci)obj;
            if (Float.floatToIntBits(b) != Float.floatToIntBits(((ci) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Float.floatToIntBits(b) + 31;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        stringbuilder.append("resolveInfo:").append(a.toString());
        stringbuilder.append("; weight:").append(new BigDecimal(b));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
