// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.flurry.FaceDetectionResultEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.aw;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements aw
{

    final List a;
    final EditViewActivity b;

    public void a()
    {
        EditViewActivity.n(b);
        if (a.size() > 0 && StatusManager.j().P())
        {
            EditViewActivity.o(b);
            EditViewActivity.p(b);
        }
    }

    public void a(List list)
    {
        EditViewActivity.n(b);
        if (list.size() > 0 && StatusManager.j().P())
        {
            EditViewActivity.o(b);
            EditViewActivity.p(b);
        }
        int i = 0;
        if (list != null)
        {
            i = list.size();
        }
        com.cyberlink.youcammakeup.flurry.a.a(new FaceDetectionResultEvent(i));
    }

    ent(EditViewActivity editviewactivity, List list)
    {
        b = editviewactivity;
        a = list;
        super();
    }
}
