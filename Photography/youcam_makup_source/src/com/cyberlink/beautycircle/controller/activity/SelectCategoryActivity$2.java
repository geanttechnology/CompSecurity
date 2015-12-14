// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SelectCategoryActivity

class a extends m
{

    final SelectCategoryActivity a;

    protected void a(d d1)
    {
        if (d1 != null && d1.b != null && !d1.b.isEmpty())
        {
            SelectCategoryActivity.a(a).addAll(d1.b);
            int j = SelectCategoryActivity.a(a).getCount();
            d1 = null;
            for (int i = 0; i < j; i++)
            {
                CircleType circletype = (CircleType)SelectCategoryActivity.a(a).getItem(i);
                if (circletype != null && SelectCategoryActivity.c(a) != null && SelectCategoryActivity.c(a).longValue() > 0L && SelectCategoryActivity.c(a).equals(circletype.id))
                {
                    SelectCategoryActivity.a(a, circletype);
                    com.cyberlink.beautycircle.controller.activity.SelectCategoryActivity.d(a).setItemChecked(i, true);
                }
                if (circletype != null && circletype.defaultType.equals("HOW-TO"))
                {
                    d1 = circletype;
                }
            }

            if (d1 != null)
            {
                SelectCategoryActivity.a(a).remove(d1);
                return;
            }
        }
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    (SelectCategoryActivity selectcategoryactivity)
    {
        a = selectcategoryactivity;
        super();
    }
}
