// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.HashMap;
import roboguice.util.Strings;

public class AttrsContainer
{
    public static class AttrsContainerMap extends HashMap
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

        public AttrsContainerMap()
        {
        }
    }


    private volatile AttrsContainerMap attrs;

    public AttrsContainer()
    {
    }

    public Object getAttr(String s)
    {
        return getAttributes().get(s);
    }

    public AttrsContainerMap getAttributes()
    {
        if (attrs != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (attrs == null)
        {
            attrs = new AttrsContainerMap();
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return attrs;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Boolean getBooleanAttr(String s)
    {
        return getBooleanAttr(s, Boolean.FALSE);
    }

    public Boolean getBooleanAttr(String s, Boolean boolean1)
    {
        return getAttributes().getBoolean(s, boolean1);
    }

    public Double getDoubleAttr(String s, Double double1)
    {
        return getAttributes().getDouble(s, double1);
    }

    public Integer getIntAttr(String s)
    {
        return getIntAttr(s, null);
    }

    public Integer getIntAttr(String s, Integer integer)
    {
        return getAttributes().getInt(s, integer);
    }

    public String getStringAttr(String s)
    {
        return getStringAttr(s, null);
    }

    public String getStringAttr(String s, String s1)
    {
        return getAttributes().getString(s, s1);
    }

    public void putAttr(String s, Boolean boolean1)
    {
        getAttributes().put(s, boolean1);
    }

    public void putAttr(String s, Double double1)
    {
        getAttributes().put(s, double1);
    }

    public void putAttr(String s, Integer integer)
    {
        getAttributes().put(s, integer);
    }

    public void putAttr(String s, Object obj)
    {
        getAttributes().put(s, obj);
    }

    public void putAttr(String s, String s1)
    {
        getAttributes().put(s, s1);
    }

    public Object removeAttr(String s)
    {
        if (attrs == null)
        {
            return null;
        } else
        {
            return attrs.remove(s);
        }
    }

    public void setAttrs(AttrsContainerMap attrscontainermap)
    {
        attrs = attrscontainermap;
    }
}
