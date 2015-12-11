// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.target.a.a.c;
import com.target.mothership.services.f.a.d;
import com.target.mothership.util.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.target.mothership.services:
//            p, q, v, x

public class l
    implements p
{
    private static class a
    {

        private final c mLog;

        private void a(Map map)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); mLog.a((new StringBuilder()).append((String)entry.getKey()).append(": ").append((String)entry.getValue()).toString()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }

        void a(com.target.mothership.services.f.a.b.b b1)
        {
            com.target.mothership.services.f.a.d.a a1 = d.a(b1.c());
            mLog.a(String.format("---> Queueing HTTP %s %s", new Object[] {
                a1, b1.e()
            }));
            a(b1.f());
            if (!o.c(b1.d()))
            {
                mLog.a((new StringBuilder()).append("body: ").append(b1.d()).toString());
            }
            mLog.a((new StringBuilder()).append("---> End HTTP ").append(a1).toString());
        }

        void a(com.target.mothership.services.f.a.b.b b1, v v1)
        {
            mLog.a(String.format("<--- HTTP %s %s (%d ms)", new Object[] {
                v1.b(), b1.e(), Long.valueOf(v1.d())
            }));
            a(v1.c());
            if (!o.c(v1.a()))
            {
                mLog.a((new StringBuilder()).append("body: ").append(v1.a()).toString());
            }
            mLog.a(String.format("<--- END HTTP %s response", new Object[] {
                v1.b()
            }));
        }

        void a(x x1, com.target.mothership.services.f.a.b.b b1)
        {
            mLog.a(String.format("%s failed with error %s on request for '%s'", new Object[] {
                d.a(b1.c()), x1, b1.e()
            }));
            mLog.a((new StringBuilder()).append("body: '").append(x1.a()).append("'").toString());
            mLog.a(String.format("<--- END HTTP %s response", new Object[] {
                x1.b()
            }));
        }

        a(com.target.a.a.b.e e)
        {
            mLog = new c("Mothership", e);
        }
    }

    private static class b extends com.target.a.a.b.c
    {

        private static final String TAG = com/target/mothership/services/l$b.getSimpleName();

        public boolean b(int i, String s, String s1, Throwable throwable)
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                return true;
            } else
            {
                mDecoratedLogger.a(80, TAG, "Refusing to log below API 16!  See SaferAndroidLogger for more information.");
                return false;
            }
        }


        public b()
        {
            super(new com.target.a.a.b.a());
        }
    }


    private static final String LIBRARY_LOGGER_TAG = "Mothership";
    private final a mHttpLogger;
    private final p mSenderToDecorate;

    private l(p p1, com.target.a.a.b.e e)
    {
        mSenderToDecorate = p1;
        mHttpLogger = new a(e);
    }

    static a a(l l1)
    {
        return l1.mHttpLogger;
    }

    public static l a(p p1)
    {
        return new l(p1, new b());
    }

    public void a(com.target.mothership.services.f.a.b.b b1, final q responseHandler, String s)
    {
        mHttpLogger.a(b1);
        responseHandler = new q() {

            final l this$0;
            final q val$responseHandler;

            public void a(v v, boolean flag, com.target.mothership.services.f.a.b.b b2)
            {
                l.a(l.this).a(b2, v);
                responseHandler.a(v, flag, b2);
            }

            public void a(x x, com.target.mothership.services.f.a.b.b b2)
            {
                l.a(l.this).a(x, b2);
                responseHandler.a(x, b2);
            }

            
            {
                this$0 = l.this;
                responseHandler = q1;
                super();
            }
        };
        mSenderToDecorate.a(b1, responseHandler, s);
    }

    public void a(String s)
        throws IllegalArgumentException
    {
        mSenderToDecorate.a(s);
    }
}
