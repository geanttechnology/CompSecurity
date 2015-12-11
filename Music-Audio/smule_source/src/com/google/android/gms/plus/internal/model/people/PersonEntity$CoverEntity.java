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
//            zzc

public final class zzaAY extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.onResponse
{

    public static final zzc CREATOR = new zzc();
    private static final HashMap zzazC;
    CoverInfoEntity zzaAW;
    CoverPhotoEntity zzaAX;
    int zzaAY;
    final Set zzazD;
    final int zzzH;

    public int describeContents()
    {
        zzc zzc1 = CREATOR;
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
                for (Iterator iterator = zzazC.values().iterator(); iterator.hasNext();)
                {
                    ity = (com.google.android.gms.common.server.response.ity.zzazC)iterator.next();
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
        return zzvR();
    }

    public com.google.android.gms.plus.model.people.erEntity getCoverInfo()
    {
        return zzaAW;
    }

    public com.google.android.gms.plus.model.people.erEntity getCoverPhoto()
    {
        return zzaAX;
    }

    public int getLayout()
    {
        return zzaAY;
    }

    public boolean hasCoverInfo()
    {
        return zzazD.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
        return zzazD.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
        return zzazD.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
        Iterator iterator = zzazC.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.server.response.ity ity = (com.google.android.gms.common.server.response.ity.zzazC)iterator.next();
            if (zza(ity))
            {
                int j = ity.mF();
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
        zzc zzc1 = CREATOR;
        zzc.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.ity ity)
    {
        return zzazD.contains(Integer.valueOf(ity.mF()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.mF())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.mF()).toString());

        case 2: // '\002'
            return zzaAW;

        case 3: // '\003'
            return zzaAX;

        case 4: // '\004'
            return Integer.valueOf(zzaAY);
        }
    }

    public Map zzmy()
    {
        return zzvL();
    }

    public HashMap zzvL()
    {
        return zzazC;
    }

    public zzazC zzvR()
    {
        return this;
    }

    static 
    {
        zzazC = new HashMap();
        zzazC.put("coverInfo", com.google.android.gms.common.server.response.a("coverInfo", 2, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverInfoEntity));
        zzazC.put("coverPhoto", com.google.android.gms.common.server.response.a("coverPhoto", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverPhotoEntity));
        zzazC.put("layout", com.google.android.gms.common.server.response.a("layout", 4, (new StringToIntConverter()).zzg("banner", 0), false));
    }

    public CoverPhotoEntity()
    {
        zzzH = 1;
        zzazD = new HashSet();
    }

    CoverPhotoEntity(Set set, int i, CoverInfoEntity coverinfoentity, CoverPhotoEntity coverphotoentity, int j)
    {
        zzazD = set;
        zzzH = i;
        zzaAW = coverinfoentity;
        zzaAX = coverphotoentity;
        zzaAY = j;
    }
}
