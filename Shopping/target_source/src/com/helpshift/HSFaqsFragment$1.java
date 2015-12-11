// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.view.MotionEvent;
import android.view.View;
import com.helpshift.app.b;

// Referenced classes of package com.helpshift:
//            HSFaqsFragment

class a
    implements android.view.ner
{

    final HSFaqsFragment a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (HSFaqsFragment.a(a) != null)
        {
            com.helpshift.HSFaqsFragment.b(a).c(HSFaqsFragment.a(a));
        }
        return false;
    }

    er(HSFaqsFragment hsfaqsfragment)
    {
        a = hsfaqsfragment;
        super();
    }
}
