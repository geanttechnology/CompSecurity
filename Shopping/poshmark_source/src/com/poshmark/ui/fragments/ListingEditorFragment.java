// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.ShareBannerInfo;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.data_model.models.inner_models.Picture;
import com.poshmark.db.DbApi;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.ColorSelectionView;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMEditListingImageSelectorView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.ListingManager;
import com.poshmark.utils.MediaScannerWrapper;
import com.poshmark.utils.RemoveEditListingImageListener;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;
import com.poshmark.utils.view_holders.ListingEditorViewHolder;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, CameraPreviewFragment, ListingEditorShareFragment, EditListingImageFragment, 
//            MappPageFragment, CategoryListFragment, MetaItemListViewFragment, ListingConditionPickerFragment, 
//            ColorPickerFragment

public class ListingEditorFragment extends PMFragment
{
    static final class LISTING_STATES extends Enum
    {

        private static final LISTING_STATES $VALUES[];
        public static final LISTING_STATES EDIT_LISTING;
        public static final LISTING_STATES EDIT_PHOTO;
        public static final LISTING_STATES FILTER_PHOTO;
        public static final LISTING_STATES GET_AVAILABILITY_STATUS;
        public static final LISTING_STATES GET_BRAND;
        public static final LISTING_STATES GET_CATEGORY;
        public static final LISTING_STATES GET_COLOR;
        public static final LISTING_STATES GET_CONDITION_STATUS;
        public static final LISTING_STATES GET_SIZE;
        public static final LISTING_STATES LISTING_SETUP_STATE;
        public static final LISTING_STATES NEW_PHOTO;
        public static final LISTING_STATES SHARE_LISTING;

        public static LISTING_STATES valueOf(String s)
        {
            return (LISTING_STATES)Enum.valueOf(com/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES, s);
        }

        public static LISTING_STATES[] values()
        {
            return (LISTING_STATES[])$VALUES.clone();
        }

        static 
        {
            LISTING_SETUP_STATE = new LISTING_STATES("LISTING_SETUP_STATE", 0);
            EDIT_LISTING = new LISTING_STATES("EDIT_LISTING", 1);
            EDIT_PHOTO = new LISTING_STATES("EDIT_PHOTO", 2);
            FILTER_PHOTO = new LISTING_STATES("FILTER_PHOTO", 3);
            NEW_PHOTO = new LISTING_STATES("NEW_PHOTO", 4);
            GET_BRAND = new LISTING_STATES("GET_BRAND", 5);
            GET_SIZE = new LISTING_STATES("GET_SIZE", 6);
            GET_COLOR = new LISTING_STATES("GET_COLOR", 7);
            GET_CATEGORY = new LISTING_STATES("GET_CATEGORY", 8);
            GET_CONDITION_STATUS = new LISTING_STATES("GET_CONDITION_STATUS", 9);
            GET_AVAILABILITY_STATUS = new LISTING_STATES("GET_AVAILABILITY_STATUS", 10);
            SHARE_LISTING = new LISTING_STATES("SHARE_LISTING", 11);
            $VALUES = (new LISTING_STATES[] {
                LISTING_SETUP_STATE, EDIT_LISTING, EDIT_PHOTO, FILTER_PHOTO, NEW_PHOTO, GET_BRAND, GET_SIZE, GET_COLOR, GET_CATEGORY, GET_CONDITION_STATUS, 
                GET_AVAILABILITY_STATUS, SHARE_LISTING
            });
        }

        private LISTING_STATES(String s, int i)
        {
            super(s, i);
        }
    }

    class NewListingId
    {

        String id;
        final ListingEditorFragment this$0;

        NewListingId()
        {
            this$0 = ListingEditorFragment.this;
            super();
        }
    }


    int DEFAULT_REQUEST_CODE;
    android.view.View.OnClickListener commonImageClickListener;
    android.view.View.OnClickListener createListingButtonListener;
    int currentActiveImageIndex;
    PMEditListingImageSelectorView currentActiveImageView;
    LISTING_STATES currentState;
    RemoveEditListingImageListener deleteButtonClickListener;
    boolean handlingUserTap;
    List imageList;
    boolean isListingDeleted;
    boolean isNFSEnabled;
    boolean isNewListing;
    ListingDetails listingDetails;
    String listingId;
    NewListing newListing;
    private android.view.View.OnTouchListener otl;
    String shareBanner;
    File storage_path;
    ListingEditorViewHolder viewHolder;

    public ListingEditorFragment()
    {
        DEFAULT_REQUEST_CODE = 1;
        currentState = LISTING_STATES.LISTING_SETUP_STATE;
        isNewListing = false;
        newListing = new NewListing();
        listingId = null;
        currentActiveImageIndex = 0;
        imageList = new ArrayList();
        handlingUserTap = false;
        isNFSEnabled = false;
        isListingDeleted = false;
        shareBanner = null;
        commonImageClickListener = new android.view.View.OnClickListener() {

            final ListingEditorFragment this$0;

            public void onClick(View view)
            {
label0:
                {
                    if (!handlingUserTap)
                    {
                        handlingUserTap = true;
                        hideKeyboard();
                        view = (PMEditListingImageSelectorView)view;
                        if (view.isNextSelector() || view.isImageSet())
                        {
                            break label0;
                        }
                        handlingUserTap = false;
                    }
                    return;
                }
                currentActiveImageView = view;
                currentActiveImageIndex = ((Integer)currentActiveImageView.getTag()).intValue();
                handleNewState(null);
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        };
        createListingButtonListener = new android.view.View.OnClickListener() {

            final ListingEditorFragment this$0;

            public void onClick(View view)
            {
                hideKeyboard();
                if (!validInput())
                {
                    return;
                }
                view = FeatureManager.getGlobalFeatureManager().getListingFeature();
                if (!view.isValidSellingPrice(newListing.getPrice()) && newListing.getInventoryStatus().equals("available"))
                {
                    view = String.format(getString(0x7f060175), new Object[] {
                        view.getFormattedMinimumSellingPrice()
                    });
                    showAutoHideProgressDialogWithMessage(view, new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                        final _cls12 this$1;

                        public void dialogDismissed()
                        {
                            newListing.setInventoryStatus("not_for_sale");
                            viewHolder.availabilityEditText.setText(newListing.getInventoryStatusDisplayString(getActivity()));
                            gotoShareScreen();
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                    return;
                } else
                {
                    gotoShareScreen();
                    return;
                }
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        };
        otl = new android.view.View.OnTouchListener() {

            final ListingEditorFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                PMActivity pmactivity = (PMActivity)getActivity();
                MetaItemPickerInfo metaitempickerinfo = new MetaItemPickerInfo();
                if (!handlingUserTap)
                {
                    Bundle bundle1 = new Bundle();
                    if (view == viewHolder.categoryEditText && motionevent.getAction() == 1)
                    {
                        handlingUserTap = true;
                        currentState = LISTING_STATES.GET_CATEGORY;
                        view = new CategorySubCategorySelectionModel();
                        view.categoryFacetList = DbApi.getAllCategories();
                        view.currentCategory = newListing.getCategory();
                        view.currentSubCategorySelection = newListing.getSubCategoryList();
                        bundle1.putBoolean("ENABLE_LISTING_MODE", true);
                        pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/CategoryListFragment, view, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                    } else
                    if (view == viewHolder.sizeEditText && motionevent.getAction() == 1)
                    {
                        view = newListing.getCategory();
                        if (view == null)
                        {
                            showAlertMessage("", getResources().getString(0x7f060180));
                            return true;
                        }
                        handlingUserTap = true;
                        metaitempickerinfo.allItems = GlobalDbController.getGlobalDbController().getAllSizesForCategory(view.getId());
                        if (metaitempickerinfo.allItems == null)
                        {
                            metaitempickerinfo.allItems = new ArrayList();
                        }
                        currentState = LISTING_STATES.GET_SIZE;
                        bundle1.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.SIZE_MODE.ordinal());
                        bundle1.putBoolean("CUSTOM_OPTION_ENABLED", true);
                        pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                    } else
                    if (view == viewHolder.brandEditText && motionevent.getAction() == 1)
                    {
                        handlingUserTap = true;
                        metaitempickerinfo.allItems = DbApi.getAllBrands();
                        currentState = LISTING_STATES.GET_BRAND;
                        bundle1.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.BRAND_MODE.ordinal());
                        bundle1.putBoolean("SEARCH_ENABLED", true);
                        bundle1.putBoolean("CUSTOM_STRING_ENABLED", true);
                        pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                    } else
                    if (view == viewHolder.nwtEditText && motionevent.getAction() == 1)
                    {
                        handlingUserTap = true;
                        currentState = LISTING_STATES.GET_CONDITION_STATUS;
                        bundle1.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.NWT_MODE.ordinal());
                        pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/ListingConditionPickerFragment, NWTOptionsMetaData.getConditionMetaItemForListingFlow(newListing.getCondition()), ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                    } else
                    if (view == viewHolder.availabilityEditText && motionevent.getAction() == 1)
                    {
                        view = FeatureManager.getGlobalFeatureManager().getListingFeature();
                        if (!view.isValidSellingPrice(newListing.getPrice()) && !newListing.getInventoryStatus().equals("available"))
                        {
                            showAlertMessage("", String.format(getString(0x7f06018d), new Object[] {
                                view.getFormattedMinimumSellingPrice()
                            }));
                            return true;
                        }
                        handlingUserTap = true;
                        metaitempickerinfo.allItems = DbApi.getNFSListingOptions();
                        currentState = LISTING_STATES.GET_AVAILABILITY_STATUS;
                        bundle1.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.AVAILABILITY_MODE.ordinal());
                        pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                    } else
                    if (view == viewHolder.colorDummyEditText && motionevent.getAction() == 1)
                    {
                        handlingUserTap = true;
                        currentState = LISTING_STATES.GET_COLOR;
                        view = new ColorPickerInfo();
                        view.allItems = DbApi.getAllColors();
                        ((ColorPickerInfo) (view)).selectedColors.addAll(newListing.getColors());
                        motionevent = (PMActivity)getActivity();
                        Bundle bundle = new Bundle();
                        bundle.putInt("COLOR_PICKER_MODE", ColorPickerFragment.COLOR_MODE.COLOR_LISTING_FLOW.ordinal());
                        motionevent.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, view, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_select_color", null);
                    } else
                    {
                        return false;
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        };
        deleteButtonClickListener = new RemoveEditListingImageListener() {

            final ListingEditorFragment this$0;

            public void onDeleteButtonClick(PMEditListingImageSelectorView pmeditlistingimageselectorview)
            {
                pmeditlistingimageselectorview.resetImageView();
                int i = ((Integer)pmeditlistingimageselectorview.getTag()).intValue();
                imageList.remove(i);
                updateImageOrder();
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        };
    }

    private void copyImageSelectorView(PMEditListingImageSelectorView pmeditlistingimageselectorview, PMEditListingImageSelectorView pmeditlistingimageselectorview1)
    {
        if (pmeditlistingimageselectorview.isImageSet())
        {
            pmeditlistingimageselectorview1.setOriginalFileUri(pmeditlistingimageselectorview.getOriginalFileUri());
            setImageThumbnail(pmeditlistingimageselectorview1, pmeditlistingimageselectorview.getFileUri());
        }
        if (pmeditlistingimageselectorview.getImageUrl() != null && pmeditlistingimageselectorview.getImageUrl().length() > 0)
        {
            pmeditlistingimageselectorview1.setRemoteImageInfo(pmeditlistingimageselectorview.getImageUrl(), pmeditlistingimageselectorview.getImageId());
        }
    }

    private void createViewHolder(View view)
    {
        Object obj = new ArrayList();
        if (viewHolder != null)
        {
            for (int i = 0; i < viewHolder.imageList.size(); i++)
            {
                ((List) (obj)).add(viewHolder.imageList.get(i));
            }

        }
        viewHolder = new ListingEditorViewHolder();
        viewHolder.picturesSelectorLayout = (LinearLayout)view.findViewById(0x7f0c019a);
        Object obj1 = (PMEditListingImageSelectorView)view.findViewById(0x7f0c01ad);
        if (((List) (obj)).size() > 0)
        {
            ((PMEditListingImageSelectorView) (obj1)).setCovershotStatus(true);
            copyImageSelectorView((PMEditListingImageSelectorView)((List) (obj)).get(0), ((PMEditListingImageSelectorView) (obj1)));
        }
        viewHolder.imageList.add((PMEditListingImageSelectorView)view.findViewById(0x7f0c01ad));
        obj1 = (PMEditListingImageSelectorView)view.findViewById(0x7f0c01af);
        if (((List) (obj)).size() > 1)
        {
            copyImageSelectorView((PMEditListingImageSelectorView)((List) (obj)).get(1), ((PMEditListingImageSelectorView) (obj1)));
        }
        ((PMEditListingImageSelectorView) (obj1)).setRemoveButtonClickListener(deleteButtonClickListener);
        viewHolder.imageList.add(obj1);
        obj1 = (PMEditListingImageSelectorView)view.findViewById(0x7f0c01b0);
        if (((List) (obj)).size() > 2)
        {
            copyImageSelectorView((PMEditListingImageSelectorView)((List) (obj)).get(2), ((PMEditListingImageSelectorView) (obj1)));
        }
        ((PMEditListingImageSelectorView) (obj1)).setRemoveButtonClickListener(deleteButtonClickListener);
        viewHolder.imageList.add(obj1);
        obj1 = (PMEditListingImageSelectorView)view.findViewById(0x7f0c01b1);
        if (((List) (obj)).size() > 3)
        {
            copyImageSelectorView((PMEditListingImageSelectorView)((List) (obj)).get(3), ((PMEditListingImageSelectorView) (obj1)));
        }
        ((PMEditListingImageSelectorView) (obj1)).setRemoveButtonClickListener(deleteButtonClickListener);
        viewHolder.imageList.add(obj1);
        viewHolder.titleEditText = (EditText)view.findViewById(0x7f0c019c);
        viewHolder.descriptionEditText = (EditText)view.findViewById(0x7f0c019d);
        viewHolder.categoryEditText = (LabelledEditText)view.findViewById(0x7f0c019e);
        viewHolder.sizeEditText = (LabelledEditText)view.findViewById(0x7f0c019f);
        viewHolder.brandEditText = (LabelledEditText)view.findViewById(0x7f0c01a0);
        viewHolder.nwtEditText = (LabelledEditText)view.findViewById(0x7f0c01a3);
        viewHolder.originalPriceEditText = (LabelledEditText)view.findViewById(0x7f0c01a4);
        viewHolder.listingPriceEditText = (LabelledEditText)view.findViewById(0x7f0c01a5);
        viewHolder.earningsTextView = (TextView)view.findViewById(0x7f0c01a6);
        viewHolder.colorsContainer = (ColorSelectionView)view.findViewById(0x7f0c01a2);
        obj = (PMTextView)view.findViewById(0x7f0c01aa);
        obj1 = getString(0x7f0602c5);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(((CharSequence) (obj1)));
        String s = getString(0x7f060248);
        int j = ((String) (obj1)).indexOf(s);
        int k = s.length();
        spannablestringbuilder.setSpan(new ClickableSpan() {

            final ListingEditorFragment this$0;

            public void onClick(View view1)
            {
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        }, j, j + k, 0);
        ((PMTextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
        ((PMTextView) (obj)).setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
        ((PMTextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final ListingEditorFragment this$0;

            public void onClick(View view1)
            {
                launchUrl("/mapp/fee_policy", "seller_policy_screen");
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        });
        viewHolder.availabilitySectionLayout = (LinearLayout)view.findViewById(0x7f0c01a7);
        viewHolder.availabilityEditText = (LabelledEditText)view.findViewById(0x7f0c01a8);
        viewHolder.colorDummyEditText = (LabelledEditText)view.findViewById(0x7f0c01a1);
        viewHolder.deleteButtonSectionLayout = (LinearLayout)view.findViewById(0x7f0c01a9);
        viewHolder.deleteButton = (PMButton)view.findViewById(0x7f0c0196);
        if (isNFSEnabled)
        {
            viewHolder.availabilitySectionLayout.setVisibility(0);
            viewHolder.deleteButtonSectionLayout.setVisibility(0);
            viewHolder.deleteButton.setOnClickListener(new android.view.View.OnClickListener() {

                final ListingEditorFragment this$0;

                public void onClick(View view1)
                {
                    showConfirmationMessage(getString(0x7f0600b8), getString(0x7f0600b9), new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (i == -1)
                            {
                                deleteListing();
                            }
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
            });
        } else
        {
            viewHolder.availabilitySectionLayout.setVisibility(8);
            viewHolder.deleteButtonSectionLayout.setVisibility(8);
        }
        prefilListingInfo();
        updateImageOrder();
    }

    private void deleteListing()
    {
        showProgressDialogWithMessage(getString(0x7f0600ba));
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "delete_listing", null);
        PMApi.deleteListing(listingId, new PMApiResponseHandler() {

            final ListingEditorFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        ListingNotificationManager.getListingNotificationManager().fireListingDeletedMessage(listingId);
                        isListingDeleted = true;
                        ((PMActivity)getActivity()).onBackPressed();
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.DELETE_LISTING, getString(0x7f0600e2), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        });
    }

    private void fireCameraActivity()
    {
        Intent intent = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraPreviewFragment);
        Bundle bundle = new Bundle();
        bundle.putInt("CREATION_MODE", CameraPreviewFragment.CREATE_COVERSHOT);
        if (currentActiveImageView.isCovershot())
        {
            bundle.putBoolean("IS_FIRST_IMAGE", true);
        }
        intent.putExtra("FRAGMENT_DATA", bundle);
        startActivityForResult(intent, DEFAULT_REQUEST_CODE);
    }

    private BigDecimal getSellerEarnings(BigDecimal bigdecimal)
    {
        ListingFeature listingfeature = FeatureManager.getGlobalFeatureManager().getListingFeature();
        if (listingfeature != null)
        {
            bigdecimal = bigdecimal.subtract(listingfeature.getFeeForListingPrice(bigdecimal));
            if (bigdecimal.compareTo(BigDecimal.ZERO) == 1)
            {
                return bigdecimal;
            } else
            {
                return BigDecimal.ZERO;
            }
        } else
        {
            return bigdecimal.multiply(BigDecimal.valueOf(0.80000000000000004D));
        }
    }

    private void getShareBannerImage()
    {
        Object obj = new ShareBannerInfo(getActivity());
        Gson gson = new Gson();
        if (!(gson instanceof Gson))
        {
            obj = gson.toJson(obj, com/poshmark/data_model/models/ShareBannerInfo);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)gson, obj, com/poshmark/data_model/models/ShareBannerInfo);
        }
        PMApi.getShareBannerImage(((String) (obj)), new PMApiResponseHandler() {

            final ListingEditorFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    shareBanner = pmapiresponse.responseString;
                }
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        });
    }

    private void gotoShareScreen()
    {
        currentState = LISTING_STATES.SHARE_LISTING;
        ListingManager listingmanager = new ListingManager();
        listingmanager.setImageList(viewHolder.imageList);
        listingmanager.setListingFlag(isNewListing);
        listingmanager.setListingDetails(newListing, listingId);
        Bundle bundle = new Bundle();
        if (shareBanner != null)
        {
            bundle.putString("share_banner", shareBanner);
        }
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/ListingEditorShareFragment, listingmanager, this, DEFAULT_REQUEST_CODE);
    }

    private void handleEditMode(int i, Intent intent)
    {
        switch (i)
        {
        case 1: // '\001'
        default:
            return;

        case 0: // '\0'
            currentState = LISTING_STATES.EDIT_LISTING;
            currentActiveImageView.resetImageView();
            i = ((Integer)currentActiveImageView.getTag()).intValue();
            imageList.remove(i);
            updateImageOrder();
            return;

        case 2: // '\002'
            currentState = LISTING_STATES.EDIT_LISTING;
            break;
        }
        if (currentActiveImageView.isCovershot())
        {
            Object obj = intent.getExtras();
            intent = (Uri)((Bundle) (obj)).getParcelable("ORIGINALFILE");
            obj = (Uri)((Bundle) (obj)).getParcelable("FILTEREDFILE");
            currentActiveImageView.resetImageView();
            currentActiveImageView.setOriginalFileUri(intent);
            setImageThumbnail(currentActiveImageView, ((Uri) (obj)));
            updateImageList(((Uri) (obj)), intent, ((Integer)currentActiveImageView.getTag()).intValue());
            return;
        } else
        {
            currentActiveImageView.resetImageView();
            currentState = LISTING_STATES.EDIT_LISTING;
            intent = (Uri)intent.getExtras().getParcelable("IMAGE_FILE_URI");
            setImageThumbnail(currentActiveImageView, intent);
            updateImageList(intent, null, ((Integer)currentActiveImageView.getTag()).intValue());
            return;
        }
    }

    private void handleNewState(Intent intent)
    {
        Object obj;
        Object obj1;
        Bundle bundle;
        String s4;
        Object obj3;
        Object obj4;
        bundle = null;
        s4 = null;
        obj3 = null;
        obj4 = null;
        obj1 = null;
        obj = null;
        static class _cls18
        {

            static final int $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[];

            static 
            {
                $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES = new int[LISTING_STATES.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.LISTING_SETUP_STATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.EDIT_LISTING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.EDIT_PHOTO.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.NEW_PHOTO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.GET_CATEGORY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.GET_SIZE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.GET_COLOR.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.GET_BRAND.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.GET_CONDITION_STATUS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.GET_AVAILABILITY_STATUS.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES[LISTING_STATES.SHARE_LISTING.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls18..SwitchMap.com.poshmark.ui.fragments.ListingEditorFragment.LISTING_STATES[currentState.ordinal()];
        JVM INSTR tableswitch 1 11: default 84
    //                   1 85
    //                   2 179
    //                   3 220
    //                   4 236
    //                   5 381
    //                   6 644
    //                   7 717
    //                   8 808
    //                   9 877
    //                   10 963
    //                   11 1032;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        return;
_L2:
        currentState = LISTING_STATES.EDIT_LISTING;
        if (isNewListing)
        {
            currentActiveImageView = (PMEditListingImageSelectorView)viewHolder.imageList.get(currentActiveImageIndex);
            prefilListingInfo();
            handleNewState(null);
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "new_listing_start", null);
            return;
        } else
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "edit_listing_start", null);
            setupCovershot();
            initializeImages();
            prefilListingInfo();
            return;
        }
_L3:
        if (currentActiveImageView.isImageSet())
        {
            currentState = LISTING_STATES.EDIT_PHOTO;
            launchEditImageFragment(currentActiveImageView.isCovershot());
            return;
        } else
        {
            currentState = LISTING_STATES.NEW_PHOTO;
            fireCameraActivity();
            return;
        }
_L4:
        handleEditMode(intent.getExtras().getInt("EDITMODE"), intent);
        return;
_L5:
        currentState = LISTING_STATES.EDIT_LISTING;
        if (currentActiveImageView.isCovershot())
        {
            obj = intent.getExtras();
            intent = (Uri)((Bundle) (obj)).getParcelable("ORIGINALFILE");
            obj = (Uri)((Bundle) (obj)).getParcelable("FILTEREDFILE");
            currentActiveImageView.resetImageView();
            currentActiveImageView.setOriginalFileUri(intent);
            setImageThumbnail(currentActiveImageView, ((Uri) (obj)));
            updateImageList(((Uri) (obj)), intent, ((Integer)currentActiveImageView.getTag()).intValue());
            return;
        } else
        {
            currentActiveImageView.resetImageView();
            currentState = LISTING_STATES.EDIT_LISTING;
            intent = (Uri)intent.getExtras().getParcelable("IMAGE_FILE_URI");
            setImageThumbnail(currentActiveImageView, intent);
            updateImageList(intent, null, ((Integer)currentActiveImageView.getTag()).intValue());
            return;
        }
_L6:
        currentState = LISTING_STATES.EDIT_LISTING;
        bundle = intent.getBundleExtra("RETURNED_RESULTS");
        s4 = bundle.getString("DATA_SELECTED");
        intent = obj1;
        if (s4 != null)
        {
            intent = (MetaItem)StringUtils.fromJson(s4, com/poshmark/data_model/models/MetaItem);
        }
        if (intent != null)
        {
            Object obj2 = newListing.getCategory();
            if (obj2 != null && !intent.getId().equals(((MetaItem) (obj2)).getId()))
            {
                viewHolder.sizeEditText.setText(null);
                newListing.setSize("");
            }
            obj2 = bundle.getString("TAGS_LIST");
            if (obj2 != null)
            {
                obj = (List)StringUtils.fromJson(((String) (obj2)), new TypeToken() {

                    final ListingEditorFragment this$0;

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
                });
            }
            obj2 = intent.getDisplay();
            if (obj != null && !((List) (obj)).isEmpty())
            {
                obj2 = (new StringBuilder()).append(((String) (obj2))).append(" | ").toString();
                obj2 = (new StringBuilder()).append(((String) (obj2))).append(((MetaItem)((List) (obj)).get(0)).getDisplay()).toString();
                newListing.setSubcategories((MetaItem)((List) (obj)).get(0));
                obj = obj2;
            } else
            {
                newListing.clearSubCategories();
                obj = obj2;
            }
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_set_subcategory", null);
            newListing.setCategory(intent);
            viewHolder.categoryEditText.setText(((CharSequence) (obj)));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        currentState = LISTING_STATES.EDIT_LISTING;
        String s = intent.getBundleExtra("RETURNED_RESULTS").getString("DATA_SELECTED");
        intent = bundle;
        if (s != null)
        {
            intent = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
        }
        if (intent != null && intent != null)
        {
            viewHolder.sizeEditText.setText(intent.getId());
            newListing.setSize(intent.getId());
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        currentState = LISTING_STATES.EDIT_LISTING;
        intent = intent.getBundleExtra("RETURNED_RESULTS");
        if (intent.getBoolean("COLOR_CHANGED", true))
        {
            intent = intent.getString("COLOR_LIST");
            if (intent != null)
            {
                intent = (List)StringUtils.fromJson(intent, new TypeToken() {

                    final ListingEditorFragment this$0;

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
                });
                newListing.setColors(intent);
                viewHolder.colorsContainer.addAllColors(intent);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_set_color", null);
                return;
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L9:
        currentState = LISTING_STATES.EDIT_LISTING;
        String s1 = intent.getBundleExtra("RETURNED_RESULTS").getString("DATA_SELECTED");
        intent = s4;
        if (s1 != null)
        {
            intent = (MetaItem)StringUtils.fromJson(s1, com/poshmark/data_model/models/MetaItem);
        }
        if (intent != null)
        {
            viewHolder.brandEditText.setText(intent.getDisplay());
            newListing.setBrand(intent.getId());
            return;
        }
        if (true) goto _L1; else goto _L10
_L10:
        currentState = LISTING_STATES.EDIT_LISTING;
        String s2 = intent.getBundleExtra("RETURNED_RESULTS").getString("DATA_SELECTED");
        intent = obj3;
        if (s2 != null)
        {
            intent = (MetaItem)StringUtils.fromJson(s2, com/poshmark/data_model/models/MetaItem);
        }
        if (intent != null)
        {
            viewHolder.nwtEditText.setText(intent.getDisplay());
            newListing.setCondition(intent.getId());
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_set_listing_condition", null);
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L11:
        currentState = LISTING_STATES.EDIT_LISTING;
        String s3 = intent.getBundleExtra("RETURNED_RESULTS").getString("DATA_SELECTED");
        intent = obj4;
        if (s3 != null)
        {
            intent = (MetaItem)StringUtils.fromJson(s3, com/poshmark/data_model/models/MetaItem);
        }
        if (intent != null)
        {
            viewHolder.availabilityEditText.setText(intent.getDisplay());
            newListing.setInventoryStatus(intent.getId());
            return;
        }
        if (true) goto _L1; else goto _L12
_L12:
        finishActivity();
        return;
    }

    private void initializeImages()
    {
        int j = imageList.size();
        int i = j;
        if (j > 4)
        {
            i = 4;
        }
        j = 0;
        while (j < i) 
        {
            Picture picture = (Picture)imageList.get(j);
            PMEditListingImageSelectorView pmeditlistingimageselectorview = (PMEditListingImageSelectorView)viewHolder.imageList.get(j);
            if (j == 0)
            {
                pmeditlistingimageselectorview.setCovershotStatus(true);
            }
            if (picture.isRemote())
            {
                pmeditlistingimageselectorview.setRemoteImageInfo(picture.getPictureUrl(), picture.getId());
            } else
            {
                pmeditlistingimageselectorview.setFileUri(picture.getPictureFileUri());
                pmeditlistingimageselectorview.setOriginalFileUri(picture.getOriginalPictureFileUri());
                setImageThumbnail(pmeditlistingimageselectorview, picture.getPictureFileUri());
            }
            pmeditlistingimageselectorview.setAsNextSelector(false);
            pmeditlistingimageselectorview.imageAssignedState(true);
            j++;
        }
        updateImageOrder();
    }

    private void launchEditImageFragment(boolean flag)
    {
        Object obj = (PMActivity)getActivity();
        obj = new Bundle();
        ((Bundle) (obj)).putBoolean("COVERSHOT", flag);
        ((Bundle) (obj)).putBoolean("NEWLISTING", isNewListing);
        ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(((Bundle) (obj)), com/poshmark/ui/fragments/EditListingImageFragment, currentActiveImageView, this, DEFAULT_REQUEST_CODE);
    }

    private void launchUrl(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(s).toString());
        bundle.putString("ANALYTICS_PAGE_NAME", s1);
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    private void prefilListingInfo()
    {
        viewHolder.titleEditText.setText(newListing.getTitle());
        viewHolder.descriptionEditText.setText(newListing.getDescription());
        if (newListing.getCategory() != null)
        {
            String s1 = newListing.getCategory().getDisplay();
            MetaItem metaitem = newListing.getFirstSubCategory();
            String s = s1;
            if (metaitem != null)
            {
                s = (new StringBuilder()).append(s1).append(" | ").append(metaitem.getDisplay()).toString();
            }
            viewHolder.categoryEditText.setText(s);
        }
        viewHolder.sizeEditText.setText(newListing.getSize());
        viewHolder.brandEditText.setText(newListing.getBrand());
        viewHolder.nwtEditText.setText(newListing.getConditionDisplayString(getActivity()));
        viewHolder.availabilityEditText.setText(newListing.getInventoryStatusDisplayString(getActivity()));
        if (newListing.getOriginalPrice().length() > 0)
        {
            viewHolder.originalPriceEditText.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(newListing.getOriginalPrice()).toString());
        }
        if (newListing.getPrice().length() > 0)
        {
            viewHolder.listingPriceEditText.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(newListing.getPrice()).toString());
        }
        Object obj = newListing.getColors();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            PMColor pmcolor;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); viewHolder.colorsContainer.addColor(pmcolor))
            {
                pmcolor = (PMColor)((Iterator) (obj)).next();
            }

        }
    }

    private void restoreState(Bundle bundle)
    {
        isNewListing = bundle.getBoolean("NEW_LISTING_FLAG");
        listingId = bundle.getString("LISTING_ID");
        currentState = LISTING_STATES.valueOf(bundle.getString("CURRENT_STATE"));
        currentActiveImageIndex = bundle.getInt("CURRENT_ACTIVE_IMAGE");
        isNFSEnabled = bundle.getBoolean("IS_NFS_ENABLED");
        currentActiveImageView = (PMEditListingImageSelectorView)viewHolder.imageList.get(currentActiveImageIndex);
        String s = bundle.getString("NEW_LISTING_INFO_JSON");
        if (s != null)
        {
            newListing = (NewListing)StringUtils.fromJson(s, com/poshmark/data_model/models/NewListing);
        }
        bundle = bundle.getString("IMAGE_LIST_JSON");
        if (bundle != null)
        {
            imageList = StringUtils.imageListFromJson(bundle, new TypeToken() {

                final ListingEditorFragment this$0;

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
            });
        }
        initializeImages();
        prefilListingInfo();
    }

    private void setImageThumbnail(PMEditListingImageSelectorView pmeditlistingimageselectorview, Uri uri)
    {
        pmeditlistingimageselectorview.setFileUri(uri);
        if (uri != null)
        {
            uri = ImageUtils.scaleBitmap(200, 200, uri);
            pmeditlistingimageselectorview.setImageBitmap(null);
            pmeditlistingimageselectorview.setImageBitmap(uri);
            pmeditlistingimageselectorview.imageAssignedState(true);
        }
        (new MediaScannerWrapper(PMApplication.getContext(), storage_path.getAbsolutePath(), "image/jpeg")).scan();
        updateImageOrder();
    }

    private void setupActionBarNextActionButton()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f0601cc).toUpperCase());
            button.setOnClickListener(createListingButtonListener);
            return;
        }
    }

    private void setupCovershot()
    {
        Object obj = new Picture();
        ((Picture) (obj)).setId(listingDetails.getCovershotId());
        ((Picture) (obj)).setPictureUrl(listingDetails.getCovershot());
        imageList.add(obj);
        obj = listingDetails.getPictures();
        int j = ((List) (obj)).size();
        for (int i = 0; i < j; i++)
        {
            Picture picture = new Picture((Picture)((List) (obj)).get(i));
            imageList.add(picture);
        }

    }

    private void setupExistingListing()
    {
        newListing.updateFromListingDetails(listingDetails);
    }

    private void setupImageClickHandlers()
    {
        for (int i = 0; i < viewHolder.imageList.size(); i++)
        {
            PMEditListingImageSelectorView pmeditlistingimageselectorview = (PMEditListingImageSelectorView)viewHolder.imageList.get(i);
            pmeditlistingimageselectorview.setTag(Integer.valueOf(i));
            pmeditlistingimageselectorview.setOnClickListener(commonImageClickListener);
        }

    }

    private void setupImageList()
    {
        ((PMEditListingImageSelectorView)viewHolder.imageList.get(0)).setCovershotStatus(true);
        setupImageClickHandlers();
    }

    private void setupPriceValidators()
    {
        viewHolder.originalPriceEditText.addTextChangedListener(new TextWatcher() {

            final ListingEditorFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                if (!editable.toString().contains(CurrencyUtils.getCurrencySymbol()))
                {
                    String s = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(viewHolder.originalPriceEditText.getText().toString()).toString();
                    viewHolder.originalPriceEditText.setText(s);
                    Selection.setSelection(viewHolder.originalPriceEditText.getText(), viewHolder.originalPriceEditText.getText().length());
                }
                editable = editable.toString();
                if (editable != null)
                {
                    editable = editable.replace(CurrencyUtils.getCurrencySymbol(), "");
                    newListing.setOriginalPrice(editable);
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        });
        viewHolder.listingPriceEditText.addTextChangedListener(new TextWatcher() {

            final ListingEditorFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                if (!editable.toString().contains(CurrencyUtils.getCurrencySymbol()))
                {
                    String s = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(viewHolder.listingPriceEditText.getText().toString()).toString();
                    viewHolder.listingPriceEditText.setText(s);
                    Selection.setSelection(viewHolder.listingPriceEditText.getText(), viewHolder.listingPriceEditText.getText().length());
                }
                editable = editable.toString();
                if (editable == null)
                {
                    break MISSING_BLOCK_LABEL_188;
                }
                editable = editable.replace(CurrencyUtils.getCurrencySymbol(), "");
                newListing.setListingPrice(editable);
                if (editable.length() <= 0)
                {
                    break MISSING_BLOCK_LABEL_188;
                }
                editable = new BigDecimal(editable);
                editable = CurrencyUtils.getPriceAsFormattedString(getSellerEarnings(editable));
                viewHolder.earningsTextView.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(editable).toString());
                return;
                editable;
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        });
    }

    private void setupTouchListeners()
    {
        viewHolder.categoryEditText.setOnTouchListener(otl);
        viewHolder.sizeEditText.setOnTouchListener(otl);
        viewHolder.brandEditText.setOnTouchListener(otl);
        viewHolder.nwtEditText.setOnTouchListener(otl);
        viewHolder.availabilityEditText.setOnTouchListener(otl);
        viewHolder.colorDummyEditText.setOnTouchListener(otl);
        viewHolder.colorsContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingEditorFragment this$0;

            public void onClick(View view)
            {
                currentState = LISTING_STATES.GET_COLOR;
                view = new ColorPickerInfo();
                view.allItems = DbApi.getAllColors();
                ((ColorPickerInfo) (view)).selectedColors.addAll(newListing.getColors());
                PMActivity pmactivity = (PMActivity)getActivity();
                Bundle bundle = new Bundle();
                bundle.putInt("COLOR_PICKER_MODE", ColorPickerFragment.COLOR_MODE.COLOR_LISTING_FLOW.ordinal());
                pmactivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, view, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_select_color", null);
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        });
    }

    private void updateImageList(Uri uri, Uri uri1, int i)
    {
        if (imageList != null)
        {
            Picture picture = new Picture();
            picture.setId("");
            picture.setFileUri(uri);
            picture.setOriginalFileUri(uri1);
            int j;
            if (i < imageList.size())
            {
                imageList.set(i, picture);
            } else
            {
                imageList.add(i, picture);
            }
        }
        j = imageList.size();
        i = j;
        if (j > 4)
        {
            i = 4;
        }
        j = 0;
        while (j < i) 
        {
            uri = (Picture)imageList.get(j);
            uri1 = (PMEditListingImageSelectorView)viewHolder.imageList.get(j);
            if (j == 0)
            {
                uri1.setCovershotStatus(true);
            }
            if (uri.isRemote())
            {
                uri1.setRemoteImageInfo(uri.getPictureUrl(), uri.getId());
            } else
            {
                uri1.setFileUri(uri.getPictureFileUri());
                uri1.setOriginalFileUri(uri.getOriginalPictureFileUri());
            }
            j++;
        }
        updateImageOrder();
    }

    private void updateImageOrder()
    {
        for (int i = 1; i < viewHolder.imageList.size() - 1; i++)
        {
            PMEditListingImageSelectorView pmeditlistingimageselectorview = (PMEditListingImageSelectorView)viewHolder.imageList.get(i);
            PMEditListingImageSelectorView pmeditlistingimageselectorview2 = (PMEditListingImageSelectorView)viewHolder.imageList.get(i + 1);
            pmeditlistingimageselectorview.setAsNextSelector(false);
            pmeditlistingimageselectorview2.setAsNextSelector(false);
            if (!pmeditlistingimageselectorview.isImageSet() && pmeditlistingimageselectorview2.isImageSet())
            {
                pmeditlistingimageselectorview.setFileUri(pmeditlistingimageselectorview2.getFileUri());
                pmeditlistingimageselectorview.setOriginalFileUri(pmeditlistingimageselectorview2.getOriginalFileUri());
                pmeditlistingimageselectorview.setRemoteImageInfo(pmeditlistingimageselectorview2.getImageUrl(), pmeditlistingimageselectorview2.getImageId());
                pmeditlistingimageselectorview.imageAssignedState(pmeditlistingimageselectorview2.isImageSet());
                pmeditlistingimageselectorview.setImageBitmap(pmeditlistingimageselectorview2.getImageBitmap());
                pmeditlistingimageselectorview2.resetImageView();
            }
        }

        int j = 0;
        do
        {
label0:
            {
                if (j < viewHolder.imageList.size())
                {
                    PMEditListingImageSelectorView pmeditlistingimageselectorview1 = (PMEditListingImageSelectorView)viewHolder.imageList.get(j);
                    if (pmeditlistingimageselectorview1.isImageSet())
                    {
                        break label0;
                    }
                    pmeditlistingimageselectorview1.setAsNextSelector(true);
                }
                return;
            }
            j++;
        } while (true);
    }

    private boolean validInput()
    {
        newListing.setTitle(viewHolder.titleEditText.getText().toString());
        newListing.setDescription(viewHolder.descriptionEditText.getText().toString());
        if (!newListing.isValidListing())
        {
            showAlertMessage(getString(0x7f0600d0), newListing.getInputError());
            return false;
        } else
        {
            return true;
        }
    }

    public boolean handleBack()
    {
        if (isListingDeleted)
        {
            finishActivity();
            return true;
        }
        String s;
        if (isNewListing)
        {
            s = getString(0x7f060070);
        } else
        {
            s = getString(0x7f06006f);
        }
        (new android.app.AlertDialog.Builder(getActivity())).setIcon(0x1080027).setTitle(getString(0x7f06006d)).setMessage(s).setPositiveButton(getString(0x7f0602cd), new android.content.DialogInterface.OnClickListener() {

            final ListingEditorFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                finishActivity();
            }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        }).setNegativeButton(getString(0x7f0601ce), null).show();
        return true;
    }

    public void hideKeyboard()
    {
        viewHolder.titleEditText.clearFocus();
        viewHolder.brandEditText.clearFocus();
        viewHolder.originalPriceEditText.clearFocus();
        viewHolder.listingPriceEditText.clearFocus();
        super.hideKeyboard();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        storage_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        setupImageList();
        setupTouchListeners();
        setupPriceValidators();
        if (bundle != null)
        {
            restoreState(bundle);
        } else
        if (currentState == LISTING_STATES.LISTING_SETUP_STATE)
        {
            if (!isNewListing)
            {
                setupExistingListing();
            }
            handleNewState(null);
        } else
        {
            currentState = LISTING_STATES.EDIT_LISTING;
        }
        if (isNewListing)
        {
            getShareBannerImage();
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        handlingUserTap = false;
        if (j == -1)
        {
            handleNewState(intent);
        }
        if (j == 0)
        {
            currentState = LISTING_STATES.EDIT_LISTING;
            if (isNewListing && !((PMEditListingImageSelectorView)viewHolder.imageList.get(0)).isImageSet())
            {
                finishActivity();
            }
            return;
        } else
        {
            currentState = LISTING_STATES.EDIT_LISTING;
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            isNFSEnabled = getArguments().getBoolean("NFS_ENABLED");
            isNewListing = getArguments().getBoolean("NEW_LISTING");
            if (!isNewListing)
            {
                listingId = getArguments().getString("ID");
                listingDetails = (ListingDetails)getFragmentDataOfType(com/poshmark/data_model/models/ListingDetails);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03006b, viewgroup, false);
        setTitle(0x7f06016c);
        createViewHolder(layoutinflater);
        return layoutinflater;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (newListing != null)
        {
            bundle.putString("NEW_LISTING_INFO_JSON", StringUtils.toJson(newListing));
        }
        java.lang.reflect.Type type = (new TypeToken() {

            final ListingEditorFragment this$0;

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
        }).getType();
        bundle.putString("IMAGE_LIST_JSON", StringUtils.imageListToJson(imageList, type));
        bundle.putBoolean("NEW_LISTING_FLAG", isNewListing);
        bundle.putString("CURRENT_STATE", currentState.toString());
        bundle.putInt("CURRENT_ACTIVE_IMAGE", currentActiveImageIndex);
        bundle.putString("LISTING_ID", listingId);
        bundle.putBoolean("IS_NFS_ENABLED", isNFSEnabled);
    }

    public void setViewNameForAnalytics()
    {
        if (isNewListing)
        {
            viewNameForAnalytics = "new_listing_screen";
            return;
        } else
        {
            viewNameForAnalytics = "edit_listing_screen";
            return;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        showRefreshButton(false);
        setupActionBarNextActionButton();
        setTitle(0x7f06016c);
    }







}
