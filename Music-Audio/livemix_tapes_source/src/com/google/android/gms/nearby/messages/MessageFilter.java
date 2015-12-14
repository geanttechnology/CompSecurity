// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            zzb

public class MessageFilter
    implements SafeParcelable
{
    public static final class Builder
    {

        private final List zzaJI = new ArrayList();

        private Builder zzE(String s, String s1)
        {
            zzaJI.add(new MessageType(s, s1));
            return this;
        }

        public MessageFilter build()
        {
            boolean flag;
            if (!zzaJI.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "At least one of the include methods must be called.");
            return new MessageFilter(zzaJI);
        }

        public Builder includeAllMyTypes()
        {
            return zzE("", "");
        }

        public Builder includeFilter(MessageFilter messagefilter)
        {
            zzaJI.addAll(messagefilter.zzyo());
            return this;
        }

        public Builder includeNamespacedType(String s, String s1)
        {
            return zzE(s, s1);
        }

        public Builder()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = (new Builder()).includeAllMyTypes().build();
    final int versionCode;
    private final List zzaJI;

    MessageFilter(int i, List list)
    {
        versionCode = i;
        zzaJI = Collections.unmodifiableList((List)zzx.zzv(list));
    }

    private MessageFilter(List list)
    {
        this(1, list);
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
        if (!(obj instanceof MessageFilter))
        {
            return false;
        } else
        {
            obj = (MessageFilter)obj;
            return zzw.equal(zzaJI, ((MessageFilter) (obj)).zzaJI);
        }
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaJI
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("MessageFilter").append(zzaJI).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    List zzyo()
    {
        return zzaJI;
    }

}
