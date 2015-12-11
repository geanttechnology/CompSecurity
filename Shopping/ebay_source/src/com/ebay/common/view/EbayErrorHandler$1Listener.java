// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.common.view:
//            EbayErrorHandler

class hasDateSettings
    implements android.content.tener, android.content.ener
{

    final WeakReference activity;
    final boolean hasDateSettings;

    public void onCancel(DialogInterface dialoginterface)
    {
        Process.killProcess(Process.myPid());
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -2)
        {
            Intent intent;
            Activity activity1;
            if (hasDateSettings)
            {
                intent = new Intent("android.settings.DATE_SETTINGS");
            } else
            {
                intent = new Intent("android.settings.SETTINGS");
            }
            intent.addFlags(0x10000000);
            activity1 = (Activity)activity.get();
            if (activity1 != null)
            {
                activity1.startActivity(intent);
            }
        }
        dialoginterface.cancel();
    }

    (Activity activity1)
    {
        boolean flag = false;
        super();
        activity = new WeakReference(activity1);
        if (activity1.getPackageManager().resolveActivity(new Intent("android.settings.DATE_SETTINGS"), 0) != null)
        {
            flag = true;
        }
        hasDateSettings = flag;
    }
}
