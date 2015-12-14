// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;


// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            UnderlinePageIndicator

final class a
    implements Runnable
{

    private UnderlinePageIndicator a;

    public final void run()
    {
        if (UnderlinePageIndicator.a(a))
        {
            a.post(UnderlinePageIndicator.d(a));
        }
    }

    I(UnderlinePageIndicator underlinepageindicator)
    {
        a = underlinepageindicator;
        super();
    }
}
