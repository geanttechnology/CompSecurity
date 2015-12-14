// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            MobileScreen

class this._cls0
    implements Runnable
{

    final MobileScreen this$0;

    public void run()
    {
        MobileScreen.access$1600(MobileScreen.this);
        if (MobileScreen.access$1100(MobileScreen.this))
        {
            String s = MobileScreen.access$200(MobileScreen.this).getText().toString();
            AlertDialog alertdialog = MobileScreen.access$2900(MobileScreen.this).createDialog(MobileScreen.access$2500(MobileScreen.this), MobileScreen.access$2600(MobileScreen.this).getString(0x7f0e00c9), MobileScreen.access$2700(MobileScreen.this).getString(0x7f0e0092), MobileScreen.access$2800(MobileScreen.this).getString(0x7f0e00c3), new android.content.DialogInterface.OnClickListener() {

                final MobileScreen._cls9 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    MobileScreen.access$000(this$0, com.amazon.gallery.framework.network.http.senna.operations.SendNotificationOperation.NotificationType.MOBILE_INSTALL_HELP_EMAIL);
                }

            
            {
                this$1 = MobileScreen._cls9.this;
                super();
            }
            });
            alertdialog.setTitle(MobileScreen.access$3000(MobileScreen.this).getString(0x7f0e00cd, new Object[] {
                s
            }));
            alertdialog.show();
            return;
        } else
        {
            MobileScreen.access$3200(MobileScreen.this).showErrorNotification(MobileScreen.access$3100(MobileScreen.this).getString(0x7f0e00bb));
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = MobileScreen.this;
        super();
    }
}
