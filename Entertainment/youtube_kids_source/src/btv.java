// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class btv
    implements Parcelable, Comparable
{

    public static final android.os.Parcelable.Creator CREATOR = new btw();
    public static final Set a = Collections.emptySet();
    public final String b;
    public final Set c;
    public final int d;

    public btv(amw amw1)
    {
        Object obj;
        if (amw1.a)
        {
            obj = amw1.b;
        } else
        {
            obj = "";
        }
        b = ((String) (obj));
        c = new HashSet();
        int i;
        for (obj = amw1.c.iterator(); ((Iterator) (obj)).hasNext(); c.add(btx.a(i)))
        {
            i = ((Integer)((Iterator) (obj)).next()).intValue();
        }

        int j;
        if (amw1.d)
        {
            j = amw1.e;
        } else
        {
            j = 0;
        }
        d = j;
    }

    public btv(dzw dzw1, Set set)
    {
        b = (String)b.a(dzw1.b);
        c = (Set)b.a(set);
        int i;
        if (dzw1.c != 0)
        {
            i = dzw1.c;
        } else
        {
            i = -1;
        }
        d = i;
    }

    public btv(String s, Set set)
    {
        this(s, set, -1);
    }

    public btv(String s, Set set, int i)
    {
        b = (String)b.a(s);
        c = (Set)b.a(set);
        d = i;
    }

    private int a(btv btv1)
    {
        if (d != btv1.d)
        {
            return d >= btv1.d ? 1 : -1;
        } else
        {
            return b.compareTo(btv1.b);
        }
    }

    public final int a(int i)
    {
        if (d == -1)
        {
            return i;
        } else
        {
            return d;
        }
    }

    public final amw a()
    {
        amw amw1 = (new amw()).a(b).b(d);
        for (Iterator iterator = c.iterator(); iterator.hasNext(); amw1.a(btx.a((btx)iterator.next()))) { }
        return amw1;
    }

    public final int compareTo(Object obj)
    {
        return a((btv)obj);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!(obj instanceof btv))
            {
                break label0;
            }
            obj = (btv)obj;
            if (this != obj)
            {
                flag = flag1;
                if (((btv) (obj)).a(this) != 0)
                {
                    break label0;
                }
                flag = flag1;
                if (hashCode() != ((btv) (obj)).hashCode())
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public final int hashCode()
    {
        return ((b.hashCode() + 31) * 31 + c.hashCode()) * 31 + d;
    }

    public final String toString()
    {
        return (new StringBuilder("@")).append(d).append("s->").append(b).append(c).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a());
    }

}
