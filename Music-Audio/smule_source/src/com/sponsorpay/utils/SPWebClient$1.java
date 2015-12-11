// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.sponsorpay.utils:
//            SPWebClient

class this._cls0
    implements android.content.e.OnClickListener
{

    final SPWebClient this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (getHostActivity() != null)
        {
            getHostActivity().finish();
        }
    }

    lickListener()
    {
        this$0 = SPWebClient.this;
        super();
    }
}
