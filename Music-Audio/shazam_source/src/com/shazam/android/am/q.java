// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import android.content.Context;
import com.google.android.now.NowAuthService;

// Referenced classes of package com.shazam.android.am:
//            h

public final class q
    implements h
{

    private final Context a;
    private final String b;

    public q(Context context, String s)
    {
        a = context;
        b = s;
    }

    public final void a()
    {
        NowAuthService.getAuthCode(a, b);
    }
}
