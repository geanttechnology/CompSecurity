// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            PageMetricsObserver

public interface PageMetricsEventListener
{

    public abstract void onPageCancelled(PageMetricsObserver pagemetricsobserver, String s);

    public abstract void onPageComplete(PageMetricsObserver pagemetricsobserver, String s);

    public abstract void onPageStart(PageMetricsObserver pagemetricsobserver, String s);
}
