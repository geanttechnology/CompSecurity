// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.dynamic:
//            a, LifecycleDelegate

class sz
    implements sz
{

    final a sw;
    final Bundle sz;

    public void b(LifecycleDelegate lifecycledelegate)
    {
        a.b(sw).onCreate(sz);
    }

    public int getState()
    {
        return 1;
    }

    cycleDelegate(a a1, Bundle bundle)
    {
        sw = a1;
        sz = bundle;
        super();
    }
}
