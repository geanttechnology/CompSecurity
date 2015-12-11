// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

class val.buttonNum
    implements android.view.n.CALDialogFragment._cls14
{

    final CALDialogFragment this$0;
    final Button val$button;
    final int val$buttonNum;

    public void onClick(View view)
    {
        if (val$button.onClickListener != null)
        {
            val$button.onClickListener.onClick(getDialog(), val$buttonNum);
        }
        dismiss();
    }

    Button()
    {
        this$0 = final_caldialogfragment;
        val$button = button1;
        val$buttonNum = I.this;
        super();
    }
}
