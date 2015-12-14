// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.facebook:
//            Settings, Response

final class val.callback
    implements Runnable
{

    final Context val$applicationContext;
    final String val$applicationId;
    final lback val$callback;

    public void run()
    {
        final Response response = Settings.publishInstallAndWaitForResponse(val$applicationContext, val$applicationId, false);
        if (val$callback != null)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final Settings._cls2 this$0;
                final Response val$response;

                public void run()
                {
                    callback.onCompleted(response);
                }

            
            {
                this$0 = Settings._cls2.this;
                response = response1;
                super();
            }
            });
        }
    }

    lback()
    {
        val$applicationContext = context;
        val$applicationId = s;
        val$callback = lback;
        super();
    }
}
