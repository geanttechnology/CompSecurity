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

class this._cls1
    implements android.content.istener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.newsletterCheckBox()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$8

/* anonymous class */
    class MyCrackleViewHelper._cls8
        implements android.view.View.OnClickListener
    {

        final MyCrackleViewHelper this$0;
        final BaseActivity val$context;
        final CheckBox val$newsletterCheckBox;

        public void onClick(View view)
        {
            if (MyCrackleViewHelper.access$800(MyCrackleViewHelper.this).getText().toString().compareTo(MyCrackleViewHelper.access$700(MyCrackleViewHelper.this).getText().toString()) != 0)
            {
                view = new android.app.AlertDialog.Builder(context);
                view.setMessage(context.getResources().getString(0x7f0b0085));
                view.setPositiveButton("Ok", new MyCrackleViewHelper._cls8._cls1());
                view.create().show();
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
            MyCrackleViewHelper.access$1400(MyCrackleViewHelper.this).createAccount(context, null, MyCrackleViewHelper.access$1000(MyCrackleViewHelper.this).getText().toString(), (new StringBuilder()).append(MyCrackleViewHelper.access$1100(MyCrackleViewHelper.this).getText().toString()).append(" ").append(MyCrackleViewHelper.access$1200(MyCrackleViewHelper.this).getText().toString()).toString(), MyCrackleViewHelper.access$800(MyCrackleViewHelper.this).getText().toString(), Integer.valueOf(i), (new StringBuilder()).append("").append(MyCrackleViewHelper.access$500(MyCrackleViewHelper.this).getTime() / 1000L).toString(), Boolean.valueOf(newsletterCheckBox.isChecked()), Boolean.valueOf(MyCrackleViewHelper.access$1300(MyCrackleViewHelper.this).isChecked()), null, null);
            MyCrackleViewHelper.access$1500(MyCrackleViewHelper.this).dismiss();
            MyCrackleViewHelper.access$400(MyCrackleViewHelper.this).dismiss();
            Toast.makeText(context.getApplicationContext(), context.getString(0x7f0b0117), 1).show();
        }

            
            {
                this$0 = final_mycrackleviewhelper;
                context = baseactivity;
                newsletterCheckBox = CheckBox.this;
                super();
            }
    }

}
