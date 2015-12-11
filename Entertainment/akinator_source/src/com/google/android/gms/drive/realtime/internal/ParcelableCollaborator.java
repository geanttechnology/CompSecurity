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
    final String zzHP;
    final String zzTa;
    final String zzaoA;
    final boolean zzaox;
    final boolean zzaoy;
    final String zzaoz;

    ParcelableCollaborator(int i, boolean flag, boolean flag1, String s, String s1, String s2, String s3, 
            String s4)
    {
        mVersionCode = i;
        zzaox = flag;
        zzaoy = flag1;
        zzHP = s;
        zzGY = s1;
        zzTa = s2;
        zzaoz = s3;
        zzaoA = s4;
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
            return zzHP.equals(((ParcelableCollaborator) (obj)).zzHP);
        }
    }

    public int hashCode()
    {
        return zzHP.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("Collaborator [isMe=").append(zzaox).append(", isAnonymous=").append(zzaoy).append(", sessionId=").append(zzHP).append(", userId=").append(zzGY).append(", displayName=").append(zzTa).append(", color=").append(zzaoz).append(", photoUrl=").append(zzaoA).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

}
