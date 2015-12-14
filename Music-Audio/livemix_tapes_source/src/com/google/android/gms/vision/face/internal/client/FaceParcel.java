// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zza, LandmarkParcel

public class FaceParcel
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    public final int versionCode;
    public final float width;
    public final float zzaVK;
    public final float zzaVL;
    public final LandmarkParcel zzaVM[];
    public final float zzaVN;
    public final float zzaVO;
    public final float zzaVP;

    public FaceParcel(int i, int j, float f, float f1, float f2, float f3, float f4, 
            float f5, LandmarkParcel alandmarkparcel[], float f6, float f7, float f8)
    {
        versionCode = i;
        id = j;
        centerX = f;
        centerY = f1;
        width = f2;
        height = f3;
        zzaVK = f4;
        zzaVL = f5;
        zzaVM = alandmarkparcel;
        zzaVN = f6;
        zzaVO = f7;
        zzaVP = f8;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
