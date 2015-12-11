// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.voice;

import android.content.Context;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.now.account.SSO;
import com.amazon.now.account.User;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.shopapp.voice.module.CustomerProvider;

// Referenced classes of package com.amazon.now.voice:
//            VoiceSearchInitializer

private static class <init>
    implements CustomerProvider
{

    public String getDeviceId()
    {
        if (User.isSignedIn())
        {
            return AndroidPlatform.getInstance().getDeviceId();
        } else
        {
            return null;
        }
    }

    public String getDirectedId(Context context)
    {
        return SSO.getMAPAccountManager().getAccount();
    }

    public String getSessionId()
    {
        if (User.isSignedIn())
        {
            return AndroidPlatform.getInstance().getSessionId();
        } else
        {
            return null;
        }
    }

    private A()
    {
    }

    A(A a)
    {
        this();
    }
}
