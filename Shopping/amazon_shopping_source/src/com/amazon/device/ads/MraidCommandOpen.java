// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidCommand, MraidView, MraidBrowserController

class MraidCommandOpen extends MraidCommand
{

    MraidCommandOpen(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        String s = getStringFromParamsForKey("url");
        mView.getBrowserController().open(s);
    }
}
