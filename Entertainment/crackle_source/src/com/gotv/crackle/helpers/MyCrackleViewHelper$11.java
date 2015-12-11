// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.context
    implements android.view.ewHelper._cls11
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void onClick(View view)
    {
        MyCrackleViewHelper.access$1400(MyCrackleViewHelper.this).verifyUserLogin(val$context, MyCrackleViewHelper.access$1000(MyCrackleViewHelper.this).getText().toString(), MyCrackleViewHelper.access$800(MyCrackleViewHelper.this).getText().toString());
        MyCrackleViewHelper.access$1800(MyCrackleViewHelper.this).dismiss();
        MyCrackleViewHelper.access$400(MyCrackleViewHelper.this).dismiss();
        Toast.makeText(val$context.getApplicationContext(), val$context.getString(0x7f0b0118), 0).show();
    }

    ()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
