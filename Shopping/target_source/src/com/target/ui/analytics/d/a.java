// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.d;

import android.net.Uri;
import com.h.b.u;
import com.h.b.v;
import com.h.b.w;
import com.h.b.x;
import com.newrelic.agent.android.NewRelic;
import com.target.a.a.b;
import com.target.mothership.util.o;
import com.target.ui.util.q;
import java.io.IOException;

public class com.target.ui.analytics.d.a
{
    private class a
        implements com.h.b.q
    {

        final com.target.ui.analytics.d.a this$0;

        void a(u u1, w w1, long l, long l1)
        {
            try
            {
                com.target.ui.analytics.d.a.a(com.target.ui.analytics.d.a.this, u1, w1, l, l1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                com.target.a.a.b.a(com.target.ui.analytics.d.a.b(), "Error attempting to report request analytics: ", u1);
            }
        }

        void a(u u1, Exception exception, long l, long l1)
        {
            try
            {
                com.target.ui.analytics.d.a.a(com.target.ui.analytics.d.a.this, u1, exception, l, l1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                com.target.a.a.b.a(com.target.ui.analytics.d.a.b(), "Error attempting to report request error analytics: ", u1);
            }
        }

        public w intercept(com.h.b.q.a a1)
            throws IOException
        {
            u u1 = a1.a();
            long l = System.currentTimeMillis();
            try
            {
                a1 = a1.a(u1);
                a(u1, a1, l, System.currentTimeMillis());
            }
            // Misplaced declaration of an exception variable
            catch (com.h.b.q.a a1)
            {
                a(u1, a1, l, System.currentTimeMillis());
                throw a1;
            }
            return a1;
        }

        private a()
        {
            this$0 = com.target.ui.analytics.d.a.this;
            super();
        }

    }


    private static final String LOG_TAG = com/target/ui/analytics/d/a.getSimpleName();
    private final a mOkInterceptor = new a();

    private com.target.ui.analytics.d.a()
    {
    }

    public static com.h.b.q a()
    {
        return (new com.target.ui.analytics.d.a()).mOkInterceptor;
    }

    private String a(com.target.mothership.services.f.a.d.a a1, String s)
    {
        Uri uri = Uri.parse(s);
        if (a1 == com.target.mothership.services.f.a.d.a.PUT || a1 == com.target.mothership.services.f.a.d.a.DELETE)
        {
            s = uri.buildUpon().clearQuery().path("").build().toString();
        } else
        if (!o.e(uri.getQuery()))
        {
            return uri.buildUpon().clearQuery().build().toString();
        }
        return s;
    }

    private void a(u u1, w w1, long l, long l1)
        throws IOException
    {
        if (u1 == null || w1 == null)
        {
            q.b(LOG_TAG, "Both the request and the response were null?");
        } else
        if (w1.i() != null || w1.j() == null)
        {
            com.target.mothership.services.f.a.d.a a1;
            long l2;
            long l3;
            if (u1.f() != null)
            {
                l2 = u1.f().contentLength();
            } else
            {
                l2 = -1L;
            }
            if (w1.g() != null)
            {
                l3 = w1.g().contentLength();
            } else
            {
                l3 = -1L;
            }
            a1 = com.target.mothership.services.f.a.d.a.valueOf(u1.d());
            NewRelic.noticeHttpTransaction(a(a1, u1.c()), a1.name(), w1.c(), l, l1, l2, l3);
            return;
        }
    }

    private void a(u u1, Exception exception, long l, long l1)
    {
        com.target.mothership.services.f.a.d.a a1 = com.target.mothership.services.f.a.d.a.valueOf(u1.d());
        NewRelic.noticeNetworkFailure(a(a1, u1.c()), a1.name(), l, l1, exception);
    }

    static void a(com.target.ui.analytics.d.a a1, u u1, w w1, long l, long l1)
        throws IOException
    {
        a1.a(u1, w1, l, l1);
    }

    static void a(com.target.ui.analytics.d.a a1, u u1, Exception exception, long l, long l1)
    {
        a1.a(u1, exception, l, l1);
    }

    static String b()
    {
        return LOG_TAG;
    }

}
