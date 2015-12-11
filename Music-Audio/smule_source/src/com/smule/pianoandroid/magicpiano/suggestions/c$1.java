// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.suggestions;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.suggestions:
//            c

class a
    implements Observer
{

    final c a;

    public void update(Observable observable, Object obj)
    {
        observable = (String)((Map)obj).get("ACTION");
        if ("ENTITLEMENTS_UPDATED_ACTION".equals(observable) || "PRODUCTS_SORTED_ACTION".equals(observable))
        {
            a.c();
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
