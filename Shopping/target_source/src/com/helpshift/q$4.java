// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import com.helpshift.d.a;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            q

static final class put extends HashMap
{

    final String a;

    (String s)
    {
        a = s;
        super();
        put("value", q.c().b(a).toLowerCase());
        put("type", "metaphone");
    }
}
