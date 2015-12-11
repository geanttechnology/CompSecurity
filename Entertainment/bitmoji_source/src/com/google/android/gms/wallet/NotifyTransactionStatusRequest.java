// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.er;

// Referenced classes of package com.google.android.gms.wallet:
//            m

public final class NotifyTransactionStatusRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final NotifyTransactionStatusRequest Zl;

        public NotifyTransactionStatusRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (!TextUtils.isEmpty(Zl.Yk))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            er.b(flag, "googleTransactionId is required");
            if (Zl.status >= 1 && Zl.status <= 8)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            er.b(flag, "status is an unrecognized value");
            return Zl;
        }

        public Builder setDetailedReason(String s)
        {
            Zl.Zk = s;
            return this;
        }

        public Builder setGoogleTransactionId(String s)
        {
            Zl.Yk = s;
            return this;
        }

        public Builder setStatus(int i)
        {
            Zl.status = i;
            return this;
        }

        private Builder()
        {
            Zl = NotifyTransactionStatusRequest.this;
            super();
        }

    }

    public static interface Status
    {

        public static final int SUCCESS = 1;
    }

    public static interface Status.Error
    {

        public static final int AVS_DECLINE = 7;
        public static final int BAD_CARD = 4;
        public static final int BAD_CVC = 3;
        public static final int DECLINED = 5;
        public static final int FRAUD_DECLINE = 8;
        public static final int OTHER = 6;
        public static final int UNKNOWN = 2;
    }


    public static final android.os.Parcelable.Creator CREATOR = new m();
    String Yk;
    String Zk;
    int status;
    final int wj;

    NotifyTransactionStatusRequest()
    {
        wj = 1;
    }

    NotifyTransactionStatusRequest(int i, String s, int j, String s1)
    {
        wj = i;
        Yk = s;
        status = j;
        Zk = s1;
    }

    public static Builder newBuilder()
    {
        NotifyTransactionStatusRequest notifytransactionstatusrequest = new NotifyTransactionStatusRequest();
        notifytransactionstatusrequest.getClass();
        return notifytransactionstatusrequest. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDetailedReason()
    {
        return Zk;
    }

    public String getGoogleTransactionId()
    {
        return Yk;
    }

    public int getStatus()
    {
        return status;
    }

    public int getVersionCode()
    {
        return wj;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        m.a(this, parcel, i);
    }

}
