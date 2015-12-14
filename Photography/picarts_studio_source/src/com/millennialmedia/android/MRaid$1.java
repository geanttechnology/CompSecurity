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
//            MRaid, MMLog

final class b
    implements Runnable
{

    private String a;
    private Context b;

    public final void run()
    {
        MMLog.d("MRaid", (new StringBuilder("MMJS -  download start (")).append(a).append(")").toString());
        Object obj = new HttpGet(a);
        obj = (new DefaultHttpClient()).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        MMLog.d("MRaid", (new StringBuilder("MMJS -  download finish (")).append(a).append(")").toString());
        if (MRaid.a(b, ((HttpResponse) (obj)).getEntity().getContent()) && MRaid.c(b, a))
        {
            MMLog.d("MRaid", (new StringBuilder("MMJS -  download saved (")).append(a).append(")").toString());
        }
        return;
        Object obj1;
        obj1;
        MMLog.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
        return;
        obj1;
        throw obj1;
        obj1;
        MMLog.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
        return;
        obj1;
        MMLog.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
        return;
    }

    ttpClient(String s, Context context)
    {
        a = s;
        b = context;
        super();
    }
}
