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
//            ew, eg, ex, eu

public class ev
    implements SafeParcelable
{
    public static class a
        implements SafeParcelable
    {

        public static final ex CREATOR = new ex();
        final String className;
        final ArrayList qv;
        final int versionCode;

        private static ArrayList b(HashMap hashmap)
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

        HashMap cA()
        {
            HashMap hashmap = new HashMap();
            int j = qv.size();
            for (int i = 0; i < j; i++)
            {
                b b1 = (b)qv.get(i);
                hashmap.put(b1.qw, b1.qx);
            }

            return hashmap;
        }

        public int describeContents()
        {
            ex ex1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            ex ex1 = CREATOR;
            ex.a(this, parcel, i);
        }


        a(int i, String s, ArrayList arraylist)
        {
            versionCode = i;
            className = s;
            qv = arraylist;
        }

        a(String s, HashMap hashmap)
        {
            versionCode = 1;
            className = s;
            qv = b(hashmap);
        }
    }

    public static class b
        implements SafeParcelable
    {

        public static final eu CREATOR = new eu();
        final String qw;
        final es.a qx;
        final int versionCode;

        public int describeContents()
        {
            eu eu1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            eu eu1 = CREATOR;
            eu.a(this, parcel, i);
        }


        b(int i, String s, es.a a1)
        {
            versionCode = i;
            qw = s;
            qx = a1;
        }

        b(String s, es.a a1)
        {
            versionCode = 1;
            qw = s;
            qx = a1;
        }
    }


    public static final ew CREATOR = new ew();
    private final int kg;
    private final HashMap qs;
    private final ArrayList qt;
    private final String qu;

    ev(int i, ArrayList arraylist, String s)
    {
        kg = i;
        qt = null;
        qs = b(arraylist);
        qu = (String)eg.f(s);
        cw();
    }

    public ev(Class class1)
    {
        kg = 1;
        qt = null;
        qs = new HashMap();
        qu = class1.getCanonicalName();
    }

    private static HashMap b(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            a a1 = (a)arraylist.get(i);
            hashmap.put(a1.className, a1.cA());
        }

        return hashmap;
    }

    public HashMap Z(String s)
    {
        return (HashMap)qs.get(s);
    }

    public void a(Class class1, HashMap hashmap)
    {
        qs.put(class1.getCanonicalName(), hashmap);
    }

    public boolean b(Class class1)
    {
        return qs.containsKey(class1.getCanonicalName());
    }

    public void cw()
    {
        for (Iterator iterator = qs.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (HashMap)qs.get(obj);
            Iterator iterator1 = ((HashMap) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                ((es.a)((HashMap) (obj)).get((String)iterator1.next())).a(this);
            }
        }

    }

    public void cx()
    {
        String s;
        HashMap hashmap1;
        for (Iterator iterator = qs.keySet().iterator(); iterator.hasNext(); qs.put(s, hashmap1))
        {
            s = (String)iterator.next();
            HashMap hashmap = (HashMap)qs.get(s);
            hashmap1 = new HashMap();
            String s1;
            for (Iterator iterator1 = hashmap.keySet().iterator(); iterator1.hasNext(); hashmap1.put(s1, ((es.a)hashmap.get(s1)).cm()))
            {
                s1 = (String)iterator1.next();
            }

        }

    }

    ArrayList cy()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = qs.keySet().iterator(); iterator.hasNext(); arraylist.add(new a(s, (HashMap)qs.get(s))))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public String cz()
    {
        return qu;
    }

    public int describeContents()
    {
        ew ew1 = CREATOR;
        return 0;
    }

    int getVersionCode()
    {
        return kg;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = qs.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            stringbuilder.append(((String) (obj))).append(":\n");
            obj = (HashMap)qs.get(obj);
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
        ew ew1 = CREATOR;
        ew.a(this, parcel, i);
    }

}
