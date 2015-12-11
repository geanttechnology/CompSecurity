// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.d.hs;
import com.google.android.gms.d.hu;
import com.google.android.gms.d.hv;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            f, g, a

public final class GetRecentContextCall
{
    public static class Request
        implements SafeParcelable
    {

        public static final f CREATOR = new f();
        final int a;
        public final Account b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final String f;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            com.google.android.gms.appdatasearch.f.a(this, parcel, i);
        }


        public Request()
        {
            this(null, false, false, false, null);
        }

        Request(int i, Account account, boolean flag, boolean flag1, boolean flag2, String s)
        {
            a = i;
            b = account;
            c = flag;
            d = flag1;
            e = flag2;
            f = s;
        }

        public Request(Account account, boolean flag, boolean flag1, boolean flag2, String s)
        {
            this(1, account, flag, flag1, flag2, s);
        }
    }

    public static final class Request.a
    {

        public Account a;
        public boolean b;
        public boolean c;
        public boolean d;
        public String e;

        public Request.a()
        {
        }
    }

    public static class Response
        implements g, SafeParcelable
    {

        public static final com.google.android.gms.appdatasearch.g CREATOR = new com.google.android.gms.appdatasearch.g();
        public Status a;
        public List b;
        public String c[];
        final int d;

        public final Status a()
        {
            return a;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            g.a(this, parcel, i);
        }


        public Response()
        {
            d = 1;
        }

        Response(int i, Status status, List list, String as[])
        {
            d = i;
            a = status;
            b = list;
            c = as;
        }
    }

    public static final class a extends com.google.android.gms.common.api.k.a
    {

        private final Request c;

        protected final g a(Status status)
        {
            Response response = new Response();
            response.a = status;
            return response;
        }

        protected final void a(com.google.android.gms.common.api.a.b b)
        {
            ((hs)((hv)b).m()).a(c, new hu(this, this) {

                final a a;

                public final void a(Response response)
                {
                    b.a(response);
                }

            
            {
                a = a1;
                super(b);
            }
            });
        }

        public a(Request request, c c1)
        {
            super(com.google.android.gms.appdatasearch.a.a, c1);
            c = request;
        }
    }

}
