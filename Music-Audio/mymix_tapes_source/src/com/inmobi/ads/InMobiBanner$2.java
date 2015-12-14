// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.view.ViewTreeObserver;
import com.inmobi.commons.core.utilities.info.DisplayInfo;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner

class a
    implements android.view.r.OnGlobalLayoutListener
{

    final InMobiBanner a;

    public void onGlobalLayout()
    {
label0:
        {
            InMobiBanner.access$502(a, DisplayInfo.a(a.getMeasuredWidth()));
            InMobiBanner.access$602(a, DisplayInfo.a(a.getMeasuredHeight()));
            if (a.hasValidSize())
            {
                if (android.os.DK_INT < 16)
                {
                    break label0;
                }
                a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            return;
        }
        a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    ies.info.DisplayInfo(InMobiBanner inmobibanner)
    {
        a = inmobibanner;
        super();
    }
}
