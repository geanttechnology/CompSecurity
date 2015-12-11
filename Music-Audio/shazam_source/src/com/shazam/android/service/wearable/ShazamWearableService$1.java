// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.wearable;

import com.shazam.android.service.unsubmitted.c;
import com.shazam.android.service.unsubmitted.d;
import com.shazam.android.service.unsubmitted.j;
import com.shazam.i.b.an.c.b;
import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.service.wearable:
//            ShazamWearableService

final class b
    implements Runnable
{

    final String a;
    final Tag b;
    final ShazamWearableService c;

    public final void run()
    {
        Object obj = a;
        obj = new d(new j[] {
            com.shazam.i.b.an.c.b.b(), com.shazam.i.b.an.c.b.a(), new c(com.shazam.i.b.c.a(), ((String) (obj)))
        });
        com.shazam.android.service.wearable.ShazamWearableService.b(c).a(b, ((j) (obj)), ShazamWearableService.a(c));
    }

    A(ShazamWearableService shazamwearableservice, String s, Tag tag)
    {
        c = shazamwearableservice;
        a = s;
        b = tag;
        super();
    }
}
