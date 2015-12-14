// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.util.Utils;
import com.socialin.android.videogenerator.ProjectVideoGenerator;
import com.socialin.android.videogenerator.d;
import com.socialin.android.videogenerator.f;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

final class b
    implements d
{

    private Integer a;
    private boolean b;
    private f c;
    private com.socialin.android.videogenerator.erator.VideoOptions d;
    private DrawingView e;

    public final void a()
    {
        String s = e.getContext().getString(0x7f080663);
        if (a != null && a.intValue() == ProjectVideoGenerator.c)
        {
            s = e.getContext().getString(0x7f08039a);
        }
        c.dismiss();
        Utils.b((Activity)e.getContext(), s);
    }

    public final void a(int i)
    {
        a = Integer.valueOf(i);
    }

    public final void b()
    {
        c.getArguments().putSerializable("MODEL", d);
        c.a(d);
    }

    public final void b(int i)
    {
        c.a.setProgress(i);
        if (!b && DrawingView.i(e) != null)
        {
            b = SocialinAdManager.a(com.socialin.android.ads.er.PicsArtInterstitialType.DRAW);
        }
    }

    tions(DrawingView drawingview, f f1, com.socialin.android.videogenerator.erator.VideoOptions videooptions)
    {
        e = drawingview;
        c = f1;
        d = videooptions;
        super();
        a = null;
        b = false;
    }
}
