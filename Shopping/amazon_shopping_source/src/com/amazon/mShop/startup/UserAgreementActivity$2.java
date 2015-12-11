// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.content.DialogInterface;
import com.amazon.mShop.util.AppUtils;

// Referenced classes of package com.amazon.mShop.startup:
//            UserAgreementActivity

class this._cls0
    implements android.content.istener
{

    final UserAgreementActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        AppUtils.exitApp();
        endStartupTask("taskResultFail");
    }

    ()
    {
        this$0 = UserAgreementActivity.this;
        super();
    }
}
