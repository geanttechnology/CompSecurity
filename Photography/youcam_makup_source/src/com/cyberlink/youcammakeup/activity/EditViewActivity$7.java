// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.flurry.FaceDetectionResultEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.aw;
import com.cyberlink.youcammakeup.utility.o;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements aw
{

    final o a;
    final EditViewActivity b;

    public void a()
    {
        a.a(true);
    }

    public void a(List list)
    {
        a.a(true);
        int i = 0;
        if (list != null)
        {
            i = list.size();
        }
        com.cyberlink.youcammakeup.flurry.a.a(new FaceDetectionResultEvent(i));
    }

    ent(EditViewActivity editviewactivity, o o1)
    {
        b = editviewactivity;
        a = o1;
        super();
    }
}
