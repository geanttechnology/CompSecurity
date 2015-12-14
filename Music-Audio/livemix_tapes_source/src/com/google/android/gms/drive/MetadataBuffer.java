// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzo;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzmb;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata

public final class MetadataBuffer extends AbstractDataBuffer
{
    private static class zza extends Metadata
    {

        private final DataHolder zzYX;
        private final int zzabh;
        private final int zzagQ;

        static int zza(zza zza1)
        {
            return zza1.zzagQ;
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

        public zza(DataHolder dataholder, int i)
        {
            zzYX = dataholder;
            zzagQ = i;
            zzabh = dataholder.zzbo(i);
        }
    }


    private zza zzagP;

    public MetadataBuffer(DataHolder dataholder)
    {
        super(dataholder);
        dataholder.zznP().setClassLoader(com/google/android/gms/drive/MetadataBuffer.getClassLoader());
    }

    public Metadata get(int i)
    {
        zza zza1;
label0:
        {
            zza zza2 = zzagP;
            if (zza2 != null)
            {
                zza1 = zza2;
                if (zza.zza(zza2) == i)
                {
                    break label0;
                }
            }
            zza1 = new zza(zzYX, i);
            zzagP = zza1;
        }
        return zza1;
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public String getNextPageToken()
    {
        return null;
    }

    public void release()
    {
        if (zzYX != null)
        {
            zze.zzb(zzYX);
        }
        super.release();
    }
}
