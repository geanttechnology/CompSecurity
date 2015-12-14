// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.realtime.internal:
//            zzq

public class ParcelableCollaborator
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzq();
    final int mVersionCode;
    final String zzGY;
    final String zzGh;
    final String zzahh;
    final boolean zzalX;
    final boolean zzalY;
    final String zzalZ;
    final String zzama;

    ParcelableCollaborator(int i, boolean flag, boolean flag1, String s, String s1, String s2, String s3, 
            String s4)
    {
        mVersionCode = i;
        zzalX = flag;
        zzalY = flag1;
        zzGY = s;
        zzGh = s1;
        zzahh = s2;
        zzalZ = s3;
        zzama = s4;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator))
        {
            return false;
        } else
        {
            obj = (ParcelableCollaborator)obj;
            return zzGY.equals(((ParcelableCollaborator) (obj)).zzGY);
        }
    }

    public int hashCode()
    {
        return zzGY.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("Collaborator [isMe=").append(zzalX).append(", isAnonymous=").append(zzalY).append(", sessionId=").append(zzGY).append(", userId=").append(zzGh).append(", displayName=").append(zzahh).append(", color=").append(zzalZ).append(", photoUrl=").append(zzama).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

}
