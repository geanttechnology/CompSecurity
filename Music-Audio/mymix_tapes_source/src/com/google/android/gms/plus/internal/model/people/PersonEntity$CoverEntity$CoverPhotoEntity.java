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
//            PersonEntity, zze

public static final class zznP extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.toEntity
{

    public static final zze CREATOR = new zze();
    private static final HashMap zzaLS;
    final int mVersionCode;
    String zzF;
    final Set zzaLT;
    int zznP;
    int zznQ;

    public int describeContents()
    {
        zze zze1 = CREATOR;
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
        return zzzb();
    }

    public int getHeight()
    {
        return zznQ;
    }

    public String getUrl()
    {
        return zzF;
    }

    public int getWidth()
    {
        return zznP;
    }

    public boolean hasHeight()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasUrl()
    {
        return zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasWidth()
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
        zze zze1 = CREATOR;
        zze.zza(this, parcel, i);
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
            return Integer.valueOf(zznQ);

        case 3: // '\003'
            return zzF;

        case 4: // '\004'
            return Integer.valueOf(zznP);
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

    public zzaLS zzzb()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("height", com.google.android.gms.common.server.response.ity.zzaLS("height", 2));
        zzaLS.put("url", com.google.android.gms.common.server.response.ity.zzaLS("url", 3));
        zzaLS.put("width", com.google.android.gms.common.server.response.ity.zzaLS("width", 4));
    }

    public a()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    zzaLT(Set set, int i, int j, String s, int k)
    {
        zzaLT = set;
        mVersionCode = i;
        zznQ = j;
        zzF = s;
        zznP = k;
    }
}
