// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcu

class zzaZf
    implements android.os..Callback
{

    final zzcu zzaZf;

    public boolean handleMessage(Message message)
    {
        if (1 == message.what && zzcu.zzDK().equals(message.obj))
        {
            zzaZf.dispatch();
            if (zzcu.zzb(zzaZf) > 0 && !zzcu.zzc(zzaZf))
            {
                zzcu.zzd(zzaZf).sendMessageDelayed(zzcu.zzd(zzaZf).obtainMessage(1, zzcu.zzDK()), zzcu.zzb(zzaZf));
            }
        }
        return true;
    }

    (zzcu zzcu1)
    {
        zzaZf = zzcu1;
        super();
    }
}
