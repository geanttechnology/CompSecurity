// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.viewitem:
//            PpaUpgradeActivity

public class PpaUpgradeConfirmDialog extends Dialog
{

    private PpaUpgradeConfirmDialog(Context context)
    {
        super(context);
    }

    private PpaUpgradeConfirmDialog(Context context, int i)
    {
        super(context, i);
    }

    private PpaUpgradeConfirmDialog(Context context, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        super(context, flag, oncancellistener);
    }

    public static Dialog create(Activity activity, boolean flag)
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
        builder.setMessage(0x7f0707a9).setCancelable(false).setTitle(0x7f0707aa).setPositiveButton(0x7f0707a8, new android.content.DialogInterface.OnClickListener(activity, flag) {

            final Activity val$a;
            final boolean val$closeActivityOnDismiss;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                PpaUpgradeActivity.start(a);
                if (closeActivityOnDismiss)
                {
                    a.finish();
                }
            }

            
            {
                a = activity;
                closeActivityOnDismiss = flag;
                super();
            }
        }).setNegativeButton(0x7f0707a7, new android.content.DialogInterface.OnClickListener(flag, activity) {

            final Activity val$a;
            final boolean val$closeActivityOnDismiss;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (closeActivityOnDismiss)
                {
                    a.finish();
                }
            }

            
            {
                closeActivityOnDismiss = flag;
                a = activity;
                super();
            }
        });
        return builder.create();
    }
}
