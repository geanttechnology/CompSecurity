// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.groupon.view:
//            ClearableEditText

class this._cls0
    implements android.view.
{

    final ClearableEditText this$0;

    public void onClick(View view)
    {
        ClearableEditText.access$000(ClearableEditText.this).setText("");
        ClearableEditText.access$000(ClearableEditText.this).requestFocus();
    }

    ()
    {
        this$0 = ClearableEditText.this;
        super();
    }
}
