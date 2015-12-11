// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import com.shazam.android.persistence.p.j;
import com.shazam.android.persistence.p.l;
import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            j

public final class k
    implements com.shazam.android.service.unsubmitted.j
{

    private final j a;
    private final l b;

    public k(j j1, l l1)
    {
        a = j1;
        b = l1;
    }

    public final void a(Tag tag)
    {
        b.a(tag.timestamp);
        a.a(tag);
    }

    public final void b(Tag tag)
    {
        b.a(tag.timestamp);
    }
}
