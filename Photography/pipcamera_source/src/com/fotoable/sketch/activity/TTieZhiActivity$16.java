// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiComposeView;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements Runnable
{

    final TTieZhiInfo a;
    final TTieZhiActivity b;

    public void run()
    {
        b.m.addTieZhiWithInfo(a, false);
    }

    (TTieZhiActivity ttiezhiactivity, TTieZhiInfo ttiezhiinfo)
    {
        b = ttiezhiactivity;
        a = ttiezhiinfo;
        super();
    }
}
