// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.groupon.view:
//            ActionBarClearableEditText

class this._cls0
    implements android.view.t._cls1
{

    final ActionBarClearableEditText this$0;

    public void onClick(View view)
    {
        ActionBarClearableEditText.access$000(ActionBarClearableEditText.this).setText("");
        ActionBarClearableEditText.access$000(ActionBarClearableEditText.this).requestFocus();
    }

    ()
    {
        this$0 = ActionBarClearableEditText.this;
        super();
    }
}
