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
//            PersonEntity, zzi

public static final class mValue extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.onse
{

    public static final zzi CREATOR = new zzi();
    private static final HashMap zzaLS;
    String mValue;
    final int mVersionCode;
    final Set zzaLT;
    boolean zzaNx;

    public int describeContents()
    {
        zzi zzi1 = CREATOR;
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
        return zzzf();
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean hasPrimary()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasValue()
    {
        return zzaLT.contains(Integer.valueOf(3));
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
        zzi zzi1 = CREATOR;
        zzi.zza(this, parcel, i);
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
            return Boolean.valueOf(zzaNx);

        case 3: // '\003'
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

    public zzaLS zzzf()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("primary", com.google.android.gms.common.server.response.ity.zzaLS("primary", 2));
        zzaLS.put("value", com.google.android.gms.common.server.response.ity.zzaLS("value", 3));
    }

    public ()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    zzaLT(Set set, int i, boolean flag, String s)
    {
        zzaLT = set;
        mVersionCode = i;
        zzaNx = flag;
        mValue = s;
    }
}
