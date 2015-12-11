// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.sso:
//            DistributedSSOLogoutActivity

class this._cls0
    implements android.content.r
{

    final DistributedSSOLogoutActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
        finish();
    }

    _cls9()
    {
        this$0 = DistributedSSOLogoutActivity.this;
        super();
    }
}
