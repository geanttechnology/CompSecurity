// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.stats:
//            zzf, zza

public final class ConnectionEvent extends zzf
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    private final long zzahn;
    private int zzaho;
    private final String zzahp;
    private final String zzahq;
    private final String zzahr;
    private final String zzahs;
    private final String zzaht;
    private final String zzahu;
    private final long zzahv;
    private final long zzahw;
    private long zzahx;

    ConnectionEvent(int i, long l, int j, String s, String s1, String s2, 
            String s3, String s4, String s5, long l1, long l2)
    {
        mVersionCode = i;
        zzahn = l;
        zzaho = j;
        zzahp = s;
        zzahq = s1;
        zzahr = s2;
        zzahs = s3;
        zzahx = -1L;
        zzaht = s4;
        zzahu = s5;
        zzahv = l1;
        zzahw = l2;
    }

    public ConnectionEvent(long l, int i, String s, String s1, String s2, String s3, 
            String s4, String s5, long l1, long l2)
    {
        this(1, l, i, s, s1, s2, s3, s4, s5, l1, l2);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getEventType()
    {
        return zzaho;
    }

    public final long getTimeMillis()
    {
        return zzahn;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public final String zzpX()
    {
        return zzahp;
    }

    public final String zzpY()
    {
        return zzahq;
    }

    public final String zzpZ()
    {
        return zzahr;
    }

    public final String zzqa()
    {
        return zzahs;
    }

    public final String zzqb()
    {
        return zzaht;
    }

    public final String zzqc()
    {
        return zzahu;
    }

    public final long zzqd()
    {
        return zzahx;
    }

    public final long zzqe()
    {
        return zzahw;
    }

    public final long zzqf()
    {
        return zzahv;
    }

    public final String zzqg()
    {
        StringBuilder stringbuilder = (new StringBuilder("\t")).append(zzpX()).append("/").append(zzpY()).append("\t").append(zzpZ()).append("/").append(zzqa()).append("\t");
        String s;
        if (zzaht == null)
        {
            s = "";
        } else
        {
            s = zzaht;
        }
        return stringbuilder.append(s).append("\t").append(zzqe()).toString();
    }

}
