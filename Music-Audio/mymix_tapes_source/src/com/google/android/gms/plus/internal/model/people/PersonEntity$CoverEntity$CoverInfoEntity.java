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
//            PersonEntity, zzd

public static final class zzaNq extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.foEntity
{

    public static final zzd CREATOR = new zzd();
    private static final HashMap zzaLS;
    final int mVersionCode;
    final Set zzaLT;
    int zzaNp;
    int zzaNq;

    public int describeContents()
    {
        zzd zzd1 = CREATOR;
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
        return zzza();
    }

    public int getLeftImageOffset()
    {
        return zzaNp;
    }

    public int getTopImageOffset()
    {
        return zzaNq;
    }

    public boolean hasLeftImageOffset()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasTopImageOffset()
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

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd zzd1 = CREATOR;
        zzd.zza(this, parcel, i);
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
            return Integer.valueOf(zzaNp);

        case 3: // '\003'
            return Integer.valueOf(zzaNq);
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

    public zzaLS zzza()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("leftImageOffset", com.google.android.gms.common.server.response.ity.zzaLS("leftImageOffset", 2));
        zzaLS.put("topImageOffset", com.google.android.gms.common.server.response.ity.zzaLS("topImageOffset", 3));
    }

    public ()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    zzaLT(Set set, int i, int j, int k)
    {
        zzaLT = set;
        mVersionCode = i;
        zzaNp = j;
        zzaNq = k;
    }
}
