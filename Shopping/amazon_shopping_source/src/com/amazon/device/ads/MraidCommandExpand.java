// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidCommand, MraidView, MraidDisplayController

class MraidCommandExpand extends MraidCommand
{

    MraidCommandExpand(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        int j = getIntFromParamsForKey("w");
        int k = getIntFromParamsForKey("h");
        String s = getStringFromParamsForKey("url");
        boolean flag = getBooleanFromParamsForKey("shouldUseCustomClose");
        boolean flag1 = getBooleanFromParamsForKey("lockOrientation");
        int i = j;
        if (j <= 0)
        {
            i = mView.getDisplayController().mScreenWidth;
        }
        j = k;
        if (k <= 0)
        {
            j = mView.getDisplayController().mScreenHeight;
        }
        mView.getDisplayController().expand(s, i, j, flag, flag1);
    }
}
