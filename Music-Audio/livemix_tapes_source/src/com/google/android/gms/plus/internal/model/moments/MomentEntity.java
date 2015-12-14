// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.moments:
//            zzb, ItemScopeEntity

public final class MomentEntity extends FastSafeParcelableJsonResponse
    implements Moment
{

    public static final zzb CREATOR = new zzb();
    private static final HashMap zzaLS;
    final int mVersionCode;
    String zzFz;
    final Set zzaLT;
    String zzaMG;
    ItemScopeEntity zzaMO;
    ItemScopeEntity zzaMP;
    String zzwj;

    public MomentEntity()
    {
        mVersionCode = 1;
        zzaLT = new HashSet();
    }

    MomentEntity(Set set, int i, String s, ItemScopeEntity itemscopeentity, String s1, ItemScopeEntity itemscopeentity1, String s2)
    {
        zzaLT = set;
        mVersionCode = i;
        zzwj = s;
        zzaMO = itemscopeentity;
        zzaMG = s1;
        zzaMP = itemscopeentity1;
        zzFz = s2;
    }

    public MomentEntity(Set set, String s, ItemScopeEntity itemscopeentity, String s1, ItemScopeEntity itemscopeentity1, String s2)
    {
        zzaLT = set;
        mVersionCode = 1;
        zzwj = s;
        zzaMO = itemscopeentity;
        zzaMG = s1;
        zzaMP = itemscopeentity1;
        zzFz = s2;
    }

    public int describeContents()
    {
        zzb zzb1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof MomentEntity))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (MomentEntity)obj;
            com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
            do
            {
                for (Iterator iterator = zzaLS.values().iterator(); iterator.hasNext();)
                {
                    field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                    if (!zza(field))
                    {
                        continue label1;
                    }
                    if (((MomentEntity) (obj)).zza(field))
                    {
                        if (!zzb(field).equals(((MomentEntity) (obj)).zzb(field)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((MomentEntity) (obj)).zza(field));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzyV();
    }

    public String getId()
    {
        return zzwj;
    }

    public ItemScope getResult()
    {
        return zzaMO;
    }

    public String getStartDate()
    {
        return zzaMG;
    }

    public ItemScope getTarget()
    {
        return zzaMP;
    }

    public String getType()
    {
        return zzFz;
    }

    public boolean hasId()
    {
        return zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasResult()
    {
        return zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate()
    {
        return zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasTarget()
    {
        return zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasType()
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
            com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
            if (zza(field))
            {
                int j = field.zzpi();
                i = zzb(field).hashCode() + (i + j);
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
        zzb zzb1 = CREATOR;
        com.google.android.gms.plus.internal.model.moments.zzb.zza(this, parcel, i);
    }

    protected boolean zza(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.zzpi())
        {
        case 3: // '\003'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(field.zzpi()).toString());

        case 2: // '\002'
            return zzwj;

        case 4: // '\004'
            return zzaMO;

        case 5: // '\005'
            return zzaMG;

        case 6: // '\006'
            return zzaMP;

        case 7: // '\007'
            return zzFz;
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

    public MomentEntity zzyV()
    {
        return this;
    }

    static 
    {
        zzaLS = new HashMap();
        zzaLS.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("id", 2));
        zzaLS.put("result", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("result", 4, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("startDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("startDate", 5));
        zzaLS.put("target", com.google.android.gms.common.server.response.FastJsonResponse.Field.zza("target", 6, com/google/android/gms/plus/internal/model/moments/ItemScopeEntity));
        zzaLS.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.zzm("type", 7));
    }
}
