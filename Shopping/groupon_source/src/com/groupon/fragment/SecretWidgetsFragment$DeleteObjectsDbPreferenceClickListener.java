// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.db.dao.DaoDealSummary;
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

private class <init>
    implements android.preference.r
{

    final SecretWidgetsFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        try
        {
            ((DaoDealSummary)SecretWidgetsFragment.access$300(SecretWidgetsFragment.this).get()).callBatchTasks(new Callable() {

                final SecretWidgetsFragment.DeleteObjectsDbPreferenceClickListener this$1;

                public Object call()
                    throws Exception
                {
                    ((GrouponOrmLiteHelper)SecretWidgetsFragment.access$200(this$0).get()).clearTables(new Class[] {
                        com/groupon/db/models/CouponSummary, com/groupon/db/models/CouponDetail, com/groupon/db/models/DealSubsetAttribute, com/groupon/db/models/DealSummary, com/groupon/db/models/CouponCategory, com/groupon/db/models/CouponMerchant, com/groupon/db/models/Pagination, com/groupon/db/models/WidgetSummary
                    });
                    return null;
                }

            
            {
                this$1 = SecretWidgetsFragment.DeleteObjectsDbPreferenceClickListener.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Preference preference)
        {
            throw new RuntimeException(preference);
        }
        return true;
    }

    private _cls1.this._cls1()
    {
        this$0 = SecretWidgetsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
