// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview;

import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview:
//            AccessoryDrawingCtrl

class c
{

    private static HashMap a;

    static HashMap a()
    {
        return a;
    }

    static 
    {
        a = new HashMap();
        a.put(AccessoryDrawingCtrl.AccessoryType.a, new AccessoryDrawingCtrl(AccessoryDrawingCtrl.AccessoryType.a, null));
        a.put(AccessoryDrawingCtrl.AccessoryType.b, new AccessoryDrawingCtrl(AccessoryDrawingCtrl.AccessoryType.b, null));
        a.put(AccessoryDrawingCtrl.AccessoryType.c, new AccessoryDrawingCtrl(AccessoryDrawingCtrl.AccessoryType.c, null));
        a.put(AccessoryDrawingCtrl.AccessoryType.d, new AccessoryDrawingCtrl(AccessoryDrawingCtrl.AccessoryType.d, null));
        a.put(AccessoryDrawingCtrl.AccessoryType.e, new AccessoryDrawingCtrl(AccessoryDrawingCtrl.AccessoryType.e, null));
    }
}
