// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchBase

class this._cls0
    implements android.widget.tionListener
{

    final GlobalSearchBase this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 3)
        {
            textSearchEditText.clearFocus();
            onSearchExecuted(textSearchEditText.getText().toString());
            return true;
        } else
        {
            return false;
        }
    }

    stener()
    {
        this$0 = GlobalSearchBase.this;
        super();
    }
}
