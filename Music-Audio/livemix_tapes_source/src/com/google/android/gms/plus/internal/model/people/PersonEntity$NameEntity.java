// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.people:
//            PersonEntity, zzg

public static final class zzaNu extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.sonResponse
{

    public static final zzg CREATOR = new zzg();
    private static final HashMap zzaLS;
    final int mVersionCode;
    final Set zzaLT;
    String zzaMr;
    String zzaMu;
    String zzaNr;
    String zzaNs;
    String zzaNt;
    String zzaNu;

    public int describeContents()
    {
        zzg zzg1 = CREATOR;
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
        return zzzd();
    }

    public String getFamilyName()
    {
        return zzaMr;
    }

    public String getFormatted()
    {
        return zzaNr;
    }

    public String getGivenName()
    {
        return zzaMu;
    }

    public String getHonorificPrefix()
    {
        return zzaNs;
    }

    public String getHonorificSuffix()
    {
        return zzaNt;
    }

    public String getMiddleName()
    {
        return zzaNu;
    }

    public boolean hasFamilyName()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasFormatted()
    {
        return zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasGivenName()
    {
        return zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasHonorificPrefix()
    {
        return zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasHonorificSuffix()
    {
        return zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasMiddleName()
    {
        return zzaLT.contains(Integer.valueOf(7));
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
        zzg zzg1 = CREATOR;
        zzg.zza(this, parcel, i);
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

        case 2: // '\002'
            return zzaMr;

        case 3: // '\003'
            return zzaNr;

        case 4: // '\004'
            return zzaMu;

        case 5: // '\005'
            return zzaNs;

        case 6: // '\006'
            return zzaNt;

        case 7: // '\007'
            return zzaNu;
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

    public zzaLS zzzd()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("familyName", com.google.android.gms.common.server.response.zm("familyName", 2));
        zzaLS.put("formatted", com.google.android.gms.common.server.response.zm("formatted", 3));
        zzaLS.put("givenName", com.google.android.gms.common.server.response.zm("givenName", 4));
        zzaLS.put("honorificPrefix", com.google.android.gms.common.server.response.zm("honorificPrefix", 5));
        zzaLS.put("honorificSuffix", com.google.android.gms.common.server.response.zm("honorificSuffix", 6));
        zzaLS.put("middleName", com.google.android.gms.common.server.response.zm("middleName", 7));
    }

    public se()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    zzaLT(Set set, int i, String s, String s1, String s2, String s3, String s4, 
            String s5)
    {
        zzaLT = set;
        mVersionCode = i;
        zzaMr = s;
        zzaNr = s1;
        zzaMu = s2;
        zzaNs = s3;
        zzaNt = s4;
        zzaNu = s5;
    }
}
