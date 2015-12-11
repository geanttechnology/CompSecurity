// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            hk, hh

public final class ep
    implements SafeParcelable, hk
{

    public static final hh CREATOR = new hh();
    final int a;
    final HashMap b;
    private final HashMap c;
    private final ArrayList d;

    public ep()
    {
        a = 1;
        b = new HashMap();
        c = new HashMap();
        d = null;
    }

    ep(int i, ArrayList arraylist)
    {
        a = i;
        b = new HashMap();
        c = new HashMap();
        d = null;
        a(arraylist);
    }

    private void a(ArrayList arraylist)
    {
        a a1;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); a(a1.b, a1.c))
        {
            a1 = (a)arraylist.next();
        }

    }

    public final ep a(String s, int i)
    {
        b.put(s, Integer.valueOf(i));
        c.put(Integer.valueOf(i), s);
        return this;
    }

    public final Object a(Object obj)
    {
        obj = (Integer)obj;
        String s = (String)c.get(obj);
        obj = s;
        if (s == null)
        {
            obj = s;
            if (b.containsKey("gms_unknown"))
            {
                obj = "gms_unknown";
            }
        }
        return obj;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hh.a(this, parcel);
    }


    private class a
        implements SafeParcelable
    {

        public static final hj CREATOR = new hj();
        final int a;
        final String b;
        final int c;

        public final int describeContents()
        {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i)
        {
            hj.a(this, parcel);
        }


        a(int i, String s, int j)
        {
            a = i;
            b = s;
            c = j;
        }

        a(String s, int i)
        {
            a = 1;
            b = s;
            c = i;
        }
    }

}
