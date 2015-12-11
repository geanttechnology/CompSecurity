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
    private static final HashMap zzaSS;
    String mValue;
    final int mVersionCode;
    int zzWJ;
    String zzaLw;
    final Set zzaST;
    private final int zzaUy;

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
                for (Iterator iterator = zzaSS.values().iterator(); iterator.hasNext();)
                {
                    ity = (com.google.android.gms.common.server.response.ity.zzaSS)iterator.next();
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
        return zzBY();
    }

    public String getLabel()
    {
        return zzaLw;
    }

    public int getType()
    {
        return zzWJ;
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean hasLabel()
    {
        return zzaST.contains(Integer.valueOf(5));
    }

    public boolean hasType()
    {
        return zzaST.contains(Integer.valueOf(6));
    }

    public boolean hasValue()
    {
        return zzaST.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
        Iterator iterator = zzaSS.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.server.response.ity ity = (com.google.android.gms.common.server.response.ity.zzaSS)iterator.next();
            if (zza(ity))
            {
                int j = ity.zpK();
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

    public HashMap zzBK()
    {
        return zzaSS;
    }

    public int zzBX()
    {
        return 4;
    }

    public zzaSS zzBY()
    {
        return this;
    }

    protected boolean zza(com.google.android.gms.common.server.response.ity ity)
    {
        return zzaST.contains(Integer.valueOf(ity.zpK()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.zpK())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.zpK()).toString());

        case 5: // '\005'
            return zzaLw;

        case 6: // '\006'
            return Integer.valueOf(zzWJ);

        case 4: // '\004'
            return mValue;
        }
    }

    public Map zzpD()
    {
        return zzBK();
    }

    static 
    {
        zzaSS = new HashMap();
        zzaSS.put("label", com.google.android.gms.common.server.response.zm("label", 5));
        zzaSS.put("type", com.google.android.gms.common.server.response.za("type", 6, (new StringToIntConverter()).zzi("home", 0).zzi("work", 1).zzi("blog", 2).zzi("profile", 3).zzi("other", 4).zzi("otherProfile", 5).zzi("contributor", 6).zzi("website", 7), false));
        zzaSS.put("value", com.google.android.gms.common.server.response.zm("value", 4));
    }

    public se()
    {
        zzaUy = 4;
        mVersionCode = 1;
        zzaST = new HashSet();
    }

    zzaST(Set set, int i, String s, int j, String s1, int k)
    {
        zzaUy = 4;
        zzaST = set;
        mVersionCode = i;
        zzaLw = s;
        zzWJ = j;
        mValue = s1;
    }
}
