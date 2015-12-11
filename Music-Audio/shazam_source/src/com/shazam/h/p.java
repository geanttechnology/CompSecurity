// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.j.b;
import com.shazam.j.c;

// Referenced classes of package com.shazam.h:
//            o, j, r, s, 
//            f

final class p
{

    private final s a;

    p(s s1)
    {
        a = s1;
    }

    final Object a(o o1, Class class1)
    {
        int i = o1.a;
        if (i != 200 && i != 201)
        {
            throw new j((new StringBuilder("Could not parse the response for non-200/201 HTTP code: ")).append(i).toString(), o1);
        }
        try
        {
            r r1 = r.a(o1.a("content-type"));
            o1 = ((o) (a.a(r1).a(o1.b, class1)));
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            throw new f(o1);
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            throw new j("Could not parse the response", o1);
        }
        return o1;
    }
}
