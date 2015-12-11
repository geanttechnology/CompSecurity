// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzah, zzr, zzaf, zzab

class zzPA
{

    private ByteArrayOutputStream zzPA;
    final zzah zzPB;
    private int zzPz;

    public byte[] getPayload()
    {
        return zzPA.toByteArray();
    }

    public boolean zzj(zzab zzab)
    {
        zzx.zzw(zzab);
        if (zzPz + 1 > zzPB.zziv().zzjM())
        {
            return false;
        }
        String s = zzPB.zza(zzab, false);
        if (s == null)
        {
            zzPB.zziu().zza(zzab, "Error formatting hit");
            return true;
        }
        byte abyte0[] = s.getBytes();
        int j = abyte0.length;
        if (j > zzPB.zziv().zzjE())
        {
            zzPB.zziu().zza(zzab, "Hit size exceeds the maximum size limit");
            return true;
        }
        int i = j;
        if (zzPA.size() > 0)
        {
            i = j + 1;
        }
        if (i + zzPA.size() > zzPB.zziv().zzjG())
        {
            return false;
        }
        try
        {
            if (zzPA.size() > 0)
            {
                zzPA.write(zzah.zzkM());
            }
            zzPA.write(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (zzab zzab)
        {
            zzPB.zze("Failed to write payload when batching hits", zzab);
            return true;
        }
        zzPz = zzPz + 1;
        return true;
    }

    public int zzkN()
    {
        return zzPz;
    }

    public (zzah zzah1)
    {
        zzPB = zzah1;
        super();
        zzPA = new ByteArrayOutputStream();
    }
}
