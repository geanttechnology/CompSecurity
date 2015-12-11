// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import android.content.Context;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.shopapp.voice.module.CustomerProvider;

// Referenced classes of package com.amazon.mShop.voice:
//            VoiceSearchInitializer

public class this._cls0
    implements CustomerProvider
{

    final VoiceSearchInitializer this$0;

    public String getDeviceId()
    {
        return AndroidPlatform.getInstance().getDeviceId();
    }

    public String getDirectedId(Context context)
    {
        return SSOUtil.getCurrentAccount(context);
    }

    public String getSessionId()
    {
        return CookieBridge.getCurrentSessionId();
    }

    public ()
    {
        this$0 = VoiceSearchInitializer.this;
        super();
    }
}
