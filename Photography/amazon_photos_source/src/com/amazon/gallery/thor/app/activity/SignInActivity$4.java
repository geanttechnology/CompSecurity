// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SignInActivity

class this._cls0
    implements android.widget.ActionListener
{

    final SignInActivity this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            SignInActivity.access$000(SignInActivity.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = SignInActivity.this;
        super();
    }
}
