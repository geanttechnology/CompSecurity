// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.util.o;
import com.target.ui.model.list.ListDetailItem;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

public class af extends e
{

    private String mItemTitle;

    private af(String s1)
    {
        mItemTitle = s1;
    }

    public static af a(ListDetailItem listdetailitem)
    {
        if (listdetailitem != null)
        {
            listdetailitem = listdetailitem.b();
        } else
        {
            listdetailitem = null;
        }
        return new af(listdetailitem);
    }

    private String a(String s1)
    {
        if (o.e(s1))
        {
            return null;
        } else
        {
            return (new StringBuilder()).append("list promotion: ").append(mItemTitle).toString();
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "tapActionName", a(mItemTitle));
        return map;
    }

    protected s c()
    {
        return com.target.ui.analytics.a.s.List;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return y.ListPromo;
    }
}
