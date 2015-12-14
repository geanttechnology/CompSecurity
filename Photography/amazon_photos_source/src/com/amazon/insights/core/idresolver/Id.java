// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.idresolver;


public class Id
{

    private static final Id EMPTY_ID = new Id("");
    private final String id;

    protected Id(String s)
    {
        id = s;
    }

    public static Id getEmptyId()
    {
        com/amazon/insights/core/idresolver/Id;
        JVM INSTR monitorenter ;
        Id id1 = EMPTY_ID;
        com/amazon/insights/core/idresolver/Id;
        JVM INSTR monitorexit ;
        return id1;
        Exception exception;
        exception;
        throw exception;
    }

    public static Id valueOf(String s)
    {
        if (s == null || s.equals(""))
        {
            return getEmptyId();
        } else
        {
            return new Id(s);
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Id)obj;
        if (id != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Id) (obj)).id == null) goto _L1; else goto _L3
_L3:
        return false;
        if (id.equals(((Id) (obj)).id)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getValue()
    {
        return id;
    }

    public int hashCode()
    {
        int i;
        if (id == null)
        {
            i = 0;
        } else
        {
            i = id.hashCode();
        }
        return i + 31;
    }

}
