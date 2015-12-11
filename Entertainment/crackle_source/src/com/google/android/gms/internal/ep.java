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
//            eq, er

public final class ep
    implements SafeParcelable, es.b
{
    public static final class a
        implements SafeParcelable
    {

        public static final er CREATOR = new er();
        final String qg;
        final int qh;
        final int versionCode;

        public int describeContents()
        {
            er er1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            er er1 = CREATOR;
            er.a(this, parcel, i);
        }


        a(int i, String s, int j)
        {
            versionCode = i;
            qg = s;
            qh = j;
        }

        a(String s, int i)
        {
            versionCode = 1;
            qg = s;
            qh = i;
        }
    }


    public static final eq CREATOR = new eq();
    private final int kg;
    private final HashMap qd;
    private final HashMap qe;
    private final ArrayList qf;

    public ep()
    {
        kg = 1;
        qd = new HashMap();
        qe = new HashMap();
        qf = null;
    }

    ep(int i, ArrayList arraylist)
    {
        kg = i;
        qd = new HashMap();
        qe = new HashMap();
        qf = null;
        a(arraylist);
    }

    private void a(ArrayList arraylist)
    {
        a a1;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); c(a1.qg, a1.qh))
        {
            a1 = (a)arraylist.next();
        }

    }

    public String a(Integer integer)
    {
        String s = (String)qe.get(integer);
        integer = s;
        if (s == null)
        {
            integer = s;
            if (qd.containsKey("gms_unknown"))
            {
                integer = "gms_unknown";
            }
        }
        return integer;
    }

    public ep c(String s, int i)
    {
        qd.put(s, Integer.valueOf(i));
        qe.put(Integer.valueOf(i), s);
        return this;
    }

    ArrayList cg()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = qd.keySet().iterator(); iterator.hasNext(); arraylist.add(new a(s, ((Integer)qd.get(s)).intValue())))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public int ch()
    {
        return 7;
    }

    public int ci()
    {
        return 0;
    }

    public int describeContents()
    {
        eq eq1 = CREATOR;
        return 0;
    }

    public Object g(Object obj)
    {
        return a((Integer)obj);
    }

    int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        eq eq1 = CREATOR;
        eq.a(this, parcel, i);
    }

}
