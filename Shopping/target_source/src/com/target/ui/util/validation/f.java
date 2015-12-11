// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import com.target.mothership.common.registries.c;
import com.target.ui.util.validation.a.d;
import com.target.ui.util.validation.a.h;
import com.target.ui.util.validation.a.j;

// Referenced classes of package com.target.ui.util.validation:
//            b

public class f
{

    public static d a(String s)
    {
        return com.target.ui.util.validation.b.c(s);
    }

    public static j b(String s)
    {
        return com.target.ui.util.validation.b.d(s);
    }

    public static boolean c(String s)
    {
        return com.target.ui.util.validation.b.i(s);
    }

    public static h d(String s)
    {
        int i = 1;
        boolean flag;
        if (com.target.mothership.common.registries.c.a(s).equals(c.UNKNOWN))
        {
            flag = false;
        } else
        {
            i = 2;
            flag = true;
        }
        return new h(s, flag, i);
    }
}
