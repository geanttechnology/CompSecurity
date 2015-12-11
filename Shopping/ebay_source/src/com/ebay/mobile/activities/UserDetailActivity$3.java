// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.mobile.activities:
//            UserDetailActivity, eBay

class this._cls0
    implements android.content.ckListener
{

    final UserDetailActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MyApp.signOut(false);
        eBay.Restart(UserDetailActivity.this);
        finish();
    }

    ()
    {
        this$0 = UserDetailActivity.this;
        super();
    }
}
