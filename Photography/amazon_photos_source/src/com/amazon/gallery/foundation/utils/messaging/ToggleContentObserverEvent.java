// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class ToggleContentObserverEvent
{

    private final boolean enabled;
    private final boolean force;

    public ToggleContentObserverEvent(boolean flag)
    {
        enabled = flag;
        force = false;
    }

    public ToggleContentObserverEvent(boolean flag, boolean flag1)
    {
        enabled = flag;
        force = flag1;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public boolean isForce()
    {
        return force;
    }
}
