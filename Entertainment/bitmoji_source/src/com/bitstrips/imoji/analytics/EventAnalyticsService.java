// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;


// Referenced classes of package com.bitstrips.imoji.analytics:
//            Category, Action

public interface EventAnalyticsService
{

    public abstract void sendEvent(Category category, Action action, String s);

    public abstract void sendEvent(Category category, Action action, String s, long l);
}
