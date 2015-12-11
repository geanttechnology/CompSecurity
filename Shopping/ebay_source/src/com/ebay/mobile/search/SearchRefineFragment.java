// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.widget.DrawerControlListener;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.shopping.GetCategoryInfoLoader;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.search.refine.controllers.AspectController;
import com.ebay.mobile.search.refine.controllers.AuctionFormatRefinementController;
import com.ebay.mobile.search.refine.controllers.CategoryRefinementController;
import com.ebay.mobile.search.refine.controllers.CheckedDetailController;
import com.ebay.mobile.search.refine.controllers.ConditionController;
import com.ebay.mobile.search.refine.controllers.DeliveryOptionsController;
import com.ebay.mobile.search.refine.controllers.DetailController;
import com.ebay.mobile.search.refine.controllers.DistanceRefinementController;
import com.ebay.mobile.search.refine.controllers.ItemLocationController;
import com.ebay.mobile.search.refine.controllers.NearController;
import com.ebay.mobile.search.refine.controllers.PriceController;
import com.ebay.mobile.search.refine.controllers.SortOrderRefinementController;
import com.ebay.mobile.search.refine.types.AuctionFormat;
import com.ebay.mobile.search.refine.types.ItemConditionHelper;
import com.ebay.mobile.search.refine.types.ItemLocation;
import com.ebay.mobile.search.refine.types.ItemLocationRelativeLocale;
import com.ebay.mobile.search.refine.types.SortOrder;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.shopping.GetCategoryInfoResponse;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.search:
//            DetailMode, RefinementLocks, DetailLaunchMode, SearchActivitySync, 
//            Summarizable, SummarizableWithDefault, HasCustomContent, PromptForStringDialogFragment, 
//            RefinementUpdatedListener

public class SearchRefineFragment extends BaseFragment
    implements android.view.View.OnClickListener, DialogFragmentCallback, PromptForStringDialogFragment.PromptForStringCompletedListener, com.ebay.mobile.search.refine.controllers.AspectController.AspectProvider, com.ebay.mobile.search.refine.controllers.CategoryRefinementController.CategoryProvider, com.ebay.mobile.util.ContentSyncManager.ContentSync
{

    private static final String EXTRA_CLIENT_SORTKEY = "refineReqSortKey";
    public static final int INVALID_INDEX = 0x7fffffff;
    private static final String KEY_DETAIL_EXTRA = "detailExtra";
    private static final String KEY_DETAIL_MODE = "detail";
    private static final String KEY_LONG_EXTRA = "lInt";
    private static final int LOADER_ID_FETCH_PARENT_CHAIN = 1;
    private static final int MAX_ASPECTS_IN_SHORTLIST = 3;
    public static String NOT_SPECIFIED_LABEL = null;
    private static final String REASON_SET_SORT_ORDER = "SearchRefineFragment.reason.setSortOrder";
    public static final int RESET_BUTTON_CALLBACK = 39;
    private static final int RESET_REFINEMENT_OPTIONS = 1;
    public static final String SYNC_KEY_ZIPCODE_MODIFIED = "zipCode";
    private static SortOrder defaultSortOrder;
    private static final HashMap detailModeToViewId;
    public static boolean isRefineCategoryHistoDisplayEnabledByDCS = false;
    public static final com.ebay.common.model.search.EbayCategoryHistogram.Category rootCategoryPlaceholder;
    public static EbayCategorySummary rootCategorySummaryPlaceholder;
    private static int sortIndexNearest;
    public static int textHighlightColor;
    public static int textLowlightColor;
    private AuctionFormat AUCTION_FORMAT_ALL;
    private AuctionFormat AUCTION_FORMAT_ALL_BO;
    private AuctionFormat AUCTION_FORMAT_AUCTION;
    private AuctionFormat AUCTION_FORMAT_BIN;
    private LinearLayout allLocalAspects;
    private LinearLayout alwaysVisibleAspects;
    private EbayAspectHistogram aspectHistogram;
    public AuctionFormat auctionFormats[];
    private EbayCategoryHistogram categoryHistogram;
    public HashMap categoryToParent;
    public HashMap categoryToSummary;
    private View charityDivider;
    private FrameLayout contentCustomView;
    private ScrollView contentMainOptionsView;
    private ListView contentOptionDetailView;
    private final EnumMap controllerMap = new EnumMap(com/ebay/mobile/search/DetailMode);
    private DetailMode deferredDetailMode;
    private Bundle deferredDetailState;
    private DetailController detailController;
    private DetailMode detailMode;
    private View dividerNear;
    private View doneButton;
    private DrawerControlListener drawerControl;
    private View ebayPlusOnlyDivider;
    private View ebayPlusOnlyLayout;
    public boolean hasUserSelectedAllCategories;
    private TextView headerBackToParentPanel;
    private View headerCategoryLayout;
    private TextView headerDetailTitleView;
    private TextView headerPanelTitleView;
    public boolean isUserWithoutPostalCode;
    private ItemConditionHelper itemConditionHelper;
    public ItemLocation itemLocationCurrentCountry;
    public ItemLocation itemLocationOnEbayCom;
    public ItemLocation itemLocationWorldwide;
    public HashMap localAspectToView;
    public ArrayList locationItems;
    private ImageView lockBuyingFormat;
    private ImageView lockCharity;
    private ImageView lockCompletedItems;
    private ImageView lockCondition;
    private ImageView lockDescriptionSearch;
    private ImageView lockEbayPlusOnly;
    private ImageView lockItemLocation;
    private ImageView lockNear;
    private ImageView lockPriceRange;
    private ImageView lockReturnsAccepted;
    private ImageView lockShipping;
    private ImageView lockSoldItems;
    private ImageView lockSortOrder;
    public RefinementLocks locks;
    private boolean locksEnabled;
    private LinearLayout moreRefinementsContainer;
    private RefinementUpdatedListener refinementUpdatedListener;
    private Button resetButton;
    int resetFlags;
    private View returnsAcceptedDivider;
    public SearchActivitySync searchActivitySync;
    public SearchParameters searchParameters;
    private View selectorBuyingFormat;
    private View selectorCategory;
    private View selectorCharity;
    private View selectorCondition;
    private View selectorItemLocation;
    private View selectorNear;
    private View selectorPriceRange;
    private View selectorReturnsAccepted;
    private View selectorShipping;
    private View selectorSortOrder;
    private boolean shouldUpdateStateWhenVisible;
    private View showFewerRefinementsContainer;
    private View showMoreRefinementsContainer;
    public int sortIndexToSkip;
    public SortOrder sortOrders[];
    private final Set syncSubscriptions = new HashSet();
    private TextView textBuyingFormat;
    private TextView textCategory;
    private TextView textCondition;
    private TextView textItemLocation;
    private TextView textNear;
    private TextView textPriceRange;
    private TextView textShipping;
    private TextView textSortOrder;
    private CheckedTextView toggleCharity;
    private CheckedTextView toggleCompletedItems;
    private CheckedTextView toggleDescriptionSearch;
    private CheckedTextView toggleEbayPlusOnly;
    private CheckedTextView toggleReturnsAccepted;
    private CheckedTextView toggleSoldItems;
    public SearchResultFragment.OnTrackingEventsListener trackingEventListener;
    private ImageView viewModeList;
    private ImageView viewModeTile;

    public SearchRefineFragment()
    {
        locationItems = null;
        itemLocationCurrentCountry = null;
        itemLocationWorldwide = null;
        itemLocationOnEbayCom = null;
        itemConditionHelper = null;
        contentMainOptionsView = null;
        contentCustomView = null;
        contentOptionDetailView = null;
        headerPanelTitleView = null;
        headerBackToParentPanel = null;
        headerCategoryLayout = null;
        headerDetailTitleView = null;
        alwaysVisibleAspects = null;
        moreRefinementsContainer = null;
        showMoreRefinementsContainer = null;
        showFewerRefinementsContainer = null;
        allLocalAspects = null;
        viewModeList = null;
        viewModeTile = null;
        doneButton = null;
        locksEnabled = false;
        shouldUpdateStateWhenVisible = false;
        resetFlags = 1;
        categoryToParent = new HashMap();
        categoryToSummary = new HashMap();
        localAspectToView = new HashMap();
        refinementUpdatedListener = null;
        searchActivitySync = null;
        drawerControl = null;
        detailController = null;
        detailMode = DetailMode.NONE;
        deferredDetailMode = DetailMode.NONE;
        deferredDetailState = null;
        isUserWithoutPostalCode = false;
        hasUserSelectedAllCategories = false;
        sortIndexToSkip = 0x7fffffff;
    }

    private void addAspectToHost(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect, String s, boolean flag, LinearLayout linearlayout)
    {
        View view = getInflater().inflate(0x7f0301dd, linearlayout, false);
        view.setTag(0x7f10000f, DetailMode.ASPECTS);
        view.setTag(0x7f10000e, aspect);
        view.findViewById(0x7f1005cd).setVisibility(8);
        TextView textview = (TextView)view.findViewById(0x7f1005cc);
        textview.setText(s);
        int i;
        if (flag)
        {
            i = textHighlightColor;
        } else
        {
            i = textLowlightColor;
        }
        textview.setTextColor(i);
        textview.setVisibility(0);
        ((TextView)view.findViewById(0x7f1005cb)).setText(aspect.name);
        view.setOnClickListener(this);
        localAspectToView.put(aspect.name, view);
        linearlayout.addView(view);
        getInflater().inflate(0x7f0301bc, linearlayout);
    }

    private void addSyncSubscription(String s)
    {
        if (syncSubscriptions.contains(s))
        {
            return;
        } else
        {
            ContentSyncManager.register(this, new String[] {
                s
            });
            syncSubscriptions.add(s);
            return;
        }
    }

    private void clearAspectRows()
    {
        if (alwaysVisibleAspects != null)
        {
            alwaysVisibleAspects.removeAllViews();
            allLocalAspects.removeAllViews();
            localAspectToView.clear();
        }
    }

    private void clickLock(RefinementLocks.RefinementLockType refinementlocktype)
    {
        if (locks.getLockState(refinementlocktype, searchParameters) != 1) goto _L2; else goto _L1
_L1:
        if (refinementlocktype == RefinementLocks.RefinementLockType.COMPLETEDITEMS)
        {
            locks.unlock(RefinementLocks.RefinementLockType.SOLDITEMS);
        }
        locks.unlock(refinementlocktype);
_L4:
        updateLocks();
        return;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$search$DetailMode[];
            static final int $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType = new int[RefinementLocks.RefinementLockType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.CONDITION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.BUYINGFORMAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.BESTOFFER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.SORTORDER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.EBAYPLUS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.MINPRICE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.MAXPRICE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.FREESHIPPING.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.EXPEDITEDSHIPPING.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.INSTOREPICKUP.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.LOCALPICKUP.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.ZIPCODE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.MAXDISTANCE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.COMPLETEDITEMS.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.SOLDITEMS.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.DESCRIPTIONSEARCH.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.SEARCHLOCALCOUNTRY.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.SEARCHOTHERCOUNTRIES.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.RETURNSACCEPTED.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.EBAYGIVINGWORKS.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[RefinementLocks.RefinementLockType.EBN.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                $SwitchMap$com$ebay$mobile$search$DetailMode = new int[DetailMode.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.ASPECTS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.AUCTION_FORMAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.CONDITION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.PRICE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.SORT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.DELIVERY_OPTIONS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.SL_DISTANCE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.SL_ITEMLOCATION.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.NEAR.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.NONE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.ROOT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.CATEGORIES.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.search.RefinementLocks.RefinementLockType[refinementlocktype.ordinal()])
        {
        case 1: // '\001'
            locks.lock(refinementlocktype, searchParameters.condition);
            break;

        case 2: // '\002'
            locks.lock(refinementlocktype, searchParameters.buyingFormat);
            locks.unlock(RefinementLocks.RefinementLockType.BESTOFFER);
            break;

        case 3: // '\003'
            locks.lock(refinementlocktype, searchParameters.bestOfferOnly);
            locks.unlock(RefinementLocks.RefinementLockType.BUYINGFORMAT);
            break;

        case 4: // '\004'
            locks.lock(refinementlocktype, searchParameters.sortOrder);
            break;

        case 5: // '\005'
            locks.lock(refinementlocktype, searchParameters.ebayPlusOnly);
            break;

        case 6: // '\006'
            locks.lock(refinementlocktype, searchParameters.minPrice);
            break;

        case 7: // '\007'
            locks.lock(refinementlocktype, searchParameters.maxPrice);
            break;

        case 8: // '\b'
            locks.lock(refinementlocktype, searchParameters.freeShipping);
            break;

        case 9: // '\t'
            locks.lock(refinementlocktype, searchParameters.expeditedShipping);
            break;

        case 10: // '\n'
            locks.lock(refinementlocktype, searchParameters.inStorePickupOnly);
            break;

        case 11: // '\013'
            locks.lock(refinementlocktype, searchParameters.localPickupOnly);
            break;

        case 12: // '\f'
            locks.lock(refinementlocktype, searchParameters.buyerPostalCode);
            break;

        case 13: // '\r'
            locks.lock(refinementlocktype, searchParameters.maxDistance);
            break;

        case 14: // '\016'
            locks.lock(refinementlocktype, searchParameters.completedListings);
            break;

        case 15: // '\017'
            locks.lock(RefinementLocks.RefinementLockType.COMPLETEDITEMS, searchParameters.completedListings);
            locks.lock(refinementlocktype, searchParameters.soldItemsOnly);
            break;

        case 16: // '\020'
            locks.lock(refinementlocktype, searchParameters.descriptionSearch);
            break;

        case 17: // '\021'
            locks.lock(refinementlocktype, searchParameters.searchLocalCountryOnly);
            break;

        case 18: // '\022'
            locks.lock(refinementlocktype, searchParameters.searchOtherCountries);
            break;

        case 19: // '\023'
            locks.lock(refinementlocktype, searchParameters.returnsAccepted);
            break;

        case 20: // '\024'
            locks.lock(refinementlocktype, searchParameters.ebayGivingWorks);
            break;

        case 21: // '\025'
            locks.lock(refinementlocktype, searchParameters.ebnOnly);
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void disableMultiTouch(View view)
    {
        ViewGroup viewgroup = (ViewGroup)view.findViewById(0x7f100582);
        view = (ViewGroup)view.findViewById(0x7f100593);
        viewgroup.setMotionEventSplittingEnabled(false);
        view.setMotionEventSplittingEnabled(false);
    }

    private String formatCurrency(ItemCurrency itemcurrency)
    {
        return EbayCurrencyUtil.formatDisplay(itemcurrency, 2);
    }

    private Bundle getDialogExtra(DialogFragment dialogfragment)
    {
        return dialogfragment.getArguments();
    }

    private int getSortIndex(SortOrder sortorder)
    {
        if (sortorder != null)
        {
            for (int i = 0; i < sortOrders.length; i++)
            {
                if (sortOrders[i] == sortorder)
                {
                    return i;
                }
            }

        }
        return -1;
    }

    private SortOrder getSortOrderBySetting(String s)
    {
        if (s != null)
        {
            SortOrder asortorder[] = sortOrders;
            int j = asortorder.length;
            for (int i = 0; i < j; i++)
            {
                SortOrder sortorder = asortorder[i];
                if (sortorder.sortOrder.equals(s))
                {
                    return sortorder;
                }
            }

        }
        return defaultSortOrder;
    }

    private void onCheckCharitySearch(boolean flag)
    {
        SearchParameters searchparameters = searchParameters;
        if (searchparameters.ebayGivingWorks != flag)
        {
            searchparameters.ebayGivingWorks = flag;
            toggleCharity.setChecked(flag);
        }
    }

    private void onCheckCompletedItems(boolean flag)
    {
        SearchParameters searchparameters = searchParameters;
        if (searchparameters.completedListings != flag)
        {
            searchparameters.completedListings = flag;
            toggleCompletedItems.setChecked(flag);
            if (flag)
            {
                onCheckDescriptionSearch(false);
                locks.unlock(RefinementLocks.RefinementLockType.DESCRIPTIONSEARCH);
                updateSortOrders(true);
            } else
            {
                if (searchparameters.soldItemsOnly)
                {
                    onCheckSoldItems(false);
                    locks.unlock(RefinementLocks.RefinementLockType.SOLDITEMS);
                }
                updateSortOrders(true);
            }
        }
        updateSummary(DetailMode.SORT, textSortOrder);
    }

    private void onCheckDescriptionSearch(boolean flag)
    {
        SearchParameters searchparameters = searchParameters;
        if (searchparameters.descriptionSearch != flag)
        {
            searchparameters.descriptionSearch = flag;
            toggleDescriptionSearch.setChecked(flag);
            if (flag)
            {
                onCheckCompletedItems(false);
                locks.unlock(RefinementLocks.RefinementLockType.COMPLETEDITEMS);
            }
        }
    }

    private void onCheckEbayPlusOnly(boolean flag)
    {
        SearchParameters searchparameters = searchParameters;
        if (searchparameters.ebayPlusOnly != flag)
        {
            searchparameters.ebayPlusOnly = flag;
            toggleEbayPlusOnly.setChecked(flag);
        }
    }

    private void onCheckReturnsAccepted(boolean flag)
    {
        SearchParameters searchparameters = searchParameters;
        if (searchparameters.returnsAccepted != flag)
        {
            searchparameters.returnsAccepted = flag;
            toggleReturnsAccepted.setChecked(flag);
        }
    }

    private void onCheckSoldItems(boolean flag)
    {
        SearchParameters searchparameters = searchParameters;
        if (searchparameters.soldItemsOnly != flag)
        {
            searchparameters.soldItemsOnly = flag;
            toggleSoldItems.setChecked(flag);
            if (flag && !searchparameters.completedListings)
            {
                onCheckCompletedItems(true);
            }
        }
    }

    private void onClick(int i)
    {
        onClick(i, DetailLaunchMode.DEFAULT);
    }

    private void onClick(int i, DetailLaunchMode detaillaunchmode)
    {
        boolean flag;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        boolean flag10;
        flag6 = true;
        flag7 = true;
        flag8 = true;
        flag9 = true;
        flag10 = true;
        flag = true;
        if (searchParameters != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        DetailMode detailmode;
        detailmode = detailMode;
        detailMode = DetailMode.NONE;
        i;
        JVM INSTR lookupswitch 35: default 328
    //                   2131755780: 509
    //                   2131755801: 768
    //                   2131756419: 498
    //                   2131756420: 779
    //                   2131756426: 1046
    //                   2131756427: 1075
    //                   2131756428: 425
    //                   2131756433: 639
    //                   2131756434: 789
    //                   2131756437: 487
    //                   2131756438: 799
    //                   2131756441: 829
    //                   2131756443: 520
    //                   2131756444: 839
    //                   2131756448: 542
    //                   2131756449: 890
    //                   2131756453: 873
    //                   2131756456: 531
    //                   2131756457: 856
    //                   2131756460: 553
    //                   2131756461: 928
    //                   2131756462: 432
    //                   2131756463: 938
    //                   2131756465: 596
    //                   2131756466: 948
    //                   2131756468: 958
    //                   2131756469: 682
    //                   2131756472: 968
    //                   2131756473: 725
    //                   2131756475: 471
    //                   2131756478: 479
    //                   2131756481: 978
    //                   2131756495: 385
    //                   2131756497: 343
    //                   2131756499: 401;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38
_L9:
        break MISSING_BLOCK_LABEL_1075;
_L3:
        break; /* Loop/switch isn't completed */
_L37:
        break; /* Loop/switch isn't completed */
_L40:
        if (detailMode == DetailMode.NONE)
        {
            showRootRefinementPanel();
            return;
        }
        if (true) goto _L1; else goto _L39
_L39:
        if (detailController != null && detailmode == detailController.getDetailMode())
        {
            detailController.onDoneClicked();
        }
        drawerControl.closeDrawer(5);
          goto _L40
_L36:
        detailController.onBackClicked();
        showRootRefinementPanel();
          goto _L40
_L38:
        if (detailController.getAdapter() != null)
        {
            detailController.notifyHeaderClicked();
        }
          goto _L40
_L10:
        refineCurrentCategory();
          goto _L40
_L25:
        if (searchParameters.soldItemsOnly)
        {
            flag = false;
        }
        onCheckSoldItems(flag);
        locks.unlock(RefinementLocks.RefinementLockType.SOLDITEMS);
        searchParamsUpdated();
          goto _L40
_L33:
        updateExtendedRefinementVisibility(true);
          goto _L40
_L34:
        updateExtendedRefinementVisibility(false);
          goto _L40
_L13:
        showDetail(DetailMode.AUCTION_FORMAT, detaillaunchmode);
          goto _L40
_L6:
        showDetail(DetailMode.SORT, detaillaunchmode);
          goto _L40
_L4:
        showDetail(DetailMode.CONDITION, detaillaunchmode);
          goto _L40
_L16:
        showDetail(DetailMode.PRICE, detaillaunchmode);
          goto _L40
_L21:
        showDetail(DetailMode.SL_ITEMLOCATION, detaillaunchmode);
          goto _L40
_L18:
        showDetail(DetailMode.NEAR, detaillaunchmode);
          goto _L40
_L23:
        boolean flag1;
        if (!searchParameters.completedListings)
        {
            flag1 = flag6;
        } else
        {
            flag1 = false;
        }
        onCheckCompletedItems(flag1);
        locks.unlock(RefinementLocks.RefinementLockType.COMPLETEDITEMS);
        searchParamsUpdated();
          goto _L40
_L27:
        boolean flag2;
        if (!searchParameters.descriptionSearch)
        {
            flag2 = flag7;
        } else
        {
            flag2 = false;
        }
        onCheckDescriptionSearch(flag2);
        locks.unlock(RefinementLocks.RefinementLockType.DESCRIPTIONSEARCH);
        searchParamsUpdated();
          goto _L40
_L11:
        boolean flag3;
        if (!searchParameters.ebayPlusOnly)
        {
            flag3 = flag8;
        } else
        {
            flag3 = false;
        }
        onCheckEbayPlusOnly(flag3);
        locks.unlock(RefinementLocks.RefinementLockType.EBAYPLUS);
        searchParamsUpdated();
          goto _L40
_L30:
        boolean flag4;
        if (!searchParameters.returnsAccepted)
        {
            flag4 = flag9;
        } else
        {
            flag4 = false;
        }
        onCheckReturnsAccepted(flag4);
        locks.unlock(RefinementLocks.RefinementLockType.RETURNSACCEPTED);
        searchParamsUpdated();
          goto _L40
_L32:
        boolean flag5;
        if (!searchParameters.ebayGivingWorks)
        {
            flag5 = flag10;
        } else
        {
            flag5 = false;
        }
        onCheckCharitySearch(flag5);
        locks.unlock(RefinementLocks.RefinementLockType.EBAYGIVINGWORKS);
        searchParamsUpdated();
          goto _L40
_L5:
        showDetail(DetailMode.DELIVERY_OPTIONS, detaillaunchmode);
          goto _L40
_L7:
        clickLock(RefinementLocks.RefinementLockType.SORTORDER);
          goto _L40
_L12:
        clickLock(RefinementLocks.RefinementLockType.EBAYPLUS);
          goto _L40
_L14:
        if (searchParameters.bestOfferOnly)
        {
            clickLock(RefinementLocks.RefinementLockType.BESTOFFER);
        } else
        {
            clickLock(RefinementLocks.RefinementLockType.BUYINGFORMAT);
        }
          goto _L40
_L15:
        clickLock(RefinementLocks.RefinementLockType.CONDITION);
          goto _L40
_L17:
        clickLock(RefinementLocks.RefinementLockType.MINPRICE);
        clickLock(RefinementLocks.RefinementLockType.MAXPRICE);
          goto _L40
_L22:
        clickLock(RefinementLocks.RefinementLockType.SEARCHOTHERCOUNTRIES);
        clickLock(RefinementLocks.RefinementLockType.SEARCHLOCALCOUNTRY);
          goto _L40
_L20:
        clickLock(RefinementLocks.RefinementLockType.FREESHIPPING);
        clickLock(RefinementLocks.RefinementLockType.EXPEDITEDSHIPPING);
          goto _L40
_L19:
        clickLock(RefinementLocks.RefinementLockType.LOCALPICKUP);
        clickLock(RefinementLocks.RefinementLockType.ZIPCODE);
        clickLock(RefinementLocks.RefinementLockType.MAXDISTANCE);
        clickLock(RefinementLocks.RefinementLockType.INSTOREPICKUP);
        clickLock(RefinementLocks.RefinementLockType.EBN);
          goto _L40
_L24:
        clickLock(RefinementLocks.RefinementLockType.COMPLETEDITEMS);
          goto _L40
_L26:
        clickLock(RefinementLocks.RefinementLockType.SOLDITEMS);
          goto _L40
_L28:
        clickLock(RefinementLocks.RefinementLockType.DESCRIPTIONSEARCH);
          goto _L40
_L29:
        clickLock(RefinementLocks.RefinementLockType.RETURNSACCEPTED);
          goto _L40
_L31:
        clickLock(RefinementLocks.RefinementLockType.EBAYGIVINGWORKS);
          goto _L40
_L35:
        detaillaunchmode = new com.ebay.app.AlertDialogFragment.Builder();
        detaillaunchmode.setMessage(getResources().getString(0x7f070987)).setTitle(getResources().getString(0x7f070988)).setPositiveButton(0x7f070738).setNegativeButton(0x7f0701cc);
        detaillaunchmode.createFromFragment(39, this).show(getFragmentManager(), "reset");
          goto _L40
_L8:
        if (searchActivitySync.getSearchViewType() != 0)
        {
            searchActivitySync.setSearchViewType(0);
            updateViewModeIcons();
        }
          goto _L40
        if (searchActivitySync.getSearchViewType() != 1)
        {
            searchActivitySync.setSearchViewType(1);
            updateViewModeIcons();
        }
          goto _L40
    }

    private void reconstructCategoryAncestry(List list)
    {
        EbayCategory ebaycategory = (EbayCategory)list.get(0);
        list = ebaycategory.namePath.split(":");
        String as[] = ebaycategory.idPath.split(":");
        int i = 0;
        while (i < as.length) 
        {
            HashMap hashmap = categoryToParent;
            long l1 = Long.parseLong(as[i]);
            long l;
            if (i == 0)
            {
                l = rootCategorySummaryPlaceholder.id;
            } else
            {
                l = Long.parseLong(as[i - 1]);
            }
            hashmap.put(Long.valueOf(l1), Long.valueOf(l));
            categoryToSummary.put(Long.valueOf(Long.parseLong(as[i])), new EbayCategorySummary(Integer.parseInt(as[i]), list[i]));
            i++;
        }
        if (detailController instanceof CategoryRefinementController)
        {
            ((CategoryRefinementController)detailController).onAncestorMetadataUpdated();
        }
    }

    private void refineCurrentCategory()
    {
        com.ebay.common.model.search.EbayCategoryHistogram.Category category;
        Iterator iterator;
        category = null;
        if (searchParameters.category != null)
        {
            category = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
            category.id = searchParameters.category.id;
            category.name = searchParameters.category.name;
        }
        iterator = null;
        if (categoryHistogram == null)
        {
            return;
        }
        if (categoryHistogram.categories.size() <= 1) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new ArrayList();
        iterator = categoryHistogram.categories.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.common.model.search.EbayCategoryHistogram.Category category1 = (com.ebay.common.model.search.EbayCategoryHistogram.Category)iterator.next();
            if (category == null || category1.parentId == category.id)
            {
                ((List) (obj)).add(category1);
            }
        } while (true);
        obj = (com.ebay.common.model.search.EbayCategoryHistogram.Category[])((List) (obj)).toArray(new com.ebay.common.model.search.EbayCategoryHistogram.Category[((List) (obj)).size()]);
_L4:
        (new CategoryRefinementController(this, category, ((com.ebay.common.model.search.EbayCategoryHistogram.Category []) (obj)), false, contentOptionDetailView)).refineCategory(category, ((com.ebay.common.model.search.EbayCategoryHistogram.Category []) (obj)), false, contentOptionDetailView);
        return;
_L2:
        obj = iterator;
        if (categoryHistogram.categories.size() == 1)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)categoryHistogram.categories.get(0);
            obj = iterator;
            if (parentcategory.children != null)
            {
                obj = iterator;
                if (parentcategory.children.size() > 0)
                {
                    obj = (com.ebay.common.model.search.EbayCategoryHistogram.Category[])parentcategory.children.toArray(new com.ebay.common.model.search.EbayCategoryHistogram.Category[0]);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void refreshRefinementView()
    {
        if (detailController == null || detailMode != detailController.getDetailMode())
        {
            return;
        } else
        {
            showDetail(detailController.getDetailMode(), detailController.getStateExtras(), DetailLaunchMode.DEFAULT);
            return;
        }
    }

    private void restoreDetail()
    {
        if (deferredDetailMode == null || deferredDetailMode == DetailMode.NONE || searchParameters == null)
        {
            return;
        } else
        {
            showDetail(deferredDetailMode, deferredDetailState, DetailLaunchMode.DEFAULT);
            deferredDetailMode = null;
            deferredDetailState = null;
            return;
        }
    }

    private void setItemLocation()
    {
        DetailController detailcontroller = getController(DetailMode.SL_ITEMLOCATION);
        textItemLocation.setText(((Summarizable)detailcontroller).getSummary());
        TextView textview = textItemLocation;
        int i;
        if (((SummarizableWithDefault)detailcontroller).isDefault())
        {
            i = textLowlightColor;
        } else
        {
            i = textHighlightColor;
        }
        textview.setTextColor(i);
    }

    private void setPriceRange(ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        searchParameters.minPrice = itemcurrency;
        searchParameters.maxPrice = itemcurrency1;
        Object obj = null;
        if (itemcurrency != null && itemcurrency1 != null)
        {
            itemcurrency = getString(0x7f0707bf, new Object[] {
                formatCurrency(itemcurrency), formatCurrency(itemcurrency1)
            });
        } else
        if (itemcurrency != null)
        {
            itemcurrency = getString(0x7f070179, new Object[] {
                formatCurrency(itemcurrency)
            });
        } else
        {
            itemcurrency = obj;
            if (itemcurrency1 != null)
            {
                itemcurrency = getString(0x7f070604, new Object[] {
                    formatCurrency(itemcurrency1)
                });
            }
        }
        if (itemcurrency != null)
        {
            textPriceRange.setText(itemcurrency);
            textPriceRange.setTextColor(textHighlightColor);
            return;
        } else
        {
            textPriceRange.setText(0x7f070986);
            textPriceRange.setTextColor(textLowlightColor);
            return;
        }
    }

    private boolean setSortOrder(String s, boolean flag)
    {
        SortOrder sortorder = setSortOrder(getSortOrderBySetting(s), flag);
        return sortorder != null && sortorder.sortOrder.equals(s);
    }

    private void showDetail(DetailMode detailmode, Bundle bundle, DetailLaunchMode detaillaunchmode)
    {
        if (searchParameters != null) goto _L2; else goto _L1
_L1:
        deferredDetailMode = detailmode;
        deferredDetailState = bundle;
_L4:
        return;
_L2:
        switch (_cls1..SwitchMap.com.ebay.mobile.search.DetailMode[detailmode.ordinal()])
        {
        default:
            detailmode = getController(detailmode);
            if (detailmode != null)
            {
                detailmode.setStateExtras(bundle);
                if (bundle == null || detaillaunchmode != DetailLaunchMode.DEFAULT)
                {
                    boolean flag;
                    if (detaillaunchmode == DetailLaunchMode.ONE_SHOT)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    detailmode.setOneShot(flag);
                }
                showDetails(detailmode);
                return;
            }
            break;

        case 10: // '\n'
        case 11: // '\013'
            showRootRefinementPanel();
            return;

        case 12: // '\f'
            refineCurrentCategory();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void showDetails(DetailController detailcontroller)
    {
        String s = detailcontroller.getTitle();
        headerPanelTitleView.setText(s);
        headerCategoryLayout.setVisibility(8);
        if (detailController != null)
        {
            detailController.onPause();
        }
        detailController = detailcontroller;
        detailMode = detailController.getDetailMode();
        for (Iterator iterator = detailController.getContentSyncKeys().iterator(); iterator.hasNext(); addSyncSubscription((String)iterator.next())) { }
        contentMainOptionsView.setVisibility(4);
        byte byte0;
        if (detailcontroller instanceof HasCustomContent)
        {
            contentOptionDetailView.setVisibility(4);
            contentCustomView.setVisibility(0);
            contentCustomView.removeAllViews();
            ((HasCustomContent)detailcontroller).setCustomViewHost(contentCustomView);
        } else
        {
            contentCustomView.setVisibility(4);
            contentOptionDetailView.setVisibility(0);
        }
        if (isResumed())
        {
            detailcontroller.onResume();
        }
        byte0 = 0;
        if (!detailcontroller.isMainHeaderVisible())
        {
            byte0 = 8;
        }
        headerBackToParentPanel.setVisibility(byte0);
    }

    private void updateDataState()
    {
        Object obj = searchParameters;
        DeviceConfiguration deviceconfiguration;
        int i;
        byte byte0;
        boolean flag;
        int k;
        byte byte1;
        boolean flag2;
        boolean flag3;
        if (((SearchParameters) (obj)).productId != null && ((SearchParameters) (obj)).productIdType != null)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        i = 0;
        flag2 = false;
        flag3 = false;
        byte0 = 0;
        byte1 = 0;
        if (!searchActivitySync.isNearEnabled())
        {
            byte0 = 8;
        }
        if (k != 0)
        {
            i = 8;
        } else
        if ((((SearchParameters) (obj)).category == null || ((SearchParameters) (obj)).category.id <= 0L) && categoryHistogram == null)
        {
            i = 8;
        } else
        if (!searchActivitySync.isCategoryRefinementSupported())
        {
            i = 8;
        }
        if (k != 0)
        {
            obj.category = null;
            obj.descriptionSearch = false;
        }
        selectorCategory.setVisibility(i);
        deviceconfiguration = DeviceConfiguration.getAsync();
        i = ((flag3) ? 1 : 0);
        if (!deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.refineCharitySupportEnabled))
        {
            i = 8;
        }
        k = ((flag2) ? 1 : 0);
        if (!deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.refineReturnsAcceptedEnabled))
        {
            k = 8;
        }
        if (!deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus))
        {
            byte1 = 8;
        }
        if (((SearchParameters) (obj)).sellerOffer != null)
        {
            toggleSoldItems.setVisibility(8);
            toggleCompletedItems.setVisibility(8);
        }
        ebayPlusOnlyLayout.setVisibility(byte1);
        ebayPlusOnlyDivider.setVisibility(byte1);
        selectorCharity.setVisibility(i);
        charityDivider.setVisibility(i);
        selectorReturnsAccepted.setVisibility(k);
        returnsAcceptedDivider.setVisibility(k);
        dividerNear.setVisibility(byte0);
        selectorNear.setVisibility(byte0);
        if (TextUtils.isEmpty(((SearchParameters) (obj)).buyerPostalCode) && ((SearchParameters) (obj)).maxDistance != 0)
        {
            obj.maxDistance = 0;
        }
        if (((SearchParameters) (obj)).searchLocalCountryOnly && ((SearchParameters) (obj)).searchOtherCountries)
        {
            obj.searchOtherCountries = false;
            obj.searchLocalCountryOnly = false;
        }
        updateSortOrders(true);
        setSortOrder(((SearchParameters) (obj)).sortOrder, false);
        setBuyingFormat(((SearchParameters) (obj)).buyingFormat, ((SearchParameters) (obj)).bestOfferOnly);
        setCondition(itemConditionHelper.getLocalizedCondition(searchParameters.condition));
        setPriceRange(((SearchParameters) (obj)).minPrice, ((SearchParameters) (obj)).maxPrice);
        setItemLocation();
        updateSummary(DetailMode.DELIVERY_OPTIONS, textShipping);
        updateSummary(DetailMode.NEAR, textNear);
        updateViewModeIcons();
        toggleEbayPlusOnly.setChecked(((SearchParameters) (obj)).ebayPlusOnly);
        toggleCompletedItems.setChecked(((SearchParameters) (obj)).completedListings);
        toggleSoldItems.setChecked(((SearchParameters) (obj)).soldItemsOnly);
        toggleDescriptionSearch.setChecked(((SearchParameters) (obj)).descriptionSearch);
        toggleCharity.setChecked(((SearchParameters) (obj)).ebayGivingWorks);
        toggleReturnsAccepted.setChecked(((SearchParameters) (obj)).returnsAccepted);
        setCategory(((SearchParameters) (obj)).category, false);
        if (detailMode == DetailMode.ASPECTS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        clearAspectRows();
        if (aspectHistogram != null && aspectHistogram.size() > 0)
        {
            i = 0;
            obj = new ArrayList();
            for (Iterator iterator = aspectHistogram.iterator(); iterator.hasNext();)
            {
                com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1 = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator.next();
                if (!aspect1.suppressDisplay)
                {
                    String s = AspectController.getSummary(aspect1);
                    boolean flag4 = AspectController.isConfigured(aspect1);
                    addAspectToHost(aspect1, s, flag4, allLocalAspects);
                    if (flag4 && i < 3)
                    {
                        addAspectToHost(aspect1, s, flag4, alwaysVisibleAspects);
                        i++;
                    } else
                    if (!flag4)
                    {
                        ((List) (obj)).add(aspect1);
                    }
                }
            }

            boolean flag1 = false;
            k = i;
            for (int j = ((flag1) ? 1 : 0); j < ((List) (obj)).size() && k < 3; j++)
            {
                com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)((List) (obj)).get(j);
                addAspectToHost(aspect, AspectController.getSummary(aspect), false, alwaysVisibleAspects);
                k++;
            }

            if (flag)
            {
                refreshRefinementView();
            }
        }
        shouldUpdateStateWhenVisible = false;
    }

    private void updateExtendedRefinementVisibility(boolean flag)
    {
        int j = 0;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        if (flag)
        {
            j = 8;
        }
        showMoreRefinementsContainer.setVisibility(j);
        alwaysVisibleAspects.setVisibility(j);
        allLocalAspects.setVisibility(i);
        moreRefinementsContainer.setVisibility(i);
        showFewerRefinementsContainer.setVisibility(i);
    }

    private void updateLock(int i, ImageView imageview)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            imageview.setVisibility(0);
            imageview.setImageResource(0x7f020235);
            return;

        case 2: // '\002'
            imageview.setVisibility(0);
            imageview.setImageResource(0x7f020236);
            return;

        case 3: // '\003'
            imageview.setVisibility(8);
            break;
        }
    }

    private void updateLock(RefinementLocks.RefinementLockType refinementlocktype, ImageView imageview)
    {
        updateLock(locks.getLockState(refinementlocktype, searchParameters), imageview);
    }

    private void updateLock(RefinementLocks.RefinementLockType arefinementlocktype[], ImageView imageview)
    {
        int j = 3;
        int i1 = arefinementlocktype.length;
        for (int i = 0; i < i1;)
        {
            RefinementLocks.RefinementLockType refinementlocktype = arefinementlocktype[i];
            int l = locks.getLockState(refinementlocktype, searchParameters);
            int k = j;
            if (l < j)
            {
                k = l;
            }
            i++;
            j = k;
        }

        updateLock(j, imageview);
    }

    private void updateLocks()
    {
        if (searchParameters == null || !locksEnabled)
        {
            return;
        }
        updateLock(RefinementLocks.RefinementLockType.SORTORDER, lockSortOrder);
        updateLock(RefinementLocks.RefinementLockType.CONDITION, lockCondition);
        Object obj = RefinementLocks.RefinementLockType.BUYINGFORMAT;
        RefinementLocks.RefinementLockType refinementlocktype = RefinementLocks.RefinementLockType.BESTOFFER;
        Object obj1 = lockBuyingFormat;
        updateLock(new RefinementLocks.RefinementLockType[] {
            obj, refinementlocktype
        }, ((ImageView) (obj1)));
        obj = RefinementLocks.RefinementLockType.MINPRICE;
        refinementlocktype = RefinementLocks.RefinementLockType.MAXPRICE;
        obj1 = lockPriceRange;
        updateLock(new RefinementLocks.RefinementLockType[] {
            obj, refinementlocktype
        }, ((ImageView) (obj1)));
        obj = RefinementLocks.RefinementLockType.SEARCHLOCALCOUNTRY;
        refinementlocktype = RefinementLocks.RefinementLockType.SEARCHOTHERCOUNTRIES;
        obj1 = lockItemLocation;
        updateLock(new RefinementLocks.RefinementLockType[] {
            obj, refinementlocktype
        }, ((ImageView) (obj1)));
        updateLock(RefinementLocks.RefinementLockType.EBAYPLUS, lockEbayPlusOnly);
        updateLock(RefinementLocks.RefinementLockType.COMPLETEDITEMS, lockCompletedItems);
        updateLock(RefinementLocks.RefinementLockType.SOLDITEMS, lockSoldItems);
        updateLock(RefinementLocks.RefinementLockType.DESCRIPTIONSEARCH, lockDescriptionSearch);
        updateLock(RefinementLocks.RefinementLockType.RETURNSACCEPTED, lockReturnsAccepted);
        updateLock(RefinementLocks.RefinementLockType.EBAYGIVINGWORKS, lockCharity);
        if (searchActivitySync.isGbhSearch())
        {
            locks.unlock(RefinementLocks.RefinementLockType.LOCALPICKUP);
            locks.unlock(RefinementLocks.RefinementLockType.ZIPCODE);
            locks.unlock(RefinementLocks.RefinementLockType.MAXDISTANCE);
            locks.unlock(RefinementLocks.RefinementLockType.EBN);
            locks.unlock(RefinementLocks.RefinementLockType.INSTOREPICKUP);
        }
        obj = DeviceConfiguration.getAsync();
        if (!((DeviceConfiguration) (obj)).get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.refineReturnsAcceptedEnabled))
        {
            locks.unlock(RefinementLocks.RefinementLockType.RETURNSACCEPTED);
        }
        if (!((DeviceConfiguration) (obj)).get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.refineExpeditedShippingEnabled))
        {
            locks.unlock(RefinementLocks.RefinementLockType.EXPEDITEDSHIPPING);
        }
        obj = RefinementLocks.RefinementLockType.LOCALPICKUP;
        refinementlocktype = RefinementLocks.RefinementLockType.ZIPCODE;
        obj1 = RefinementLocks.RefinementLockType.MAXDISTANCE;
        RefinementLocks.RefinementLockType refinementlocktype1 = RefinementLocks.RefinementLockType.INSTOREPICKUP;
        RefinementLocks.RefinementLockType refinementlocktype2 = RefinementLocks.RefinementLockType.EBN;
        ImageView imageview = lockNear;
        updateLock(new RefinementLocks.RefinementLockType[] {
            obj, refinementlocktype, obj1, refinementlocktype1, refinementlocktype2
        }, imageview);
        obj = RefinementLocks.RefinementLockType.FREESHIPPING;
        refinementlocktype = RefinementLocks.RefinementLockType.EXPEDITEDSHIPPING;
        obj1 = lockShipping;
        updateLock(new RefinementLocks.RefinementLockType[] {
            obj, refinementlocktype
        }, ((ImageView) (obj1)));
    }

    private void updateSortOrders(boolean flag)
    {
        Preferences preferences = MyApp.getPrefs();
        Object obj = preferences.getAuthentication();
        int i;
        boolean flag3;
        if (obj != null)
        {
            obj = ((Authentication) (obj)).iafToken;
        } else
        {
            obj = null;
        }
        if (obj != null && (searchParameters == null || TextUtils.isEmpty(searchParameters.buyerPostalCode)) && (preferences.getPostalCode() == null || TextUtils.isEmpty(preferences.getPostalCode().postalCode)))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        isUserWithoutPostalCode = flag3;
        i = 0;
        if (searchParameters != null)
        {
            if (searchParameters.soldItemsOnly || searchParameters.completedListings)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        }
        if (sortOrders == null || flag)
        {
            Object obj1 = getResources();
            boolean flag1;
            if (i != 0)
            {
                obj = ((Resources) (obj1)).getStringArray(0x7f0e001c);
                obj1 = ((Resources) (obj1)).getStringArray(0x7f0e001e);
            } else
            {
                obj = ((Resources) (obj1)).getStringArray(0x7f0e001b);
                obj1 = ((Resources) (obj1)).getStringArray(0x7f0e001d);
            }
            flag1 = false;
            sortOrders = new SortOrder[obj.length];
            i = 0;
            while (i < obj.length) 
            {
                String s = obj1[i];
                sortOrders[i] = new SortOrder(obj[i], s);
                boolean flag2;
                if (sortOrders[i].sortOrder.equals("BestMatch"))
                {
                    defaultSortOrder = sortOrders[i];
                } else
                if (sortOrders[i].sortOrder.equals("DistanceNearest"))
                {
                    sortIndexNearest = i;
                }
                flag2 = flag1;
                if (searchParameters != null)
                {
                    flag2 = flag1;
                    if (s.equals(searchParameters.sortOrder))
                    {
                        flag2 = true;
                    }
                }
                i++;
                flag1 = flag2;
            }
            if (searchParameters != null && !flag1)
            {
                searchParameters.sortOrder = null;
            }
        }
        if (flag)
        {
            ((SortOrderRefinementController)getController(DetailMode.SORT)).refreshAdapter();
        }
        addSyncSubscription("syncAuthChanged");
        addSyncSubscription("syncCountryChanged");
        addSyncSubscription("zipCode");
        addSyncSubscription(NearController.SYNC_NEAR_SUMMARY);
        if (searchActivitySync.isGbhSearch() || isUserWithoutPostalCode)
        {
            i = sortIndexNearest;
        } else
        {
            i = 0x7fffffff;
        }
        sortIndexToSkip = i;
    }

    private void updateSummary(DetailMode detailmode, TextView textview)
    {
        detailmode = getController(detailmode);
        if (!(detailmode instanceof SummarizableWithDefault))
        {
            return;
        }
        detailmode = (SummarizableWithDefault)detailmode;
        textview.setText(detailmode.getSummary());
        int i;
        if (detailmode.isDefault())
        {
            i = textLowlightColor;
        } else
        {
            i = textHighlightColor;
        }
        textview.setTextColor(i);
    }

    public void aspectUpdated(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect)
    {
        updateAspectSummary(aspect);
    }

    public boolean checkForPostalCode(String s, Bundle bundle)
    {
        if (TextUtils.isEmpty(searchParameters.buyerPostalCode))
        {
            PromptForStringDialogFragment.Show(getFragmentManager(), 0x7f07097e, 0x7f07097f, 0x7f07058a, s, bundle);
            return false;
        } else
        {
            return true;
        }
    }

    public void clearAspects()
    {
        aspectHistogram = null;
        clearAspectRows();
    }

    public void closeRefinement()
    {
        if (getActiveDetailController() != null)
        {
            deferredDetailMode = null;
            deferredDetailState = null;
            showRootRefinementPanel();
        }
    }

    public void commitDetail()
    {
        searchParamsUpdated();
        if (detailController.isOneShot())
        {
            drawerControl.closeDrawer(5);
        }
    }

    public DialogFragment createRetryDialog(int i, Bundle bundle)
    {
        Object obj = new com.ebay.app.AlertDialogFragment.Builder();
        ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setMessage(getString(0x7f070151));
        ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setPositiveButton(getString(0x7f070920));
        obj = ((com.ebay.app.AlertDialogFragment.Builder) (obj)).createFromFragment(i, this);
        if (bundle != null)
        {
            ((DialogFragment) (obj)).setArguments(bundle);
        }
        return ((DialogFragment) (obj));
    }

    public void fetchParentChain(long l)
    {
        FwLoaderManager fwloadermanager;
        if (l > 0L)
        {
            if ((fwloadermanager = getFwLoaderManager()).getRunningLoader(1) == null)
            {
                fwloadermanager.start(1, new GetCategoryInfoLoader(getFwActivity().getEbayContext(), EbayApiUtil.getShoppingApi(getActivity()), l), false);
                return;
            }
        }
    }

    public DetailController getActiveDetailController()
    {
        if (detailController != null && detailMode == detailController.getDetailMode())
        {
            return detailController;
        } else
        {
            return null;
        }
    }

    public EbayAspectHistogram getAspectHistogram()
    {
        return aspectHistogram;
    }

    public Long getCategoryParent(long l)
    {
        if (categoryToParent.containsKey(Long.valueOf(l)))
        {
            return (Long)categoryToParent.get(Long.valueOf(l));
        } else
        {
            return null;
        }
    }

    public EbayCategorySummary getCategorySummary(long l)
    {
        return (EbayCategorySummary)categoryToSummary.get(Long.valueOf(l));
    }

    public DetailController getController(DetailMode detailmode)
    {
        Object obj;
        boolean flag;
        obj = null;
        if (controllerMap.containsKey(detailmode))
        {
            detailmode = (DetailController)controllerMap.get(detailmode);
            detailmode.onSearchParametersUpdated(searchParameters, aspectHistogram, categoryHistogram);
            return detailmode;
        }
        flag = true;
        _cls1..SwitchMap.com.ebay.mobile.search.DetailMode[detailmode.ordinal()];
        JVM INSTR tableswitch 1 9: default 104
    //                   1 124
    //                   2 143
    //                   3 159
    //                   4 175
    //                   5 198
    //                   6 214
    //                   7 226
    //                   8 242
    //                   9 258;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        if (obj != null && flag)
        {
            controllerMap.put(detailmode, obj);
        }
        return ((DetailController) (obj));
_L2:
        obj = new AspectController(this, null, contentOptionDetailView);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new AuctionFormatRefinementController(this, contentOptionDetailView);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new ConditionController(this, contentOptionDetailView);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new PriceController(this);
        ((PriceController)obj).init(searchParameters);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new SortOrderRefinementController(this, contentOptionDetailView);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = new DeliveryOptionsController(this);
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new DistanceRefinementController(this, contentOptionDetailView);
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new ItemLocationController(this, contentOptionDetailView);
        continue; /* Loop/switch isn't completed */
_L10:
        obj = new NearController(this);
        if (true) goto _L1; else goto _L11
_L11:
    }

    public LayoutInflater getInflater()
    {
        return LayoutInflater.from(new ContextThemeWrapper(getActivity(), 0x7f0a002b));
    }

    public int getItemLocationIndex(SearchParameters searchparameters)
    {
        SearchParameters searchparameters1 = searchparameters;
        if (searchparameters == null)
        {
            searchparameters1 = searchParameters;
        }
        int i;
        if (!searchparameters1.country.isSite())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0 && searchparameters1.searchOtherCountries)
        {
            searchparameters = itemLocationWorldwide;
        } else
        if (searchparameters1.searchLocalCountryOnly)
        {
            searchparameters = itemLocationCurrentCountry;
        } else
        {
            searchparameters = itemLocationOnEbayCom;
        }
        for (i = 0; i < locationItems.size(); i++)
        {
            if (searchparameters == locationItems.get(i))
            {
                return i;
            }
        }

        return -1;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("detail"))
        {
            deferredDetailMode = DetailMode.valueOf(bundle.getString("detail"));
            deferredDetailState = bundle.getBundle("detailExtra");
            restoreDetail();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        rootCategoryPlaceholder.name = getString(0x7f07096c);
        rootCategorySummaryPlaceholder = new EbayCategorySummary(rootCategoryPlaceholder);
        if (!categoryToParent.containsKey(Long.valueOf(rootCategorySummaryPlaceholder.id)))
        {
            categoryToParent.put(Long.valueOf(rootCategorySummaryPlaceholder.id), null);
            categoryToSummary.put(Long.valueOf(rootCategorySummaryPlaceholder.id), rootCategorySummaryPlaceholder);
        }
        try
        {
            refinementUpdatedListener = (RefinementUpdatedListener)activity;
            searchActivitySync = (SearchActivitySync)activity;
            drawerControl = (DrawerControlListener)activity;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement interfaces: ").append(com/ebay/mobile/search/RefinementUpdatedListener.toString()).append(", ").append(com/ebay/mobile/search/SearchActivitySync.toString()).toString());
        }
        textHighlightColor = getActivity().getResources().getColor(0x7f0d00df);
        textLowlightColor = getActivity().getResources().getColor(0x7f0d00e7);
        if (activity instanceof SearchResultFragment.OnTrackingEventsListener)
        {
            trackingEventListener = (SearchResultFragment.OnTrackingEventsListener)activity;
        }
    }

    public void onClick(View view)
    {
        Object obj = view.getTag(0x7f10000f);
        if (obj != null)
        {
            view = ((View) (view.getTag(0x7f10000e)));
            if (view == null)
            {
                view = ((View) (obj));
            }
            refine(view, DetailLaunchMode.DEFAULT);
            return;
        } else
        {
            onClick(view.getId());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        AUCTION_FORMAT_ALL = new AuctionFormat(getString(0x7f07055e), 7, false);
        AUCTION_FORMAT_AUCTION = new AuctionFormat(getString(0x7f07055f), 5, false);
        AUCTION_FORMAT_BIN = new AuctionFormat(getString(0x7f070529), 6, false);
        AUCTION_FORMAT_ALL_BO = new AuctionFormat(getString(0x7f070523), 7, true);
        auctionFormats = (new AuctionFormat[] {
            AUCTION_FORMAT_ALL, AUCTION_FORMAT_AUCTION, AUCTION_FORMAT_BIN, AUCTION_FORMAT_ALL_BO
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = DeviceConfiguration.getAsync();
        isRefineCategoryHistoDisplayEnabledByDCS = layoutinflater.get(DcsBoolean.RefineDisplayCatHisto);
        viewgroup = LayoutInflater.from(new ContextThemeWrapper(getActivity(), 0x7f0a002b)).inflate(0x7f0301de, viewgroup, false);
        doneButton = viewgroup.findViewById(0x7f1005d1);
        doneButton.setOnClickListener(this);
        contentMainOptionsView = (ScrollView)viewgroup.findViewById(0x7f1005d6);
        contentCustomView = (FrameLayout)viewgroup.findViewById(0x7f1005d4);
        contentOptionDetailView = (ListView)viewgroup.findViewById(0x7f1005d5);
        headerPanelTitleView = (TextView)viewgroup.findViewById(0x7f1005d0);
        headerCategoryLayout = viewgroup.findViewById(0x7f1005d2);
        headerBackToParentPanel = (TextView)viewgroup.findViewById(0x7f1005cf);
        headerDetailTitleView = (TextView)viewgroup.findViewById(0x7f1005d3);
        headerBackToParentPanel.setOnClickListener(this);
        headerDetailTitleView.setOnClickListener(this);
        moreRefinementsContainer = (LinearLayout)viewgroup.findViewById(0x7f10059f);
        alwaysVisibleAspects = (LinearLayout)viewgroup.findViewById(0x7f100593);
        allLocalAspects = (LinearLayout)viewgroup.findViewById(0x7f100594);
        showMoreRefinementsContainer = viewgroup.findViewById(0x7f1005bb);
        showFewerRefinementsContainer = viewgroup.findViewById(0x7f1005be);
        showMoreRefinementsContainer.setOnClickListener(this);
        showFewerRefinementsContainer.setOnClickListener(this);
        getResources();
        updateSortOrders(false);
        viewModeList = (ImageView)viewgroup.findViewById(0x7f10058a);
        viewModeTile = (ImageView)viewgroup.findViewById(0x7f10058b);
        viewModeList.setOnClickListener(this);
        viewModeTile.setOnClickListener(this);
        selectorNear = viewgroup.findViewById(0x7f1005a0);
        textNear = (TextView)selectorNear.findViewById(0x7f1005a3);
        lockNear = (ImageView)selectorNear.findViewById(0x7f1005a1);
        dividerNear = viewgroup.findViewById(0x7f1005a4);
        lockNear.setOnClickListener(this);
        selectorNear.setOnClickListener(this);
        selectorBuyingFormat = viewgroup.findViewById(0x7f100595);
        textBuyingFormat = (TextView)selectorBuyingFormat.findViewById(0x7f100598);
        lockBuyingFormat = (ImageView)selectorBuyingFormat.findViewById(0x7f100596);
        lockBuyingFormat.setOnClickListener(this);
        selectorBuyingFormat.setOnClickListener(this);
        selectorSortOrder = viewgroup.findViewById(0x7f100583);
        textSortOrder = (TextView)selectorSortOrder.findViewById(0x7f100586);
        lockSortOrder = (ImageView)selectorSortOrder.findViewById(0x7f100584);
        lockSortOrder.setOnClickListener(this);
        selectorSortOrder.setOnClickListener(this);
        selectorCategory = viewgroup.findViewById(0x7f10058c);
        textCategory = (TextView)selectorCategory.findViewById(0x7f10058e);
        selectorCategory.setOnClickListener(this);
        ebayPlusOnlyLayout = viewgroup.findViewById(0x7f100590);
        toggleEbayPlusOnly = (CheckedTextView)viewgroup.findViewById(0x7f100591);
        lockEbayPlusOnly = (ImageView)viewgroup.findViewById(0x7f100592);
        toggleEbayPlusOnly.setOnClickListener(this);
        lockEbayPlusOnly.setOnClickListener(this);
        selectorCondition = viewgroup.findViewById(0x7f100304);
        textCondition = (TextView)selectorCondition.findViewById(0x7f100305);
        lockCondition = (ImageView)selectorCondition.findViewById(0x7f100599);
        lockCondition.setOnClickListener(this);
        selectorCondition.setOnClickListener(this);
        selectorPriceRange = viewgroup.findViewById(0x7f10059b);
        textPriceRange = (TextView)selectorPriceRange.findViewById(0x7f10059e);
        lockPriceRange = (ImageView)selectorPriceRange.findViewById(0x7f10059c);
        lockPriceRange.setOnClickListener(this);
        selectorPriceRange.setOnClickListener(this);
        selectorItemLocation = viewgroup.findViewById(0x7f1005a8);
        textItemLocation = (TextView)selectorItemLocation.findViewById(0x7f1005ab);
        lockItemLocation = (ImageView)selectorItemLocation.findViewById(0x7f1005a9);
        lockItemLocation.setOnClickListener(this);
        selectorItemLocation.setOnClickListener(this);
        selectorShipping = viewgroup.findViewById(0x7f100319);
        textShipping = (TextView)selectorShipping.findViewById(0x7f1002f1);
        lockShipping = (ImageView)selectorShipping.findViewById(0x7f1005a5);
        lockShipping.setOnClickListener(this);
        selectorShipping.setOnClickListener(this);
        toggleSoldItems = (CheckedTextView)viewgroup.findViewById(0x7f1005ae);
        lockSoldItems = (ImageView)viewgroup.findViewById(0x7f1005af);
        toggleCompletedItems = (CheckedTextView)viewgroup.findViewById(0x7f1005ac);
        lockCompletedItems = (ImageView)viewgroup.findViewById(0x7f1005ad);
        toggleDescriptionSearch = (CheckedTextView)viewgroup.findViewById(0x7f1005b1);
        lockDescriptionSearch = (ImageView)viewgroup.findViewById(0x7f1005b2);
        toggleReturnsAccepted = (CheckedTextView)viewgroup.findViewById(0x7f1005b5);
        lockReturnsAccepted = (ImageView)viewgroup.findViewById(0x7f1005b4);
        toggleCharity = (CheckedTextView)viewgroup.findViewById(0x7f1005b9);
        lockCharity = (ImageView)viewgroup.findViewById(0x7f1005b8);
        selectorReturnsAccepted = viewgroup.findViewById(0x7f1005b3);
        selectorCharity = viewgroup.findViewById(0x7f1005b7);
        ebayPlusOnlyDivider = viewgroup.findViewById(0x7f10058f);
        charityDivider = viewgroup.findViewById(0x7f1005ba);
        returnsAcceptedDivider = viewgroup.findViewById(0x7f1005b6);
        toggleSoldItems.setOnClickListener(this);
        lockSoldItems.setOnClickListener(this);
        toggleCompletedItems.setOnClickListener(this);
        lockCompletedItems.setOnClickListener(this);
        toggleDescriptionSearch.setOnClickListener(this);
        lockDescriptionSearch.setOnClickListener(this);
        toggleReturnsAccepted.setOnClickListener(this);
        lockReturnsAccepted.setOnClickListener(this);
        toggleCharity.setOnClickListener(this);
        lockCharity.setOnClickListener(this);
        resetButton = (Button)viewgroup.findViewById(0x7f1005c1);
        resetButton.setOnClickListener(this);
        disableMultiTouch(viewgroup);
        controllerMap.clear();
        locksEnabled = layoutinflater.get(DcsBoolean.SearchRefineLocking);
        locks = new RefinementLocks(getActivity());
        updateLocks();
        NOT_SPECIFIED_LABEL = getResources().getString(0x7f070953);
        itemConditionHelper = new ItemConditionHelper(viewgroup.getContext());
        return viewgroup;
    }

    public void onDetach()
    {
        super.onDetach();
        refinementUpdatedListener = null;
        searchActivitySync = null;
        for (Iterator iterator = syncSubscriptions.iterator(); iterator.hasNext(); ContentSyncManager.unregister(this, new String[] {
    (String)iterator.next()
})) { }
        syncSubscriptions.clear();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (j != 1)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            fetchParentChain(getDialogExtra(dialogfragment).getLong("lInt"));
            return;

        case 39: // '\''
            hasUserSelectedAllCategories = false;
            break;
        }
        if (searchActivitySync.getSearchViewType() != 0)
        {
            searchActivitySync.setSearchViewType(0);
        }
        searchActivitySync.resetSearchParameters(searchParameters.keywords);
        RefinementLocks.unlockAll();
    }

    public void onPause()
    {
        DetailController detailcontroller = getActiveDetailController();
        if (detailcontroller != null)
        {
            deferredDetailMode = detailcontroller.getDetailMode();
            deferredDetailState = detailcontroller.getStateExtras();
            detailcontroller.onPause();
        }
        super.onPause();
    }

    public void onPromptForStringCompleted(String s, boolean flag, String s1, Bundle bundle)
    {
        if (!TextUtils.isEmpty(s1) && s1.equals("SearchRefineFragment.reason.setSortOrder"))
        {
            if (!flag)
            {
                setSortOrder(getSortOrderBySetting(bundle.getString("refineReqSortKey")), false);
            }
            refreshRefinementView();
        }
        if (detailController instanceof PromptForStringDialogFragment.PromptForStringCompletedListener)
        {
            ((PromptForStringDialogFragment.PromptForStringCompletedListener)detailController).onPromptForStringCompleted(s, flag, s1, bundle);
        }
        updateContent("zipCode", s);
    }

    public void onResume()
    {
        DetailController detailcontroller;
        boolean flag;
        boolean flag1;
label0:
        {
            super.onResume();
            detailcontroller = getActiveDetailController();
            if (searchParameters != null && detailcontroller != null)
            {
                if (controllerMap.get(detailMode) == detailcontroller)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!(detailcontroller instanceof CheckedDetailController) || ((CheckedDetailController)detailcontroller).getListView() == contentOptionDetailView)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (detailcontroller.getDetailMode() != DetailMode.CATEGORIES)
                {
                    break label0;
                }
                refineCurrentCategory();
            }
            return;
        }
        if (flag || flag1)
        {
            if (detailcontroller.getDetailMode() == deferredDetailMode)
            {
                detailcontroller.setStateExtras(deferredDetailState);
                deferredDetailMode = null;
                deferredDetailState = null;
            }
            showDetails(detailcontroller);
            return;
        } else
        {
            refreshRefinementView();
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (detailMode != null)
        {
            bundle.putString("detail", detailMode.toString());
            if (detailController != null)
            {
                Bundle bundle1 = detailController.getStateExtras();
                if (bundle1 != null)
                {
                    bundle.putBundle("detailExtra", bundle1);
                }
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSearchContextChanged()
    {
        hasUserSelectedAllCategories = false;
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (fwloader instanceof GetCategoryInfoLoader)
        {
            GetCategoryInfoLoader getcategoryinfoloader = (GetCategoryInfoLoader)fwloader;
            if (!getcategoryinfoloader.isError())
            {
                GetCategoryInfoResponse getcategoryinforesponse = (GetCategoryInfoResponse)getcategoryinfoloader.getResponse();
                if (getcategoryinforesponse.categories.size() > 0 && i == 1)
                {
                    reconstructCategoryAncestry(getcategoryinforesponse.categories);
                }
            } else
            {
                Bundle bundle = null;
                if (i == 1)
                {
                    bundle = new Bundle();
                    bundle.putLong("lInt", getcategoryinfoloader.categoryId);
                }
                createRetryDialog(i, bundle);
            }
        }
        super.onTaskComplete(i, fwloader);
    }

    public void populateItemLocations()
    {
        if (locationItems != null)
        {
            return;
        }
        String s = EbayCountryManager.getCountryName(getResources(), searchParameters.country);
        String s1 = searchParameters.country.getSiteDomain().replace("ebay", getString(0x7f07016b));
        itemLocationCurrentCountry = new ItemLocation(getString(0x7f070596, new Object[] {
            s
        }), ItemLocationRelativeLocale.CURRENT_COUNTRY);
        itemLocationWorldwide = new ItemLocation(getString(0x7f0705a7), ItemLocationRelativeLocale.WORLDWIDE);
        itemLocationOnEbayCom = new ItemLocation(getString(0x7f070597, new Object[] {
            s1
        }), ItemLocationRelativeLocale.ON_EBAY);
        locationItems = new ArrayList();
        locationItems.add(itemLocationCurrentCountry);
        if (!searchActivitySync.isGbhSearch())
        {
            locationItems.add(itemLocationWorldwide);
        }
        locationItems.add(itemLocationOnEbayCom);
    }

    public boolean refine(Object obj, DetailLaunchMode detaillaunchmode)
    {
        if (obj instanceof com.ebay.common.model.search.EbayAspectHistogram.Aspect)
        {
            Bundle bundle = new Bundle();
            bundle.putString("aspect", ((com.ebay.common.model.search.EbayAspectHistogram.Aspect)obj).name);
            showDetail(DetailMode.ASPECTS, bundle, detaillaunchmode);
        } else
        if (obj instanceof DetailMode)
        {
            obj = (DetailMode)obj;
            if (obj == DetailMode.ROOT)
            {
                showRootRefinementPanel();
                return true;
            }
            if (detailModeToViewId.containsKey(obj))
            {
                onClick(((Integer)detailModeToViewId.get(obj)).intValue(), detaillaunchmode);
                return true;
            }
        }
        return true;
    }

    public void reset()
    {
        showRootRefinementPanel();
    }

    public void searchParamsUpdated()
    {
        if (searchParameters.category == null && TextUtils.isEmpty(searchParameters.keywords) && searchParameters.productId == null && searchParameters.sellerId == null && searchParameters.sellerOffer == null)
        {
            return;
        } else
        {
            refinementUpdatedListener.onSearchRefinement(searchParameters, aspectHistogram);
            updateLocks();
            return;
        }
    }

    public boolean searchRequiresExplicitRootCategory()
    {
        return hasUserSelectedAllCategories && searchParameters.category == null;
    }

    public boolean setBuyingFormat(int i, boolean flag)
    {
        boolean flag1;
        if (searchParameters.buyingFormat != i || searchParameters.bestOfferOnly != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i;
        JVM INSTR tableswitch 5 7: default 52
    //                   5 144
    //                   6 165
    //                   7 106;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_165;
_L1:
        searchParameters.buyingFormat = 7;
        textBuyingFormat.setText(0x7f07055e);
_L5:
        searchParameters.bestOfferOnly = flag;
        if (i == 7 && !flag)
        {
            textBuyingFormat.setTextColor(textLowlightColor);
            return flag1;
        } else
        {
            textBuyingFormat.setTextColor(textHighlightColor);
            return flag1;
        }
_L4:
        searchParameters.buyingFormat = i;
        if (flag)
        {
            textBuyingFormat.setText(0x7f070523);
        } else
        {
            textBuyingFormat.setText(0x7f07096b);
        }
          goto _L5
_L2:
        searchParameters.buyingFormat = i;
        textBuyingFormat.setText(0x7f07055f);
          goto _L5
        searchParameters.buyingFormat = i;
        textBuyingFormat.setText(0x7f070529);
          goto _L5
    }

    public boolean setCategory(EbayCategorySummary ebaycategorysummary, boolean flag)
    {
        if (ebaycategorysummary == null || ebaycategorysummary.id <= 0L)
        {
            categoryToParent.put(Long.valueOf(rootCategorySummaryPlaceholder.id), null);
            categoryToSummary.put(Long.valueOf(rootCategorySummaryPlaceholder.id), rootCategorySummaryPlaceholder);
            searchParameters.category = null;
            textCategory.setText(0x7f07002d);
            textCategory.setTextColor(textLowlightColor);
            return false;
        }
        if (!categoryToParent.containsKey(Long.valueOf(ebaycategorysummary.id)))
        {
            if (flag && searchParameters.category != null && searchParameters.category.id != ebaycategorysummary.id)
            {
                categoryToParent.put(Long.valueOf(ebaycategorysummary.id), Long.valueOf(searchParameters.category.id));
            }
            categoryToSummary.put(Long.valueOf(ebaycategorysummary.id), ebaycategorysummary);
        }
        if (ebaycategorysummary.name == null)
        {
            ebaycategorysummary.name = String.valueOf(ebaycategorysummary.id);
        }
        textCategory.setText(ebaycategorysummary.name);
        textCategory.setTextColor(textHighlightColor);
        if (searchParameters.category == null || searchParameters.category.id != ebaycategorysummary.id)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchParameters.category = ebaycategorysummary;
        return flag;
    }

    public void setCategoryParentHeader(String s, Boolean boolean1, Boolean boolean2, Boolean boolean3)
    {
        if (s != null)
        {
            headerDetailTitleView.setText(s);
        }
        if (boolean1 != null)
        {
            headerDetailTitleView.setEnabled(boolean1.booleanValue());
        }
        int i;
        if (boolean2 != null)
        {
            s = headerCategoryLayout;
            if (boolean2.booleanValue())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            s.setVisibility(i);
        }
        if (boolean3 != null)
        {
            s = headerDetailTitleView;
            if (boolean3.booleanValue())
            {
                i = 0x7f0201be;
            } else
            {
                i = 0;
            }
            s.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        }
    }

    public boolean setCondition(String s)
    {
        String s1 = searchParameters.condition;
        s = itemConditionHelper.getCondition(s);
        textCondition.setText(((com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemCondition) (s)).displayValue);
        Object obj = textCondition;
        int i;
        if (((com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemCondition) (s)).state == com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemConditionState.ANY)
        {
            i = textLowlightColor;
        } else
        {
            i = textHighlightColor;
        }
        ((TextView) (obj)).setTextColor(i);
        obj = searchParameters;
        if (((com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemCondition) (s)).state != com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemConditionState.ANY)
        {
            s = ((com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemCondition) (s)).constraintValue;
        } else
        {
            s = null;
        }
        obj.condition = s;
        return !TextUtils.equals(s1, searchParameters.condition);
    }

    public boolean setItemLocation(ItemLocation itemlocation)
    {
        ItemLocation itemlocation1 = itemlocation;
        if (itemlocation == null)
        {
            itemlocation1 = (ItemLocation)locationItems.get(getItemLocationIndex(null));
        }
        if (itemlocation1 == locationItems.get(getItemLocationIndex(searchParameters)))
        {
            return false;
        }
        searchParameters.searchLocalCountryOnly = false;
        searchParameters.searchOtherCountries = false;
        if (itemlocation1.tag == ItemLocationRelativeLocale.WORLDWIDE)
        {
            searchParameters.searchOtherCountries = true;
        } else
        if (itemlocation1.tag == ItemLocationRelativeLocale.CURRENT_COUNTRY)
        {
            searchParameters.searchLocalCountryOnly = true;
        } else
        if (itemlocation1.tag != ItemLocationRelativeLocale.ON_EBAY);
        return true;
    }

    public boolean setPrice(ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        boolean flag;
        boolean flag1;
label0:
        {
            boolean flag2 = true;
            boolean flag4 = false;
            boolean flag3;
            if (searchParameters.minPrice == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (itemcurrency == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag == flag1)
            {
                flag3 = flag4;
                if (itemcurrency == null)
                {
                    break label0;
                }
                flag3 = flag4;
                if (itemcurrency.equals(searchParameters.minPrice))
                {
                    break label0;
                }
            }
            searchParameters.minPrice = itemcurrency;
            flag3 = true;
        }
label1:
        {
            if (searchParameters.maxPrice == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (itemcurrency1 == null)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            if (flag == flag1)
            {
                flag4 = flag3;
                if (itemcurrency1 == null)
                {
                    break label1;
                }
                flag4 = flag3;
                if (itemcurrency1.equals(searchParameters.maxPrice))
                {
                    break label1;
                }
            }
            searchParameters.maxPrice = itemcurrency1;
            flag4 = true;
        }
        return flag4;
    }

    public void setSearchParameters(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        searchParameters = searchparameters;
        categoryHistogram = ebaycategoryhistogram;
        aspectHistogram = ebayaspecthistogram;
        long l1;
        if (categoryHistogram != null)
        {
            searchparameters = categoryHistogram.getBreadCrumb();
        } else
        {
            searchparameters = null;
        }
        if (searchparameters == null) goto _L2; else goto _L1
_L1:
        ebayaspecthistogram = categoryToParent;
        l1 = searchParameters.category.id;
        long l;
        if (((com.ebay.common.model.search.EbayCategoryHistogram.BreadCrumb) (searchparameters)).categoryId <= 0L)
        {
            l = rootCategorySummaryPlaceholder.id;
        } else
        {
            l = ((com.ebay.common.model.search.EbayCategoryHistogram.BreadCrumb) (searchparameters)).categoryId;
        }
        ebayaspecthistogram.put(Long.valueOf(l1), Long.valueOf(l));
        categoryToSummary.put(Long.valueOf(((com.ebay.common.model.search.EbayCategoryHistogram.BreadCrumb) (searchparameters)).categoryId), new EbayCategorySummary(((com.ebay.common.model.search.EbayCategoryHistogram.BreadCrumb) (searchparameters)).categoryId, ((com.ebay.common.model.search.EbayCategoryHistogram.BreadCrumb) (searchparameters)).displayName));
_L4:
        if (categoryHistogram != null && categoryHistogram.categories != null)
        {
            for (searchparameters = categoryHistogram.categories.iterator(); searchparameters.hasNext(); categoryToSummary.put(Long.valueOf(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (ebayaspecthistogram)).id), new EbayCategorySummary(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (ebayaspecthistogram)).id, ((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (ebayaspecthistogram)).name)))
            {
                ebayaspecthistogram = (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)searchparameters.next();
                categoryToParent.put(Long.valueOf(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (ebayaspecthistogram)).id), Long.valueOf(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (ebayaspecthistogram)).parentId));
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (searchParameters.category != null)
        {
            categoryToParent.put(Long.valueOf(searchParameters.category.id), Long.valueOf(rootCategorySummaryPlaceholder.id));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (searchParameters.category != null && searchParameters.category.id == 0L)
        {
            searchParameters.category = null;
        }
        if (isVisible())
        {
            updateDataState();
        } else
        {
            shouldUpdateStateWhenVisible = true;
        }
        if (detailController != null && detailMode != DetailMode.NONE)
        {
            detailController.onSearchParametersUpdated(searchParameters, aspectHistogram, categoryHistogram);
        }
        restoreDetail();
        updateLocks();
        return;
    }

    public SortOrder setSortOrder(SortOrder sortorder, boolean flag)
    {
        SortOrder sortorder1 = getSortOrderBySetting(searchParameters.sortOrder);
        if (sortorder != null) goto _L2; else goto _L1
_L1:
        return sortorder1;
_L2:
        boolean flag2;
        boolean flag3 = true;
        flag2 = flag3;
        if (!sortorder.sortOrder.equals("DistanceNearest"))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (MyApp.getPrefs().getPostalCode() != null)
        {
            flag2 = flag3;
            if (!TextUtils.isEmpty(MyApp.getPrefs().getPostalCode().postalCode))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("refineReqSortKey", sortorder.sortOrder);
        flag2 = checkForPostalCode("SearchRefineFragment.reason.setSortOrder", bundle);
        if (!flag2 || getSortIndex(sortorder) == sortIndexToSkip) goto _L1; else goto _L3
_L3:
        boolean flag1;
        if (searchParameters.sortOrder == null || !searchParameters.sortOrder.equals(sortorder.sortOrder))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        searchParameters.sortOrder = sortorder.sortOrder;
        textSortOrder.setText(sortorder.Label);
        if (sortorder != defaultSortOrder)
        {
            textSortOrder.setTextColor(textHighlightColor);
        } else
        {
            textSortOrder.setTextColor(textLowlightColor);
        }
        if (!flag1)
        {
            sortorder = null;
        }
        return sortorder;
    }

    public void setUserSelectedAllCategories()
    {
        hasUserSelectedAllCategories = true;
    }

    public void showCategoryDetails(DetailController detailcontroller)
    {
        showDetails(detailcontroller);
    }

    public void showDetail(DetailMode detailmode)
    {
        showDetail(detailmode, null, DetailLaunchMode.DEFAULT);
    }

    public void showDetail(DetailMode detailmode, DetailLaunchMode detaillaunchmode)
    {
        showDetail(detailmode, null, detaillaunchmode);
    }

    public void showRootRefinementPanel()
    {
        if (detailController != null)
        {
            detailController.onPause();
        }
        contentMainOptionsView.setVisibility(0);
        contentCustomView.setVisibility(4);
        contentOptionDetailView.setVisibility(4);
        headerBackToParentPanel.setVisibility(4);
        headerCategoryLayout.setVisibility(8);
        headerPanelTitleView.setText(0x7f070981);
        detailMode = DetailMode.NONE;
    }

    public void updateAspectSummary(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect)
    {
        Object obj = (View)localAspectToView.get(aspect.name);
        if (obj != null)
        {
            obj = (TextView)((View) (obj)).findViewById(0x7f1005cc);
            ((TextView) (obj)).setText(AspectController.getSummary(aspect));
            int i;
            if (AspectController.isConfigured(aspect))
            {
                i = textHighlightColor;
            } else
            {
                i = textLowlightColor;
            }
            ((TextView) (obj)).setTextColor(i);
        }
    }

    public void updateContent(String s, Object obj)
    {
        Iterator iterator;
        if (s.equals("syncAuthChanged") || s.equals("syncCountryChanged"))
        {
            updateSortOrders(false);
        } else
        {
            if (searchActivitySync.isGbhSearch() || !s.equals("syncShippingSummary"))
            {
                continue; /* Loop/switch isn't completed */
            }
            updateSummary(DetailMode.DELIVERY_OPTIONS, textShipping);
        }
_L3:
        obj = new HashSet();
        iterator = controllerMap.entrySet().iterator();
        boolean flag;
        boolean flag1;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((DetailController)entry.getValue()).getContentSyncKeys().indexOf(s) != -1)
            {
                ((Set) (obj)).add(entry.getKey());
            }
        } while (true);
        DetailMode detailmode;
        for (s = ((Set) (obj)).iterator(); s.hasNext(); controllerMap.remove(detailmode))
        {
            detailmode = (DetailMode)s.next();
        }

          goto _L1
        if (!s.equals("zipCode")) goto _L3; else goto _L2
_L2:
        if (!TextUtils.isEmpty((String)obj)) goto _L5; else goto _L4
_L4:
        if (!TextUtils.isEmpty(searchParameters.sortOrder) && searchParameters.sortOrder.equals("DistanceNearest") && TextUtils.isEmpty(searchParameters.buyerPostalCode))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (sortIndexToSkip != 0x7fffffff && searchParameters.sortOrder.equals(sortOrders[sortIndexToSkip].sortOrder))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag && !flag1) goto _L7; else goto _L6
_L6:
        setSortOrder(defaultSortOrder, false);
        searchParamsUpdated();
_L11:
        updateSortOrders(false);
_L9:
        return;
_L7:
        s = getActiveDetailController();
        if (s != null)
        {
            s.onSearchParametersUpdated(searchParameters, aspectHistogram, categoryHistogram);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        searchParameters.buyerPostalCode = (String)obj;
        searchParamsUpdated();
        continue; /* Loop/switch isn't completed */
_L1:
        if (detailController == null || detailMode != detailController.getDetailMode() || !((Set) (obj)).contains(detailMode)) goto _L9; else goto _L8
_L8:
        showDetail(detailMode);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void updatePanelState()
    {
        if (shouldUpdateStateWhenVisible)
        {
            updateDataState();
        }
    }

    public void updateViewModeIcons()
    {
        switch (searchActivitySync.getSearchViewType())
        {
        default:
            return;

        case 0: // '\0'
            viewModeList.setImageResource(SearchActivitySync.viewIconsSelected.get(0));
            viewModeTile.setImageResource(SearchActivitySync.viewIconsUnselected.get(1));
            return;

        case 1: // '\001'
            viewModeList.setImageResource(SearchActivitySync.viewIconsUnselected.get(0));
            break;
        }
        viewModeTile.setImageResource(SearchActivitySync.viewIconsSelected.get(1));
    }

    static 
    {
        rootCategoryPlaceholder = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
        rootCategoryPlaceholder.id = 0L;
        detailModeToViewId = new HashMap();
        detailModeToViewId.put(DetailMode.CONDITION, Integer.valueOf(0x7f100304));
        detailModeToViewId.put(DetailMode.AUCTION_FORMAT, Integer.valueOf(0x7f100595));
        detailModeToViewId.put(DetailMode.CATEGORIES, Integer.valueOf(0x7f10058c));
        detailModeToViewId.put(DetailMode.SL_ITEMLOCATION, Integer.valueOf(0x7f1005a8));
        detailModeToViewId.put(DetailMode.SORT, Integer.valueOf(0x7f100583));
    }
}
