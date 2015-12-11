// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.altbeacon.beacon:
//            e, Beacon

public class Region
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected final List a;
    protected final String b;

    protected Region(Parcel parcel)
    {
        b = parcel.readString();
        int j = parcel.readInt();
        a = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            Object obj = parcel.readString();
            if (obj == null)
            {
                a.add(null);
            } else
            {
                obj = e.a(((String) (obj)));
                a.add(obj);
            }
            i++;
        }
    }

    public Region(String s, List list)
    {
        a = new ArrayList(list);
        b = s;
        if (s == null)
        {
            throw new NullPointerException("uniqueId may not be null");
        } else
        {
            return;
        }
    }

    public Region(String s, e e1, e e2, e e3)
    {
        a = new ArrayList(3);
        a.add(e1);
        a.add(e2);
        a.add(e3);
        b = s;
        if (s == null)
        {
            throw new NullPointerException("uniqueId may not be null");
        } else
        {
            return;
        }
    }

    public String a()
    {
        return b;
    }

    public boolean a(Beacon beacon)
    {
        int i = 0;
_L3:
        if (i >= a.size())
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L1
_L5:
        i++;
        if (true) goto _L3; else goto _L2
_L1:
        if (beacon.h().size() <= i && a.get(i) == null || a.get(i) == null || ((e)a.get(i)).equals(beacon.c.get(i))) goto _L5; else goto _L4
_L4:
        return false;
_L2:
        return true;
    }

    public Region b()
    {
        return new Region(b, a);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return b();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Region)
        {
            return ((Region)obj).b.equals(b);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return b.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = a.iterator();
        int i = 1;
        while (iterator.hasNext()) 
        {
            Object obj = (e)iterator.next();
            if (i > 1)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append("id");
            stringbuilder.append(i);
            stringbuilder.append(": ");
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((e) (obj)).toString();
            }
            stringbuilder.append(((String) (obj)));
            i++;
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(b);
        parcel.writeInt(a.size());
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            e e1 = (e)iterator.next();
            if (e1 != null)
            {
                parcel.writeString(e1.toString());
            } else
            {
                parcel.writeString(null);
            }
        }

    }


    /* member class not found */
    class _cls1 {}

}
