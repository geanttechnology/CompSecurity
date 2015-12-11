// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.smule.android.f.c;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.AccountIcon;
import com.smule.android.network.models.PerformanceV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.globe.PianoGlobeBridge;
import java.io.File;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, GlobeGLSurfaceView, an

class a
    implements Runnable
{

    final GlobeActivity a;

    public void run()
    {
        if (!a.isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        GlobeActivity.a(a).a(GlobeActivity.b(a).accountIcon.latitude, GlobeActivity.b(a).accountIcon.longitude);
        synchronized (GlobeActivity.p(a))
        {
            PianoGlobeBridge.playPerformanceFromFile(GlobeActivity.k(a).getAbsolutePath());
        }
        GlobeActivity.a(a, 0);
        GlobeActivity.d(a).setClickable(true);
        c.a(GlobeActivity.f(a), a.getResources().getDrawable(0x7f0200f6));
        obj1 = GlobeActivity.b(a);
        boolean flag;
        if (i.a().c(((PerformanceV2) (obj1)).songUid) || ap.a().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            GlobeActivity.a(a, ak.a().a(((PerformanceV2) (obj1)).songUid));
            TextView textview;
            if (GlobeActivity.g(a) != null)
            {
                GlobeActivity.q(a).setVisibility(0);
            } else
            {
                GlobeActivity.q(a).setVisibility(4);
            }
        } else
        {
            GlobeActivity.a(a, ak.a().f(((PerformanceV2) (obj1)).songUid));
            if (GlobeActivity.h(a) != null)
            {
                GlobeActivity.q(a).setVisibility(0);
            } else
            {
                GlobeActivity.q(a).setVisibility(4);
            }
        }
        GlobeActivity.r(a).setText(((PerformanceV2) (obj1)).accountIcon.handle);
        GlobeActivity.s(a).setText(((PerformanceV2) (obj1)).title);
        obj = ak.a().a(((PerformanceV2) (obj1)).songUid);
        textview = GlobeActivity.t(a);
        if (obj == null)
        {
            obj = "";
        } else
        {
            obj = ((SongV2) (obj)).artist;
        }
        textview.setText(((CharSequence) (obj)));
        GlobeActivity.e(a).setText(String.valueOf(((PerformanceV2) (obj1)).totalLoves));
        c.a(((PerformanceV2) (obj1)).accountIcon.picUrl, GlobeActivity.u(a), 0x7f020152, true, 0xff444444, null);
        if (GlobeActivity.v(a) != null)
        {
            GlobeActivity.v(a).dismiss();
            GlobeActivity.a(a, null);
        }
        a.a(false);
        if (GlobeActivity.w(a)) goto _L1; else goto _L3
_L3:
        GlobeActivity.b(a, true);
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    w(GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
