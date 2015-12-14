// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            af

final class a
    implements Runnable
{

    final View a;

    public void run()
    {
        if (a != null)
        {
            a.setVisibility(0);
        }
    }

    (View view)
    {
        a = view;
        super();
    }
}
