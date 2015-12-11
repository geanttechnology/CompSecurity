// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.google.android.gms.plus:
//            PlusOneButton

protected class DF
    implements android.view.eClickListener, DF
{

    private final DG DF;
    final PlusOneButton DG;

    public void onClick(View view)
    {
        view = (Intent)PlusOneButton.a(DG).getTag();
        if (DF != null)
        {
            DF.neClick(view);
            return;
        } else
        {
            onPlusOneClick(view);
            return;
        }
    }

    public void onPlusOneClick(Intent intent)
    {
        android.content.Context context = DG.getContext();
        if ((context instanceof Activity) && intent != null)
        {
            ((Activity)context).startActivityForResult(intent, PlusOneButton.b(DG));
        }
    }

    public (PlusOneButton plusonebutton,  )
    {
        DG = plusonebutton;
        super();
        DF = ;
    }
}
