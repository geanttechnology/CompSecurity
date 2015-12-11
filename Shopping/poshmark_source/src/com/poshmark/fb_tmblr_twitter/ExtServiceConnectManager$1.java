// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.Bundle;
import com.poshmark.http.api.PMApiError;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            FBConnectCallback, ExtServiceConnectManager, ExtServiceConnectInterface

class val.callback
    implements FBConnectCallback
{

    final ExtServiceConnectManager this$0;
    final ExtServiceConnectInterface val$callback;

    public void error(PMApiError pmapierror)
    {
        val$callback.error(pmapierror);
    }

    public void success(int i, String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", s);
        bundle.putString("EXPIRY_DATE", s1);
        val$callback.success(i, bundle);
    }

    ()
    {
        this$0 = final_extserviceconnectmanager;
        val$callback = ExtServiceConnectInterface.this;
        super();
    }
}
