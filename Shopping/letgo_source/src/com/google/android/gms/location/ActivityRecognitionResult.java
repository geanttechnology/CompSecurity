// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            c, DetectedActivity

public class ActivityRecognitionResult
    implements SafeParcelable
{

    public static final c CREATOR = new c();
    List a;
    long b;
    long c;
    int d;
    private final int e;

    public ActivityRecognitionResult(int i, List list, long l, long l1, int j)
    {
        e = i;
        a = list;
        b = l;
        c = l1;
        d = j;
    }

    public static boolean a(Intent intent)
    {
        if (intent == null)
        {
            return false;
        } else
        {
            return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        }
    }

    public static ActivityRecognitionResult b(Intent intent)
    {
        if (!a(intent))
        {
            return null;
        }
        intent = ((Intent) (intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")));
        if (intent instanceof byte[])
        {
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall((byte[])(byte[])intent, 0, ((byte[])(byte[])intent).length);
            parcel.setDataPosition(0);
            return CREATOR.a(parcel);
        }
        if (intent instanceof ActivityRecognitionResult)
        {
            return (ActivityRecognitionResult)intent;
        } else
        {
            return null;
        }
    }

    public DetectedActivity a()
    {
        return (DetectedActivity)a.get(0);
    }

    public int b()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ActivityRecognitionResult)obj;
            if (b != ((ActivityRecognitionResult) (obj)).b || c != ((ActivityRecognitionResult) (obj)).c || d != ((ActivityRecognitionResult) (obj)).d || !w.a(a, ((ActivityRecognitionResult) (obj)).a))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            Long.valueOf(b), Long.valueOf(c), Integer.valueOf(d), a
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("ActivityRecognitionResult [probableActivities=").append(a).append(", timeMillis=").append(b).append(", elapsedRealtimeMillis=").append(c).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.location.c.a(this, parcel, i);
    }

}
