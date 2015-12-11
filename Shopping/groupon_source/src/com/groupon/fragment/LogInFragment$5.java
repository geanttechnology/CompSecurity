// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.KeyEvent;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

class this._cls0
    implements android.widget.rActionListener
{

    final LogInFragment this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            submit.performClick();
        }
        return false;
    }

    nListener()
    {
        this$0 = LogInFragment.this;
        super();
    }
}
