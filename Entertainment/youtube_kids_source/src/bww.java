// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class bww
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new bwx();
    public final List a;
    public final List b;
    public final List c;
    public final dyz d;
    public final String e;
    public final bwb f;
    public final boolean g;
    public final long h;
    public final boolean i;
    private final long j;
    private final long k;

    bww(dyz dyz1, String s, long l, long l1, boolean flag)
    {
        d = dyz1;
        e = s;
        j = l;
        k = l1;
        g = flag;
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        dla adla[];
        int k1;
        if (dyz1.a != 0L)
        {
            h = TimeUnit.MILLISECONDS.convert(dyz1.a, TimeUnit.SECONDS) + l1;
        } else
        {
            h = 0x7fffffffffffffffL;
        }
        if (!TextUtils.isEmpty(dyz1.e))
        {
            f = bwb.a(Uri.parse(dyz1.e), s, l);
        } else
        {
            f = null;
        }
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        adla = dyz1.b;
        k1 = adla.length;
        for (int i1 = 0; i1 < k1; i1++)
        {
            Object obj1 = adla[i1];
            if (!((dla) (obj1)).m)
            {
                obj1 = new bwb(((dla) (obj1)), s, l);
                arraylist.add(obj1);
                arraylist1.add(obj1);
            }
        }

        dyz1 = dyz1.c;
        k1 = dyz1.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            Object obj = dyz1[j1];
            if (!((dla) (obj)).m)
            {
                obj = new bwb(((dla) (obj)), s, l);
                arraylist.add(obj);
                arraylist2.add(obj);
            }
        }

        a = Collections.unmodifiableList(arraylist);
        b = Collections.unmodifiableList(arraylist1);
        c = Collections.unmodifiableList(arraylist2);
        dyz1 = arraylist2.iterator();
_L4:
        if (!dyz1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((bwb)dyz1.next()).e()) goto _L4; else goto _L3
_L3:
        flag = true;
_L6:
        i = flag;
        return;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private Uri d()
    {
        if (d.e != null)
        {
            return Uri.parse(d.e);
        } else
        {
            return null;
        }
    }

    public final bww a(List list, List list1)
    {
        dyz dyz1 = new dyz();
        try
        {
            eun.a(dyz1, eun.a(d));
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            return this;
        }
        dyz1.c = (dla[])a.a(dyz1.c, list.toArray(new dla[list.size()]));
        dyz1.f = (dov[])a.a(dyz1.f, list1.toArray(new dov[list1.size()]));
        return new bww(dyz1, e, j, k, g);
    }

    public final boolean a()
    {
        return a.isEmpty() && !TextUtils.isEmpty(d.e);
    }

    public final boolean a(long l)
    {
        return l >= h;
    }

    public final Uri b()
    {
        if (d.d != null)
        {
            return Uri.parse(d.d);
        } else
        {
            return null;
        }
    }

    public final boolean c()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            bwb bwb1 = (bwb)iterator.next();
            if (!bwd.k().contains(Integer.valueOf(bwb1.a.b)))
            {
                return false;
            }
        }

        return a.size() > 0;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof bww) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!b.a(e, ((bww) (obj = (bww)obj)).e) || !b.a(d(), ((bww) (obj)).d()) || !b.a(b(), ((bww) (obj)).b()) || g != ((bww) (obj)).g || j != ((bww) (obj)).j || c.size() != ((bww) (obj)).c.size() || b.size() != ((bww) (obj)).b.size() || h != ((bww) (obj)).h)
        {
            continue; /* Loop/switch isn't completed */
        }
        for (int l = 0; l < c.size(); l++)
        {
            if (!b.a(c.get(l), ((bww) (obj)).c.get(l)))
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= b.size())
                {
                    break label1;
                }
                if (!b.a(b.get(i1), ((bww) (obj)).b.get(i1)))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public int hashCode()
    {
        b.b(false);
        return 0;
    }

    public String toString()
    {
        int i1 = a.size();
        Integer ainteger[] = new Integer[i1];
        for (int l = 0; l < i1; l++)
        {
            ainteger[l] = Integer.valueOf(((bwb)a.get(l)).a.b);
        }

        return String.format("ITAGS:{%s} HLS:{%s} DASH:{%s}", new Object[] {
            TextUtils.join(", ", ainteger), d.e, d.d
        });
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        a.a(parcel, d);
        parcel.writeString(e);
        parcel.writeLong(j);
        parcel.writeLong(h);
        if (g)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        parcel.writeInt(l);
    }

}
