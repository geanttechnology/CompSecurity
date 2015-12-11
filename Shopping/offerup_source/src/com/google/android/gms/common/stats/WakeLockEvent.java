// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.stats:
//            zzf, zzh

public final class WakeLockEvent extends zzf
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private final long mTimeout;
    final int mVersionCode;
    private final long zzahn;
    private int zzaho;
    private final long zzahv;
    private long zzahx;
    private final String zzaia;
    private final int zzaib;
    private final List zzaic;
    private final String zzaid;
    private int zzaie;
    private final String zzaif;
    private final String zzaig;
    private final float zzaih;

    WakeLockEvent(int i, long l, int j, String s, int k, List list, 
            String s1, long l1, int i1, String s2, String s3, float f, 
            long l2)
    {
        mVersionCode = i;
        zzahn = l;
        zzaho = j;
        zzaia = s;
        zzaif = s2;
        zzaib = k;
        zzahx = -1L;
        zzaic = list;
        zzaid = s1;
        zzahv = l1;
        zzaie = i1;
        zzaig = s3;
        zzaih = f;
        mTimeout = l2;
    }

    public WakeLockEvent(long l, int i, String s, int j, List list, String s1, 
            long l1, int k, String s2, String s3, float f, long l2)
    {
        this(1, l, i, s, j, list, s1, l1, k, s2, s3, f, l2);
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
        zzh.zza(this, parcel, i);
    }

    public final String zzqc()
    {
        return zzaid;
    }

    public final long zzqd()
    {
        return zzahx;
    }

    public final long zzqf()
    {
        return zzahv;
    }

    public final String zzqg()
    {
        StringBuilder stringbuilder = (new StringBuilder("\t")).append(zzqj()).append("\t").append(zzql()).append("\t");
        String s;
        if (zzqm() == null)
        {
            s = "";
        } else
        {
            s = TextUtils.join(",", zzqm());
        }
        stringbuilder = stringbuilder.append(s).append("\t").append(zzqn()).append("\t");
        if (zzqk() == null)
        {
            s = "";
        } else
        {
            s = zzqk();
        }
        stringbuilder = stringbuilder.append(s).append("\t");
        if (zzqo() == null)
        {
            s = "";
        } else
        {
            s = zzqo();
        }
        return stringbuilder.append(s).append("\t").append(zzqp()).toString();
    }

    public final String zzqj()
    {
        return zzaia;
    }

    public final String zzqk()
    {
        return zzaif;
    }

    public final int zzql()
    {
        return zzaib;
    }

    public final List zzqm()
    {
        return zzaic;
    }

    public final int zzqn()
    {
        return zzaie;
    }

    public final String zzqo()
    {
        return zzaig;
    }

    public final float zzqp()
    {
        return zzaih;
    }

    public final long zzqq()
    {
        return mTimeout;
    }

}
