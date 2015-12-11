// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import com.shazam.f.g;
import com.shazam.k.s;
import com.shazam.model.Tag;
import com.shazam.model.Track;

// Referenced classes of package com.shazam.android.persistence.p:
//            j, d, c

public final class m
    implements j
{

    private final s a;
    private final c b;
    private final d c;

    public m(s s1)
    {
        this(s1, d.a, c.a);
    }

    private m(s s1, d d1, c c1)
    {
        a = s1;
        c = d1;
        b = c1;
    }

    public final void a(Object obj)
    {
        obj = (Tag)obj;
        if (((Tag) (obj)).track == null || ((Tag) (obj)).track.isFull)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        a.a(((Tag) (obj)));
_L1:
        c.a();
        return;
        try
        {
            a.b(((Tag) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            b.a();
            return;
        }
          goto _L1
    }
}
