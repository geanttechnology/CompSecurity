// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.geocoderlib.enums.GeocodingTypes;
import java.util.ArrayList;
import java.util.Iterator;

public class aoq
{

    private ArrayList a;
    private String b;
    private boolean c;
    private ArrayList d;
    private apa e;
    private boolean f;
    private String g;
    private String h;
    private String i;

    public aoq()
    {
        a = new ArrayList();
        d = new ArrayList();
        e = new apa();
        f = false;
    }

    public String a()
    {
        if (f)
        {
            return i;
        } else
        {
            return b;
        }
    }

    public void a(aoz aoz)
    {
        d.add(aoz);
    }

    public void a(apa apa1)
    {
        e = apa1;
    }

    public void a(String s)
    {
        b = s;
    }

    public void a(ArrayList arraylist)
    {
        a = arraylist;
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public ArrayList b()
    {
        return d;
    }

    public boolean b(ArrayList arraylist)
    {
        arraylist = arraylist.iterator();
        boolean flag = false;
        while (arraylist.hasNext()) 
        {
            GeocodingTypes geocodingtypes = (GeocodingTypes)arraylist.next();
            Iterator iterator = a.iterator();
            while (iterator.hasNext()) 
            {
                if (geocodingtypes.equals((GeocodingTypes)iterator.next()))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public apa c()
    {
        return e;
    }

    public String d()
    {
        if (f)
        {
            return h;
        }
        if (!aop.a(this, new GeocodingTypes[] {
    GeocodingTypes.POLITICAL, GeocodingTypes.LOCALITY
}).equals(""))
        {
            return aop.a(this, new GeocodingTypes[] {
                GeocodingTypes.POLITICAL, GeocodingTypes.LOCALITY
            });
        } else
        {
            return aop.a(this, new GeocodingTypes[] {
                GeocodingTypes.POLITICAL, GeocodingTypes.SUBLOCALITY
            });
        }
    }

    public String e()
    {
        if (f)
        {
            return g;
        } else
        {
            return aop.a(this, new GeocodingTypes[] {
                GeocodingTypes.POLITICAL, GeocodingTypes.COUNTRY
            });
        }
    }
}
