// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.tagging;

import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.ay.a.n;
import com.shazam.android.ay.a.q;
import com.shazam.android.j.d.a;
import com.shazam.i.b.ar.a.e;

// Referenced classes of package com.shazam.android.service.tagging:
//            AutoTaggingService

final class a
    implements Runnable
{

    final AutoTaggingService a;

    public final void run()
    {
        q q1 = e.a();
        com.shazam.android.analytics.TaggedBeaconData taggedbeacondata = com.shazam.android.analytics.der.taggedBeaconData().withTaggingOrigin(TaggingOrigin.BACKGROUND).build();
        if (q1.d.a() && !q1.a.a())
        {
            q1.c.a(taggedbeacondata);
        }
    }

    (AutoTaggingService autotaggingservice)
    {
        a = autotaggingservice;
        super();
    }
}
