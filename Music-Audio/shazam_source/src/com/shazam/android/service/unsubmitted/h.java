// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import com.shazam.android.persistence.p.n;
import com.shazam.android.service.tagging.b;
import com.shazam.model.Tag;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            m, i, j

public final class h
    implements m
{

    private final n a;
    private final b b;
    private final i c;
    private final j d;

    public h(n n1, b b1, j j, i i)
    {
        a = n1;
        b = b1;
        d = j;
        c = i;
    }

    public final void a()
    {
        for (Iterator iterator = a.a().iterator(); iterator.hasNext();)
        {
            Tag tag = (Tag)iterator.next();
            try
            {
                b.a(tag, d, c);
            }
            catch (Exception exception) { }
        }

    }
}
