// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            SignUpActivity

class a
    implements android.widget.er
{

    final SignUpActivity a;
    final ssword b;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return a.onFinishEditPassword(i);
    }

    ( , SignUpActivity signupactivity)
    {
        b = ;
        a = signupactivity;
        super();
    }
}
