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

    private final Map zzWi = new HashMap();
    private final Map zzWj = new HashMap();
    private final Map zzWk = new HashMap();

    public  zzb(String s, String s1, int i)
    {
        zzWi.put(s, s1);
        zzWj.put(s1, s);
        zzWk.put(s, Integer.valueOf(i));
        return this;
    }

    public String zzbF(String s)
    {
        return (String)zzWi.get(s);
    }

    public String zzbG(String s)
    {
        return (String)zzWj.get(s);
    }

    public int zzbH(String s)
    {
        s = (Integer)zzWk.get(s);
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
