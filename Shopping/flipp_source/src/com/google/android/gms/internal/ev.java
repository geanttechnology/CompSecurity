// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hn, ha

public class ev
    implements SafeParcelable
{

    public static final hn CREATOR = new hn();
    final int a;
    final HashMap b;
    final String c;
    private final ArrayList d = null;

    ev(int i, ArrayList arraylist, String s)
    {
        a = i;
        b = a(arraylist);
        c = (String)ha.a(s);
        a();
    }

    private static HashMap a(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            a a1 = (a)arraylist.get(i);
            hashmap.put(a1.b, a1.a());
        }

        return hashmap;
    }

    private void a()
    {
        for (Iterator iterator = b.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (HashMap)b.get(obj);
            Iterator iterator1 = ((HashMap) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                ((es.a)((HashMap) (obj)).get((String)iterator1.next())).j = this;
            }
        }

    }

    public final HashMap a(String s)
    {
        return (HashMap)b.get(s);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = b.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            stringbuilder.append(((String) (obj))).append(":\n");
            obj = (HashMap)b.get(obj);
            Iterator iterator1 = ((HashMap) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                stringbuilder.append("  ").append(s).append(": ");
                stringbuilder.append(((HashMap) (obj)).get(s));
            }
        }

        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        hn.a(this, parcel);
    }


    private class a
        implements SafeParcelable
    {

        public static final ho CREATOR = new ho();
        final int a;
        final String b;
        final ArrayList c;

        private static ArrayList a(HashMap hashmap)
        {
            if (hashmap == null)
            {
                return null;
            }
            ArrayList arraylist = new ArrayList();
            String s;
            for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); arraylist.add(new b(s, (es.a)hashmap.get(s))))
            {
                s = (String)iterator.next();
            }

            return arraylist;
        }

        final HashMap a()
        {
            HashMap hashmap = new HashMap();
            int j = c.size();
            for (int i = 0; i < j; i++)
            {
                b b1 = (b)c.get(i);
                hashmap.put(b1.b, b1.c);
            }

            return hashmap;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            ho.a(this, parcel);
        }


        a(int i, String s, ArrayList arraylist)
        {
            a = i;
            b = s;
            c = arraylist;
        }

        a(String s, HashMap hashmap)
        {
            a = 1;
            b = s;
            c = a(hashmap);
        }

        private class b
            implements SafeParcelable
        {

            public static final hm CREATOR = new hm();
            final int a;
            final String b;
            final es.a c;

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
                hm.a(this, parcel, i);
            }


            b(int i, String s, es.a a1)
            {
                a = i;
                b = s;
                c = a1;
            }

            b(String s, es.a a1)
            {
                a = 1;
                b = s;
                c = a1;
            }
        }

    }

}
