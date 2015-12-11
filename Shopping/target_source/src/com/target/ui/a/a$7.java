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
    final oldHolder val$changeInfo;
    final ba val$oldViewAnim;

    public void a(View view)
    {
        a.this.b(val$changeInfo.oldHolder, true);
    }

    public void b(View view)
    {
        val$oldViewAnim.a(null);
        ai.c(view, 1.0F);
        ai.a(view, 0.0F);
        ai.b(view, 0.0F);
        a.this.a(val$changeInfo.oldHolder, true);
        com.target.ui.a.a.g(a.this).remove(val$changeInfo.oldHolder);
        j();
    }

    iew.ba()
    {
        this$0 = final_a1;
        val$changeInfo = ba1;
        val$oldViewAnim = ba.this;
        super(null);
    }
}
