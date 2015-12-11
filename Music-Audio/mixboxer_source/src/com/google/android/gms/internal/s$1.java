// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            s, r

class et
    implements Runnable
{

    private final WeakReference es;
    final r et;
    final s eu;

    public void run()
    {
        s.a(eu, false);
        r r1 = (r)es.get();
        if (r1 != null)
        {
            r1.b(s.a(eu));
        }
    }

    (s s1, r r1)
    {
        eu = s1;
        et = r1;
        super();
        es = new WeakReference(et);
    }
}
