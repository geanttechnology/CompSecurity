// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import android.app.IntentService;
import android.content.Intent;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.i.b.ah.f.g;
import com.shazam.i.b.an.b.a;
import com.shazam.i.b.c;
import com.shazam.i.b.g.b;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            h, d, j, b, 
//            m

public class UnsubmittedTagsSubmittingService extends IntentService
{

    private final m a;

    public UnsubmittedTagsSubmittingService()
    {
        this(((m) (new h(g.a(), com.shazam.i.b.an.b.a.a(b.c(), TaggingOrigin.UNSUBMITTED), new d(new j[] {
            com.shazam.i.b.an.c.b.b(), com.shazam.i.b.an.c.b.a(), new com.shazam.android.service.unsubmitted.b(c.a())
        }), com.shazam.i.b.an.c.a.a()))));
    }

    public UnsubmittedTagsSubmittingService(m m1)
    {
        super(com/shazam/android/service/unsubmitted/UnsubmittedTagsSubmittingService.getSimpleName());
        a = m1;
    }

    protected void onHandleIntent(Intent intent)
    {
        a.a();
    }
}
