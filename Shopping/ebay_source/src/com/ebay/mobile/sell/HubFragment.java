// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.sell.hubitem.CategoryHubItem;
import com.ebay.mobile.sell.hubitem.ConditionHubItem;
import com.ebay.mobile.sell.hubitem.CustomHubItem;
import com.ebay.mobile.sell.hubitem.DescriptionHubItem;
import com.ebay.mobile.sell.hubitem.FormatPriceHubItem;
import com.ebay.mobile.sell.hubitem.ItemSpecificsHubItem;
import com.ebay.mobile.sell.hubitem.PhotosHubItem;
import com.ebay.mobile.sell.hubitem.PreferencesHubItem;
import com.ebay.mobile.sell.hubitem.ShippingHubItem;
import com.ebay.mobile.sell.hubitem.TitleHubItem;
import com.ebay.mobile.sell.widget.CustomScrollView;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.sell:
//            HubDisplayState, SpokeCompletedState, SpokeLauncher, BaseSpokeFragment, 
//            PhotosSpokeFragment, ListingFragmentActivity

public class HubFragment extends BaseFragment
    implements android.app.FragmentManager.OnBackStackChangedListener, android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    public static final String CURRENT_FRAGMENT = "currentFragment";
    private static final String STATE_SCROLL = "scroll";
    private int cachedScrollValue;
    private CategoryHubItem categoryHubItem;
    private ConditionHubItem conditionHubItem;
    private ListingDraftContent content;
    private DescriptionHubItem descriptionHubItem;
    private final HubDisplayState displayState = new HubDisplayState();
    private ListingDraftDataManager dm;
    private ListingDraft draft;
    private FormatPriceHubItem formatPriceHubItem;
    private ImageView headerImage;
    private TextView headerText;
    private ImageCache imageCache;
    private ItemSpecificsHubItem itemSpecificsHubItem;
    private PhotosHubItem photosHubItem;
    private PreferencesHubItem preferencesHubItem;
    private CustomScrollView scrollView;
    private ShippingHubItem shippingHubItem;
    private final SpokeCompletedState spokeState = new SpokeCompletedState();
    private TitleHubItem titleHubItem;
    private boolean wasFragmentRetained;

    public HubFragment()
    {
        wasFragmentRetained = false;
        cachedScrollValue = 0;
    }

    private void drawState()
    {
        if (headerText != null)
        {
            headerText.setText(displayState.titleValue);
        }
        if (displayState.photoUrlValue != null)
        {
            if (headerImage != null)
            {
                imageCache.setImage(headerImage, displayState.photoUrlValue);
            }
        } else
        if (headerImage != null)
        {
            headerImage.setImageResource(0x7f0201f5);
        }
        titleHubItem.setDisplayFromState(displayState, spokeState.titleSpokeCompleted);
        conditionHubItem.setDisplayFromState(displayState, spokeState.conditionSpokeCompleted);
        photosHubItem.setDisplayFromState(displayState, spokeState.photoSpokeCompleted);
        categoryHubItem.setDisplayFromState(displayState, spokeState.categorySpokeCompleted);
        descriptionHubItem.setDisplayFromState(displayState, spokeState.descriptionSpokeCompleted);
        preferencesHubItem.setDisplayFromState(displayState, spokeState.preferencesSpokeCompleted);
        formatPriceHubItem.setDisplayFromState(displayState, spokeState.formatPriceSpokeCompleted);
        if (isAdded())
        {
            boolean flag;
            if (draft != null && content.hasSpecificsGuidance)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            itemSpecificsHubItem.setDisplayFromState(displayState, spokeState.itemSpecificsSpokeCompleted, flag);
            if (draft != null && content.shippingRecommendation != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            shippingHubItem.setDisplayFromState(displayState, spokeState.shippingSpokeCompleted, flag);
        }
    }

    public void clearHubSelection()
    {
        photosHubItem.resetSelectedBackground();
        titleHubItem.resetSelectedBackground();
        categoryHubItem.resetSelectedBackground();
        conditionHubItem.resetSelectedBackground();
        descriptionHubItem.resetSelectedBackground();
        formatPriceHubItem.resetSelectedBackground();
        shippingHubItem.resetSelectedBackground();
        preferencesHubItem.resetSelectedBackground();
        itemSpecificsHubItem.resetSelectedBackground();
    }

    public void launchPhotosSpoke()
    {
        SpokeLauncher.launchPhotosOnLoad(this);
    }

    public void launchPhotosSpokeForNotification()
    {
        SpokeLauncher.launchPhotosForUploadNotification(this);
    }

    public void navigateToValidationErrorLocation(String s)
    {
        SpokeLauncher.launchFromValidationError(this, s);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (wasFragmentRetained)
        {
            return;
        }
        wasFragmentRetained = true;
        imageCache = new ImageCache(getActivity());
        getFragmentManager().addOnBackStackChangedListener(this);
        if (bundle == null)
        {
            scrollView.setVisibility(8);
            return;
        } else
        {
            cachedScrollValue = bundle.getInt("scroll");
            scrollView.scrollTo(0, cachedScrollValue);
            Util.hideSoftInput(getView().getContext(), scrollView);
            return;
        }
    }

    public void onBackStackChanged()
    {
        if (getFragmentManager().getBackStackEntryCount() == 0 && getResources().getBoolean(0x7f0b0006))
        {
            clearHubSelection();
        }
    }

    public void onClick(View view)
    {
        if (!isDetached())
        {
            Util.hideSoftInput(view.getContext(), view);
            if (view.getId() == 0x7f10064b)
            {
                view = getFragmentManager().findFragmentByTag("currentFragment");
                if (view instanceof BaseSpokeFragment)
                {
                    ((BaseSpokeFragment)view).saveOutstandingChanges(true);
                    return;
                }
                if (view instanceof PhotosSpokeFragment)
                {
                    ((PhotosSpokeFragment)view).saveOutstandingChanges(true);
                    return;
                } else
                {
                    dm.validateDraft();
                    return;
                }
            }
            if (view.getId() == 0x7f10064a)
            {
                getActivity().onBackPressed();
                return;
            }
            if (view.getId() == 0x7f100650)
            {
                SpokeLauncher.launchFromViewClick(this, titleHubItem);
                return;
            }
            if (view.getId() == 0x7f10064e)
            {
                SpokeLauncher.launchFromViewClick(this, photosHubItem);
                return;
            }
            if (view instanceof CustomHubItem)
            {
                SpokeLauncher.launchFromViewClick(this, (CustomHubItem)view);
                return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        drawState();
        super.onConfigurationChanged(configuration);
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        } else
        {
            content = listingdraftcontent;
            draft = (ListingDraft)listingdraftcontent.getData();
            displayState.update(listingdraftcontent, ((ListingFragmentActivity)getActivity()).getEbayContext());
            spokeState.update(listingdraftcontent);
            drawState();
            scrollView.setVisibility(0);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030204, null);
        layoutinflater.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        return layoutinflater;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (ListingDraftDataManager)datamanagercontainer.initialize((com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params"), this);
    }

    public void onResume()
    {
        super.onResume();
        drawState();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (scrollView != null)
        {
            bundle.putInt("scroll", scrollView.getScrollY());
        } else
        {
            bundle.putInt("scroll", cachedScrollValue);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ((ContainerLayout)view.findViewById(0x7f100651)).setMotionEventSplittingEnabled(false);
        ((ViewGroup)view).setMotionEventSplittingEnabled(false);
        scrollView = (CustomScrollView)view.findViewById(0x7f1004bc);
        ((ViewGroup)scrollView.findViewById(0x7f10064d)).setMotionEventSplittingEnabled(false);
        ((ViewGroup)scrollView.getChildAt(0)).setMotionEventSplittingEnabled(false);
        headerText = (TextView)view.findViewById(0x7f100650);
        if (headerText != null)
        {
            headerText.setOnClickListener(this);
        }
        headerImage = (ImageView)view.findViewById(0x7f10064f);
        bundle = view.findViewById(0x7f10064e);
        if (bundle != null)
        {
            bundle.setOnClickListener(this);
        }
        photosHubItem = (PhotosHubItem)view.findViewById(0x7f100712);
        titleHubItem = (TitleHubItem)view.findViewById(0x7f100713);
        shippingHubItem = (ShippingHubItem)view.findViewById(0x7f100719);
        categoryHubItem = (CategoryHubItem)view.findViewById(0x7f100714);
        conditionHubItem = (ConditionHubItem)view.findViewById(0x7f100715);
        descriptionHubItem = (DescriptionHubItem)view.findViewById(0x7f100717);
        formatPriceHubItem = (FormatPriceHubItem)view.findViewById(0x7f100718);
        preferencesHubItem = (PreferencesHubItem)view.findViewById(0x7f10071a);
        itemSpecificsHubItem = (ItemSpecificsHubItem)view.findViewById(0x7f100716);
        if (getResources().getBoolean(0x7f0b0006))
        {
            clearHubSelection();
        }
        view.findViewById(0x7f10064a).setOnClickListener(this);
        view.findViewById(0x7f10064b).setOnClickListener(this);
        shippingHubItem.setOnClickListener(this);
        photosHubItem.setOnClickListener(this);
        titleHubItem.setOnClickListener(this);
        categoryHubItem.setOnClickListener(this);
        conditionHubItem.setOnClickListener(this);
        descriptionHubItem.setOnClickListener(this);
        formatPriceHubItem.setOnClickListener(this);
        preferencesHubItem.setOnClickListener(this);
        itemSpecificsHubItem.setOnClickListener(this);
    }
}
