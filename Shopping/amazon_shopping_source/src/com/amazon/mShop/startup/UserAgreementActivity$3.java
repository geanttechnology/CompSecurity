// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.startup:
//            UserAgreementActivity

class this._cls0
    implements android.content.sListener
{

    final UserAgreementActivity this$0;

    public void onDismiss(DialogInterface dialoginterface)
    {
        finishIfNotFinishing();
    }

    ()
    {
        this$0 = UserAgreementActivity.this;
        super();
    }
}
