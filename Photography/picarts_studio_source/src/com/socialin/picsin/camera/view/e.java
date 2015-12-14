// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.view.View;

// Referenced classes of package com.socialin.picsin.camera.view:
//            RightToLeftSlidingDrower

final class e
    implements android.view.View.OnClickListener
{

    private RightToLeftSlidingDrower a;

    private e(RightToLeftSlidingDrower righttoleftslidingdrower)
    {
        a = righttoleftslidingdrower;
        super();
    }

    e(RightToLeftSlidingDrower righttoleftslidingdrower, byte byte0)
    {
        this(righttoleftslidingdrower);
    }

    public final void onClick(View view)
    {
        if (RightToLeftSlidingDrower.a(a))
        {
            view = a;
            if (!((RightToLeftSlidingDrower) (view)).b)
            {
                view.a();
                view.b(((RightToLeftSlidingDrower) (view)).a.getLeft());
                view.sendAccessibilityEvent(32);
                return;
            } else
            {
                view.a();
                view.a(((RightToLeftSlidingDrower) (view)).a.getLeft());
                return;
            }
        }
        view = a;
        if (!((RightToLeftSlidingDrower) (view)).b)
        {
            view.c();
        } else
        {
            view.b();
        }
        view.invalidate();
        view.requestLayout();
    }
}
