// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.content.Context;
import com.shazam.android.util.s;

// Referenced classes of package com.shazam.android.service.player:
//            o, i

public final class n
    implements o
{

    private final s a;
    private final String b;
    private final Context c;

    public n(Context context, s s1, String s2)
    {
        c = context;
        a = s1;
        b = s2;
    }

    public final void a()
    {
        String s1 = c.getString(0x7f0900d2, new Object[] {
            b
        });
        s s2 = a;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.b = s1;
        a1.c = 1;
        s2.a(a1.a());
        c.startService(i.b("actionPause"));
    }
}
