// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;


// Referenced classes of package com.freewheel.ad:
//            SlideShowAdRequester, AdFetcher

class this._cls0
    implements Runnable
{

    final SlideShowAdRequester this$0;

    public void run()
    {
        if (SlideShowAdRequester.access$000(SlideShowAdRequester.this) == null)
        {
            SlideShowAdRequester.access$002(SlideShowAdRequester.this, new AdFetcher(SlideShowAdRequester.this));
        }
        SlideShowAdRequester.access$000(SlideShowAdRequester.this).loadAd(getSectionName());
    }

    ()
    {
        this$0 = SlideShowAdRequester.this;
        super();
    }
}
