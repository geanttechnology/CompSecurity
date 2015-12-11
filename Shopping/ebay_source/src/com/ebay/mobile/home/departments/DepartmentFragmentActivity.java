// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.categorybrowser.BrowseCategoriesActivity;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.mobile.home.channels.ChannelObserver;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.kernel.util.NumberUtil;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

public class DepartmentFragmentActivity extends BaseActivity
    implements ChannelObserver
{

    public static final String EXTRA_BACKGROUND_URL = "backgroundUrl";
    public static final String EXTRA_DEPARTMENT_ID = "departmentId";
    public static final String EXTRA_DEPARTMENT_TITLE = "departmentTitle";
    public static final String EXTRA_IS_DEPARTMENT = "isDepartment";
    public static final String EXTRA_PARENT_DEPARTMENT_ID = "parentDepartmentId";
    private String backgroundUrl;
    private String departmentId;
    private String departmentTitle;
    private boolean isDepartment;
    private String parentDepartmentId;

    public DepartmentFragmentActivity()
    {
    }

    private void sendTracking()
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("dept", parentDepartmentId, true);
        trackingdata.addKeyValuePair("subdept", departmentId, true);
        trackingdata.addSourceIdentification(getIntent());
        trackingdata.send(this);
    }

    public String getTrackingEventName()
    {
        return "SubDepartment";
    }

    public void onCategoryExpansion(ChannelFragment channelfragment, float f)
    {
    }

    public void onCategorySelected(ChannelFragment channelfragment, Category category)
    {
        if (category != null)
        {
            Long long1 = NumberUtil.safeParseLong(category.id);
            if (category.name == null)
            {
                channelfragment = null;
            } else
            {
                channelfragment = category.name.content;
            }
            if (long1 != null && !TextUtils.isEmpty(channelfragment))
            {
                if (com.ebay.nautilus.domain.data.UnifiedStream.Category.Destination.SRP.equals(category.destination))
                {
                    category = eBayDictionaryProvider.getLockedSearchParameters(this, null);
                    category.category = new EbayCategorySummary(long1.longValue(), channelfragment);
                    ActivityStarter.startSearchResultList(this, category, null);
                    return;
                }
                category = new Intent(this, com/ebay/mobile/categorybrowser/BrowseCategoriesActivity);
                category.putExtra("categoryId", long1);
                category.putExtra("categoryName", channelfragment);
                if (TextUtils.equals(parentDepartmentId, "Motors"))
                {
                    category.putExtra("categorySite", EbaySite.MOTOR);
                }
                category.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "browsecat", TrackingData.sanitize(departmentId)));
                startActivity(category);
                return;
            }
        }
    }

    public void onContentLoaded(ChannelFragment channelfragment)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        departmentId = bundle.getString("departmentId");
        departmentTitle = bundle.getString("departmentTitle");
        backgroundUrl = bundle.getString("backgroundUrl");
        isDepartment = bundle.getBoolean("isDepartment");
        parentDepartmentId = bundle.getString("parentDepartmentId");
_L4:
        setContentView(0x7f030125);
        bundle = DepartmentFragment.create(departmentId, departmentTitle, backgroundUrl, isDepartment, -1);
        getFragmentManager().beginTransaction().add(0x7f1000cb, bundle, departmentId).commit();
        return;
_L2:
        bundle = getIntent();
        if (bundle != null)
        {
            departmentId = bundle.getStringExtra("departmentId");
            departmentTitle = bundle.getStringExtra("departmentTitle");
            backgroundUrl = bundle.getStringExtra("backgroundUrl");
            isDepartment = bundle.getBooleanExtra("isDepartment", false);
            parentDepartmentId = bundle.getStringExtra("parentDepartmentId");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        departmentId = bundle.getString("departmentId");
        departmentTitle = bundle.getString("departmentTitle");
        backgroundUrl = bundle.getString("backgroundUrl");
        isDepartment = bundle.getBoolean("isDepartment", false);
        parentDepartmentId = bundle.getString("parentDepartmentId");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("departmentId", departmentId);
        bundle.putString("departmentTitle", departmentTitle);
        bundle.putString("backgroundUrl", backgroundUrl);
        bundle.putBoolean("isDepartment", isDepartment);
        bundle.putString("parentDepartmentId", parentDepartmentId);
    }

    public void onScrollChanged(ChannelFragment channelfragment, int i, int j)
    {
    }

    public void onStart()
    {
        super.onStart();
        sendTracking();
    }
}
