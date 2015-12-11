// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.gotv.crackle.helpers.MyCrackleViewHelper;

// Referenced classes of package com.gotv.crackle.base:
//            BaseActivity

class val.Message
    implements Runnable
{

    final BaseActivity this$0;
    final String val$Message;
    final String val$tag;

    public void run()
    {
        if (val$tag.equalsIgnoreCase("ForgotPassword"))
        {
            BaseActivity.sMyCrackleHelper.dismissForgotPasswordDialog();
            removeDialogFragment(42340);
            android.app.lder lder = new android.app.lder(BaseActivity.this);
            lder.setMessage(val$Message);
            lder.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                final BaseActivity._cls6 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = BaseActivity._cls6.this;
                super();
            }
            });
            lder.create().show();
        } else
        if (val$tag.compareTo("CrackleAccountManager Register") == 0 || val$tag.compareTo("CrackleAccountManager Sign In") == 0)
        {
            removeDialogFragment(42340);
            android.app.lder lder1 = new android.app.lder(BaseActivity.this);
            lder1.setMessage(val$Message);
            lder1.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                final BaseActivity._cls6 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = BaseActivity._cls6.this;
                super();
            }
            });
            lder1.create().show();
            return;
        }
    }

    _cls2.this._cls1()
    {
        this$0 = final_baseactivity;
        val$tag = s;
        val$Message = String.this;
        super();
    }
}
