// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.an.s;
import com.shazam.android.an.t;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.server.response.streaming.rdio.RdioTrialStartStatus;

// Referenced classes of package com.shazam.android.an.a:
//            o

public final class m
    implements s
{
    private final class a
        implements RdioCallback
    {

        final m a;

        public final void a(Object obj)
        {
            obj = (RdioTrialStartStatus)obj;
            m m1 = a;
            if (((RdioTrialStartStatus) (obj)).success)
            {
                m1.a.a();
                return;
            } else
            {
                m1.a.b();
                return;
            }
        }

        public final void a(String s1)
        {
            a.a.b();
        }

        private a()
        {
            a = m.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    t a;
    private final o b;

    public m(o o1)
    {
        b = o1;
    }

    public final void a(t t)
    {
        a = t;
        b.c(new a((byte)0));
    }
}
