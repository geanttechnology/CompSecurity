// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a extends ch
{

    final EditViewActivity a;

    public void onAnimationEnd(Animator animator)
    {
        EditViewActivity.c(a, false);
        Globals.d().i().h(a);
    }

    (EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
