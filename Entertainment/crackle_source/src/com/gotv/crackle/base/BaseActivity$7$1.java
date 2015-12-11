// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;

import android.content.DialogInterface;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.dialogs.ParentalPinDialog;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle.base:
//            BaseActivity

class log
    implements android.content.nDismissListener
{

    final l.runAfterPlay this$1;
    final ParentalPinDialog val$dialog;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!val$dialog.wasCancelled())
        {
            if (val$dialog.getCode().compareTo(SharedPrefsManager.getParentalLockCode()) != 0)
            {
                val$dialog.show();
                val$dialog.clearInput();
            } else
            {
                BaseActivity.access$200(_fld0, itemID);
            }
        }
        if (runAfterPlay != null)
        {
            runAfterPlay.run();
        }
    }

    log()
    {
        this$1 = final_log;
        val$dialog = ParentalPinDialog.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/base/BaseActivity$7

/* anonymous class */
    class BaseActivity._cls7
        implements Runnable
    {

        final BaseActivity this$0;
        final String val$itemID;
        final Runnable val$runAfterPlay;

        public void run()
        {
            ParentalPinDialog parentalpindialog = new ParentalPinDialog(BaseActivity.this);
            ((TextView)parentalpindialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
            parentalpindialog.setTitle(getString(0x7f0b0069));
            parentalpindialog.setOnDismissListener(parentalpindialog. new BaseActivity._cls7._cls1());
            parentalpindialog.show();
        }

            
            {
                this$0 = final_baseactivity;
                itemID = s;
                runAfterPlay = Runnable.this;
                super();
            }
    }

}
