// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            ActivityRecognitionResultCreator, DetectedActivity

public class ActivityRecognitionResult
    implements SafeParcelable
{

    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    private final int mVersionCode;
    List zzaEb;
    long zzaEc;
    long zzaEd;
    int zzaEe;

    public ActivityRecognitionResult(int i, List list, long l, long l1, int j)
    {
        mVersionCode = i;
        zzaEb = list;
        zzaEc = l;
        zzaEd = l1;
        zzaEe = j;
    }

    public ActivityRecognitionResult(DetectedActivity detectedactivity, long l, long l1)
    {
        this(detectedactivity, l, l1, 0);
    }

    public ActivityRecognitionResult(DetectedActivity detectedactivity, long l, long l1, int i)
    {
        this(Collections.singletonList(detectedactivity), l, l1, i);
    }

    public ActivityRecognitionResult(List list, long l, long l1)
    {
        this(list, l, l1, 0);
    }

    public ActivityRecognitionResult(List list, long l, long l1, int i)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Must have at least 1 detected activity");
        if (l > 0L && l1 > 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Must set times");
        mVersionCode = 2;
        zzaEb = list;
        zzaEc = l;
        zzaEd = l1;
        zzaEe = i;
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
            parcel.unmarshall((byte[])intent, 0, ((byte[])intent).length);
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

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ActivityRecognitionResult)obj;
            if (zzaEc != ((ActivityRecognitionResult) (obj)).zzaEc || zzaEd != ((ActivityRecognitionResult) (obj)).zzaEd || zzaEe != ((ActivityRecognitionResult) (obj)).zzaEe || !zzw.equal(zzaEb, ((ActivityRecognitionResult) (obj)).zzaEb))
            {
                return false;
            }
        }
        return true;
    }

    public int getActivityConfidence(int i)
    {
        for (Iterator iterator = zzaEb.iterator(); iterator.hasNext();)
        {
            DetectedActivity detectedactivity = (DetectedActivity)iterator.next();
            if (detectedactivity.getType() == i)
            {
                return detectedactivity.getConfidence();
            }
        }

        return 0;
    }

    public long getElapsedRealtimeMillis()
    {
        return zzaEd;
    }

    public DetectedActivity getMostProbableActivity()
    {
        return (DetectedActivity)zzaEb.get(0);
    }

    public List getProbableActivities()
    {
        return zzaEb;
    }

    public long getTime()
    {
        return zzaEc;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzaEc), Long.valueOf(zzaEd), Integer.valueOf(zzaEe), zzaEb
        });
    }

    public String toString()
    {
        return (new StringBuilder("ActivityRecognitionResult [probableActivities=")).append(zzaEb).append(", timeMillis=").append(zzaEc).append(", elapsedRealtimeMillis=").append(zzaEd).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ActivityRecognitionResultCreator.zza(this, parcel, i);
    }

}
