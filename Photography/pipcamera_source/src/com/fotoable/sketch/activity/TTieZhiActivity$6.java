// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import com.fotoable.sketch.view.TTieZhiCollectionPageScrolllView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import gb;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements Runnable
{

    final TTieZhiActivity a;

    public void run()
    {
        a.o.setVisibility(4);
        a.v = false;
        if (!gb.c() && a.p.getVisibility() == 0)
        {
            a.p.refresh();
        }
    }

    crolllView(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
