// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.internal:
//            zze, zzx

class zzafg extends zze
{

    List zzafg;

    public zze zza(zze zze1)
    {
        ArrayList arraylist = new ArrayList(zzafg);
        arraylist.add(zzx.zzw(zze1));
        return new <init>(arraylist);
    }

    public boolean zzd(char c)
    {
        for (Iterator iterator = zzafg.iterator(); iterator.hasNext();)
        {
            if (((zze)iterator.next()).zzd(c))
            {
                return true;
            }
        }

        return false;
    }

    (List list)
    {
        zzafg = list;
    }
}
