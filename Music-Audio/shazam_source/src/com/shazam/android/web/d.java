// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web;

import android.webkit.CookieManager;
import com.shazam.model.configuration.InstallationIdRepository;

// Referenced classes of package com.shazam.android.web:
//            a

public final class d
    implements a
{

    private final CookieManager a;
    private final InstallationIdRepository b;

    public d(CookieManager cookiemanager, InstallationIdRepository installationidrepository)
    {
        a = cookiemanager;
        b = installationidrepository;
    }

    public final void a()
    {
        if (b.a())
        {
            a.setCookie(".shazam.com", (new StringBuilder("shazamINID=")).append(b.b()).toString());
        }
    }
}
