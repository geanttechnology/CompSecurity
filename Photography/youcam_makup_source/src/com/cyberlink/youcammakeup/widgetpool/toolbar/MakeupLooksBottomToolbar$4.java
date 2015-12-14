// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class a
    implements c
{

    final MakeupLooksBottomToolbar a;

    public void a()
    {
        Object obj = a.getActivity();
        if (!(obj instanceof EditViewActivity))
        {
            return;
        } else
        {
            obj = (EditViewActivity)obj;
            ((EditViewActivity) (obj)).b(this);
            ((EditViewActivity) (obj)).b(false, false);
            a.c(true);
            return;
        }
    }

    (MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        a = makeuplooksbottomtoolbar;
        super();
    }
}
