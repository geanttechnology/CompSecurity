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
//            PersonEntity, zzj

public static final class mValue extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.sonResponse
{

    public static final zzj CREATOR = new zzj();
    private static final HashMap zzaLS;
    String mValue;
    final int mVersionCode;
    int zzUS;
    String zzaID;
    final Set zzaLT;
    private final int zzaNy;

    public int describeContents()
    {
        zzj zzj1 = CREATOR;
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
        return zzzh();
    }

    public String getLabel()
    {
        return zzaID;
    }

    public int getType()
    {
        return zzUS;
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean hasLabel()
    {
        return zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasType()
    {
        return zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasValue()
    {
        return zzaLT.contains(Integer.valueOf(4));
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
                int j = ity.zpi();
                i = zzb(ity).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj zzj1 = CREATOR;
        zzj.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.ity ity)
    {
        return zzaLT.contains(Integer.valueOf(ity.zpi()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.zpi())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.zpi()).toString());

        case 5: // '\005'
            return zzaID;

        case 6: // '\006'
            return Integer.valueOf(zzUS);

        case 4: // '\004'
            return mValue;
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

    public int zzzg()
    {
        return 4;
    }

    public zzaLS zzzh()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("label", com.google.android.gms.common.server.response.zm("label", 5));
        zzaLS.put("type", com.google.android.gms.common.server.response.za("type", 6, (new StringToIntConverter()).zzi("home", 0).zzi("work", 1).zzi("blog", 2).zzi("profile", 3).zzi("other", 4).zzi("otherProfile", 5).zzi("contributor", 6).zzi("website", 7), false));
        zzaLS.put("value", com.google.android.gms.common.server.response.zm("value", 4));
    }

    public se()
    {
        zzaNy = 4;
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    zzaLT(Set set, int i, String s, int j, String s1, int k)
    {
        zzaNy = 4;
        zzaLT = set;
        mVersionCode = i;
        zzaID = s;
        zzUS = j;
        mValue = s1;
    }
}
