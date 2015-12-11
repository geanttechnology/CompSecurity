// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidCommand, MraidView, MraidDisplayController

class MraidCommandPlayVideo extends MraidCommand
{

    MraidCommandPlayVideo(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        Controller.Dimensions dimensions = null;
        Integer ainteger[] = getIntArrayFromParamsForKey("position");
        if (ainteger[0].intValue() != -1)
        {
            dimensions = new Controller.Dimensions();
            dimensions.y = ainteger[0].intValue();
            dimensions.x = ainteger[1].intValue();
            dimensions.width = ainteger[2].intValue();
            dimensions.height = ainteger[3].intValue();
        }
        String s = getStringFromParamsForKey("url");
        Controller.PlayerProperties playerproperties = new Controller.PlayerProperties();
        playerproperties.setProperties(getBooleanFromParamsForKey("audioMuted"), getBooleanFromParamsForKey("autoPlay"), getBooleanFromParamsForKey("controls"), true, getBooleanFromParamsForKey("loop"), getStringFromParamsForKey("startStyle"), getStringFromParamsForKey("stopStyle"));
        mView.getDisplayController().playVideo(s, dimensions, playerproperties);
    }
}
