// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            Gifting

private class <init>
    implements TextWatcher
{

    final Gifting this$0;

    public void afterTextChanged(Editable editable)
    {
        messageCount.setText(getString(0x7f0800ae, new Object[] {
            Integer.valueOf(220 - message1510.length())
        }));
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = Gifting.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
