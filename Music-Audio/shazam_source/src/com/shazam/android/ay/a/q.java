// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ay.a;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.analytics.TaggedBeaconData;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.j.d.a;
import com.shazam.android.service.tagging.AutoTaggingService;

// Referenced classes of package com.shazam.android.ay.a:
//            j, p, n

public final class q
    implements j, p
{

    public final n a;
    public final n c;
    public final a d;
    private final Context e;

    public q(n n1, n n2, a a1, Context context)
    {
        a = n1;
        c = n2;
        d = a1;
        e = context;
    }

    private void e()
    {
        b(TaggingOutcome.ERROR);
        a(TaggingOutcome.ERROR);
    }

    public final void a()
    {
    }

    public final void a(j.a a1)
    {
        e();
    }

    public final boolean a(TaggedBeaconData taggedbeacondata)
    {
        c.a(TaggingOutcome.CANCELED);
        return a.a(taggedbeacondata);
    }

    public final boolean a(TaggingOutcome taggingoutcome)
    {
        return a.a(taggingoutcome);
    }

    public final void b()
    {
        e();
    }

    public final boolean b(TaggingOutcome taggingoutcome)
    {
        return c.a(taggingoutcome);
    }

    public final boolean c()
    {
        return a.a();
    }

    public final void d()
    {
        if (!c.a())
        {
            e.startService(new Intent(e, com/shazam/android/service/tagging/AutoTaggingService));
        }
    }
}
