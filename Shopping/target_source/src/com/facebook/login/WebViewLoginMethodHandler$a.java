// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.q;

// Referenced classes of package com.facebook.login:
//            WebViewLoginMethodHandler

static class  extends com.facebook.internal.
{

    private String a;
    private boolean b;

    public q a()
    {
        Bundle bundle = e();
        bundle.putString("redirect_uri", "fbconnect://success");
        bundle.putString("client_id", b());
        bundle.putString("e2e", a);
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        if (b)
        {
            bundle.putString("auth_type", "rerequest");
        }
        return new q(c(), "oauth", bundle, d(), f());
    }

    public f a(String s)
    {
        a = s;
        return this;
    }

    public a a(boolean flag)
    {
        b = flag;
        return this;
    }

    public (Context context, String s, Bundle bundle)
    {
        super(context, s, "oauth", bundle);
    }
}
