// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ep;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, StatusCreator, CommonStatusCodes

public final class Status
    implements Result, SafeParcelable
{

    public static final StatusCreator CREATOR = new StatusCreator();
    public static final Status zQ = new Status(0, null, null);
    public static final Status zR = new Status(14, null, null);
    public static final Status zS = new Status(15, null, null);
    private final PendingIntent mPendingIntent;
    private final int wj;
    private final int yJ;
    private final String zT;

    public Status(int i)
    {
        this(1, i, null, null);
    }

    Status(int i, int j, String s, PendingIntent pendingintent)
    {
        wj = i;
        yJ = j;
        zT = s;
        mPendingIntent = pendingintent;
    }

    public Status(int i, String s, PendingIntent pendingintent)
    {
        this(1, i, s, pendingintent);
    }

    private String dn()
    {
        if (zT != null)
        {
            return zT;
        } else
        {
            return CommonStatusCodes.getStatusCodeString(yJ);
        }
    }

    PendingIntent dE()
    {
        return mPendingIntent;
    }

    String dF()
    {
        return zT;
    }

    public ConnectionResult dG()
    {
        return new ConnectionResult(yJ, mPendingIntent);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (wj == ((Status) (obj = (Status)obj)).wj && yJ == ((Status) (obj)).yJ && ep.equal(zT, ((Status) (obj)).zT) && ep.equal(mPendingIntent, ((Status) (obj)).mPendingIntent))
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
        return yJ;
    }

    int getVersionCode()
    {
        return wj;
    }

    public boolean hasResolution()
    {
        return mPendingIntent != null;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            Integer.valueOf(wj), Integer.valueOf(yJ), zT, mPendingIntent
        });
    }

    public boolean isInterrupted()
    {
        return yJ == 14;
    }

    public boolean isSuccess()
    {
        return yJ <= 0;
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
        return ep.e(this).a("statusCode", dn()).a("resolution", mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        StatusCreator.a(this, parcel, i);
    }

}
