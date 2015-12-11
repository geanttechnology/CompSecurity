// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLogoutActivity

class this._cls0
    implements android.content.tener
{

    final CentralSSOLogoutActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
        finish();
    }

    ()
    {
        this$0 = CentralSSOLogoutActivity.this;
        super();
    }
}
