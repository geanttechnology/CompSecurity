// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.view.View;

// Referenced classes of package com.facebook.login:
//            LoginFragment

class a
    implements a
{

    final View a;
    final LoginFragment b;

    public void a()
    {
        a.findViewById(com.facebook._login_activity_progress_bar).setVisibility(0);
    }

    public void b()
    {
        a.findViewById(com.facebook._login_activity_progress_bar).setVisibility(8);
    }

    (LoginFragment loginfragment, View view)
    {
        b = loginfragment;
        a = view;
        super();
    }
}
