// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            b

public class ActivityRecognitionResult
    implements SafeParcelable
{

    public static final b CREATOR = new b();
    final int a = 1;
    List b;
    long c;
    long d;

    public ActivityRecognitionResult(List list, long l, long l1)
    {
        b = list;
        c = l;
        d = l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder("ActivityRecognitionResult [probableActivities=")).append(b).append(", timeMillis=").append(c).append(", elapsedRealtimeMillis=").append(d).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.location.b.a(this, parcel);
    }

}
