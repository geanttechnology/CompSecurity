// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;

// Referenced classes of package com.groupon.view:
//            ReferenceCountMap

public class HideCountMap extends ReferenceCountMap
{

    public HideCountMap()
    {
    }

    public int decrement(View view)
    {
        int i;
        if (view == null)
        {
            i = 0;
        } else
        {
            int j = super.decrement(view);
            i = j;
            if (j == 0)
            {
                view.setVisibility(0);
                return j;
            }
        }
        return i;
    }

    public volatile int decrement(Object obj)
    {
        return decrement((View)obj);
    }

    public int increment(View view)
    {
        if (view == null)
        {
            return 0;
        } else
        {
            view.setVisibility(8);
            return super.increment(view);
        }
    }

    public volatile int increment(Object obj)
    {
        return increment((View)obj);
    }
}
