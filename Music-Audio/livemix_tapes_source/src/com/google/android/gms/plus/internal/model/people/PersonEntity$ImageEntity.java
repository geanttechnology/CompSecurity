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
//            PersonEntity, zzf

public static final class zzF extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.onResponse
{

    public static final zzf CREATOR = new zzf();
    private static final HashMap zzaLS;
    final int mVersionCode;
    String zzF;
    final Set zzaLT;

    public int describeContents()
    {
        zzf zzf1 = CREATOR;
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
        return zzzc();
    }

    public String getUrl()
    {
        return zzF;
    }

    public boolean hasUrl()
    {
        return zzaLT.contains(Integer.valueOf(2));
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
                int j = ity.pi();
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
        zzf zzf1 = CREATOR;
        zzf.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.ity ity)
    {
        return zzaLT.contains(Integer.valueOf(ity.pi()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.pi())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.pi()).toString());

        case 2: // '\002'
            return zzF;
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

    public zzaLS zzzc()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("url", com.google.android.gms.common.server.response.m("url", 2));
    }

    public e()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    public zzaLT(String s)
    {
        zzaLT = new HashSet();
        mVersionCode = 1;
        zzF = s;
        zzaLT.add(Integer.valueOf(2));
    }

    zzaLT(Set set, int i, String s)
    {
        zzaLT = set;
        mVersionCode = i;
        zzF = s;
    }
}
