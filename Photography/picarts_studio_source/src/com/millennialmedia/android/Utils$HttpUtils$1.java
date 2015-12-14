// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            MMLog

final class a
    implements Runnable
{

    private String a;

    public final void run()
    {
        try
        {
            (new DefaultHttpClient()).execute(new HttpGet(a));
            MMLog.b("Utils", (new StringBuilder("Executed Url :\"")).append(a).append("\"").toString());
            return;
        }
        catch (IOException ioexception)
        {
            MMLog.a("Utils", "Exception with HttpUtils: ", ioexception);
        }
    }

    (String s)
    {
        a = s;
        super();
    }
}
