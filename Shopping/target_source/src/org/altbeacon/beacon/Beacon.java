// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.a.a;
import org.altbeacon.beacon.a.b;
import org.altbeacon.beacon.c.c;

// Referenced classes of package org.altbeacon.beacon:
//            e

public class Beacon
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected static boolean a = false;
    protected static org.altbeacon.beacon.b.c b = null;
    protected static a j = new b();
    private static final List o = Collections.unmodifiableList(new ArrayList());
    private static final List p = Collections.unmodifiableList(new ArrayList());
    protected List c;
    protected List d;
    protected List e;
    protected Double f;
    protected int g;
    protected int h;
    protected String i;
    protected int k;
    protected int l;
    protected int m;
    protected String n;
    private Double q;

    protected Beacon()
    {
        q = null;
        m = -1;
        c = new ArrayList(1);
        d = new ArrayList(1);
        e = new ArrayList(1);
    }

    protected Beacon(Parcel parcel)
    {
        boolean flag = false;
        super();
        q = null;
        m = -1;
        int l1 = parcel.readInt();
        c = new ArrayList(l1);
        for (int i1 = 0; i1 < l1; i1++)
        {
            c.add(org.altbeacon.beacon.e.a(parcel.readString()));
        }

        f = Double.valueOf(parcel.readDouble());
        g = parcel.readInt();
        h = parcel.readInt();
        i = parcel.readString();
        k = parcel.readInt();
        m = parcel.readInt();
        l1 = parcel.readInt();
        d = new ArrayList(l1);
        for (int j1 = 0; j1 < l1; j1++)
        {
            d.add(Long.valueOf(parcel.readLong()));
        }

        l1 = parcel.readInt();
        if (org.altbeacon.beacon.c.c.a())
        {
            org.altbeacon.beacon.c.c.a("Beacon", (new StringBuilder()).append("reading ").append(l1).append(" extra data fields from parcel").toString(), new Object[0]);
        }
        e = new ArrayList(l1);
        for (int k1 = ((flag) ? 1 : 0); k1 < l1; k1++)
        {
            e.add(Long.valueOf(parcel.readLong()));
        }

        l = parcel.readInt();
        n = parcel.readString();
    }

    protected static Double a(int i1, double d1)
    {
        if (a() != null)
        {
            return Double.valueOf(a().a(i1, d1));
        } else
        {
            org.altbeacon.beacon.c.c.d("Beacon", "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
            return Double.valueOf(-1D);
        }
    }

    public static org.altbeacon.beacon.b.c a()
    {
        return b;
    }

    public static void a(org.altbeacon.beacon.b.c c1)
    {
        b = c1;
    }

    public void a(double d1)
    {
        q = Double.valueOf(d1);
        f = null;
    }

    public void a(int i1)
    {
        g = i1;
    }

    public void a(List list)
    {
        e = list;
    }

    public int b()
    {
        return m;
    }

    public e c()
    {
        return (e)c.get(0);
    }

    public e d()
    {
        return (e)c.get(1);
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return (e)c.get(2);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Beacon) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (c.size() == ((Beacon) (obj = (Beacon)obj)).c.size())
        {
            int i1 = 0;
label0:
            do
            {
label1:
                {
                    if (i1 >= c.size())
                    {
                        break label1;
                    }
                    if (!((e)c.get(i1)).equals(((Beacon) (obj)).c.get(i1)))
                    {
                        break label0;
                    }
                    i1++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (a)
        {
            flag = k().equals(((Beacon) (obj)).k());
        } else
        {
            flag = true;
        }
        return flag;
    }

    public List f()
    {
        if (d.getClass().isInstance(o))
        {
            return d;
        } else
        {
            return Collections.unmodifiableList(d);
        }
    }

    public List g()
    {
        if (e.getClass().isInstance(o))
        {
            return e;
        } else
        {
            return Collections.unmodifiableList(e);
        }
    }

    public List h()
    {
        if (c.getClass().isInstance(p))
        {
            return c;
        } else
        {
            return Collections.unmodifiableList(c);
        }
    }

    public int hashCode()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = c.iterator();
        for (int i1 = 1; iterator.hasNext(); i1++)
        {
            e e1 = (e)iterator.next();
            stringbuilder.append("id");
            stringbuilder.append(i1);
            stringbuilder.append(": ");
            stringbuilder.append(e1.toString());
            stringbuilder.append(" ");
        }

        if (a)
        {
            stringbuilder.append(i);
        }
        return stringbuilder.toString().hashCode();
    }

    public double i()
    {
        if (f == null)
        {
            double d1 = g;
            if (q != null)
            {
                d1 = q.doubleValue();
            } else
            {
                org.altbeacon.beacon.c.c.a("Beacon", "Not using running average RSSI because it is null", new Object[0]);
            }
            f = a(h, d1);
        }
        return f.doubleValue();
    }

    public int j()
    {
        return g;
    }

    public String k()
    {
        return i;
    }

    public boolean l()
    {
        return c.size() == 0 && d.size() != 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = c.iterator();
        int i1 = 1;
        while (iterator.hasNext()) 
        {
            Object obj = (e)iterator.next();
            if (i1 > 1)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append("id");
            stringbuilder.append(i1);
            stringbuilder.append(": ");
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((e) (obj)).toString();
            }
            stringbuilder.append(((String) (obj)));
            i1++;
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeInt(c.size());
        org.altbeacon.beacon.c.c.a("Beacon", "serializing identifiers of size %s", new Object[] {
            Integer.valueOf(c.size())
        });
        Iterator iterator2 = c.iterator();
        while (iterator2.hasNext()) 
        {
            Object obj = (e)iterator2.next();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((e) (obj)).toString();
            }
            parcel.writeString(((String) (obj)));
        }
        parcel.writeDouble(i());
        parcel.writeInt(g);
        parcel.writeInt(h);
        parcel.writeString(i);
        parcel.writeInt(k);
        parcel.writeInt(m);
        parcel.writeInt(d.size());
        for (Iterator iterator = d.iterator(); iterator.hasNext(); parcel.writeLong(((Long)iterator.next()).longValue())) { }
        if (org.altbeacon.beacon.c.c.a())
        {
            org.altbeacon.beacon.c.c.a("Beacon", (new StringBuilder()).append("writing ").append(e.size()).append(" extra data fields to parcel").toString(), new Object[0]);
        }
        parcel.writeInt(e.size());
        for (Iterator iterator1 = e.iterator(); iterator1.hasNext(); parcel.writeLong(((Long)iterator1.next()).longValue())) { }
        parcel.writeInt(l);
        parcel.writeString(n);
    }


    /* member class not found */
    class _cls1 {}

}
