// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.ebay.common.util.EnvironmentUtils;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.ServiceStarter;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Experiment;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.shell.app.ActivityShim;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsLong, DcsString, DcsBoolean, DcsInteger

public final class DcsHelper
    implements com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Configuration, LogTrackConfiguration
{
    public static final class KillSwitch extends ActivityShim
    {

        protected void onStart()
        {
            Activity activity = getActivity();
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            if (deviceconfiguration.get(DcsBoolean.KillSwitch) || !deviceconfiguration.get(DcsBoolean.Polling))
            {
                ServiceStarter.startPollService(activity, "com.ebay.mobile.service.DISABLE_POLLING");
            }
            if (deviceconfiguration.get(DcsBoolean.KillSwitch))
            {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
                builder.setMessage(activity.getString(0x7f07014a)).setCancelable(false).setPositiveButton(activity.getString(0x7f070b94), activity. new android.content.DialogInterface.OnClickListener() {

                    final KillSwitch this$0;
                    final Activity val$activity;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = new Intent("android.intent.action.VIEW");
                        dialoginterface.setData(Uri.parse("market://details?id=com.ebay.mobile"));
                        dialoginterface.addFlags(0x10800000);
                        activity.startActivity(dialoginterface);
                        activity.finish();
                    }

            
            {
                this$0 = final_killswitch;
                activity = Activity.this;
                super();
            }
                }).setNegativeButton(activity.getString(0x7f0701cc), activity. new android.content.DialogInterface.OnClickListener() {

                    final KillSwitch this$0;
                    final Activity val$activity;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        activity.finish();
                    }

            
            {
                this$0 = final_killswitch;
                activity = Activity.this;
                super();
            }
                }).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

                    final KillSwitch this$0;

                    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
                    {
                        return i == 84 && keyevent.getRepeatCount() == 0;
                    }

            
            {
                this$0 = KillSwitch.this;
                super();
            }
                });
                builder.create().show();
            }
        }

        public KillSwitch()
        {
        }
    }


    private static final boolean IS_THIS_AN_EMULATOR;
    private static final Object LOCK = new Object();
    private static volatile Boolean _isConfiguredToShowMaps;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static volatile int googlePlayServicesResult;
    private static volatile boolean isOpenGlEs2_0_Available;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private volatile DeviceConfiguration config;
    private final Context context;

    public DcsHelper(Context context1)
    {
        context = context1;
        config = DeviceConfiguration.getNoSync();
    }

    private List CsvToList(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = Collections.emptyList();
_L4:
        return s;
_L2:
        String as[] = s.split(",");
        ArrayList arraylist = new ArrayList();
        int j = as.length;
        int i = 0;
        do
        {
            s = arraylist;
            if (i >= j)
            {
                continue;
            }
            s = as[i].trim();
            if (!TextUtils.isEmpty(s))
            {
                arraylist.add(s);
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String getLanguageBase()
    {
        String s1 = Locale.getDefault().getLanguage();
        String s = s1;
        if (s1.length() > 2)
        {
            s = s1.substring(0, 2);
        }
        return s;
    }

    private boolean isDeviceConfiguredToShowMaps()
    {
        boolean flag2 = true;
        if (_isConfiguredToShowMaps != null) goto _L2; else goto _L1
_L1:
        Object obj = LOCK;
        obj;
        JVM INSTR monitorenter ;
        if (_isConfiguredToShowMaps != null) goto _L4; else goto _L3
_L3:
        googlePlayServicesResult = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        boolean flag;
        boolean flag1;
        if (googlePlayServicesResult == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isOpenGlEs2_0_Available = flag1;
        if (IS_THIS_AN_EMULATOR || !flag) goto _L6; else goto _L5
_L5:
        if (!isOpenGlEs2_0_Available) goto _L6; else goto _L7
_L7:
        flag1 = flag2;
_L9:
        _isConfiguredToShowMaps = Boolean.valueOf(flag1);
_L4:
        obj;
        JVM INSTR monitorexit ;
_L2:
        return _isConfiguredToShowMaps.booleanValue();
_L6:
        flag1 = false;
        if (true) goto _L9; else goto _L8
_L8:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean isSiteInList(String s, DcsPropString dcspropstring)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        dcspropstring = config.get(dcspropstring);
        flag = flag1;
        if (dcspropstring == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        dcspropstring = dcspropstring.split(",");
        j = dcspropstring.length;
        i = 0;
_L7:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L3
_L3:
        if (!dcspropstring[i].trim().equalsIgnoreCase(s)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public long aplsTrafficInterval()
    {
        return config.get(DcsLong.TrafficMonitorSendInterval);
    }

    public String buyerProtectionUrl()
    {
        return buyerProtectionUrl(false);
    }

    public String buyerProtectionUrl(boolean flag)
    {
        String s = null;
        if (flag)
        {
            s = config.get(com.ebay.nautilus.domain.dcs.DcsDomain.ViewItem.S.proofPointsUrlFormat);
        }
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = config.get(Dcs.App.S.eBayBuyerProtectionUrlFormat);
        }
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        String s2 = getLanguageBase();
        s = s2;
        if (!Arrays.asList(new String[] {
    "en", "es", "fr", "de", "it"
}).contains(s2))
        {
            s = config.getState().site.localeLanguage;
        }
        return String.format(s1, new Object[] {
            s
        });
    }

    public String categoryImageType()
    {
        return config.get(DcsString.DCSCategoryBrowseAssetType);
    }

    public String categoryImageUrlPath()
    {
        return config.get(DcsString.categoryBrowseAssetHostURL);
    }

    public String dealsUrl()
    {
        String s = config.get(DcsString.DealsUrl);
        return EbayCountryManager.addMobileWebParams(context, s);
    }

    public String feedUrl()
    {
        String s = config.get(DcsString.FeedUrl);
        return EbayCountryManager.addMobileWebParams(context, s);
    }

    public String forgotPasswordUrl()
    {
        return EbayCountryManager.addResponsiveFlowParams(config.get(DcsString.ForgotPasswordUrl));
    }

    public String fpaRegistrationUrl()
    {
        return EbayCountryManager.addResponsiveFlowParams(config.get(DcsString.BuyerRegistrationFpaUrl));
    }

    public List getAppsTrackingPrefixes()
    {
        String s;
        if (config.get(DcsBoolean.iApps))
        {
            if ((s = config.get(DcsString.iAppsList)) != null)
            {
                return CsvToList(s);
            }
        }
        return null;
    }

    public DeviceConfiguration getConfig()
    {
        return config;
    }

    public String getConfigVersion()
    {
        return config.getConfigVersion();
    }

    public String getDeviceMapsState()
    {
        Object obj = "Device configured to support ISPU/PUDO";
        if (!isDeviceConfiguredToShowMaps())
        {
            obj = new StringBuilder("Device NOT configured to support ISPU/PUDO");
            ((StringBuilder) (obj)).append("\nReason(s):");
            if (IS_THIS_AN_EMULATOR)
            {
                ((StringBuilder) (obj)).append("\nEmulators are not supported");
            }
            if (!isOpenGlEs2_0_Available)
            {
                ((StringBuilder) (obj)).append("\nDevice doesn't support Open GL ES 2.0 or higher");
            }
            if (googlePlayServicesResult != 0)
            {
                ((StringBuilder) (obj)).append((new StringBuilder()).append("\nGoogle Play Services: ").append(GooglePlayServicesUtil.getErrorString(googlePlayServicesResult)).toString());
            }
            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

    public String getEpChannelId()
    {
        return config.get(DcsString.EpChannelId);
    }

    public String getEpDefaultOverride(Experiment experiment)
    {
        return config.get(experiment);
    }

    public List getEpExperimentBlacklist()
    {
        return CsvToList(config.get(DcsString.MepClientBlacklistExperimentName));
    }

    public List getEpTreatmentBlacklist()
    {
        return CsvToList(config.get(DcsString.MepClientBlacklistTreatmentName));
    }

    public int getExperimentationQualificationPeriodSeconds()
    {
        return Math.min(0x278d00, Math.max(1800, config.get(DcsInteger.MepQualificationPeriodSeconds)));
    }

    public List getFollowNotificationTypes()
    {
        Object obj = CsvToList(config.get(DcsString.searchFollowNotificationToggleTypes));
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            try
            {
                arraylist.add(com.ebay.common.model.followinterest.FollowDescriptor.NotificationEnum.valueOf(s));
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                if (debugLogger.isLoggable)
                {
                    debugLogger.log((new StringBuilder()).append("Invalid value in DCS searchFollowNotificationToggleTypes: ").append(s).toString());
                }
            }
        } while (true);
        return arraylist;
    }

    public String getGalleryImageHost()
    {
        String s1 = config.get(DcsNautilusString.ThumbnailHost);
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = null;
        }
        return s;
    }

    public int getRolloutThreshold()
    {
        return config.getState().rolloutThreshold;
    }

    public int getSearchPageSize(Resources resources)
    {
        if (resources.getBoolean(0x7f0b0006))
        {
            return config.get(DcsInteger.SearchTabletPageSize);
        } else
        {
            return config.get(DcsInteger.SearchPhonePageSize);
        }
    }

    public Set getShoppingCartExcludedItemCategories()
    {
        String s = config.get(DcsString.ShoppingCartExcludedItemCategories);
        HashSet hashset = new HashSet();
        String as[] = s.split(",");
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            hashset.add(as[i].trim());
        }

        return hashset;
    }

    public List getWebviewLandingDomainWhitelist()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = CsvToList(config.get(DcsString.WebviewLandingDomainWhitelist));
        Locale locale = Locale.getDefault();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((String)((Iterator) (obj)).next()).toLowerCase(locale))) { }
        for (Iterator iterator = EbaySite.getAvailableInstances().iterator(); iterator.hasNext(); arraylist.add(((EbaySite)iterator.next()).getDomain().toLowerCase(locale))) { }
        return arraylist;
    }

    public boolean isAfterSalesEnabled()
    {
        return config.get(DcsBoolean.PostTransactionWebFlow) && !config.getState().isGbh;
    }

    public boolean isAlternativePaymentMethodsAvailable()
    {
        return config.get(DcsBoolean.MecAlternativePaymentMethods) && config.get(DcsBoolean.MEC2);
    }

    public boolean isAplsImageLoadingTraffic()
    {
        return config.get(DcsBoolean.TrafficMonitorRecordImageLoads);
    }

    public boolean isAplsLogErrorMessage()
    {
        return config.get(DcsBoolean.AplsLogErrorMessagesWithV2);
    }

    public boolean isAplsLogErrorMessageV1()
    {
        if (isAplsLogErrorMessage())
        {
            return false;
        } else
        {
            return config.get(DcsBoolean.AplsLogErrorMessages);
        }
    }

    public boolean isAplsSendRlogId()
    {
        return config.get(DcsBoolean.soaSendRlogId);
    }

    public boolean isAplsTraffic()
    {
        return config.get(DcsBoolean.TrafficMonitorSendData);
    }

    public boolean isBopisEnabled()
    {
        boolean flag = config.get(DcsBoolean.BOPIS);
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("Bopis enabled in DCS: ").append(flag).toString());
        }
        if (flag && isDeviceConfiguredToShowMaps())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("Bopis is available: ").append(flag).toString());
        }
        return flag;
    }

    public boolean isExperimentationDisabled()
    {
        return config.get(DcsBoolean.MepClientDisable);
    }

    public boolean isItemTitleTranslationEnabled()
    {
        return config.get(DcsBoolean.itemTitleTranslationEnabled);
    }

    public boolean isLockedPortraitOnPhone(Resources resources)
    {
        if (resources.getBoolean(0x7f0b0006))
        {
            return false;
        } else
        {
            return config.get(Dcs.Verticals.B.lockedPortraitOnPhone);
        }
    }

    public boolean isMECAddressValidationEnabledForCountry(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("isoCountryCode");
        }
        String s1;
        if (config.get(DcsBoolean.MecAddressValidation))
        {
            if (!TextUtils.isEmpty(s1 = config.get(DcsString.MecAddressValidationCountries)))
            {
                return s1.contains(s);
            }
        }
        return false;
    }

    public boolean isMaintenanceWindow()
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        String s = config.get(DcsString.MAINTENANCE_WINDOW);
        boolean flag = flag1;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String as[] = s.split(",");
        flag = flag1;
        if (as.length != 3) goto _L2; else goto _L3
_L3:
        GregorianCalendar gregoriancalendar;
        int i;
        gregoriancalendar = new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles"));
        gregoriancalendar.setTimeInMillis(System.currentTimeMillis());
        i = Integer.parseInt(as[0]);
        flag = flag1;
        if (gregoriancalendar.get(7) < i) goto _L2; else goto _L4
_L4:
        Calendar calendar;
        calendar = (Calendar)gregoriancalendar.clone();
        calendar.add(7, gregoriancalendar.get(7) - i);
        flag = flag2;
        if (as[1].length() != 4) goto _L6; else goto _L5
_L5:
        Calendar calendar1;
        int j = Integer.parseInt(as[1].substring(0, 2));
        int k = Integer.parseInt(as[1].substring(2));
        calendar.set(11, j);
        calendar.set(12, k);
        calendar1 = (Calendar)calendar.clone();
        calendar1.add(12, Integer.parseInt(as[2]));
        flag = flag1;
        if (gregoriancalendar.getTime().getTime() < calendar.getTime().getTime()) goto _L2; else goto _L7
_L7:
        long l;
        long l1;
        l = gregoriancalendar.getTime().getTime();
        l1 = calendar1.getTime().getTime();
        flag = flag1;
        if (l < l1)
        {
            flag = true;
        }
_L2:
        if (verboseLogger.isLoggable)
        {
            com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = verboseLogger;
            StringBuilder stringbuilder = (new StringBuilder()).append("Maintenance Window is ");
            Object obj;
            if (flag)
            {
                obj = "open";
            } else
            {
                obj = "closed";
            }
            loginfo.log(stringbuilder.append(((String) (obj))).toString());
        }
_L6:
        return flag;
        obj;
        flag = flag1;
        if (debugLogger.isLoggable)
        {
            debugLogger.logAsError("isMaintenanceWindow exception", ((Throwable) (obj)));
            flag = flag1;
        }
          goto _L2
    }

    public boolean isMec2Enabled(String s)
    {
        return config.get(DcsBoolean.MEC2) && (TextUtils.isEmpty(s) || isSiteInList(s, DcsString.MEC2_LIST));
    }

    public boolean isMecEnabled(String s)
    {
        return config.get(DcsBoolean.MEC) && (TextUtils.isEmpty(s) || isSiteInList(s, DcsString.MEC_LIST));
    }

    public boolean isMecOrMec2Enabled(String s)
    {
        boolean flag = isMecEnabled(s);
        return isMec2Enabled(s) || flag;
    }

    public boolean isMotorsCommunityEnabled()
    {
        return isMotorsEnabled() && config.get(DcsBoolean.MotorsCommunity);
    }

    public boolean isMotorsEnabled()
    {
        if (!com.ebay.common.view.util.EbayCountryManager.Default.supportsMotors(config.getState().ebayCountry))
        {
            return false;
        } else
        {
            return config.get(DcsBoolean.Motors);
        }
    }

    public boolean isMotorsEventsEnabled()
    {
        return isMotorsEnabled() && config.get(DcsBoolean.MotorsEvents);
    }

    public boolean isMotorsRtmEnabled()
    {
        DcsState dcsstate = config.getState();
        return isMotorsEnabled() && isRTMEnabled() && Locale.getDefault().getLanguage().equals(dcsstate.site.localeLanguage);
    }

    public boolean isMotorsSellingEnabled()
    {
        return isMotorsEnabled() && config.get(DcsBoolean.MotorsSell);
    }

    public boolean isMotorsVideosEnabled()
    {
        return isMotorsEnabled() && config.get(DcsBoolean.MotorsVideos);
    }

    public boolean isMotorsVisualSearchEnabled()
    {
        return false;
    }

    public boolean isPaisaPayEnabled(String s)
    {
        return config.get(DcsBoolean.PaisaPay) && (TextUtils.isEmpty(s) || isSiteInList(s, DcsString.PaisaPayList)) && config.get(DcsBoolean.SSO);
    }

    public boolean isPudoEnabled()
    {
        boolean flag = config.get(DcsNautilusBoolean.PUDO);
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("PUDO enabled in DCS: ").append(flag).toString());
        }
        if (flag && isDeviceConfiguredToShowMaps())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("PUDO is available: ").append(flag).toString());
        }
        return flag;
    }

    public boolean isRTMEnabled()
    {
        if (EnvironmentUtils.isBlackberry())
        {
            return false;
        } else
        {
            return config.get(DcsBoolean.RTM);
        }
    }

    public boolean isRequestErrorReportingEnabled()
    {
        return config.get(DcsBoolean.LOG_REQUEST_ERRORS);
    }

    public boolean isSellingEnabled()
    {
        return config.getDefault(DcsBoolean.Sell) && config.get(DcsBoolean.Sell);
    }

    public boolean isShoppingCartEnabled()
    {
        return config.get(DcsBoolean.ShoppingCart);
    }

    public boolean isTopRatedSellerEnabled()
    {
        return config.get(DcsBoolean.TopRatedSeller3) || config.get(DcsBoolean.TopRatedSeller1);
    }

    public boolean isVIPBuyBarOverridCartControlsDisabled()
    {
        return TextUtils.equals(config.get(DcsString.viewItemBuyBarOverride), "DisableCartControls");
    }

    public boolean isVIPBuyBarOverrideEnabled()
    {
        return !TextUtils.isEmpty(config.get(DcsString.viewItemBuyBarOverride));
    }

    public boolean isVIPBuyBarOverridePayForItemEnabled()
    {
        return TextUtils.equals(config.get(DcsString.viewItemBuyBarOverride), "EnablePayForItem");
    }

    public String ocsUrl()
    {
        String s1 = config.get(Dcs.Connect.S.ocsUrl);
        String s = s1;
        if (s1 != null)
        {
            s = Uri.parse(s1).buildUpon().appendQueryParameter("srcAppId", "2571").appendQueryParameter("appVer", NautilusKernel.getAppVersionName(context)).build().toString();
        }
        return s;
    }

    public String ppaRegistrationUrl()
    {
        return EbayCountryManager.addResponsiveFlowParams(config.get(DcsString.BuyerRegistrationPpaUrl));
    }

    public String ppaUpgradeUrl()
    {
        return EbayCountryManager.addResponsiveFlowParams(config.get(DcsString.PpaUpgradeUrl));
    }

    public void refresh()
    {
        if (verboseLogger.isLoggable)
        {
            verboseLogger.log("refresh() called.");
        }
        config = DeviceConfiguration.getAsync();
    }

    public String sellerRegistrationUrl()
    {
        String s = config.get(DcsString.SellerRegistrationUrl);
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return Uri.parse(s).buildUpon().appendQueryParameter("clientapptype", "12").toString();
        }
    }

    public String topRatedSeller3Url()
    {
        String s = config.get(DcsString.TopRatedSeller3Url);
        String s1 = getLanguageBase();
        try
        {
            s1 = String.format(s, new Object[] {
                s1
            });
        }
        catch (NullPointerException nullpointerexception)
        {
            return s;
        }
        catch (IllegalFormatException illegalformatexception)
        {
            return s;
        }
        return s1;
    }

    public String topRatedSeller3XOUrl()
    {
        String s = config.get(DcsString.TopRatedSeller3XOUrl);
        String s1 = getLanguageBase();
        try
        {
            s1 = String.format(s, new Object[] {
                s1
            });
        }
        catch (NullPointerException nullpointerexception)
        {
            return s;
        }
        catch (IllegalFormatException illegalformatexception)
        {
            return s;
        }
        return s1;
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("DeviceConfig", 3, "Log DeviceConfiguration events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended DeviceConfiguration events");
        boolean flag;
        if ("sdk".equals(Build.MODEL) || "google_sdk".equals(Build.MODEL))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IS_THIS_AN_EMULATOR = flag;
    }
}
