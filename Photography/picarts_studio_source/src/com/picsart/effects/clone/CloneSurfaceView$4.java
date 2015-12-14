// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.app.Activity;
import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import myobfuscated.ay.e;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.clone:
//            CloneSurfaceView, CloneActivity, f

final class c
    implements Runnable
{

    private Activity a;
    private Bitmap b;
    private long c;
    private CloneSurfaceView d;

    public final void run()
    {
        EditingData editingdata = ((CloneActivity)a).a;
        String s = "";
        if (editingdata != null)
        {
            editingdata.c("clone");
            s = editingdata.a;
        }
        CloneSurfaceView.c(d).e();
        CloneSurfaceView.c(d).f();
        if (CloneSurfaceView.d(d))
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tDoneEvent("effect_clone"));
            Activity activity = a;
            int i;
            int j;
            if (com.picsart.effects.clone.CloneSurfaceView.e(d) != null)
            {
                i = com.picsart.effects.clone.CloneSurfaceView.e(d).getWidth();
            } else
            {
                i = b.getWidth();
            }
            if (com.picsart.effects.clone.CloneSurfaceView.e(d) != null)
            {
                j = com.picsart.effects.clone.CloneSurfaceView.e(d).getHeight();
            } else
            {
                j = b.getHeight();
            }
            e.a(activity, "effect_clone", i, j, true, true, (System.nanoTime() - c) / 0xf4240L, false, new JSONArray(), s);
        }
    }

    ry.EffectDoneEvent(CloneSurfaceView clonesurfaceview, Activity activity, Bitmap bitmap, long l)
    {
        d = clonesurfaceview;
        a = activity;
        b = bitmap;
        c = l;
        super();
    }
}
