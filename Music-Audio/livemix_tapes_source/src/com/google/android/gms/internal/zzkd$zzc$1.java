// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzkd, zzkf, zzke

class zzWj
    implements zzo
{

    final zzkd zzWj;
    final nit> zzWm;

    public void zza(long l, int i, Object obj)
    {
        if (obj == null)
        {
            zzke zzke1;
            try
            {
                zzWm.a(new nit>(new Status(i, null, null), a(zzWm)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                zzWm.a(zzWm.u(new Status(13)));
            }
            break MISSING_BLOCK_LABEL_156;
        }
        obj = (zzkf)obj;
        zzke1 = ((zzkf) (obj)).zzmr();
        if (zzke1 == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (!zzf.zza("1.0.0", zzke1.getVersion()))
        {
            zzWm.a(zzWm.u(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[] {
                zzke1.getVersion(), "1.0.0"
            }))));
            zzkd.zza(zzWm.Wd, null);
            return;
        }
        break MISSING_BLOCK_LABEL_157;
        return;
        zzWm.a(new nit>(new Status(i, ((zzkf) (obj)).zzmn(), null), a(zzWm)));
        return;
    }

    public void zzy(long l)
    {
        zzWm.a(zzWm.u(new Status(2103)));
    }

    ( , zzkd zzkd1)
    {
        zzWm = ;
        zzWj = zzkd1;
        super();
    }
}
