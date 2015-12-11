// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import java.util.Date;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.newsletterCheckBox
    implements android.view.iewHelper._cls8
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;
    final CheckBox val$newsletterCheckBox;

    public void onClick(View view)
    {
        if (MyCrackleViewHelper.access$800(MyCrackleViewHelper.this).getText().toString().compareTo(MyCrackleViewHelper.access$700(MyCrackleViewHelper.this).getText().toString()) != 0)
        {
            view = new android.app.nit>(val$context);
            view.tMessage(val$context.getResources().getString(0x7f0b0085));
            view.tPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                final MyCrackleViewHelper._cls8 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = MyCrackleViewHelper._cls8.this;
                super();
            }
            });
            view.eate().show();
            return;
        }
        int i;
        if (MyCrackleViewHelper.access$900(MyCrackleViewHelper.this).isChecked())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        MyCrackleViewHelper.access$1400(MyCrackleViewHelper.this).createAccount(val$context, null, MyCrackleViewHelper.access$1000(MyCrackleViewHelper.this).getText().toString(), (new StringBuilder()).append(MyCrackleViewHelper.access$1100(MyCrackleViewHelper.this).getText().toString()).append(" ").append(MyCrackleViewHelper.access$1200(MyCrackleViewHelper.this).getText().toString()).toString(), MyCrackleViewHelper.access$800(MyCrackleViewHelper.this).getText().toString(), Integer.valueOf(i), (new StringBuilder()).append("").append(MyCrackleViewHelper.access$500(MyCrackleViewHelper.this).getTime() / 1000L).toString(), Boolean.valueOf(val$newsletterCheckBox.isChecked()), Boolean.valueOf(MyCrackleViewHelper.access$1300(MyCrackleViewHelper.this).isChecked()), null, null);
        MyCrackleViewHelper.access$1500(MyCrackleViewHelper.this).dismiss();
        MyCrackleViewHelper.access$400(MyCrackleViewHelper.this).dismiss();
        Toast.makeText(val$context.getApplicationContext(), val$context.getString(0x7f0b0117), 1).show();
    }

    _cls1.this._cls1()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = baseactivity;
        val$newsletterCheckBox = CheckBox.this;
        super();
    }
}
