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
//            gj, dq, ax, fi, 
//            g, gl

final class ai
    implements gj
{

    private final List cc;

    public ai()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new dq());
        arraylist.add(new ax());
        arraylist.add(new fi());
        arraylist.add(new g());
        cc = Collections.unmodifiableList(arraylist);
    }

    public final boolean a(Context context, gl gl)
    {
        if (context != null && gl != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        Iterator iterator = cc.iterator();
        boolean flag = true;
        do
        {
            flag1 = flag;
            if (!iterator.hasNext())
            {
                continue;
            }
            if (!((gj)iterator.next()).a(context, gl))
            {
                flag = false;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
