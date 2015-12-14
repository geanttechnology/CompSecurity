// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.d;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class b
    implements d
{

    final MakeupMode a;
    final BeautyMode b;
    final EditViewActivity c;

    public void a()
    {
        EditViewActivity.f(c).b(this);
        EditViewActivity.f(c).b(a, b);
    }

    BottomToolbar(EditViewActivity editviewactivity, MakeupMode makeupmode, BeautyMode beautymode)
    {
        c = editviewactivity;
        a = makeupmode;
        b = beautymode;
        super();
    }
}
