// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            ba, cv, FlurryAds, cw, 
//            AdUnit, ae

final class bb
    implements ba
{

    private final List dd;

    public bb()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cv());
        dd = Collections.unmodifiableList(arraylist);
    }

    public final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        ae ae = null;
        Iterator iterator = dd.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ae ae1 = ((ba)iterator.next()).a(context, flurryads, cw, adunit);
            ae = ae1;
            if (ae1 == null)
            {
                continue;
            }
            ae = ae1;
            break;
        } while (true);
        return ae;
    }
}
