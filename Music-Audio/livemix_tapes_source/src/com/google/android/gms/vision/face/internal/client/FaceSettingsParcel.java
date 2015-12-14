// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zzb

public class FaceSettingsParcel
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    public int mode;
    public final int versionCode;
    public int zzaVQ;
    public int zzaVR;
    public boolean zzaVS;
    public boolean zzaVT;

    public FaceSettingsParcel()
    {
        versionCode = 1;
    }

    public FaceSettingsParcel(int i, int j, int k, int l, boolean flag, boolean flag1)
    {
        versionCode = i;
        mode = j;
        zzaVQ = k;
        zzaVR = l;
        zzaVS = flag;
        zzaVT = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
