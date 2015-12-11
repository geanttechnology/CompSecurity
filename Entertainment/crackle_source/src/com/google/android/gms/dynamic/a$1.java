// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            d, a, LifecycleDelegate

class sw
    implements d
{

    final a sw;

    public void a(LifecycleDelegate lifecycledelegate)
    {
        com.google.android.gms.dynamic.a.a(sw, lifecycledelegate);
        for (lifecycledelegate = com.google.android.gms.dynamic.a.a(sw).iterator(); lifecycledelegate.hasNext(); ((sw)lifecycledelegate.next()).b(com.google.android.gms.dynamic.a.b(sw))) { }
        com.google.android.gms.dynamic.a.a(sw).clear();
        com.google.android.gms.dynamic.a.a(sw, null);
    }

    cycleDelegate(a a1)
    {
        sw = a1;
        super();
    }
}
