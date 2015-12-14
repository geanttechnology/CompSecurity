// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.zze;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata

public final class MetadataBuffer extends AbstractDataBuffer
{

    private zza zzaja;

    public MetadataBuffer(DataHolder dataholder)
    {
        super(dataholder);
        dataholder.zzor().setClassLoader(com/google/android/gms/drive/MetadataBuffer.getClassLoader());
    }

    public final Metadata get(int i)
    {
        zza zza1;
label0:
        {
            zza zza2 = zzaja;
            if (zza2 != null)
            {
                zza1 = zza2;
                if (zza.zza(zza2) == i)
                {
                    break label0;
                }
            }
            zza1 = new zza(zzabq, i);
            zzaja = zza1;
        }
        return zza1;
    }

    public final volatile Object get(int i)
    {
        return get(i);
    }

    public final String getNextPageToken()
    {
        return null;
    }

    public final void release()
    {
        if (zzabq != null)
        {
            zze.zza(zzabq);
        }
        super.release();
    }

    /* member class not found */
    class zza {}

}
