// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.google.android.gms.plus:
//            PlusOneButton

protected class zzaLk
    implements android.view.eClickListener, zzaLk
{

    private final zzaLl zzaLk;
    final PlusOneButton zzaLl;

    public void onClick(View view)
    {
        view = (Intent)PlusOneButton.zza(zzaLl).getTag();
        if (zzaLk != null)
        {
            zzaLk.neClick(view);
            return;
        } else
        {
            onPlusOneClick(view);
            return;
        }
    }

    public void onPlusOneClick(Intent intent)
    {
        android.content.Context context = zzaLl.getContext();
        if ((context instanceof Activity) && intent != null)
        {
            ((Activity)context).startActivityForResult(intent, PlusOneButton.zzb(zzaLl));
        }
    }

    public (PlusOneButton plusonebutton,  )
    {
        zzaLl = plusonebutton;
        super();
        zzaLk = ;
    }
}
