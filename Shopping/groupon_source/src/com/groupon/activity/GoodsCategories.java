// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;
import com.groupon.service.CategoryService;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            Categories

public class GoodsCategories extends Categories
{

    private CategoryService categoryService;

    public GoodsCategories()
    {
    }

    protected Channel getChannel()
    {
        return Channel.GOODS;
    }

    protected void setUpCategories()
    {
        categoryService.getGoodsCategories(this, new Function1() {

            final GoodsCategories this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                onCategoriesSuccess(list);
            }

            
            {
                this$0 = GoodsCategories.this;
                super();
            }
        });
    }
}
