// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.b.z;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            n

final class r extends z
{

    final n a;

    r(n n1, int ai[], String s)
    {
        a = n1;
        super(ai, s);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (HashMap)obj;
        n.a(a, ((HashMap) (obj)));
        if (n.c(a) != null)
        {
            n.d(a);
        }
    }
}
