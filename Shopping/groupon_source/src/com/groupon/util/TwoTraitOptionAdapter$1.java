// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.Option;
import java.util.Comparator;

// Referenced classes of package com.groupon.util:
//            TwoTraitOptionAdapter, BuyUtils

class this._cls0
    implements Comparator
{

    final TwoTraitOptionAdapter this$0;

    public int compare(Option option, Option option1)
    {
        boolean flag;
        boolean flag1;
        if (option.isSoldOut() || TwoTraitOptionAdapter.access$000(TwoTraitOptionAdapter.this).isOptionExpired(option))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (option1.isSoldOut() || TwoTraitOptionAdapter.access$000(TwoTraitOptionAdapter.this).isOptionExpired(option1))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag == flag1)
        {
            return 0;
        }
        return !flag ? -1 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Option)obj, (Option)obj1);
    }

    ()
    {
        this$0 = TwoTraitOptionAdapter.this;
        super();
    }
}
