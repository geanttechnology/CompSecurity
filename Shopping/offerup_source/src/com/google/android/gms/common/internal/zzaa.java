// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzu

public final class zzaa extends zzg
{

    private static final zzaa zzags = new zzaa();

    private zzaa()
    {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzb(Context context, int i, int j)
    {
        return zzags.zzc(context, i, j);
    }

    private View zzc(Context context, int i, int j)
    {
        try
        {
            com.google.android.gms.dynamic.zzd zzd1 = zze.zzy(context);
            context = (View)zze.zzp(((zzu)zzas(context)).zza(zzd1, i, j));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new com.google.android.gms.dynamic.zzg.zza((new StringBuilder("Could not get button with size ")).append(i).append(" and color ").append(j).toString(), context);
        }
        return context;
    }

    public final zzu zzaN(IBinder ibinder)
    {
        return zzu.zza.zzaM(ibinder);
    }

    public final Object zzd(IBinder ibinder)
    {
        return zzaN(ibinder);
    }

}
