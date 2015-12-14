// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InlineAd

public static interface us
{

    public abstract void onAdLeftApplication(InlineAd inlinead);

    public abstract void onClicked(InlineAd inlinead);

    public abstract void onCollapsed(InlineAd inlinead);

    public abstract void onExpanded(InlineAd inlinead);

    public abstract void onRequestFailed(InlineAd inlinead, us us);

    public abstract void onRequestSucceeded(InlineAd inlinead);

    public abstract void onResize(InlineAd inlinead, int i, int j);

    public abstract void onResized(InlineAd inlinead, int i, int j, boolean flag);
}
