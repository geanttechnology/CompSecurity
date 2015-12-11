// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.personalized:
//            zzb, zza

public class HereContent
    implements SafeParcelable
{
    public static final class Action
        implements SafeParcelable
    {

        public static final zza CREATOR = new zza();
        final int mVersionCode;
        private final String zzQg;
        private final String zzajf;

        public int describeContents()
        {
            zza zza1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof Action))
                {
                    return false;
                }
                obj = (Action)obj;
                if (!zzw.equal(zzajf, ((Action) (obj)).zzajf) || !zzw.equal(zzQg, ((Action) (obj)).zzQg))
                {
                    return false;
                }
            }
            return true;
        }

        public String getTitle()
        {
            return zzajf;
        }

        public String getUri()
        {
            return zzQg;
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                zzajf, zzQg
            });
        }

        public String toString()
        {
            return zzw.zzv(this).zzg("title", zzajf).zzg("uri", zzQg).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zza zza1 = CREATOR;
            zza.zza(this, parcel, i);
        }


        Action(int i, String s, String s1)
        {
            mVersionCode = i;
            zzajf = s;
            zzQg = s1;
        }
    }


    public static final zzb CREATOR = new zzb();
    final int mVersionCode;
    private final String zzaHW;
    private final List zzaHX;

    HereContent(int i, String s, List list)
    {
        mVersionCode = i;
        zzaHW = s;
        zzaHX = list;
    }

    public int describeContents()
    {
        zzb zzb1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof HereContent))
            {
                return false;
            }
            obj = (HereContent)obj;
            if (!zzw.equal(zzaHW, ((HereContent) (obj)).zzaHW) || !zzw.equal(zzaHX, ((HereContent) (obj)).zzaHX))
            {
                return false;
            }
        }
        return true;
    }

    public List getActions()
    {
        return zzaHX;
    }

    public String getData()
    {
        return zzaHW;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaHW, zzaHX
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("data", zzaHW).zzg("actions", zzaHX).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb zzb1 = CREATOR;
        zzb.zza(this, parcel, i);
    }

}
