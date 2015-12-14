// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;


// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class a
    implements Runnable
{

    final MakeupLooksBottomToolbar a;

    public void run()
    {
        if (MakeupLooksBottomToolbar.b(a) != null)
        {
            MakeupLooksBottomToolbar.q(a);
        }
    }

    (MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        a = makeuplooksbottomtoolbar;
        super();
    }
}
