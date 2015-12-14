// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.location.Location;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MMRequest
{

    public static final String EDUCATION_ASSOCIATES = "associates";
    public static final String EDUCATION_BACHELORS = "bachelors";
    public static final String EDUCATION_DOCTORATE = "doctorate";
    public static final String EDUCATION_HIGH_SCHOOL = "highschool";
    public static final String EDUCATION_IN_COLLEGE = "incollege";
    public static final String EDUCATION_MASTERS = "masters";
    public static final String EDUCATION_OTHER = "other";
    public static final String EDUCATION_SOME_COLLEGE = "somecollege";
    public static final String ETHNICITY_ASIAN = "asian";
    public static final String ETHNICITY_BLACK = "black";
    public static final String ETHNICITY_HISPANIC = "hispanic";
    public static final String ETHNICITY_INDIAN = "indian";
    public static final String ETHNICITY_MIDDLE_EASTERN = "middleeastern";
    public static final String ETHNICITY_NATIVE_AMERICAN = "nativeamerican";
    public static final String ETHNICITY_OTHER = "other";
    public static final String ETHNICITY_PACIFIC_ISLANDER = "pacificislander";
    public static final String ETHNICITY_WHITE = "white";
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_OTHER = "other";
    public static final String KEY_AGE = "age";
    public static final String KEY_CHILDREN = "children";
    public static final String KEY_EDUCATION = "education";
    public static final String KEY_ETHNICITY = "ethnicity";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_HEIGHT = "hsht";
    public static final String KEY_INCOME = "income";
    public static final String KEY_KEYWORDS = "keywords";
    public static final String KEY_MARITAL_STATUS = "marital";
    public static final String KEY_POLITICS = "politics";
    public static final String KEY_VENDOR = "vendor";
    public static final String KEY_WIDTH = "hswd";
    public static final String KEY_ZIP_CODE = "zip";
    public static final String MARITAL_DIVORCED = "divorced";
    public static final String MARITAL_ENGAGED = "engaged";
    public static final String MARITAL_MARRIED = "married";
    public static final String MARITAL_OTHER = "other";
    public static final String MARITAL_RELATIONSHIP = "relationship";
    public static final String MARITAL_SINGLE = "single";
    static Location l;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    private Map m;

    public MMRequest()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        m = new HashMap();
    }

    static void b(Map map)
    {
        if (l != null)
        {
            map.put("lat", Double.toString(l.getLatitude()));
            map.put("long", Double.toString(l.getLongitude()));
            if (l.hasAccuracy())
            {
                map.put("ha", Float.toString(l.getAccuracy()));
                map.put("va", Float.toString(l.getAccuracy()));
            }
            if (l.hasSpeed())
            {
                map.put("spd", Float.toString(l.getSpeed()));
            }
            if (l.hasBearing())
            {
                map.put("brg", Float.toString(l.getBearing()));
            }
            if (l.hasAltitude())
            {
                map.put("alt", Double.toString(l.getAltitude()));
            }
            map.put("tslr", Long.toString(l.getTime()));
            map.put("loc", "true");
            map.put("lsrc", l.getProvider());
            return;
        } else
        {
            map.put("loc", "false");
            return;
        }
    }

    public static Location getUserLocation()
    {
        return l;
    }

    public static void setUserLocation(Location location)
    {
        if (location == null)
        {
            return;
        } else
        {
            l = location;
            return;
        }
    }

    final void a(Map map)
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = m.entrySet().iterator(); iterator.hasNext(); map.put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        if (a != null)
        {
            map.put("age", a);
        }
        if (b != null)
        {
            map.put("children", b);
        }
        if (c != null)
        {
            map.put("education", c);
        }
        if (d != null)
        {
            map.put("ethnicity", d);
        }
        if (e != null)
        {
            map.put("gender", e);
        }
        if (f != null)
        {
            map.put("income", f);
        }
        if (g != null)
        {
            map.put("keywords", g);
        }
        if (h != null)
        {
            map.put("marital", h);
        }
        if (i != null)
        {
            map.put("politics", i);
        }
        if (j != null)
        {
            map.put("vendor", j);
        }
        if (k != null)
        {
            map.put("zip", k);
        }
    }

    public final MMRequest put(String s, String s1)
    {
        if (s.equals("age"))
        {
            a = s1;
            return this;
        }
        if (s.equals("children"))
        {
            b = s1;
            return this;
        }
        if (s.equals("education"))
        {
            c = s1;
            return this;
        }
        if (s.equals("ethnicity"))
        {
            d = s1;
            return this;
        }
        if (s.equals("gender"))
        {
            e = s1;
            return this;
        }
        if (s.equals("income"))
        {
            f = s1;
            return this;
        }
        if (s.equals("keywords"))
        {
            g = s1;
            return this;
        }
        if (s.equals("marital"))
        {
            h = s1;
            return this;
        }
        if (s.equals("politics"))
        {
            i = s1;
            return this;
        }
        if (s.equals("vendor"))
        {
            j = s1;
            return this;
        }
        if (s.equals("zip"))
        {
            k = s1;
            return this;
        }
        if (s1 != null)
        {
            m.put(s, s1);
            return this;
        } else
        {
            m.remove(s);
            return this;
        }
    }

    public final void setAge(String s)
    {
        a = s;
    }

    public final void setChildren(String s)
    {
        b = s;
    }

    public final void setEducation(String s)
    {
        c = s;
    }

    public final void setEthnicity(String s)
    {
        d = s;
    }

    public final void setGender(String s)
    {
        e = s;
    }

    public final void setIncome(String s)
    {
        f = s;
    }

    public final void setKeywords(String s)
    {
        g = s;
    }

    public final void setMarital(String s)
    {
        h = s;
    }

    public final void setMetaValues(Map map)
    {
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                put((String)entry.getKey(), (String)entry.getValue());
            }
        }
    }

    public final void setPolitics(String s)
    {
        i = s;
    }

    public final void setVendor(String s)
    {
        j = s;
    }

    public final void setZip(String s)
    {
        k = s;
    }
}
