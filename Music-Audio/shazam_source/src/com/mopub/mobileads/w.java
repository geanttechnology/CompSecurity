// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.m;
import java.io.Serializable;
import java.util.Locale;

// Referenced classes of package com.mopub.mobileads:
//            ae

public final class w extends ae
    implements Serializable, Comparable
{

    private final int d;

    public w(String s, int i)
    {
        super(s);
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m.a(flag);
        d = i;
    }

    public final int a(w w1)
    {
        int i = w1.d;
        return d - i;
    }

    public final int compareTo(Object obj)
    {
        return a((w)obj);
    }

    public final String toString()
    {
        return String.format(Locale.US, "%dms: %s", new Object[] {
            Integer.valueOf(d), a
        });
    }
}
