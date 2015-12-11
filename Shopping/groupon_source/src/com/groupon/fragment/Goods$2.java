// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.groupon.adapter.GoodsCategoriesAdapter;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.Function1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            Goods

class this._cls0
    implements Function1
{

    final Goods this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        boolean flag = true;
        Goods.access$300(Goods.this, true);
        Goods.access$402(Goods.this, Goods.access$500(Goods.this).getGoodsCategories(list));
        getArguments().putParcelableArrayList("categories_list", (ArrayList)Goods.access$400(Goods.this));
        if (Goods.access$400(Goods.this).size() < 2)
        {
            flag = false;
        }
        if (flag)
        {
            Collections.sort(Goods.access$400(Goods.this), new com.groupon.util.esUtil.CategoryComparator());
            list = new GoodsCategoriesAdapter(getActivity(), Goods.access$400(Goods.this));
            list.setOnItemClickListener(new GoodsCategoryItemClickListener(Goods.this, null));
            Goods.access$700(Goods.this).setAdapter(list);
            Goods.access$800(Goods.this).getLayoutParams().height = (int)getResources().getDimension(0x7f0b0148);
            return;
        } else
        {
            Goods.access$800(Goods.this).getLayoutParams().height = -2;
            return;
        }
    }

    Params()
    {
        this$0 = Goods.this;
        super();
    }
}
