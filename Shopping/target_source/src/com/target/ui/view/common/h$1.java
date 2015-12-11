// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import com.f.a.f;

// Referenced classes of package com.target.ui.view.common:
//            h

class <init> extends <init>
{

    final h this$0;
    final boolean val$isActionClicked[];
    final b val$listener;

    public void d(f f)
    {
        super.d(f);
        if (val$listener == null)
        {
            return;
        }
        if (val$isActionClicked[0])
        {
            val$listener.a();
            return;
        } else
        {
            val$listener.b();
            return;
        }
    }

    ()
    {
        this$0 = final_h1;
        val$listener = ;
        val$isActionClicked = _5B_Z.this;
        super(final_h1);
    }
}
