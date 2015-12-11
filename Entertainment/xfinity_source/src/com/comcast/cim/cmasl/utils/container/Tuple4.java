// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.container;

import java.io.Serializable;

public class Tuple4
    implements Serializable
{

    public final Object e1;
    public final Object e2;
    public final Object e3;
    public final Object e4;

    public Tuple4(Object obj, Object obj1, Object obj2, Object obj3)
    {
        e1 = obj;
        e2 = obj1;
        e3 = obj2;
        e4 = obj3;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Tuple4)obj;
            if (e1 == null ? ((Tuple4) (obj)).e1 != null : !e1.equals(((Tuple4) (obj)).e1))
            {
                return false;
            }
            if (e2 == null ? ((Tuple4) (obj)).e2 != null : !e2.equals(((Tuple4) (obj)).e2))
            {
                return false;
            }
            if (e3 == null ? ((Tuple4) (obj)).e3 != null : !e3.equals(((Tuple4) (obj)).e3))
            {
                return false;
            }
            if (e4 == null ? ((Tuple4) (obj)).e4 != null : !e4.equals(((Tuple4) (obj)).e4))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
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
        } else
        {
            j = 0;
        }
        if (e3 != null)
        {
            k = e3.hashCode();
        } else
        {
            k = 0;
        }
        if (e4 != null)
        {
            l = e4.hashCode();
        }
        return ((i * 31 + j) * 31 + k) * 31 + l;
    }
}
