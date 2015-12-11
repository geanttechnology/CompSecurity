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
    final newHolder val$changeInfo;
    final View val$newView;
    final ba val$newViewAnimation;

    public void a(View view)
    {
        a.this.b(val$changeInfo.newHolder, false);
    }

    public void b(View view)
    {
        val$newViewAnimation.a(null);
        ai.c(val$newView, 1.0F);
        ai.a(val$newView, 0.0F);
        ai.b(val$newView, 0.0F);
        a.this.a(val$changeInfo.newHolder, false);
        com.target.ui.a.a.g(a.this).remove(val$changeInfo.newHolder);
        j();
    }

    iew.ba()
    {
        this$0 = final_a1;
        val$changeInfo = ba1;
        val$newViewAnimation = ba2;
        val$newView = View.this;
        super(null);
    }
}
