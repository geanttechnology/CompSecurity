// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            cd, AdSpaceLayout

final class x extends cd
{

    private static final Map am;

    x()
    {
    }

    private static Integer f(String s)
    {
        return (Integer)am.get(s);
    }

    public final android.view.ViewGroup.LayoutParams a(Context context, AdSpaceLayout adspacelayout)
    {
        context = new android.widget.RelativeLayout.LayoutParams(b(context, adspacelayout), c(context, adspacelayout));
        adspacelayout = adspacelayout.getAlignment().toString().split("-");
        if (adspacelayout.length == 2)
        {
            Integer integer = f(adspacelayout[0]);
            if (integer != null)
            {
                context.addRule(integer.intValue());
            }
            adspacelayout = f(adspacelayout[1]);
            if (adspacelayout != null)
            {
                context.addRule(adspacelayout.intValue());
            }
        }
        return context;
    }

    public final int m()
    {
        return -1;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("b", Integer.valueOf(12));
        hashmap.put("t", Integer.valueOf(10));
        hashmap.put("m", Integer.valueOf(15));
        hashmap.put("c", Integer.valueOf(14));
        hashmap.put("l", Integer.valueOf(9));
        hashmap.put("r", Integer.valueOf(11));
        am = Collections.unmodifiableMap(hashmap);
    }
}
