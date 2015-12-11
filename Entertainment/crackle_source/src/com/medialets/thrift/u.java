// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;

// Referenced classes of package com.medialets.thrift:
//            adExitEnum

final class u extends HashMap
{

    u()
    {
        put(Integer.valueOf(0), "MMExitUnkown");
        put(Integer.valueOf(1), "MMAdClickthrough");
        put(Integer.valueOf(2), "MMAdSkipped");
        put(Integer.valueOf(3), "MMAdExited");
        put(Integer.valueOf(4), "MMAdAppTerminated");
        put(Integer.valueOf(5), "MMAdAdTimeout");
        put(Integer.valueOf(6), "MMAppCrash");
    }
}
