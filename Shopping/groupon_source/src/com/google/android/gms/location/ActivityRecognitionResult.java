// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            ActivityRecognitionResultCreator, DetectedActivity

public class ActivityRecognitionResult
    implements SafeParcelable
{

    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    private final int zzCY;
    List zzaxr;
    long zzaxs;
    long zzaxt;
    int zzaxu;

    public ActivityRecognitionResult(int i, List list, long l, long l1, int j)
    {
        zzCY = i;
        zzaxr = list;
        zzaxs = l;
        zzaxt = l1;
        zzaxu = j;
    }

    public static ActivityRecognitionResult extractResult(Intent intent)
    {
        if (!hasResult(intent))
        {
            return null;
        }
        intent = ((Intent) (intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")));
        if (intent instanceof byte[])
        {
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall((byte[])(byte[])intent, 0, ((byte[])(byte[])intent).length);
            parcel.setDataPosition(0);
            return CREATOR.createFromParcel(parcel);
        }
        if (intent instanceof ActivityRecognitionResult)
        {
            return (ActivityRecognitionResult)intent;
        } else
        {
            return null;
        }
    }

    public static boolean hasResult(Intent intent)
    {
        if (intent == null)
        {
            return false;
        } else
        {
            return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public DetectedActivity getMostProbableActivity()
    {
        return (DetectedActivity)zzaxr.get(0);
    }

    public int getVersionCode()
    {
        return zzCY;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ActivityRecognitionResult [probableActivities=").append(zzaxr).append(", timeMillis=").append(zzaxs).append(", elapsedRealtimeMillis=").append(zzaxt).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ActivityRecognitionResultCreator.zza(this, parcel, i);
    }

}
