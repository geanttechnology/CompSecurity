// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import com.gotv.crackle.data.CrackleAccountManager;
import java.util.Date;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class this._cls1
    implements android.content.ner
{

    final er this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.newsletterCheckBox()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/FacebookHelperActivity$11

/* anonymous class */
    class FacebookHelperActivity._cls11
        implements android.view.View.OnClickListener
    {

        final FacebookHelperActivity this$0;
        final CheckBox val$newsletterCheckBox;

        public void onClick(View view)
        {
            if (FacebookHelperActivity.access$900(FacebookHelperActivity.this).getText().toString().compareTo(FacebookHelperActivity.access$800(FacebookHelperActivity.this).getText().toString()) != 0)
            {
                view = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
                view.setMessage(getResources().getString(0x7f0b0085));
                view.setPositiveButton("Ok", new FacebookHelperActivity._cls11._cls1());
                view.create().show();
                return;
            }
            if (!FacebookHelperActivity.access$1000(FacebookHelperActivity.this).isChecked())
            {
                view = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
                view.setMessage(getResources().getString(0x7f0b0090));
                view.setPositiveButton("Ok", new FacebookHelperActivity._cls11._cls2());
                view.create().show();
                return;
            }
            showDialog(42340);
            int i;
            if (FacebookHelperActivity.access$1100(FacebookHelperActivity.this).isChecked())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            FacebookHelperActivity.access$1500(FacebookHelperActivity.this).createAccount(FacebookHelperActivity.this, null, FacebookHelperActivity.access$1200(FacebookHelperActivity.this).getText().toString(), (new StringBuilder()).append(FacebookHelperActivity.access$1300(FacebookHelperActivity.this).getText().toString()).append(" ").append(FacebookHelperActivity.access$1400(FacebookHelperActivity.this).getText().toString()).toString(), FacebookHelperActivity.access$900(FacebookHelperActivity.this).getText().toString(), Integer.valueOf(i), (new StringBuilder()).append("").append(FacebookHelperActivity.access$500(FacebookHelperActivity.this).getTime() / 1000L).toString(), Boolean.valueOf(newsletterCheckBox.isChecked()), Boolean.valueOf(FacebookHelperActivity.access$1000(FacebookHelperActivity.this).isChecked()), null, null);
            finish();
        }

            
            {
                this$0 = final_facebookhelperactivity;
                newsletterCheckBox = CheckBox.this;
                super();
            }

        // Unreferenced inner class com/gotv/crackle/FacebookHelperActivity$11$1

/* anonymous class */
        class FacebookHelperActivity._cls11._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FacebookHelperActivity._cls11 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = FacebookHelperActivity._cls11.this;
                        super();
                    }
        }

    }

}
