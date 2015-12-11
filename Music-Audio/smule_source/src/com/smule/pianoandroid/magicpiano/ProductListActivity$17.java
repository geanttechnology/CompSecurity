// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class a
    implements Runnable
{

    final View a;
    final ProductListActivity b;

    public void run()
    {
        a.startAnimation(AnimationUtils.loadAnimation(b, 0x7f040015));
    }

    (ProductListActivity productlistactivity, View view)
    {
        b = productlistactivity;
        a = view;
        super();
    }
}
