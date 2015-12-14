// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zze

public final class LandmarkParcel
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    public final int type;
    public final int versionCode;
    public final float x;
    public final float y;

    public LandmarkParcel(int i, float f, float f1, int j)
    {
        versionCode = i;
        x = f;
        y = f1;
        type = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

}
