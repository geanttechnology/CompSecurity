// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.people:
//            PersonEntity, zzh

public static final class zzUS extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.se
{

    public static final zzh CREATOR = new zzh();
    private static final HashMap zzaLS;
    String mName;
    final int mVersionCode;
    int zzUS;
    final Set zzaLT;
    String zzaMG;
    String zzaMq;
    String zzaNv;
    String zzaNw;
    boolean zzaNx;
    String zzagU;
    String zzaoB;

    public int describeContents()
    {
        zzh zzh1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (CREATOR)obj;
            com.google.android.gms.common.server.response.ity ity;
label1:
            do
            {
                for (Iterator iterator = zzaLS.values().iterator(); iterator.hasNext();)
                {
                    ity = (com.google.android.gms.common.server.response.ity.zzaLS)iterator.next();
                    if (!zza(ity))
                    {
                        continue label1;
                    }
                    if (((zza) (obj)).zza(ity))
                    {
                        if (!zzb(ity).equals(((zzb) (obj)).zzb(ity)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zzb) (obj)).zza(ity));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzze();
    }

    public String getDepartment()
    {
        return zzaNv;
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public String getEndDate()
    {
        return zzaMq;
    }

    public String getLocation()
    {
        return zzaNw;
    }

    public String getName()
    {
        return mName;
    }

    public String getStartDate()
    {
        return zzaMG;
    }

    public String getTitle()
    {
        return zzagU;
    }

    public int getType()
    {
        return zzUS;
    }

    public boolean hasDepartment()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasDescription()
    {
        return zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasEndDate()
    {
        return zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasLocation()
    {
        return zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasName()
    {
        return zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasPrimary()
    {
        return zzaLT.contains(Integer.valueOf(7));
    }

    public boolean hasStartDate()
    {
        return zzaLT.contains(Integer.valueOf(8));
    }

    public boolean hasTitle()
    {
        return zzaLT.contains(Integer.valueOf(9));
    }

    public boolean hasType()
    {
        return zzaLT.contains(Integer.valueOf(10));
    }

    public int hashCode()
    {
        Iterator iterator = zzaLS.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.server.response.ity ity = (com.google.android.gms.common.server.response.ity.zzaLS)iterator.next();
            if (zza(ity))
            {
                int j = ity.zza();
                i = zzb(ity).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isPrimary()
    {
        return zzaNx;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh zzh1 = CREATOR;
        zzh.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.ity ity)
    {
        return zzaLT.contains(Integer.valueOf(ity.zzaLT()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.ity())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.ity()).toString());

        case 2: // '\002'
            return zzaNv;

        case 3: // '\003'
            return zzaoB;

        case 4: // '\004'
            return zzaMq;

        case 5: // '\005'
            return zzaNw;

        case 6: // '\006'
            return mName;

        case 7: // '\007'
            return Boolean.valueOf(zzaNx);

        case 8: // '\b'
            return zzaMG;

        case 9: // '\t'
            return zzagU;

        case 10: // '\n'
            return Integer.valueOf(zzUS);
        }
    }

    public Map zzpb()
    {
        return zzyT();
    }

    public HashMap zzyT()
    {
        return zzaLS;
    }

    public zzaLS zzze()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("department", com.google.android.gms.common.server.response.ity.zzaLS("department", 2));
        zzaLS.put("description", com.google.android.gms.common.server.response.ity.zzaLS("description", 3));
        zzaLS.put("endDate", com.google.android.gms.common.server.response.ity.zzaLS("endDate", 4));
        zzaLS.put("location", com.google.android.gms.common.server.response.ity.zzaLS("location", 5));
        zzaLS.put("name", com.google.android.gms.common.server.response.ity.zzaLS("name", 6));
        zzaLS.put("primary", com.google.android.gms.common.server.response.ity.zzaLS("primary", 7));
        zzaLS.put("startDate", com.google.android.gms.common.server.response.ity.zzaLS("startDate", 8));
        zzaLS.put("title", com.google.android.gms.common.server.response.ity.zzaLS("title", 9));
        zzaLS.put("type", com.google.android.gms.common.server.response.ity.zzaLS("type", 10, (new StringToIntConverter()).zzi("work", 0).zzi("school", 1), false));
    }

    public ()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    zzaLT(Set set, int i, String s, String s1, String s2, String s3, String s4, 
            boolean flag, String s5, String s6, int j)
    {
        zzaLT = set;
        mVersionCode = i;
        zzaNv = s;
        zzaoB = s1;
        zzaMq = s2;
        zzaNw = s3;
        mName = s4;
        zzaNx = flag;
        zzaMG = s5;
        zzagU = s6;
        zzUS = j;
    }
}
