// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.os.Looper;

// Referenced classes of package com.urbanairship:
//            CancelableOperation, UAirship

final class peration extends CancelableOperation
{

    final ReadyCallback val$callback;

    public final void onRun()
    {
        if (val$callback != null)
        {
            val$callback.onAirshipReady(UAirship.shared());
        }
    }

    ReadyCallback(ReadyCallback readycallback)
    {
        val$callback = readycallback;
        super(final_looper);
    }
}
