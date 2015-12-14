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

    private final Map zzUr = new HashMap();
    private final Map zzUs = new HashMap();
    private final Map zzUt = new HashMap();

    public  zzb(String s, String s1, int i)
    {
        zzUr.put(s, s1);
        zzUs.put(s1, s);
        zzUt.put(s, Integer.valueOf(i));
        return this;
    }

    public String zzbE(String s)
    {
        return (String)zzUr.get(s);
    }

    public String zzbF(String s)
    {
        return (String)zzUs.get(s);
    }

    public int zzbG(String s)
    {
        s = (Integer)zzUt.get(s);
        if (s != null)
        {
            return s.intValue();
        } else
        {
            return 0;
        }
    }

    public ()
    {
    }
}
