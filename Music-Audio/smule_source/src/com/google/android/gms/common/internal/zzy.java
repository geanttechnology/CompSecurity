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
//            zzs

public final class zzy extends zzg
{

    private static final zzy zzUc = new zzy();

    private zzy()
    {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzb(Context context, int i, int j)
    {
        return zzUc.zzc(context, i, j);
    }

    private View zzc(Context context, int i, int j)
    {
        try
        {
            com.google.android.gms.dynamic.zzd zzd1 = zze.zzt(context);
            context = (View)zze.zzg(((zzs)zzX(context)).zza(zzd1, i, j));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new com.google.android.gms.dynamic.zzg.zza((new StringBuilder()).append("Could not get button with size ").append(i).append(" and color ").append(j).toString(), context);
        }
        return context;
    }

    public zzs zzW(IBinder ibinder)
    {
        return zzs.zza.zzV(ibinder);
    }

    public Object zzd(IBinder ibinder)
    {
        return zzW(ibinder);
    }

}
