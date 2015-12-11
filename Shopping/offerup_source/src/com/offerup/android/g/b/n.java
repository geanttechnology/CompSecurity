// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.view.View;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.v;

// Referenced classes of package com.offerup.android.g.b:
//            k, v

final class n
    implements android.view.View.OnClickListener
{

    private k a;

    n(k k1)
    {
        a = k1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("SignupLogin_Facebook-Button_click");
        com.offerup.android.g.b.k.a(a).setReadPermissions(v.b);
        LoginManager.getInstance().registerCallback(k.b(a), new com.offerup.android.g.b.v(a, (byte)0));
    }
}
