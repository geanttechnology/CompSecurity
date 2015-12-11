// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task

public class OneoffTask extends Task
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final long a;
    private final long b;

    private OneoffTask(Parcel parcel)
    {
        super(parcel);
        a = parcel.readLong();
        b = parcel.readLong();
    }

    OneoffTask(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    private OneoffTask(a a1)
    {
        super(a1);
    /* block-local class not found */
    class a {}

        a = a.a(a1);
        b = a.b(a1);
    }

    OneoffTask(a a1, _cls1 _pcls1)
    {
        this(a1);
    }

    public long a()
    {
        return a;
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        bundle.putLong("window_start", a);
        bundle.putLong("window_end", b);
    }

    public long b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ").append("windowStart=").append(a()).append(" ").append("windowEnd=").append(b()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(a);
        parcel.writeLong(b);
    }


    /* member class not found */
    class _cls1 {}

}
