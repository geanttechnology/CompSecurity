// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.os.HandlerThread;

// Referenced classes of package com.g.c:
//            i

static final class ring extends HandlerThread
{

    ring()
    {
        super("Picasso-Dispatcher", 10);
    }
}
