// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class b extends ch
{

    final Boolean a;
    final Boolean b;
    final EditViewActivity c;

    public void onAnimationEnd(Animator animator)
    {
        boolean flag1 = true;
        EditViewActivity.c(c, false);
        animator = c;
        boolean flag;
        if (!a.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (b.booleanValue())
        {
            flag1 = false;
        }
        animator.a(8, flag, flag1);
        EditViewActivity.m(c).setVisibility(8);
        Globals.d().i().h(c);
    }

    (EditViewActivity editviewactivity, Boolean boolean1, Boolean boolean2)
    {
        c = editviewactivity;
        a = boolean1;
        b = boolean2;
        super();
    }
}
