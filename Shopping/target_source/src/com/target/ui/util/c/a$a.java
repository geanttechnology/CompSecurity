// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.c;

import com.target.a.a.b;
import de.greenrobot.event.NoSubscriberEvent;

// Referenced classes of package com.target.ui.util.c:
//            a

public static class scriberEvent
    implements scriberEvent
{

    public void a(NoSubscriberEvent nosubscriberevent)
    {
        nosubscriberevent = nosubscriberevent.originalEvent.getClass().getSimpleName();
        b.b(com.target.ui.util.c.a.b(), (new StringBuilder()).append("\n\n\n\n\nWARNING: NO SUBSCRIBERS FOR POSTED EVENT: ").append(nosubscriberevent).append("\n\n\n\n\n").toString());
    }

    public scriberEvent()
    {
    }
}
