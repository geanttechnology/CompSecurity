// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.now.account.SSO;

// Referenced classes of package com.amazon.now.web:
//            WebActivity

public abstract class AuthenticatedWebActivity extends WebActivity
{

    private boolean shouldCheckAuth;

    public AuthenticatedWebActivity()
    {
        shouldCheckAuth = false;
    }

    private void auth(final String url)
    {
        if (!SSO.syncCookies(true, new Callback() {

        final AuthenticatedWebActivity this$0;
        final String val$url;

        public void onError(Bundle bundle)
        {
        }

        public void onSuccess(Bundle bundle)
        {
            authenticate(url);
        }

            
            {
                this$0 = AuthenticatedWebActivity.this;
                url = s;
                super();
            }
    }))
        {
            authenticate(url);
        }
    }

    public void onCreate(Bundle bundle)
    {
        getIntent().putExtra("intentDeferLoadKey", true);
        super.onCreate(bundle);
        auth(getLaunchUrl());
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        auth(getLaunchUrl());
    }

    public void onResume()
    {
        super.onResume();
        if (shouldCheckAuth)
        {
            auth(null);
        }
        shouldCheckAuth = true;
    }
}
