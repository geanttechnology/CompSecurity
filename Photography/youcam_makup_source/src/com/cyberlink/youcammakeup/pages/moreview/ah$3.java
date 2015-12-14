// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.aj;
import com.cyberlink.youcammakeup.database.more.f.b;
import com.cyberlink.youcammakeup.flurry.YMKNoticeItemURLClicksEvent;
import com.cyberlink.youcammakeup.flurry.a;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ah

class a
    implements android.view.OnClickListener
{

    final ah a;

    public void onClick(View view)
    {
        view = (Integer)view.getTag();
        view = (b)a.getGroup(view.intValue());
        String s = view.f();
        com.cyberlink.youcammakeup.clflurry.b.a(new aj(view.a()));
        com.cyberlink.youcammakeup.flurry.a.a(new YMKNoticeItemURLClicksEvent(view.a()));
        com.cyberlink.youcammakeup.utility.a.b(s, Globals.d().a(com.cyberlink.youcammakeup.ls.ActivityType.b), null);
    }

    (ah ah1)
    {
        a = ah1;
        super();
    }
}
