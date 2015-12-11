// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Window;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzd

class zzBy
    implements Runnable
{

    final Drawable zzBy;
    final zzBy zzBz;

    public void run()
    {
        zzd.zza(zzBz.Bv).getWindow().setBackgroundDrawable(zzBy);
    }

    ( , Drawable drawable)
    {
        zzBz = ;
        zzBy = drawable;
        super();
    }
}
