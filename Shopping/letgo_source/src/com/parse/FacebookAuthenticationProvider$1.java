// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.facebook.f;
import com.facebook.h;
import com.facebook.login.g;

// Referenced classes of package com.parse:
//            FacebookAuthenticationProvider

class val.tcs
    implements f
{

    final FacebookAuthenticationProvider this$0;
    final android.support.v7. val$tcs;

    public void onCancel()
    {
        val$tcs._mth1();
    }

    public void onError(h h)
    {
        val$tcs._mth1(h);
    }

    public void onSuccess(g g1)
    {
        g1 = g1.a();
        g1 = getAuthData(g1);
        val$tcs.(g1);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((g)obj);
    }

    ()
    {
        this$0 = final_facebookauthenticationprovider;
        val$tcs = android.support.v7._cls1.this;
        super();
    }
}
