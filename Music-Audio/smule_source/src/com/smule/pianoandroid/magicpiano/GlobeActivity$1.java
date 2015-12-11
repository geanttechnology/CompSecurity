// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.graphics.Rect;
import com.smule.pianoandroid.utils.n;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, GlobeGLSurfaceView

class a
    implements android.view..OnGlobalLayoutListener
{

    final GlobeActivity a;

    public void onGlobalLayout()
    {
        n.a(this, GlobeActivity.a(a).getViewTreeObserver());
        Rect rect = new Rect();
        GlobeActivity.a(a).getGlobalVisibleRect(rect);
        GlobeActivity.a(a).a(rect);
    }

    ew(GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
