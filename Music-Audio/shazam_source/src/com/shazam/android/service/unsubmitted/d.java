// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            j

public final class d
    implements j
{

    private final j a[];

    public transient d(j aj[])
    {
        a = aj;
    }

    public final void a(Tag tag)
    {
        j aj[] = a;
        int k = aj.length;
        for (int i = 0; i < k; i++)
        {
            aj[i].a(tag);
        }

    }

    public final void b(Tag tag)
    {
        j aj[] = a;
        int k = aj.length;
        for (int i = 0; i < k; i++)
        {
            aj[i].b(tag);
        }

    }
}
