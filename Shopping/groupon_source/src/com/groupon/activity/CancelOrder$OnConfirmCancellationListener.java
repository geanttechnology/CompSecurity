// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            CancelOrder

private class <init>
    implements android.view.istener
{

    final CancelOrder this$0;

    public void onClick(View view)
    {
        int i = reasonsRadioGroup.getCheckedRadioButtonId();
        if (((RadioButton)reasonsRadioGroup.findViewById(i)).getText().equals("Other") && Strings.isEmpty(otherDescription.getText().toString()))
        {
            CancelOrder.access$300(CancelOrder.this);
            return;
        } else
        {
            CancelOrder.access$400(CancelOrder.this);
            return;
        }
    }

    private ()
    {
        this$0 = CancelOrder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
