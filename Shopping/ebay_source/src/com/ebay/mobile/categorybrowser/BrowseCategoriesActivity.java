// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesFragment, CategoryViewModel

public final class BrowseCategoriesActivity extends BaseActivity
    implements android.app.FragmentManager.OnBackStackChangedListener, com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.Observer
{

    private String backgroundImageUrl;
    private long categoryId;
    private String categoryName;
    private EbaySite categorySite;
    private com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.KeyParams dataManagerKey;
    private EbayCategory navigationBreadcrumbs[];
    private View progressView;

    public BrowseCategoriesActivity()
    {
    }

    public void onBackPressed()
    {
        DrawerLayout drawerlayout = getNavigationDrawer();
        if (drawerlayout == null || !drawerlayout.isDrawerOpen(3))
        {
            finish();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onBackStackChanged()
    {
        Object obj = getFragmentManager();
        int i = ((FragmentManager) (obj)).getBackStackEntryCount();
        if (i > 0)
        {
            android.app.FragmentManager.BackStackEntry backstackentry = ((FragmentManager) (obj)).getBackStackEntryAt(i - 1);
            if (backstackentry != null && !TextUtils.isEmpty(backstackentry.getName()))
            {
                obj = ((FragmentManager) (obj)).findFragmentByTag(backstackentry.getName());
                if (obj instanceof BrowseCategoriesFragment)
                {
                    TrackingData trackingdata = new TrackingData("Browse", TrackingType.PAGE_IMPRESSION);
                    trackingdata.addKeyValuePair("catlbl", ((BrowseCategoriesFragment)obj).getCategoryLabel());
                    trackingdata.send(this);
                }
            }
        }
    }

    public void onCategoriesChanged(CategoryServiceDataManager categoryservicedatamanager, long l, Content content)
    {
        if (!isFinishing() && !isDestroyed() && l == categoryId && content != null)
        {
            progressView.setVisibility(8);
            Object obj = content.getStatus();
            content = (EbayCategoryNode)content.getData();
            if (((ResultStatus) (obj)).hasError())
            {
                EbayErrorHandler.handleResultStatus(this, 0, ((ResultStatus) (obj)));
                return;
            }
            getDataManagerContainer().delete(dataManagerKey);
            getFragmentManager().popBackStackImmediate(BrowseCategoriesFragment.createFragmentTag(0), 0);
            FragmentManager fragmentmanager = getFragmentManager();
            obj = new BrowseCategoriesFragment();
            Object obj1 = new Bundle();
            ((Bundle) (obj1)).putLong("categoryId", -1L);
            ((Bundle) (obj1)).putString("categoryName", getString(0x7f07053e));
            ((Bundle) (obj1)).putInt("categoryLevel", 0);
            ((Bundle) (obj1)).putParcelable("categorySite", MyApp.getPrefs().getCurrentCountry().site);
            ((Bundle) (obj1)).putParcelableArray("navigationIdPath", new EbayCategory[] {
                new EbayCategory(-1L, getString(0x7f07053e))
            });
            ((Bundle) (obj1)).putString("categoryImageUrl", null);
            ((Fragment) (obj)).setArguments(((Bundle) (obj1)));
            obj1 = BrowseCategoriesFragment.createFragmentTag(0);
            fragmentmanager.beginTransaction().replace(0x7f1000bf, ((Fragment) (obj)), ((String) (obj1))).commit();
            if (content != null && ((EbayCategoryNode) (content)).category != null)
            {
                obj = CategoryViewModel.getCategoryImageUrl(((EbayCategoryNode) (content)).category.id);
            } else
            {
                obj = null;
            }
            while (content != null && ((EbayCategoryNode) (content)).category != null) 
            {
                EbayCategory ebaycategory = ((EbayCategoryNode) (content)).category;
                BrowseCategoriesFragment browsecategoriesfragment = new BrowseCategoriesFragment();
                Bundle bundle = new Bundle();
                bundle.putLong("categoryId", ebaycategory.id);
                bundle.putString("categoryName", ebaycategory.name);
                bundle.putInt("categoryLevel", ebaycategory.level);
                bundle.putParcelableArray("navigationIdPath", BrowseCategoriesFragment.constructNavigationBreadcrumbs(this, ebaycategory));
                Object obj2;
                if (categoryservicedatamanager.getParams().ebaySite == EbaySite.US && ebaycategory.id == 6000L)
                {
                    obj2 = EbaySite.MOTOR;
                } else
                {
                    obj2 = categoryservicedatamanager.getParams().ebaySite;
                }
                bundle.putParcelable("categorySite", ((android.os.Parcelable) (obj2)));
                bundle.putString("categoryImageUrl", ((String) (obj)));
                browsecategoriesfragment.setArguments(bundle);
                obj2 = BrowseCategoriesFragment.createFragmentTag(ebaycategory.level);
                fragmentmanager.beginTransaction().addToBackStack(((String) (obj2))).replace(0x7f1000bf, browsecategoriesfragment, ((String) (obj2))).commit();
                if (((EbayCategoryNode) (content)).children.length > 0)
                {
                    content = ((EbayCategoryNode) (content)).children[0];
                } else
                {
                    content = null;
                }
            }
        }
    }

    public void onCategoriesLoading(CategoryServiceDataManager categoryservicedatamanager, long l)
    {
        if (l == categoryId)
        {
            progressView.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        android.os.Parcelable aparcelable[];
        Intent intent;
        super.onCreate(bundle);
        setContentView(0x7f030022);
        intent = getIntent();
        aparcelable = null;
        if (intent == null) goto _L2; else goto _L1
_L1:
        categoryId = intent.getLongExtra("categoryId", -1L);
        categoryName = intent.getStringExtra("categoryName");
        aparcelable = intent.getParcelableArrayExtra("navigationIdPath");
        backgroundImageUrl = intent.getStringExtra("categoryImageUrl");
        categorySite = (EbaySite)intent.getParcelableExtra("categorySite");
_L4:
        if (aparcelable != null)
        {
            navigationBreadcrumbs = new EbayCategory[aparcelable.length];
            for (int i = 0; i < navigationBreadcrumbs.length; i++)
            {
                navigationBreadcrumbs[i] = (EbayCategory)aparcelable[i];
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (bundle != null)
        {
            categoryId = bundle.getLong("categoryId", -1L);
            categoryName = bundle.getString("categoryName");
            aparcelable = bundle.getParcelableArray("navigationIdPath");
            backgroundImageUrl = bundle.getString("categoryImageUrl");
            categorySite = (EbaySite)bundle.getParcelable("categorySite");
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (TextUtils.isEmpty(categoryName))
        {
            categoryName = getString(0x7f07053e);
        }
        progressView = findViewById(0x7f1000c0);
        if (categoryId == -1L)
        {
            String s = BrowseCategoriesFragment.createFragmentTag(0);
            Fragment fragment = getFragmentManager().findFragmentByTag(s);
            bundle = fragment;
            if (fragment == null)
            {
                bundle = new BrowseCategoriesFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putLong("categoryId", categoryId);
                bundle1.putString("categoryName", categoryName);
                bundle1.putParcelableArray("navigationIdPath", navigationBreadcrumbs);
                bundle1.putString("categoryImageUrl", backgroundImageUrl);
                if (categorySite != null)
                {
                    bundle1.putParcelable("categorySite", categorySite);
                }
                bundle.setArguments(bundle1);
            }
            getFragmentManager().beginTransaction().replace(0x7f1000bf, bundle, s).commit();
        }
        return;
    }

    public void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (categoryId != -1L && getFragmentManager().getBackStackEntryCount() < 1)
        {
            Object obj = MyApp.getPrefs().getCurrentCountry();
            if (categorySite != null)
            {
                obj = categorySite;
            } else
            {
                obj = ((EbayCountry) (obj)).site;
            }
            dataManagerKey = new com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.KeyParams(((EbaySite) (obj)));
            ((CategoryServiceDataManager)datamanagercontainer.initialize(dataManagerKey, this)).getPathToCategory(categoryId, this);
        }
    }

    public void onPause()
    {
        getFragmentManager().removeOnBackStackChangedListener(this);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        getFragmentManager().addOnBackStackChangedListener(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putLong("categoryId", categoryId);
        bundle.putString("categoryName", categoryName);
        bundle.putParcelableArray("navigationIdPath", navigationBreadcrumbs);
        bundle.putString("categoryImageUrl", backgroundImageUrl);
    }
}
