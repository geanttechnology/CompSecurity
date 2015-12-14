// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zze

public class MessageType
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    public final String type;
    final int versionCode;
    public final String zzaeI;

    MessageType(int i, String s, String s1)
    {
        versionCode = i;
        zzaeI = s;
        type = s1;
    }

    public MessageType(String s, String s1)
    {
        this(1, s, s1);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof MessageType))
            {
                return false;
            }
            obj = (MessageType)obj;
            if (!zzw.equal(zzaeI, ((MessageType) (obj)).zzaeI) || !zzw.equal(type, ((MessageType) (obj)).type))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaeI, type
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("namespace=").append(zzaeI).append(", type=").append(type).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

}
