// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.games.internal:
//            PopupLocationInfoParcelableCreator

public final class PopupLocationInfoParcelable
    implements SafeParcelable
{

    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int mVersionCode;
    private final Bundle zzaum;
    private final IBinder zzaun;

    PopupLocationInfoParcelable(int i, Bundle bundle, IBinder ibinder)
    {
        mVersionCode = i;
        zzaum = bundle;
        zzaun = ibinder;
    }

    public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo popuplocationinfo)
    {
        mVersionCode = 1;
        zzaum = popuplocationinfo.zzuo();
        zzaun = popuplocationinfo.zzauq;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public IBinder getWindowToken()
    {
        return zzaun;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        PopupLocationInfoParcelableCreator.zza(this, parcel, i);
    }

    public Bundle zzuo()
    {
        return zzaum;
    }

}
