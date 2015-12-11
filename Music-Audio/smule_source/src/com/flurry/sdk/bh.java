// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            bi, bg, bl, be, 
//            bk, bm

public final class bh
    implements bi
{

    private final List a;

    public bh()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bg());
        arraylist.add(new bl());
        arraylist.add(new be());
        arraylist.add(new bk());
        a = Collections.unmodifiableList(arraylist);
    }

    public boolean a(Context context, bm bm)
    {
        if (context != null && bm != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        Iterator iterator = a.iterator();
        boolean flag = true;
        do
        {
            flag1 = flag;
            if (!iterator.hasNext())
            {
                continue;
            }
            if (!((bi)iterator.next()).a(context, bm))
            {
                flag = false;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
