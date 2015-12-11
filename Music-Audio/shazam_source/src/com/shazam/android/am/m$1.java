// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import com.shazam.b.a.e;
import com.shazam.model.myshazam.MyShazamTag;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.am:
//            m

final class a
    implements e
{

    final m a;

    public final boolean apply(Object obj)
    {
        obj = (MyShazamTag)obj;
        return obj != null && System.currentTimeMillis() - ((MyShazamTag) (obj)).a().longValue() <= TimeUnit.DAYS.toMillis(7L);
    }

    nit(m m1)
    {
        a = m1;
        super();
    }
}
