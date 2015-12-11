// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.server.response:
//            zzd

public class zzF
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
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); arraylist.add(new apPair(s, (apPair)map.get(s))))
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
            apPair appair = (apPair)zzahh.get(i);
            hashmap.put(appair.key, appair.zzahi);
        }

        return hashmap;
    }


    apPair(int i, String s, ArrayList arraylist)
    {
        versionCode = i;
        className = s;
        zzahh = arraylist;
    }

    zzahh(String s, Map map)
    {
        versionCode = 1;
        className = s;
        zzahh = zzF(map);
    }
}
