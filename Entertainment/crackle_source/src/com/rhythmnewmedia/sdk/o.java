// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import java.io.IOException;
import org.apache.http.HttpResponse;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            a, y

public class o extends a
{

    public o(Context context)
    {
        super(context);
    }

    static String a(o o1)
    {
        return o1.a();
    }

    static HttpResponse a(o o1, a.e e)
        throws IOException
    {
        return o1.a(e, null);
    }

    static void b(HttpResponse httpresponse)
    {
        a(httpresponse);
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/o$1

/* anonymous class */
    public final class _cls1
        implements Runnable
    {

        final String a;
        final String b;
        final o c;

        public final void run()
        {
            Object obj;
            obj = String.format("%s/adServed?requestId=%s&id=%s&%s=%d", new Object[] {
                o.a(c), a, b, "v", Integer.valueOf(3)
            });
            obj = o.a(c, com.rhythmnewmedia.sdk.a.e.a(((String) (obj))));
            o.b(((HttpResponse) (obj)));
            return;
            Object obj1;
            obj1;
            y.a(((Throwable) (obj1)), "Error during ack", new Object[0]);
            o.b(null);
            return;
            obj1;
            o.b(null);
            throw obj1;
        }

            public 
            {
                c = o.this;
                a = s;
                b = s1;
                super();
            }
    }

}
