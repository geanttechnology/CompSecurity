// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.e;

import android.content.Context;
import com.facebook.ads.a.c.e;
import com.facebook.ads.a.c.f;
import com.facebook.ads.a.d.a;
import com.facebook.ads.a.d.b;
import com.facebook.ads.a.d.d;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package com.facebook.ads.a.e:
//            b

public final class b
    implements Runnable
{

    final Context a;
    final e b;
    final com.facebook.ads.a.e.b c;

    public final void run()
    {
        f.b(a);
        c.a = b.c();
        Object obj;
        Object obj1;
        a a1;
        Object obj2;
        Object obj3;
        try
        {
            com.facebook.ads.a.e.b.a(c, new a(a, b.e));
            a1 = com.facebook.ads.a.e.b.c(c);
            obj2 = com.facebook.ads.a.e.b.a(c);
            obj1 = new d(c.a);
            obj = com.facebook.ads.a.e.b.b(c);
            obj3 = ((d) (obj1)).a();
            obj1 = a1.b;
            obj2 = new HttpPost(((String) (obj2)));
        }
        catch (Exception exception)
        {
            com.facebook.ads.a.e.b.a(c, com.facebook.ads.a.a.i.a(exception.getMessage()));
            return;
        }
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        ((HttpEntityEnclosingRequestBase) (obj2)).setEntity(((org.apache.http.HttpEntity) (obj3)));
        obj3 = new SyncBasicHttpContext(new BasicHttpContext());
        obj2 = a.a.submit(new b(((org.apache.http.impl.client.AbstractHttpClient) (obj1)), ((org.apache.http.protocol.HttpContext) (obj3)), ((org.apache.http.client.methods.HttpUriRequest) (obj2)), ((com.facebook.ads.a.d.c) (obj))));
        obj1 = (List)a1.c.get(a1.d);
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        obj = new LinkedList();
        a1.c.put(a1.d, obj);
        ((List) (obj)).add(new WeakReference(obj2));
        return;
    }

    public ce(com.facebook.ads.a.e.b b1, Context context, e e1)
    {
        c = b1;
        a = context;
        b = e1;
        super();
    }
}
