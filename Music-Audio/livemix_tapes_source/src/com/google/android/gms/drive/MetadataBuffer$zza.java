// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzo;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzmb;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata, MetadataBuffer

private static class bo extends Metadata
{

    private final DataHolder zzYX;
    private final int zzabh;
    private final int zzagQ;

    static int zza(bo bo)
    {
        return bo.zzagQ;
    }

    public Object freeze()
    {
        return zzqo();
    }

    public boolean isDataValid()
    {
        return !zzYX.isClosed();
    }

    public Object zza(MetadataField metadatafield)
    {
        return metadatafield.zza(zzYX, zzagQ, zzabh);
    }

    public Metadata zzqo()
    {
        MetadataBundle metadatabundle = MetadataBundle.zzrb();
        Iterator iterator = zze.zzra().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MetadataField metadatafield = (MetadataField)iterator.next();
            if (metadatafield != zzmb.zzakT)
            {
                metadatafield.zza(zzYX, metadatabundle, zzagQ, zzabh);
            }
        } while (true);
        return new zzo(metadatabundle);
    }

    public eld(DataHolder dataholder, int i)
    {
        zzYX = dataholder;
        zzagQ = i;
        zzabh = dataholder.zzbo(i);
    }
}
