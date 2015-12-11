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

class val.runAfterPlay
    implements Runnable
{

    final BaseActivity this$0;
    final String val$itemID;
    final Runnable val$runAfterPlay;

    public void run()
    {
        final ParentalPinDialog dialog = new ParentalPinDialog(BaseActivity.this);
        ((TextView)dialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        dialog.setTitle(getString(0x7f0b0069));
        dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final BaseActivity._cls7 this$1;
            final ParentalPinDialog val$dialog;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (!dialog.wasCancelled())
                {
                    if (dialog.getCode().compareTo(SharedPrefsManager.getParentalLockCode()) != 0)
                    {
                        dialog.show();
                        dialog.clearInput();
                    } else
                    {
                        BaseActivity.access$200(this$0, itemID);
                    }
                }
                if (runAfterPlay != null)
                {
                    runAfterPlay.run();
                }
            }

            
            {
                this$1 = BaseActivity._cls7.this;
                dialog = parentalpindialog;
                super();
            }
        });
        dialog.show();
    }

    _cls1.val.dialog()
    {
        this$0 = final_baseactivity;
        val$itemID = s;
        val$runAfterPlay = Runnable.this;
        super();
    }
}
