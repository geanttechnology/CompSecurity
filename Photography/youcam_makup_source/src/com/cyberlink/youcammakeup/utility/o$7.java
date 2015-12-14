// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            o

class b
    implements Runnable
{

    final View a;
    final Animation b;
    final o c;

    public void run()
    {
        a.startAnimation(b);
    }

    (o o1, View view, Animation animation)
    {
        c = o1;
        a = view;
        b = animation;
        super();
    }
}
