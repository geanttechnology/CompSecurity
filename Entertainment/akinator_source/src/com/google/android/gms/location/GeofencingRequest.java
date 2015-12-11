// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
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

        private final List zzaEt = new ArrayList();
        private int zzaEu;

        public static int zzgM(int i)
        {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence)
        {
            zzx.zzb(geofence, "geofence can't be null.");
            zzx.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            zzaEt.add((ParcelableGeofence)geofence);
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
            if (!zzaEt.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "No geofence has been added to this request.");
            return new GeofencingRequest(zzaEt, zzaEu);
        }

        public Builder setInitialTrigger(int i)
        {
            zzaEu = zzgM(i);
            return this;
        }

        public Builder()
        {
            zzaEu = 5;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int mVersionCode;
    private final List zzaEt;
    private final int zzaEu;

    GeofencingRequest(int i, List list, int j)
    {
        mVersionCode = i;
        zzaEt = list;
        zzaEu = j;
    }

    private GeofencingRequest(List list, int i)
    {
        this(1, list, i);
    }


    public int describeContents()
    {
        return 0;
    }

    public List getGeofences()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(zzaEt);
        return arraylist;
    }

    public int getInitialTrigger()
    {
        return zzaEu;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public List zzwv()
    {
        return zzaEt;
    }

}
