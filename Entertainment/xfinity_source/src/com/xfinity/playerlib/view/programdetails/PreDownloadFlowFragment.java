// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.CancellingClickListener;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.hls.HlsDownloadClient;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylistParser;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylistParser;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.DeferringTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.comcast.cim.model.user.XipUser;
import com.comcast.cim.utils.UIPresentationUtil;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.player.PlayerPlatformAPI;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.xfinity.playerlib.authorization.SMILResource;
import com.xfinity.playerlib.authorization.ThePlatformClient;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.downloads.MediaLicenseClient;
import com.xfinity.playerlib.downloads.RegisterDeviceClient;
import com.xfinity.playerlib.downloads.TitaniumTicket;
import com.xfinity.playerlib.downloads.TitaniumTicketClient;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.model.videoplay.PlayerConfigurationListener;
import com.xfinity.playerlib.model.videoplay.adobeplayer.CimAssetFactory;
import com.xfinity.playerlib.view.common.ParentalControlPinFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreDownloadFlowFragment extends Fragment
{
    private class DefaultDialogLifecycleManager extends DialogLifecycleManager
    {

        private final String dialogId;
        private final Provider dialogProvider;
        private CALDialogFragment managedDialog;
        final PreDownloadFlowFragment this$0;

        protected void dismissDialog()
        {
            managedDialog.dismiss();
        }

        protected String getDialogId()
        {
            return dialogId;
        }

        protected void showDialogWithDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
        {
            LOG.debug((new StringBuilder()).append("Resuming dialog with id ").append(dialogId).toString());
            managedDialog = (CALDialogFragment)dialogProvider.get();
            managedDialog.setOnDismissListener(ondismisslistener);
            managedDialog.show(getFragmentManager(), "caldialogfragment");
        }

        public DefaultDialogLifecycleManager(Provider provider, String s)
        {
            this$0 = PreDownloadFlowFragment.this;
            super();
            dialogId = s;
            dialogProvider = provider;
        }
    }

    private class DeferWhenPausedTaskExecutionListener extends DeferringTaskExecutionListener
    {

        final PreDownloadFlowFragment this$0;

        protected void onDefer(Runnable runnable)
        {
            abortFlow();
        }

        protected boolean shouldDefer()
        {
            return !isResumed();
        }

        private DeferWhenPausedTaskExecutionListener(TaskExecutionListener taskexecutionlistener)
        {
            this$0 = PreDownloadFlowFragment.this;
            super(taskexecutionlistener);
        }

    }

    private abstract class DialogLifecycleManager
    {

        private boolean isDismissingFromOnPause;
        final PreDownloadFlowFragment this$0;

        protected abstract void dismissDialog();

        protected abstract String getDialogId();

        public void onPause()
        {
            isDismissingFromOnPause = true;
            dismissDialog();
        }

        public void onResume()
        {
            showDialogWithDismissListener(new android.content.DialogInterface.OnDismissListener() {

                final DialogLifecycleManager this$1;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    if (isDismissingFromOnPause)
                    {
                        isDismissingFromOnPause = false;
                        return;
                    }
                    if (dialogLifecycleManager == DialogLifecycleManager.this)
                    {
                        LOG.debug("From onDismiss, nulling out lifecycle manager for {}", getDialogId());
                        dialogLifecycleManager = null;
                        return;
                    } else
                    {
                        LOG.info("dialogLifecycleManager reference has been updated since we were dismissed, not clearing reference");
                        return;
                    }
                }

            
            {
                this$1 = DialogLifecycleManager.this;
                super();
            }
            });
        }

        protected abstract void showDialogWithDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener);



/*
        static boolean access$4802(DialogLifecycleManager dialoglifecyclemanager, boolean flag)
        {
            dialoglifecyclemanager.isDismissingFromOnPause = flag;
            return flag;
        }

*/

        private DialogLifecycleManager()
        {
            this$0 = PreDownloadFlowFragment.this;
            super();
        }

    }

    private class ParentalControlPinFragmentLifecycleManager extends DialogLifecycleManager
    {

        private ParentalControlPinFragment fragment;
        private final Provider fragmentProvider;
        final PreDownloadFlowFragment this$0;

        protected void dismissDialog()
        {
            fragment.dismiss();
        }

        protected String getDialogId()
        {
            return "parental control pin fragment";
        }

        protected void showDialogWithDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
        {
            fragment = (ParentalControlPinFragment)fragmentProvider.get();
            FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
            fragmenttransaction.addToBackStack(null);
            fragment.setOnDismissListener(ondismisslistener);
            fragment.show(fragmenttransaction, "dialog");
        }

        public ParentalControlPinFragmentLifecycleManager(Provider provider)
        {
            this$0 = PreDownloadFlowFragment.this;
            super();
            fragmentProvider = provider;
        }
    }

    public static interface PreDownloadFlowEventListener
    {

        public abstract void onPreDownloadFlowCompleted(VideoFacade videofacade);
    }

    private abstract class RetryingExecutionListener extends DefaultTaskExecutionListener
    {

        private final TaskExecutor provider;
        final PreDownloadFlowFragment this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            showDialog(taskexecutionexception. new Provider() {

                final RetryingExecutionListener this$1;
                final TaskExecutionException val$exception;

                public CALDialogFragment get()
                {
                    Object obj = errorFormatter.formatError(exception.getCause());
                    obj = errorDialogFactory.createErrorDialogForThrowable(exception, ((com.comcast.cim.android.view.common.errorformatter.FormattedError) (obj)), new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                        final RetryingExecutionListener._cls1 this$2;

                        public void tryAgain()
                        {
                            provider.execute(new DeferWhenPausedTaskExecutionListener(_fld1));
                        }

            
            {
                this$2 = RetryingExecutionListener._cls1.this;
                super();
            }
                    });
                    ((CALDialogFragment) (obj)).setOnCancelListener(abortFlowCancelListener);
                    return ((CALDialogFragment) (obj));
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$1 = final_retryingexecutionlistener;
                exception = TaskExecutionException.this;
                super();
            }
            }, "RetryingTaskExecutionListener", false);
        }


        protected RetryingExecutionListener(TaskExecutor taskexecutor)
        {
            this$0 = PreDownloadFlowFragment.this;
            super();
            provider = taskexecutor;
        }
    }

    private static final class VideoQuality extends Enum
    {

        private static final VideoQuality $VALUES[];
        public static final VideoQuality DEFAULT;
        public static final VideoQuality HIGH;
        public static final VideoQuality LOW;

        public static VideoQuality valueOf(String s)
        {
            return (VideoQuality)Enum.valueOf(com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality, s);
        }

        public static VideoQuality[] values()
        {
            return (VideoQuality[])$VALUES.clone();
        }

        static 
        {
            HIGH = new VideoQuality("HIGH", 0);
            LOW = new VideoQuality("LOW", 1);
            DEFAULT = new VideoQuality("DEFAULT", 2);
            $VALUES = (new VideoQuality[] {
                HIGH, LOW, DEFAULT
            });
        }

        private VideoQuality(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String FRAGMENT_TAG = com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment.getSimpleName();
    private static final Comparator MEDIA_AUDIO_PROFILE_COMPARATOR = new Comparator() {

        public int compare(com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile, com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile1)
        {
            if (!mediaaudioprofile.getLanguage().equals("eng") || mediaaudioprofile1.getLanguage().equals("eng"))
            {
                if (mediaaudioprofile1.getLanguage().equals("eng") && !mediaaudioprofile.getLanguage().equals("eng"))
                {
                    return 1;
                }
                if (!mediaaudioprofile.getLanguage().equals("spa") || mediaaudioprofile1.getLanguage().equals("spa"))
                {
                    if (mediaaudioprofile1.getLanguage().equals("spa") && !mediaaudioprofile.getLanguage().equals("spa"))
                    {
                        return 1;
                    } else
                    {
                        return mediaaudioprofile.getLanguage().compareTo(mediaaudioprofile1.getLanguage());
                    }
                }
            }
            return -1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)obj, (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)obj1);
        }

    };
    private static final Comparator MEDIA_PROFILE_BANDWIDTH_COMPARATOR = new Comparator() {

        public int compare(com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaprofile, com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaprofile1)
        {
            if (mediaprofile.getBandwidth() < mediaprofile1.getBandwidth())
            {
                return -1;
            }
            return mediaprofile.getBandwidth() != mediaprofile1.getBandwidth() ? 1 : 0;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)obj, (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)obj1);
        }

    };
    private final Logger LOG;
    private final android.content.DialogInterface.OnCancelListener abortFlowCancelListener;
    private final android.content.DialogInterface.OnDismissListener abortFlowDismissListener;
    private HlsSimplePlaylist alternateAudioPlaylist;
    private com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile alternateAudioProfile;
    private final Application application;
    private final CimAssetFactory cimAssetFactory;
    private DialogLifecycleManager dialogLifecycleManager;
    private final PlayerDownloadServiceManager downloadsManager;
    private VideoEntitlement entitlement;
    private final TaskExecutor entitlementProvider;
    private final ErrorDialogFactory errorDialogFactory;
    private final ErrorFormatter errorFormatter;
    private boolean flowAborted;
    private PreDownloadFlowEventListener flowEventListener;
    private final Handler handler;
    private final HlsDownloadClient hlsDownloadClient;
    private final HttpClient httpClient;
    private final InternetConnection internetConnection;
    private Date licenseExpirationDate;
    private String manifestUrl;
    private final MediaLicenseClient mediaLicenseClient;
    private HlsVariantPlaylist metaDownloadProfile;
    private final TaskExecutor pcSettingsProvider;
    private final PlayerConfigUtil playerConfigUtil;
    private HlsSimplePlaylist profileToDownload;
    private ProgressDialog progressDialog;
    private String progressDialogMessage;
    private final RegisterDeviceClient registerDeviceClient;
    private final Resources resources;
    private HalVideoProfile selectedHalVideoProfile;
    private VideoQuality selectedVideoQuality;
    private boolean shouldShowProgressDialogIfResumed;
    private final TaskExecutorFactory taskExecutorFactory;
    private final ThePlatformClient thePlatformClient;
    private TitaniumTicket titaniumTicket;
    private final TitaniumTicketClient titaniumTicketClient;
    private final PlayNowUserManager userManager;
    private VideoFacade video;
    private Watchable watchable;

    public PreDownloadFlowFragment()
    {
        LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment);
        handler = new Handler();
        resources = PlayerContainer.getInstance().getResources();
        internetConnection = PlayerContainer.getInstance().getInternetConnection();
        userManager = PlayerContainer.getInstance().getUserManager();
        application = PlayerContainer.getInstance().getApplication();
        httpClient = PlayerContainer.getInstance().getHttpClient();
        taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
        pcSettingsProvider = PlayerContainer.getInstance().getParentalControlsSettingsTaskExecutor();
        entitlementProvider = PlayerContainer.getInstance().getNonDegradingVideoEntitlementProvider();
        registerDeviceClient = PlayerContainer.getInstance().getRegisterDeviceClient();
        titaniumTicketClient = PlayerContainer.getInstance().getTitaniumTicketClient();
        mediaLicenseClient = PlayerContainer.getInstance().getMediaLicenseClient();
        hlsDownloadClient = PlayerContainer.getInstance().getHlsDownloadClient();
        thePlatformClient = PlayerContainer.getInstance().getThePlatformClient();
        downloadsManager = PlayerContainer.getInstance().getDownloadServiceManager();
        cimAssetFactory = PlayerContainer.getInstance().getCimAssetFactory();
        playerConfigUtil = PlayerContainer.getInstance().getPlayerConfigUtil();
        errorFormatter = PlayerContainer.getInstance().getDownloadErrorFormatter();
        errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
        flowAborted = false;
        abortFlowCancelListener = new android.content.DialogInterface.OnCancelListener() {

            final PreDownloadFlowFragment this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                abortFlow();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        };
        abortFlowDismissListener = new android.content.DialogInterface.OnDismissListener() {

            final PreDownloadFlowFragment this$0;

            public void onDismiss(DialogInterface dialoginterface)
            {
                abortFlow();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        };
    }

    public PreDownloadFlowFragment(Watchable watchable1, VideoFacade videofacade, PreDownloadFlowEventListener predownloadfloweventlistener)
    {
        LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment);
        handler = new Handler();
        resources = PlayerContainer.getInstance().getResources();
        internetConnection = PlayerContainer.getInstance().getInternetConnection();
        userManager = PlayerContainer.getInstance().getUserManager();
        application = PlayerContainer.getInstance().getApplication();
        httpClient = PlayerContainer.getInstance().getHttpClient();
        taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
        pcSettingsProvider = PlayerContainer.getInstance().getParentalControlsSettingsTaskExecutor();
        entitlementProvider = PlayerContainer.getInstance().getNonDegradingVideoEntitlementProvider();
        registerDeviceClient = PlayerContainer.getInstance().getRegisterDeviceClient();
        titaniumTicketClient = PlayerContainer.getInstance().getTitaniumTicketClient();
        mediaLicenseClient = PlayerContainer.getInstance().getMediaLicenseClient();
        hlsDownloadClient = PlayerContainer.getInstance().getHlsDownloadClient();
        thePlatformClient = PlayerContainer.getInstance().getThePlatformClient();
        downloadsManager = PlayerContainer.getInstance().getDownloadServiceManager();
        cimAssetFactory = PlayerContainer.getInstance().getCimAssetFactory();
        playerConfigUtil = PlayerContainer.getInstance().getPlayerConfigUtil();
        errorFormatter = PlayerContainer.getInstance().getDownloadErrorFormatter();
        errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
        flowAborted = false;
        abortFlowCancelListener = new _cls1();
        abortFlowDismissListener = new _cls2();
        Validate.notNull(watchable1);
        Validate.notNull(videofacade);
        Validate.notNull(predownloadfloweventlistener);
        watchable = watchable1;
        video = videofacade;
        flowEventListener = predownloadfloweventlistener;
    }

    private void acquireMediaLicense()
    {
        final PlayerPlatformAPI playerPlatformAPI = new PlayerPlatformAPI(application, httpClient);
        playerPlatformAPI = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;
            final PlayerPlatformAPI val$playerPlatformAPI;

            public volatile Object execute()
            {
                return execute();
            }

            public Date execute()
            {
                com.comcast.playerplatform.primetime.android.asset.Asset asset = cimAssetFactory.create(manifestUrl, titaniumTicket, video, DrmWorkflow.STREAMING);
                return mediaLicenseClient.getOrRefreshMediaLicense(playerPlatformAPI, asset);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                playerPlatformAPI = playerplatformapi;
                super();
            }
        });
        LOG.debug("Fetching media license for manifest url {}", manifestUrl);
        playerPlatformAPI.execute(new DeferWhenPausedTaskExecutionListener(new RetryingExecutionListener(playerPlatformAPI) {

            final PreDownloadFlowFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                if (taskexecutionexception.getCause() instanceof com.xfinity.playerlib.downloads.MediaLicenseClient.LicenseAcquisitionTimeoutException)
                {
                    showDialog(new Provider() {

                        final _cls27 this$1;

                        public CALDialogFragment get()
                        {
                            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlgRetryable");
                            caldialogfragment.setTryAgainListener(new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                                final _cls1 this$2;

                                public void tryAgain()
                                {
                                    acquireMediaLicense();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            Bundle bundle = new Bundle();
                            bundle.putString("description", getResources().getString(com.xfinity.playerlib.R.string.player_platform_error_msg_connection_problem));
                            caldialogfragment.addArguments(bundle);
                            caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                            return caldialogfragment;
                        }

                        public volatile Object get()
                        {
                            return get();
                        }

            
            {
                this$1 = _cls27.this;
                super();
            }
                    }, "acquireMediaLicense", false);
                    return;
                } else
                {
                    super.onError(taskexecutionexception);
                    return;
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Date)obj);
            }

            public void onPostExecute(Date date)
            {
                LOG.debug("Acquired media license");
                licenseExpirationDate = date;
                submitDownload();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        }));
    }

    private void checkParentalControls()
    {
        LOG.debug("Fetching parental control settings");
        reportProgress(resources.getString(com.xfinity.playerlib.R.string.checking_parental_controls_progress_message));
        RetryingExecutionListener retryingexecutionlistener = new RetryingExecutionListener(pcSettingsProvider) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(ParentalControlsSettings parentalcontrolssettings)
            {
                LOG.debug("Parental control settings fetched");
                ParentalControlsPin parentalcontrolspin = parentalcontrolssettings.getParentalPin();
                if (parentalcontrolspin != null && pinRequiredForVideo(parentalcontrolssettings, video))
                {
                    LOG.debug("Prompting for pin");
                    promptForParentalControlPin(parentalcontrolspin);
                    return;
                } else
                {
                    LOG.debug("Pin not set or not required for video");
                    fetchTitaniumTicket();
                    return;
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((ParentalControlsSettings)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        };
        pcSettingsProvider.execute(new DeferWhenPausedTaskExecutionListener(retryingexecutionlistener));
    }

    private void chooseVideoFormat()
    {
        LOG.debug("Prompting for video format");
        final HalVideoProfile lowQualityProfile = video.getLowQualityDownloadProfile();
        if (lowQualityProfile == null)
        {
            setSelectedHalVideoProfileAndProceedToNextStep(video.getDefaultDownloadProfile(), VideoQuality.DEFAULT);
            return;
        } else
        {
            showDialog(new Provider() {

                final PreDownloadFlowFragment this$0;
                final HalVideoProfile val$highQualityProfile;
                final HalVideoProfile val$lowQualityProfile;

                public CALDialogFragment get()
                {
                    Object obj = new Bundle();
                    ((Bundle) (obj)).putString("title", resources.getString(com.xfinity.playerlib.R.string.select_download_quality));
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
                    caldialogfragment.addArguments(((Bundle) (obj)));
                    obj = new ArrayList();
                    ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.download_quality_button_medium, new Object[] {
                        Long.valueOf(UIPresentationUtil.bytesToMB(lowQualityProfile.getContentSizeInBytes()))
                    }), new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            setSelectedHalVideoProfileAndProceedToNextStep(lowQualityProfile, VideoQuality.LOW);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    }));
                    ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.download_quality_button_high, new Object[] {
                        Long.valueOf(UIPresentationUtil.bytesToMB(highQualityProfile.getContentSizeInBytes()))
                    }), new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            setSelectedHalVideoProfileAndProceedToNextStep(highQualityProfile, VideoQuality.HIGH);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    }));
                    caldialogfragment.setButtonList(((List) (obj)));
                    caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                    return caldialogfragment;
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                lowQualityProfile = halvideoprofile;
                highQualityProfile = halvideoprofile1;
                super();
            }
            }, "chooseVideoFormat");
            return;
        }
    }

    private void configurePlayer()
    {
        if (ConfigurationManager.getInstance().isReady())
        {
            acquireMediaLicense();
            return;
        } else
        {
            playerConfigUtil.configurePlayerPlatform(new PlayerConfigurationListener() {

                final PreDownloadFlowFragment this$0;

                public void configurationFailed(String s)
                {
                    super.configurationFailed(s);
                    throw new CimException(s);
                }

                public void configurationLoaded()
                {
                    super.configurationLoaded();
                    acquireMediaLicense();
                }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void dismissProgressDialogIfShowing()
    {
        if (progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    private void ensureDeviceRegistration()
    {
        if (((PlayerUserSettings)userManager.getUserSettings()).getDeviceRegistration() == null)
        {
            LOG.debug("No saved registration");
            promptToRegisterDevice();
            return;
        } else
        {
            LOG.debug("Device registration found");
            checkParentalControls();
            return;
        }
    }

    private void ensureRequiredConnectivity()
    {
        if (internetConnection.isConnectedNotOnWiFi() && !((PlayerUserSettings)userManager.getUserSettings()).getUseCellularWhenAvailable())
        {
            LOG.debug("Device currently has download over cellular turned off, asking permission");
            showDialog(new Provider() {

                final PreDownloadFlowFragment this$0;
                final String val$message;

                public CALDialogFragment get()
                {
                    Object obj = new Bundle();
                    ((Bundle) (obj)).putString("title", resources.getString(com.xfinity.playerlib.R.string.content_acquisition_allow_over_cellular_title));
                    ((Bundle) (obj)).putString("description", message);
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
                    caldialogfragment.addArguments(((Bundle) (obj)));
                    obj = new ArrayList();
                    ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.content_acquisition_allow_over_cellular_button), new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            try
                            {
                                downloadsManager.setCellularDataThreshold(-1D);
                            }
                            // Misplaced declaration of an exception variable
                            catch (DialogInterface dialoginterface)
                            {
                                downloadsManager.showCrashDialog(getActivity(), dialoginterface);
                                return;
                            }
                            ((PlayerUserSettings)userManager.getUserSettings()).setUseCellularWhenAvailable(true);
                            fetchVideoEntitlement();
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    }));
                    ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new CancellingClickListener()));
                    caldialogfragment.setButtonList(((List) (obj)));
                    caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                    return caldialogfragment;
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                message = s;
                super();
            }
            }, "ensureRequiredConnectivity");
            return;
        } else
        {
            LOG.debug("Not connected on cellular or cellular is allowed, continuing download flow");
            fetchVideoEntitlement();
            return;
        }
    }

    private void ensureSDCardPresent()
    {
        if (downloadsManager.isExternalStorageConnected())
        {
            ensureRequiredConnectivity();
            return;
        } else
        {
            LOG.debug("Storage unavailable, we cannot download a file without it.");
            showDialog(new Provider() {

                final PreDownloadFlowFragment this$0;

                public CALDialogFragment get()
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", resources.getString(com.xfinity.playerlib.R.string.content_acquisition_storage_error_title));
                    bundle.putString("description", resources.getString(com.xfinity.playerlib.R.string.content_acquisition_storage_error_message));
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlg");
                    caldialogfragment.addArguments(bundle);
                    caldialogfragment.setOnDismissListener(abortFlowDismissListener);
                    caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                    return caldialogfragment;
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
            }, "ensureSDCardPresent");
            return;
        }
    }

    private void fetchHlsAlternateAudio()
    {
        TaskExecutor taskexecutor = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;

            public HlsSimplePlaylist execute()
            {
                return (HlsSimplePlaylist)hlsDownloadClient.downloadHlsFile((new StringBuilder()).append(metaDownloadProfile.getUrlPathPrefix()).append(alternateAudioProfile.getUriString().replace("\"", "")).toString(), new HlsSimplePlaylistParser());
            }

            public volatile Object execute()
            {
                return execute();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        });
        taskexecutor.execute(new DeferWhenPausedTaskExecutionListener(new RetryingExecutionListener(taskexecutor) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(HlsSimplePlaylist hlssimpleplaylist)
            {
                alternateAudioPlaylist = hlssimpleplaylist;
                ensureDeviceRegistration();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((HlsSimplePlaylist)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        }));
    }

    private void fetchHlsSimplePlaylistForMediaProfile(final com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaProfile)
    {
        mediaProfile = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;
            final com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile val$mediaProfile;

            public HlsSimplePlaylist execute()
            {
                return (HlsSimplePlaylist)hlsDownloadClient.downloadHlsFile((new StringBuilder()).append(metaDownloadProfile.getUrlPathPrefix()).append(mediaProfile.getRelativePath()).toString(), new HlsSimplePlaylistParser());
            }

            public volatile Object execute()
            {
                return execute();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                mediaProfile = mediaprofile;
                super();
            }
        });
        mediaProfile.execute(new DeferWhenPausedTaskExecutionListener(new RetryingExecutionListener(mediaProfile) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(HlsSimplePlaylist hlssimpleplaylist)
            {
                if (hlssimpleplaylist.getRelativeSequencePaths() != null && hlssimpleplaylist.getRelativeSequencePaths().size() > 0)
                {
                    profileToDownload = hlssimpleplaylist;
                    if (alternateAudioProfile != null)
                    {
                        fetchHlsAlternateAudio();
                        return;
                    } else
                    {
                        ensureDeviceRegistration();
                        return;
                    }
                } else
                {
                    showDialog(new Provider() {

                        final _cls15 this$1;

                        public CALDialogFragment get()
                        {
                            Object obj = new Bundle();
                            ((Bundle) (obj)).putString("description", getResources().getString(com.xfinity.playerlib.R.string.missing_segments_error));
                            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
                            caldialogfragment.addArguments(((Bundle) (obj)));
                            obj = new ArrayList();
                            ((List) (obj)).add(new CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_try_again), new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    chooseVideoFormat();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }));
                            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new CancellingClickListener()));
                            caldialogfragment.setButtonList(((List) (obj)));
                            caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                            return caldialogfragment;
                        }

                        public volatile Object get()
                        {
                            return get();
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    }, "chooseVideoFormat");
                    return;
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((HlsSimplePlaylist)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        }));
    }

    private void fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(final String hlsVariantPlaylistUrl)
    {
        hlsVariantPlaylistUrl = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;
            final String val$hlsVariantPlaylistUrl;

            public HlsVariantPlaylist execute()
            {
                return (HlsVariantPlaylist)hlsDownloadClient.downloadHlsFile(hlsVariantPlaylistUrl, new HlsVariantPlaylistParser());
            }

            public volatile Object execute()
            {
                return execute();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                hlsVariantPlaylistUrl = s;
                super();
            }
        });
        hlsVariantPlaylistUrl.execute(new DeferWhenPausedTaskExecutionListener(new RetryingExecutionListener(hlsVariantPlaylistUrl) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(HlsVariantPlaylist hlsvariantplaylist)
            {
                Object obj;
                obj = Lists.newArrayList(hlsvariantplaylist.getMediaProfiles());
                Iterator iterator = ((List) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)iterator.next();
                    if (mediaprofile.getWidth() != selectedHalVideoProfile.getWidth() || mediaprofile.getHeight() != selectedHalVideoProfile.getHeight())
                    {
                        LOG.info("Filtering media profile {} as it has a resolution that does match the selected HAL profile", mediaprofile);
                        iterator.remove();
                    }
                } while (true);
                if (((List) (obj)).isEmpty())
                {
                    showDialog(new Provider() {

                        final _cls13 this$1;

                        public CALDialogFragment get()
                        {
                            Object obj = new Bundle();
                            ((Bundle) (obj)).putString("description", getResources().getString(com.xfinity.playerlib.R.string.no_matching_profile_error));
                            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
                            caldialogfragment.addArguments(((Bundle) (obj)));
                            obj = new ArrayList();
                            ((List) (obj)).add(new CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_try_again), new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    chooseVideoFormat();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }));
                            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new CancellingClickListener()));
                            caldialogfragment.setButtonList(((List) (obj)));
                            caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                            return caldialogfragment;
                        }

                        public volatile Object get()
                        {
                            return get();
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    }, "chooseVideoFormat");
                    return;
                }
                Collections.sort(((List) (obj)), PreDownloadFlowFragment.MEDIA_PROFILE_BANDWIDTH_COMPARATOR);
                static class _cls29
                {

                    static final int $SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality[];

                    static 
                    {
                        $SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality = new int[VideoQuality.values().length];
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality[VideoQuality.LOW.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality[VideoQuality.HIGH.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality[VideoQuality.DEFAULT.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls29..SwitchMap.com.xfinity.playerlib.view.programdetails.PreDownloadFlowFragment.VideoQuality[selectedVideoQuality.ordinal()];
                JVM INSTR tableswitch 1 1: default 164
            //                           1 266;
                   goto _L1 _L2
_L1:
                obj = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)((List) (obj)).get(((List) (obj)).size() - 1);
_L6:
                ArrayList arraylist;
                ArrayList arraylist1;
                Iterator iterator1;
                hlsvariantplaylist.setMediaProfiles(CollectionUtils.createList(obj));
                arraylist = Lists.newArrayList();
                arraylist1 = Lists.newArrayList(hlsvariantplaylist.getAudioProfiles());
                iterator1 = arraylist1.iterator();
_L4:
                if (!iterator1.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)iterator1.next();
                if (((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile) (obj)).getAudio() != null && !((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile) (obj)).getAudio().equals(mediaaudioprofile.getGroupId()))
                {
                    iterator1.remove();
                } else
                if (mediaaudioprofile.getUriString() == null)
                {
                    arraylist.add(mediaaudioprofile);
                    iterator1.remove();
                }
                continue; /* Loop/switch isn't completed */
_L2:
                obj = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)((List) (obj)).get(0);
                continue; /* Loop/switch isn't completed */
                if (true) goto _L4; else goto _L3
_L3:
                if (!arraylist1.isEmpty())
                {
                    Collections.sort(arraylist1, PreDownloadFlowFragment.MEDIA_AUDIO_PROFILE_COMPARATOR);
                    alternateAudioProfile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)arraylist1.get(0);
                    arraylist.add(alternateAudioProfile);
                }
                hlsvariantplaylist.setAudioProfiles(arraylist);
                metaDownloadProfile = hlsvariantplaylist;
                fetchHlsSimplePlaylistForMediaProfile(((com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile) (obj)));
                return;
                if (true) goto _L6; else goto _L5
_L5:
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((HlsVariantPlaylist)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        }));
    }

    private void fetchSMILAndExtractSignedManifestUrl()
    {
        reportProgress(resources.getString(com.xfinity.playerlib.R.string.fetching_download_quality_progress));
        TaskExecutor taskexecutor = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;

            public SMILResource execute()
            {
                return thePlatformClient.getSMILResource(selectedHalVideoProfile.getManifestUrl());
            }

            public volatile Object execute()
            {
                return execute();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        });
        taskexecutor.execute(new DeferWhenPausedTaskExecutionListener(new RetryingExecutionListener(taskexecutor) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(SMILResource smilresource)
            {
                manifestUrl = smilresource.getSignedManifestUrl();
                fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(smilresource.getSignedManifestUrl());
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((SMILResource)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        }));
    }

    private void fetchTitaniumTicket()
    {
        LOG.debug("Fetching titanium ticket");
        reportProgress(resources.getString(com.xfinity.playerlib.R.string.acquiring_license_progress_message));
        TaskExecutor taskexecutor = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;

            public TitaniumTicket execute()
            {
                return titaniumTicketClient.getTitaniumTicket(((PlayNowUser)userManager.getUser()).getAuthKeys(), entitlement, selectedHalVideoProfile);
            }

            public volatile Object execute()
            {
                return execute();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        });
        taskexecutor.execute(new DeferWhenPausedTaskExecutionListener(new RetryingExecutionListener(taskexecutor) {

            final PreDownloadFlowFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                if ((taskexecutionexception.getCause() instanceof AmsHttpErrorException) && ((AmsHttpErrorException)(AmsHttpErrorException)taskexecutionexception.getCause()).getDetailedStatusCode() == 2001)
                {
                    LOG.error("Device is not registered, wiping all content and prompting user to register device", taskexecutionexception);
                    ((PlayerUserSettings)userManager.getUserSettings()).setDeviceRegistration(null);
                    try
                    {
                        downloadsManager.deleteAllContent();
                    }
                    // Misplaced declaration of an exception variable
                    catch (TaskExecutionException taskexecutionexception)
                    {
                        LOG.error("Caught exception attempting to delete all content", taskexecutionexception);
                    }
                    promptToRegisterDevice();
                    return;
                } else
                {
                    super.onError(taskexecutionexception);
                    return;
                }
            }

            public void onPostExecute(TitaniumTicket titaniumticket)
            {
                LOG.debug("Fetched titanium ticket");
                titaniumTicket = titaniumticket;
                configurePlayer();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((TitaniumTicket)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        }));
    }

    private void fetchVideoEntitlement()
    {
        LOG.debug("Fetching entitlement");
        reportProgress(resources.getString(com.xfinity.playerlib.R.string.fetching_entitlements_progress_message));
        RetryingExecutionListener retryingexecutionlistener = new RetryingExecutionListener(entitlementProvider) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(VideoEntitlement videoentitlement)
            {
                LOG.debug("Entitlement fetched");
                entitlement = videoentitlement;
                chooseVideoFormat();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((VideoEntitlement)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        };
        entitlementProvider.execute(new DeferWhenPausedTaskExecutionListener(retryingexecutionlistener));
    }

    private boolean pinRequiredForVideo(ParentalControlsSettings parentalcontrolssettings, VideoFacade videofacade)
    {
        return parentalcontrolssettings.getProtectedRatings().contains(videofacade.getVideoRating()) || parentalcontrolssettings.getProtectedNetworkIds().contains(Long.valueOf(videofacade.getNetworkInfo().getNetworkId()));
    }

    private void promptForParentalControlPin(final ParentalControlsPin pin)
    {
        showParentalControlsPinFragment(new Provider() {

            final PreDownloadFlowFragment this$0;
            final ParentalControlsPin val$pin;

            public ParentalControlPinFragment get()
            {
                ParentalControlPinFragment parentalcontrolpinfragment = new ParentalControlPinFragment();
                parentalcontrolpinfragment.setPinValidator(new com.comcast.cim.android.view.common.PinKeypadFragment.PinValidator() {

                    final _cls22 this$1;

                    public void validatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
                    {
                        boolean flag = (new ParentalControlsPin(s)).equals(pin);
                        if (flag)
                        {
                            fetchTitaniumTicket();
                        }
                        pinvalidationcompletedlistener.onPinValidationComplete(flag);
                    }

            
            {
                this$1 = _cls22.this;
                super();
            }
                });
                parentalcontrolpinfragment.setOnCancelListener(abortFlowCancelListener);
                return parentalcontrolpinfragment;
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                pin = parentalcontrolspin;
                super();
            }
        });
    }

    private void promptToRegisterDevice()
    {
        showDialog(new Provider() {

            final PreDownloadFlowFragment this$0;

            public CALDialogFragment get()
            {
                Object obj = new Bundle();
                ((Bundle) (obj)).putString("description", getResources().getString(com.xfinity.playerlib.R.string.registration_dialog_prompt));
                CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
                caldialogfragment.addArguments(((Bundle) (obj)));
                obj = new ArrayList();
                ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_continue), new android.content.DialogInterface.OnClickListener() {

                    final _cls18 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        registerDevice();
                    }

            
            {
                this$1 = _cls18.this;
                super();
            }
                }));
                ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new android.content.DialogInterface.OnClickListener() {

                    final _cls18 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        abortFlow();
                    }

            
            {
                this$1 = _cls18.this;
                super();
            }
                }));
                caldialogfragment.setButtonList(((List) (obj)));
                caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                return caldialogfragment;
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        }, "promptToRegisterDevice");
    }

    private void registerDevice()
    {
        reportProgress(resources.getString(com.xfinity.playerlib.R.string.registering_device_progress_message));
        TaskExecutor taskexecutor = taskExecutorFactory.create(new NonCachingBaseTask() {

            final PreDownloadFlowFragment this$0;

            public DeviceRegistration execute()
            {
                return registerDeviceClient.registerDevice((XipUser)userManager.getUser());
            }

            public volatile Object execute()
            {
                return execute();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        });
        taskexecutor.execute(new RetryingExecutionListener(taskexecutor) {

            final PreDownloadFlowFragment this$0;

            public void onPostExecute(DeviceRegistration deviceregistration)
            {
                ((PlayerUserSettings)userManager.getUserSettings()).setDeviceRegistration(deviceregistration);
                if (isResumed())
                {
                    checkParentalControls();
                    return;
                } else
                {
                    abortFlow();
                    return;
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((DeviceRegistration)obj);
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(taskexecutor);
            }
        });
    }

    private void removeFromFragmentManager()
    {
        FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
        fragmenttransaction.remove(this);
        fragmenttransaction.commitAllowingStateLoss();
    }

    private void reportProgress(String s)
    {
        reportProgress(s, true);
    }

    private void reportProgress(String s, boolean flag)
    {
        if (progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.setMessage(s);
        } else
        {
            progressDialog = ProgressDialog.show(getActivity(), "", s, true);
            progressDialog.setOnCancelListener(abortFlowCancelListener);
        }
        progressDialog.setCancelable(flag);
        progressDialogMessage = s;
    }

    private void setSelectedHalVideoProfileAndProceedToNextStep(HalVideoProfile halvideoprofile, VideoQuality videoquality)
    {
        selectedHalVideoProfile = halvideoprofile;
        selectedVideoQuality = videoquality;
        fetchSMILAndExtractSignedManifestUrl();
    }

    private void showDialog(Provider provider, String s)
    {
        showDialog(provider, s, true);
    }

    private void showDialog(Provider provider, String s, boolean flag)
    {
        if (flag)
        {
            dismissProgressDialogIfShowing();
        }
        LOG.debug("Setting lifecycle manager for dialog {}", s);
        dialogLifecycleManager = new DefaultDialogLifecycleManager(provider, s);
        dialogLifecycleManager.onResume();
    }

    private void showParentalControlsPinFragment(Provider provider)
    {
        dismissProgressDialogIfShowing();
        LOG.debug("Setting lifecycle manager for parental controls pin fragment");
        dialogLifecycleManager = new ParentalControlPinFragmentLifecycleManager(provider);
        dialogLifecycleManager.onResume();
    }

    private void submitDownload()
    {
        reportProgress(resources.getString(com.xfinity.playerlib.R.string.submitting_download_progress_message), false);
        downloadsManager.downloadHlsFileWithWatchable(watchable, video, licenseExpirationDate, profileToDownload, metaDownloadProfile, alternateAudioPlaylist, selectedHalVideoProfile, new FutureCallback() {

            final PreDownloadFlowFragment this$0;

            public void onFailure(Throwable throwable)
            {
                LOG.error("Download submission failed", throwable);
                if (!isResumed())
                {
                    abortFlow();
                    return;
                } else
                {
                    showDialog(throwable. new Provider() {

                        final _cls28 this$1;
                        final Throwable val$t;

                        public CALDialogFragment get()
                        {
                            CALDialogFragment caldialogfragment = errorDialogFactory.createErrorDialogForThrowable(t, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                                final _cls1 this$2;

                                public void tryAgain()
                                {
                                    submitDownload();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            caldialogfragment.setOnCancelListener(abortFlowCancelListener);
                            return caldialogfragment;
                        }

                        public volatile Object get()
                        {
                            return get();
                        }

            
            {
                this$1 = final__pcls28;
                t = Throwable.this;
                super();
            }
                    }, "submitDownload", false);
                    return;
                }
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((Void)obj);
            }

            public void onSuccess(Void void1)
            {
                LOG.debug("Download submitted, completing flow");
                completeFlow();
            }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
        });
    }

    public void abortFlow()
    {
        if (!flowAborted)
        {
            LOG.debug("Flow aborted");
            Toast.makeText(application, application.getString(com.xfinity.playerlib.R.string.download_cancelled_toast), 1).show();
            removeFromFragmentManager();
            flowAborted = true;
        }
    }

    public void completeFlow()
    {
        LOG.debug("Flow completed");
        removeFromFragmentManager();
        flowEventListener.onPreDownloadFlowCompleted(video);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (watchable == null)
        {
            LOG.warn("Prerequisites not found in onCreate, aborting");
            abortFlow();
            return;
        } else
        {
            handler.post(new Runnable() {

                final PreDownloadFlowFragment this$0;

                public void run()
                {
                    ensureSDCardPresent();
                }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        if (progressDialog != null && progressDialog.isShowing())
        {
            shouldShowProgressDialogIfResumed = true;
            progressDialog.dismiss();
        } else
        {
            shouldShowProgressDialogIfResumed = false;
        }
        if (dialogLifecycleManager != null)
        {
            dialogLifecycleManager.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (shouldShowProgressDialogIfResumed)
        {
            reportProgress(progressDialogMessage);
        }
        if (dialogLifecycleManager != null)
        {
            dialogLifecycleManager.onResume();
        }
    }

    public void setFlowEventListener(PreDownloadFlowEventListener predownloadfloweventlistener)
    {
        flowEventListener = predownloadfloweventlistener;
    }










/*
    static String access$1402(PreDownloadFlowFragment predownloadflowfragment, String s)
    {
        predownloadflowfragment.manifestUrl = s;
        return s;
    }

*/









/*
    static VideoEntitlement access$202(PreDownloadFlowFragment predownloadflowfragment, VideoEntitlement videoentitlement)
    {
        predownloadflowfragment.entitlement = videoentitlement;
        return videoentitlement;
    }

*/



/*
    static com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile access$2102(PreDownloadFlowFragment predownloadflowfragment, com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile)
    {
        predownloadflowfragment.alternateAudioProfile = mediaaudioprofile;
        return mediaaudioprofile;
    }

*/



/*
    static HlsVariantPlaylist access$2202(PreDownloadFlowFragment predownloadflowfragment, HlsVariantPlaylist hlsvariantplaylist)
    {
        predownloadflowfragment.metaDownloadProfile = hlsvariantplaylist;
        return hlsvariantplaylist;
    }

*/



/*
    static HlsSimplePlaylist access$2402(PreDownloadFlowFragment predownloadflowfragment, HlsSimplePlaylist hlssimpleplaylist)
    {
        predownloadflowfragment.profileToDownload = hlssimpleplaylist;
        return hlssimpleplaylist;
    }

*/




/*
    static HlsSimplePlaylist access$2702(PreDownloadFlowFragment predownloadflowfragment, HlsSimplePlaylist hlssimpleplaylist)
    {
        predownloadflowfragment.alternateAudioPlaylist = hlssimpleplaylist;
        return hlssimpleplaylist;
    }

*/














/*
    static TitaniumTicket access$3802(PreDownloadFlowFragment predownloadflowfragment, TitaniumTicket titaniumticket)
    {
        predownloadflowfragment.titaniumTicket = titaniumticket;
        return titaniumticket;
    }

*/







/*
    static Date access$4402(PreDownloadFlowFragment predownloadflowfragment, Date date)
    {
        predownloadflowfragment.licenseExpirationDate = date;
        return date;
    }

*/





/*
    static DialogLifecycleManager access$4902(PreDownloadFlowFragment predownloadflowfragment, DialogLifecycleManager dialoglifecyclemanager)
    {
        predownloadflowfragment.dialogLifecycleManager = dialoglifecyclemanager;
        return dialoglifecyclemanager;
    }

*/





}
