// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, zzd, CommonStatusCodes

public final class Status
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    public static final Status zzabb = new Status(0);
    public static final Status zzabc = new Status(14);
    public static final Status zzabd = new Status(8);
    public static final Status zzabe = new Status(15);
    public static final Status zzabf = new Status(16);
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzYm;
    private final String zzZZ;

    public Status(int i)
    {
        this(i, null);
    }

    Status(int i, int j, String s, PendingIntent pendingintent)
    {
        mVersionCode = i;
        zzYm = j;
        zzZZ = s;
        mPendingIntent = pendingintent;
    }

    public Status(int i, String s)
    {
        this(1, i, s, null);
    }

    public Status(int i, String s, PendingIntent pendingintent)
    {
        this(1, i, s, pendingintent);
    }

    private String zznI()
    {
        if (zzZZ != null)
        {
            return zzZZ;
        } else
        {
            return CommonStatusCodes.getStatusCodeString(zzYm);
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (mVersionCode == ((Status) (obj = (Status)obj)).mVersionCode && zzYm == ((Status) (obj)).zzYm && zzw.equal(zzZZ, ((Status) (obj)).zzZZ) && zzw.equal(mPendingIntent, ((Status) (obj)).mPendingIntent))
            {
                return true;
            }
        }
        return false;
    }

    public final PendingIntent getResolution()
    {
        return mPendingIntent;
    }

    public final Status getStatus()
    {
        return this;
    }

    public final int getStatusCode()
    {
        return zzYm;
    }

    public final String getStatusMessage()
    {
        return zzZZ;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final boolean hasResolution()
    {
        return mPendingIntent != null;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mVersionCode), Integer.valueOf(zzYm), zzZZ, mPendingIntent
        });
    }

    public final boolean isCanceled()
    {
        return zzYm == 16;
    }

    public final boolean isInterrupted()
    {
        return zzYm == 14;
    }

    public final boolean isSuccess()
    {
        return zzYm <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i)
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

    public final String toString()
    {
        return zzw.zzv(this).zzg("statusCode", zznI()).zzg("resolution", mPendingIntent).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    final PendingIntent zznH()
    {
        return mPendingIntent;
    }

}
