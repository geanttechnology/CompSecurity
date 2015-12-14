// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.cyberlink.beautycircle.model.CircleType;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SelectCategoryActivity

class a
    implements android.widget.stener
{

    final SelectCategoryActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CircleType)SelectCategoryActivity.a(a).getItem(i);
        if (adapterview != null)
        {
            SelectCategoryActivity.a(a, adapterview);
            SelectCategoryActivity.a(a, ((CircleType) (adapterview)).id);
            SelectCategoryActivity.b(a);
        }
    }

    (SelectCategoryActivity selectcategoryactivity)
    {
        a = selectcategoryactivity;
        super();
    }
}
