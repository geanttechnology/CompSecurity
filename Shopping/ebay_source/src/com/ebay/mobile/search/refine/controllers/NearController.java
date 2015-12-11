// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.HasCustomContent;
import com.ebay.mobile.search.PromptDialogFragment;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchActivitySync;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.search.SummarizableWithDefault;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            BaseDetailController

public class NearController extends BaseDetailController
    implements android.os.Handler.Callback, TextWatcher, android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener, HasCustomContent, com.ebay.mobile.search.PromptForStringDialogFragment.PromptForStringCompletedListener, SummarizableWithDefault, com.ebay.mobile.util.ContentSyncManager.ContentSync
{

    private static final int DEFAULT_LOCAL_PICKUP_DISTANCE = 100;
    private static final String EXTRA_BOOL_ALLOW_SEARCH = "NearController.flags.no_search";
    private static final String EXTRA_DIRTY_ZIP = "ZIP";
    private static String EXTRA_LAST_EXPLICIT_DISTANCE = "lastDistance";
    private static final String MSGDATA_ZIP = "zip";
    public static final int MSG_LOC_UNAVAILABLE = 2;
    public static final int MSG_UPDATE_ZIP = 1;
    private static final String REASON_CHECK_EBN = "NearController.reason.ebn.checked";
    private static final String REASON_CHECK_LOCAL_PICKUP = "NearController.reason.localPickup.checked";
    private static final String REASON_CHECK_STORE_PICKUP = "NearController.reason.storePickup.checked";
    private static final String REASON_MAX_DISTANCE_CLICK = "NearController.reason.max.distance.clicked";
    public static String SYNC_NEAR_SUMMARY = "syncRefineNear";
    private boolean dirty;
    private View distanceButton;
    private View distanceButtonDivider;
    private TextView distanceSummary;
    private View ebnLayout;
    private TextView ebnText;
    private int lastExplicitDistance;
    private final LocationListener lastLocationListener = null;
    private View localPickupLayout;
    private View storePickupDivider;
    private View storePickupLayout;
    private CheckBox toggleEbn;
    private CheckBox toggleLocalPickup;
    private CheckBox toggleStorePickup;
    private EditText zipCodeField;
    private final Handler zipUpdateHandler = new Handler(this);

    public NearController(SearchRefineFragment searchrefinefragment)
    {
        super(searchrefinefragment);
        lastExplicitDistance = 0;
        localPickupLayout = null;
        toggleLocalPickup = null;
        storePickupLayout = null;
        storePickupDivider = null;
        toggleStorePickup = null;
        ebnLayout = null;
        toggleEbn = null;
        ebnText = null;
        dirty = false;
        distanceSummary = null;
    }

    private boolean applyChanges(boolean flag)
    {
        String s = getSanitizedZipCode(zipCodeField.getText().toString());
        SearchParameters searchparameters = getSearchParameters();
        boolean flag1;
        if (TextUtils.isEmpty(searchparameters.buyerPostalCode) != TextUtils.isEmpty(s) || !s.equals(searchparameters.buyerPostalCode))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!TextUtils.isEmpty(s) && flag1)
        {
            searchparameters.buyerPostalCode = s;
            updateVisibility();
            if (flag)
            {
                unlockPanel();
                searchParamsUpdated();
            }
        }
        dirty = false;
        return flag1;
    }

    private void applyCurrentLocation(final boolean promptWhenLocationUnavailable)
    {
        (new Thread(new Runnable() {

            final NearController this$0;
            final boolean val$promptWhenLocationUnavailable;

            public void run()
            {
                Object obj;
                Object obj1;
                obj = Locale.getDefault();
                obj1 = getSearchParameters().country.site;
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_27;
                }
                obj = ((EbaySite) (obj1)).getLocale();
                obj = new Geocoder(refineActivity, ((Locale) (obj)));
                obj1 = LocationUtil.getLastKnownLocation(refineActivity);
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_130;
                }
                obj = ((Geocoder) (obj)).getFromLocation(((Location) (obj1)).getLatitude(), ((Location) (obj1)).getLongitude(), 1);
                if (((List) (obj)).size() > 0)
                {
                    obj = ((Address)((List) (obj)).get(0)).getPostalCode();
                    Message message = zipUpdateHandler.obtainMessage(1);
                    message.getData().putString("zip", ((String) (obj)));
                    zipUpdateHandler.sendMessage(message);
                    return;
                }
                try
                {
                    if (promptWhenLocationUnavailable)
                    {
                        zipUpdateHandler.sendEmptyMessage(2);
                        return;
                    }
                }
                catch (IOException ioexception) { }
                return;
            }

            
            {
                this$0 = NearController.this;
                promptWhenLocationUnavailable = flag;
                super();
            }
        })).start();
    }

    private Bundle getPromptExtrasBundle(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("NearController.flags.no_search", flag);
        return bundle;
    }

    private static String getSanitizedZipCode(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return s;
        } else
        {
            s = s.replaceAll("[\\[\\]\\<\\>;]", "");
            return s.substring(0, Math.min(15, s.length()));
        }
    }

    private void notifySummaryChanged()
    {
        ContentSyncManager.notifyUpdate(this, SYNC_NEAR_SUMMARY);
    }

    private boolean onCheckEbn(boolean flag, boolean flag1)
    {
        SearchParameters searchparameters = getSearchParameters();
        if (flag)
        {
            if (TextUtils.isEmpty(zipCodeField.getText()) && !refineFragment.checkForPostalCode("NearController.reason.ebn.checked", getPromptExtrasBundle(false)))
            {
                onCheckEbn(false, false);
                return false;
            }
            onCheckLocalPickup(false, false);
            lastExplicitDistance = searchparameters.maxDistance;
            searchparameters.maxDistance = 0;
        } else
        {
            searchparameters.maxDistance = lastExplicitDistance;
        }
        searchparameters.ebnOnly = flag;
        toggleEbn.setChecked(flag);
        if (flag1)
        {
            updateDistanceSummary();
            notifySummaryChanged();
            updateVisibility();
            searchParamsUpdated();
        }
        return true;
    }

    private boolean onCheckLocalPickup(boolean flag, boolean flag1)
    {
        SearchParameters searchparameters = getSearchParameters();
        if (flag)
        {
            if (TextUtils.isEmpty(zipCodeField.getText()) && !refineFragment.checkForPostalCode("NearController.reason.localPickup.checked", getPromptExtrasBundle(false)))
            {
                onCheckLocalPickup(false, false);
                return false;
            }
            onCheckStorePickup(false, false);
            onCheckEbn(false, false);
            lastExplicitDistance = searchparameters.maxDistance;
            if (searchparameters.maxDistance <= 0)
            {
                searchparameters.maxDistance = 100;
            }
        } else
        {
            searchparameters.maxDistance = lastExplicitDistance;
        }
        searchparameters.localPickupOnly = flag;
        toggleLocalPickup.setChecked(flag);
        if (flag1)
        {
            updateDistanceSummary();
            notifySummaryChanged();
            updateVisibility();
            searchParamsUpdated();
        }
        return true;
    }

    private boolean onCheckStorePickup(boolean flag, boolean flag1)
    {
        SearchParameters searchparameters = getSearchParameters();
        if (flag)
        {
            if (TextUtils.isEmpty(zipCodeField.getText()) && !refineFragment.checkForPostalCode("NearController.reason.storePickup.checked", getPromptExtrasBundle(false)))
            {
                onCheckStorePickup(false, false);
                return false;
            }
            onCheckLocalPickup(false, false);
            lastExplicitDistance = searchparameters.maxDistance;
            searchparameters.maxDistance = 0;
        } else
        {
            searchparameters.maxDistance = lastExplicitDistance;
        }
        searchparameters.inStorePickupOnly = flag;
        toggleStorePickup.setChecked(flag);
        if (flag1)
        {
            updateDistanceSummary();
            notifySummaryChanged();
            updateVisibility();
            searchParamsUpdated();
        }
        return true;
    }

    private void showMaxDistanceWithZipcode()
    {
        if (!TextUtils.isEmpty(zipCodeField.getText()))
        {
            refineFragment.showDetail(DetailMode.SL_DISTANCE);
            return;
        } else
        {
            refineFragment.checkForPostalCode("NearController.reason.max.distance.clicked", getPromptExtrasBundle(false));
            return;
        }
    }

    private void unlockPanel()
    {
        unlockRefinements(new com.ebay.mobile.search.RefinementLocks.RefinementLockType[] {
            com.ebay.mobile.search.RefinementLocks.RefinementLockType.LOCALPICKUP, com.ebay.mobile.search.RefinementLocks.RefinementLockType.ZIPCODE, com.ebay.mobile.search.RefinementLocks.RefinementLockType.MAXDISTANCE, com.ebay.mobile.search.RefinementLocks.RefinementLockType.INSTOREPICKUP, com.ebay.mobile.search.RefinementLocks.RefinementLockType.EBN
        });
    }

    private void updateDistanceSummary()
    {
        SummarizableWithDefault summarizablewithdefault = (SummarizableWithDefault)refineFragment.getController(DetailMode.SL_DISTANCE);
        distanceSummary.setText(summarizablewithdefault.getSummary());
        TextView textview = distanceSummary;
        int i;
        if (summarizablewithdefault.isDefault())
        {
            i = SearchRefineFragment.textLowlightColor;
        } else
        {
            i = SearchRefineFragment.textHighlightColor;
        }
        textview.setTextColor(i);
    }

    private void updateVisibility()
    {
        if (customView == null)
        {
            return;
        }
        SearchParameters searchparameters = getSearchParameters();
        int i;
        if (SearchUtil.bopisRefinementEnabled(searchparameters))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        storePickupLayout.setVisibility(i);
        storePickupDivider.setVisibility(i);
        if (SearchUtil.ebnRefinementEnabled(searchparameters))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ebnLayout.setVisibility(i);
        if (refineFragment.searchActivitySync.isGbhSearch() || searchparameters.inStorePickupOnly || searchparameters.ebnOnly)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        distanceButton.setVisibility(i);
        distanceButtonDivider.setVisibility(i);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public View createView()
    {
        View view = refineFragment.getInflater().inflate(0x7f0301e1, parentView, false);
        localPickupLayout = view.findViewById(0x7f1005e1);
        toggleLocalPickup = (CheckBox)localPickupLayout.findViewById(0x7f1005e2);
        localPickupLayout.setOnClickListener(this);
        toggleLocalPickup.setOnClickListener(this);
        storePickupLayout = view.findViewById(0x7f1005dc);
        storePickupDivider = view.findViewById(0x7f1005e0);
        toggleStorePickup = (CheckBox)storePickupLayout.findViewById(0x7f1005dd);
        ebnLayout = view.findViewById(0x7f1005d7);
        toggleEbn = (CheckBox)view.findViewById(0x7f1005d8);
        ebnText = (TextView)view.findViewById(0x7f1005d9);
        byte byte0 = 8;
        if (SearchUtil.bopisRefinementEnabled(getSearchParameters()))
        {
            storePickupLayout.setOnClickListener(this);
            toggleStorePickup.setOnClickListener(this);
            byte0 = 0;
        }
        storePickupLayout.setVisibility(byte0);
        toggleStorePickup.setVisibility(byte0);
        byte0 = 8;
        if (SearchUtil.ebnRefinementEnabled(getSearchParameters()))
        {
            ebnLayout.setOnClickListener(this);
            toggleEbn.setOnClickListener(this);
            byte0 = 0;
        }
        Object obj = getSearchParameters().country;
        ((TextView)view.findViewById(0x7f1005de)).setText(getString(SearchUtil.getInStorePickupResourceForCountry(((EbayCountry) (obj)))));
        ebnText.setText(SearchUtil.getEbayNowResourceForCountry(((EbayCountry) (obj))));
        ebnLayout.setVisibility(byte0);
        toggleEbn.setVisibility(byte0);
        distanceSummary = (TextView)view.findViewById(0x7f1005eb);
        zipCodeField = (EditText)view.findViewById(0x7f1005e7);
        zipCodeField.addTextChangedListener(this);
        zipCodeField.setOnEditorActionListener(this);
        distanceButton = view.findViewById(0x7f1005e9);
        distanceButton.setOnClickListener(this);
        distanceButtonDivider = view.findViewById(0x7f1005ec);
        obj = view.findViewById(0x7f1005e8);
        if (refineFragment.searchActivitySync.isUseMyLocationEnabled())
        {
            ((View) (obj)).setOnClickListener(this);
            return view;
        } else
        {
            ((View) (obj)).setVisibility(8);
            return view;
        }
    }

    public String getDefaultSummary()
    {
        return getString(0x7f070980);
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.NEAR;
    }

    public Bundle getStateExtras()
    {
        Bundle bundle = super.getStateExtras();
        String s = zipCodeField.getText().toString();
        if (!s.equals(getSearchParameters().buyerPostalCode))
        {
            bundle.putString("ZIP", s);
            bundle.putInt(EXTRA_LAST_EXPLICIT_DISTANCE, lastExplicitDistance);
        }
        return bundle;
    }

    public String getSummary()
    {
        SearchParameters searchparameters = getSearchParameters();
        SummarizableWithDefault summarizablewithdefault = (SummarizableWithDefault)refineFragment.getController(DetailMode.SL_DISTANCE);
        ArrayList arraylist = new ArrayList();
        if (searchparameters.localPickupOnly)
        {
            arraylist.add(getString(0x7f0700b7));
        }
        if (searchparameters.inStorePickupOnly)
        {
            arraylist.add(getString(SearchUtil.getInStorePickupResourceForCountry(searchparameters.country)));
        }
        if (searchparameters.ebnOnly)
        {
            arraylist.add(getString(SearchUtil.getEbayNowResourceForCountry(searchparameters.country)));
        }
        if (!TextUtils.isEmpty(searchparameters.buyerPostalCode) && !summarizablewithdefault.isDefault())
        {
            arraylist.add(String.format(getString(0x7f070979), new Object[] {
                summarizablewithdefault.getSummary(), searchparameters.buyerPostalCode.toString()
            }));
        }
        if (arraylist.size() == 0)
        {
            return getDefaultSummary();
        } else
        {
            return TextUtils.join(", ", arraylist);
        }
    }

    public String getTitle()
    {
        return getString(0x7f070576);
    }

    public boolean handleMessage(Message message)
    {
        if (!isActive() || customView == null)
        {
            return false;
        }
        message.what;
        JVM INSTR tableswitch 1 2: default 44
    //                   1 46
    //                   2 78;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        zipCodeField.setText(message.getData().getString("zip"));
        applyChanges(true);
        updateDistanceSummary();
        updateVisibility();
_L5:
        return true;
_L3:
        PromptDialogFragment.Show(refineFragment.getFragmentManager(), 0x7f07097e, 0x7f070973);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean isDefault()
    {
        return getSummary().equals(getDefaultSummary());
    }

    public void onClick(View view)
    {
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag = false;
        switch (view.getId())
        {
        case 2131756505: 
        case 2131756506: 
        case 2131756507: 
        case 2131756510: 
        case 2131756511: 
        case 2131756512: 
        case 2131756515: 
        case 2131756516: 
        case 2131756517: 
        case 2131756518: 
        case 2131756519: 
        default:
            return;

        case 2131756513: 
        case 2131756514: 
            applyChanges(false);
            if (!getSearchParameters().localPickupOnly)
            {
                flag = true;
            }
            onCheckLocalPickup(flag, true);
            unlockPanel();
            return;

        case 2131756508: 
        case 2131756509: 
            applyChanges(false);
            boolean flag1 = flag3;
            if (!getSearchParameters().inStorePickupOnly)
            {
                flag1 = true;
            }
            onCheckStorePickup(flag1, true);
            unlockPanel();
            return;

        case 2131756520: 
            applyCurrentLocation(true);
            updateVisibility();
            return;

        case 2131756503: 
        case 2131756504: 
            applyChanges(false);
            boolean flag2 = flag4;
            if (!getSearchParameters().ebnOnly)
            {
                flag2 = true;
            }
            onCheckEbn(flag2, true);
            unlockPanel();
            updateVisibility();
            return;

        case 2131756521: 
            applyChanges(false);
            showMaxDistanceWithZipcode();
            return;
        }
    }

    public void onDoneClicked()
    {
        applyChanges(true);
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i == 6)
        {
            flag = applyChanges(true);
        }
        return flag;
    }

    public void onPause()
    {
        Util.hideSoftInput(refineActivity, zipCodeField);
        if (dirty)
        {
            applyChanges(true);
        }
        ContentSyncManager.notifyUpdate(this, SYNC_NEAR_SUMMARY);
        if (lastLocationListener != null)
        {
            LocationUtil.cancelLocationListener(refineActivity, lastLocationListener);
        }
        notifySummaryChanged();
        super.onPause();
    }

    public void onPromptForStringCompleted(String s, boolean flag, String s1, Bundle bundle)
    {
        boolean flag1;
        if (!TextUtils.isEmpty(s))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        zipCodeField.setText(getSanitizedZipCode(s));
        if (!s1.equals("NearController.reason.localPickup.checked")) goto _L4; else goto _L3
_L3:
        onCheckLocalPickup(true, false);
_L2:
        notifySummaryChanged();
        applyChanges(bundle.getBoolean("NearController.flags.no_search"));
        return;
_L4:
        if (s1.equals("NearController.reason.storePickup.checked"))
        {
            onCheckStorePickup(true, false);
        } else
        if (s1.equals("NearController.reason.ebn.checked"))
        {
            onCheckEbn(true, false);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onResume()
    {
        super.onResume();
        if (deferredStateExtras != null)
        {
            zipCodeField.setText(deferredStateExtras.getString("ZIP"));
            if (deferredStateExtras.containsKey(EXTRA_LAST_EXPLICIT_DISTANCE))
            {
                lastExplicitDistance = deferredStateExtras.getInt(EXTRA_LAST_EXPLICIT_DISTANCE);
            }
            deferredStateExtras = null;
        }
        onSearchParametersUpdated(getSearchParameters(), null, null);
        refineFragment.trackingEventListener.onRefineNear();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        if (customView != null)
        {
            zipCodeField.setText(searchparameters.buyerPostalCode);
            toggleLocalPickup.setChecked(searchparameters.localPickupOnly);
            toggleStorePickup.setChecked(searchparameters.inStorePickupOnly);
            toggleEbn.setChecked(searchparameters.ebnOnly);
            if (!searchparameters.ebnOnly && !searchparameters.localPickupOnly && !searchparameters.inStorePickupOnly)
            {
                lastExplicitDistance = searchparameters.maxDistance;
            }
            updateDistanceSummary();
            updateVisibility();
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        dirty = true;
    }

    public void updateContent(String s, Object obj)
    {
        if (s.equals("zipCode"))
        {
            s = (String)obj;
            if (!TextUtils.isEmpty(s) && getRefinementLocks().getLockState(com.ebay.mobile.search.RefinementLocks.RefinementLockType.ZIPCODE, getSearchParameters()) != 1)
            {
                zipCodeField.setText(s);
            }
        }
    }


}
