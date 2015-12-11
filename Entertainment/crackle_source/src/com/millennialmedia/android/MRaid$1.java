// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            MRaid

static final class val.context
    implements Runnable
{

    final Context val$context;
    final String val$url;

    public void run()
    {
        Object obj = new HttpGet(val$url);
        obj = (new DefaultHttpClient()).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        if (MRaid.saveMRaid(val$context, ((HttpResponse) (obj)).getEntity().getContent()))
        {
            MRaid.storeMraidUrl(val$context, val$url);
        }
        return;
        Object obj1;
        obj1;
        ((MalformedURLException) (obj1)).printStackTrace();
        return;
        obj1;
        throw obj1;
        obj1;
        ((IllegalStateException) (obj1)).printStackTrace();
        return;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        return;
    }

    ttpClient(String s, Context context1)
    {
        val$url = s;
        val$context = context1;
        super();
    }
}
