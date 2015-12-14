// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import com.picsart.studio.PicsartContext;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            StudioActivity

final class a
    implements Runnable
{

    private StudioActivity a;

    public final void run()
    {
        StudioActivity studioactivity = a;
        String s = StudioActivity.a(a);
        java.util.HashMap hashmap = StudioActivity.b(a);
        int i = StudioActivity.c(a);
        studioactivity.startActivityForResult(EffectsActivityNew.a(studioactivity, StudioActivity.d(a), null, hashmap, s, i, PicsartContext.a(studioactivity), null, false, false, false, true), 0);
        studioactivity.finish();
    }

    ityNew(StudioActivity studioactivity, String s)
    {
        a = studioactivity;
        super();
    }
}
