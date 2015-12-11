// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.tagging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.shazam.android.service.tagging:
//            AutoTaggingService

final class a extends BroadcastReceiver
{

    final AutoTaggingService a;

    public final void onReceive(Context context, Intent intent)
    {
        a.stopSelf();
    }

    (AutoTaggingService autotaggingservice)
    {
        a = autotaggingservice;
        super();
    }
}
