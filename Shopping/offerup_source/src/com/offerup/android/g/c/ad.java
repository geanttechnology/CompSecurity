// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import com.b.a.a.g;
import com.b.a.a.j;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import java.util.Set;

// Referenced classes of package com.offerup.android.g.c:
//            z

final class ad
    implements FacebookCallback
{

    private z a;

    private ad(z z)
    {
        a = z;
        super();
    }

    ad(z z, byte byte0)
    {
        this(z);
    }

    public final void onCancel()
    {
    }

    public final void onError(FacebookException facebookexception)
    {
        g.a(a, facebookexception);
    }

    public final void onSuccess(Object obj)
    {
        obj = (LoginResult)obj;
        if (((LoginResult) (obj)).getAccessToken() != null)
        {
            obj = ((LoginResult) (obj)).getAccessToken();
            Set set = ((AccessToken) (obj)).getPermissions();
            j.a().f(((AccessToken) (obj)).getToken());
            if (set.contains("publish_actions"))
            {
                g.a(a, "Have FB pub permission");
                return;
            } else
            {
                g.a(a, "Missing FB pub permission");
                return;
            }
        } else
        {
            g.a(this, new Throwable("Unable to retrieve facebook access token"));
            return;
        }
    }
}
