// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.viewitem:
//            PpaUpgradeConfirmDialog

static final class val.a
    implements android.content.tener
{

    final Activity val$a;
    final boolean val$closeActivityOnDismiss;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (val$closeActivityOnDismiss)
        {
            val$a.finish();
        }
    }

    (boolean flag, Activity activity)
    {
        val$closeActivityOnDismiss = flag;
        val$a = activity;
        super();
    }
}
