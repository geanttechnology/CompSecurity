// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class b
    implements Runnable
{

    final View a;
    final Animation b;
    final ProductListActivity c;

    public void run()
    {
        a.startAnimation(b);
    }

    (ProductListActivity productlistactivity, View view, Animation animation)
    {
        c = productlistactivity;
        a = view;
        b = animation;
        super();
    }
}
