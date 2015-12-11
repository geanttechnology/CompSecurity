// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            fs, fi, fg

public class fr
    implements SafeParcelable
{

    public static final fs CREATOR = new fs();
    public final String mP;
    final int xM;
    final fi yq;
    final long yr;
    final int ys;
    final fg yt;

    fr(int i, fi fi, long l, int j, String s, fg fg)
    {
        xM = i;
        yq = fi;
        yr = l;
        ys = j;
        mP = s;
        yt = fg;
    }

    public int describeContents()
    {
        fs fs1 = CREATOR;
        return 0;
    }

    public String toString()
    {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[] {
            yq, Long.valueOf(yr), Integer.valueOf(ys)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        fs fs1 = CREATOR;
        fs.a(this, parcel, i);
    }

}
