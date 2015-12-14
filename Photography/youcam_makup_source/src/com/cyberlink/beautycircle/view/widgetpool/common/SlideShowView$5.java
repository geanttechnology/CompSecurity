// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;


// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            SlideShowView

class a
    implements Runnable
{

    final SlideShowView a;

    public void run()
    {
        a.removeCallbacks(SlideShowView.e(a));
    }

    (SlideShowView slideshowview)
    {
        a = slideshowview;
        super();
    }
}
