// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzdt, zzdv, zziz

public class zzdu
    implements Iterable
{

    private final List zzyb = new LinkedList();

    public zzdu()
    {
    }

    private zzdt zzc(zziz zziz)
    {
        for (Iterator iterator1 = zzp.zzbI().iterator(); iterator1.hasNext();)
        {
            zzdt zzdt1 = (zzdt)iterator1.next();
            if (zzdt1.zzoM == zziz)
            {
                return zzdt1;
            }
        }

        return null;
    }

    public Iterator iterator()
    {
        return zzyb.iterator();
    }

    public void zza(zzdt zzdt1)
    {
        zzyb.add(zzdt1);
    }

    public boolean zza(zziz zziz)
    {
        zziz = zzc(zziz);
        if (zziz != null)
        {
            ((zzdt) (zziz)).zzxY.abort();
            return true;
        } else
        {
            return false;
        }
    }

    public void zzb(zzdt zzdt1)
    {
        zzyb.remove(zzdt1);
    }

    public boolean zzb(zziz zziz)
    {
        return zzc(zziz) != null;
    }
}
