// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.view.View;

// Referenced classes of package com.picsart.studio.view:
//            SlidingUpPanelLayout

final class a
    implements android.view.elLayout._cls1
{

    private SlidingUpPanelLayout a;

    public final void onClick(View view)
    {
        if (!a.isEnabled())
        {
            return;
        }
        if (!a.d())
        {
            boolean flag;
            if (a.a == nelState.ANCHORED)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                a.a(SlidingUpPanelLayout.a(a));
                return;
            }
        }
        a.c();
    }

    nelState(SlidingUpPanelLayout slidinguppanellayout)
    {
        a = slidinguppanellayout;
        super();
    }
}
