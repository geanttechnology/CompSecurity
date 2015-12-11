// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.view.View;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.android.view.settings.PreferenceDelegate;
import com.comcast.cim.cmasl.android708compatlib.view.preference.CCPreferenceDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.playerplatform.primetime.android.util.PlayerPlatformVersion;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.downloads.RegisteredDevice;
import com.xfinity.playerlib.downloads.RegistrationListClient;
import com.xfinity.playerlib.downloads.UnregisterDeviceClient;
import com.xfinity.playerlib.model.downloads.NotificationQueueManager;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.authentication.PlayNowSignoutActivity;
import com.xfinity.playerlib.view.common.AdultContentSettingChangeActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            ButtonPreference

public class PlayNowPreferenceDelegate extends PreferenceDelegate
{

    protected PlayerAndroidDevice androidDevice;
    private final PlayerApplication app = PlayerApplication.getInstance();
    private final List availableConfigurations;
    private final CCPreferenceDelegate ccPrefDelegate;
    private final PlayerConfiguration configuration;
    private Activity context;
    private List deviceList;
    private TaskExecutionListener deviceListListener;
    private TaskExecutor deviceListTaskExecutor;
    private final ErrorFormatter errorFormatter;
    private final Task liveStreamResourceCache;
    private final NotificationQueueManager notificationQueueManager = PlayerContainer.getInstance().getNotificationQueueManager();
    private final Task parentalControlsCache;
    private final PlayerDownloadServiceManager playerDownloadServiceManager;
    private PreferenceFragment prefFragment;
    private final RegistrationListClient registrationListClient;
    private final TaskExecutorFactory taskExecutorFactory;
    private final UnregisterDeviceClient unregisterDeviceClient;
    private PlayNowUserManager userManager;

    public PlayNowPreferenceDelegate(PreferenceFragment preferencefragment, PlayNowUserManager playnowusermanager, Task task, TaskExecutorFactory taskexecutorfactory, UnregisterDeviceClient unregisterdeviceclient, PlayerDownloadServiceManager playerdownloadservicemanager, RegistrationListClient registrationlistclient, 
            ErrorFormatter errorformatter, PlayerConfiguration playerconfiguration, List list, Task task1)
    {
        super(preferencefragment.getActivity());
        androidDevice = PlayerContainer.getInstance().getAndroidDevice();
        deviceListTaskExecutor = null;
        deviceListListener = null;
        deviceList = null;
        prefFragment = preferencefragment;
        context = preferencefragment.getActivity();
        userManager = playnowusermanager;
        parentalControlsCache = task;
        taskExecutorFactory = taskexecutorfactory;
        unregisterDeviceClient = unregisterdeviceclient;
        playerDownloadServiceManager = playerdownloadservicemanager;
        registrationListClient = registrationlistclient;
        errorFormatter = errorformatter;
        configuration = playerconfiguration;
        availableConfigurations = list;
        liveStreamResourceCache = task1;
        ccPrefDelegate = new CCPreferenceDelegate(context, null, getPrefFragment());
    }

    private void fetchDevices()
    {
        deviceListTaskExecutor = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PlayNowPreferenceDelegate this$0;

            public volatile Object execute()
            {
                return execute();
            }

            public List execute()
            {
                return (List)CommonUtils.uncheckedCast(registrationListClient.getDeviceRegistrationList(((PlayNowUser)userManager.getUser()).getAuthKeys()));
            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
        });
        deviceListListener = new DefaultTaskExecutionListener() {

            final PlayNowPreferenceDelegate this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                taskexecutionexception = getErrorDialogBuilder((Exception)taskexecutionexception.getCause());
                taskexecutionexception.setPositiveButton(com.xfinity.playerlib.R.string.dlg_btn_try_again, new android.content.DialogInterface.OnClickListener() {

                    final _cls12 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        deviceListTaskExecutor.execute(deviceListListener);
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                }).setNegativeButton(com.xfinity.playerlib.R.string.dlg_btn_cancel, new android.content.DialogInterface.OnClickListener() {

                    final _cls12 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.cancel();
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final _cls12 this$1;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        dialoginterface = findPreference(context.getString(com.xfinity.playerlib.R.string.settings_manage_devices_loading_key));
                        if (dialoginterface != null)
                        {
                            getPreferenceScreen().removePreference(dialoginterface);
                        }
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                });
                taskexecutionexception.create().show();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            public void onPostExecute(List list)
            {
                deviceList = list;
                Object obj = findPreference(com.xfinity.playerlib.R.string.settings_manage_devices_loading_key);
                if (obj != null)
                {
                    getPreferenceScreen().removePreference(((Preference) (obj)));
                }
                obj = ((PlayerUserSettings)userManager.getUserSettings()).getDeviceRegistration();
                ButtonPreference buttonpreference;
                for (list = list.iterator(); list.hasNext(); getPreferenceScreen().addPreference(buttonpreference))
                {
                    RegisteredDevice registereddevice = (RegisteredDevice)list.next();
                    buttonpreference = new ButtonPreference(context, null);
                    buttonpreference.setKey(registereddevice.getDeviceId());
                    buttonpreference.setTitleText(registereddevice.getDeviceName());
                    if (obj != null && registereddevice.getDeviceId().equals(((DeviceRegistration) (obj)).getDeviceId()))
                    {
                        Resources resources = getPreferenceScreen().getContext().getResources();
                        buttonpreference.setTitleText(resources.getString(com.xfinity.playerlib.R.string.settings_dl_devices_this_device));
                        buttonpreference.setRightButtonText(resources.getString(com.xfinity.playerlib.R.string.settings_dl_devices_remove));
                        buttonpreference.setRightButtonClickListener(buttonpreference. new android.view.View.OnClickListener() {

                            final _cls12 this$1;
                            final ButtonPreference val$button;

                            public void onClick(View view)
                            {
                                button.showProgress();
                                unregisterDevice();
                            }

            
            {
                this$1 = final__pcls12;
                button = ButtonPreference.this;
                super();
            }
                        });
                    }
                }

            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
        };
        deviceListTaskExecutor.execute(deviceListListener);
    }

    private android.app.AlertDialog.Builder getErrorDialogBuilder(Exception exception)
    {
        String s;
        android.app.AlertDialog.Builder builder;
        if (exception instanceof DownloadServiceException)
        {
            s = context.getString(com.xfinity.playerlib.R.string.device_registration_failed_title);
            exception = context.getString(com.xfinity.playerlib.R.string.device_registration_failed_message, new Object[] {
                exception.getMessage()
            });
        } else
        {
            exception = errorFormatter.formatError(exception);
            s = exception.getTitle();
            exception = exception.getDescription();
        }
        builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(exception).setTitle(s);
        return builder;
    }

    private PreferenceScreen getPreferenceScreen()
    {
        return prefFragment.getPreferenceScreen();
    }

    private boolean isIntentAvailable(String s)
    {
        return context.getPackageManager().queryIntentActivities(new Intent(s), 0x10000).size() > 0;
    }

    private void showUnregisterErrorDialog(Exception exception)
    {
        exception = getErrorDialogBuilder(exception);
        exception.setPositiveButton(com.xfinity.playerlib.R.string.dlg_btn_try_again, new android.content.DialogInterface.OnClickListener() {

            final PlayNowPreferenceDelegate this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                unregisterDevice();
                dialoginterface.dismiss();
            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
        }).setNegativeButton(com.xfinity.playerlib.R.string.dlg_btn_ok, new android.content.DialogInterface.OnClickListener() {

            final PlayNowPreferenceDelegate this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final PlayNowPreferenceDelegate this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (deviceList != null)
                {
                    dialoginterface = deviceList.iterator();
                    do
                    {
                        if (!dialoginterface.hasNext())
                        {
                            break;
                        }
                        Object obj = (RegisteredDevice)dialoginterface.next();
                        PreferenceScreen preferencescreen = getPreferenceScreen();
                        obj = preferencescreen.findPreference(((RegisteredDevice) (obj)).getDeviceId());
                        if (obj != null)
                        {
                            preferencescreen.removePreference(((Preference) (obj)));
                        }
                    } while (true);
                }
                fetchDevices();
            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
        });
        exception.create().show();
    }

    private void signout()
    {
        Intent intent = new Intent(context, com/xfinity/playerlib/view/authentication/PlayNowSignoutActivity);
        context.startActivity(intent);
    }

    private void unregisterDevice()
    {
        final PlayerUserSettings settings = (PlayerUserSettings)userManager.getUserSettings();
        taskExecutorFactory.create(new NonCachingBaseTask() {

            final PlayNowPreferenceDelegate this$0;
            final PlayerUserSettings val$settings;

            public volatile Object execute()
            {
                return execute();
            }

            public Void execute()
            {
                unregisterDeviceClient.unregisterDevice(((PlayNowUser)userManager.getUser()).getAuthKeys(), settings.getDeviceRegistration().getDeviceId());
                return null;
            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
        }).execute(new DefaultTaskExecutionListener() {

            final PlayNowPreferenceDelegate this$0;
            final PlayerUserSettings val$settings;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                try
                {
                    showUnregisterErrorDialog((Exception)taskexecutionexception.getCause());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (TaskExecutionException taskexecutionexception)
                {
                    Log.e("Settings", "Failed to show Alert Dialog for Unregister Failure!");
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            public void onPostExecute(Void void1)
            {
                void1 = settings.getDeviceRegistration().getDeviceId();
                void1 = (ButtonPreference)findPreference(void1);
                try
                {
                    playerDownloadServiceManager.deleteAllContent();
                    settings.setDeviceRegistration(null);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    showUnregisterErrorDialog(void1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    Log.e("Settings", "Failed to show Alert Dialog for Unregister Success!");
                    return;
                }
                if (void1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                getPreferenceScreen().removePreference(void1);
                void1 = new android.app.AlertDialog.Builder(context);
                void1.setMessage("Device has been unregistered").setTitle("Device Unregistration").setPositiveButton(context.getString(com.xfinity.playerlib.R.string.dlg_btn_ok), new android.content.DialogInterface.OnClickListener() {

                    final _cls14 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
                void1.create().show();
                return;
            }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
        });
    }

    public void cancelListeners()
    {
        if (deviceListTaskExecutor != null)
        {
            deviceListTaskExecutor.cancelNotificationsFor(deviceListListener);
        }
    }

    protected PreferenceFragment getPrefFragment()
    {
        return prefFragment;
    }

    public void initPreferences()
    {
        String s1;
        Preference preference;
        Object obj = (CheckBoxPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_show_adult);
        if (obj != null)
        {
            final PlayerUserSettings settings = (PlayerUserSettings)userManager.getUserSettings();
            ((CheckBoxPreference) (obj)).setChecked(settings.getWantsAdultContent());
            ((CheckBoxPreference) (obj)).setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final PlayNowPreferenceDelegate this$0;
                final PlayerUserSettings val$settings;

                public boolean onPreferenceChange(Preference preference1, Object obj2)
                {
                    preference1 = (ParentalControlsSettings)parentalControlsCache.getCachedResultIfAvailable();
                    obj2 = Boolean.valueOf(obj2.toString());
                    if (!((Boolean) (obj2)).booleanValue() || preference1 != null && preference1.getParentalPin() == null)
                    {
                        notificationQueueManager.cancelAdultDownloadNotifications();
                        settings.setWantsAdultContent(((Boolean) (obj2)).booleanValue());
                        return true;
                    } else
                    {
                        preference1 = new Intent(context, com/xfinity/playerlib/view/common/AdultContentSettingChangeActivity);
                        preference1.addFlags(0x40000000);
                        context.startActivity(preference1);
                        return false;
                    }
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
            });
        }
        obj = findPreference(com.xfinity.playerlib.R.string.settings_key_signout);
        if (obj != null)
        {
            ((Preference) (obj)).setSummary(((PlayNowUser)userManager.getUser()).getUserName());
            ((Preference) (obj)).setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                final PlayNowPreferenceDelegate this$0;

                public boolean onPreferenceClick(Preference preference1)
                {
                    signout();
                    return true;
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
            });
        }
        s1 = context.getApplicationContext().getPackageName();
        preference = findPreference(com.xfinity.playerlib.R.string.settings_key_app_version_info);
        if (preference == null) goto _L2; else goto _L1
_L1:
        String s = "not available";
        s1 = app.getPackageManager().getPackageInfo(s1, 0).versionName;
        s = s1;
_L4:
        s = (new StringBuilder()).append(s).append(" ").append(PlayerContainer.getInstance().getConfigurationVersion()).toString();
        preference.setTitle((new StringBuilder()).append("Application Version ").append(s).toString());
_L2:
        final PlayerUserSettings settings = (CheckBoxPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_use_cellular_data);
        if (settings != null)
        {
            final PlayerUserSettings settings = (PlayerUserSettings)userManager.getUserSettings();
            settings.setChecked(settings.getUseCellularWhenAvailable());
            settings.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final PlayNowPreferenceDelegate this$0;
                final PlayerUserSettings val$settings;

                public boolean onPreferenceChange(Preference preference1, Object obj2)
                {
                    preference1 = Boolean.valueOf(obj2.toString());
                    obj2 = playerDownloadServiceManager;
                    double d;
                    if (preference1.booleanValue())
                    {
                        d = -1D;
                    } else
                    {
                        d = 0.0D;
                    }
                    try
                    {
                        ((PlayerDownloadServiceManager) (obj2)).setCellularDataThreshold(d);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Preference preference1)
                    {
                        playerDownloadServiceManager.showCrashDialog(context, preference1);
                        return true;
                    }
                    settings.setUseCellularWhenAvailable(preference1.booleanValue());
                    return true;
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
            });
        }
        if (findPreference(com.xfinity.playerlib.R.string.settings_manage_devices_loading_key) != null)
        {
            fetchDevices();
        }
        settings = (PlayerUserSettings)userManager.getUserSettings();
        Object obj1 = (CheckBoxPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_show_volume);
        if (obj1 != null)
        {
            ((CheckBoxPreference) (obj1)).setChecked(settings.getWantsVolumeControl());
            ((CheckBoxPreference) (obj1)).setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final PlayNowPreferenceDelegate this$0;
                final PlayerUserSettings val$settings;

                public boolean onPreferenceChange(Preference preference1, Object obj2)
                {
                    obj2 = (Boolean)obj2;
                    ((CheckBoxPreference)preference1).setChecked(((Boolean) (obj2)).booleanValue());
                    settings.setWantsVolumeControl(((Boolean) (obj2)).booleanValue());
                    return false;
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
            });
        }
        obj1 = (CheckBoxPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_show_brightness);
        if (obj1 != null)
        {
            ((CheckBoxPreference) (obj1)).setChecked(settings.getWantsBrightnessControl());
            ((CheckBoxPreference) (obj1)).setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final PlayNowPreferenceDelegate this$0;
                final PlayerUserSettings val$settings;

                public boolean onPreferenceChange(Preference preference1, Object obj2)
                {
                    obj2 = (Boolean)obj2;
                    ((CheckBoxPreference)preference1).setChecked(((Boolean) (obj2)).booleanValue());
                    settings.setWantsBrightnessControl(((Boolean) (obj2)).booleanValue());
                    return false;
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
            });
        }
        obj1 = (ListPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_video_quality);
        if (obj1 != null)
        {
            ((ListPreference) (obj1)).setValue(String.valueOf(settings.getWantsStaticBitrate()));
            ((ListPreference) (obj1)).setSummary(((ListPreference) (obj1)).getEntry());
            ((ListPreference) (obj1)).setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final PlayNowPreferenceDelegate this$0;
                final PlayerUserSettings val$settings;

                public boolean onPreferenceChange(Preference preference1, Object obj2)
                {
                    obj2 = (String)obj2;
                    ((ListPreference)preference1).setValue(((String) (obj2)));
                    preference1.setSummary(((ListPreference)preference1).getEntry());
                    settings.setWantsStaticBitrate(Boolean.valueOf(((String) (obj2))).booleanValue());
                    return false;
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                settings = playerusersettings;
                super();
            }
            });
        }
        settings = (PreferenceScreen)findPreference(com.xfinity.playerlib.R.string.settings_key_cc_options);
        if (settings != null)
        {
            ccPrefDelegate.setupPreferences((com.comcast.cim.cmasl.android708compatlib.view.preference.CCPreviewPreference.CCPreferenceStore)userManager.getUserSettings(), settings);
        }
        if ((PreferenceScreen)findPreference(com.xfinity.playerlib.R.string.settings_key_developer_options) != null)
        {
            final Object devConfiguration = (ListPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_developer_configuration);
            if (devConfiguration != null)
            {
                final CheckBoxPreference darkStreams = new ArrayList(availableConfigurations.size());
                darkStreams.add(app.getString(com.xfinity.playerlib.R.string.settings_developer_configuration_default));
                for (Iterator iterator = availableConfigurations.iterator(); iterator.hasNext(); darkStreams.add(((PlayerConfiguration)iterator.next()).getClass().getSimpleName())) { }
                CharSequence acharsequence[] = (CharSequence[])darkStreams.toArray(new CharSequence[darkStreams.size()]);
                ((ListPreference) (devConfiguration)).setEntries(acharsequence);
                ((ListPreference) (devConfiguration)).setEntryValues(acharsequence);
                acharsequence = configuration.getDeveloperConfiguration();
                CheckBoxPreference checkboxpreference;
                if (acharsequence != null)
                {
                    ((ListPreference) (devConfiguration)).setValue(acharsequence.getClass().getSimpleName());
                    ((ListPreference) (devConfiguration)).setTitle(app.getString(com.xfinity.playerlib.R.string.settings_title_developer_configuration, new Object[] {
                        acharsequence.getClass().getSimpleName()
                    }));
                } else
                {
                    ((ListPreference) (devConfiguration)).setValue(app.getString(com.xfinity.playerlib.R.string.settings_developer_configuration_default));
                    ((ListPreference) (devConfiguration)).setTitle(app.getString(com.xfinity.playerlib.R.string.settings_title_developer_configuration, new Object[] {
                        app.getString(com.xfinity.playerlib.R.string.settings_developer_configuration_default)
                    }));
                }
                ((ListPreference) (devConfiguration)).setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                    final PlayNowPreferenceDelegate this$0;

                    public boolean onPreferenceChange(Preference preference1, Object obj2)
                    {
                        obj2 = (String)obj2;
                        ((ListPreference)preference1).setValue(((String) (obj2)));
                        preference1.setTitle(context.getResources().getString(com.xfinity.playerlib.R.string.settings_title_developer_configuration, new Object[] {
                            obj2
                        }));
                        if (!((String) (obj2)).equals(app.getString(com.xfinity.playerlib.R.string.settings_developer_configuration_default))) goto _L2; else goto _L1
_L1:
                        configuration.setDeveloperConfiguration(null);
_L4:
                        return false;
_L2:
                        PlayerConfiguration playerconfiguration;
                        preference1 = availableConfigurations.iterator();
                        do
                        {
                            if (!preference1.hasNext())
                            {
                                continue; /* Loop/switch isn't completed */
                            }
                            playerconfiguration = (PlayerConfiguration)preference1.next();
                        } while (!playerconfiguration.getClass().getSimpleName().equals(obj2));
                        break; /* Loop/switch isn't completed */
                        if (true) goto _L4; else goto _L3
_L3:
                        configuration.setDeveloperConfiguration(playerconfiguration);
                        return false;
                    }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
                });
                ((ListPreference) (devConfiguration)).setEnabled(configuration.isDeveloperModeEnabled());
            }
            acharsequence = (CheckBoxPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_show_dark_streams);
            if (acharsequence != null)
            {
                acharsequence.setEnabled(configuration.isDeveloperModeEnabled());
                acharsequence.setChecked(configuration.isDarkStreamsEnabled());
                acharsequence.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                    final PlayNowPreferenceDelegate this$0;

                    public boolean onPreferenceChange(Preference preference1, Object obj2)
                    {
                        obj2 = (Boolean)obj2;
                        ((CheckBoxPreference)preference1).setChecked(((Boolean) (obj2)).booleanValue());
                        configuration.setDarkStreamsEnabled(((Boolean) (obj2)));
                        liveStreamResourceCache.clearCachedResult();
                        return false;
                    }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
                });
            }
            checkboxpreference = (CheckBoxPreference)findPreference(com.xfinity.playerlib.R.string.settings_key_dev_mode_on);
            if (checkboxpreference != null)
            {
                checkboxpreference.setChecked(configuration.isDeveloperModeEnabled());
                checkboxpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                    final PlayNowPreferenceDelegate this$0;
                    final CheckBoxPreference val$darkStreams;
                    final ListPreference val$devConfiguration;

                    public boolean onPreferenceChange(Preference preference1, Object obj2)
                    {
                        obj2 = (Boolean)obj2;
                        ((CheckBoxPreference)preference1).setChecked(((Boolean) (obj2)).booleanValue());
                        configuration.setDeveloperModeEnabled(((Boolean) (obj2)).booleanValue());
                        devConfiguration.setEnabled(configuration.isDeveloperModeEnabled());
                        darkStreams.setEnabled(configuration.isDeveloperModeEnabled());
                        return false;
                    }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                devConfiguration = listpreference;
                darkStreams = checkboxpreference;
                super();
            }
                });
            }
        }
        devConfiguration = findPreference(com.xfinity.playerlib.R.string.settings_key_call_us);
        if (devConfiguration != null && !isIntentAvailable("android.intent.action.DIAL"))
        {
            ((Preference) (devConfiguration)).setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {

                final PlayNowPreferenceDelegate this$0;

                public boolean onPreferenceClick(Preference preference1)
                {
                    return true;
                }

            
            {
                this$0 = PlayNowPreferenceDelegate.this;
                super();
            }
            });
        }
        devConfiguration = findPreference(com.xfinity.playerlib.R.string.settings_key_developer_viper_version);
        if (devConfiguration != null)
        {
            ((Preference) (devConfiguration)).setSummary(PlayerPlatformVersion.getPlayerPlatformVersion());
        }
        devConfiguration = findPreference(com.xfinity.playerlib.R.string.settings_key_developer_adobe_version);
        if (devConfiguration != null)
        {
            ((Preference) (devConfiguration)).setSummary(PlayerPlatformVersion.getAdobeVersion());
        }
        devConfiguration = findPreference(com.xfinity.playerlib.R.string.settings_key_developer_disney_version);
        if (devConfiguration != null)
        {
            ((Preference) (devConfiguration)).setSummary(PlayerPlatformVersion.getDisneyVersion());
        }
        devConfiguration = findPreference(com.xfinity.playerlib.R.string.settings_key_developer_espn_version);
        if (devConfiguration != null)
        {
            ((Preference) (devConfiguration)).setSummary(PlayerPlatformVersion.getEspnVersion());
        }
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L4; else goto _L3
_L3:
    }






/*
    static List access$1102(PlayNowPreferenceDelegate playnowpreferencedelegate, List list)
    {
        playnowpreferencedelegate.deviceList = list;
        return list;
    }

*/



















}
