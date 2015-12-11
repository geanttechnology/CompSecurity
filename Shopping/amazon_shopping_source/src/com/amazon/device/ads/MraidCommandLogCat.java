// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidCommand, Log, MraidView

class MraidCommandLogCat extends MraidCommand
{

    private static final String MRAID_LOG_TAG = "MRAIDLog";

    MraidCommandLogCat(Map map, MraidView mraidview)
    {
        super(map, mraidview);
    }

    void execute()
    {
        int i = getIntFromParamsForKey("level");
        String s;
        for (s = getStringFromParamsForKey("log"); i == -1 || s == null || s.length() == 0;)
        {
            return;
        }

        switch (i)
        {
        case 4: // '\004'
        default:
            Log.i("MRAIDLog", s);
            return;

        case 3: // '\003'
            Log.d("MRAIDLog", s);
            return;

        case 2: // '\002'
            Log.v("MRAIDLog", s);
            return;

        case 5: // '\005'
            Log.w("MRAIDLog", s);
            return;

        case 6: // '\006'
            Log.e("MRAIDLog", s);
            break;
        }
    }
}
