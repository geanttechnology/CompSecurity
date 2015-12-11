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

class val.newsletterCheckBox
    implements android.view.._cls11
{

    final FacebookHelperActivity this$0;
    final CheckBox val$newsletterCheckBox;

    public void onClick(View view)
    {
        if (FacebookHelperActivity.access$900(FacebookHelperActivity.this).getText().toString().compareTo(FacebookHelperActivity.access$800(FacebookHelperActivity.this).getText().toString()) != 0)
        {
            view = new android.app.(FacebookHelperActivity.this);
            view.sage(getResources().getString(0x7f0b0085));
            view.itiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                final FacebookHelperActivity._cls11 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = FacebookHelperActivity._cls11.this;
                super();
            }
            });
            view.().show();
            return;
        }
        if (!FacebookHelperActivity.access$1000(FacebookHelperActivity.this).isChecked())
        {
            view = new android.app.(FacebookHelperActivity.this);
            view.sage(getResources().getString(0x7f0b0090));
            view.itiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                final FacebookHelperActivity._cls11 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = FacebookHelperActivity._cls11.this;
                super();
            }
            });
            view.().show();
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
        FacebookHelperActivity.access$1500(FacebookHelperActivity.this).createAccount(FacebookHelperActivity.this, null, FacebookHelperActivity.access$1200(FacebookHelperActivity.this).getText().toString(), (new StringBuilder()).append(FacebookHelperActivity.access$1300(FacebookHelperActivity.this).getText().toString()).append(" ").append(FacebookHelperActivity.access$1400(FacebookHelperActivity.this).getText().toString()).toString(), FacebookHelperActivity.access$900(FacebookHelperActivity.this).getText().toString(), Integer.valueOf(i), (new StringBuilder()).append("").append(FacebookHelperActivity.access$500(FacebookHelperActivity.this).getTime() / 1000L).toString(), Boolean.valueOf(val$newsletterCheckBox.isChecked()), Boolean.valueOf(FacebookHelperActivity.access$1000(FacebookHelperActivity.this).isChecked()), null, null);
        finish();
    }

    _cls2.this._cls1()
    {
        this$0 = final_facebookhelperactivity;
        val$newsletterCheckBox = CheckBox.this;
        super();
    }
}
