// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import viewpagerindicator.UnderlinePageIndicator;

public class cfz
    implements Runnable
{

    final UnderlinePageIndicator a;

    public cfz(UnderlinePageIndicator underlinepageindicator)
    {
        a = underlinepageindicator;
        super();
    }

    public void run()
    {
        if (UnderlinePageIndicator.access$000(a))
        {
            a.post(UnderlinePageIndicator.access$300(a));
        }
    }
}
