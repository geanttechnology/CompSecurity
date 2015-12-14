// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;

class avg
    implements Runnable
{

    final ave a;

    avg(ave ave1)
    {
        a = ave1;
        super();
    }

    public void run()
    {
        a.c.G = false;
        if (a.b)
        {
            a.c.c();
            return;
        } else
        {
            a.c.n.setIsFinishLoad(a.c.t);
            a.c.n.jumpToIndex(4);
            return;
        }
    }
}
