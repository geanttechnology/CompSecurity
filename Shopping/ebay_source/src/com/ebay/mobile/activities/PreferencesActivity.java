// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.TwoStatePreference;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Switch;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.net.api.usage.Usage;
import com.ebay.common.util.LruHistoryCache;
import com.ebay.common.view.util.DialogManager;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.AddressListActivity;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.notifications.DevLog;
import com.ebay.mobile.notifications.EbaySmartNotificationManager;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.mobile.preference.DeveloperPreferenceFragment;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.mobile.search.LruVisitedItemCache;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.settings.AboutPreferencesFragment;
import com.ebay.mobile.settings.AdsOptOutFragment;
import com.ebay.mobile.settings.BuyingNotificationPreferencesFragment;
import com.ebay.mobile.settings.CountryPreferencesFragment;
import com.ebay.mobile.settings.EulaWebviewFragment;
import com.ebay.mobile.settings.GeneralNotificationPreferencesFragment;
import com.ebay.mobile.settings.NotificationPreferencesFragment;
import com.ebay.mobile.settings.NotificationSoundsPreferencesFragment;
import com.ebay.mobile.settings.PreferredCountryPreferenceFragment;
import com.ebay.mobile.settings.PrivacyWebviewFragment;
import com.ebay.mobile.settings.SellingNotificationPreferencesFragment;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.activities:
//            CorePreferenceActivity, eBay, SignInModalActivity, OcsActivity, 
//            ShowFileWebViewActivity, ShowWebViewActivity

public class PreferencesActivity extends CorePreferenceActivity
    implements android.preference.Preference.OnPreferenceChangeListener, DialogFragmentCallback, com.ebay.mobile.util.ContentSyncManager.ContentSync
{
    private class AddressDataManagerObserver extends com.ebay.nautilus.domain.content.dm.AddressDataManager.SimpleObserver
    {

        final PreferencesActivity this$0;

        public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
        {
            if (!isFinishing())
            {
                if (content.getStatus().hasError())
                {
                    shippingAddresses = null;
                } else
                {
                    shippingAddresses = (List)content.getData();
                }
                updateShippingAddressLayout();
                if (flag)
                {
                    BaseCheckoutActivity.handleDefaultAddressChange(PreferencesActivity.this, userContextDataManager, shippingAddresses, false, "Sign In");
                    return;
                }
            }
        }

        private AddressDataManagerObserver()
        {
            this$0 = PreferencesActivity.this;
            super();
        }

    }

    private class HeaderAdapter extends ArrayAdapter
    {

        private static final int HEADER_TYPE_CATEGORY = 0;
        private static final int HEADER_TYPE_COUNT = 3;
        private static final int HEADER_TYPE_NORMAL = 1;
        private static final int HEADER_TYPE_SWITCH = 2;
        private final LayoutInflater mInflater;
        final PreferencesActivity this$0;

        private int getHeaderType(android.preference.PreferenceActivity.Header header)
        {
            if (isSwitch(header) || isSwitchMultiPane(header))
            {
                return 2;
            }
            return !isCategory(header) ? 1 : 0;
        }

        public boolean areAllItemsEnabled()
        {
            return false;
        }

        public int getItemViewType(int i)
        {
            return getHeaderType((android.preference.PreferenceActivity.Header)getItem(i));
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Resources resources;
            android.preference.PreferenceActivity.Header header;
            header = (android.preference.PreferenceActivity.Header)getItem(i);
            i = getHeaderType(header);
            resources = null;
            if (view == null) goto _L2; else goto _L1
_L1:
            viewgroup = (HeaderViewHolder)view.getTag();
_L13:
            resources = getContext().getResources();
            switch (i)
            {
            default:
                return view;

            case 2: // '\002'
                if (((HeaderViewHolder) (viewgroup)).switchController != null)
                {
                    ((HeaderViewHolder) (viewgroup)).switchController.unregister();
                    viewgroup.switchController = null;
                }
                View view1;
                if (header.id == 0x7f1009d5L)
                {
                    if (isMultiPane())
                    {
                        viewgroup.switchController = newNotificationSwitchController(((HeaderViewHolder) (viewgroup)).toggleSwitch);
                    }
                } else
                if (header.id == 0x7f1009dfL)
                {
                    viewgroup.switchController = newUsageLoggingSwitchController(((HeaderViewHolder) (viewgroup)).toggleSwitch);
                } else
                if (header.fragmentArguments != null)
                {
                    ((HeaderViewHolder) (viewgroup)).toggleSwitch.setEnabled(header.fragmentArguments.getBoolean("isEnabled"));
                    ((HeaderViewHolder) (viewgroup)).toggleSwitch.setChecked(header.fragmentArguments.getBoolean("isChecked"));
                }
                view1 = ((HeaderViewHolder) (viewgroup)).toggleDivider;
                if (isSwitchMultiPane(header))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                view1.setVisibility(i);
                switchMap.put(header, ((HeaderViewHolder) (viewgroup)).toggleSwitch);
                // fall through

            case 1: // '\001'
                ((HeaderViewHolder) (viewgroup)).icon.setImageResource(header.iconRes);
                CharSequence charsequence = header.getSummary(resources);
                if (TextUtils.isEmpty(charsequence))
                {
                    ((HeaderViewHolder) (viewgroup)).summary.setVisibility(8);
                } else
                {
                    ((HeaderViewHolder) (viewgroup)).summary.setVisibility(0);
                    ((HeaderViewHolder) (viewgroup)).summary.setText(charsequence);
                }
                // fall through

            case 0: // '\0'
                ((HeaderViewHolder) (viewgroup)).title.setText(header.getTitle(resources));
                return view;
            }
_L2:
            if (i != 0) goto _L4; else goto _L3
_L3:
            view = mInflater.inflate(0x1090002, viewgroup, false);
_L11:
            viewgroup = new HeaderViewHolder();
            view.setTag(viewgroup);
            i;
            JVM INSTR tableswitch 0 2: default 128
        //                       0 131
        //                       1 206
        //                       2 175;
               goto _L5 _L6 _L7 _L8
_L5:
            continue; /* Loop/switch isn't completed */
_L6:
            viewgroup.title = (TextView)view.findViewById(0x1020016);
            continue; /* Loop/switch isn't completed */
_L4:
            if (i == 1) goto _L10; else goto _L9
_L9:
            view = resources;
            if (i != 2) goto _L11; else goto _L10
_L10:
            view = mInflater.inflate(0x7f0301a5, viewgroup, false);
              goto _L11
_L8:
            viewgroup.toggleDivider = view.findViewById(0x7f1004e4);
            viewgroup.toggleSwitch = (Switch)view.findViewById(0x7f1004e5);
            ((HeaderViewHolder) (viewgroup)).toggleSwitch.setVisibility(0);
_L7:
            viewgroup.icon = (ImageView)view.findViewById(0x1020006);
            viewgroup.summary = (TextView)view.findViewById(0x1020010);
              goto _L6
            if (true) goto _L13; else goto _L12
_L12:
        }

        public int getViewTypeCount()
        {
            return 3;
        }

        public boolean hasStableIds()
        {
            return true;
        }

        public boolean isEnabled(int i)
        {
            return getItemViewType(i) != 0;
        }

        public HeaderAdapter(Context context, List list)
        {
            this$0 = PreferencesActivity.this;
            super(context, 0, list);
            mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

    class HeaderAdapter.HeaderViewHolder
    {

        ImageView icon;
        TextView summary;
        PreferenceSwitchController switchController;
        final HeaderAdapter this$1;
        TextView title;
        View toggleDivider;
        Switch toggleSwitch;

        HeaderAdapter.HeaderViewHolder()
        {
            this$1 = HeaderAdapter.this;
            super();
        }
    }

    public class NotificationSwitchController extends PreferenceSwitchController
    {

        final PreferencesActivity this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            notificationPrefs.setEventEnabled(userId, "ALLNOTIFICATIONS", flag);
            toggleAllNotifications(flag);
        }

        public volatile void register()
        {
            super.register();
        }

        public volatile void unregister()
        {
            super.unregister();
        }

        public NotificationSwitchController(Switch switch1)
        {
            this$0 = PreferencesActivity.this;
            super(switch1);
            switch1.setChecked(getNotificationsEnabled());
            switch1.setEnabled(true);
            register();
        }
    }

    static abstract class PreferenceSwitchController
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        protected final Switch toggleSwitch;

        public void register()
        {
            toggleSwitch.setOnCheckedChangeListener(this);
        }

        public void unregister()
        {
            toggleSwitch.setOnCheckedChangeListener(null);
        }

        public PreferenceSwitchController(Switch switch1)
        {
            toggleSwitch = switch1;
        }
    }

    static class SettingsLoadResultHandler extends Handler
    {

        private final WeakReference activityReference;
        public long startTime;

        public void handleMessage(Message message)
        {
label0:
            {
                message = (PreferencesActivity)activityReference.get();
                if (message != null)
                {
                    if (!message.isNotificationsSettled())
                    {
                        break label0;
                    }
                    message.removeDialog(0x7f0707c6);
                    message.startNotificationPreferences();
                }
                return;
            }
            if (System.currentTimeMillis() - startTime > 30000L)
            {
                Log.d("PreferencesActivity", "SettingsLoadResultHandler: operation takes long time, aborted");
                message.removeDialog(0x7f0707c6);
                message.showDialog(0x7f07014c);
                return;
            } else
            {
                sleep(1000L);
                return;
            }
        }

        public void sleep(long l)
        {
            removeMessages(0);
            sendMessageDelayed(obtainMessage(0), l);
        }

        public SettingsLoadResultHandler(PreferencesActivity preferencesactivity, long l)
        {
            activityReference = new WeakReference(preferencesactivity);
            startTime = l;
        }
    }

    final class ToggleNotificationsAsyncTask extends AsyncTask
    {

        private Boolean enabling;
        private MenuItem item;
        final PreferencesActivity this$0;

        protected transient ResultStatus doInBackground(Void avoid[])
        {
            return NotificationUtil.updateNotificationSubscriptions(PreferencesActivity.this, getEbayContext(), notificationType);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            dialog.dismiss();
            onNotificationsUpdateComplete(resultstatus, enabling, item);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        protected void onPreExecute()
        {
            int i;
            if (enabling != null)
            {
                if (enabling.booleanValue())
                {
                    i = 0x7f0703b7;
                } else
                {
                    i = 0x7f070293;
                }
            } else
            {
                i = 0x7f070b95;
            }
            dialog = ProgressDialog.show(PreferencesActivity.this, null, getString(i));
        }

        public ToggleNotificationsAsyncTask(Boolean boolean1)
        {
            this$0 = PreferencesActivity.this;
            super();
            enabling = null;
            item = null;
            enabling = boolean1;
        }

        public ToggleNotificationsAsyncTask(Boolean boolean1, MenuItem menuitem)
        {
            this(boolean1);
            item = menuitem;
        }
    }

    class UsageLoggingSwitchController extends PreferenceSwitchController
    {

        final PreferencesActivity this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (Usage.isEnabled())
            {
                compoundbutton = Usage.getInst();
                if (flag)
                {
                    View view = LayoutInflater.from(PreferencesActivity.this).inflate(0x7f0301a6, null);
                    final EditText input = (EditText)view.findViewById(0x7f1004e7);
                    final EditText input2 = compoundbutton.getSessionName();
                    if (input2 != null && input2.length() > 0)
                    {
                        input.setText(input2.toCharArray(), 0, input2.length());
                    }
                    input2 = (EditText)view.findViewById(0x7f1004e9);
                    String s = compoundbutton.getDeviceName();
                    if (s != null && s.length() > 0)
                    {
                        input2.setText(s.toCharArray(), 0, s.length());
                    }
                    (new android.app.AlertDialog.Builder(PreferencesActivity.this)).setTitle("Usage Profiling").setMessage("Enter session and device names.").setView(view).setPositiveButton(0x104000a, compoundbutton. new android.content.DialogInterface.OnClickListener() {

                        final UsageLoggingSwitchController this$1;
                        final EditText val$input;
                        final EditText val$input2;
                        final Usage val$usage;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = input.getText().toString();
                            String s = input2.getText().toString();
                            usageLoggingHeader.summary = dialoginterface;
                            HeaderAdapter headeradapter = (HeaderAdapter)getListAdapter();
                            if (headeradapter != null)
                            {
                                headeradapter.notifyDataSetChanged();
                            }
                            usage.setSessionName(dialoginterface);
                            usage.setDeviceName(s);
                            usage.startSession();
                        }

            
            {
                this$1 = final_usageloggingswitchcontroller;
                input = edittext;
                input2 = edittext1;
                usage = Usage.this;
                super();
            }
                    }).setNegativeButton(0x1040000, compoundbutton. new android.content.DialogInterface.OnClickListener() {

                        final UsageLoggingSwitchController this$1;
                        final Usage val$usage;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            usage.startSession();
                        }

            
            {
                this$1 = final_usageloggingswitchcontroller;
                usage = Usage.this;
                super();
            }
                    }).create().show();
                } else
                {
                    (new android.app.AlertDialog.Builder(PreferencesActivity.this)).setTitle("Usage Profiling").setMessage("Save usage data?").setPositiveButton(0x104000a, compoundbutton. new android.content.DialogInterface.OnClickListener() {

                        final UsageLoggingSwitchController this$1;
                        final Usage val$usage;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            usage.endSession();
                            usage.setSessionName("");
                            usage.setDeviceName("");
                        }

            
            {
                this$1 = final_usageloggingswitchcontroller;
                usage = Usage.this;
                super();
            }
                    }).setNeutralButton("Email", compoundbutton. new android.content.DialogInterface.OnClickListener() {

                        final UsageLoggingSwitchController this$1;
                        final Usage val$usage;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            usage.sendUsageEmail(_fld0);
                            usage.endSession();
                            usage.setSessionName("");
                            usage.setDeviceName("");
                        }

            
            {
                this$1 = final_usageloggingswitchcontroller;
                usage = Usage.this;
                super();
            }
                    }).setNegativeButton("Delete", compoundbutton. new android.content.DialogInterface.OnClickListener() {

                        final UsageLoggingSwitchController this$1;
                        final Usage val$usage;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            usage.markForDeleteSession();
                            usage.deleteFile();
                            usage.endSession();
                            usage.setSessionName("");
                            usage.setDeviceName("");
                        }

            
            {
                this$1 = final_usageloggingswitchcontroller;
                usage = Usage.this;
                super();
            }
                    }).create().show();
                    usageLoggingHeader.summary = null;
                    compoundbutton = (HeaderAdapter)getListAdapter();
                    if (compoundbutton != null)
                    {
                        compoundbutton.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }

        public UsageLoggingSwitchController(Switch switch1)
        {
            this$0 = PreferencesActivity.this;
            super(switch1);
            switch1.setChecked(Usage.getInst().isSessionActive());
            switch1.setEnabled(true);
            register();
        }
    }


    public static final String DEVELOPER_OPTIONS_LOG_TAG = "eBayDevOptions";
    private static final int DIALOG_CLEAR_SEARCH_HIST = 1;
    private static final int DIALOG_NOTIFICATIONS_WILL_NOT_BE_RECEIVED = 1;
    private static final String IS_CATEGORY = "isCategory";
    private static final String IS_CHECKED = "isChecked";
    private static final String IS_ENABLED = "isEnabled";
    private static final String IS_SWITCH = "isSwitch";
    private static final String IS_SWITCH_MULTI_PANE = "isSwitchMultiPane";
    public static final String KEY_ALL_NOTIFICATIONS = "ALLNOTIFICATIONS";
    private static final int LOADER_ID_CLEAR_ALL = 1;
    private static final int REQUEST_SIGN_IN_NOTIFICATIONS = 1;
    private static final String TAG_CLEAR_SEARCH_HISTORY = "tag_clear_search_history";
    private static final int WAIT_MS_MAX = 30000;
    private android.preference.PreferenceActivity.Header aboutHeader;
    private AddressDataManagerObserver addressDataManagerObserver;
    private android.preference.PreferenceActivity.Header adsOptOut;
    private android.preference.PreferenceActivity.Header buyerProtectionGuaranteeHeader;
    private final Map changeMap = new HashMap();
    private android.preference.PreferenceActivity.Header changePassword;
    private android.preference.PreferenceActivity.Header clearHistoryHeader;
    private android.preference.PreferenceActivity.Header countryRegionHeader;
    private android.preference.PreferenceActivity.Header developerOptionsHeader;
    protected ProgressDialog dialog;
    private android.preference.PreferenceActivity.Header emailSupportHeader;
    private android.preference.PreferenceActivity.Header eulaHeader;
    private boolean firstStart;
    private List headers;
    private boolean headersInitialized;
    private android.preference.PreferenceActivity.Header helpCategoryHeader;
    private boolean historyCleared;
    private SettingsLoadResultHandler loadHandler;
    private android.preference.PreferenceActivity.Header logTagsCategoryHeader;
    private boolean notifPrefChanged;
    protected NotificationPreferenceManager notificationPrefs;
    protected com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType notificationType;
    private boolean ocsClickable;
    private android.preference.PreferenceActivity.Header privacyHeader;
    private android.preference.PreferenceActivity.Header pushNotificationsHeader;
    private RecentsDataManager recentsDataManager;
    private android.preference.PreferenceActivity.Header selectHeader;
    private android.preference.PreferenceActivity.Header shippingAddressHeader;
    protected List shippingAddresses;
    private long startTime;
    private ItemCache stateCache;
    protected final HashMap switchMap = new HashMap();
    protected android.preference.PreferenceActivity.Header usageLoggingHeader;
    private android.preference.PreferenceActivity.Header useQaServersHeader;
    protected UserContextDataManager userContextDataManager;
    protected String userId;
    private android.preference.PreferenceActivity.Header usingC2dmHeader;
    private android.preference.PreferenceActivity.Header usingGcmHeader;
    private android.preference.PreferenceActivity.Header usingPollingHeader;
    private final Set validFragments = new HashSet();

    public PreferencesActivity()
    {
        headersInitialized = false;
        ocsClickable = true;
        firstStart = true;
        historyCleared = false;
        shippingAddresses = null;
        validFragments.add(com/ebay/mobile/preference/DeveloperPreferenceFragment.getName());
        validFragments.add(com/ebay/mobile/settings/AboutPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/CountryPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/PreferredCountryPreferenceFragment.getName());
        validFragments.add(com/ebay/mobile/settings/NotificationSoundsPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/BuyingNotificationPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/GeneralNotificationPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/NotificationPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/SellingNotificationPreferencesFragment.getName());
        validFragments.add(com/ebay/mobile/settings/EulaWebviewFragment.getName());
        validFragments.add(com/ebay/mobile/settings/PrivacyWebviewFragment.getName());
        validFragments.add(com/ebay/mobile/settings/AdsOptOutFragment.getName());
    }

    public static void StartActivity(Activity activity)
    {
        activity.startActivityForResult(new Intent(activity, com/ebay/mobile/activities/PreferencesActivity), 508);
    }

    private void disableAllNotifications(NotificationPreferenceManager notificationpreferencemanager)
    {
        enableOrDisableNotifications(notificationpreferencemanager, false);
    }

    private void doClearSearchHistory()
    {
        Preferences preferences = MyApp.getPrefs();
        eBayDictionaryProvider.clearHistory(this);
        LruVisitedItemCache.get().clear();
        preferences.removeUserPref("searchLastKeywords");
        preferences.removeUserPref("searchLastCharityKeywords");
        SearchUtil.purgeSavedSearchCaches(getEbayContext());
        SearchUtil.purgeFollowCaches(this);
        if (recentsDataManager != null)
        {
            recentsDataManager.clearRecentlyViewedItems();
            recentsDataManager.clearRecentSearches();
        }
        historyCleared = true;
    }

    private void enableOrDisableNotifications(NotificationPreferenceManager notificationpreferencemanager, boolean flag)
    {
        if (EbayUtil.isPushActive(this, userId, "AEAPP"))
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
            int k = aeventtype.length;
            for (int i = 0; i < k; i++)
            {
                com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
                if (eventtype.supported && !NotificationPreferenceManager.isAlwaysOn(eventtype))
                {
                    notificationpreferencemanager.setEventEnabled(userId, eventtype.name(), flag);
                }
            }

        } else
        {
            com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
            int l = aalerttype.length;
            for (int j = 0; j < l; j++)
            {
                com.ebay.common.model.mdns.NotificationPreference.AlertType alerttype = aalerttype[j];
                if (alerttype.supported)
                {
                    notificationpreferencemanager.setEventEnabled(userId, NotificationPreference.idToName(alerttype.id), flag);
                }
            }

        }
    }

    private void fillSettingsMapping(NotificationPreferenceManager notificationpreferencemanager)
    {
        if (EbayUtil.isPushActive(this, userId, "AEAPP"))
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
            int j = aeventtype.length;
            int i = 0;
            while (i < j) 
            {
                com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
                if (eventtype.supported && eventtype.id != 2 && eventtype.id != 19 && eventtype.id != 20)
                {
                    changeMap.put(eventtype.name(), Boolean.valueOf(notificationpreferencemanager.isEventEnabled(userId, eventtype.name())));
                }
                i++;
            }
        }
    }

    private void finishNotingHistoryWasCleared()
    {
        setResult(-1, getClearHistoryIntent());
        finish();
    }

    private Intent getClearHistoryIntent()
    {
        Intent intent = new Intent();
        intent.putExtra("cleared", true);
        return intent;
    }

    private String getOcsAvailabilityMessage(EbayCountry ebaycountry)
    {
        String s1 = Locale.getDefault().getLanguage();
        String s2 = ebaycountry.getSiteLocale().getLanguage();
        String s = null;
        if (!s1.equals(s2))
        {
            ebaycountry = ebaycountry.getSiteLocale().getDisplayLanguage();
            s = getResources().getString(0x7f07073a, new Object[] {
                ebaycountry
            });
        }
        return s;
    }

    private boolean haveHeaderInstances()
    {
        return shippingAddressHeader != null && pushNotificationsHeader != null && countryRegionHeader != null && clearHistoryHeader != null && helpCategoryHeader != null && buyerProtectionGuaranteeHeader != null && privacyHeader != null && eulaHeader != null && emailSupportHeader != null && aboutHeader != null && headers != null && headers.contains(pushNotificationsHeader) && adsOptOut != null;
    }

    private boolean initHeaders()
    {
        android.preference.PreferenceActivity.Header header;
        boolean flag;
        boolean flag2;
        header = null;
        Object obj = null;
        if (headers == null)
        {
            return false;
        }
        if (!haveHeaderInstances())
        {
            Iterator iterator = headers.iterator();
            do
            {
                header = ((android.preference.PreferenceActivity.Header) (obj));
                if (!iterator.hasNext())
                {
                    break;
                }
                header = (android.preference.PreferenceActivity.Header)iterator.next();
                if (header == null)
                {
                    return false;
                }
                if (header.id == 0x7f1009d2L)
                {
                    shippingAddressHeader = header;
                } else
                if (header.id == 0x7f1009d4L)
                {
                    changePassword = header;
                } else
                if (header.id == 0x7f1009d5L)
                {
                    pushNotificationsHeader = header;
                } else
                if (header.id == 0x7f1009d6L)
                {
                    countryRegionHeader = header;
                } else
                if (header.id == 0x7f1009d7L)
                {
                    clearHistoryHeader = header;
                } else
                if (header.id == 0x7f1009d8L)
                {
                    helpCategoryHeader = header;
                } else
                if (header.id == 0x7f1009d9L)
                {
                    buyerProtectionGuaranteeHeader = header;
                } else
                if (header.id == 0x7f1009dbL)
                {
                    privacyHeader = header;
                } else
                if (header.id == 0x7f1009daL)
                {
                    eulaHeader = header;
                } else
                if (header.id == 0x7f1009ddL)
                {
                    emailSupportHeader = header;
                } else
                if (header.id == 0x7f1009deL)
                {
                    aboutHeader = header;
                } else
                if (header.id == 0x7f1009dfL)
                {
                    usageLoggingHeader = header;
                } else
                if (header.id == 0x7f1009e0L)
                {
                    developerOptionsHeader = header;
                } else
                if (header.id == 0x7f1009e1L)
                {
                    logTagsCategoryHeader = header;
                } else
                if (header.id == 0x7f1009e2L)
                {
                    useQaServersHeader = header;
                } else
                if (header.id == 0x7f1009e3L)
                {
                    usingC2dmHeader = header;
                } else
                if (header.id == 0x7f1009e4L)
                {
                    usingPollingHeader = header;
                } else
                if (header.id == 0x7f1009e5L)
                {
                    usingGcmHeader = header;
                } else
                if (header.id == 0x7f1009dcL)
                {
                    adsOptOut = header;
                } else
                if (header.id == 0x7f1009d3L)
                {
                    obj = header;
                }
            } while (true);
        }
        if (!haveHeaderInstances())
        {
            return false;
        }
        for (int i = headers.indexOf(helpCategoryHeader); i >= 0 && i + 1 < headers.size(); headers.remove(i + 1)) { }
        Object obj2 = MyApp.getPrefs();
        DcsHelper dcshelper;
        if (!((Preferences) (obj2)).isSignedIn() || TextUtils.isEmpty(userId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dcshelper = MyApp.getDeviceConfiguration();
        obj = DeviceConfiguration.getAsync();
        obj2 = ((Preferences) (obj2)).getCurrentCountry();
        selectHeader = null;
        if (flag)
        {
            pushNotificationsHeader.fragment = null;
            pushNotificationsHeader.fragmentArguments = null;
            pushNotificationsHeader.summaryRes = 0x7f070114;
        } else
        {
            pushNotificationsHeader.fragment = com/ebay/mobile/settings/NotificationPreferencesFragment.getName();
            pushNotificationsHeader.fragmentArguments = new Bundle();
            pushNotificationsHeader.fragmentArguments.putBoolean("isSwitchMultiPane", true);
            pushNotificationsHeader.summaryRes = 0;
            pushNotificationsHeader.intent = null;
            if (firstStart)
            {
                selectHeader = pushNotificationsHeader;
                firstStart = false;
            }
        }
        countryRegionHeader.summary = EbayCountryManager.getCountryWithLanguageName(getResources(), ((EbayCountry) (obj2)));
        if (dcshelper.buyerProtectionUrl() != null)
        {
            Object obj1 = buyerProtectionGuaranteeHeader;
            android.preference.PreferenceActivity.Header header1;
            int j;
            boolean flag1;
            boolean flag3;
            boolean flag4;
            if (((DeviceConfiguration) (obj)).get(DcsBoolean.BuyerGuarantee))
            {
                j = 0x7f0701bb;
            } else
            {
                j = 0x7f0701c0;
            }
            obj1.titleRes = j;
            headers.add(buyerProtectionGuaranteeHeader);
        }
        headers.add(eulaHeader);
        headers.add(privacyHeader);
        headers.add(adsOptOut);
        headers.add(emailSupportHeader);
        aboutHeader.summary = NautilusKernel.getAppVersionName(this);
        headers.add(aboutHeader);
        if (Usage.isEnabled())
        {
            headers.add(usageLoggingHeader);
            obj1 = Usage.getInst();
            if (((Usage) (obj1)).isSessionActive())
            {
                obj1 = ((Usage) (obj1)).getSessionName();
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    usageLoggingHeader.summary = ((CharSequence) (obj1));
                }
            }
        }
        if (((DeviceConfiguration) (obj)).get(DcsNautilusBoolean.QA_ENABLED) && (MyApp.getPrefs().getGlobalPref("developerOptions", false) || Log.isLoggable("eBayDevOptions", 3)))
        {
            headers.add(developerOptionsHeader);
        }
        flag2 = false;
        flag4 = Log.isLoggable("logs", 3);
        j = 0;
        if (NautilusKernel.isQaMode())
        {
            headers.add(logTagsCategoryHeader);
            j = 1;
            headers.add(useQaServersHeader);
        }
        obj = FwLog.getAllLoggingTags().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj1 = (com.ebay.nautilus.kernel.util.FwLog.LogInfo)((Iterator) (obj)).next();
            flag1 = flag2;
            if (((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).tag.equals("eBayNotifications"))
            {
                flag1 = flag2;
                if (((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).isLoggable)
                {
                    flag1 = flag2;
                    if (((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).priority < 4)
                    {
                        flag1 = true;
                    }
                }
            }
            if (!flag4)
            {
                flag2 = flag1;
                if (!((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).isLoggable)
                {
                    continue;
                }
                flag2 = flag1;
                if (((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).priority >= 4)
                {
                    continue;
                }
            }
            flag3 = j;
            if (j == 0)
            {
                headers.add(logTagsCategoryHeader);
                flag3 = true;
            }
            header1 = new android.preference.PreferenceActivity.Header();
            header1.title = ((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).description;
            header1.summary = ((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).toString();
            header1.fragmentArguments = new Bundle();
            header1.fragmentArguments.putBoolean("isSwitch", true);
            header1.fragmentArguments.putBoolean("isEnabled", false);
            header1.fragmentArguments.putBoolean("isChecked", ((com.ebay.nautilus.kernel.util.FwLog.LogInfo) (obj1)).isLoggable);
            headers.add(header1);
            flag2 = flag1;
            j = ((flag3) ? 1 : 0);
        } while (true);
        if (!flag2 || flag) goto _L2; else goto _L1
_L1:
        int k = headers.indexOf(aboutHeader);
        static class _cls4
        {

            static final int $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType = new int[com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.C2DM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType[EbaySmartNotificationManager.getCurrentConfiguration(this).ordinal()];
        JVM INSTR tableswitch 1 2: default 1244
    //                   1 1349
    //                   2 1369;
           goto _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_1369;
_L3:
        headers.add(k + 1, usingPollingHeader);
_L2:
        String s;
        if (flag || MyApp.getPrefs().getUserIsPpa())
        {
            headers.remove(shippingAddressHeader);
        } else
        {
            Intent intent = new Intent(this, com/ebay/mobile/checkout/AddressListActivity);
            intent.setAction("android.intent.action.EDIT");
            intent.putExtra("xo_state_shipping_addresses", (Serializable)shippingAddresses);
            shippingAddressHeader.intent = intent;
            updateShippingAddressLayout();
        }
        if (flag)
        {
            headers.remove(changePassword);
            headers.remove(header);
        }
        s = getOcsAvailabilityMessage(MyApp.getPrefs().getCurrentCountry());
        if (s != null)
        {
            emailSupportHeader.summary = s;
            ocsClickable = false;
        }
        return true;
_L4:
        headers.add(k + 1, usingGcmHeader);
          goto _L2
        headers.add(k + 1, usingC2dmHeader);
          goto _L2
    }

    private boolean isHeaderLevel()
    {
        return getIntent().getStringExtra(":android:show_fragment") == null;
    }

    public static boolean isNotificationListAllDisabled(Context context, String s, NotificationPreferenceManager notificationpreferencemanager)
    {
        boolean flag1 = true;
        if (!EbayUtil.isPushActive(context, s, "AEAPP")) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        context = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
        j = context.length;
        i = 0;
_L7:
        boolean flag = flag1;
        if (i >= j) goto _L4; else goto _L3
_L3:
        com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = context[i];
        if (!eventtype.supported || !eventtype.isUiVisible() || !notificationpreferencemanager.isEventEnabled(s, eventtype.name())) goto _L6; else goto _L5
_L5:
        flag = false;
_L4:
        return flag;
_L6:
        i++;
          goto _L7
_L2:
        context = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
        j = context.length;
        i = 0;
_L9:
        flag = flag1;
        if (i >= j) goto _L4; else goto _L8
_L8:
        Object obj = context[i];
        if (((com.ebay.common.model.mdns.NotificationPreference.AlertType) (obj)).supported && notificationpreferencemanager.isEventEnabled(s, NotificationPreference.idToName(((com.ebay.common.model.mdns.NotificationPreference.AlertType) (obj)).id)))
        {
            return false;
        }
        i++;
          goto _L9
    }

    private void restoreNotificationSettings(NotificationPreferenceManager notificationpreferencemanager)
    {
        if (EbayUtil.isPushActive(this, userId, "AEAPP"))
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
            int k = aeventtype.length;
            for (int i = 0; i < k; i++)
            {
                com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
                if (eventtype.supported && !NotificationPreferenceManager.isAlwaysOn(eventtype))
                {
                    notificationpreferencemanager.setEventEnabled(userId, eventtype.name(), notificationpreferencemanager.isEventEnabledSave(userId, eventtype.name()));
                }
            }

        } else
        {
            com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
            int l = aalerttype.length;
            for (int j = 0; j < l; j++)
            {
                Object obj = aalerttype[j];
                if (((com.ebay.common.model.mdns.NotificationPreference.AlertType) (obj)).supported)
                {
                    obj = NotificationPreference.idToName(((com.ebay.common.model.mdns.NotificationPreference.AlertType) (obj)).id);
                    notificationpreferencemanager.setEventEnabled(userId, ((String) (obj)), notificationpreferencemanager.isEventEnabledSave(userId, ((String) (obj))));
                }
            }

        }
    }

    private void resumeUi()
    {
        if (ItemCache.isGoogleAccountMissing(this)) goto _L2; else goto _L1
_L1:
        if (!ItemCache.askAndClearC2dmRegAuthFailed(this)) goto _L4; else goto _L3
_L3:
        showDialog(0x7f070906);
_L2:
        if (EbayUtil.isPushActive(this, userId, "AEAPP"))
        {
            if (stateCache == null)
            {
                stateCache = new ItemCache(this);
            }
            if (DevLog.logNotifications.isLoggable)
            {
                DevLog.logNotifications.log((new StringBuilder()).append("GCM regid=").append(stateCache.getGCMRegistrationId(userId)).toString());
                DevLog.logNotifications.log((new StringBuilder()).append("C2DM regid=").append(stateCache.getRegistrationId(userId)).toString());
            }
        }
        if (!notifPrefChanged)
        {
            fillSettingsMapping(notificationPrefs);
        }
        return;
_L4:
        if ((ItemCache.needRegisterNotification(this, userId) || !notificationPrefs.hasPushSettings(userId, "AEAPP")) && !EbaySmartNotificationManager.isInTransition())
        {
            ServiceStarter.startNotificationManagerService(this);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void saveNotificationSettings(NotificationPreferenceManager notificationpreferencemanager)
    {
        if (EbayUtil.isPushActive(this, userId, "AEAPP"))
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
            int k = aeventtype.length;
            for (int i = 0; i < k; i++)
            {
                com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
                if (eventtype.supported && !NotificationPreferenceManager.isAlwaysOn(eventtype))
                {
                    notificationpreferencemanager.setEventEnabledSave(userId, eventtype.name(), notificationpreferencemanager.isEventEnabled(userId, eventtype.name()));
                }
            }

        } else
        {
            com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
            int l = aalerttype.length;
            for (int j = 0; j < l; j++)
            {
                Object obj = aalerttype[j];
                if (((com.ebay.common.model.mdns.NotificationPreference.AlertType) (obj)).supported)
                {
                    obj = NotificationPreference.idToName(((com.ebay.common.model.mdns.NotificationPreference.AlertType) (obj)).id);
                    notificationpreferencemanager.setEventEnabledSave(userId, ((String) (obj)), notificationpreferencemanager.isEventEnabled(userId, ((String) (obj))));
                }
            }

        }
    }

    private void setSpinner()
    {
        if (isNotificationsSettled())
        {
            removeDialog(0x7f0707c6);
            startNotificationPreferences();
            return;
        }
        long l = System.currentTimeMillis();
        if (l - startTime > 30000L)
        {
            Log.d("PreferencesActivity", "setSpinner: operation takes long time, aborted");
            removeDialog(0x7f0707c6);
            showDialog(0x7f07014c);
            return;
        }
        if (loadHandler == null)
        {
            loadHandler = new SettingsLoadResultHandler(this, startTime);
        } else
        {
            loadHandler.startTime = l;
        }
        showDialog(0x7f0707c6);
        loadHandler.sleep(1000L);
    }

    private void showClearSearchHistoryConfirmation()
    {
        (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f07023b).setMessage(0x7f07023c).setNegativeButton(0x7f0701cc).setPositiveButton(0x7f070738).createFromActivity(1).show(getFragmentManager(), "tag_clear_search_history");
    }

    private void showEndingAlert()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(0x7f070a47);
        builder.setMessage(0x7f070a46);
        builder.setCancelable(true);
        builder.setPositiveButton(getString(0x7f070738), new android.content.DialogInterface.OnClickListener() {

            final PreferencesActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = PreferencesActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void startNotificationPreferences(android.preference.PreferenceActivity.Header header, int i)
    {
        super.onHeaderClick(header, i);
    }

    protected void doSignOut()
    {
        MyApp.signOut(false);
        eBay.Restart(this);
        finish();
    }

    public boolean getNotificationsEnabled()
    {
label0:
        {
            boolean flag1 = notificationPrefs.isEventEnabled(userId, "ALLNOTIFICATIONS");
            boolean flag = flag1;
            if (!flag1)
            {
                if (isNotificationListAllDisabled(this, userId, notificationPrefs))
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return false;
    }

    boolean isCategory(android.preference.PreferenceActivity.Header header)
    {
        return header != null && header.fragmentArguments != null && header.fragmentArguments.getBoolean("isCategory");
    }

    public boolean isDualPane()
    {
        return isMultiPane() && !onIsHidingHeaders();
    }

    protected boolean isEventEnabled(String s, String s1, NotificationPreferenceManager notificationpreferencemanager)
    {
        Object obj;
        try
        {
            obj = com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent.valueOf(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent.UNDEFINED;
        }
        if (obj == com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent.UNDEFINED)
        {
            return notificationpreferencemanager.isEventEnabled(s, s1);
        } else
        {
            return notificationpreferencemanager.isEventEnabled(s, ((com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent) (obj)));
        }
    }

    protected boolean isNotificationsSettled()
    {
        if ((EbaySmartNotificationManager.getCurrentConfiguration(this) == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM || EbaySmartNotificationManager.getCurrentConfiguration(this) == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.C2DM) && !EbaySmartNotificationManager.isInTransition())
        {
            return true;
        } else
        {
            return stateCache.isSettingsLoaded();
        }
    }

    boolean isSwitch(android.preference.PreferenceActivity.Header header)
    {
        return header != null && header.fragmentArguments != null && header.fragmentArguments.getBoolean("isSwitch");
    }

    boolean isSwitchMultiPane(android.preference.PreferenceActivity.Header header)
    {
        return header != null && header.fragmentArguments != null && isMultiPane() && header.fragmentArguments.getBoolean("isSwitchMultiPane");
    }

    protected boolean isValidFragment(String s)
    {
        return validFragments.contains(s);
    }

    public NotificationSwitchController newNotificationSwitchController(Switch switch1)
    {
        return new NotificationSwitchController(switch1);
    }

    UsageLoggingSwitchController newUsageLoggingSwitchController(Switch switch1)
    {
        return new UsageLoggingSwitchController(switch1);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            startTime = System.currentTimeMillis();
            if (stateCache == null)
            {
                stateCache = new ItemCache(this);
            }
            if (!isNotificationsSettled())
            {
                setSpinner();
                return;
            } else
            {
                startNotificationPreferences();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        if (notifPrefChanged)
        {
            Log.d("PreferencesActivity", "onBackPressed: going to call API to save notif pref changes");
            (new ToggleNotificationsAsyncTask(null)).execute(new Void[0]);
            return;
        }
        if (historyCleared)
        {
            finishNotingHistoryWasCleared();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onBuildHeaders(List list)
    {
        if (headers == null || !haveHeaderInstances() || !headersInitialized)
        {
            Iterator iterator;
            if (headers != null)
            {
                headers.clear();
            } else
            {
                headers = new ArrayList();
            }
            loadHeadersFromResource(0x7f050008, headers);
            shippingAddressHeader = null;
            changePassword = null;
            pushNotificationsHeader = null;
            countryRegionHeader = null;
            clearHistoryHeader = null;
            helpCategoryHeader = null;
            buyerProtectionGuaranteeHeader = null;
            privacyHeader = null;
            eulaHeader = null;
            emailSupportHeader = null;
            aboutHeader = null;
            usageLoggingHeader = null;
            developerOptionsHeader = null;
            logTagsCategoryHeader = null;
            useQaServersHeader = null;
            usingC2dmHeader = null;
            usingPollingHeader = null;
            usingGcmHeader = null;
            adsOptOut = null;
            userId = MyApp.getPrefs().getCurrentUser();
            headersInitialized = initHeaders();
        }
        for (iterator = headers.iterator(); iterator.hasNext(); list.add((android.preference.PreferenceActivity.Header)iterator.next())) { }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
        stateCache = new ItemCache(this);
        notificationType = EbaySmartNotificationManager.getCurrentConfiguration(this);
        addressDataManagerObserver = new AddressDataManagerObserver();
        initDataManagers();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 2131167174: 
            return DialogManager.createProgressDialog(this, i);

        case 2131165516: 
        case 2131166161: 
            return (new android.app.AlertDialog.Builder(this)).setMessage(i).setNegativeButton(0x104000a, null).create();

        case 2131167494: 
        case 2131167495: 
            com.ebay.common.view.util.DialogManager.AlertDialogBuilder alertdialogbuilder = new com.ebay.common.view.util.DialogManager.AlertDialogBuilder(this);
            alertdialogbuilder.setMessage(i);
            alertdialogbuilder.setCancelable(false);
            alertdialogbuilder.setPositiveButton(getString(0x7f070738), new android.content.DialogInterface.OnClickListener() {

                final PreferencesActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    finish();
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = PreferencesActivity.this;
                super();
            }
            });
            return alertdialogbuilder.create();

        case 1: // '\001'
            return (new android.app.AlertDialog.Builder(this)).setTitle(0x7f070130).setMessage(0x7f0706e9).setNegativeButton(0x7f0701cc, null).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

                final PreferencesActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    doSignOut();
                }

            
            {
                this$0 = PreferencesActivity.this;
                super();
            }
            }).create();
        }
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == 1)
        {
            doClearSearchHistory();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public android.preference.PreferenceActivity.Header onGetInitialHeader()
    {
label0:
        {
            if (headers == null)
            {
                break label0;
            }
            Iterator iterator = headers.iterator();
            android.preference.PreferenceActivity.Header header;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                header = (android.preference.PreferenceActivity.Header)iterator.next();
            } while (header.fragment == null);
            return header;
        }
        return null;
    }

    public android.preference.PreferenceActivity.Header onGetNewHeader()
    {
        android.preference.PreferenceActivity.Header header;
        if (isDualPane())
        {
            header = selectHeader;
        } else
        {
            header = null;
        }
        selectHeader = null;
        return header;
    }

    public void onHeaderClick(android.preference.PreferenceActivity.Header header, int i)
    {
        boolean flag = false;
        if (header.id != 0x7f1009d5L) goto _L2; else goto _L1
_L1:
        if (header.fragment == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn("Settings", this), 1);
            i = 1;
        } else
        if (!isNotificationsSettled())
        {
            if (!EbaySmartNotificationManager.isInTransition())
            {
                ServiceStarter.startNotificationManagerService(this);
            }
            startTime = System.currentTimeMillis();
            setSpinner();
            i = ((flag) ? 1 : 0);
        } else
        {
            startNotificationPreferences(header, i);
            i = 1;
        }
_L4:
        if (isMultiPane() && header.fragment == null && header.intent == null && i == 0)
        {
            invalidateHeaders();
        }
        return;
_L2:
        if (header.id == 0x7f1009d7L)
        {
            TrackingData trackingdata = new TrackingData("SettingsEvents", TrackingType.EVENT);
            trackingdata.addKeyValuePair("mfls", "ClearSearchHistory");
            trackingdata.send(this);
            showClearSearchHistoryConfirmation();
            i = ((flag) ? 1 : 0);
        } else
        if (header.id == 0x7f1009ddL && ocsClickable)
        {
            if (DeviceConfiguration.getAsync().get(DcsBoolean.OCS))
            {
                startActivity(new Intent(this, com/ebay/mobile/activities/OcsActivity));
                i = ((flag) ? 1 : 0);
            } else
            {
                TrackingData trackingdata1 = new TrackingData("AppEvents", TrackingType.EVENT);
                trackingdata1.addKeyValuePair("mfls", "HLP");
                trackingdata1.send(this, getEbayContext());
                Util.composeSupportEmail(this);
                i = ((flag) ? 1 : 0);
            }
        } else
        if (header.id == 0x7f1009d9L)
        {
            DcsHelper dcshelper = MyApp.getDeviceConfiguration();
            if (dcshelper.getConfig().get(DcsBoolean.BuyerGuarantee))
            {
                i = EbayCountryManager.getBuyerProtectionPageTitle();
            } else
            {
                i = 0x7f0701c0;
            }
            ShowFileWebViewActivity.startActivity(this, dcshelper.buyerProtectionUrl(), Integer.valueOf(i), "EBayBuyerProtection", Boolean.valueOf(false));
            i = 1;
        } else
        if (header.id == 0x7f1009d3L)
        {
            showDialog(1);
            i = ((flag) ? 1 : 0);
        } else
        if (header.id == 0x7f1009d4L)
        {
            String s = MyApp.getDeviceConfiguration().forgotPasswordUrl();
            Intent intent;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.ForgotPasswordInWebView))
            {
                intent = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
                intent.putExtra("url", s);
                intent.putExtra("android.intent.extra.TITLE", getString(0x7f070760));
                intent.putExtra(ShowWebViewActivity.EXTRA_SHOW_MENU, false);
                intent.putExtra("back", true);
                intent.putExtra("impression", "ForgotPassword");
            } else
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
                (new TrackingData("ForgotPassword", TrackingType.PAGE_IMPRESSION)).send(this);
            }
            startActivity(intent);
            i = ((flag) ? 1 : 0);
        } else
        if (isSwitch(header))
        {
            Switch switch1 = (Switch)switchMap.get(header);
            i = ((flag) ? 1 : 0);
            if (switch1 != null)
            {
                boolean flag1;
                if (!switch1.isChecked())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                switch1.setChecked(flag1);
                i = ((flag) ? 1 : 0);
            }
        } else
        {
            super.onHeaderClick(header, i);
            i = ((flag) ? 1 : 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            recentsDataManager = (RecentsDataManager)datamanagercontainer.initialize(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(authentication.iafToken), null);
        }
        datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"), addressDataManagerObserver);
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
    }

    void onNotificationsUpdateComplete(ResultStatus resultstatus, Boolean boolean1, MenuItem menuitem)
    {
        if (resultstatus == null || resultstatus.hasError()) goto _L2; else goto _L1
_L1:
        notifPrefChanged = false;
        if (boolean1 != null) goto _L4; else goto _L3
_L3:
        sendTrackingEvents();
        if (menuitem == null) goto _L6; else goto _L5
_L5:
        onOptionsItemSelected(menuitem);
_L4:
        return;
_L6:
        onBackPressed();
        return;
_L2:
        boolean flag1 = false;
        boolean flag = false;
        if (resultstatus != null)
        {
            resultstatus = resultstatus.getMessages().iterator();
            do
            {
                flag1 = flag;
                if (!resultstatus.hasNext())
                {
                    break;
                }
                if (11002 == ((com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next()).getId())
                {
                    MyApp.signOutForIafTokenFailure(this);
                    flag = true;
                }
            } while (true);
        }
        if (!flag1)
        {
            showDialog(0x7f0703d1);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x102002c && notifPrefChanged)
        {
            Log.d("PreferencesActivity", "onOptionsItemSelected: going to call API to save notif pref changes");
            (new ToggleNotificationsAsyncTask(null, menuitem)).execute(new Void[0]);
            return true;
        }
        if (i == 0x102002c && historyCleared)
        {
            finishNotingHistoryWasCleared();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        ContentSyncManager.unregister(this, new String[] {
            "syncCountryChanged"
        });
        headersInitialized = false;
    }

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (dialog == null || !dialog.isShowing()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        boolean flag1 = ((Boolean)obj).booleanValue();
        obj = new NotificationPreferenceManager(this);
        boolean flag = false;
        if (preference.getKey().equals("QuietTimes"))
        {
            if (flag1)
            {
                ((NotificationPreferenceManager) (obj)).setUserQuietTimeEnabled(userId);
                ContentSyncManager.notifyUpdate(this, "NotificationPreferences.QuietTimesEnabled");
            } else
            {
                ((NotificationPreferenceManager) (obj)).setUserQuietTimeDisabled(userId);
                ContentSyncManager.notifyUpdate(this, "NotificationPreferences.QuietTimesDisabled");
            }
        } else
        if (NotificationPreference.getSupportedPushEventNames().contains(preference.getKey()))
        {
            if (flag1 && preference.getKey().equals(com.ebay.common.model.mdns.NotificationPreference.EventType.OUTBID.name()))
            {
                showEndingAlert();
            }
            ((NotificationPreferenceManager) (obj)).setEventEnabled(userId, preference.getKey(), flag1);
            notifPrefChanged = true;
            flag = true;
        } else
        {
            preference = com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent.valueOf(preference.getKey());
            if (preference != null)
            {
                if (flag1 && preference == com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent.BUYING_AUCTION_UPDATES)
                {
                    showEndingAlert();
                }
                ((NotificationPreferenceManager) (obj)).setEventEnabled(userId, preference, flag1);
                notifPrefChanged = true;
                flag = true;
            }
        }
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((NotificationPreferenceManager) (obj)).setEventEnabled(userId, "ALLNOTIFICATIONS", flag1);
_L5:
        preference = (HeaderAdapter)getListAdapter();
        if (preference != null)
        {
            preference.notifyDataSetChanged();
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!isNotificationListAllDisabled(this, userId, ((NotificationPreferenceManager) (obj)))) goto _L5; else goto _L4
_L4:
        ((NotificationPreferenceManager) (obj)).setEventEnabled(userId, "ALLNOTIFICATIONS", false);
          goto _L5
    }

    protected void onResume()
    {
        super.onResume();
        ContentSyncManager.register(this, new String[] {
            "syncCountryChanged"
        });
        userId = MyApp.getPrefs().getCurrentUser();
        notificationPrefs = new NotificationPreferenceManager(getApplicationContext());
        if (isHeaderLevel())
        {
            if (headers == null || headers.isEmpty() || !headersInitialized)
            {
                invalidateHeaders();
            }
            resumeUi();
            (new TrackingData("Settings", TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
        }
    }

    void sendTrackingEvents()
    {
        if (NotificationTrackingUtil.isTrackingEnabled(notificationType) && changeMap != null && changeMap.size() > 0)
        {
            Object obj = null;
            Object obj1 = null;
            com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
            int j = aeventtype.length;
            int i = 0;
            while (i < j) 
            {
                com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
                Object obj2;
                Object obj3;
                if (!eventtype.supported)
                {
                    obj2 = obj;
                    obj3 = obj1;
                } else
                {
                    Boolean boolean1 = (Boolean)changeMap.get(eventtype.name());
                    obj3 = obj1;
                    obj2 = obj;
                    if (boolean1 != null)
                    {
                        obj3 = obj1;
                        obj2 = obj;
                        if (boolean1.booleanValue() != notificationPrefs.isEventEnabled(userId, eventtype.name()))
                        {
                            if (!boolean1.booleanValue())
                            {
                                obj2 = obj;
                                if (obj == null)
                                {
                                    obj2 = new ArrayList();
                                }
                                ((List) (obj2)).add(eventtype.name());
                                obj3 = obj1;
                            } else
                            {
                                obj2 = obj1;
                                if (obj1 == null)
                                {
                                    obj2 = new ArrayList();
                                }
                                ((List) (obj2)).add(eventtype.name());
                                obj3 = obj2;
                                obj2 = obj;
                            }
                        }
                    }
                }
                i++;
                obj1 = obj3;
                obj = obj2;
            }
            String s;
            if (notificationPrefs != null)
            {
                s = notificationPrefs.getNotificationEnabledStringForTracking(userId);
            } else
            {
                s = null;
            }
            NotificationTrackingUtil.sendEvent(this, NotificationTrackingUtil.createNotificationsToggledTrackingData(((List) (obj)), ((List) (obj1)), s));
        }
    }

    public void setListAdapter(ListAdapter listadapter)
    {
        if (listadapter == null)
        {
            super.setListAdapter(null);
            return;
        }
        if (headers == null)
        {
            headers = new ArrayList();
            invalidateHeaders();
        }
        super.setListAdapter(new HeaderAdapter(this, headers));
    }

    public void setPreference(NotificationPreferenceManager notificationpreferencemanager, PreferenceScreen preferencescreen, String s, boolean flag, boolean flag1)
    {
        Preference preference = preferencescreen.findPreference(s);
        if (preference == null)
        {
            return;
        }
        if (!flag)
        {
            preferencescreen.removePreference(preference);
            return;
        }
        if (flag1)
        {
            preference.setEnabled(false);
            return;
        }
        preference.setEnabled(true);
        if (preference instanceof TwoStatePreference)
        {
            if (!"QuietTimes".equals(s))
            {
                ((TwoStatePreference)preference).setChecked(isEventEnabled(userId, s, notificationpreferencemanager));
            } else
            {
                ((TwoStatePreference)preference).setChecked(notificationpreferencemanager.isUserQuietTimeEnabled(userId));
            }
        }
        preference.setOnPreferenceChangeListener(this);
    }

    protected void startNotificationPreferences()
    {
        startNotificationPreferences(pushNotificationsHeader, headers.indexOf(pushNotificationsHeader));
    }

    void toggleAllNotifications(boolean flag)
    {
        notificationPrefs.setEventEnabled(userId, "ALLNOTIFICATIONS", flag);
        NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(this);
        if (flag)
        {
            restoreNotificationSettings(notificationpreferencemanager);
            ContentSyncManager.notifyUpdate(this, "NotificationPreferences.ShowAllNotifications");
            ServiceStarter.instructNotificationManagerService(this, 13);
        } else
        {
            saveNotificationSettings(notificationpreferencemanager);
            ContentSyncManager.notifyUpdate(this, "NotificationPreferences.HideAllNotifications");
            switchToHeader(pushNotificationsHeader);
            disableAllNotifications(notificationpreferencemanager);
            ServiceStarter.instructNotificationManagerService(this, 14);
        }
        if (NotificationTrackingUtil.isTrackingEnabled(notificationType))
        {
            NotificationTrackingUtil.sendEvent(this, NotificationTrackingUtil.createAllNotificationsToggledTrackingData(flag));
        }
        (new ToggleNotificationsAsyncTask(Boolean.valueOf(flag))).execute(new Void[0]);
    }

    public void updateContent(String s, Object obj)
    {
        if ("syncCountryChanged".equals(s) && countryRegionHeader != null)
        {
            countryRegionHeader.summary = EbayCountryManager.getCountryWithLanguageName(getResources(), MyApp.getPrefs().getCurrentCountry());
            invalidateHeaders();
        }
    }

    protected void updateShippingAddressLayout()
    {
label0:
        {
            if (shippingAddresses == null || shippingAddresses.isEmpty() || MyApp.getPrefs().getUserIsPpa() || shippingAddressHeader == null)
            {
                break label0;
            }
            Object obj1 = shippingAddresses.iterator();
            Object obj;
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label0;
                }
                obj = (Address)((Iterator) (obj1)).next();
            } while (!((Address) (obj)).isDefault());
            obj1 = new StringBuilder();
            if (!TextUtils.isEmpty(((Address) (obj)).addressFields.name))
            {
                ((StringBuilder) (obj1)).append(((Address) (obj)).addressFields.name).append('\n');
            }
            if (!TextUtils.isEmpty(((Address) (obj)).addressFields.street1))
            {
                ((StringBuilder) (obj1)).append(((Address) (obj)).addressFields.street1).append('\n');
            }
            if (!TextUtils.isEmpty(((Address) (obj)).addressFields.street2))
            {
                ((StringBuilder) (obj1)).append(((Address) (obj)).addressFields.street2).append('\n');
            }
            ((StringBuilder) (obj1)).append(com.ebay.nautilus.domain.data.Address.AddressFields.getCityStatePostalString(((Address) (obj)).addressFields.city, ((Address) (obj)).addressFields.stateOrProvince, ((Address) (obj)).addressFields.postalCode, ((Address) (obj)).addressFields.country, false));
            ((StringBuilder) (obj1)).append('\n');
            if (!TextUtils.isEmpty(((Address) (obj)).addressFields.country))
            {
                ((StringBuilder) (obj1)).append(EbayCountryManager.getCountryName(getResources(), ((Address) (obj)).addressFields.country));
            }
            shippingAddressHeader.summary = ((CharSequence) (obj1));
            obj = (BaseAdapter)getListAdapter();
            if (obj != null)
            {
                ((BaseAdapter) (obj)).notifyDataSetChanged();
            }
        }
    }
}
