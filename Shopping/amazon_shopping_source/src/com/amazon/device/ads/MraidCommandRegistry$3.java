// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidCommandRegistry, MraidCommandUseCustomClose, MraidView, MraidCommand

static final class ose
    implements aidCommandFactory
{

    public MraidCommand create(Map map, MraidView mraidview)
    {
        return new MraidCommandUseCustomClose(map, mraidview);
    }

    ose()
    {
    }
}
