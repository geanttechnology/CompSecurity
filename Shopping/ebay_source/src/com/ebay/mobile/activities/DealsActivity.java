// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.EbayDeals;
import com.ebay.common.util.ImageCache;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.deals.GetDealsLoader;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseListActivity, DealsItem, DealsWebViewActivity, DealsAdapter

public final class DealsActivity extends BaseListActivity
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener
{

    public static final String CATEGORY_NAME = "in_category";
    public static final String CURRENT_POSITION_Y = "currentPositionY";
    private static final String EXTRA_MSKU_ITEM = com/ebay/mobile/activities/DealsItem.getName();
    public static final String EXTRA_MSKU_ITEM_TITLE = "mskuItemTitle";
    private static final int MSKU_DIALOG_ID = 1;
    public static String upToString;
    private String categoryName;
    private int colorShippingFree;
    private int colorTextDefault;
    private int currentPositionY;
    private EbayDeals deals;
    private String freeShipping;
    private boolean icsCrashHackIgnoreBack;
    private ImageCache imageCache;
    private TextView messageView;
    private DealsItem mskuItem;
    private View progressView;

    public DealsActivity()
    {
        deals = null;
        mskuItem = null;
    }

    private void addCategoryDeals(com.ebay.common.model.EbayDeals.Section section, com.ebay.common.model.EbayDeals.SubSection subsection, Resources resources, List list)
    {
        for (section = subsection.iterator(); section.hasNext(); addItem(list, (com.ebay.common.model.EbayDeals.Item)section.next(), resources, freeShipping, colorTextDefault, colorShippingFree)) { }
    }

    private void addItem(List list, com.ebay.common.model.EbayDeals.Item item, Resources resources, String s, int i, int j)
    {
        double d;
        com.ebay.common.model.EbayDeals.Item item1;
        Resources resources1;
        String s1;
        com.ebay.common.model.EbayDeals.Item item2;
        com.ebay.common.model.EbayDeals.Item item3;
        Resources resources2;
        Object obj1;
        int k;
        long l = item.id;
        String s3 = item.title;
        String s4 = item.imageUrl;
        String s5 = item.energyRating;
        resources2 = null;
        item1 = null;
        item3 = null;
        s1 = null;
        obj1 = null;
        k = i;
        Object obj;
        if (item instanceof com.ebay.common.model.EbayDeals.MultiSkuItem)
        {
            obj = (com.ebay.common.model.EbayDeals.MultiSkuItem)item;
            if (((com.ebay.common.model.EbayDeals.MultiSkuItem) (obj)).items == null || ((com.ebay.common.model.EbayDeals.MultiSkuItem) (obj)).items.isEmpty())
            {
                return;
            }
            item = (com.ebay.common.model.EbayDeals.Item)((com.ebay.common.model.EbayDeals.MultiSkuItem) (obj)).items.get(0);
            if (((com.ebay.common.model.EbayDeals.MultiSkuItem) (obj)).items.size() == 1)
            {
                addItem(list, item, resources, s, i, j);
                return;
            }
            ArrayList arraylist = new ArrayList();
            Iterator iterator = ((com.ebay.common.model.EbayDeals.MultiSkuItem) (obj)).items.iterator();
            do
            {
                item2 = item;
                obj = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                addItem(((List) (arraylist)), (com.ebay.common.model.EbayDeals.Item)iterator.next(), resources, s, i, j);
            } while (true);
        } else
        {
            obj = null;
            item2 = item;
        }
        String s2;
        if (item2.savingsRate > 0)
        {
            s2 = resources.getString(0x7f07094e, new Object[] {
                Integer.valueOf(item2.savingsRate)
            });
        } else
        {
            s2 = null;
        }
        item = item1;
        item1 = resources2;
        resources1 = item3;
        if (isEmpty(item2.convertedCurrentPrice))
        {
            break MISSING_BLOCK_LABEL_269;
        }
        item1 = resources2;
        resources1 = item3;
        item = formatCurrency(Double.parseDouble(item2.convertedCurrentPrice.value), item2.convertedCurrentPrice.code);
        resources = s1;
        item1 = item;
        resources1 = item3;
        if (item2.savingsRate <= 0)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        resources = s1;
        item1 = item;
        resources1 = item3;
        if (isEmpty(item2.origRetailPrice))
        {
            break MISSING_BLOCK_LABEL_366;
        }
        resources = s1;
        item1 = item;
        resources1 = item3;
        if (item2.origRetailPrice.equals(item2.convertedCurrentPrice))
        {
            break MISSING_BLOCK_LABEL_366;
        }
        item1 = item;
        resources1 = item3;
        resources = formatCurrency(Double.parseDouble(item2.origRetailPrice.value), item2.origRetailPrice.code);
        item3 = item;
        resources2 = resources;
        s1 = obj1;
        i = k;
        item1 = item;
        resources1 = resources;
        if (isEmpty(item2.shippingCost)) goto _L2; else goto _L1
_L1:
        item1 = item;
        resources1 = resources;
        d = Double.parseDouble(item2.shippingCost.value);
        if (d >= 0.01D) goto _L4; else goto _L3
_L3:
        i = j;
        s1 = s;
        resources2 = resources;
        item3 = item;
_L2:
        list.add(new DealsItem(l, s3, s4, s2, item3, item2.origRetailPrice, item2.savingsRate, resources2, s1, i, ((List) (obj)), s5));
        return;
_L4:
        item1 = item;
        resources1 = resources;
        s1 = formatCurrency(d, item2.shippingCost.code);
        item3 = item;
        resources2 = resources;
        i = k;
        continue; /* Loop/switch isn't completed */
        item;
        item.printStackTrace();
        item3 = item1;
        resources2 = resources1;
        s1 = obj1;
        i = k;
        if (true) goto _L2; else goto _L5
_L5:
    }

    private String formatCurrency(double d, String s)
    {
        return EbayCurrencyUtil.formatDisplay(s, d, 0);
    }

    public static Intent getStartingIntent(Activity activity, Authentication authentication)
    {
        Object obj1 = null;
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        DeviceConfiguration deviceconfiguration = dcshelper.getConfig();
        Object obj = obj1;
        if (activity != null)
        {
            obj = obj1;
            if (deviceconfiguration.get(DcsBoolean.Deals))
            {
                if (TextUtils.isEmpty(dcshelper.dealsUrl()))
                {
                    obj = new Intent(activity, com/ebay/mobile/activities/DealsActivity);
                } else
                {
                    activity = new Intent(activity, com/ebay/mobile/activities/DealsWebViewActivity);
                    obj = activity;
                    if (authentication != null)
                    {
                        authentication = deviceconfiguration.get(DcsString.DealsUrlScope);
                        obj = activity;
                        if (!TextUtils.isEmpty(authentication))
                        {
                            activity.putExtra("use_sso", true);
                            activity.putExtra(DealsWebViewActivity.EXTRA_SCOPE, authentication);
                            return activity;
                        }
                    }
                }
            }
        }
        return ((Intent) (obj));
    }

    private boolean isEmpty(ItemCurrency itemcurrency)
    {
        return ItemCurrency.isEmpty(itemcurrency);
    }

    private void refresh(boolean flag)
    {
        getFwLoaderManager().cancelLoader(0, true);
        deals = null;
        Object obj = MyApp.getPrefs().getCurrentCountry();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.Deals))
        {
            obj = new GetDealsLoader(getEbayContext(), getCacheDir(), flag, ((EbayCountry) (obj)).site);
            getFwLoaderManager().start(0, ((FwLoader) (obj)), false);
        } else
        {
            obj = EbayCountryManager.getCountryWithLanguageName(getResources(), ((EbayCountry) (obj)));
            messageView.setText(getString(0x7f070138, new Object[] {
                obj
            }));
            progressView.setVisibility(8);
            messageView.setVisibility(0);
        }
        setListAdapter(null);
    }

    private void set(EbayDeals ebaydeals, boolean flag)
    {
        Resources resources;
        ArrayList arraylist;
        Iterator iterator;
        boolean flag3;
        boolean flag5;
        getSupportActionBar().setSubtitle(null);
        resources = getResources();
        flag3 = true;
        arraylist = new ArrayList();
        if (ebaydeals == null)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        flag5 = true;
        iterator = ebaydeals.iterator();
_L2:
        com.ebay.common.model.EbayDeals.Section section;
        Iterator iterator2;
        boolean flag1;
        boolean flag2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_253;
        }
        section = (com.ebay.common.model.EbayDeals.Section)iterator.next();
        iterator2 = section.iterator();
        flag2 = flag3;
        flag1 = flag5;
_L3:
        flag5 = flag1;
        flag3 = flag2;
        if (!iterator2.hasNext()) goto _L2; else goto _L1
_L1:
        com.ebay.common.model.EbayDeals.SubSection subsection = (com.ebay.common.model.EbayDeals.SubSection)iterator2.next();
        if (flag1 || flag)
        {
            if (TextUtils.isEmpty(subsection.title))
            {
                ebaydeals = section.title;
            } else
            {
                ebaydeals = subsection.title;
            }
            arraylist.add(new DealsItem(ebaydeals, true));
            addCategoryDeals(section, subsection, resources, arraylist);
            flag1 = false;
        } else
        {
            boolean flag4 = flag2;
            if (flag2)
            {
                arraylist.add(new DealsItem(getString(0x7f07053a), true));
                flag4 = false;
            }
            if (TextUtils.isEmpty(subsection.title))
            {
                ebaydeals = section.title;
            } else
            {
                ebaydeals = subsection.title;
            }
            arraylist.add(new DealsItem(ebaydeals, false));
            flag2 = flag4;
        }
          goto _L3
        if (!flag)
        {
            arraylist.add(new DealsItem(getString(0x7f07051a), false));
        }
        String s = getIntent().getStringExtra("mskuItemTitle");
        if (s != null)
        {
            Object obj = null;
            Iterator iterator1 = arraylist.iterator();
            do
            {
                ebaydeals = obj;
                if (!iterator1.hasNext())
                {
                    break;
                }
                ebaydeals = (DealsItem)iterator1.next();
            } while (((DealsItem) (ebaydeals)).msku == null || !s.equals(((DealsItem) (ebaydeals)).title));
            if (ebaydeals != null)
            {
                arraylist.clear();
                arraylist.addAll(((DealsItem) (ebaydeals)).msku);
                getSupportActionBar().setSubtitle(s);
            }
        }
        setListAdapter(new DealsAdapter(this, imageCache, arraylist));
        getListView().setSelectionFromTop(currentPositionY, 0);
        if (!flag)
        {
            currentPositionY = 0;
        }
        return;
          goto _L3
    }

    private void setDeals()
    {
        if (categoryName == null)
        {
            set(deals, false);
            return;
        }
        if (categoryName.equals(getString(0x7f07051a)))
        {
            set(deals, true);
            return;
        } else
        {
            showCategoryDeals(categoryName);
            return;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (icsCrashHackIgnoreBack)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public String getTrackingEventName()
    {
        return "Deals";
    }

    public void onBackPressed()
    {
        if (categoryName != null)
        {
            categoryName = null;
            set(deals, false);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        mskuItem = null;
        removeDialog(1);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -3)
        {
            dialoginterface.cancel();
        } else
        if (mskuItem != null)
        {
            dialoginterface = mskuItem;
            mskuItem = null;
            dialoginterface = (DealsItem)((DealsItem) (dialoginterface)).msku.get(i);
            removeDialog(1);
            ItemViewActivity.StartActivityDealItem(this, ((DealsItem) (dialoginterface)).id, ((DealsItem) (dialoginterface)).orp, ((DealsItem) (dialoginterface)).savingsRate);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030084);
        imageCache = new ImageCache(this, MyApp.getDeviceConfiguration().getGalleryImageHost());
        progressView = findViewById(0x7f100143);
        progressView.setVisibility(8);
        messageView = (TextView)findViewById(0x7f100164);
        colorTextDefault = getResources().getColor(0x106000c);
        colorShippingFree = getResources().getColor(0x7f0d0065);
        freeShipping = getResources().getString(0x7f070422);
        upToString = getResources().getString(0x7f070b93);
        if (bundle != null)
        {
            mskuItem = (DealsItem)bundle.getParcelable(EXTRA_MSKU_ITEM);
            categoryName = bundle.getString("in_category");
            currentPositionY = bundle.getInt("currentPositionY");
        }
        initDataManagers();
        bundle = ((Bundle) (getLastFwNonConfigurationInstance()));
        if (bundle == null)
        {
            refresh(false);
        } else
        {
            deals = (EbayDeals)bundle;
            setDeals();
        }
        if (MyApp.getPrefs().getCurrentCountry().getSiteId() == 77)
        {
            setTitle(getString(0x7f070cf0));
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        DealsItem dealsitem = mskuItem;
        if (i == 1 && dealsitem != null)
        {
            DealsAdapter dealsadapter = new DealsAdapter(this, imageCache, dealsitem.msku);
            return (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(dealsitem.title).setAdapter(dealsadapter, this).setNeutralButton(0x1040000, this).setOnCancelListener(this).create();
        } else
        {
            return super.onCreateDialog(i);
        }
    }

    protected void onDestroy()
    {
        imageCache.clearImageFetching();
        super.onDestroy();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        view = (DealsItem)((DealsAdapter)getListAdapter()).getItem(i);
        switch (((DealsItem) (view)).type)
        {
        default:
            return;

        case 1: // '\001'
            currentPositionY = listview.getFirstVisiblePosition();
            categoryName = ((DealsItem) (view)).title;
            if (((DealsItem) (view)).title.equals(getString(0x7f07051a)))
            {
                set(deals, true);
                return;
            } else
            {
                showCategoryDeals(categoryName);
                return;
            }

        case 0: // '\0'
            break;
        }
        if (((DealsItem) (view)).msku == null)
        {
            icsCrashHackIgnoreBack = true;
            ItemViewActivity.StartActivityDealItem(this, ((DealsItem) (view)).id, ((DealsItem) (view)).orp, ((DealsItem) (view)).savingsRate);
            return;
        } else
        {
            mskuItem = view;
            showDialog(1);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (categoryName != null)
        {
            categoryName = null;
            set(deals, false);
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onResume()
    {
        super.onResume();
        icsCrashHackIgnoreBack = false;
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("site", Integer.toString(MyApp.getPrefs().getCurrentCountry().getSiteId()));
        trackingdata.send(this);
    }

    public Object onRetainFwNonConfigurationInstance()
    {
        return deals;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mskuItem != null)
        {
            bundle.putParcelable(EXTRA_MSKU_ITEM, mskuItem);
        }
        bundle.putString("in_category", categoryName);
        bundle.putInt("currentPositionY", currentPositionY);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        if (isFinishing())
        {
            return;
        }
        fwloader = (GetDealsLoader)fwloader;
        if (fwloader.isError())
        {
            messageView.setText(0x7f07024c);
            messageView.setVisibility(0);
        } else
        {
            deals = ((GetDealsLoader) (fwloader)).deals;
            setDeals();
        }
        progressView.setVisibility(8);
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
        super.onTaskStarted(i, fwloader);
        progressView.setVisibility(0);
        messageView.setVisibility(8);
    }

    public void showCategoryDeals(String s)
    {
        getSupportActionBar().setSubtitle(s);
        Resources resources = getResources();
        ArrayList arraylist = new ArrayList();
        if (deals != null)
        {
            for (Iterator iterator = deals.iterator(); iterator.hasNext();)
            {
                com.ebay.common.model.EbayDeals.Section section = (com.ebay.common.model.EbayDeals.Section)iterator.next();
                Iterator iterator1 = section.iterator();
                while (iterator1.hasNext()) 
                {
                    com.ebay.common.model.EbayDeals.SubSection subsection = (com.ebay.common.model.EbayDeals.SubSection)iterator1.next();
                    if (section.title.equals(s) || subsection.title != null && subsection.title.equals(s))
                    {
                        addCategoryDeals(section, subsection, resources, arraylist);
                    }
                }
            }

        }
        s = new DealsAdapter(this, imageCache, arraylist);
        setListAdapter(s);
        s.notifyDataSetChanged();
    }

}
