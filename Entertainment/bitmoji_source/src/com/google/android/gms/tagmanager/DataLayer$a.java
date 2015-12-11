// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.tagmanager:
//            DataLayer

static final class UB
{

    public final String UA;
    public final Object UB;

    public boolean equals(Object obj)
    {
        if (obj instanceof UB)
        {
            if (UA.equals(((UA) (obj = (UA)obj)).UA) && UB.equals(((UB) (obj)).UB))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Integer[] {
            Integer.valueOf(UA.hashCode()), Integer.valueOf(UB.hashCode())
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("Key: ").append(UA).append(" value: ").append(UB.toString()).toString();
    }

    (String s, Object obj)
    {
        UA = s;
        UB = obj;
    }
}
