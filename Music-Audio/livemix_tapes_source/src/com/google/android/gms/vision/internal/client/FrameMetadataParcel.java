// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

// Referenced classes of package com.google.android.gms.vision.internal.client:
//            zza

public class FrameMetadataParcel
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    public int height;
    public int id;
    public int rotation;
    final int versionCode;
    public int width;
    public long zzaVY;

    public FrameMetadataParcel()
    {
        versionCode = 1;
    }

    public FrameMetadataParcel(int i, int j, int k, int l, long l1, int i1)
    {
        versionCode = i;
        width = j;
        height = k;
        id = l;
        zzaVY = l1;
        rotation = i1;
    }

    public static FrameMetadataParcel zzc(Frame frame)
    {
        FrameMetadataParcel framemetadataparcel = new FrameMetadataParcel();
        framemetadataparcel.width = frame.getMetadata().getWidth();
        framemetadataparcel.height = frame.getMetadata().getHeight();
        framemetadataparcel.rotation = frame.getMetadata().getRotation();
        framemetadataparcel.id = frame.getMetadata().getId();
        framemetadataparcel.zzaVY = frame.getMetadata().getTimestampMillis();
        return framemetadataparcel;
    }

    public int describeContents()
    {
        zza zza1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza zza1 = CREATOR;
        zza.zza(this, parcel, i);
    }

}
