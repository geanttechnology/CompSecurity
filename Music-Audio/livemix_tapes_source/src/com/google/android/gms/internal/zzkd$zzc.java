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
//            zzkd, zzkf, zzke

public abstract class <init> extends <init>
{

    final zzkd zzWd;
    private GameManagerClient zzWl;

    static GameManagerClient zza(<init> <init>1)
    {
        return <init>1.zzWl;
    }

    public Result zzb(Status status)
    {
        return zzu(status);
    }

    public com.google.android.gms.cast.games.erClient.GameManagerInstanceResult zzu(Status status)
    {
        return new <init>(status, null);
    }

    public agerClient(zzkd zzkd1, GameManagerClient gamemanagerclient)
    {
        zzWd = zzkd1;
        super(zzkd1);
        zzWl = gamemanagerclient;
        zzVC = new zzo(zzkd1) {

            final zzkd zzWj;
            final zzkd.zzc zzWm;

            public void zza(long l, int i, Object obj)
            {
                if (obj == null)
                {
                    zzke zzke1;
                    try
                    {
                        zzWm.zza(new zzkd.zzd(new Status(i, null, null), zzkd.zzc.zza(zzWm)));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        zzWm.zza(zzWm.zzu(new Status(13)));
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
                    zzWm.zza(zzWm.zzu(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[] {
                        zzke1.getVersion(), "1.0.0"
                    }))));
                    zzkd.zza(zzWm.zzWd, null);
                    return;
                }
                break MISSING_BLOCK_LABEL_157;
                return;
                zzWm.zza(new zzkd.zzd(new Status(i, ((zzkf) (obj)).zzmn(), null), zzkd.zzc.zza(zzWm)));
                return;
            }

            public void zzy(long l)
            {
                zzWm.zza(zzWm.zzu(new Status(2103)));
            }

            
            {
                zzWm = zzkd.zzc.this;
                zzWj = zzkd1;
                super();
            }
        };
    }
}
