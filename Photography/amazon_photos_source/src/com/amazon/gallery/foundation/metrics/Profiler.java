// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import java.util.Map;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            Timer

public interface Profiler
{

    public abstract void endSession();

    public abstract Timer newTimer(String s, String s1);

    public abstract Timer newTimer(String s, String s1, Map map);

    public abstract void startSession();

    public abstract void trackEvent(String s, String s1);

    public abstract void trackEvent(String s, String s1, Map map);

    public abstract void trackEvent(String s, String s1, boolean flag);

    public abstract void trackTimer(String s, String s1, long l);

    public abstract void trackTimer(String s, String s1, long l, Map map);

    public abstract void trackTimer(String s, String s1, long l, Map map, boolean flag);

    public abstract void trackTimer(String s, String s1, long l, boolean flag);
}
