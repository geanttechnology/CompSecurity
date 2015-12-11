// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common.a;

import com.target.mothership.services.aa;
import com.target.mothership.services.x;
import com.target.mothership.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.common.a:
//            d, c, f, j

public class h
    implements aa
{

    private com.target.mothership.model.common.a.f mEmptyErrorCondition;
    private d mJsonTransformer;

    public h(d d1, com.target.mothership.model.common.a.f f1)
    {
        mJsonTransformer = d1;
        mEmptyErrorCondition = f1;
    }

    public com.target.mothership.model.common.a.f a(x x1)
    {
        List list = (List)mJsonTransformer.a(x1);
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (c)iterator.next();
            j j1 = f.a(mEmptyErrorCondition, ((c) (obj)));
            obj = j1;
            if (j1 == null)
            {
                obj = f.a(mEmptyErrorCondition, c._ERR_UNKNOWN);
            }
            if (!arraylist.contains(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        mEmptyErrorCondition.a(x1);
        mEmptyErrorCondition.a(arraylist);
        mEmptyErrorCondition.a((j)arraylist.get(0));
        return mEmptyErrorCondition;
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
