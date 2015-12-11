// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            a, al

static final class a
    implements Runnable
{

    final Context a;

    public final void run()
    {
        al.b();
        com.millennialmedia.android.a.c(a);
        com.millennialmedia.android.a.d(a);
    }

    (Context context)
    {
        a = context;
        super();
    }
}
