// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzck, zzci, zzcp

class zzaYK
    implements a
{

    final zzcp zzaYG;
    final Map zzaYH;
    final Map zzaYI;
    final Map zzaYJ;
    final Map zzaYK;

    public void zza(com.google.android.gms.internal.e e, Set set, Set set1, zzck zzck1)
    {
        List list = (List)zzaYH.get(e);
        List list1 = (List)zzaYI.get(e);
        if (list != null)
        {
            set.addAll(list);
            zzck1.zzDb().zzc(list, list1);
        }
        set = (List)zzaYJ.get(e);
        e = (List)zzaYK.get(e);
        if (set != null)
        {
            set1.addAll(set);
            zzck1.zzDc().zzc(set, e);
        }
    }

    a(zzcp zzcp, Map map, Map map1, Map map2, Map map3)
    {
        zzaYG = zzcp;
        zzaYH = map;
        zzaYI = map1;
        zzaYJ = map2;
        zzaYK = map3;
        super();
    }
}
