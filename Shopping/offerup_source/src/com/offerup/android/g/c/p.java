// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.net.Uri;
import com.offerup.android.activities.k;
import com.offerup.android.utils.f;

// Referenced classes of package com.offerup.android.g.c:
//            l

final class p
    implements f
{

    private l a;

    p(l l1)
    {
        a = l1;
        super();
    }

    public final void a()
    {
        ((k)a.getActivity()).i();
    }

    public final void a(Uri uri)
    {
        if (uri != null)
        {
            l.a(a, uri);
        }
        ((k)a.getActivity()).i();
    }
}
