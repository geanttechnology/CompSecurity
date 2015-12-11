// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            zza, Geofence

public class GeofencingRequest
    implements SafeParcelable
{
    public static final class Builder
    {

        private final List zzaxJ = new ArrayList();
        private int zzaxK;

        public static int zzgr(int i)
        {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence)
        {
            zzu.zzb(geofence, "geofence can't be null.");
            zzu.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            zzaxJ.add((ParcelableGeofence)geofence);
            return this;
        }

        public Builder addGeofences(List list)
        {
            if (list != null && !list.isEmpty())
            {
                list = list.iterator();
                while (list.hasNext()) 
                {
                    Geofence geofence = (Geofence)list.next();
                    if (geofence != null)
                    {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build()
        {
            boolean flag;
            if (!zzaxJ.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzu.zzb(flag, "No geofence has been added to this request.");
            return new GeofencingRequest(zzaxJ, zzaxK);
        }

        public Builder setInitialTrigger(int i)
        {
            zzaxK = zzgr(i);
            return this;
        }

        public Builder()
        {
            zzaxK = 5;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int zzCY;
    private final List zzaxJ;
    private final int zzaxK;

    GeofencingRequest(int i, List list, int j)
    {
        zzCY = i;
        zzaxJ = list;
        zzaxK = j;
    }

    private GeofencingRequest(List list, int i)
    {
        this(1, list, i);
    }


    public int describeContents()
    {
        return 0;
    }

    public int getInitialTrigger()
    {
        return zzaxK;
    }

    public int getVersionCode()
    {
        return zzCY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public List zzun()
    {
        return zzaxJ;
    }

}
