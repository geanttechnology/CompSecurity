// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;


final class i
    implements java.util.Map.Entry
{

    i a;
    i b;
    i c;
    i d;
    i e;
    final Object f;
    final int g;
    Object h;
    int i;

    i()
    {
        f = null;
        g = -1;
        e = this;
        d = this;
    }

    i(i j, Object obj, int k, i l, i i1)
    {
        a = j;
        f = obj;
        g = k;
        i = 1;
        d = l;
        e = i1;
        i1.d = this;
        l.e = this;
    }

    public final boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!(obj instanceof java.util.Map.Entry)) goto _L2; else goto _L1
_L1:
        obj = (java.util.Map.Entry)obj;
        if (f != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (((java.util.Map.Entry) (obj)).getKey() != null) goto _L2; else goto _L5
_L5:
        if (h != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((java.util.Map.Entry) (obj)).getValue() != null) goto _L2; else goto _L8
_L8:
        flag = true;
_L2:
        return flag;
_L4:
        flag = flag1;
        if (!f.equals(((java.util.Map.Entry) (obj)).getKey())) goto _L2; else goto _L5
_L7:
        flag = flag1;
        if (!h.equals(((java.util.Map.Entry) (obj)).getValue())) goto _L2; else goto _L8
    }

    public final Object getKey()
    {
        return f;
    }

    public final Object getValue()
    {
        return h;
    }

    public final int hashCode()
    {
        int k = 0;
        int j;
        if (f == null)
        {
            j = 0;
        } else
        {
            j = f.hashCode();
        }
        if (h != null)
        {
            k = h.hashCode();
        }
        return j ^ k;
    }

    public final Object setValue(Object obj)
    {
        Object obj1 = h;
        h = obj;
        return obj1;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(f).append("=").append(h).toString();
    }
}
