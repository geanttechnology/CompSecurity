// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util.b;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.shazam.android.util.b:
//            a

public final class b
    implements a
{

    private final Context b;

    public b(Context context)
    {
        b = context;
    }

    public final void a(Intent intent)
    {
        b.sendBroadcast(intent);
    }
}
