// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            zzc

public class LogEvent
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzaGF;
    public final byte zzaGG[];
    public final Bundle zzaGH;

    LogEvent(int i, long l, String s, byte abyte0[], Bundle bundle)
    {
        versionCode = i;
        zzaGF = l;
        tag = s;
        zzaGG = abyte0;
        zzaGH = bundle;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("tag=").append(tag).append(",");
        stringbuilder.append("eventTime=").append(zzaGF).append(",");
        if (zzaGH != null && !zzaGH.isEmpty())
        {
            stringbuilder.append("keyValues=");
            for (Iterator iterator = zzaGH.keySet().iterator(); iterator.hasNext(); stringbuilder.append(" "))
            {
                String s = (String)iterator.next();
                stringbuilder.append("(").append(s).append(",");
                stringbuilder.append(zzaGH.getString(s)).append(")");
            }

        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
