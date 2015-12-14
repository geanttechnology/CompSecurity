// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            bm

class bo
{

    final bm a;
    private int b;
    private String c;
    private Map d;

    bo(bm bm, String s, Map map)
    {
        this(bm, s, map, 0);
    }

    bo(bm bm, String s, Map map, int i)
    {
        a = bm;
        super();
        b = i;
        c = (new StringBuilder()).append(s).append("&postback_ts=").append(System.currentTimeMillis()).toString();
        d = map;
    }

    public int a()
    {
        return b;
    }

    public void a(int i)
    {
        b = i;
    }

    public String b()
    {
        return c;
    }

    public Map c()
    {
        return d;
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
        obj = (bo)obj;
        flag = flag2;
        if (b != ((bo) (obj)).b) goto _L4; else goto _L6
_L6:
        if (c == null) goto _L8; else goto _L7
_L7:
        flag = flag2;
        if (!c.equals(((bo) (obj)).c)) goto _L4; else goto _L9
_L9:
        if (d == null) goto _L11; else goto _L10
_L10:
        flag = flag1;
        if (d.equals(((bo) (obj)).d)) goto _L13; else goto _L12
_L12:
        flag = false;
_L13:
        return flag;
_L8:
        if (((bo) (obj)).c == null) goto _L9; else goto _L14
_L14:
        return false;
_L11:
        if (((bo) (obj)).d != null) goto _L12; else goto _L15
_L15:
        flag = flag1;
          goto _L13
    }

    public int hashCode()
    {
        int j = 0;
        int k = b;
        int i;
        if (c != null)
        {
            i = c.hashCode();
        } else
        {
            i = 0;
        }
        if (d != null)
        {
            j = d.hashCode();
        }
        return (i + k * 31) * 31 + j;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PostbackRequest{attemptNumber=").append(b).append(", targetUrl='").append(c).append('\'').append(", requestBody=").append(d).append('}').toString();
    }
}
