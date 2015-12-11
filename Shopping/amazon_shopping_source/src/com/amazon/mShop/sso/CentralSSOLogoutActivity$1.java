// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLogoutActivity

class this._cls0
    implements android.content.ener
{

    final CentralSSOLogoutActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            return;

        case -2: 
            dialoginterface.dismiss();
            CentralSSOLogoutActivity.access$000(CentralSSOLogoutActivity.this);
            return;

        case -1: 
            dialoginterface.dismiss();
            break;
        }
        finish();
    }

    ()
    {
        this$0 = CentralSSOLogoutActivity.this;
        super();
    }
}
