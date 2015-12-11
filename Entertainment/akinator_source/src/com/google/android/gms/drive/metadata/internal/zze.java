// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzl

public final class zze
{
    public static interface zza
    {

        public abstract void zzb(DataHolder dataholder);

        public abstract String zzrL();
    }


    private static final Map zzamE = new HashMap();
    private static final Map zzamF = new HashMap();

    public static void zza(DataHolder dataholder)
    {
        for (Iterator iterator = zzamF.values().iterator(); iterator.hasNext(); ((zza)iterator.next()).zzb(dataholder)) { }
    }

    private static void zza(zza zza1)
    {
        if (zzamF.put(zza1.zzrL(), zza1) != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("A cleaner for key ").append(zza1.zzrL()).append(" has already been registered").toString());
        } else
        {
            return;
        }
    }

    private static void zzb(MetadataField metadatafield)
    {
        if (zzamE.containsKey(metadatafield.getName()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate field name registered: ").append(metadatafield.getName()).toString());
        } else
        {
            zzamE.put(metadatafield.getName(), metadatafield);
            return;
        }
    }

    public static MetadataField zzcF(String s)
    {
        return (MetadataField)zzamE.get(s);
    }

    public static Collection zzrK()
    {
        return Collections.unmodifiableCollection(zzamE.values());
    }

    static 
    {
        zzb(zznd.zzamJ);
        zzb(zznd.zzanp);
        zzb(zznd.zzang);
        zzb(zznd.zzann);
        zzb(zznd.zzanq);
        zzb(zznd.zzamW);
        zzb(zznd.zzamV);
        zzb(zznd.zzamX);
        zzb(zznd.zzamY);
        zzb(zznd.zzamZ);
        zzb(zznd.zzamT);
        zzb(zznd.zzanb);
        zzb(zznd.zzanc);
        zzb(zznd.zzand);
        zzb(zznd.zzanl);
        zzb(zznd.zzamK);
        zzb(zznd.zzani);
        zzb(zznd.zzamM);
        zzb(zznd.zzamU);
        zzb(zznd.zzamN);
        zzb(zznd.zzamO);
        zzb(zznd.zzamP);
        zzb(zznd.zzamQ);
        zzb(zznd.zzanf);
        zzb(zznd.zzana);
        zzb(zznd.zzanh);
        zzb(zznd.zzanj);
        zzb(zznd.zzank);
        zzb(zznd.zzanm);
        zzb(zznd.zzanr);
        zzb(zznd.zzans);
        zzb(zznd.zzamS);
        zzb(zznd.zzamR);
        zzb(zznd.zzano);
        zzb(zznd.zzane);
        zzb(zznd.zzamL);
        zzb(zznd.zzant);
        zzb(zznd.zzanu);
        zzb(zznd.zzanv);
        zzb(zznd.zzanw);
        zzb(zznd.zzanx);
        zzb(zznd.zzany);
        zzb(zznd.zzanz);
        zzb(zznf.zzanB);
        zzb(zznf.zzanD);
        zzb(zznf.zzanE);
        zzb(zznf.zzanF);
        zzb(zznf.zzanC);
        zzb(zznf.zzanG);
        zzb(zznh.zzanI);
        zzb(zznh.zzanJ);
        zzl zzl1 = zznd.zzanl;
        zza(zzl.zzamI);
        zza(zzne.zzanA);
    }
}
