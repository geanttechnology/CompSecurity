// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzf

public class MessageWrapper
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    final int versionCode;
    public final Message zzaJS;

    MessageWrapper(int i, Message message)
    {
        versionCode = i;
        zzaJS = (Message)zzx.zzv(message);
    }

    public static final MessageWrapper zza(Message message)
    {
        return new MessageWrapper(1, message);
    }

    public int describeContents()
    {
        zzf zzf1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof MessageWrapper))
        {
            return false;
        } else
        {
            obj = (MessageWrapper)obj;
            return zzw.equal(zzaJS, ((MessageWrapper) (obj)).zzaJS);
        }
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaJS
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf zzf1 = CREATOR;
        zzf.zza(this, parcel, i);
    }

}
