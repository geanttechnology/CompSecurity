// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            Utils

static class _cls1.val.url
{

    static void executeUrl(String s)
    {
        com.millennialmedia.android.s.execute(new Runnable(s) {

            final String val$url;

            public void run()
            {
                try
                {
                    (new DefaultHttpClient()).execute(new HttpGet(url));
                    MMSDK.Log.d((new StringBuilder()).append("Executed Url :\"").append(url).append("\"").toString());
                    return;
                }
                catch (IOException ioexception)
                {
                    MMSDK.Log.e(ioexception);
                }
            }

            
            {
                url = s;
                super();
            }
        });
    }

    _cls1.val.url()
    {
    }
}
