// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzko, zzkq, zzkp

public abstract class <init> extends <init>
{

    final zzko zzXV;
    private GameManagerClient zzYd;

    static GameManagerClient zza(<init> <init>1)
    {
        return <init>1.zzYd;
    }

    public Result zzb(Status status)
    {
        return zzr(status);
    }

    public com.google.android.gms.cast.games.erClient.GameManagerInstanceResult zzr(Status status)
    {
        return new <init>(status, null);
    }

    public agerClient(zzko zzko1, GameManagerClient gamemanagerclient)
    {
        zzXV = zzko1;
        super(zzko1);
        zzYd = gamemanagerclient;
        zzXu = new zzo(zzko1) {

            final zzko zzYb;
            final zzko.zzc zzYe;

            public void zza(long l, int i, Object obj)
            {
                if (obj == null)
                {
                    zzkp zzkp1;
                    try
                    {
                        zzYe.zzb(new zzko.zzd(new Status(i, null, null), zzko.zzc.zza(zzYe)));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        zzYe.zzb(zzYe.zzr(new Status(13)));
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
                    zzYe.zzb(zzYe.zzr(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[] {
                        zzkp1.getVersion(), "1.0.0"
                    }))));
                    zzko.zza(zzYe.zzXV, null);
                    return;
                }
                break MISSING_BLOCK_LABEL_157;
                return;
                zzYe.zzb(new zzko.zzd(new Status(i, ((zzkq) (obj)).zzmJ(), null), zzko.zzc.zza(zzYe)));
                return;
            }

            public void zzy(long l)
            {
                zzYe.zzb(zzYe.zzr(new Status(2103)));
            }

            
            {
                zzYe = zzko.zzc.this;
                zzYb = zzko1;
                super();
            }
        };
    }
}
