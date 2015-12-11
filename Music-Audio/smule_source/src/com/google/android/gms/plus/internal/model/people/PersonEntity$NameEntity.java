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
//            zzg

public final class zzaBe extends FastSafeParcelableJsonResponse
    implements com.google.android.gms.plus.model.people.sonResponse
{

    public static final zzg CREATOR = new zzg();
    private static final HashMap zzazC;
    String zzaAb;
    String zzaAe;
    String zzaBb;
    String zzaBc;
    String zzaBd;
    String zzaBe;
    final Set zzazD;
    final int zzzH;

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
        return zzvV();
    }

    public String getFamilyName()
    {
        return zzaAb;
    }

    public String getFormatted()
    {
        return zzaBb;
    }

    public String getGivenName()
    {
        return zzaAe;
    }

    public String getHonorificPrefix()
    {
        return zzaBc;
    }

    public String getHonorificSuffix()
    {
        return zzaBd;
    }

    public String getMiddleName()
    {
        return zzaBe;
    }

    public boolean hasFamilyName()
    {
        return zzazD.contains(Integer.valueOf(2));
    }

    public boolean hasFormatted()
    {
        return zzazD.contains(Integer.valueOf(3));
    }

    public boolean hasGivenName()
    {
        return zzazD.contains(Integer.valueOf(4));
    }

    public boolean hasHonorificPrefix()
    {
        return zzazD.contains(Integer.valueOf(5));
    }

    public boolean hasHonorificSuffix()
    {
        return zzazD.contains(Integer.valueOf(6));
    }

    public boolean hasMiddleName()
    {
        return zzazD.contains(Integer.valueOf(7));
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
                int j = ity.zmF();
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
        return zzazD.contains(Integer.valueOf(ity.zmF()));
    }

    protected Object zzb(com.google.android.gms.common.server.response.ity ity)
    {
        switch (ity.zmF())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(ity.zmF()).toString());

        case 2: // '\002'
            return zzaAb;

        case 3: // '\003'
            return zzaBb;

        case 4: // '\004'
            return zzaAe;

        case 5: // '\005'
            return zzaBc;

        case 6: // '\006'
            return zzaBd;

        case 7: // '\007'
            return zzaBe;
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

    public zzazC zzvV()
    {
        return this;
    }

    static 
    {
        zzazC = new HashMap();
        zzazC.put("familyName", com.google.android.gms.common.server.response.zk("familyName", 2));
        zzazC.put("formatted", com.google.android.gms.common.server.response.zk("formatted", 3));
        zzazC.put("givenName", com.google.android.gms.common.server.response.zk("givenName", 4));
        zzazC.put("honorificPrefix", com.google.android.gms.common.server.response.zk("honorificPrefix", 5));
        zzazC.put("honorificSuffix", com.google.android.gms.common.server.response.zk("honorificSuffix", 6));
        zzazC.put("middleName", com.google.android.gms.common.server.response.zk("middleName", 7));
    }

    public se()
    {
        zzzH = 1;
        zzazD = new HashSet();
    }

    zzazD(Set set, int i, String s, String s1, String s2, String s3, String s4, 
            String s5)
    {
        zzazD = set;
        zzzH = i;
        zzaAb = s;
        zzaBb = s1;
        zzaAe = s2;
        zzaBc = s3;
        zzaBd = s4;
        zzaBe = s5;
    }
}
