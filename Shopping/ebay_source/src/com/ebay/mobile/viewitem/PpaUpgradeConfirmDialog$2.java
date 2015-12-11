// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.viewitem:
//            PpaUpgradeConfirmDialog, PpaUpgradeActivity

static final class val.closeActivityOnDismiss
    implements android.content.tener
{

    final Activity val$a;
    final boolean val$closeActivityOnDismiss;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        PpaUpgradeActivity.start(val$a);
        if (val$closeActivityOnDismiss)
        {
            val$a.finish();
        }
    }

    (Activity activity, boolean flag)
    {
        val$a = activity;
        val$closeActivityOnDismiss = flag;
        super();
    }
}
