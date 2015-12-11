// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
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
//            BaseSecretSettingsFragment, SecretSetOnceFlagsFragment

public class SecretWidgetsFragment extends BaseSecretSettingsFragment
{
    private class DeleteObjectsDbPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final SecretWidgetsFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            try
            {
                ((DaoDealSummary)dealSummaryDao.get()).callBatchTasks(new Callable() {

                    final DeleteObjectsDbPreferenceClickListener this$1;

                    public Object call()
                        throws Exception
                    {
                        ((GrouponOrmLiteHelper)dbHelper.get()).clearTables(new Class[] {
                            com/groupon/db/models/CouponSummary, com/groupon/db/models/CouponDetail, com/groupon/db/models/DealSubsetAttribute, com/groupon/db/models/DealSummary, com/groupon/db/models/CouponCategory, com/groupon/db/models/CouponMerchant, com/groupon/db/models/Pagination, com/groupon/db/models/WidgetSummary
                        });
                        return null;
                    }

            
            {
                this$1 = DeleteObjectsDbPreferenceClickListener.this;
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

        private DeleteObjectsDbPreferenceClickListener()
        {
            this$0 = SecretWidgetsFragment.this;
            super();
        }

    }

    private class DeleteWidgetDbPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final SecretWidgetsFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            try
            {
                ((DaoDealSummary)dealSummaryDao.get()).callBatchTasks(new Callable() {

                    final DeleteWidgetDbPreferenceClickListener this$1;

                    public Object call()
                        throws Exception
                    {
                        ((GrouponOrmLiteHelper)dbHelper.get()).clearTables(new Class[] {
                            com/groupon/db/models/WidgetSummary
                        });
                        return null;
                    }

            
            {
                this$1 = DeleteWidgetDbPreferenceClickListener.this;
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

        private DeleteWidgetDbPreferenceClickListener()
        {
            this$0 = SecretWidgetsFragment.this;
            super();
        }

    }


    public static final String TAG = com/groupon/fragment/SecretSetOnceFlagsFragment.getName();
    private Lazy dbHelper;
    private Lazy dealSummaryDao;

    public SecretWidgetsFragment()
    {
    }

    public void init()
    {
        super.init();
        dealSummaryDao = new Lazy(getActivity()) {

            final SecretWidgetsFragment this$0;

            
            {
                this$0 = SecretWidgetsFragment.this;
                super(context);
            }
        };
        dbHelper = new Lazy(getActivity()) {

            final SecretWidgetsFragment this$0;

            
            {
                this$0 = SecretWidgetsFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getPreferenceScreen().addPreference(generateListPreference("Force widget type", "widgetType", new String[] {
            "None", "Goods", "Deal Details List", "Default"
        }, new String[] {
            "none", "goods", "smallDealCardList", "default"
        }));
        getPreferenceScreen().addPreference(generateListPreference("Preview Widget", "widgetPreview", new String[] {
            "", "true", "false"
        }, new String[] {
            "", "true", "false"
        }));
        getPreferenceScreen().addPreference(generateEditTextPreference("widgetDatetime", "Widget datetime ", "(e.g. 2014-12-05T09:00:00Z)"));
        bundle = new Preference(getActivity());
        bundle.setTitle("Delete Widgets from DB");
        bundle.setOnPreferenceClickListener(new DeleteWidgetDbPreferenceClickListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new Preference(getActivity());
        bundle.setTitle("Delete objects from DB");
        bundle.setSummary("Coupon*, Deal*, Widget*");
        bundle.setOnPreferenceClickListener(new DeleteObjectsDbPreferenceClickListener());
        getPreferenceScreen().addPreference(bundle);
    }



}
