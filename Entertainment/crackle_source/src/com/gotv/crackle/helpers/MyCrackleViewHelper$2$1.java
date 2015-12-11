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

class this._cls1
    implements android.view.wHelper._cls2._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        view = ((LayoutInflater)MyCrackleViewHelper.access$100(_fld0).getSystemService("layout_inflater")).inflate(0x7f030061, null);
        MyCrackleViewHelper.access$300(_fld0, MyCrackleViewHelper.access$100(_fld0), view);
        MyCrackleViewHelper.access$402(_fld0, new Dialog(MyCrackleViewHelper.access$100(_fld0)));
        ((TextView)MyCrackleViewHelper.access$400(_fld0).findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
        MyCrackleViewHelper.access$400(_fld0).setContentView(view);
        MyCrackleViewHelper.access$400(_fld0).setTitle(MyCrackleViewHelper.access$100(_fld0).getResources().getString(0x7f0b0081));
        MyCrackleViewHelper.access$400(_fld0).setCanceledOnTouchOutside(true);
        MyCrackleViewHelper.access$400(_fld0).show();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$2

/* anonymous class */
    class MyCrackleViewHelper._cls2
        implements android.view.View.OnClickListener
    {

        final MyCrackleViewHelper this$0;

        public void onClick(View view)
        {
            CrackleAccountManager.logOut();
            MyCrackleViewHelper.access$200(MyCrackleViewHelper.this).setText(MyCrackleViewHelper.access$100(MyCrackleViewHelper.this).getResources().getString(0x7f0b0065));
            MyCrackleViewHelper.access$200(MyCrackleViewHelper.this).setOnClickListener(new MyCrackleViewHelper._cls2._cls1());
        }

            
            {
                this$0 = MyCrackleViewHelper.this;
                super();
            }
    }

}
