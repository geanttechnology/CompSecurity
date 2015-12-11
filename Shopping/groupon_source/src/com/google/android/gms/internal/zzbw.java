// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzbv, zzbs

public class zzbw
{

    private final Collection zztA = new ArrayList();
    private final Collection zzty = new ArrayList();
    private final Collection zztz = new ArrayList();

    public zzbw()
    {
    }

    public void zza(zzbs zzbs)
    {
        zzty.add(zzbs);
    }

    public void zza(zzbv zzbv1)
    {
        zztz.add(zzbv1);
    }

    public void zzb(zzbv zzbv1)
    {
        zztA.add(zzbv1);
    }

    public List zzdb()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zztz.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)((zzbv)iterator.next()).get();
            if (s != null)
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }
}
