// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            zza

public class GeofencingRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int mVersionCode;
    private final List zzaEt;
    private final int zzaEu;

    GeofencingRequest(int i, List list, int j)
    {
        mVersionCode = i;
        zzaEt = list;
        zzaEu = j;
    }

    private GeofencingRequest(List list, int i)
    {
        this(1, list, i);
    }

    GeofencingRequest(List list, int i, _cls1 _pcls1)
    {
        this(list, i);
    }

    public int describeContents()
    {
        return 0;
    }

    public List getGeofences()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(zzaEt);
        return arraylist;
    }

    public int getInitialTrigger()
    {
        return zzaEu;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public List zzwv()
    {
        return zzaEt;
    }

}
