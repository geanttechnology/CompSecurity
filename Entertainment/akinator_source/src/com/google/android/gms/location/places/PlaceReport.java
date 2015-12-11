// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.location.places:
//            zzj

public class PlaceReport
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaGt;
    private final String zzaGu;

    PlaceReport(int i, String s, String s1, String s2)
    {
        mVersionCode = i;
        zzaGt = s;
        mTag = s1;
        zzaGu = s2;
    }

    public static PlaceReport create(String s, String s1)
    {
        return zzi(s, s1, "unknown");
    }

    private static boolean zzdy(String s)
    {
        byte byte0;
        boolean flag;
        flag = true;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 6: default 68
    //                   -1436706272: 140
    //                   -1194968642: 126
    //                   -284840886: 112
    //                   -262743844: 168
    //                   1164924125: 182
    //                   1287171955: 154;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        switch (byte0)
        {
        default:
            flag = false;
            // fall through

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return flag;
        }
_L4:
        if (s.equals("unknown"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("userReported"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("inferredGeofencing"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (s.equals("inferredRadioSignals"))
        {
            byte0 = 3;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.equals("inferredReverseGeocoding"))
        {
            byte0 = 4;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("inferredSnappedToRoad"))
        {
            byte0 = 5;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public static PlaceReport zzi(String s, String s1, String s2)
    {
        zzx.zzw(s);
        zzx.zzcr(s1);
        zzx.zzcr(s2);
        zzx.zzb(zzdy(s2), "Invalid source");
        return new PlaceReport(1, s, s1, s2);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlaceReport)
        {
            if (zzw.equal(zzaGt, ((PlaceReport) (obj = (PlaceReport)obj)).zzaGt) && zzw.equal(mTag, ((PlaceReport) (obj)).mTag) && zzw.equal(zzaGu, ((PlaceReport) (obj)).zzaGu))
            {
                return true;
            }
        }
        return false;
    }

    public String getPlaceId()
    {
        return zzaGt;
    }

    public String getSource()
    {
        return zzaGu;
    }

    public String getTag()
    {
        return mTag;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaGt, mTag, zzaGu
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza = zzw.zzv(this);
        zza.zzg("placeId", zzaGt);
        zza.zzg("tag", mTag);
        if (!"unknown".equals(zzaGu))
        {
            zza.zzg("source", zzaGu);
        }
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

}
