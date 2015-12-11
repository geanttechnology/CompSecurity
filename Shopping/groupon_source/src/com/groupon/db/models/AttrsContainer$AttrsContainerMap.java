// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.HashMap;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            AttrsContainer

public static class  extends HashMap
{

    public Boolean getBoolean(String s)
    {
        return getBoolean(s, null);
    }

    public Boolean getBoolean(String s, Boolean boolean1)
    {
        s = ((String) (get(s)));
        if (s != null)
        {
            return (Boolean)s;
        } else
        {
            return boolean1;
        }
    }

    public Double getDouble(String s, Double double1)
    {
        s = ((String) (get(s)));
        if (s != null)
        {
            return (Double)s;
        } else
        {
            return double1;
        }
    }

    public Integer getInt(String s, Integer integer)
    {
        s = ((String) (get(s)));
        if (s != null)
        {
            return (Integer)s;
        } else
        {
            return integer;
        }
    }

    public String getString(String s, String s1)
    {
        s = ((String) (get(s)));
        if (Strings.notEmpty(s))
        {
            s1 = s.toString();
        }
        return s1;
    }

    public ()
    {
    }
}
