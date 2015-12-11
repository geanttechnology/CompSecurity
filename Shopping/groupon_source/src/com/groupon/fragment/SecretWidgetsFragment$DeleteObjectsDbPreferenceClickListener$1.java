// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponSummary;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.WidgetSummary;
import java.util.concurrent.Callable;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretWidgetsFragment

class this._cls1
    implements Callable
{

    final is._cls0 this$1;

    public Object call()
        throws Exception
    {
        ((GrouponOrmLiteHelper)SecretWidgetsFragment.access$200(_fld0).get()).clearTables(new Class[] {
            com/groupon/db/models/CouponSummary, com/groupon/db/models/CouponDetail, com/groupon/db/models/DealSubsetAttribute, com/groupon/db/models/DealSummary, com/groupon/db/models/CouponCategory, com/groupon/db/models/CouponMerchant, com/groupon/db/models/Pagination, com/groupon/db/models/WidgetSummary
        });
        return null;
    }

    Y()
    {
        this$1 = this._cls1.this;
        super();
    }
}
