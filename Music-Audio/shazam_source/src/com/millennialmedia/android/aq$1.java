// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            aq, al

static final class b
    implements Runnable
{

    final String a;
    final Context b;

    public final void run()
    {
        (new StringBuilder("MMJS -  download start (")).append(a).append(")");
        al.d();
        Object obj = new HttpGet(a);
        obj = (new DefaultHttpClient()).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        (new StringBuilder("MMJS -  download finish (")).append(a).append(")");
        al.d();
        if (aq.a(b, ((HttpResponse) (obj)).getEntity().getContent()) && aq.a(b, a))
        {
            (new StringBuilder("MMJS -  download saved (")).append(a).append(")");
            al.d();
        }
        if (aq.a == null) goto _L2; else goto _L1
_L1:
        WeakReference weakreference = aq.a;
_L7:
        weakreference.get();
_L2:
        return;
        Object obj1;
        obj1;
        al.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
        if (aq.a == null) goto _L2; else goto _L3
_L3:
        obj1 = aq.a;
        continue; /* Loop/switch isn't completed */
        obj1;
        al.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
        if (aq.a == null) goto _L2; else goto _L4
_L4:
        obj1 = aq.a;
        continue; /* Loop/switch isn't completed */
        obj1;
        al.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
        if (aq.a == null) goto _L2; else goto _L5
_L5:
        obj1 = aq.a;
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        if (aq.a != null)
        {
            aq.a.get();
        }
        throw obj1;
    }

    ltHttpClient(String s, Context context)
    {
        a = s;
        b = context;
        super();
    }
}
