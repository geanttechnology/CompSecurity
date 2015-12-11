// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class hm
    implements Comparable
{

    public final ResolveInfo a;
    public float b;

    public final int compareTo(Object obj)
    {
        return Float.floatToIntBits(((hm)obj).b) - Float.floatToIntBits(b);
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
            obj = (hm)obj;
            if (Float.floatToIntBits(b) != Float.floatToIntBits(((hm) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Float.floatToIntBits(b) + 31;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        stringbuilder.append("resolveInfo:").append(a.toString());
        stringbuilder.append("; weight:").append(new BigDecimal(b));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
