// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

abstract class d extends e
{

    private static final String ROW_COLUMN_FORMAT = "r%dc%d";
    private Integer mColumn;
    private Integer mRow;
    private y mTapAction;

    protected d(y y, Integer integer, Integer integer1)
    {
        mColumn = integer1;
        mRow = integer;
        mTapAction = y;
    }

    private String a(Integer integer, Integer integer1)
    {
        if (integer == null || integer1 == null)
        {
            return null;
        } else
        {
            return String.format("r%dc%d", new Object[] {
                integer, integer1
            });
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "linkPosition", a(mRow, mColumn));
        return map;
    }

    protected s c()
    {
        return s.Deals;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return mTapAction;
    }
}
