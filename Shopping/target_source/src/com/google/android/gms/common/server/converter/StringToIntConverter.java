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
//            b, c

public final class StringToIntConverter
    implements SafeParcelable, com.google.android.gms.common.server.response.FastJsonResponse.a
{
    public static final class Entry
        implements SafeParcelable
    {

        public static final c CREATOR = new c();
        final int a;
        final String b;
        final int c;

        public int describeContents()
        {
            c c1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            c c1 = CREATOR;
            com.google.android.gms.common.server.converter.c.a(this, parcel, i);
        }


        Entry(int i, String s, int j)
        {
            a = i;
            b = s;
            c = j;
        }

        Entry(String s, int i)
        {
            a = 1;
            b = s;
            c = i;
        }
    }


    public static final b CREATOR = new b();
    private final int a;
    private final HashMap b;
    private final HashMap c;
    private final ArrayList d;

    public StringToIntConverter()
    {
        a = 1;
        b = new HashMap();
        c = new HashMap();
        d = null;
    }

    StringToIntConverter(int i, ArrayList arraylist)
    {
        a = i;
        b = new HashMap();
        c = new HashMap();
        d = null;
        a(arraylist);
    }

    private void a(ArrayList arraylist)
    {
        Entry entry;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); a(entry.b, entry.c))
        {
            entry = (Entry)arraylist.next();
        }

    }

    int a()
    {
        return a;
    }

    public StringToIntConverter a(String s, int i)
    {
        b.put(s, Integer.valueOf(i));
        c.put(Integer.valueOf(i), s);
        return this;
    }

    public Object a(Object obj)
    {
        return a((Integer)obj);
    }

    public String a(Integer integer)
    {
        String s = (String)c.get(integer);
        integer = s;
        if (s == null)
        {
            integer = s;
            if (b.containsKey("gms_unknown"))
            {
                integer = "gms_unknown";
            }
        }
        return integer;
    }

    ArrayList b()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = b.keySet().iterator(); iterator.hasNext(); arraylist.add(new Entry(s, ((Integer)b.get(s)).intValue())))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public int describeContents()
    {
        b b1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        b b1 = CREATOR;
        com.google.android.gms.common.server.converter.b.a(this, parcel, i);
    }

}
