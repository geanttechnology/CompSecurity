// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zznd;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata, MetadataBuffer

private static class bt extends Metadata
{

    private final DataHolder zzabq;
    private final int zzadm;
    private final int zzajb;

    static int zza(bt bt)
    {
        return bt.zzajb;
    }

    public Object freeze()
    {
        return zzqV();
    }

    public boolean isDataValid()
    {
        return !zzabq.isClosed();
    }

    public Object zza(MetadataField metadatafield)
    {
        return metadatafield.zza(zzabq, zzajb, zzadm);
    }

    public Metadata zzqV()
    {
        MetadataBundle metadatabundle = MetadataBundle.zzrM();
        Iterator iterator = zze.zzrK().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MetadataField metadatafield = (MetadataField)iterator.next();
            if (metadatafield != zznd.zzano)
            {
                metadatafield.zza(zzabq, metadatabundle, zzajb, zzadm);
            }
        } while (true);
        return new zzp(metadatabundle);
    }

    public eld(DataHolder dataholder, int i)
    {
        zzabq = dataholder;
        zzajb = i;
        zzadm = dataholder.zzbt(i);
    }
}
