// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.a.d.h;
import com.google.a.d.i;
import com.rdio.android.core.util.Logging;

// Referenced classes of package com.rdio.android.core:
//            SharedAsyncEventBus

class val.logging
    implements i
{

    final Logging val$logging;

    public void handleException(Throwable throwable, h h)
    {
        val$logging.log(6, "SharedAsyncEventBus", "Exception thrown when handling event.");
        val$logging.logException(throwable, true);
    }

    ()
    {
        val$logging = logging1;
        super();
    }
}
