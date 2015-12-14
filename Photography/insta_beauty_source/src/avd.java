// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiCollectionPageScrolllView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;

public class avd
    implements Runnable
{

    final TTieZhiActivity a;

    public avd(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void run()
    {
        a.n.setVisibility(4);
        a.v = false;
        if (!aaj.c() && a.o.getVisibility() == 0)
        {
            a.o.refresh();
        }
    }
}
