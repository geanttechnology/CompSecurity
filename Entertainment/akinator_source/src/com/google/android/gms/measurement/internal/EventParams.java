// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzi

public class EventParams
    implements SafeParcelable, Iterable
{

    public static final zzi CREATOR = new zzi();
    public final int versionCode;
    private final Bundle zzaMh;

    EventParams(int i, Bundle bundle)
    {
        versionCode = i;
        zzaMh = bundle;
    }

    EventParams(Bundle bundle)
    {
        zzx.zzw(bundle);
        zzaMh = bundle;
        versionCode = 1;
    }

    static Bundle zza(EventParams eventparams)
    {
        return eventparams.zzaMh;
    }

    public int describeContents()
    {
        return 0;
    }

    Object get(String s)
    {
        return zzaMh.get(s);
    }

    public Iterator iterator()
    {
        return new Iterator() {

            Iterator zzaMi;
            final EventParams zzaMj;

            public boolean hasNext()
            {
                return zzaMi.hasNext();
            }

            public volatile Object next()
            {
                return next();
            }

            public String next()
            {
                return (String)zzaMi.next();
            }

            public void remove()
            {
                throw new UnsupportedOperationException("Remove not supported");
            }

            
            {
                zzaMj = EventParams.this;
                super();
                zzaMi = EventParams.zza(zzaMj).keySet().iterator();
            }
        };
    }

    public int size()
    {
        return zzaMh.size();
    }

    public String toString()
    {
        return zzaMh.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public Bundle zzzB()
    {
        return new Bundle(zzaMh);
    }

}
