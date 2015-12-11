// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            e, f

public class GetRecentContextCall
{
    public static class Request
        implements SafeParcelable
    {

        public static final e CREATOR = new e();
        final int a;
        public final Account b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        public int describeContents()
        {
            e e1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            e e1 = CREATOR;
            com.google.android.gms.appdatasearch.e.a(this, parcel, i);
        }


        public Request()
        {
            this(null, false, false, false);
        }

        Request(int i, Account account, boolean flag, boolean flag1, boolean flag2)
        {
            a = i;
            b = account;
            c = flag;
            d = flag1;
            e = flag2;
        }

        public Request(Account account, boolean flag, boolean flag1, boolean flag2)
        {
            this(1, account, flag, flag1, flag2);
        }
    }

    public static class Response
        implements g, SafeParcelable
    {

        public static final f CREATOR = new f();
        public Status a;
        public List b;
        public String c[];
        final int d;

        public Status a()
        {
            return a;
        }

        public int describeContents()
        {
            f f1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            f f1 = CREATOR;
            f.a(this, parcel, i);
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

}
