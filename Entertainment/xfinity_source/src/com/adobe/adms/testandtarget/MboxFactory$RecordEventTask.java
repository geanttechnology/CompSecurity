// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;

import android.util.Log;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.adobe.adms.testandtarget:
//            MboxFactory

private class url
    implements Runnable
{

    final MboxFactory this$0;
    public String url;

    public void run()
    {
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("User-Agent", "Apache-HttpClient (Test&Target Android SDK)");
        if (MboxFactory.access$000(MboxFactory.this) != null)
        {
            httpget.setHeader("Cookie", MboxFactory.access$000(MboxFactory.this));
        }
        try
        {
            defaulthttpclient.execute(httpget);
            MboxFactory.access$100(MboxFactory.this, defaulthttpclient.getCookieStore());
            return;
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            Log.e("MboxFactory", (new StringBuilder()).append("EXCEPTION: ").append(clientprotocolexception.toString()).toString());
            return;
        }
        catch (IOException ioexception)
        {
            Log.e("MboxFactory", (new StringBuilder()).append("EXCEPTION: ").append(ioexception.toString()).toString());
        }
    }

    public (String s)
    {
        this$0 = MboxFactory.this;
        super();
        url = s;
    }
}
