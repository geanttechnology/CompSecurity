// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Paint;
import viewpagerindicator.UnderlinePageIndicator;

public class cfy
    implements Runnable
{

    final UnderlinePageIndicator a;

    public cfy(UnderlinePageIndicator underlinepageindicator)
    {
        a = underlinepageindicator;
        super();
    }

    public void run()
    {
        if (UnderlinePageIndicator.access$000(a))
        {
            int i = Math.max(UnderlinePageIndicator.access$100(a).getAlpha() - UnderlinePageIndicator.access$200(a), 0);
            UnderlinePageIndicator.access$100(a).setAlpha(i);
            a.invalidate();
            if (i > 0)
            {
                a.postDelayed(this, 30L);
                return;
            }
        }
    }
}
