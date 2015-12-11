// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g.b;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.api.a.g.b:
//            d

public final class f
{

    public static String a(d d1)
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        String s;
        boolean flag;
        try
        {
            stringbuilder = new StringBuilder();
            stringbuilder.append('{');
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            throw new RuntimeException(d1);
        }
        flag = true;
        iterator = d1.a().iterator();
_L1:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s = (String)iterator.next();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        flag = false;
_L2:
        stringbuilder.append(s).append('=').append(d1.a(s));
          goto _L1
        stringbuilder.append(", ");
          goto _L2
        d1 = stringbuilder.append('}').toString();
        return d1;
    }
}
