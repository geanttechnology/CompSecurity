// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.Pagination;
import com.groupon.v3.loader.EmptyListChecker;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            BaseRecyclerViewDelegate

private static class <init>
    implements EmptyListChecker
{

    public boolean isEmpty(List list)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            if (list != null && !list.isEmpty())
            {
                flag = flag1;
                if (list.size() != 1)
                {
                    break label0;
                }
                flag = flag1;
                if (!(list.get(0) instanceof Pagination))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
