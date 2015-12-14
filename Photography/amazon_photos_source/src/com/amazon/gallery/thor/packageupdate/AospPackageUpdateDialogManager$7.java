// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.app.Activity;
import android.content.DialogInterface;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;

// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            AospPackageUpdateDialogManager, ApplicationStore

class val.context
    implements android.content.UpdateDialogManager._cls7
{

    final AospPackageUpdateDialogManager this$0;
    final Activity val$context;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        dialoginterface = AospPackageUpdateDialogManager.access$200(AospPackageUpdateDialogManager.this).getUpdateIntent(val$context);
        val$context.startActivity(dialoginterface);
        AospPackageUpdateDialogManager.access$300(AospPackageUpdateDialogManager.this).trackEvent(tricsEvent.MandatoryUpdateLaunched);
    }

    tricsEvent()
    {
        this$0 = final_aosppackageupdatedialogmanager;
        val$context = Activity.this;
        super();
    }
}
