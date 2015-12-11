// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.a;

import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.a:
//            a

class <init> extends <init>
{

    final a this$0;
    final ba val$animation;
    final int val$deltaX;
    final int val$deltaY;
    final android.support.v7.widget.clerView.t val$holder;

    public void a(View view)
    {
        h(val$holder);
    }

    public void b(View view)
    {
        val$animation.a(null);
        e(val$holder);
        com.target.ui.a.a.f(a.this).remove(val$holder);
        j();
    }

    public void c(View view)
    {
        if (val$deltaX != 0)
        {
            ai.a(view, 0.0F);
        }
        if (val$deltaY != 0)
        {
            ai.b(view, 0.0F);
        }
    }

    iew.ba()
    {
        this$0 = final_a1;
        val$holder = t;
        val$deltaX = i;
        val$deltaY = j;
        val$animation = ba.this;
        super(null);
    }
}
