// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            zzll, zzli

class zzacC extends zzll
{

    private WeakReference zzacC;

    public void zzoi()
    {
        zzli zzli1 = (zzli)zzacC.get();
        if (zzli1 == null)
        {
            return;
        } else
        {
            zzli.zzd(zzli1);
            return;
        }
    }

    (zzli zzli1)
    {
        zzacC = new WeakReference(zzli1);
    }
}
