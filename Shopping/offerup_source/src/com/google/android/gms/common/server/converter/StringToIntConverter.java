// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.server.converter:
//            zzb

public final class StringToIntConverter
    implements SafeParcelable, com.google.android.gms.common.server.response.FastJsonResponse.zza
{

    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap zzagP;
    private final HashMap zzagQ;
    private final ArrayList zzagR;

    public StringToIntConverter()
    {
        mVersionCode = 1;
        zzagP = new HashMap();
        zzagQ = new HashMap();
        zzagR = null;
    }

    StringToIntConverter(int i, ArrayList arraylist)
    {
        mVersionCode = i;
        zzagP = new HashMap();
        zzagQ = new HashMap();
        zzagR = null;
        zzb(arraylist);
    }

    private void zzb(ArrayList arraylist)
    {
        Entry entry;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); zzi(entry.zzagS, entry.zzagT))
        {
            entry = (Entry)arraylist.next();
        }

    }

    public final Object convertBack(Object obj)
    {
        return zzb((Integer)obj);
    }

    public final int describeContents()
    {
        return 0;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.server.converter.zzb.zza(this, parcel, i);
    }

    public final String zzb(Integer integer)
    {
        String s = (String)zzagQ.get(integer);
        integer = s;
        if (s == null)
        {
            integer = s;
            if (zzagP.containsKey("gms_unknown"))
            {
                integer = "gms_unknown";
            }
        }
        return integer;
    }

    public final StringToIntConverter zzi(String s, int i)
    {
        zzagP.put(s, Integer.valueOf(i));
        zzagQ.put(Integer.valueOf(i), s);
        return this;
    }

    final ArrayList zzpA()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = zzagP.keySet().iterator(); iterator.hasNext(); arraylist.add(new Entry(s, ((Integer)zzagP.get(s)).intValue())))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public final int zzpB()
    {
        return 7;
    }

    public final int zzpC()
    {
        return 0;
    }


    private class Entry
        implements SafeParcelable
    {

        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzagS;
        final int zzagT;

        public final int describeContents()
        {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i)
        {
            zzc.zza(this, parcel, i);
        }


        Entry(int i, String s, int j)
        {
            versionCode = i;
            zzagS = s;
            zzagT = j;
        }

        Entry(String s, int i)
        {
            versionCode = 1;
            zzagS = s;
            zzagT = i;
        }
    }

}
