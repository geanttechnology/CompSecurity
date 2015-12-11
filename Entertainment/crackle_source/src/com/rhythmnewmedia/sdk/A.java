// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import java.io.IOException;
import org.apache.http.HttpResponse;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            a, y

public class A extends a
{

    public A(Context context)
    {
        super(context);
    }

    static String a(A a1)
    {
        return a1.a();
    }

    static HttpResponse a(A a1, a.e e)
        throws IOException
    {
        return a1.a(e, null);
    }

    static void b(HttpResponse httpresponse)
    {
        a(httpresponse);
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/A$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final String a;
        final String b;
        final double c;
        final com.rhythmnewmedia.sdk.video.VideoDataSource.a d;
        final A e;

        public final void run()
        {
            Object obj;
            obj = String.format("%s/adServed?requestId=%s&id=%s&%s=%d&completed=%.2f&sourceType=%d", new Object[] {
                A.a(e), a, b, "v", Integer.valueOf(3), Double.valueOf(c), Integer.valueOf(d.d)
            });
            obj = A.a(e, com.rhythmnewmedia.sdk.a.e.a(((String) (obj))));
            A.b(((HttpResponse) (obj)));
            return;
            Object obj1;
            obj1;
            y.a(((Throwable) (obj1)), "Error during ack", new Object[0]);
            A.b(null);
            return;
            obj1;
            A.b(null);
            throw obj1;
        }

            
            {
                e = A.this;
                a = s;
                b = s1;
                c = d1;
                d = a2;
                super();
            }
    }

}
