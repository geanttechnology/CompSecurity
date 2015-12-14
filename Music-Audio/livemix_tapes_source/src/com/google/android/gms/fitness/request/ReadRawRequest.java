// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznd;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzq

public class ReadRawRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzq();
    private final int mVersionCode;
    private final String zzOZ;
    private final boolean zzapQ;
    private final boolean zzapR;
    private final zznd zzaqf;
    private final List zzaqg;

    ReadRawRequest(int i, IBinder ibinder, String s, List list, boolean flag, boolean flag1)
    {
        mVersionCode = i;
        zzaqf = com.google.android.gms.internal.zznd.zza.zzbF(ibinder);
        zzaqg = list;
        zzOZ = s;
        zzapQ = flag;
        zzapR = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzaqf != null)
        {
            return zzaqf.asBinder();
        } else
        {
            return null;
        }
    }

    public boolean zzsh()
    {
        return zzapR;
    }

    public boolean zzsi()
    {
        return zzapQ;
    }

    public List zzsn()
    {
        return zzaqg;
    }

}
