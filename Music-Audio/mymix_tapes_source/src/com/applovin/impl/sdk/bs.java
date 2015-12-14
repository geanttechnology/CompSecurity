// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import java.util.Map;

public class bs
{

    private final String a;
    private final Map b;
    private final long c;
    private final String d;

    public bs(String s, Map map, long l, String s1)
    {
        a = s;
        b = map;
        c = l;
        d = s1;
    }

    public String a()
    {
        return a;
    }

    public Map b()
    {
        return b;
    }

    public long c()
    {
        return c;
    }

    public boolean equals(Object obj)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (bs)obj;
        flag = flag2;
        if (c != ((bs) (obj)).c) goto _L4; else goto _L6
_L6:
        if (a == null) goto _L8; else goto _L7
_L7:
        flag = flag2;
        if (!a.equals(((bs) (obj)).a)) goto _L4; else goto _L9
_L9:
        if (b == null) goto _L11; else goto _L10
_L10:
        flag = flag2;
        if (!b.equals(((bs) (obj)).b)) goto _L4; else goto _L12
_L12:
        if (d == null) goto _L14; else goto _L13
_L13:
        flag = flag1;
        if (d.equals(((bs) (obj)).d)) goto _L16; else goto _L15
_L15:
        flag = false;
_L16:
        return flag;
_L8:
        if (((bs) (obj)).a == null) goto _L9; else goto _L17
_L17:
        return false;
_L11:
        if (((bs) (obj)).b == null) goto _L12; else goto _L18
_L18:
        return false;
_L14:
        if (((bs) (obj)).d != null) goto _L15; else goto _L19
_L19:
        flag = flag1;
          goto _L16
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        int l;
        if (a != null)
        {
            i = a.hashCode();
        } else
        {
            i = 0;
        }
        if (b != null)
        {
            j = b.hashCode();
        } else
        {
            j = 0;
        }
        l = (int)(c ^ c >>> 32);
        if (d != null)
        {
            k = d.hashCode();
        }
        return ((j + i * 31) * 31 + l) * 31 + k;
    }

    public String toString()
    {
        return (new StringBuilder()).append("SdkEvent{eventType='").append(a).append('\'').append(", parameters=").append(b).append(", creationTsMillis=").append(c).append(", uniqueIdentifier='").append(d).append('\'').append('}').toString();
    }
}
