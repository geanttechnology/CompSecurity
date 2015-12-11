// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzko, zzkq, zzkp

class zzYb
    implements zzo
{

    final zzko zzYb;
    final nit> zzYe;

    public void zza(long l, int i, Object obj)
    {
        if (obj == null)
        {
            zzkp zzkp1;
            try
            {
                zzYe.b(new nit>(new Status(i, null, null), a(zzYe)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                zzYe.b(zzYe.r(new Status(13)));
            }
            break MISSING_BLOCK_LABEL_156;
        }
        obj = (zzkq)obj;
        zzkp1 = ((zzkq) (obj)).zzmN();
        if (zzkp1 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (!zzf.zza("1.0.0", zzkp1.getVersion()))
        {
            zzYe.b(zzYe.r(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[] {
                zzkp1.getVersion(), "1.0.0"
            }))));
            zzko.zza(zzYe.XV, null);
            return;
        }
        break MISSING_BLOCK_LABEL_157;
        return;
        zzYe.b(new nit>(new Status(i, ((zzkq) (obj)).zzmJ(), null), a(zzYe)));
        return;
    }

    public void zzy(long l)
    {
        zzYe.b(zzYe.r(new Status(2103)));
    }

    ( , zzko zzko1)
    {
        zzYe = ;
        zzYb = zzko1;
        super();
    }
}
