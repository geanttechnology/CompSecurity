// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.m;
import java.io.Serializable;
import java.util.Locale;

// Referenced classes of package com.mopub.mobileads:
//            ae

public final class z extends ae
    implements Serializable, Comparable
{

    private final float d;

    public z(String s, float f)
    {
        super(s);
        boolean flag;
        if (f >= 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m.a(flag);
        d = f;
    }

    public final int a(z z1)
    {
        float f = z1.d;
        return Double.compare(d, f);
    }

    public final int compareTo(Object obj)
    {
        return a((z)obj);
    }

    public final String toString()
    {
        return String.format(Locale.US, "%2f: %s", new Object[] {
            Float.valueOf(d), a
        });
    }
}
