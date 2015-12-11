// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.amazon.now.web.NowWebFragment;

// Referenced classes of package com.amazon.now.debug:
//            DebugWebActivity

class this._cls0
    implements android.view.r
{

    final DebugWebActivity this$0;

    public void onClick(View view)
    {
        view = (EditText)findViewById(0x7f0e0034);
        String s = view.getText().toString();
        if (s != null)
        {
            DebugWebActivity.access$000(DebugWebActivity.this).loadUrl(s);
        }
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    ger()
    {
        this$0 = DebugWebActivity.this;
        super();
    }
}
