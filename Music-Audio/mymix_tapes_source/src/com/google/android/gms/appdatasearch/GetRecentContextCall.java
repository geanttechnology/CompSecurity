// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzjc;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjf;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzf, zzg, zza

public class GetRecentContextCall
{
    public static class Request
        implements SafeParcelable
    {

        public static final zzf CREATOR = new zzf();
        final int mVersionCode;
        public final Account zzPl;
        public final boolean zzPm;
        public final boolean zzPn;
        public final boolean zzPo;
        public final String zzPp;

        public int describeContents()
        {
            zzf zzf1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzf zzf1 = CREATOR;
            zzf.zza(this, parcel, i);
        }


        public Request()
        {
            this(null, false, false, false, null);
        }

        Request(int i, Account account, boolean flag, boolean flag1, boolean flag2, String s)
        {
            mVersionCode = i;
            zzPl = account;
            zzPm = flag;
            zzPn = flag1;
            zzPo = flag2;
            zzPp = s;
        }

        public Request(Account account, boolean flag, boolean flag1, boolean flag2, String s)
        {
            this(1, account, flag, flag1, flag2, s);
        }
    }

    public static final class Request.zza
    {

        private Account zzPq;
        private boolean zzPr;
        private boolean zzPs;
        private boolean zzPt;
        private String zzPu;

        public Request.zza zzL(boolean flag)
        {
            zzPs = flag;
            return this;
        }

        public Request.zza zzbw(String s)
        {
            zzPu = s;
            return this;
        }

        public Request zzlb()
        {
            return new Request(zzPq, zzPr, zzPs, zzPt, zzPu);
        }

        public Request.zza()
        {
        }
    }

    public static class Response
        implements Result, SafeParcelable
    {

        public static final zzg CREATOR = new zzg();
        final int mVersionCode;
        public Status zzPv;
        public List zzPw;
        public String zzPx[];

        public int describeContents()
        {
            zzg zzg1 = CREATOR;
            return 0;
        }

        public Status getStatus()
        {
            return zzPv;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzg zzg1 = CREATOR;
            zzg.zza(this, parcel, i);
        }


        public Response()
        {
            mVersionCode = 1;
        }

        Response(int i, Status status, List list, String as[])
        {
            mVersionCode = i;
            zzPv = status;
            zzPw = list;
            zzPx = as;
        }
    }

    public static class zza extends com.google.android.gms.common.api.zzc.zza
    {

        private final Request zzPj;

        protected Response zza(Status status)
        {
            Response response = new Response();
            response.zzPv = status;
            return response;
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjf)zzb1);
        }

        protected void zza(zzjf zzjf1)
            throws RemoteException
        {
            zzjf1.zzlg().zza(zzPj, new zzje(this, this) {

                final zza zzPk;

                public void zza(Response response)
                {
                    zzPW.zzn(response);
                }

            
            {
                zzPk = zza1;
                super(zzb);
            }
            });
        }

        protected Result zzb(Status status)
        {
            return zza(status);
        }

        public zza(Request request, GoogleApiClient googleapiclient)
        {
            super(com.google.android.gms.appdatasearch.zza.zzOO, googleapiclient);
            zzPj = request;
        }
    }

}
