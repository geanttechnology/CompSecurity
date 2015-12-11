// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.tagmanager:
//            DataLayer

class zzaWD
    implements c.zza
{

    final DataLayer zzaWD;

    public void zzw(List list)
    {
        a a;
        for (list = list.iterator(); list.hasNext(); DataLayer.zza(zzaWD, zzaWD.zzk(a.zzue, a.zzJy)))
        {
            a = (a)list.next();
        }

        DataLayer.zza(zzaWD).countDown();
    }

    a(DataLayer datalayer)
    {
        zzaWD = datalayer;
        super();
    }
}
