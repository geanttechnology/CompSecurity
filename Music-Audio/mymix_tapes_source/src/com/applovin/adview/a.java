// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.content.DialogInterface;

// Referenced classes of package com.applovin.adview:
//            AppLovinConfirmationActivity

class a
    implements android.content.DialogInterface.OnClickListener
{

    final AppLovinConfirmationActivity a;

    a(AppLovinConfirmationActivity applovinconfirmationactivity)
    {
        a = applovinconfirmationactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        a.finish();
    }
}
