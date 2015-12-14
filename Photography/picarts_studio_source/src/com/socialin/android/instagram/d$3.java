// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import com.socialin.android.d;
import java.util.List;

// Referenced classes of package com.socialin.android.instagram:
//            d

final class a extends Thread
{

    private com.socialin.android.instagram.d a;

    public final void run()
    {
        List list;
        com.socialin.android.instagram.d.d(a);
        d.e(a);
        d.a(a, true);
        list = a.a();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        int i = list.size();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        d.h(a);
        return;
        d.f(a).addAll(list);
        d.a(a, d.f(a));
        d.a(a, false);
        d.h(a);
        return;
        Object obj;
        obj;
        d.g(a);
        d.b(d.f(), new Object[] {
            "loadPhotos", obj
        });
        d.h(a);
        return;
        obj;
        d.h(a);
        throw obj;
    }

    (com.socialin.android.instagram.d d1)
    {
        a = d1;
        super();
    }
}
