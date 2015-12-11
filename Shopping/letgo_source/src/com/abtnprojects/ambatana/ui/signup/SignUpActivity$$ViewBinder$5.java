// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            SignUpActivity

class a extends DebouncingOnClickListener
{

    final SignUpActivity a;
    final cked b;

    public void doClick(View view)
    {
        a.onUserImageClicked();
    }

    ( , SignUpActivity signupactivity)
    {
        b = ;
        a = signupactivity;
        super();
    }
}
