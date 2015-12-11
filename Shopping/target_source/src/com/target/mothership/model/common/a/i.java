// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common.a;

import com.target.mothership.services.aa;
import com.target.mothership.services.x;
import com.target.mothership.util.f;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.common.a:
//            e, c, f

public class i
    implements aa
{

    private com.target.mothership.model.common.a.f mCondition;
    private e mJsonTransformer;

    public i(e e1, com.target.mothership.model.common.a.f f1)
    {
        mJsonTransformer = e1;
        mCondition = f1;
    }

    public com.target.mothership.model.common.a.f a(x x1)
    {
        Object obj = (c)mJsonTransformer.a(x1);
        obj = f.a(mCondition, ((c) (obj)));
        mCondition.a(((j) (obj)));
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(obj);
        mCondition.a(arraylist);
        mCondition.a(x1);
        return mCondition;
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
