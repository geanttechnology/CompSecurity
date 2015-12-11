// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.container;

import java.io.Serializable;

public class Tuple
    implements Serializable
{

    public final Object e1;
    public final Object e2;

    public Tuple(Object obj, Object obj1)
    {
        e1 = obj;
        e2 = obj1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Tuple)obj;
            if (e1 == null ? ((Tuple) (obj)).e1 != null : !e1.equals(((Tuple) (obj)).e1))
            {
                return false;
            }
            if (e2 == null ? ((Tuple) (obj)).e2 != null : !e2.equals(((Tuple) (obj)).e2))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (e1 != null)
        {
            i = e1.hashCode();
        } else
        {
            i = 0;
        }
        if (e2 != null)
        {
            j = e2.hashCode();
        }
        return i * 31 + j;
    }

    public String toString()
    {
        String s;
        String s1;
        if (e1 != null)
        {
            s = (new StringBuilder()).append(e1.getClass().getName()).append("=").append(e1.toString()).toString();
        } else
        {
            s = "null";
        }
        if (e2 != null)
        {
            s1 = (new StringBuilder()).append(e2.getClass().getName()).append("=").append(e2.toString()).toString();
        } else
        {
            s1 = "null";
        }
        return (new StringBuilder()).append(getClass().getName()).append("[").append(s).append(",").append(s1).append("]").toString();
    }
}
