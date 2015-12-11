// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Process;
import android.widget.Toast;
import com.gotv.crackle.Application;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.helpers.MyCrackleViewHelper;
import com.gotv.crackle.util.LocalNotificationManager;
import com.mobileapptracker.MobileAppTracker;
import com.sessionm.api.ext.SessionM;
import java.util.List;

// Referenced classes of package com.gotv.crackle.base:
//            BaseActivity

class val.tag
    implements Runnable
{

    final BaseActivity this$0;
    final String val$tag;

    public void run()
    {
        if (val$tag.compareTo("GetLocation") != 0) goto _L2; else goto _L1
_L1:
        if (!Application.getInstance().getLocalization().isCurrentCountryCodeValid())
        {
            removeDialogFragment(42340);
            android.app.lder lder = new android.app.lder(BaseActivity.this);
            lder.setMessage(getResources().getString(0x7f0b00b3));
            lder.setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                final BaseActivity._cls5 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent("android.intent.action.MAIN");
                    dialoginterface.addCategory("android.intent.category.HOME");
                    dialoginterface.addFlags(0x4000000);
                    dialoginterface.setFlags(0x10000000);
                    startActivity(dialoginterface);
                    Process.killProcess(Process.myPid());
                }

            
            {
                this$1 = BaseActivity._cls5.this;
                super();
            }
            });
            lder.create().show();
        }
_L4:
        return;
_L2:
        if (val$tag.compareTo("FULL_WATCHLIST") != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (BaseActivity.access$000(BaseActivity.this).getItems() != null && BaseActivity.access$000(BaseActivity.this).getItems().size() > 0)
        {
            (new LocalNotificationManager()).regenerateWatchlistAlerts(BaseActivity.this, BaseActivity.access$000(BaseActivity.this).getItems());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (val$tag.compareTo("CrackleAccountManager Register") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        removeDialogFragment(42340);
        BaseActivity.sMyCrackleHelper.dismissRegistrationDialog();
        BaseActivity.sMyCrackleHelper.dismissSignInRegistrationDialog();
        BaseActivity.sMyCrackleHelper.setUpLogOut();
        Toast.makeText(BaseActivity.this, getResources().getString(0x7f0b0082), 0).show();
        Application.getInstance().getHasOffersTracking().measureAction("registration");
        SessionM.getInstance().presentActivity(com.sessionm.api.tyType.ACHIEVEMENT, new Object[] {
            "register"
        });
        String s = CrackleAccountManager.getUserID();
        if (s != null)
        {
            BaseActivity.access$002(BaseActivity.this, new QueueManager(BaseActivity.this, s));
            BaseActivity.access$000(BaseActivity.this).getWatchList();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (val$tag.compareTo("CrackleAccountManager Sign In") != 0) goto _L4; else goto _L5
_L5:
        removeDialogFragment(42340);
        BaseActivity.sMyCrackleHelper.dismissSignInDialog();
        BaseActivity.sMyCrackleHelper.dismissSignInRegistrationDialog();
        BaseActivity.sMyCrackleHelper.setUpLogOut();
        Toast.makeText(BaseActivity.this, getResources().getString(0x7f0b0083), 0).show();
        if (BaseActivity.access$100(BaseActivity.this) != null)
        {
            BaseActivity.access$100(BaseActivity.this).onSignInSuccess();
        }
        String s1 = CrackleAccountManager.getUserID();
        if (s1 != null)
        {
            BaseActivity.access$002(BaseActivity.this, new QueueManager(BaseActivity.this, s1));
            BaseActivity.access$000(BaseActivity.this).getWatchList();
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    _cls1.this._cls1()
    {
        this$0 = final_baseactivity;
        val$tag = String.this;
        super();
    }
}
