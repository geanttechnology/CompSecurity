// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.support.v7.aqo;
import com.facebook.f;
import com.facebook.h;
import com.facebook.login.g;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            f, g

class a
    implements f
{

    final com.abtnprojects.ambatana.ui.signup.f a;

    public void a(g g1)
    {
        aqo.a("Facebook login success", new Object[0]);
        f.a(a).a(0);
        a.b();
    }

    public void onCancel()
    {
        aqo.a("Facebook login cancelled", new Object[0]);
    }

    public void onError(h h)
    {
        aqo.a("Facebook login error", new Object[0]);
        f.a(a).m();
    }

    public void onSuccess(Object obj)
    {
        a((g)obj);
    }

    (com.abtnprojects.ambatana.ui.signup.f f1)
    {
        a = f1;
        super();
    }
}
