// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import android.content.Intent;

// Referenced classes of package com.ebay.common.model.mdns:
//            PlatformNotificationsEvent

public static class  extends PlatformNotificationsEvent
{

    public void setInfo(Intent intent)
    {
        code = intent.getStringExtra("code");
    }

    public ()
    {
        super.eventType = .();
    }
}
