// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.server.response:
//            zzc

public class FieldMappingDictionary
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    private final int mVersionCode;
    private final HashMap zzahe;
    private final ArrayList zzahf;
    private final String zzahg;

    FieldMappingDictionary(int i, ArrayList arraylist, String s)
    {
        mVersionCode = i;
        zzahf = null;
        zzahe = zzc(arraylist);
        zzahg = (String)zzx.zzw(s);
        zzpQ();
    }

    public FieldMappingDictionary(Class class1)
    {
        mVersionCode = 1;
        zzahf = null;
        zzahe = new HashMap();
        zzahg = class1.getCanonicalName();
    }

    private static HashMap zzc(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Entry entry = (Entry)arraylist.get(i);
            hashmap.put(entry.className, entry.zzpU());
        }

        return hashmap;
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = zzahe.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            stringbuilder.append(((String) (obj))).append(":\n");
            obj = (Map)zzahe.get(obj);
            Iterator iterator1 = ((Map) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                stringbuilder.append("  ").append(s).append(": ");
                stringbuilder.append(((Map) (obj)).get(s));
            }
        }

        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.server.response.zzc.zza(this, parcel, i);
    }

    public void zza(Class class1, Map map)
    {
        zzahe.put(class1.getCanonicalName(), map);
    }

    public boolean zzb(Class class1)
    {
        return zzahe.containsKey(class1.getCanonicalName());
    }

    public Map zzcw(String s)
    {
        return (Map)zzahe.get(s);
    }

    public void zzpQ()
    {
        for (Iterator iterator = zzahe.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (Map)zzahe.get(obj);
            Iterator iterator1 = ((Map) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                ((FastJsonResponse.Field)((Map) (obj)).get((String)iterator1.next())).zza(this);
            }
        }

    }

    public void zzpR()
    {
        String s;
        HashMap hashmap;
        for (Iterator iterator = zzahe.keySet().iterator(); iterator.hasNext(); zzahe.put(s, hashmap))
        {
            s = (String)iterator.next();
            Map map = (Map)zzahe.get(s);
            hashmap = new HashMap();
            String s1;
            for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); hashmap.put(s1, ((FastJsonResponse.Field)map.get(s1)).zzpG()))
            {
                s1 = (String)iterator1.next();
            }

        }

    }

    ArrayList zzpS()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = zzahe.keySet().iterator(); iterator.hasNext(); arraylist.add(new Entry(s, (Map)zzahe.get(s))))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public String zzpT()
    {
        return zzahg;
    }


    private class Entry
        implements SafeParcelable
    {

        public static final zzd CREATOR = new zzd();
        final String className;
        final int versionCode;
        final ArrayList zzahh;

        private static ArrayList zzF(Map map)
        {
            if (map == null)
            {
                return null;
            }
            ArrayList arraylist = new ArrayList();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); arraylist.add(new FieldMapPair(s, (FastJsonResponse.Field)map.get(s))))
            {
                s = (String)iterator.next();
            }

            return arraylist;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzd.zza(this, parcel, i);
        }

        HashMap zzpU()
        {
            HashMap hashmap = new HashMap();
            int j = zzahh.size();
            for (int i = 0; i < j; i++)
            {
                FieldMapPair fieldmappair = (FieldMapPair)zzahh.get(i);
                hashmap.put(fieldmappair.key, fieldmappair.zzahi);
            }

            return hashmap;
        }


        Entry(int i, String s, ArrayList arraylist)
        {
            versionCode = i;
            className = s;
            zzahh = arraylist;
        }

        Entry(String s, Map map)
        {
            versionCode = 1;
            className = s;
            zzahh = zzF(map);
        }

        private class FieldMapPair
            implements SafeParcelable
        {

            public static final zzb CREATOR = new zzb();
            final String key;
            final int versionCode;
            final FastJsonResponse.Field zzahi;

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
                com.google.android.gms.common.server.response.zzb.zza(this, parcel, i);
            }


            FieldMapPair(int i, String s, FastJsonResponse.Field field)
            {
                versionCode = i;
                key = s;
                zzahi = field;
            }

            FieldMapPair(String s, FastJsonResponse.Field field)
            {
                versionCode = 1;
                key = s;
                zzahi = field;
            }
        }

    }

}
