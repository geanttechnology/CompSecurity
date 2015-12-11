// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

// Referenced classes of package com.google.android.gms.location:
//            DetectedActivityCreator

public class DetectedActivity
    implements SafeParcelable
{

    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final Comparator zzaxv = new Comparator() {

        public int compare(Object obj, Object obj1)
        {
            return zza((DetectedActivity)obj, (DetectedActivity)obj1);
        }

        public int zza(DetectedActivity detectedactivity, DetectedActivity detectedactivity1)
        {
            int j = Integer.valueOf(detectedactivity1.getConfidence()).compareTo(Integer.valueOf(detectedactivity.getConfidence()));
            int i = j;
            if (j == 0)
            {
                i = Integer.valueOf(detectedactivity.getType()).compareTo(Integer.valueOf(detectedactivity1.getType()));
            }
            return i;
        }

    };
    private final int zzCY;
    int zzaxw;
    int zzaxx;

    public DetectedActivity(int i, int j, int k)
    {
        zzCY = i;
        zzaxw = j;
        zzaxx = k;
    }

    private int zzgp(int i)
    {
        int j = i;
        if (i > 15)
        {
            j = 4;
        }
        return j;
    }

    public static String zzgq(int i)
    {
        switch (i)
        {
        case 6: // '\006'
        default:
            return Integer.toString(i);

        case 0: // '\0'
            return "IN_VEHICLE";

        case 1: // '\001'
            return "ON_BICYCLE";

        case 2: // '\002'
            return "ON_FOOT";

        case 3: // '\003'
            return "STILL";

        case 4: // '\004'
            return "UNKNOWN";

        case 5: // '\005'
            return "TILTING";

        case 7: // '\007'
            return "WALKING";

        case 8: // '\b'
            return "RUNNING";
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public int getConfidence()
    {
        return zzaxx;
    }

    public int getType()
    {
        return zzgp(zzaxw);
    }

    public int getVersionCode()
    {
        return zzCY;
    }

    public String toString()
    {
        return (new StringBuilder()).append("DetectedActivity [type=").append(zzgq(getType())).append(", confidence=").append(zzaxx).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DetectedActivityCreator.zza(this, parcel, i);
    }

}
