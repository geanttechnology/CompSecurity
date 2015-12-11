// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import com.groupon.tracking.mobile.events.MobileEvent;

// Referenced classes of package com.groupon:
//            RedirectLogger

public static class event
{

    private MobileEvent event;
    private String keyString;

    public MobileEvent getEvent()
    {
        return event;
    }

    public String getKeyString()
    {
        return keyString;
    }

    public ent(String s, MobileEvent mobileevent)
    {
        keyString = s;
        event = mobileevent;
    }
}
