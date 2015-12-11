// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.app.ModalProgressFragment;
import com.ebay.common.Preferences;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.RoiTrackingUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.photomanager.PhotoManagerFragment;
import com.ebay.mobile.photomanager.PhotoManagerViewAdapter;
import com.ebay.mobile.photomanager.SiteHostedPictureDetails;
import com.ebay.mobile.photomanager.net.UploadPhotoNetLoader;
import com.ebay.mobile.photomanager.net.UploadSiteHostedPicturesResponse;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.mobile.sell.util.FieldInputOrder;
import com.ebay.mobile.viewitem.PpaUpgradeConfirmDialog;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftPreferences;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.LdsError;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.ebay.mobile.sell:
//            SpokeCompletedState, HubFragment, SellerRegistrationDialogFragment, CongratulationsActivity, 
//            SsoPagesWebViewActivity, ReviewDialogFragment, PhotosSpokeFragment, BaseSpokeFragment

public class ListingFragmentActivity extends BaseActivity
    implements android.content.DialogInterface.OnCancelListener, android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.mobile.photomanager.PhotoManagerFragment.PhotoManagerHost, CategoryDialogFragment.CategoryDialogHost, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.LoadDraftDetailsGenerator, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{
    private static final class LoadingState extends Enum
    {

        private static final LoadingState $VALUES[];
        public static final LoadingState ERROR;
        public static final LoadingState LOADED;
        public static final LoadingState LOADING;

        public static LoadingState valueOf(String s)
        {
            return (LoadingState)Enum.valueOf(com/ebay/mobile/sell/ListingFragmentActivity$LoadingState, s);
        }

        public static LoadingState[] values()
        {
            return (LoadingState[])$VALUES.clone();
        }

        static 
        {
            LOADING = new LoadingState("LOADING", 0);
            LOADED = new LoadingState("LOADED", 1);
            ERROR = new LoadingState("ERROR", 2);
            $VALUES = (new LoadingState[] {
                LOADING, LOADED, ERROR
            });
        }

        private LoadingState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int DIALOG_CALLBACK_DISCARD_DRAFT = 2;
    private static final int DIALOG_CALLBACK_DROP_INVALID_PRODUCT = 1;
    private static final int DIALOG_CALLBACK_EFT_ERROR = 4;
    private static final int DIALOG_CALLBACK_PAYPAL_WARNING = 3;
    private static final int DIALOG_CALLBACK_PUBLISH_ERROR_REDIRECT = 5;
    public static final String EXTRA_CATEGORY_ID_FOR_TRACKING = "category_id";
    public static final String EXTRA_DRAFT_ID = "draft_id";
    public static final String EXTRA_KEY_PARAMS = "key_params";
    public static final String EXTRA_LISTING_MODE = "listing_mode";
    public static final String EXTRA_SITE = "site";
    public static final String EXTRA_SMARTBOX_CATEGORY_ID = "category_id";
    public static final String EXTRA_SMARTBOX_EPID = "epid";
    public static final String EXTRA_SMARTBOX_TITLE = "title";
    public static final String EXTRA_SOURCE_ITEM_ID = "source_item_id";
    private static final int OPTION_SAVE_FOR_LATER = 101;
    private static final int RESULT_REDIRECT_COMPLETE = 2;
    private static final int RESULT_SELLER_REG_COMPLETE = 1;
    private static final String STATE_AUCTION_START_PRICE = "auctionStartPrice";
    private static final String STATE_CHARITY_CHANGED = "charityChanged";
    private static final String STATE_CHARITY_DONATION_PERCENTAGE_CHANGED = "donationPercentageChanged";
    private static final String STATE_CHARITY_LOADED = "charityLoaded";
    private static final String STATE_KEY_PARAMS = "key_params";
    private static final String STATE_PUBLISH_ERROR_FOR_CALLBACK = "publishErrorForCallback";
    private static final int UPLOAD_PHOTO_LOADER_ID = 2;
    private static final AtomicLong keyIdGenerator = new AtomicLong();
    private String cachedStartPrice;
    private PhotoManagerViewAdapter configChangeBackup;
    private ListingDraftDataManager draftDm;
    private EbaySite draftSite;
    private View errorLayout;
    private TextView errorPrimary;
    private TextView errorSecondary;
    private boolean isGuaranteeSelectedThisSession;
    private boolean isPaused;
    private com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams keyParams;
    private View leftPane;
    private ListingDraft listingDraft;
    private String listingMode;
    private View loadingLayout;
    private LoadingState loadingState;
    private String origItemId;
    private LdsError publishDraftErrorForCallback;
    private ListingDraft publishedDraft;
    private View retryButton;
    private View rightPane;
    private Set trackedSpokes;
    private final SpokeCompletedState trackingSpokeCompletionState = new SpokeCompletedState();
    private boolean tracking_charityChanged;
    private boolean tracking_charityLoaded;
    private boolean tracking_donationPercentageChanged;
    private String urlForUploadedPhoto;

    public ListingFragmentActivity()
    {
        listingDraft = new ListingDraft();
        publishedDraft = new ListingDraft();
        tracking_charityLoaded = false;
        tracking_charityChanged = false;
        tracking_donationPercentageChanged = false;
        trackedSpokes = null;
        configChangeBackup = null;
        urlForUploadedPhoto = null;
        cachedStartPrice = "0.00";
        origItemId = null;
        listingMode = null;
        isPaused = false;
    }

    private boolean containsBadProduct(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            if (((LdsError)arraylist.next()).id.equals("100012018"))
            {
                return true;
            }
        }

        return false;
    }

    private boolean containsPaypalNotLinkedWarning(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            if ("121919158".equals(((LdsError)arraylist.next()).id))
            {
                return true;
            }
        }

        return false;
    }

    private void doRoiTracking(ListingDraft listingdraft)
    {
        String s = listingDraft.quantity.getStringValue();
        EbaySite ebaysite = EbaySite.getInstanceFromId(listingDraft.siteId);
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = listingdraft.feeTotal().toItemCurrency();
        String s1 = listingDraft.category.getStringValue();
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        RoiTrackingUtil.trackRoi(this, "Sell-MobileApp", ebaysite, new com.ebay.mobile.analytics.RoiTrackingUtil.RoiItemData(authentication.iafToken, authentication.user, listingdraft.itemId, s, itemcurrency, s1, null));
    }

    private void doTracking(ListingDraft listingdraft)
    {
        TrackingData trackingdata = new TrackingData("ConfirmListing", TrackingType.EVENT);
        trackingdata.addKeyValuePair("itemId", listingdraft.itemId);
        trackingdata.addKeyValuePair("liid", listingdraft.itemId);
        String s;
        if (tracking_charityLoaded)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("scload", s);
        if (listingDraft != null)
        {
            Object obj;
            boolean flag;
            if (listingDraft.charityId != null && listingDraft.charityId.getStringValue() != null && !listingDraft.charityId.getStringValue().equals("0"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            trackingdata.addKeyValuePair("scu", s);
            s = "";
            if (listingDraft.charityDonationPercent != null)
            {
                s = listingDraft.charityDonationPercent.getStringValue();
            }
            obj = s;
            if (TextUtils.isEmpty(s))
            {
                obj = "0";
            }
            trackingdata.addKeyValuePair("scdv", ((String) (obj)));
        }
        if (tracking_charityChanged)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("scvc", s);
        if (tracking_donationPercentageChanged)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("scdc", s);
        trackingdata.addKeyValuePair("draft_id", listingdraft.id);
        if (listingdraft.category != null)
        {
            s = listingdraft.category.getStringValue();
        } else
        {
            s = null;
        }
        trackingdata.addKeyValuePair("leaf", s);
        trackingdata.addKeyValuePair("origItemId", origItemId);
        trackingdata.addKeyValuePair("mfls", listingModeToTrackingMode(listingMode, true));
        trackingdata.addKeyValuePair("smd", listingModeToTrackingMode(listingMode, false));
        if (isGuaranteeSelectedThisSession)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("spg", s);
        trackingdata.send(this);
        doRoiTracking(listingdraft);
        if (listingMode != null)
        {
            sendTrackingForSpecialSellingEvent(listingModeToTrackingMode(listingMode, true));
        }
        s = "PMTO";
        obj = listingDraft.paymentMethods.iterator();
        do
        {
            listingdraft = s;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            listingdraft = (LdsField)((Iterator) (obj)).next();
            if (!listingdraft.getBooleanValue() || !"PayPal".equals(listingdraft.getIdIndex()))
            {
                continue;
            }
            listingdraft = "PMTPP";
            break;
        } while (true);
        sendTrackingForSpecialSellingEvent(listingdraft);
        listingdraft = "SSI";
        if (listingDraft.startDateEnabled.getBooleanValue())
        {
            listingdraft = "SSD";
        }
        sendTrackingForSpecialSellingEvent(listingdraft);
        if (listingDraft.intlShippingType == null || listingDraft.intlShippingType.getStringValue() == null || listingDraft.intlShippingType.getStringValue().equals("NOT_SPECIFIED"))
        {
            listingdraft = "SHO";
        } else
        {
            listingdraft = "SHI";
        }
        if (listingdraft != null)
        {
            sendTrackingForSpecialSellingEvent(listingdraft);
        }
        listingdraft = listingDraft.format.getStringValue();
        if ("ChineseAuction".equals(listingdraft))
        {
            sendTrackingForSpecialSellingEvent("auction");
        } else
        if ("FixedPrice".equals(listingdraft) || "StoresFixedPrice".equals(listingdraft))
        {
            sendTrackingForSpecialSellingEvent("fixed_price");
            return;
        }
    }

    private void finishAndReturnDraft()
    {
        if (listingDraft != null && listingDraft.id != null)
        {
            Toast.makeText(this, getString(0x7f070943), 0).show();
            sendTrackingForEvent("SellSaveAsDraft", false, true, false, false);
        }
        setResult(-1);
        finish();
    }

    private String getCurrentListingModeForMts()
    {
        return listingModeToTrackingMode(listingMode, false);
    }

    private HubFragment getHubFragment()
    {
        Fragment fragment;
        if (getResources().getBoolean(0x7f0b0006))
        {
            fragment = getFragmentManager().findFragmentById(0x7f100649);
        } else
        {
            fragment = getFragmentManager().findFragmentById(0x7f100648);
        }
        if (fragment instanceof HubFragment)
        {
            return (HubFragment)fragment;
        } else
        {
            Log.w(com/ebay/mobile/sell/ListingFragmentActivity.getSimpleName(), "Could not find HubFragment");
            return null;
        }
    }

    private String getSecondaryErrorMessage(ResultStatus resultstatus)
    {
        resultstatus = resultstatus.getFirstMessage();
        if (resultstatus == null || 2005 == resultstatus.getId())
        {
            return null;
        } else
        {
            return ResultStatus.getSafeLongMessage(getEbayContext(), resultstatus);
        }
    }

    private void handleError(ListingDraftContent listingdraftcontent)
    {
        Object obj = null;
        retryButton.setVisibility(8);
        ResultStatus resultstatus = listingdraftcontent.getStatus();
        if (NetworkUtil.isConnectionError(resultstatus))
        {
            listingdraftcontent = getString(0x7f070265);
            retryButton.setVisibility(0);
        } else
        {
            if (EbayErrorUtil.userNotLoggedIn(resultstatus.getMessages()))
            {
                handleIafTokenExpiration();
                return;
            }
            listingdraftcontent = getString(0x7f0707c1);
            obj = getSecondaryErrorMessage(resultstatus);
        }
        errorPrimary.setText(listingdraftcontent);
        errorSecondary.setText(((CharSequence) (obj)));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            errorSecondary.setVisibility(8);
        } else
        {
            errorSecondary.setVisibility(0);
        }
        setLoadingState(LoadingState.ERROR);
        ModalProgressFragment.hide(getFragmentManager());
    }

    private void handleLoadResult(ListingDraft listingdraft)
    {
        listingDraft = listingdraft;
        setLoadingState(LoadingState.LOADED);
        if (getIntent().getIntExtra("noti_type_id", -1) != -1)
        {
            listingdraft = getHubFragment();
            if (listingdraft != null)
            {
                listingdraft.launchPhotosSpokeForNotification();
            }
        } else
        if (getResources().getBoolean(0x7f0b0006))
        {
            listingdraft = getHubFragment();
            if (listingdraft != null)
            {
                listingdraft.launchPhotosSpoke();
                return;
            }
        }
    }

    private void handlePublishErrors(ArrayList arraylist)
    {
        LdsError ldserror = LdsError.getFirstElvisError(arraylist);
        if (ldserror != null)
        {
            showPublishError(ldserror);
        } else
        {
            if (MyApp.getPrefs().getUserIsPpa())
            {
                showDialog(0x7f0707aa);
                return;
            }
            LdsError ldserror1 = LdsError.getFirstSellerVerificationError(arraylist);
            if (ldserror1 != null)
            {
                publishDraftErrorForCallback = ldserror1;
                (new SellerRegistrationDialogFragment()).show(getFragmentManager(), "seller_reg_dialog");
                return;
            }
            ldserror1 = LdsError.getFirstRedirectError(arraylist);
            if (ldserror1 != null)
            {
                showPublishError(ldserror1);
                return;
            }
            arraylist = (LdsError)arraylist.get(0);
            if (arraylist != null)
            {
                showPublishError(arraylist);
                return;
            }
        }
    }

    private void handlePublishResult(ListingDraft listingdraft)
    {
        setLoadingState(LoadingState.LOADED);
        publishedDraft = listingdraft;
        ModalProgressFragment.hide(getFragmentManager());
        ArrayList arraylist = listingdraft.errors;
        if (arraylist.isEmpty())
        {
            doTracking(listingdraft);
            SellingListActivity.setSellingInvalid(getEbayContext());
            listingdraft = new Intent(this, com/ebay/mobile/sell/CongratulationsActivity);
            listingdraft.putExtra("extraListingDraft", listingDraft);
            listingdraft.putExtra("extraPublishedDraft", publishedDraft);
            listingdraft.putExtra("extraGuaranteeSelected", isGuaranteeSelectedThisSession);
            startActivity(listingdraft);
            draftDm.removeDraft();
            setResult(-1);
            finish();
            return;
        } else
        {
            handlePublishErrors(arraylist);
            return;
        }
    }

    private void handleValidationResult(ListingDraft listingdraft)
    {
        setLoadingState(LoadingState.LOADED);
        listingDraft = listingdraft;
        ArrayList arraylist = listingdraft.errors;
        LdsError ldserror = FieldInputOrder.getFirstError(listingdraft.errors);
        if (arraylist.isEmpty() || ldserror.id.equals("121916796"))
        {
            ModalProgressFragment.hide(getFragmentManager());
            if (containsPaypalNotLinkedWarning(listingdraft.warnings))
            {
                showPaypalWarningDialog();
                return;
            } else
            {
                showReviewDialog(listingdraft);
                return;
            }
        }
        if (containsBadProduct(arraylist))
        {
            ModalProgressFragment.hide(getFragmentManager());
            (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(0x7f0703d5).setPositiveButton(0x7f070738).setNegativeButton(0x7f0701cc).createFromActivity(1).show(getFragmentManager(), "product_error");
            return;
        }
        ModalProgressFragment.hide(getFragmentManager());
        listingdraft = getHubFragment();
        if (listingdraft != null)
        {
            listingdraft.navigateToValidationErrorLocation(ldserror.inputRefId);
        }
        if ("100000506".equals(ldserror.id) && DeviceConfiguration.getAsync().get(DcsBoolean.SellEftWebview))
        {
            (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(0x7f07013d).setPositiveButton(0x7f07013f).setNegativeButton(0x7f07013e).createFromActivity(4).show(getFragmentManager(), "eft_error");
            return;
        }
        listingdraft = ldserror.longMessage;
        if (ldserror.id.equals("121917221"))
        {
            listingdraft = getString(0x7f0703d4);
        }
        (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(listingdraft).setPositiveButton(0x7f070738).createFromActivity(-1).show(getFragmentManager(), "validation_error");
    }

    private void launchEftEditor()
    {
        Object obj = null;
        Iterator iterator = listingDraft.errors.iterator();
        LdsError ldserror;
        do
        {
            ldserror = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            ldserror = (LdsError)iterator.next();
        } while (!"100000506".equals(ldserror.id));
        if (ldserror == null || TextUtils.isEmpty(ldserror.parameterMessageUrl))
        {
            return;
        } else
        {
            Intent intent = new Intent(this, com/ebay/mobile/sell/SsoPagesWebViewActivity);
            intent.putExtra("url", ldserror.parameterMessageUrl);
            intent.putExtra("android.intent.extra.TITLE", getString(0x7f070bbc));
            intent.putExtra("ok", false);
            intent.putExtra(ShowWebViewActivity.EXTRA_DONE_PATTERN, ".*\\?SellHub.*");
            intent.putExtra("impression", "SellerEftDetails");
            startActivity(intent);
            return;
        }
    }

    private void launchPublishErrorRedirect()
    {
        Object obj = publishDraftErrorForCallback;
        if (obj != null)
        {
            if (!TextUtils.isEmpty(((CharSequence) (obj = LdsError.getRedirectUrlWithReplacements(((LdsError) (obj)))))))
            {
                Intent intent = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
                intent.putExtra("url", ((String) (obj)));
                intent.putExtra("use_sso", true);
                intent.putExtra("back", true);
                startActivityForResult(intent, 2);
                return;
            }
        }
    }

    public static String listingModeToTrackingMode(String s, boolean flag)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   246818852: 88
    //                   481200203: 103
    //                   507384028: 118
    //                   1320222924: 133;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_133;
_L6:
        switch (byte0)
        {
        default:
            if (flag)
            {
                return "SLIS";
            } else
            {
                return "0";
            }

        case 0: // '\0'
            if (flag)
            {
                return "SREL";
            } else
            {
                return "2";
            }

        case 1: // '\001'
            if (flag)
            {
                return "SREV";
            } else
            {
                return "1";
            }

        case 2: // '\002'
            if (flag)
            {
                return "SOLT";
            } else
            {
                return "6";
            }

        case 3: // '\003'
            break;
        }
        break MISSING_BLOCK_LABEL_184;
_L2:
        if (s.equals("RelistItem"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s.equals("ReviseItem"))
        {
            byte0 = 1;
        }
          goto _L6
_L4:
        if (s.equals("SellLikeItem"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("SellSimilarItem"))
        {
            byte0 = 3;
        }
          goto _L6
        if (flag)
        {
            return "SSSI";
        } else
        {
            return "3";
        }
    }

    private void migrateListingFormPreferences()
    {
        ListingDraftPreferences listingdraftpreferences = new ListingDraftPreferences(this);
        Authentication authentication;
        if (!listingdraftpreferences.alreadyExists())
        {
            if ((authentication = MyApp.getPrefs().getAuthentication()) != null)
            {
                Preferences preferences = MyApp.getPrefs();
                Iterator iterator = ListingDraftPreferences.getMigrationKeys().iterator();
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    if (preferences.containsUserPref(s))
                    {
                        String s1 = preferences.getUserPref(s, "");
                        if (!TextUtils.isEmpty(s1))
                        {
                            listingdraftpreferences.setUserPref(authentication, s, s1);
                        }
                        preferences.removeUserPref(s);
                    }
                }
            }
        }
    }

    private void sendTrackingForEvent(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        if (flag3)
        {
            TrackingData trackingdata = new TrackingData(s, TrackingType.PAGE_IMPRESSION);
            if (DeviceInfoUtil.isPortrait(this))
            {
                s = "p";
            } else
            {
                s = "l";
            }
            trackingdata.addKeyValuePair("ort", s);
            s = trackingdata;
        } else
        {
            s = new TrackingData(s, TrackingType.EVENT);
        }
        if (listingDraft == null || TextUtils.isEmpty(listingDraft.id)) goto _L2; else goto _L1
_L1:
        s.addKeyValuePair("draft_id", listingDraft.id);
        String s1;
        if (listingDraft.category != null)
        {
            s1 = listingDraft.category.getStringValue();
        } else
        {
            s1 = null;
        }
        s.addKeyValuePair("leaf", s1);
_L4:
        s.addSourceIdentification(getIntent());
        if (flag)
        {
            s.addKeyValuePair("origItemId", origItemId);
        }
        if (flag1)
        {
            s.addKeyValuePair("mfls", listingModeToTrackingMode(listingMode, true));
            s.addKeyValuePair("smd", listingModeToTrackingMode(listingMode, false));
        }
        if (flag2)
        {
            NotificationTrackingUtil.addNotificationTracking(this, s, getIntent(), com.ebay.common.model.mdns.NotificationPreference.EventType.ADDPHOTO.name());
        }
        if (trackedSpokes != null)
        {
            s.addKeyValuePair("chk_spokes", AnalyticsUtil.getCommaSeparatedStringFromCollection(trackedSpokes));
        }
        s.send(this);
        return;
_L2:
        Bundle bundle = getIntent().getExtras();
        String s2 = bundle.getString("draft_id");
        if (!TextUtils.isEmpty(s2))
        {
            s.addKeyValuePair("draft_id", s2);
        }
        String s3 = bundle.getString("category_id");
        s2 = s3;
        if (TextUtils.isEmpty(s3))
        {
            s2 = bundle.getString("category_id");
        }
        if (!TextUtils.isEmpty(s2))
        {
            s.addKeyValuePair("leaf", s2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void sendTrackingForSellCatalogItem(ListingDraft listingdraft, boolean flag)
    {
        TrackingData trackingdata = new TrackingData("SellCatalogItemSelectedForListing", TrackingType.EVENT);
        if (listingdraft != null)
        {
            trackingdata.addKeyValuePair("draft_id", listingdraft.id);
            if (listingdraft.category != null)
            {
                String s = listingdraft.category.getStringValue();
                trackingdata.addKeyValuePair("cat", s);
                trackingdata.addKeyValuePair("leaf", s);
            }
            if (listingdraft.productId != null)
            {
                trackingdata.addKeyValuePair("pri", listingdraft.productId.getStringValue());
            }
        }
        trackingdata.addKeyValuePair("smd", getCurrentListingModeForMts());
        if (flag)
        {
            listingdraft = "1";
        } else
        {
            listingdraft = "0";
        }
        trackingdata.addKeyValuePair("succ", listingdraft);
        trackingdata.send(this);
    }

    private void sendTrackingForSpecialSellingEvent(String s)
    {
        Object obj = null;
        TrackingData trackingdata = new TrackingData("SellingEvents", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", s);
        if (listingDraft == null)
        {
            s = null;
        } else
        {
            s = listingDraft.id;
        }
        trackingdata.addKeyValuePair("draft_id", s);
        s = obj;
        if (listingDraft != null)
        {
            s = obj;
            if (listingDraft.category != null)
            {
                s = listingDraft.category.getStringValue();
            }
        }
        trackingdata.addKeyValuePair("leaf", s);
        trackingdata.send(this);
    }

    private void setLoadingState(LoadingState loadingstate)
    {
        loadingState = loadingstate;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[];
            static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState = new int[LoadingState.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[LoadingState.LOADING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[LoadingState.LOADED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$ListingFragmentActivity$LoadingState[LoadingState.ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType = new int[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.CREATE_COMPLETE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.CREATE_RELIST_COMPLETE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.BLOCKING_CHANGE_ACK.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.VALIDATE_ACK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.PUBLISH_ACK.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.VALIDATE_COMPLETE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.PUBLISH_COMPLETE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.BLOCKING_CHANGE_COMPLETE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.COMPLETE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ListingDraftDataManager$DispatchType[com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType.ACK.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.sell.ListingFragmentActivity.LoadingState[loadingState.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 45
    //                   2 92
    //                   3 111;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        loadingLayout.setVisibility(0);
        errorLayout.setVisibility(8);
        rightPane.setVisibility(0);
        if (getResources().getBoolean(0x7f0b0006))
        {
            leftPane.setVisibility(0);
            return;
        }
          goto _L1
_L3:
        loadingLayout.setVisibility(8);
        errorLayout.setVisibility(8);
        return;
_L4:
        leftPane.setVisibility(8);
        rightPane.setVisibility(8);
        loadingLayout.setVisibility(8);
        errorLayout.setVisibility(0);
        return;
    }

    private void showDiscardDraft()
    {
        (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(0x7f0709de).setPositiveButton(0x7f070738).setNegativeButton(0x7f0701cc).createFromActivity(2).show(getFragmentManager(), "discard_draft");
    }

    private void showPaypalWarningDialog()
    {
        Object obj = null;
        Iterator iterator = listingDraft.warnings.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsError ldserror = (LdsError)iterator.next();
            if ("121919158".equals(ldserror.id))
            {
                obj = ldserror;
            }
        } while (true);
        if (obj == null)
        {
            return;
        } else
        {
            obj = (new SpannableStringBuilder()).append(((LdsError) (obj)).longMessage).append("\n\n");
            int i = ((SpannableStringBuilder) (obj)).length();
            ((SpannableStringBuilder) (obj)).append(listingDraft.paypalEmailAddress.getStringValue());
            ((SpannableStringBuilder) (obj)).setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0d00df)), i, ((SpannableStringBuilder) (obj)).length(), 33);
            (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(((CharSequence) (obj))).setTitle(0x7f070158).setPositiveButton(0x7f070157).setNegativeButton(0x7f070156).createFromActivity(3).show(getFragmentManager(), "paypal_warning");
            return;
        }
    }

    private void showPublishError(LdsError ldserror)
    {
        String s = ldserror.longMessage;
        if (!"100000036".equals(ldserror.id) || !ldserror.isSyiErrorMessage()) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1 = ldserror.getSyiErrorId();
        obj = s;
        byte byte0;
        if (!TextUtils.isEmpty(s1))
        {
            if (s1.equals("319"))
            {
                obj = getString(0x7f070b8d);
            } else
            {
                obj = getString(0x7f070b8c, new Object[] {
                    s1
                });
            }
        }
_L4:
        obj = new SpannableString(((CharSequence) (obj)));
        if (!"121919067".equals(ldserror.id))
        {
            Linkify.addLinks(((android.text.Spannable) (obj)), 1);
        }
        obj = (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f0705e5).setMessage(((CharSequence) (obj))).setPositiveButton(0x7f070738).setLinksClickable(true);
        if ("100000240".equals(ldserror.id))
        {
            ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setMessage(ldserror.parameterMessage);
            ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setMessageAsWebview(true);
        }
        byte0 = -1;
        publishDraftErrorForCallback = null;
        if (!TextUtils.isEmpty(ldserror.parameterRedirectUrl))
        {
            byte0 = 5;
            publishDraftErrorForCallback = ldserror;
        }
        ((com.ebay.app.AlertDialogFragment.Builder) (obj)).createFromActivity(byte0).show(getFragmentManager(), "publish_error");
        return;
_L2:
        obj = s;
        if ("121919188".equals(ldserror.id))
        {
            obj = s;
            if (!TextUtils.isEmpty(ldserror.parameterShortMessage))
            {
                obj = ldserror.parameterShortMessage;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void showReviewDialog(ListingDraft listingdraft)
    {
        if (!isPaused)
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putParcelable("key_params", draftDm.getParams());
            ReviewDialogFragment reviewdialogfragment = new ReviewDialogFragment();
            reviewdialogfragment.setArguments(((Bundle) (obj)));
            reviewdialogfragment.show(getFragmentManager(), "review_dialog");
            obj = new TrackingData("ReviewListing", TrackingType.EVENT);
            ((TrackingData) (obj)).addKeyValuePair("draft_id", listingdraft.id);
            if (listingdraft.category != null)
            {
                listingdraft = listingdraft.category.getStringValue();
            } else
            {
                listingdraft = null;
            }
            ((TrackingData) (obj)).addKeyValuePair("leaf", listingdraft);
            if (origItemId != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("origItemId", origItemId);
            } else
            {
                listingdraft = listingDraft.originalItemId.getStringValue();
                if (!listingdraft.equals("0"))
                {
                    ((TrackingData) (obj)).addKeyValuePair("origItemId", listingdraft);
                }
            }
            ((TrackingData) (obj)).addKeyValuePair("mfls", listingModeToTrackingMode(listingMode, true));
            ((TrackingData) (obj)).addKeyValuePair("smd", listingModeToTrackingMode(listingMode, false));
            if (isGuaranteeSelectedThisSession)
            {
                listingdraft = "1";
            } else
            {
                listingdraft = "0";
            }
            ((TrackingData) (obj)).addKeyValuePair("spg", listingdraft);
            ((TrackingData) (obj)).send(this);
        }
    }

    public void detachCategoryDialog()
    {
    }

    public com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.LoadDraftDetails generateLoadDraftDetails()
    {
        com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.LoadDraftDetails loaddraftdetails = new com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.LoadDraftDetails();
        Object obj = getIntent().getExtras();
        loaddraftdetails.draftId = ((Bundle) (obj)).getString("draft_id");
        if (loaddraftdetails.draftId != null)
        {
            return loaddraftdetails;
        }
        loaddraftdetails.sourceItemId = ((Bundle) (obj)).getString("source_item_id");
        loaddraftdetails.title = ((Bundle) (obj)).getString("title");
        loaddraftdetails.categoryId = ((Bundle) (obj)).getString("category_id");
        loaddraftdetails.epid = ((Bundle) (obj)).getString("epid");
        Object obj1 = MyApp.getPrefs();
        obj = ((Preferences) (obj1)).getAuthentication();
        ListingDraftPreferences listingdraftpreferences = new ListingDraftPreferences(this);
        loaddraftdetails.defaults.paypalEmail = listingdraftpreferences.getSellerPaypalEmail(((Authentication) (obj)));
        loaddraftdetails.defaults.country = listingdraftpreferences.getItemLocationCountry(((Authentication) (obj)));
        loaddraftdetails.defaults.zipcode = listingdraftpreferences.getItemLocationPostalCode(((Authentication) (obj)));
        obj1 = ((Preferences) (obj1)).getPostalCode();
        if (TextUtils.isEmpty(loaddraftdetails.defaults.country) && obj1 != null && !TextUtils.isEmpty(((PostalCodeSpecification) (obj1)).countryCode))
        {
            loaddraftdetails.defaults.country = ((PostalCodeSpecification) (obj1)).countryCode;
        }
        if (TextUtils.isEmpty(loaddraftdetails.defaults.zipcode) && obj1 != null && !TextUtils.isEmpty(((PostalCodeSpecification) (obj1)).postalCode))
        {
            loaddraftdetails.defaults.zipcode = ((PostalCodeSpecification) (obj1)).postalCode;
        }
        loaddraftdetails.defaults.shippingType = "FLAT_RATE";
        loaddraftdetails.defaults.cityState = listingdraftpreferences.getItemLocationCityState(((Authentication) (obj)));
        loaddraftdetails.defaults.handlingTime = listingdraftpreferences.getHandlingTime(((Authentication) (obj)));
        loaddraftdetails.defaults.returnsAccepted = listingdraftpreferences.getReturnPolicy(((Authentication) (obj)));
        loaddraftdetails.defaults.returnPeriod = listingdraftpreferences.getReturnPolicyWithin(((Authentication) (obj)));
        loaddraftdetails.defaults.refundMethod = listingdraftpreferences.getReturnPolicyRefundType(((Authentication) (obj)));
        loaddraftdetails.defaults.refundShipmentPayee = listingdraftpreferences.getReturnPolicyShippingPaidBy(((Authentication) (obj)));
        loaddraftdetails.defaults.restockingFee = listingdraftpreferences.getReturnPolicyRestockingFee(((Authentication) (obj)));
        loaddraftdetails.defaults.policyDetails = listingdraftpreferences.getReturnPolicyAdditionalDetails(((Authentication) (obj)));
        loaddraftdetails.defaults.acceptedPaymentMethods = listingdraftpreferences.getPaymentMethods(((Authentication) (obj)), draftSite);
        return loaddraftdetails;
    }

    public PhotoManagerViewAdapter getConfigChangeBackupAdapter()
    {
        PhotoManagerViewAdapter photomanagerviewadapter = configChangeBackup;
        configChangeBackup = null;
        return photomanagerviewadapter;
    }

    public String getSelectedCategoryId()
    {
        return listingDraft.category.getStringValue();
    }

    public String getSelectedCategoryIdPath()
    {
        return listingDraft.categoryIdPath.getStringValue();
    }

    public String getTrackingEventName()
    {
        return "Selling";
    }

    public boolean isDataAvailable()
    {
        return listingDraft != null && listingDraft.id != null;
    }

    public String keywordsForSuggestions()
    {
        return listingDraft.title.getStringValue();
    }

    public void launchSellerRegistration()
    {
        LdsError ldserror = publishDraftErrorForCallback;
        if (ldserror == null)
        {
            return;
        }
        Object obj = new TrackingData("AppEvents", TrackingType.EVENT);
        ((TrackingData) (obj)).addKeyValuePair("mfls", "ASR");
        ((TrackingData) (obj)).send(this);
        String s = LdsError.getRedirectUrlWithReplacements(ldserror);
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = MyApp.getDeviceConfiguration().sellerRegistrationUrl();
        }
        s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = MyApp.getPrefs().getCurrentCountry();
            s = (new StringBuilder()).append("http://www.").append(((EbayCountry) (obj)).getSiteDomain()).toString();
        }
        obj = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
        ((Intent) (obj)).putExtra("url", s);
        ((Intent) (obj)).putExtra("use_sso", true);
        ((Intent) (obj)).putExtra("android.intent.extra.TITLE", getString(0x7f070903));
        ((Intent) (obj)).putExtra("ok", false);
        if (TextUtils.isEmpty(ldserror.parameterRuPlaceHolder))
        {
            ((Intent) (obj)).putExtra(ShowWebViewActivity.EXTRA_DONE_PATTERN, ".*\\?SellHub.*");
        }
        ((Intent) (obj)).putExtra("impression", "SellerRegistrationStart");
        ((Intent) (obj)).putExtra("trackingPair", new String[] {
            "smd", listingModeToTrackingMode(listingMode, false)
        });
        startActivityForResult(((Intent) (obj)), 1);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 32
    //                   2 78;
           goto _L1 _L2 _L3
_L1:
        super.onActivityResult(i, j, intent);
        return;
_L2:
        if (j == -1)
        {
            EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
            String s = MyApp.getPrefs().getCurrentUser();
            RoiTrackingUtil.trackRoi(this, "RegSell-MobileApp", ebaycountry.site, s);
            draftDm.publishDraft(null);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            draftDm.publishDraft(null);
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onBackPressed()
    {
        if (getResources().getBoolean(0x7f0b0006) && "ReviseItem".equals(listingMode))
        {
            showDiscardDraft();
            return;
        }
        Fragment fragment = getFragmentManager().findFragmentById(0x7f100648);
        if (fragment instanceof PhotosSpokeFragment)
        {
            ((PhotosSpokeFragment)fragment).onBackPressed();
            return;
        }
        if (fragment instanceof BaseSpokeFragment)
        {
            ((BaseSpokeFragment)fragment).onBackPressed();
            return;
        }
        if (fragment instanceof DialogFragment)
        {
            getFragmentManager().popBackStack();
            return;
        }
        if ("ReviseItem".equals(listingMode))
        {
            showDiscardDraft();
            return;
        } else
        {
            finishAndReturnDraft();
            return;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        draftDm.cancelDraftValidation();
        ModalProgressFragment.hide(getFragmentManager());
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f10013f)
        {
            setLoadingState(LoadingState.LOADING);
            draftDm.retryLastRequest();
        } else
        if (view.getId() == 0x7f1003ab)
        {
            onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = getFragmentManager().findFragmentByTag("currentFragment");
        if ((configuration instanceof PhotoManagerFragment) && !isPaused)
        {
            configChangeBackup = ((PhotoManagerFragment)configuration).removeAdapter();
            FragmentTransaction fragmenttransaction;
            PhotosSpokeFragment photosspokefragment;
            Bundle bundle;
            if (getResources().getBoolean(0x7f0b0006))
            {
                getFragmentManager().beginTransaction().remove(configuration).commitAllowingStateLoss();
            } else
            {
                getFragmentManager().popBackStack();
            }
            fragmenttransaction = getFragmentManager().beginTransaction();
            photosspokefragment = new PhotosSpokeFragment();
            bundle = new Bundle();
            bundle.putAll(configuration.getArguments());
            photosspokefragment.setArguments(bundle);
            fragmenttransaction.replace(0x7f100648, photosspokefragment, "currentFragment");
            if (!getResources().getBoolean(0x7f0b0006))
            {
                fragmenttransaction.addToBackStack(null);
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (!listingdraftcontent.getStatus().hasError()) goto _L2; else goto _L1
_L1:
        handleError(listingdraftcontent);
        _cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType[dispatchtype.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 45;
           goto _L3 _L4 _L4
_L3:
        return;
_L4:
        sendTrackingForSellCatalogItem((ListingDraft)listingdraftcontent.getData(), false);
        return;
_L2:
        isGuaranteeSelectedThisSession = listingdraftcontent.isGuaranteeSelectedThisSession;
        _cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType[dispatchtype.ordinal()];
        JVM INSTR tableswitch 1 10: default 128
    //                   1 296
    //                   2 468
    //                   3 254
    //                   4 254
    //                   5 254
    //                   6 265
    //                   7 279
    //                   8 507
    //                   9 528
    //                   10 528;
           goto _L5 _L6 _L7 _L8 _L8 _L8 _L9 _L10 _L11 _L12 _L12
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        break; /* Loop/switch isn't completed */
_L14:
        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType[dispatchtype.ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            break;
        }
        if (trackedSpokes == null)
        {
            trackedSpokes = trackingSpokeCompletionState.getCheckedSpokesForTracking();
        }
        trackingSpokeCompletionState.update(listingdraftcontent);
        listingdraftdatamanager = trackingSpokeCompletionState.getCheckedSpokesForTracking();
        if (!listingdraftdatamanager.equals(trackedSpokes))
        {
            trackedSpokes = listingdraftdatamanager;
            sendTrackingForEvent(getTrackingEventName(), true, true, false, true);
            return;
        }
        if (true) goto _L3; else goto _L13
_L13:
        ModalProgressFragment.show(getFragmentManager(), this);
          goto _L14
_L9:
        handleValidationResult((ListingDraft)listingdraftcontent.getData());
          goto _L14
_L10:
        handlePublishResult((ListingDraft)listingdraftdatamanager.getPublishContent().getData());
          goto _L14
_L6:
        listingDraft = (ListingDraft)listingdraftcontent.getData();
        handleLoadResult(listingDraft);
        sendTrackingForSellCatalogItem(listingDraft, true);
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.B.guarantee) && listingDraft.listingMode.equals("ReviseItem") && listingDraft.guaranteeProvided != null && listingDraft.guaranteeProvided.getBooleanValue() && listingDraft.guaranteeSalePrice != null && listingDraft.guaranteeSalePrice.getStringValue() != null)
        {
            listingdraftdatamanager = EbayCurrencyUtil.formatDisplay(listingDraft.getCurrencyCode(), listingDraft.guaranteeSalePrice.getDoubleValue(), 0);
            (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(getString(0x7f07015f, new Object[] {
                listingdraftdatamanager
            })).setPositiveButton(0x7f070738).createFromActivity(0).show(getFragmentManager(), "guarantee_warning");
        }
          goto _L14
_L7:
        listingDraft = (ListingDraft)listingdraftcontent.getData();
        handleLoadResult(listingDraft);
        sendTrackingForSellCatalogItem(listingDraft, true);
        showReviewDialog(listingDraft);
          goto _L14
_L11:
        ModalProgressFragment.hide(getFragmentManager());
        listingDraft = (ListingDraft)listingdraftcontent.getData();
          goto _L14
_L12:
        if (listingDraft.id == null)
        {
            handleLoadResult((ListingDraft)listingdraftcontent.getData());
        } else
        if (!loadingState.equals(LoadingState.LOADED))
        {
            listingDraft = (ListingDraft)listingdraftcontent.getData();
            setLoadingState(LoadingState.LOADED);
        } else
        {
            listingDraft = (ListingDraft)listingdraftcontent.getData();
        }
          goto _L14
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030201);
        if (!MyApp.getPrefs().isSignedIn())
        {
            handleIafTokenExpiration();
            finish();
            return;
        }
        ((TextView)findViewById(0x7f1003a5)).setText(getTitle());
        leftPane = findViewById(0x7f100649);
        rightPane = findViewById(0x7f100648);
        loadingLayout = findViewById(0x7f100143);
        errorLayout = findViewById(0x7f10013c);
        errorLayout.setBackgroundColor(getResources().getColor(0x106000b));
        errorLayout.setVisibility(8);
        errorPrimary = (TextView)findViewById(0x7f10013d);
        errorSecondary = (TextView)findViewById(0x7f10013e);
        retryButton = findViewById(0x7f10013f);
        retryButton.setOnClickListener(this);
        findViewById(0x7f1003ab).setOnClickListener(this);
        setLoadingState(LoadingState.LOADING);
        Bundle bundle1 = getIntent().getExtras();
        draftSite = (EbaySite)bundle1.getParcelable("site");
        if (draftSite == null)
        {
            Log.e(com/ebay/mobile/sell/ListingFragmentActivity.getSimpleName(), "Intent must include site");
            finish();
            return;
        }
        origItemId = bundle1.getString("source_item_id");
        listingMode = bundle1.getString("listing_mode");
        if (listingMode == null)
        {
            listingMode = "AddItem";
        }
        if (bundle == null)
        {
            keyParams = new com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams(keyIdGenerator.getAndIncrement(), listingMode, draftSite);
            migrateListingFormPreferences();
            sendTrackingForEvent("NewListing", true, true, true, false);
            if (getIntent().getIntExtra("noti_type_id", -1) != -1)
            {
                ServiceStarter.startUpdateNotificationCacheService(this, com.ebay.common.model.mdns.NotificationPreference.EventType.ADDPHOTO.name(), null);
            }
            bundle = getFragmentManager().beginTransaction();
            HubFragment hubfragment = new HubFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("key_params", keyParams);
            hubfragment.setArguments(bundle2);
            if (getResources().getBoolean(0x7f0b0006))
            {
                bundle.replace(0x7f100649, hubfragment);
            } else
            {
                bundle.replace(0x7f100648, hubfragment);
            }
            bundle.commit();
        } else
        {
            keyParams = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)bundle.getParcelable("key_params");
        }
        initDataManagers();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 2131167146: 
            return PpaUpgradeConfirmDialog.create(this, false);
        }
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   1: 101
    //                   2: 114
    //                   3: 124
    //                   4: 223
    //                   5: 233
    //                   100: 61;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L7:
        if (j == 3)
        {
            getFwLoaderManager().cancelLoader(2, true);
            dialogfragment = getFragmentManager().findFragmentByTag("currentFragment");
            if (dialogfragment instanceof PhotoManagerFragment)
            {
                ((PhotoManagerFragment)dialogfragment).onUploadCanceled();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == 1)
        {
            draftDm.updateDropProduct();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == 1)
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (j == 1)
        {
            showReviewDialog(listingDraft);
            return;
        }
        if (j == 2)
        {
            dialogfragment = null;
            Iterator iterator = listingDraft.warnings.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                LdsError ldserror = (LdsError)iterator.next();
                if ("121919158".equals(ldserror.id))
                {
                    dialogfragment = ldserror;
                }
            } while (true);
            if (dialogfragment != null)
            {
                HubFragment hubfragment = getHubFragment();
                if (hubfragment != null)
                {
                    hubfragment.navigateToValidationErrorLocation(((LdsError) (dialogfragment)).inputRefId);
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (j == 1)
        {
            launchEftEditor();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j == 1)
        {
            launchPublishErrorRedirect();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        DeviceConfiguration.getAsync();
        draftDm = (ListingDraftDataManager)getDataManagerContainer().initialize(keyParams, this);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 101)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        super.onPause();
        isPaused = true;
        if (isFinishing() && draftDm != null)
        {
            draftDm.resetListingFormSession();
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        ModalProgressFragment.hide(getFragmentManager());
        cachedStartPrice = bundle.getString("auctionStartPrice");
        tracking_charityLoaded = bundle.getBoolean("charityLoaded");
        tracking_charityChanged = bundle.getBoolean("charityChanged");
        tracking_donationPercentageChanged = bundle.getBoolean("donationPercentageChanged");
        publishDraftErrorForCallback = (LdsError)bundle.getParcelable("publishErrorForCallback");
    }

    public void onResume()
    {
        super.onResume();
        if (!MyApp.getPrefs().isSignedIn())
        {
            handleIafTokenExpiration();
            return;
        } else
        {
            isPaused = false;
            sendTrackingForEvent(getTrackingEventName(), true, true, false, true);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("key_params", keyParams);
        bundle.putString("auctionStartPrice", cachedStartPrice);
        bundle.putBoolean("charityLoaded", tracking_charityLoaded);
        bundle.putBoolean("charityChanged", tracking_charityChanged);
        bundle.putBoolean("donationPercentageChanged", tracking_donationPercentageChanged);
        bundle.putParcelable("publishErrorForCallback", publishDraftErrorForCallback);
        super.onSaveInstanceState(bundle);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        i;
        JVM INSTR tableswitch 2 2: default 20
    //                   2 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        PhotoManagerFragment.hideProgress(this);
        fwloader = (UploadPhotoNetLoader)fwloader;
        if (!fwloader.isError() && fwloader.getResponse() != null)
        {
            urlForUploadedPhoto = ((UploadSiteHostedPicturesResponse)fwloader.getResponse()).image.fullUrl.toString();
            fwloader = getFragmentManager().findFragmentById(0x7f100648);
            if (fwloader instanceof PhotoManagerFragment)
            {
                ((PhotoManagerFragment)fwloader).onUploadComplete();
                return;
            }
        } else
        if (fwloader.getResponse() != null && EbayErrorUtil.userNotLoggedIn(((UploadSiteHostedPicturesResponse)fwloader.getResponse()).getResultStatus().getMessages()))
        {
            handleIafTokenExpiration();
            return;
        } else
        {
            Toast.makeText(this, getString(0x7f07078d), 1).show();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void sendTrackingForSpokeEvent(String s)
    {
        Object obj = null;
        TrackingData trackingdata = new TrackingData(s, TrackingType.PAGE_IMPRESSION);
        if (listingDraft == null)
        {
            s = null;
        } else
        {
            s = listingDraft.id;
        }
        trackingdata.addKeyValuePair("draft_id", s);
        trackingdata.addKeyValuePair("smd", getCurrentListingModeForMts());
        s = obj;
        if (listingDraft != null)
        {
            s = obj;
            if (listingDraft.category != null)
            {
                s = listingDraft.category.getStringValue();
            }
        }
        trackingdata.addKeyValuePair("leaf", s);
        trackingdata.send(this);
    }

    public void setCharityChanged(boolean flag)
    {
        tracking_charityChanged = flag;
    }

    public void setCharityLoaded(boolean flag)
    {
        tracking_charityLoaded = flag;
    }

    public void setDonationChanged(boolean flag)
    {
        tracking_donationPercentageChanged = flag;
    }

    public boolean showMotorsWithUsCats()
    {
        return false;
    }

    public void uploadPhoto(UploadPhotoNetLoader uploadphotonetloader)
    {
        getFwLoaderManager().start(2, uploadphotonetloader, true);
    }

    public String urlForUploadedPhoto()
    {
        String s = urlForUploadedPhoto;
        urlForUploadedPhoto = null;
        return s;
    }

}
