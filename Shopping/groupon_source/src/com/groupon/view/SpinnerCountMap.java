// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;

// Referenced classes of package com.groupon.view:
//            SpinnerLoggerCountMap, SpinnerButton

public class SpinnerCountMap extends SpinnerLoggerCountMap
{

    public SpinnerCountMap()
    {
    }

    public int decrement(Object obj)
    {
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            int j = super.decrement(obj);
            i = j;
            if (j == 0)
            {
                if (obj instanceof SpinnerButton)
                {
                    ((SpinnerButton)obj).stopSpinning();
                    return j;
                }
                i = j;
                if (obj instanceof View)
                {
                    ((View)obj).setVisibility(8);
                    return j;
                }
            }
        }
        return i;
    }

    public int increment(Object obj)
    {
        if (obj == null)
        {
            return 0;
        }
        if (!(obj instanceof SpinnerButton)) goto _L2; else goto _L1
_L1:
        ((SpinnerButton)obj).startSpinning();
_L4:
        return super.increment(obj);
_L2:
        if (obj instanceof View)
        {
            ((View)obj).setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
