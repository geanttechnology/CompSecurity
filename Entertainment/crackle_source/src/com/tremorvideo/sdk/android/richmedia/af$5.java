// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            af

class a
    implements Runnable
{

    final af a;

    public void run()
    {
        if (a.k != null && a.k.isShown())
        {
            a.k.setVisibility(8);
        }
        a.b.addView(af.e(a), af.f(a));
        if (a.a != null && a.a.isPlaying())
        {
            a.a.stopPlayback();
        }
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
