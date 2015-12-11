// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata

private static class 
{

    private final Map kS = new HashMap();
    private final Map kT = new HashMap();
    private final Map kU = new HashMap();

    public int A(String s)
    {
        s = (Integer)kU.get(s);
        if (s != null)
        {
            return s.intValue();
        } else
        {
            return 0;
        }
    }

    public kU a(String s, String s1, int i)
    {
        kS.put(s, s1);
        kT.put(s1, s);
        kU.put(s, Integer.valueOf(i));
        return this;
    }

    public String y(String s)
    {
        return (String)kS.get(s);
    }

    public String z(String s)
    {
        return (String)kT.get(s);
    }

    public ()
    {
    }
}
