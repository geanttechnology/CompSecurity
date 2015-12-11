// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, StatusCreator, CommonStatusCodes

public final class Status
    implements Result, SafeParcelable
{

    public static final StatusCreator CREATOR = new StatusCreator();
    public static final Status nA = new Status(0, null, null);
    public static final Status nB = new Status(14, null, null);
    public static final Status nC = new Status(15, null, null);
    private final int kg;
    private final int mC;
    private final PendingIntent mPendingIntent;
    private final String nD;

    public Status(int i)
    {
        this(1, i, null, null);
    }

    Status(int i, int j, String s, PendingIntent pendingintent)
    {
        kg = i;
        mC = j;
        nD = s;
        mPendingIntent = pendingintent;
    }

    public Status(int i, String s, PendingIntent pendingintent)
    {
        this(1, i, s, pendingintent);
    }

    private String bh()
    {
        if (nD != null)
        {
            return nD;
        } else
        {
            return CommonStatusCodes.getStatusCodeString(mC);
        }
    }

    PendingIntent bs()
    {
        return mPendingIntent;
    }

    String bt()
    {
        return nD;
    }

    public ConnectionResult bu()
    {
        return new ConnectionResult(mC, mPendingIntent);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (kg == ((Status) (obj = (Status)obj)).kg && mC == ((Status) (obj)).mC && ee.equal(nD, ((Status) (obj)).nD) && ee.equal(mPendingIntent, ((Status) (obj)).mPendingIntent))
            {
                return true;
            }
        }
        return false;
    }

    public PendingIntent getResolution()
    {
        return mPendingIntent;
    }

    public Status getStatus()
    {
        return this;
    }

    public int getStatusCode()
    {
        return mC;
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean hasResolution()
    {
        return mPendingIntent != null;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(kg), Integer.valueOf(mC), nD, mPendingIntent
        });
    }

    public boolean isInterrupted()
    {
        return mC == 14;
    }

    public boolean isSuccess()
    {
        return mC <= 0;
    }

    public void startResolutionForResult(Activity activity, int i)
        throws android.content.IntentSender.SendIntentException
    {
        if (!hasResolution())
        {
            return;
        } else
        {
            activity.startIntentSenderForResult(mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
            return;
        }
    }

    public String toString()
    {
        return ee.e(this).a("statusCode", bh()).a("resolution", mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        StatusCreator.a(this, parcel, i);
    }

}
