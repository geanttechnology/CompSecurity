// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiComposeView;

class ava
    implements Runnable
{

    final TTieZhiInfo a;
    final auz b;

    ava(auz auz1, TTieZhiInfo ttiezhiinfo)
    {
        b = auz1;
        a = ttiezhiinfo;
        super();
    }

    public void run()
    {
        b.a.l.addTieZhiWithInfo(a, true);
    }
}
