// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.CookieSyncManager;

// Referenced classes of package com.amazon.device.ads:
//            eb

static final class a
{

    boolean a;

    public final void a(Context context)
    {
        if (!a)
        {
            CookieSyncManager.createInstance(context);
            a = true;
        }
    }

    nager()
    {
        a = false;
    }
}
