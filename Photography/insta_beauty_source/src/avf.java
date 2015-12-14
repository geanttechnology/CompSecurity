// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import java.util.List;

class avf
    implements Runnable
{

    final ave a;

    avf(ave ave1)
    {
        a = ave1;
        super();
    }

    public void run()
    {
        a.c.G = false;
        if (a.c.n.getVisibility() == 0 && TTieZhiActivity.i(a.c).size() > 0)
        {
            a.c.n.setIsFinishLoad(a.c.t);
            a.c.n.handleData(TTieZhiActivity.i(a.c));
        }
    }
}
