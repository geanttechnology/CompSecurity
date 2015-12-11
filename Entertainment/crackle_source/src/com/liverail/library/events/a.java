// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.events;


// Referenced classes of package com.liverail.library.events:
//            VPAIDEventListener, VPAIDEvent

public interface a
{

    public abstract void addEventListener(String s, VPAIDEventListener vpaideventlistener);

    public abstract void dispatchEvent(VPAIDEvent vpaidevent);

    public abstract boolean hasEventListener(String s, VPAIDEventListener vpaideventlistener);

    public abstract void removeEventListener(String s, VPAIDEventListener vpaideventlistener);
}
