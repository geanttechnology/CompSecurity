// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.gotv.crackle.helpers.MyCrackleViewHelper;

// Referenced classes of package com.gotv.crackle.base:
//            BaseActivity

class this._cls1
    implements android.content.nClickListener
{

    final  this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.Message()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/base/BaseActivity$6

/* anonymous class */
    class BaseActivity._cls6
        implements Runnable
    {

        final BaseActivity this$0;
        final String val$Message;
        final String val$tag;

        public void run()
        {
            if (tag.equalsIgnoreCase("ForgotPassword"))
            {
                BaseActivity.sMyCrackleHelper.dismissForgotPasswordDialog();
                removeDialogFragment(42340);
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(BaseActivity.this);
                builder.setMessage(Message);
                builder.setPositiveButton("Ok", new BaseActivity._cls6._cls1());
                builder.create().show();
            } else
            if (tag.compareTo("CrackleAccountManager Register") == 0 || tag.compareTo("CrackleAccountManager Sign In") == 0)
            {
                removeDialogFragment(42340);
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(BaseActivity.this);
                builder1.setMessage(Message);
                builder1.setPositiveButton("Ok", new BaseActivity._cls6._cls2());
                builder1.create().show();
                return;
            }
        }

            
            {
                this$0 = final_baseactivity;
                tag = s;
                Message = String.this;
                super();
            }

        // Unreferenced inner class com/gotv/crackle/base/BaseActivity$6$2

/* anonymous class */
        class BaseActivity._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final BaseActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = BaseActivity._cls6.this;
                        super();
                    }
        }

    }

}
