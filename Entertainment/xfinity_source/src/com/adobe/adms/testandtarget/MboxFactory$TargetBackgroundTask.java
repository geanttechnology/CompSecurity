// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.adobe.adms.testandtarget:
//            MboxFactory, Mbox

private class callback
    implements Runnable
{

    public callback callback;
    final MboxFactory this$0;
    public String url;

    public void run()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        DefaultHttpClient defaulthttpclient;
        Object obj9;
        defaulthttpclient = new DefaultHttpClient();
        obj9 = new HttpGet(url);
        ((HttpGet) (obj9)).setHeader("User-Agent", "Apache-HttpClient (Test&Target Android SDK)");
        if (MboxFactory.access$000(MboxFactory.this) != null)
        {
            ((HttpGet) (obj9)).setHeader("Cookie", MboxFactory.access$000(MboxFactory.this));
        }
        obj7 = null;
        obj8 = null;
        obj = null;
        obj5 = null;
        obj6 = null;
        obj4 = null;
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        obj9 = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj9)));
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        int i = ((HttpResponse) (obj9)).getStatusLine().getStatusCode();
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        String s = ((HttpResponse) (obj9)).getFirstHeader("Content-Type").getValue();
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        MboxFactory.access$100(MboxFactory.this, defaulthttpclient.getCookieStore());
        if (i != 200) goto _L2; else goto _L1
_L1:
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        if (!s.equals("image/gif")) goto _L3; else goto _L2
_L2:
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        callback.callback("/images/log.gif");
        obj1 = obj4;
_L7:
        Exception exception1;
        try
        {
            ((InputStream) (obj)).close();
            ((ByteArrayOutputStream) (obj1)).close();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
_L3:
        obj2 = obj6;
        obj1 = obj7;
        obj3 = obj8;
        obj = ((HttpResponse) (obj9)).getEntity().getContent();
        obj2 = obj6;
        obj1 = obj;
        obj3 = obj;
        obj4 = new ByteArrayOutputStream();
        obj1 = new byte[512];
_L6:
        i = ((InputStream) (obj)).read(((byte []) (obj1)));
        if (i == -1) goto _L5; else goto _L4
_L4:
        ((ByteArrayOutputStream) (obj4)).write(((byte []) (obj1)), 0, i);
          goto _L6
        obj2;
        obj1 = obj4;
        obj3 = obj;
        obj4 = obj2;
        obj = obj1;
_L10:
        obj2 = obj;
        obj1 = obj3;
        Log.e("MboxFactory", (new StringBuilder()).append("ERROR: ").append(((IOException) (obj4)).toString()).toString());
        obj2 = obj;
        obj1 = obj3;
        callback.callback("/images/log.gif");
        try
        {
            ((InputStream) (obj3)).close();
            ((ByteArrayOutputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
_L5:
        callback.callback(new String(((ByteArrayOutputStream) (obj4)).toByteArray(), "UTF-8"));
        obj1 = obj4;
          goto _L7
        obj;
_L9:
        try
        {
            ((InputStream) (obj1)).close();
            ((ByteArrayOutputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        throw obj;
        exception1;
        obj2 = obj4;
        obj1 = obj;
        obj = exception1;
        if (true) goto _L9; else goto _L8
_L8:
        obj4;
        obj = obj5;
          goto _L10
    }

    public (Mbox mbox, String s,  )
    {
        this$0 = MboxFactory.this;
        super();
        url = s;
        callback = ;
    }
}
