// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import android.app.backup.BackupManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.AutoSavePowerSettingChangedEvent;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.kindle.CameraUtils;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.util.ReportIssueUtility;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.upload.UploadPreferences;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.BroadcastReceiverUtility;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.SendFeedbackHelper;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.HiddenNativeGalleryActivity;
import com.amazon.gallery.thor.app.activity.LegalInformationSettingsActivity;
import com.amazon.gallery.thor.app.activity.SDCardSettingsHelper;
import com.amazon.gallery.thor.app.activity.SDCardSettingsHelperWrapper;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.app.authentication.AospSignOutHelper;
import com.amazon.gallery.thor.app.ui.ImageRewindSettingsHelper;
import com.amazon.gallery.thor.app.ui.ImageRewindSettingsHelperWrapper;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import com.amazon.gallery.thor.settings.HidePreferenceManager;
import com.amazon.gallery.thor.settings.RootUtil;
import com.amazon.gallery.thor.thisday.ThisDayAlarmManager;
import com.amazon.gallery.thor.thisday.ThisDayBroadcastReceiver;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import java.lang.ref.WeakReference;
import java.util.List;

public class SettingsFragment extends PreferenceFragment
{
    public static final class AutoSaveSource extends Enum
    {

        private static final AutoSaveSource $VALUES[];
        public static final AutoSaveSource Dialog;
        public static final AutoSaveSource OOBE;
        public static final AutoSaveSource Settings;

        public static AutoSaveSource valueOf(String s)
        {
            return (AutoSaveSource)Enum.valueOf(com/amazon/gallery/framework/kindle/fragment/SettingsFragment$AutoSaveSource, s);
        }

        public static AutoSaveSource[] values()
        {
            return (AutoSaveSource[])$VALUES.clone();
        }

        static 
        {
            Dialog = new AutoSaveSource("Dialog", 0);
            Settings = new AutoSaveSource("Settings", 1);
            OOBE = new AutoSaveSource("OOBE", 2);
            $VALUES = (new AutoSaveSource[] {
                Dialog, Settings, OOBE
            });
        }

        private AutoSaveSource(String s, int i)
        {
            super(s, i);
        }
    }

    private abstract class SwitchPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SettingsFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            boolean flag = true;
            if (launchRegisterIfNeeded())
            {
                obj = preference.getEditor();
                String s = preference.getKey();
                if (preference.isEnabled())
                {
                    flag = false;
                }
                ((android.content.SharedPreferences.Editor) (obj)).putBoolean(s, flag).commit();
                updateEnabledOptions(false);
                return false;
            } else
            {
                GLogger.d(SettingsFragment.TAG, "Preference %s Changed! ", new Object[] {
                    preference.getKey()
                });
                backupManager.dataChanged();
                return switchPreferenceChanged(preference, ((Boolean)obj).booleanValue());
            }
        }

        protected abstract boolean switchPreferenceChanged(Preference preference, boolean flag);

        private SwitchPreferenceChangeListener()
        {
            this$0 = SettingsFragment.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/SettingsFragment.getName();
    private final AmazonInsightsHelper amazoninsightsHelper;
    private PreferenceCategory autoSaveCategory;
    protected Preference autoUploadPowerSettings;
    private final SwitchPreferenceChangeListener autoUploadPowerSettingsChangeListener = new SwitchPreferenceChangeListener() {

        final SettingsFragment this$0;

        protected boolean switchPreferenceChanged(Preference preference, boolean flag)
        {
            preference.getEditor().putBoolean(preference.getKey(), flag).commit();
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            GlobalMessagingBus.post(new AutoSavePowerSettingChangedEvent(flag));
            return true;
        }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
    };
    private final SwitchPreferenceChangeListener autoUploadPreferenceChangeListener = new SwitchPreferenceChangeListener() {

        final SettingsFragment this$0;

        protected boolean switchPreferenceChanged(Preference preference, boolean flag)
        {
            final boolean autoUploadEnabledForPhotos = flag;
            TagAutoSaveChangedEvent tagautosavechangedevent;
            final TagDao tagDao;
            boolean flag1;
            if (preference.getKey().equals("auto_upload_photos_key"))
            {
                flag1 = autoUploadEnabledForPhotos | isAutoUploadEnabledForVideos();
                SettingsFragment.onAutoSaveChanged(getActivity().getApplication(), AutoSaveSource.Settings, MediaType.PHOTO, flag);
            } else
            {
                flag1 = autoUploadEnabledForPhotos;
                if (preference.getKey().equals("auto_upload_videos_key"))
                {
                    flag1 = autoUploadEnabledForPhotos | isAutoUploadEnabledForPhotos();
                    SettingsFragment.onAutoSaveChanged(getActivity().getApplication(), AutoSaveSource.Settings, MediaType.VIDEO, flag);
                }
            }
            tagautosavechangedevent = new TagAutoSaveChangedEvent();
            tagDao = (TagDao)((BeanAwareApplication)getActivity().getApplication()).getBeanFactory().getBean(Keys.TAG_DAO);
            if (preference.getKey().equals("auto_upload_photos_key"))
            {
                autoUploadEnabledForPhotos = flag;
            } else
            {
                autoUploadEnabledForPhotos = isAutoUploadEnabledForPhotos();
            }
            if (!preference.getKey().equals("auto_upload_videos_key"))
            {
                flag = isAutoUploadEnabledForVideos();
            }
            tagautosavechangedevent.setPostRunnable(flag. new Runnable() {

                final _cls1 this$1;
                final boolean val$autoUploadEnabledForPhotos;
                final boolean val$autoUploadEnabledForVideos;
                final TagDao val$tagDao;

                public void run()
                {
                    (new AsyncTask() {

                        final _cls1 this$2;

                        protected volatile Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            boolean flag1 = true;
                            avoid = tagDao;
                            boolean flag;
                            if (!autoUploadEnabledForPhotos)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (autoUploadEnabledForVideos)
                            {
                                flag1 = false;
                            }
                            avoid.removeTemporarySyncStates(flag, flag1);
                            return null;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }

            
            {
                this$1 = final__pcls1;
                tagDao = tagdao;
                autoUploadEnabledForPhotos = flag;
                autoUploadEnabledForVideos = Z.this;
                super();
            }
            });
            GlobalMessagingBus.post(tagautosavechangedevent);
            updateEnabledOptions(flag1);
            return true;
        }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
    };
    private BackupManager backupManager;
    private PreferenceCategory cloudDriveCategory;
    private PreferenceCategory deviceCategory;
    private Preference folderSettings;
    private Preference freeTimeSettingsButton;
    private PreferenceCategory hiddenCategory;
    private final SwitchPreferenceChangeListener hiddenPreferenceChangeListener = new SwitchPreferenceChangeListener() {

        final SettingsFragment this$0;

        protected boolean switchPreferenceChanged(Preference preference, boolean flag)
        {
            flag = getShowHiddenContent();
            preference = new HidePreferenceManager(getActivity());
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            preference.setHiddenPreference(flag);
            return true;
        }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
    };
    private Preference wanAllowed;

    public SettingsFragment()
    {
        amazoninsightsHelper = (AmazonInsightsHelper)ThorGalleryApplication.getBean(Keys.AMAZON_INSIGHTS_HELPER);
    }

    private boolean getShowHiddenContent()
    {
        return (new HidePreferenceManager(getActivity())).getHiddenPreference();
    }

    private void initCategories()
    {
        autoSaveCategory = (PreferenceCategory)getPreferenceScreen().findPreference("auto_save_category");
        hiddenCategory = (PreferenceCategory)getPreferenceScreen().findPreference("hidden_category");
        cloudDriveCategory = (PreferenceCategory)getPreferenceScreen().findPreference("cloud_drive_category");
        deviceCategory = (PreferenceCategory)getPreferenceScreen().findPreference("device_category");
    }

    private boolean isAutoUploadEnabled()
    {
        return isAutoUploadEnabledForPhotos() || isAutoUploadEnabledForVideos();
    }

    private boolean isAutoUploadEnabledForPhotos()
    {
        return PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("auto_upload_photos_key", false);
    }

    private boolean isAutoUploadEnabledForVideos()
    {
        return PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("auto_upload_videos_key", false);
    }

    private boolean launchRegisterIfNeeded()
    {
        if (!((AuthenticationManager)((BeanAwareApplication)getActivity().getApplication()).getBeanFactory().getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount())
        {
            startActivity(new Intent("com.amazon.dcp.sso.AddAccount"));
            return true;
        } else
        {
            return false;
        }
    }

    private static void onAutoSaveChanged(Context context, AutoSaveSource autosavesource, MediaType mediatype, boolean flag)
    {
        Profiler profiler = null;
        if (!(context instanceof BeanAwareApplication)) goto _L2; else goto _L1
_L1:
        profiler = (Profiler)((BeanAwareApplication)context).getBeanFactory().getBean(Keys.PROFILER);
_L9:
        if (profiler == null) goto _L4; else goto _L3
_L3:
        static class _cls14
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls14..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediatype.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 102
    //                   2 142;
           goto _L5 _L6 _L7
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        GLogger.d(TAG, "No metric event", new Object[0]);
_L4:
        return;
_L2:
        if (context instanceof BeanAwareActivity)
        {
            profiler = (Profiler)((BeanAwareActivity)context).getApplicationBean(Keys.PROFILER);
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (flag)
        {
            context = com.amazon.gallery.framework.network.upload.UploadPreferences.MetricsEvent.EnableAutoPhotoSave;
        } else
        {
            context = com.amazon.gallery.framework.network.upload.UploadPreferences.MetricsEvent.DisableAutoPhotoSave;
        }
_L11:
        profiler.trackEvent(com/amazon/gallery/framework/network/upload/UploadPreferences.getSimpleName(), context.toString(), CustomerMetricsHelper.getExtraEventTag(autosavesource.name()));
        return;
_L7:
        if (flag)
        {
            context = com.amazon.gallery.framework.network.upload.UploadPreferences.MetricsEvent.EnableAutoVideoSave;
        } else
        {
            context = com.amazon.gallery.framework.network.upload.UploadPreferences.MetricsEvent.DisableAutoVideoSave;
        }
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static void setAutoUploadEnabled(Context context, boolean flag, AutoSaveSource autosavesource)
    {
        setAutoUploadEnabledForPhotos(context, flag, autosavesource);
        setAutoUploadEnabledForVideos(context, flag, autosavesource);
    }

    public static void setAutoUploadEnabledForPhotos(Context context, boolean flag, AutoSaveSource autosavesource)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("auto_upload_photos_key", flag).apply();
        if (autosavesource != null)
        {
            onAutoSaveChanged(context, autosavesource, MediaType.PHOTO, flag);
        }
    }

    public static void setAutoUploadEnabledForVideos(Context context, boolean flag, AutoSaveSource autosavesource)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("auto_upload_videos_key", flag).apply();
        if (autosavesource != null)
        {
            onAutoSaveChanged(context, autosavesource, MediaType.VIDEO, flag);
        }
    }

    private void setupDownloadPreference()
    {
        RemovableStorageManager removablestoragemanager = (RemovableStorageManager)ThorGalleryApplication.getBean(Keys.REMOVABLE_STORAGE_MANAGER);
        PreferenceGroup preferencegroup = (PreferenceGroup)findPreference("sd_card_placeholder_key");
        if (!removablestoragemanager.isRemovableStorageMounted())
        {
            getPreferenceScreen().removePreference(preferencegroup);
            return;
        } else
        {
            addPreferencesFromResource(0x7f050005);
            (new SDCardSettingsHelperWrapper(getActivity())).setupSDCardSettings(getPreferenceScreen(), preferencegroup, removablestoragemanager);
            return;
        }
    }

    private void setupImageRewind()
    {
        final Object rewindCleanupButton = (PreferenceGroup)findPreference("rewind_cleanup_button");
        if (FeatureManager.isFeatureEnabled(Features.REWIND))
        {
            final ImageRewindSettingsHelperWrapper helper = new ImageRewindSettingsHelperWrapper();
            helper.initializePreferenceView(((PreferenceGroup) (rewindCleanupButton)));
            ((PreferenceGroup) (rewindCleanupButton)).setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                final SettingsFragment this$0;
                final ImageRewindSettingsHelper val$helper;

                public boolean onPreferenceClick(Preference preference)
                {
                    helper.onClick();
                    return true;
                }

            
            {
                this$0 = SettingsFragment.this;
                helper = imagerewindsettingshelper;
                super();
            }
            });
            rewindCleanupButton = new BroadcastReceiver() {

                final SettingsFragment this$0;
                final ImageRewindSettingsHelper val$helper;
                final PreferenceGroup val$rewindCleanupButton;

                public void onReceive(Context context, Intent intent)
                {
                    if (rewindCleanupButton != null)
                    {
                        helper.initializePreferenceView(rewindCleanupButton);
                    }
                }

            
            {
                this$0 = SettingsFragment.this;
                rewindCleanupButton = preferencegroup;
                helper = imagerewindsettingshelper;
                super();
            }
            };
            helper = new IntentFilter("com.amazon.gallery.app.IMAGE_REWIND_CLEANUP_COMPLETED");
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(((BroadcastReceiver) (rewindCleanupButton)), helper);
            return;
        } else
        {
            deviceCategory.removePreference(((Preference) (rewindCleanupButton)));
            getPreferenceScreen().removePreference(deviceCategory);
            return;
        }
    }

    private void setupLegalInformation()
    {
        Preference preference = findPreference("legal_information_button");
        if (!BuildFlavors.isAosp())
        {
            cloudDriveCategory.removePreference(preference);
            return;
        } else
        {
            preference.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                final SettingsFragment this$0;

                public boolean onPreferenceClick(Preference preference1)
                {
                    preference1 = new Intent(getActivity(), com/amazon/gallery/thor/app/activity/LegalInformationSettingsActivity);
                    getActivity().startActivity(preference1);
                    return true;
                }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupReportIssue()
    {
        Preference preference = findPreference("report_issue");
        if (!BuildFlavors.isAosp())
        {
            cloudDriveCategory.removePreference(preference);
            return;
        } else
        {
            preference.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                final SettingsFragment this$0;
                final CustomerMetricsInfo val$info;

                public boolean onPreferenceClick(Preference preference1)
                {
                    (new ReportIssueUtility()).sendEmail(getActivity(), info.getAppVersionName());
                    return true;
                }

            
            {
                this$0 = SettingsFragment.this;
                info = customermetricsinfo;
                super();
            }
            });
            return;
        }
    }

    private void setupRootWarning()
    {
        Preference preference = findPreference("root_disclaimer");
        if (!RootUtil.deviceIsRooted())
        {
            cloudDriveCategory.removePreference(preference);
        }
    }

    private void setupSendFeedback()
    {
        findPreference("send_feedback_button").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final SettingsFragment this$0;

            public boolean onPreferenceClick(Preference preference)
            {
                Endpoint endpoint = ((RestClient)((BeanAwareApplication)getActivity().getApplication()).getBeanFactory().getBean(Keys.REST_CLIENT)).getEndpointManager().getCachedEndpoint();
                preference = null;
                if (endpoint != null)
                {
                    preference = endpoint.getHttpHostString();
                }
                preference = SendFeedbackHelper.getIntentForSendFeedback(getActivity(), preference);
                try
                {
                    startActivity(preference);
                }
                // Misplaced declaration of an exception variable
                catch (Preference preference)
                {
                    Toast.makeText(getActivity(), getString(0x7f0e01dd), 1).show();
                    return true;
                }
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
    }

    private void setupSignOut()
    {
        Preference preference = findPreference("signout_settings_button");
        if (!BuildFlavors.isAosp())
        {
            cloudDriveCategory.removePreference(preference);
            return;
        }
        String s = (new AospPreferences(getActivity())).getEmail();
        if (s != null)
        {
            preference.setSummary(s);
        }
        preference.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final SettingsFragment this$0;

            public boolean onPreferenceClick(Preference preference1)
            {
                (new AospSignOutHelper(new WeakReference(getActivity()))).confirmSignOut();
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
    }

    private void setupThisDay()
    {
        findPreference("this_day_notification_key").setOnPreferenceChangeListener(new SwitchPreferenceChangeListener() {

            private final ThisDayMetricsHelper metricsHelper;
            final SettingsFragment this$0;

            protected boolean switchPreferenceChanged(Preference preference, boolean flag)
            {
                if (!(new ThisDaySharedPrefsManager(getActivity())).areNotificationsEnabled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                (new ThisDaySharedPrefsManager(getActivity())).setNotificationPreference(flag);
                if (flag)
                {
                    BroadcastReceiverUtility.toggleBroadcastReceiver(getActivity().getApplicationContext(), com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver, true);
                    ((ThisDayAlarmManager)ThorGalleryApplication.getBean(Keys.THIS_DAY_ALARM_MANAGER)).setAlarm(com.amazon.gallery.thor.thisday.ThisDayAlarmManager.AlarmType.NOTIFICATION_ALARM, false);
                } else
                {
                    ((ThisDayAlarmManager)ThorGalleryApplication.getBean(Keys.THIS_DAY_ALARM_MANAGER)).cancelAlarm(com.amazon.gallery.thor.thisday.ThisDayAlarmManager.AlarmType.NOTIFICATION_ALARM);
                    BroadcastReceiverUtility.toggleBroadcastReceiver(getActivity().getApplicationContext(), com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver, false);
                }
                metricsHelper.onNotificationsToggleFromSettings(flag);
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
                metricsHelper = new ThisDayMetricsHelper((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER));
            }
        });
    }

    private void setupViewHiddenContent()
    {
        findPreference("view_hidden_content_button").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final SettingsFragment this$0;

            public boolean onPreferenceClick(Preference preference)
            {
                preference = new Intent(getActivity(), com/amazon/gallery/thor/app/activity/HiddenNativeGalleryActivity);
                preference.setAction("com.amazon.photos.INTERNAL");
                preference.putExtra("view_hidden_content_button", true);
                getActivity().startActivity(preference);
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
    }

    private void updateEnabledOptions(boolean flag)
    {
        if (wanAllowed != null)
        {
            wanAllowed.setEnabled(flag);
        }
        if (folderSettings != null)
        {
            folderSettings.setEnabled(flag);
        }
        if (freeTimeSettingsButton != null)
        {
            freeTimeSettingsButton.setEnabled(flag);
        }
        if (autoUploadPowerSettings != null)
        {
            autoUploadPowerSettings.setEnabled(flag);
        }
    }

    public void attachPreferenceListeners()
    {
        findPreference("auto_upload_photos_key").setOnPreferenceChangeListener(autoUploadPreferenceChangeListener);
        findPreference("auto_upload_videos_key").setOnPreferenceChangeListener(autoUploadPreferenceChangeListener);
        autoUploadPowerSettings = findPreference("auto_upload_only_when_charging_key");
        autoUploadPowerSettings.setOnPreferenceChangeListener(autoUploadPowerSettingsChangeListener);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupManageStorage();
        setupDownloadPreference();
        setupSignOut();
        setupLegalInformation();
        setupSendFeedback();
        setupReportIssue();
        setupRootWarning();
        setupImageRewind();
        amazoninsightsHelper.loadLaunch("This Day", "show_notifications", new com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LaunchLoadedListener() {

            final SettingsFragment this$0;

            public void onLaunchLoaded(boolean flag)
            {
                if (flag)
                {
                    setupThisDay();
                    return;
                } else
                {
                    Preference preference = getPreferenceScreen().findPreference("this_day_category");
                    getPreferenceScreen().removePreference(preference);
                    return;
                }
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        if (FeatureManager.isFeatureEnabled(Features.HIDE))
        {
            setupViewHiddenContent();
        }
        if (deviceCategory.getPreferenceCount() == 0)
        {
            getPreferenceScreen().removePreference(deviceCategory);
        }
        backupManager = new BackupManager(getActivity());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f050003);
        initCategories();
        attachPreferenceListeners();
        updatePreferences();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (layoutinflater != null)
        {
            viewgroup = (ListView)layoutinflater.findViewById(0x102000a);
            int i = getResources().getDimensionPixelSize(0x7f0a01b3);
            viewgroup.setPadding(i, getResources().getDimensionPixelSize(0x7f0a01b4), i, 0);
        }
        return layoutinflater;
    }

    public void setupManageStorage()
    {
        findPreference("manage_storage_button").setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

            final SettingsFragment this$0;

            public boolean onPreferenceClick(Preference preference)
            {
                GalleryWebViewHelper.startManageStorage(getActivity());
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
    }

    public void updatePreferences()
    {
        folderSettings = findPreference("folder_settings_button");
        wanAllowed = findPreference("wan_allowed_key");
        freeTimeSettingsButton = findPreference("freetime_settings_button");
        FreeTime freetime = (FreeTime)ThorGalleryApplication.getBean(AppKeys.THOR_FREE_TIME);
        if (!freetime.isFreeTimeFeatureEnabled() || freeTimeSettingsButton != null && (!CameraUtils.isCameraAvailable(getActivity()) || freetime.getFreetimeProfiles().isEmpty()))
        {
            autoSaveCategory.removePreference(freeTimeSettingsButton);
        } else
        {
            freeTimeSettingsButton.setTitle(getResources().getString(0x7f0e0148, new Object[] {
                freetime.getFreetimeModeName()
            }));
        }
        if (!((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).deviceHasWAN())
        {
            autoSaveCategory.removePreference(wanAllowed);
            findPreference("auto_upload_videos_key").setSummary("");
        }
        if (!FeatureManager.isFeatureEnabled(Features.HIDE))
        {
            hiddenCategory.removePreference(findPreference("show_hidden_content_key"));
            hiddenCategory.removePreference(findPreference("view_hidden_content_button"));
        } else
        {
            findPreference("show_hidden_content_key").setOnPreferenceChangeListener(hiddenPreferenceChangeListener);
        }
        updateEnabledOptions(isAutoUploadEnabled());
    }










}
