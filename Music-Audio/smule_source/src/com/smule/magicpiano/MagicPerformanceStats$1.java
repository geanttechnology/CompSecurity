// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import android.os.Parcel;

// Referenced classes of package com.smule.magicpiano:
//            MagicPerformanceStats

final class 
    implements android.os.ceStats._cls1
{

    public MagicPerformanceStats a(Parcel parcel)
    {
        return new MagicPerformanceStats(parcel);
    }

    public MagicPerformanceStats[] a(int i)
    {
        return new MagicPerformanceStats[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
