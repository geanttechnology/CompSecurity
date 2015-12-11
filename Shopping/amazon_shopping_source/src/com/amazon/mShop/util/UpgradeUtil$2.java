// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.view.View;
import com.amazon.mShop.AmazonAlertDialog;

// Referenced classes of package com.amazon.mShop.util:
//            UpgradeUtil, AppUtils

static final class val.dialog
    implements android.view.stener
{

    final AmazonAlertDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
        UpgradeUtil.goToUpgradePage();
        AppUtils.exitApp();
    }

    (AmazonAlertDialog amazonalertdialog)
    {
        val$dialog = amazonalertdialog;
        super();
    }
}
