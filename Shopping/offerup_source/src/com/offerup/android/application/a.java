// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.application;

import com.offerup.android.notifications.b;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;

// Referenced classes of package com.offerup.android.application:
//            OfferUpApplication

final class a
    implements com.urbanairship.UAirship.OnReadyCallback
{

    private OfferUpApplication a;

    a(OfferUpApplication offerupapplication)
    {
        a = offerupapplication;
        super();
    }

    public final void onAirshipReady(UAirship uairship)
    {
        uairship = UAirship.shared().getPushManager();
        uairship.setPushEnabled(true);
        uairship.setUserNotificationsEnabled(true);
        uairship.setSoundEnabled(true);
        uairship.setVibrateEnabled(true);
        uairship.setQuietTimeEnabled(false);
        uairship.setNotificationFactory(new b(a));
    }
}
