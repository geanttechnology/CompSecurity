// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkd, zzkf

public abstract class <init> extends <init>
{

    final zzkd zzWd;

    public Result zzb(Status status)
    {
        return zzt(status);
    }

    public com.google.android.gms.cast.games.erClient.GameManagerResult zzt(Status status)
    {
        return new <init>(status, null, -1L, null);
    }

    public _cls1.zzWj(zzkd zzkd1)
    {
        zzWd = zzkd1;
        super(zzkd1);
        zzVC = new zzo(zzkd1) {

            final zzkd zzWj;
            final zzkd.zza zzWk;

            public void zza(long l, int i, Object obj)
            {
                if (obj == null)
                {
                    String s;
                    try
                    {
                        zzWk.zza(new zzkd.zze(new Status(i, null, null), null, l, null));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        zzWk.zza(zzWk.zzt(new Status(13)));
                    }
                    break MISSING_BLOCK_LABEL_135;
                }
                obj = (zzkf)obj;
                s = ((zzkf) (obj)).getPlayerId();
                if (i != 0 || s == null)
                {
                    break MISSING_BLOCK_LABEL_69;
                }
                zzkd.zza(zzWk.zzWd, s);
                zzWk.zza(new zzkd.zze(new Status(i, ((zzkf) (obj)).zzmn(), null), s, ((zzkf) (obj)).getRequestId(), ((zzkf) (obj)).getExtraMessageData()));
                return;
            }

            public void zzy(long l)
            {
                zzWk.zza(zzWk.zzt(new Status(2103)));
            }

            
            {
                zzWk = zzkd.zza.this;
                zzWj = zzkd1;
                super();
            }
        };
    }
}
