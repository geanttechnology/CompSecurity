// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.a;

// Referenced classes of package com.smule.android.network.managers:
//            LocalizationManager

class b
    implements Runnable
{

    final String a;
    final tLocalizationPackageListener b;
    final LocalizationManager c;

    public void run()
    {
        com.smule.android.network.managers.LocalizationManager.a(c, a);
        com.smule.android.network.core.a.a(b, c.a(a));
    }

    tLocalizationPackageListener(LocalizationManager localizationmanager, String s, tLocalizationPackageListener tlocalizationpackagelistener)
    {
        c = localizationmanager;
        a = s;
        b = tlocalizationpackagelistener;
        super();
    }
}
