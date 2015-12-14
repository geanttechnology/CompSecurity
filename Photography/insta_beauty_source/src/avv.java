// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiComposeView;

public class avv
    implements Runnable
{

    final TTieZhiInfo a;
    final TTieZhiActivity b;

    public avv(TTieZhiActivity ttiezhiactivity, TTieZhiInfo ttiezhiinfo)
    {
        b = ttiezhiactivity;
        a = ttiezhiinfo;
        super();
    }

    public void run()
    {
        b.l.addTieZhiWithInfo(a, false);
    }
}
