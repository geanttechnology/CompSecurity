// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aj;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.q;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.s;
import com.shazam.android.persistence.c;
import com.shazam.model.analytics.ScreenOrigin;

// Referenced classes of package com.shazam.android.aj:
//            b

public final class a
    implements b
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final Intent a(r r1, Activity activity)
    {
        activity = q.b(activity);
        if (com.shazam.android.k.f.b.a.a == r1.b || ScreenOrigin.MY_TAGS_TAG.equals(r1.c.e))
        {
            activity.setAction("android.intent.action.VIEW");
            activity.setData(a.a("my_tags", new String[0]));
        }
        activity.addFlags(0x10000000);
        activity.addFlags(0x4000000);
        return activity;
    }
}
