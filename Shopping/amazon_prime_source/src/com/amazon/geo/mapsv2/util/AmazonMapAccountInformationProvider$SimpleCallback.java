// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapAccountInformationProvider

public static abstract class _cls1.val.succeeded
    implements Callback
{

    public void onError(Bundle bundle)
    {
        onFinished(bundle, false);
    }

    protected void onFinished(final Bundle bundle, final boolean succeeded)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final AmazonMapAccountInformationProvider.SimpleCallback this$0;
            final Bundle val$bundle;
            final boolean val$succeeded;

            public void run()
            {
                onFinishedMainThread(bundle, succeeded);
            }

            
            {
                this$0 = AmazonMapAccountInformationProvider.SimpleCallback.this;
                bundle = bundle1;
                succeeded = flag;
                super();
            }
        });
    }

    protected void onFinishedMainThread(Bundle bundle, boolean flag)
    {
    }

    public void onSuccess(Bundle bundle)
    {
        onFinished(bundle, true);
    }

    public _cls1.val.succeeded()
    {
    }
}
