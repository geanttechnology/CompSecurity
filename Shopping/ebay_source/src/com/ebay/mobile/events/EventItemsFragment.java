// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.common.RefineContentFragment;
import com.ebay.mobile.common.SimpleRefineFragment;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.dm.EventDetailsDataManager;
import com.ebay.nautilus.domain.content.dm.EventItemsDataManager;
import com.ebay.nautilus.domain.data.cos.base.DateTime;
import com.ebay.nautilus.domain.data.cos.base.Property;
import com.ebay.nautilus.domain.data.cos.base.PropertyValue;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.events:
//            EventRefineFragment, EventItemsAdapter, EventTimeLeftHelper

public class EventItemsFragment extends RefineContentFragment
    implements android.support.v4.widget.DrawerLayout.DrawerListener, android.view.View.OnClickListener, com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.OnRequestMoreListener, com.ebay.nautilus.domain.content.dm.EventDetailsDataManager.Observer, com.ebay.nautilus.domain.content.dm.EventItemsDataManager.Observer
{

    public static final String DISPLAY_NAME = "DisplayName";
    public static final String HERO_IMAGE = "HeroImage";
    private EventItemsAdapter adapter;
    private String coverImageUrl;
    private String endsInText;
    private String eventDepartment;
    private EventDetailsDataManager eventDetailsDataManager;
    private String eventId;
    private EventItemsDataManager eventItemsDataManager;
    private String eventSeoName;
    private String eventTitle;
    private boolean isLandscape;
    private boolean isLoaded;
    private boolean isRefinePanelLoaded;
    private boolean isTablet;
    private int lastPageIndexRequested;
    private View progressView;
    private RecyclerView recyclerView;
    private String shareUrl;

    public EventItemsFragment()
    {
    }

    private int getNumGridSpans()
    {
        if (isTablet)
        {
            return !isLandscape ? 3 : 4;
        } else
        {
            return 2;
        }
    }

    private Object getPropertyValue(String s, List list, Class class1)
    {
label0:
        {
            if (TextUtils.isEmpty(s) || list == null)
            {
                break label0;
            }
            list = list.iterator();
            Object obj;
            do
            {
                do
                {
                    do
                    {
                        if (!list.hasNext())
                        {
                            break label0;
                        }
                        obj = (Property)list.next();
                    } while (!s.equalsIgnoreCase(((Property) (obj)).propertyName));
                    obj = ((Property) (obj)).propertyValues;
                } while (obj == null || ((List) (obj)).isEmpty());
                obj = (PropertyValue)((List) (obj)).get(0);
            } while (obj == null);
            s = null;
            if (class1.isAssignableFrom(java/lang/String))
            {
                s = ((PropertyValue) (obj)).stringValue;
            }
            return class1.cast(s);
        }
        return null;
    }

    private void initializeRefinements()
    {
        if (refineFragment instanceof EventRefineFragment)
        {
            ((EventRefineFragment)refineFragment).setDefaultCategories(eventItemsDataManager.getCategories(), eventItemsDataManager.getSortOptions());
        }
    }

    private void loadEventItems()
    {
        if (!TextUtils.isEmpty(eventId))
        {
            com.ebay.nautilus.domain.content.dm.EventItemsDataManager.KeyParams keyparams = new com.ebay.nautilus.domain.content.dm.EventItemsDataManager.KeyParams(eventId);
            eventItemsDataManager = (EventItemsDataManager)getDataManagerContainer().initialize(keyparams, this);
            if (!isLoaded)
            {
                eventItemsDataManager.loadPage(1, this);
            }
        }
    }

    private void resetView()
    {
        if (adapter != null)
        {
            adapter.clear();
        }
        isLoaded = false;
        lastPageIndexRequested = 0;
    }

    private void setCategoryChange(EventRefineFragment.CategoryRefinement categoryrefinement)
    {
        showProgress(true);
        resetView();
        eventItemsDataManager.addCategoryFilter(categoryrefinement.refinementCategory);
        eventItemsDataManager.forceReloadData();
    }

    private void setHeaderInfo()
    {
        if (adapter != null)
        {
            adapter.headerInfo.eventBannerImageUrl = coverImageUrl;
            adapter.headerInfo.endsInText = endsInText;
            adapter.headerInfo.shareUrl = shareUrl;
        }
    }

    private void setPriceRangeChange(EventRefineFragment.PriceRefinement pricerefinement)
    {
        showProgress(true);
        resetView();
        if (pricerefinement.getTitle().equals(getString(0x7f0703e2)))
        {
            eventItemsDataManager.setMinPrice(pricerefinement.price);
        } else
        {
            eventItemsDataManager.setMaxPrice(pricerefinement.price);
        }
        eventItemsDataManager.forceReloadData();
    }

    private void setSortRefinementChange(EventRefineFragment.SortRefinement sortrefinement)
    {
        resetView();
        eventItemsDataManager.setSortOrder(sortrefinement.sortOption);
        eventItemsDataManager.forceReloadData();
    }

    private void showProgress(boolean flag)
    {
        byte byte0 = 8;
        Object obj = progressView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = recyclerView;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((RecyclerView) (obj)).setVisibility(i);
    }

    protected String getTitleText(Resources resources)
    {
        return getString(0x7f0703dd);
    }

    protected boolean hasCustomLayoutHandling()
    {
        return true;
    }

    protected void initAdapter()
    {
        if (adapter != null)
        {
            adapter.setOnRequestMoreListener(null);
        }
        adapter = new EventItemsAdapter(getActivity(), 0x7f03009b, 0x7f10005f);
        adapter.setOnRequestMoreListener(this);
        adapter.setEmptyViewResource(0x7f03016c);
        adapter.setLoadingViewResource(0x7f03016e);
        adapter.setOnClickListener(this);
        setHeaderInfo();
        adapter.setHeaderViewResource(0x7f03009d);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131755240: 49
    //                   2131755310: 84
    //                   2131755416: 49
    //                   2131755417: 54;
           goto _L1 _L2 _L3 _L2 _L4
_L1:
        return;
_L2:
        openRefinePanel();
        return;
_L4:
        view = NumberUtil.safeParseLong(view.getTag().toString());
        if (view != null)
        {
            ItemViewActivity.StartActivity(getActivity(), view.longValue(), com.ebay.common.ConstantsCommon.ItemKind.Unknown);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (shareUrl != null && !TextUtils.isEmpty(shareUrl))
        {
            view = new Intent("android.intent.action.SEND");
            view.setType("text/plain");
            Resources resources = getResources();
            String s = resources.getString(0x7f070282);
            view.putExtra("android.intent.extra.SUBJECT", s);
            view.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s).append(" ").append(shareUrl).toString());
            startActivity(Intent.createChooser(view, resources.getString(0x7f0704ef)));
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            eventId = bundle.getString("eventId");
            eventTitle = bundle.getString("eventTitle");
            coverImageUrl = bundle.getString("coverImageUrl");
            endsInText = bundle.getString("endsText");
            shareUrl = bundle.getString("shareUrl");
        }
        initDataManagers();
    }

    public View onCreateCustomView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = onCreateMainContentView(layoutinflater, viewgroup, bundle);
        drawerLayout = (DrawerLayout)layoutinflater.inflate(0x7f03009e, viewgroup, false);
        drawerLayout.setDrawerListener(this);
        ((FrameLayout)drawerLayout.findViewById(0x7f1001a3)).addView(view);
        refineFragment = (EventRefineFragment)getFragmentManager().findFragmentById(0x7f1001a4);
        refineFragment.setSimpleRefineCallback(this);
        if (bundle != null && bundle.getBoolean("drawerOpen", false))
        {
            openRefinePanel();
        }
        return drawerLayout;
    }

    public View onCreateMainContentView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        boolean flag = false;
        viewgroup = new LinearLayout(getActivity());
        isLoaded = false;
        isRefinePanelLoaded = false;
        isTablet = getResources().getBoolean(0x7f0b0006);
        if (!DeviceInfoUtil.isPortrait(getActivity()))
        {
            flag = true;
        }
        isLandscape = flag;
        layoutinflater = layoutinflater.inflate(0x7f03009c, viewgroup, true);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x102000a);
        refineButton = layoutinflater.findViewById(0x7f1000e8);
        progressView = layoutinflater.findViewById(0x7f1000ca);
        showProgress(true);
        layoutinflater = new GridLayoutManager(getActivity(), getNumGridSpans());
        layoutinflater.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

            final EventItemsFragment this$0;

            public int getSpanSize(int i)
            {
                switch (adapter.getItemViewType(i))
                {
                default:
                    return 1;

                case 1: // '\001'
                    return getNumGridSpans();
                }
            }

            
            {
                this$0 = EventItemsFragment.this;
                super();
            }
        });
        recyclerView.setLayoutManager(layoutinflater);
        return viewgroup;
    }

    public void onDestroyView()
    {
        refineFragment = null;
        super.onDestroyView();
    }

    public void onDrawerClosed(View view)
    {
        Util.hideSoftInput(getActivity(), getView());
        isRefinePanelLoaded = false;
    }

    public void onDrawerOpened(View view)
    {
        if (!isRefinePanelLoaded && (refineFragment instanceof EventRefineFragment))
        {
            ((EventRefineFragment)refineFragment).populateAdapter();
        }
    }

    public void onDrawerSlide(View view, float f)
    {
    }

    public void onDrawerStateChanged(int i)
    {
    }

    public void onEventDetailsLoaded(EventDetailsDataManager eventdetailsdatamanager, com.ebay.nautilus.domain.net.api.events.EventDetailsResponse.EventDetails eventdetails)
    {
        if (eventdetails != null && !TextUtils.isEmpty(eventdetails.eventId))
        {
            eventId = eventdetails.eventId;
            coverImageUrl = (String)getPropertyValue("HeroImage", eventdetails.properties, java/lang/String);
            eventTitle = (String)getPropertyValue("DisplayName", eventdetails.properties, java/lang/String);
            shareUrl = eventdetails.url;
            eventdetailsdatamanager = getResources();
            eventdetails = EventTimeLeftHelper.getEndsInTimeMaxUnitString(eventdetailsdatamanager, EventTimeLeftHelper.getRemainingDuration(eventdetails.endingDate.value), true);
            endsInText = String.format(eventdetailsdatamanager.getString(0x7f0701f4), new Object[] {
                eventdetails
            });
            setHeaderInfo();
            loadEventItems();
        } else
        {
            eventdetailsdatamanager = getActivity();
            if (eventdetailsdatamanager != null)
            {
                eventdetails = new Intent(eventdetailsdatamanager, com/ebay/mobile/activities/eBay);
                eventdetails.setFlags(0x4000000);
                eventdetailsdatamanager.startActivity(eventdetails);
                eventdetailsdatamanager.finish();
                return;
            }
        }
    }

    public void onEventListContentChanged(EventItemsDataManager eventitemsdatamanager, ListContent listcontent)
    {
        eventitemsdatamanager = listcontent.getStatus();
        if (eventitemsdatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, eventitemsdatamanager);
        } else
        {
            eventitemsdatamanager = listcontent.getList();
            int i;
            int k;
            int l;
            if (eventitemsdatamanager != null && !eventitemsdatamanager.isEmpty())
            {
                i = listcontent.getTotalItemCount();
            } else
            {
                i = 0;
            }
            k = listcontent.getUnfilteredItemsLoaded();
            l = listcontent.getPagesLoaded();
            if (l >= lastPageIndexRequested)
            {
                EventItemsAdapter eventitemsadapter = adapter;
                String s = eventTitle;
                int j;
                if (!listcontent.getStatus().hasError())
                {
                    j = EventItemsDataManager.MAX_ENTRIES_PER_PAGE;
                } else
                {
                    j = -1;
                }
                eventitemsdatamanager = eventitemsadapter.newSection(0, s, eventitemsdatamanager, i, k, -1, l, j);
                if (adapter.getListCount() == 0)
                {
                    adapter.add(eventitemsdatamanager);
                } else
                {
                    adapter.setList(0, eventitemsdatamanager);
                }
                initializeRefinements();
                isLoaded = true;
                showProgress(false);
                return;
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        if (!TextUtils.isEmpty(eventId))
        {
            loadEventItems();
        } else
        if (!TextUtils.isEmpty(eventSeoName))
        {
            eventDetailsDataManager = (EventDetailsDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.EventDetailsDataManager.KeyParams(eventSeoName), this);
            eventDetailsDataManager.loadData();
            return;
        }
    }

    public void onRefinementSelected(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement)
    {
        if (!(refinement instanceof EventRefineFragment.PriceRefinement)) goto _L2; else goto _L1
_L1:
        setPriceRangeChange((EventRefineFragment.PriceRefinement)refinement);
_L4:
        return;
_L2:
        if (!(refinement instanceof EventRefineFragment.EventRefinement))
        {
            continue; /* Loop/switch isn't completed */
        }
        refinement = (EventRefineFragment.EventRefinement)refinement;
        if (!refinement.isTopLevelRefinement() || ((EventRefineFragment.EventRefinement) (refinement)).refinementType != EventRefineFragment.RefinementType.CATEGORY_FILTER)
        {
            break; /* Loop/switch isn't completed */
        }
        if (refineFragment instanceof EventRefineFragment)
        {
            ((EventRefineFragment)refineFragment).addRefinementCategories(eventItemsDataManager.getCategories());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (refinement instanceof EventRefineFragment.CategoryRefinement)
        {
            setCategoryChange((EventRefineFragment.CategoryRefinement)refinement);
            return;
        }
        if (refinement instanceof EventRefineFragment.SortRefinement)
        {
            setSortRefinementChange((EventRefineFragment.SortRefinement)refinement);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        lastPageIndexRequested = j;
        eventItemsDataManager.loadPage(j, this);
    }

    public void onResetPressed(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement, com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement1)
    {
        resetView();
        eventItemsDataManager.resetAllSortAndFilter();
        if (refineFragment instanceof EventRefineFragment)
        {
            refinement = (EventRefineFragment)refineFragment;
            refinement1 = eventItemsDataManager.getCategories();
            if (refinement1 != null && refinement1.size() > 0)
            {
                refinement.setDefaultRefinements((com.ebay.nautilus.domain.data.Event.Category)refinement1.get(0));
            }
        }
        eventItemsDataManager.forceReloadData();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("eventId", eventId);
        bundle.putString("eventSeoName", eventSeoName);
        bundle.putString("eventTitle", eventTitle);
        bundle.putString("coverImageUrl", coverImageUrl);
        bundle.putString("endsText", endsInText);
        bundle.putString("shareUrl", shareUrl);
        bundle.putString("departmentSubChannel", eventDepartment);
        super.onSaveInstanceState(bundle);
    }

    public void openRefinePanel()
    {
        if (refineFragment instanceof EventRefineFragment)
        {
            ((EventRefineFragment)refineFragment).populateAdapter();
            isRefinePanelLoaded = true;
        }
        super.openRefinePanel();
    }

    protected void processArguments(Intent intent)
    {
        if (TextUtils.isEmpty(eventId))
        {
            eventId = intent.getStringExtra("eventId");
        }
        eventSeoName = intent.getStringExtra("eventSeoName");
        if (TextUtils.isEmpty(eventId) && TextUtils.isEmpty(eventSeoName))
        {
            getActivity().finish();
        }
        if (TextUtils.isEmpty(eventTitle))
        {
            eventTitle = intent.getStringExtra("eventTitle");
        }
        if (TextUtils.isEmpty(coverImageUrl))
        {
            coverImageUrl = intent.getStringExtra("coverImageUrl");
        }
        if (TextUtils.isEmpty(endsInText))
        {
            endsInText = intent.getStringExtra("endsText");
        }
        if (TextUtils.isEmpty(shareUrl))
        {
            shareUrl = intent.getStringExtra("shareUrl");
        }
        eventDepartment = intent.getStringExtra("departmentSubChannel");
        initAdapter();
    }


}
