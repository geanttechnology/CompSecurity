// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.KeyEvent;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment

class this._cls0
    implements android.widget.ActionListener
{

    final SignUpFragment this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            submit.performClick();
        }
        return false;
    }

    Listener()
    {
        this$0 = SignUpFragment.this;
        super();
    }
}
