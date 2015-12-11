// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;

// Referenced classes of package com.groupon.activity:
//            CancelOrder

private class <init>
    implements android.widget.tener
{

    final CancelOrder this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        compoundbutton = (InputMethodManager)getSystemService("input_method");
        if (flag)
        {
            otherDescription.setVisibility(0);
            otherDescription.requestFocus();
            compoundbutton.showSoftInput(otherDescription, 0);
            return;
        } else
        {
            otherDescription.setVisibility(8);
            compoundbutton.hideSoftInputFromWindow(otherDescription.getWindowToken(), 0);
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
