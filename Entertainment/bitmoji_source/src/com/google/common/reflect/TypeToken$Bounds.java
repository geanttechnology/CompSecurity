// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.reflect;

import java.lang.reflect.Type;

// Referenced classes of package com.google.common.reflect:
//            TypeToken

private static class target
{

    private final Type bounds[];
    private final boolean target;

    boolean isSubtypeOf(Type type)
    {
        Type atype[];
        int i;
        int j;
        boolean flag;
        flag = false;
        atype = bounds;
        j = atype.length;
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L1
_L1:
        if (TypeToken.of(atype[i]).isSubtypeOf(type) != target) goto _L4; else goto _L3
_L3:
        flag = target;
_L6:
        return flag;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (target) goto _L6; else goto _L5
_L5:
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    boolean isSupertypeOf(Type type)
    {
        Type atype[];
        int i;
        int j;
        boolean flag;
        flag = false;
        type = TypeToken.of(type);
        atype = bounds;
        j = atype.length;
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L1
_L1:
        if (type.isSubtypeOf(atype[i]) != target) goto _L4; else goto _L3
_L3:
        flag = target;
_L6:
        return flag;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (target) goto _L6; else goto _L5
_L5:
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    (Type atype[], boolean flag)
    {
        bounds = atype;
        target = flag;
    }
}
