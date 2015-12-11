// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.gotv.crackle.FacebookHelperActivity;
import com.gotv.crackle.base.BaseActivity;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.context
    implements android.view.iewHelper._cls4
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void onClick(View view)
    {
        MyCrackleViewHelper.access$400(MyCrackleViewHelper.this).dismiss();
        view = new Intent(val$context, com/gotv/crackle/FacebookHelperActivity);
        view.putExtra("REQUEST_TYPE", 4);
        val$context.startActivity(view);
    }

    ()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
