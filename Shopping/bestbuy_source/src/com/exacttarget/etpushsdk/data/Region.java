// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import ahs;
import aht;
import com.exacttarget.etpushsdk.util.l;
import java.util.List;

public class Region
{

    private Integer a;
    private String b;
    private String c;
    private l d;
    private Double e;
    private Double f;
    private Integer g;
    private List h;
    private Boolean i;
    private String j;
    private Integer k;
    private Integer l;
    private Integer m;
    private Integer n;
    private String o;
    private Boolean p;

    public Region()
    {
        a = Integer.valueOf(1);
        m = Integer.valueOf(0);
        n = Integer.valueOf(0);
        p = Boolean.FALSE;
    }

    public ahs a()
    {
        byte byte0;
        if ("~~m@g1c_f3nc3~~".equals(getId()))
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        return (new aht()).a(b).a(e.doubleValue(), f.doubleValue(), g.intValue()).a(byte0).a(-1L).a();
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Region)
        {
            if (b == null && ((Region)obj).b == null)
            {
                return true;
            }
            if (b != null)
            {
                return b.equals(((Region)obj).b);
            }
        }
        return false;
    }

    public Boolean getActive()
    {
        return i;
    }

    public l getCenter()
    {
        return d;
    }

    public String getDescription()
    {
        return o;
    }

    public Integer getEntryCount()
    {
        return m;
    }

    public Integer getExitCount()
    {
        return n;
    }

    public String getGuid()
    {
        return j;
    }

    public Boolean getHasEntered()
    {
        return p;
    }

    public String getId()
    {
        return b;
    }

    public Double getLatitude()
    {
        return e;
    }

    public Integer getLocationType()
    {
        if (a == null)
        {
            a = Integer.valueOf(1);
        }
        return a;
    }

    public Double getLongitude()
    {
        return f;
    }

    public Integer getMajor()
    {
        return k;
    }

    public List getMessages()
    {
        return h;
    }

    public Integer getMinor()
    {
        return l;
    }

    public String getName()
    {
        return c;
    }

    public Integer getRadius()
    {
        return g;
    }

    public int hashCode()
    {
        return b.hashCode();
    }

    public void setActive(Boolean boolean1)
    {
        i = boolean1;
    }

    public void setCenter(l l1)
    {
        d = l1;
        setLatitude(l1.a());
        setLongitude(l1.b());
    }

    public void setDescription(String s)
    {
        o = s;
    }

    public void setEntryCount(Integer integer)
    {
        m = integer;
    }

    public void setExitCount(Integer integer)
    {
        n = integer;
    }

    public void setGuid(String s)
    {
        j = s;
    }

    public void setHasEntered(Boolean boolean1)
    {
        p = boolean1;
    }

    public void setId(String s)
    {
        b = s;
    }

    public void setLatitude(Double double1)
    {
        e = double1;
    }

    public void setLocationType(Integer integer)
    {
        a = integer;
    }

    public void setLongitude(Double double1)
    {
        f = double1;
    }

    public void setMajor(Integer integer)
    {
        k = integer;
    }

    public void setMessages(List list)
    {
        h = list;
    }

    public void setMinor(Integer integer)
    {
        l = integer;
    }

    public void setName(String s)
    {
        c = s;
    }

    public void setRadius(Integer integer)
    {
        g = integer;
    }
}
