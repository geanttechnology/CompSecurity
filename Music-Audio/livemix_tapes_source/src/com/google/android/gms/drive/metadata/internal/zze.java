// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzl

public final class zze
{

    private static final Map zzakl = new HashMap();

    public static void zzb(DataHolder dataholder)
    {
        zzmb.zzakQ.zzd(dataholder);
    }

    private static void zzb(MetadataField metadatafield)
    {
        if (zzakl.containsKey(metadatafield.getName()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate field name registered: ").append(metadatafield.getName()).toString());
        } else
        {
            zzakl.put(metadatafield.getName(), metadatafield);
            return;
        }
    }

    public static MetadataField zzcG(String s)
    {
        return (MetadataField)zzakl.get(s);
    }

    public static Collection zzra()
    {
        return Collections.unmodifiableCollection(zzakl.values());
    }

    static 
    {
        zzb(zzmb.zzako);
        zzb(zzmb.zzakU);
        zzb(zzmb.zzakL);
        zzb(zzmb.zzakS);
        zzb(zzmb.zzakV);
        zzb(zzmb.zzakB);
        zzb(zzmb.zzakA);
        zzb(zzmb.zzakC);
        zzb(zzmb.zzakD);
        zzb(zzmb.zzakE);
        zzb(zzmb.zzaky);
        zzb(zzmb.zzakG);
        zzb(zzmb.zzakH);
        zzb(zzmb.zzakI);
        zzb(zzmb.zzakQ);
        zzb(zzmb.zzakp);
        zzb(zzmb.zzakN);
        zzb(zzmb.zzakr);
        zzb(zzmb.zzakz);
        zzb(zzmb.zzaks);
        zzb(zzmb.zzakt);
        zzb(zzmb.zzaku);
        zzb(zzmb.zzakv);
        zzb(zzmb.zzakK);
        zzb(zzmb.zzakF);
        zzb(zzmb.zzakM);
        zzb(zzmb.zzakO);
        zzb(zzmb.zzakP);
        zzb(zzmb.zzakR);
        zzb(zzmb.zzakW);
        zzb(zzmb.zzakX);
        zzb(zzmb.zzakx);
        zzb(zzmb.zzakw);
        zzb(zzmb.zzakT);
        zzb(zzmb.zzakJ);
        zzb(zzmb.zzakq);
        zzb(zzmb.zzakY);
        zzb(zzmb.zzakZ);
        zzb(zzmb.zzala);
        zzb(zzmb.zzalb);
        zzb(zzmb.zzalc);
        zzb(zzmd.zzald);
        zzb(zzmd.zzalf);
        zzb(zzmd.zzalg);
        zzb(zzmd.zzalh);
        zzb(zzmd.zzale);
        zzb(zzmf.zzalj);
        zzb(zzmf.zzalk);
    }
}
