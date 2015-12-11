// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.now.web:
//            AuthenticatedWebActivity

class val.url
    implements Callback
{

    final AuthenticatedWebActivity this$0;
    final String val$url;

    public void onError(Bundle bundle)
    {
    }

    public void onSuccess(Bundle bundle)
    {
        authenticate(val$url);
    }

    ()
    {
        this$0 = final_authenticatedwebactivity;
        val$url = String.this;
        super();
    }
}
