// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzt;

public final class b
{

    public final int a;
    public final int b;

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof b) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (this == obj) goto _L4; else goto _L3
_L3:
        obj = (b)obj;
        if (((b) (obj)).a != a)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((a) (obj)).b == b) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int hashCode()
    {
        return zzt.a(new Object[] {
            Integer.valueOf(a), Integer.valueOf(b)
        });
    }

    public t(int i, int j)
    {
        a = i;
        b = j;
    }
}
