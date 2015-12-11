// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class this._cls0
    implements android.view.iewHelper._cls2
{

    final MyCrackleViewHelper this$0;

    public void onClick(View view)
    {
        CrackleAccountManager.logOut();
        MyCrackleViewHelper.access$200(MyCrackleViewHelper.this).setText(MyCrackleViewHelper.access$100(MyCrackleViewHelper.this).getResources().getString(0x7f0b0065));
        MyCrackleViewHelper.access$200(MyCrackleViewHelper.this).setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper._cls2 this$1;

            public void onClick(View view1)
            {
                view1 = ((LayoutInflater)MyCrackleViewHelper.access$100(this$0).getSystemService("layout_inflater")).inflate(0x7f030061, null);
                MyCrackleViewHelper.access$300(this$0, MyCrackleViewHelper.access$100(this$0), view1);
                MyCrackleViewHelper.access$402(this$0, new Dialog(MyCrackleViewHelper.access$100(this$0)));
                ((TextView)MyCrackleViewHelper.access$400(this$0).findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
                MyCrackleViewHelper.access$400(this$0).setContentView(view1);
                MyCrackleViewHelper.access$400(this$0).setTitle(MyCrackleViewHelper.access$100(this$0).getResources().getString(0x7f0b0081));
                MyCrackleViewHelper.access$400(this$0).setCanceledOnTouchOutside(true);
                MyCrackleViewHelper.access$400(this$0).show();
            }

            
            {
                this$1 = MyCrackleViewHelper._cls2.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = MyCrackleViewHelper.this;
        super();
    }
}
