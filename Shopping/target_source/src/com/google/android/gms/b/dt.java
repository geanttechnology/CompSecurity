// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.b;

// Referenced classes of package com.google.android.gms.b:
//            ds, dr

public class dt
    implements com.google.android.gms.search.b
{
    static abstract class a extends dq.a
    {

        public void a(Status status, GoogleNowAuthState googlenowauthstate)
        {
            throw new UnsupportedOperationException();
        }

        a()
        {
        }
    }

    static class b extends com.google.android.gms.common.api.i.a
    {

        private final d b;
        private final String c;
        private final boolean d = Log.isLoggable("SearchAuth", 3);

        static boolean a(b b1)
        {
            return b1.d;
        }

        protected void a(ds ds1)
            throws RemoteException
        {
            if (d)
            {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String s = b.a().getPackageName();
            a a1 = new a(this) {

                final b a;

                public void a(Status status, GoogleNowAuthState googlenowauthstate)
                {
                    if (b.a(a))
                    {
                        Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                    }
                    a.a(new c(status, googlenowauthstate));
                }

            
            {
                a = b1;
                super();
            }
            };
            ((dr)ds1.m()).a(a1, s, c);
        }

        protected g b(Status status)
        {
            return d(status);
        }

        protected void b(com.google.android.gms.common.api.b.b b1)
            throws RemoteException
        {
            a((ds)b1);
        }

        protected com.google.android.gms.search.b.a d(Status status)
        {
            if (d)
            {
                Log.d("SearchAuth", (new StringBuilder()).append("GetGoogleNowAuthImpl received failure: ").append(status.c()).toString());
            }
            return new c(status, null);
        }

        protected b(d d1, String s)
        {
            super(com.google.android.gms.search.a.a, d1);
            b = d1;
            c = s;
        }
    }

    static class c
        implements com.google.android.gms.search.b.a
    {

        private final Status a;
        private final GoogleNowAuthState b;

        public Status a()
        {
            return a;
        }

        public GoogleNowAuthState b()
        {
            return b;
        }

        c(Status status, GoogleNowAuthState googlenowauthstate)
        {
            a = status;
            b = googlenowauthstate;
        }
    }


    public dt()
    {
    }

    public e a(d d1, String s)
    {
        return d1.a(new b(d1, s));
    }
}
