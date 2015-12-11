// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bst
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new bsu();
    private static String g = "https://s.youtube.com/api/stats/playback";
    private static String h = "https://s.youtube.com/api/stats/watchtime";
    private static String i = "https://s.youtube.com/api/stats/qoe";
    private static final Set j;
    private static final Set k;
    public final btv a;
    public final btv b;
    public final btv c;
    public final btv d;
    public final btv e;
    public final List f;
    private final boolean l;

    public bst()
    {
        this(((dti) (null)));
    }

    public bst(amt amt1)
    {
        l = amt1.l;
        if (amt1.a)
        {
            b = new btv(amt1.b);
        } else
        {
            b = new btv("https://s.youtube.com/api/stats/playback", btv.a);
        }
        if (amt1.c)
        {
            c = new btv(amt1.d);
        } else
        {
            c = new btv("https://s.youtube.com/api/stats/delayplay", btv.a);
        }
        if (amt1.e)
        {
            d = new btv(amt1.f);
        } else
        {
            d = new btv("https://s.youtube.com/api/stats/watchtime", btv.a);
        }
        if (amt1.g)
        {
            e = new btv(amt1.h);
        } else
        {
            e = new btv("https://s.youtube.com/api/stats/qoe", btv.a);
        }
        f = new ArrayList();
        amw amw1;
        for (Iterator iterator = amt1.i.iterator(); iterator.hasNext(); f.add(new btv(amw1)))
        {
            amw1 = (amw)iterator.next();
        }

        if (amt1.j)
        {
            amt1 = new btv(amt1.k);
        } else
        {
            amt1 = null;
        }
        a = amt1;
    }

    public bst(dti dti1)
    {
        Object obj;
        boolean flag;
        if (dti1 != null && dti1.g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = flag;
        if (dti1 != null && dti1.a != null)
        {
            obj = dti1.a.b;
        } else
        {
            obj = g;
        }
        b = new btv(((String) (obj)), btv.a);
        if (dti1 != null && dti1.b != null)
        {
            c = new btv(dti1.b, btv.a);
        } else
        {
            c = new btv("https://s.youtube.com/api/stats/delayplay", btv.a);
        }
        if (dti1 != null && dti1.c != null)
        {
            obj = dti1.c.b;
        } else
        {
            obj = h;
        }
        d = new btv(((String) (obj)), btv.a);
        if (dti1 != null && dti1.e != null)
        {
            obj = dti1.e.b;
        } else
        {
            obj = i;
        }
        e = new btv(((String) (obj)), btv.a);
        if (dti1 != null && dti1.h != null)
        {
            obj = new btv(dti1.h, btv.a);
        } else
        {
            obj = null;
        }
        a = ((btv) (obj));
        f = new ArrayList();
        if (dti1 != null && dti1.d != null)
        {
            f.add(new btv(dti1.d.b, j, 0));
        }
        if (dti1 != null && dti1.f != null)
        {
            f.add(new btv(dti1.f.b, k, dti1.f.c));
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && getClass().equals(obj.getClass()))
        {
            obj = (bst)obj;
            if (b.a(b, ((bst) (obj)).b) && b.a(c, ((bst) (obj)).c) && b.a(d, ((bst) (obj)).d) && b.a(e, ((bst) (obj)).e) && b.a(f, ((bst) (obj)).f) && b.a(a, ((bst) (obj)).a) && l == ((bst) (obj)).l)
            {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        amt amt1 = new amt();
        amt1.a(b.a()).b(c.a()).c(d.a()).d(e.a()).a(l);
        if (a != null)
        {
            amt1.f(a.a());
        }
        for (Iterator iterator = f.iterator(); iterator.hasNext(); amt1.e(((btv)iterator.next()).a())) { }
        a.a(parcel, amt1);
    }

    static 
    {
        HashSet hashset = new HashSet();
        j = hashset;
        hashset.add(btx.c);
        hashset = new HashSet();
        k = hashset;
        hashset.add(btx.a);
    }
}
