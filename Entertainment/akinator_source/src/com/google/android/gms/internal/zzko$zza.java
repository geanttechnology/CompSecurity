// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzko, zzkq

public abstract class <init> extends <init>
{

    final zzko zzXV;

    public Result zzb(Status status)
    {
        return zzq(status);
    }

    public com.google.android.gms.cast.games.erClient.GameManagerResult zzq(Status status)
    {
        return new <init>(status, null, -1L, null);
    }

    public _cls1.zzYb(zzko zzko1)
    {
        zzXV = zzko1;
        super(zzko1);
        zzXu = new zzo(zzko1) {

            final zzko zzYb;
            final zzko.zza zzYc;

            public void zza(long l, int i, Object obj)
            {
                if (obj == null)
                {
                    String s;
                    try
                    {
                        zzYc.zzb(new zzko.zze(new Status(i, null, null), null, l, null));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        zzYc.zzb(zzYc.zzq(new Status(13)));
                    }
                    break MISSING_BLOCK_LABEL_135;
                }
                obj = (zzkq)obj;
                s = ((zzkq) (obj)).getPlayerId();
                if (i != 0 || s == null)
                {
                    break MISSING_BLOCK_LABEL_69;
                }
                zzko.zza(zzYc.zzXV, s);
                zzYc.zzb(new zzko.zze(new Status(i, ((zzkq) (obj)).zzmJ(), null), s, ((zzkq) (obj)).getRequestId(), ((zzkq) (obj)).getExtraMessageData()));
                return;
            }

            public void zzy(long l)
            {
                zzYc.zzb(zzYc.zzq(new Status(2103)));
            }

            
            {
                zzYc = zzko.zza.this;
                zzYb = zzko1;
                super();
            }
        };
    }
}
