// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.support.v4.view.ai;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            a

class <init> extends <init>
{

    final a this$0;
    final int val$deltaX;
    final int val$deltaY;
    final android.support.v7.widget.clerView.t val$holder;

    public void b(View view)
    {
        e(val$holder);
        mMoveAnimations.remove(val$holder);
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

    .t()
    {
        this$0 = final_a1;
        val$deltaX = i;
        val$deltaY = j;
        val$holder = android.support.v7.widget.clerView.t.this;
        super();
    }
}
