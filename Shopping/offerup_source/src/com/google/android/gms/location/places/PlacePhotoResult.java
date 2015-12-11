// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.location.places:
//            zzi

public class PlacePhotoResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    private final Bitmap mBitmap;
    final int mVersionCode;
    private final Status zzSC;
    final BitmapTeleporter zzaGs;

    PlacePhotoResult(int i, Status status, BitmapTeleporter bitmapteleporter)
    {
        mVersionCode = i;
        zzSC = status;
        zzaGs = bitmapteleporter;
        if (zzaGs != null)
        {
            mBitmap = bitmapteleporter.zzos();
            return;
        } else
        {
            mBitmap = null;
            return;
        }
    }

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapteleporter)
    {
        mVersionCode = 0;
        zzSC = status;
        zzaGs = bitmapteleporter;
        if (zzaGs != null)
        {
            mBitmap = bitmapteleporter.zzos();
            return;
        } else
        {
            mBitmap = null;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Bitmap getBitmap()
    {
        return mBitmap;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("bitmap", mBitmap).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

}
