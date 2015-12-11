// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.db.models.Pagination;
import com.groupon.v3.loader.EmptyListChecker;
import com.groupon.v3.trigger.NextPageTrigger;
import com.groupon.v3.view.list_view.LocationBarHeader;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            FeaturedRapiFragment

private static class <init>
    implements EmptyListChecker
{

    public boolean isEmpty(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = list.next();
            if (!(obj instanceof LocationBarHeader) && !(obj instanceof NextPageTrigger) && !(obj instanceof Pagination))
            {
                return false;
            }
        }

        return true;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
