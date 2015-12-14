// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.widget.Toast;

// Referenced classes of package com.socialin.android.apiv3.log:
//            EventLoggingService

final class a
    implements Runnable
{

    private Toast a;

    public final void run()
    {
        a.cancel();
    }

    (Toast toast)
    {
        a = toast;
        super();
    }
}
