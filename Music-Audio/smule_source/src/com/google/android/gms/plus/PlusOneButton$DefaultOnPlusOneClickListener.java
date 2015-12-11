// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.google.android.gms.plus:
//            PlusOneButton

public class zzayT
    implements android.view.eClickListener, zzayT
{

    private final zzayU zzayT;
    final PlusOneButton zzayU;

    public void onClick(View view)
    {
        view = (Intent)PlusOneButton.zza(zzayU).getTag();
        if (zzayT != null)
        {
            zzayT.neClick(view);
            return;
        } else
        {
            onPlusOneClick(view);
            return;
        }
    }

    public void onPlusOneClick(Intent intent)
    {
        android.content.Context context = zzayU.getContext();
        if ((context instanceof Activity) && intent != null)
        {
            ((Activity)context).startActivityForResult(intent, PlusOneButton.zzb(zzayU));
        }
    }

    public (PlusOneButton plusonebutton,  )
    {
        zzayU = plusonebutton;
        super();
        zzayT = ;
    }
}
