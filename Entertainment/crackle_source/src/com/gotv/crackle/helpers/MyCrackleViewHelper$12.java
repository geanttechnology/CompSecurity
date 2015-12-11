// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.context
    implements android.view.ewHelper._cls12
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void onClick(View view)
    {
        MyCrackleViewHelper.access$1902(MyCrackleViewHelper.this, new Dialog(val$context));
        view = ((LayoutInflater)val$context.getSystemService("layout_inflater")).inflate(0x7f03005d, null);
        MyCrackleViewHelper.access$1900(MyCrackleViewHelper.this).setContentView(view);
        MyCrackleViewHelper.access$1900(MyCrackleViewHelper.this).setTitle(val$context.getString(0x7f0b0062));
        MyCrackleViewHelper.access$2002(MyCrackleViewHelper.this, (EditText)view.findViewById(0x7f0a0125));
        MyCrackleViewHelper.access$2000(MyCrackleViewHelper.this).addTextChangedListener(MyCrackleViewHelper.access$2100(MyCrackleViewHelper.this));
        MyCrackleViewHelper.access$2202(MyCrackleViewHelper.this, (Button)view.findViewById(0x7f0a0126));
        MyCrackleViewHelper.access$2200(MyCrackleViewHelper.this).setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper._cls12 this$1;

            public void onClick(View view1)
            {
                context.showDialogFragment(42340);
                view1 = MyCrackleViewHelper.access$2000(this$0).getText().toString().trim();
                if (view1.contains(" "))
                {
                    view1.replace(" ", "");
                    return;
                } else
                {
                    MyCrackleViewHelper.access$1400(this$0).forgotPassword(context, view1);
                    return;
                }
            }

            
            {
                this$1 = MyCrackleViewHelper._cls12.this;
                super();
            }
        });
        MyCrackleViewHelper.access$1900(MyCrackleViewHelper.this).setCanceledOnTouchOutside(true);
        MyCrackleViewHelper.access$1900(MyCrackleViewHelper.this).show();
    }

    _cls1.this._cls1()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
