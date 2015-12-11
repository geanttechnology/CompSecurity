// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.view.MotionEvent;
import android.view.View;
import com.helpshift.app.b;

// Referenced classes of package com.helpshift:
//            HSSectionFragment

class a
    implements android.view.
{

    final HSSectionFragment a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (HSSectionFragment.a(a) != null)
        {
            com.helpshift.HSSectionFragment.b(a).c(HSSectionFragment.a(a));
        }
        return false;
    }

    (HSSectionFragment hssectionfragment)
    {
        a = hssectionfragment;
        super();
    }
}
