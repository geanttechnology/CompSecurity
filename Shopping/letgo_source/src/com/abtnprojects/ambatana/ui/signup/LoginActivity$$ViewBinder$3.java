// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            LoginActivity

class a extends DebouncingOnClickListener
{

    final LoginActivity a;
    final icked b;

    public void doClick(View view)
    {
        a.onSendButtonClicked();
    }

    ( , LoginActivity loginactivity)
    {
        b = ;
        a = loginactivity;
        super();
    }
}
