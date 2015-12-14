// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;


// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            Event

public interface Timer
    extends Event
{

    public abstract void remove();

    public abstract void start();

    public abstract void stop();

    public abstract void stop(boolean flag);
}
