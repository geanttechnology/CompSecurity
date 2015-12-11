// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.cachebust;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.groupon.activity.Carousel;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.service.cachebust:
//            EmergencyDialogDisplayManager

class this._cls1
    implements android.content.ayManager._cls1._cls1
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((Logger)RoboGuice.getInjector(EmergencyDialogDisplayManager.access$000(_fld0)).getInstance(com/groupon/tracking/mobile/sdk/Logger)).logGeneralEvent("CacheBusting", "restart", EmergencyDialogDisplayManager.access$000(_fld0).getLocalClassName(), 0, Logger.NULL_NST_FIELD);
        if (EmergencyDialogDisplayManager.access$000(_fld0) instanceof Carousel)
        {
            System.exit(0);
            return;
        } else
        {
            dialoginterface = new Intent(EmergencyDialogDisplayManager.access$000(_fld0).getApplicationContext(), com/groupon/activity/Carousel);
            dialoginterface.setFlags(0x4000000);
            dialoginterface.putExtra("EXIT", true);
            EmergencyDialogDisplayManager.access$000(_fld0).startActivity(dialoginterface);
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/service/cachebust/EmergencyDialogDisplayManager$1

/* anonymous class */
    class EmergencyDialogDisplayManager._cls1
        implements Runnable
    {

        final EmergencyDialogDisplayManager this$0;

        public void run()
        {
            com.groupon.util.GrouponAlertDialog.Builder builder = new com.groupon.util.GrouponAlertDialog.Builder(EmergencyDialogDisplayManager.access$000(EmergencyDialogDisplayManager.this));
            builder.setCancelable(false).setMessage(0x7f0800bb).setNegativeButton(0x7f0804fe, new EmergencyDialogDisplayManager._cls1._cls1());
            builder.create().show();
        }

            
            {
                this$0 = EmergencyDialogDisplayManager.this;
                super();
            }
    }

}
