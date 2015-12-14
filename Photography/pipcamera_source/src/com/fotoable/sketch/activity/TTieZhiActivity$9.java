// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import oj;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class b
    implements Runnable
{

    final oj a;
    final android.widget.tParams b;
    final TTieZhiActivity c;

    public void run()
    {
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(c, 0x7f04002b);
        c.s.addView(a, b);
        a.startAnimation(animation);
    }

    (TTieZhiActivity ttiezhiactivity, oj oj1, android.widget.tParams tparams)
    {
        c = ttiezhiactivity;
        a = oj1;
        b = tparams;
        super();
    }
}
