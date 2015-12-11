// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p.a;

import android.content.pm.PackageManager;

// Referenced classes of package com.shazam.android.p.a:
//            c

public final class f
    implements c
{

    private final PackageManager a;

    public f(PackageManager packagemanager)
    {
        a = packagemanager;
    }

    public final boolean a(String s)
    {
        boolean flag = false;
        if (a.resolveContentProvider(s, 0) != null)
        {
            flag = true;
        }
        return flag;
    }
}
