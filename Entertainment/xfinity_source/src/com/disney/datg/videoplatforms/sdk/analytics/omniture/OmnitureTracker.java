// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics.omniture;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adobe.adms.measurement.ADMS_Measurement;
import com.disney.datg.videoplatforms.sdk.analytics.IAdTracker;
import com.disney.datg.videoplatforms.sdk.analytics.IAppTracker;
import com.disney.datg.videoplatforms.sdk.analytics.IAuthZTracker;
import com.disney.datg.videoplatforms.sdk.analytics.ILinkTracker;
import com.disney.datg.videoplatforms.sdk.analytics.IMediaTracker;
import com.disney.datg.videoplatforms.sdk.analytics.ITrackable;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.media.Configuration;
import com.disney.datg.videoplatforms.sdk.media.VPGeolocation;
import com.disney.datg.videoplatforms.sdk.media.VPMedia;
import com.disney.datg.videoplatforms.sdk.media.VPVideo;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliate;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliates;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.models.api.User;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.CookieEnabledHttpRequestFactory;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

public class OmnitureTracker
    implements IAdTracker, IAppTracker, IAuthZTracker, ILinkTracker, IMediaTracker
{

    private Activity activity;
    private Configuration configuration;

    public OmnitureTracker(Activity activity1, Configuration configuration1)
        throws Exception
    {
        ADMS_Measurement adms_measurement = ADMS_Measurement.sharedInstance();
        if (configuration1 != null && configuration1.getCurrentConfig() != null)
        {
            setConfiguration(configuration1);
            activity = activity1;
            activity1 = configuration1.getCurrentConfig().getParamInFeatureId("account", "FEAT0015");
            configuration1 = configuration1.getCurrentConfig().getParamInFeatureId("trackingServer", "FEAT0015");
            if (!TextUtils.isEmpty(activity1) && !TextUtils.isEmpty(configuration1))
            {
                adms_measurement.configureMeasurement(activity1, configuration1);
            }
            return;
        } else
        {
            throw new Exception("configuration cannot be null");
        }
    }

    private static String makeOmnitureStringFormat(String s)
    {
        return s.toLowerCase(Locale.US).trim().replaceAll("[ ]", "-").replaceAll("[^a-z0-9-]", "");
    }

    private void populate(ADMS_Measurement adms_measurement, ITrackable itrackable)
    {
        if (itrackable.getEvars() != null)
        {
            for (int i = 0; i < itrackable.getEvars().size(); i++)
            {
                adms_measurement.setEvar(Integer.parseInt(((BasicNameValuePair)itrackable.getEvars().get(i)).getName()), ((BasicNameValuePair)itrackable.getEvars().get(i)).getValue());
            }

        }
        if (itrackable.getProps() != null)
        {
            for (int j = 0; j < itrackable.getProps().size(); j++)
            {
                adms_measurement.setProp(Integer.parseInt(((BasicNameValuePair)itrackable.getProps().get(j)).getName()), ((BasicNameValuePair)itrackable.getProps().get(j)).getValue());
            }

        }
        StringBuilder stringbuilder = new StringBuilder();
        if (itrackable.getEvents() != null)
        {
            for (int k = 0; k < itrackable.getEvents().size(); k++)
            {
                if (k > 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append((String)itrackable.getEvents().get(k));
            }

        }
        if (itrackable.getContextData().containsKey("channel"))
        {
            adms_measurement.setChannel(activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_channel).replace("%DEVICE_MODEL%", Build.MODEL));
        }
        if (itrackable.getContextData().containsKey("pageName"))
        {
            adms_measurement.setAppState(itrackable.getContextData().get("pageName").toString());
        }
        Object obj = null;
        Object obj1 = obj;
        String s1;
        Activity activity1;
        try
        {
            if (VPGeolocation.getGeolocationManager().getCurrentGeolocation() != null)
            {
                obj1 = VPGeolocation.getGeolocationManager().getCurrentGeolocation();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            LogUtils.LOGD("OmnitureTracker", ((AndroidSDKException) (obj1)).getMessage());
            obj1 = obj;
        }
        s1 = "phone";
        activity1 = activity;
        obj = s1;
        if (activity1 != null)
        {
            obj = s1;
            if (((TelephonyManager)activity1.getSystemService("phone")).getPhoneType() == 0)
            {
                obj = "tablet";
            }
        }
        adms_measurement.setProp(1, ((String) (obj)));
        adms_measurement.setEvar(2, ((String) (obj)));
        if (CookieEnabledHttpRequestFactory.getSWID() != null && !"".equals(CookieEnabledHttpRequestFactory.getSWID()))
        {
            adms_measurement.setProp(2, CookieEnabledHttpRequestFactory.getSWID());
            adms_measurement.setEvar(2, CookieEnabledHttpRequestFactory.getSWID());
        } else
        {
            adms_measurement.setProp(2, "None");
            adms_measurement.setEvar(2, "None");
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("currentMVPDId") != null)
        {
            obj = (String)itrackable.getContextData().get("currentMVPDId");
            Object obj2;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                adms_measurement.setProp(3, ((String) (obj)));
                adms_measurement.setEvar(3, ((String) (obj)));
            } else
            {
                adms_measurement.setProp(3, "None");
                adms_measurement.setEvar(3, "None");
            }
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("currentMVPDGUID") != null)
        {
            obj = (String)itrackable.getContextData().get("currentMVPDGUID");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                adms_measurement.setProp(4, ((String) (obj)));
                adms_measurement.setEvar(4, ((String) (obj)));
            } else
            {
                adms_measurement.setProp(4, "None");
                adms_measurement.setEvar(4, "None");
            }
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("adobePassOS") != null)
        {
            obj = (String)itrackable.getContextData().get("adobePassOS");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                adms_measurement.setProp(5, ((String) (obj)));
                adms_measurement.setEvar(5, ((String) (obj)));
            } else
            {
                adms_measurement.setProp(5, "None");
                adms_measurement.setEvar(5, "None");
            }
        }
        adms_measurement.setProp(6, "None");
        adms_measurement.setEvar(6, "None");
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("authenticated") != null)
        {
            if (((Boolean)itrackable.getContextData().get("authenticated")).booleanValue())
            {
                adms_measurement.setProp(8, "true");
                adms_measurement.setEvar(8, "true");
            } else
            {
                adms_measurement.setProp(8, "false");
                adms_measurement.setEvar(8, "false");
            }
        }
        itrackable = "";
        obj = itrackable;
        if (obj1 != null)
        {
            obj2 = ((GeoLocation) (obj1)).getAffiliates();
            obj = itrackable;
            if (obj2 != null)
            {
                obj = itrackable;
                if (((Affiliates) (obj2)).getAffiliates().size() > 0)
                {
                    obj = ((Affiliates) (obj2)).getAffiliates().iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        obj2 = (Affiliate)((Iterator) (obj)).next();
                        if (obj2 != null && !TextUtils.isEmpty(((Affiliate) (obj2)).getId()))
                        {
                            itrackable = (new StringBuilder()).append(itrackable).append(((Affiliate) (obj2)).getId()).append(",").toString();
                        }
                    } while (true);
                    obj = itrackable;
                    if (!TextUtils.isEmpty(itrackable))
                    {
                        obj = itrackable.substring(0, itrackable.length() - 1);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            adms_measurement.setProp(7, ((String) (obj)));
            adms_measurement.setEvar(7, ((String) (obj)));
        } else
        {
            adms_measurement.setProp(7, "None");
            adms_measurement.setEvar(7, "None");
        }
        adms_measurement.setProp(13, Build.DISPLAY);
        adms_measurement.setEvar(13, Build.DISPLAY);
        adms_measurement.setProp(13, android.os.Build.VERSION.RELEASE);
        adms_measurement.setEvar(13, android.os.Build.VERSION.RELEASE);
        adms_measurement.setProp(14, "None");
        adms_measurement.setEvar(14, "None");
        itrackable = null;
        if (obj1 != null)
        {
            itrackable = ((GeoLocation) (obj1)).getUser();
        }
        if (itrackable != null)
        {
            String s;
            PackageManager packagemanager;
            String s2;
            if (itrackable.getProxy() != null && !"".equals(itrackable.getProxy()))
            {
                adms_measurement.setProp(15, itrackable.getProxy());
                adms_measurement.setEvar(15, itrackable.getProxy());
            } else
            {
                adms_measurement.setProp(15, "None");
                adms_measurement.setEvar(15, "None");
            }
            if (itrackable.getAllowed().booleanValue())
            {
                adms_measurement.setProp(16, "true");
                adms_measurement.setEvar(16, "true");
            } else
            {
                adms_measurement.setProp(16, "false");
                adms_measurement.setEvar(16, "false");
            }
            if (itrackable.getCity() != null && !"".equals(itrackable.getCity()))
            {
                adms_measurement.setProp(17, itrackable.getCity());
                adms_measurement.setEvar(17, itrackable.getCity());
            } else
            {
                adms_measurement.setProp(17, "None");
                adms_measurement.setEvar(17, "None");
            }
            if (itrackable.getState() != null && !"".equals(itrackable.getState()))
            {
                adms_measurement.setProp(18, itrackable.getState());
                adms_measurement.setEvar(18, itrackable.getState());
            } else
            {
                adms_measurement.setProp(18, "None");
                adms_measurement.setEvar(18, "None");
            }
            if (itrackable.getCountry() != null && !"".equals(itrackable.getCountry()))
            {
                adms_measurement.setProp(19, itrackable.getCountry());
                adms_measurement.setEvar(19, itrackable.getCountry());
            } else
            {
                adms_measurement.setProp(19, "None");
                adms_measurement.setEvar(19, "None");
            }
        }
        itrackable = activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop25).replace("%DEVICE_MODEL%", Build.MODEL);
        adms_measurement.setProp(25, itrackable);
        adms_measurement.setEvar(25, itrackable);
        adms_measurement.setProp(26, activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop26));
        adms_measurement.setEvar(26, activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop26));
        adms_measurement.setProp(31, System.getProperty("http.agent"));
        adms_measurement.setEvar(31, System.getProperty("http.agent"));
        adms_measurement.setProp(52, activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop52));
        adms_measurement.setEvar(52, activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop52));
        packagemanager = activity.getPackageManager();
        s2 = activity.getPackageName();
        obj1 = null;
        s = "";
        itrackable = ((ITrackable) (obj1));
        if (packagemanager != null)
        {
            itrackable = ((ITrackable) (obj1));
            if (!TextUtils.isEmpty(s2))
            {
                try
                {
                    itrackable = packagemanager.getPackageInfo(s2, 0);
                }
                // Misplaced declaration of an exception variable
                catch (ITrackable itrackable)
                {
                    LogUtils.logException(itrackable);
                    itrackable = ((ITrackable) (obj1));
                }
            }
        }
        if (itrackable != null)
        {
            s = ((PackageInfo) (itrackable)).versionName;
        }
        adms_measurement.setProp(64, s);
        adms_measurement.setEvar(64, s);
        adms_measurement.setEvents(stringbuilder.toString());
    }

    private void populateVideoTags(ITrackable itrackable)
    {
        String s;
        String s1;
        String s2;
        Object obj;
        String s3;
        String s9;
        String s10;
        String s11;
        String s12;
        String s13;
        String s14;
        String s15;
        s = "None";
        s2 = "None";
        s15 = "None";
        s14 = "None";
        s13 = "None";
        s12 = "None";
        s9 = "None";
        s1 = "None";
        s11 = "None";
        s10 = "None";
        s3 = "N/A";
        Object obj1 = null;
        obj = obj1;
        if (itrackable != null)
        {
            obj = obj1;
            if (itrackable.getContextData() != null)
            {
                obj = obj1;
                if (itrackable.getContextData().get("activity") != null)
                {
                    Object obj2 = itrackable.getContextData().get("activity");
                    obj = obj2;
                    if (obj2 instanceof Fragment)
                    {
                        obj = ((Fragment)obj2).getActivity();
                    }
                    obj = (Activity)obj;
                }
            }
        }
        if (obj != null)
        {
            String s4 = ((Activity) (obj)).getApplication().getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop53);
            itrackable.addProp(53, s4);
            itrackable.addEvar(53, s4);
            s4 = ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop54);
            itrackable.addProp(54, s4);
            itrackable.addEvar(54, s4);
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("uplynkSessionID") != null && !TextUtils.isEmpty((String)itrackable.getContextData().get("uplynkSessionID")))
        {
            itrackable.addProp(57, "None");
            itrackable.addEvar(57, "None");
        }
        itrackable.addProp(62, "None");
        itrackable.addEvar(62, "None");
        if (obj != null)
        {
            s3 = ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prop63);
            itrackable.addProp(63, s3);
            itrackable.addEvar(63, s3);
        }
        if (itrackable == null || itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null) goto _L2; else goto _L1
_L1:
        Object obj4 = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (obj4 == null) goto _L2; else goto _L3
_L3:
        static class _cls1
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow = new int[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.FREE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.MARKET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.SUBSCRIPTION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType = new int[com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType.VOD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType.LIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow[((VPMedia) (obj4)).getAccessWindow().ordinal()];
        JVM INSTR tableswitch 1 3: default 444
    //                   1 1288
    //                   2 1288
    //                   3 1313;
           goto _L4 _L5 _L5 _L6
_L4:
        String s16 = ((VPMedia) (obj4)).getMediaType().getTypes();
        itrackable.addProp(36, s16);
        itrackable.addEvar(36, s16);
        String s6 = s10;
        Object obj3 = obj4;
        String s7 = s;
        String s5 = s2;
        String s8 = s1;
        if (obj4 instanceof VPVideo)
        {
            obj4 = (VPVideo)obj4;
            s5 = s15;
            if (!TextUtils.isEmpty(((VPVideo)obj4).getAirDate()))
            {
                s5 = ((VPVideo)obj4).getAirDate();
            }
            itrackable.addProp(43, s5);
            itrackable.addEvar(43, s5);
            s5 = s14;
            if (!TextUtils.isEmpty(((VPVideo)obj4).getExpireDate()))
            {
                s5 = ((VPVideo)obj4).getExpireDate();
            }
            itrackable.addProp(44, s5);
            itrackable.addEvar(44, s5);
            int i = (int)((VPVideo)obj4).getDuration() / 1000;
            s5 = (new StringBuilder()).append("").append(i).toString();
            itrackable.addProp(45, s5);
            itrackable.addEvar(45, s5);
            s5 = s13;
            if (!TextUtils.isEmpty(((VPVideo)obj4).getEpisodeNumber()))
            {
                s5 = ((VPVideo)obj4).getEpisodeNumber();
            }
            itrackable.addProp(46, s5);
            itrackable.addEvar(46, s5);
            s5 = s12;
            if (!TextUtils.isEmpty(((VPVideo)obj4).getAvailableDate()))
            {
                s5 = ((VPVideo)obj4).getAvailableDate();
            }
            itrackable.addProp(47, s5);
            itrackable.addEvar(47, s5);
            s5 = s11;
            if (!TextUtils.isEmpty(((VPVideo)obj4).getSeasonNumber()))
            {
                s5 = ((VPVideo)obj4).getSeasonNumber();
            }
            itrackable.addProp(55, s5);
            itrackable.addEvar(55, s5);
            if (!TextUtils.isEmpty(((VPVideo)obj4).getDayPart()))
            {
                s = ((VPVideo)obj4).getDayPart();
            }
            itrackable.addProp(37, s);
            itrackable.addEvar(37, s);
            if (!TextUtils.isEmpty(((VPVideo)obj4).getCGenre()))
            {
                s1 = ((VPVideo)obj4).getCGenre();
            }
            itrackable.addProp(51, s1);
            itrackable.addEvar(51, s1);
            if (!TextUtils.isEmpty(((VPVideo)obj4).getCShowName()))
            {
                s2 = ((VPVideo)obj4).getCShowName();
            }
            itrackable.addProp(56, s2);
            itrackable.addEvar(56, s2);
            s6 = s10;
            obj3 = obj4;
            s7 = s;
            s5 = s2;
            s8 = s1;
            if (!TextUtils.isEmpty(((VPVideo)obj4).getCVideo()))
            {
                s6 = ((VPVideo)obj4).getCVideo();
                s8 = s1;
                s5 = s2;
                s7 = s;
                obj3 = obj4;
            }
        }
        s = s9;
        if (!TextUtils.isEmpty(((VPMedia) (obj3)).getMediaTitle()))
        {
            s = makeOmnitureStringFormat(((VPMedia) (obj3)).getMediaTitle());
        }
        itrackable.addProp(48, s);
        itrackable.addEvar(48, s);
        s1 = (new StringBuilder()).append(((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix)).append(":").append(makeOmnitureStringFormat(s16)).append(":").append(makeOmnitureStringFormat(s3)).append(":").append(makeOmnitureStringFormat(Build.MODEL)).append(":").append(makeOmnitureStringFormat(s7)).append(":").append(makeOmnitureStringFormat(s8)).append(":").append(makeOmnitureStringFormat(s5)).append(":").append(makeOmnitureStringFormat(s6)).append(":").append(makeOmnitureStringFormat(s)).toString();
        itrackable.addProp(35, s1);
        itrackable.addEvar(35, s1);
        s = (new StringBuilder()).append(((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_old_prefix)).append(":").append(makeOmnitureStringFormat(Build.MODEL)).append(":content").append(":").append(makeOmnitureStringFormat(s5)).append(":").append(makeOmnitureStringFormat(s6)).append(":").append(makeOmnitureStringFormat(s)).toString();
        itrackable.addProp(65, s);
        itrackable.addEvar(65, s);
_L2:
        return;
_L5:
        itrackable.addProp(10, "false");
        itrackable.addEvar(10, "false");
        continue; /* Loop/switch isn't completed */
_L6:
        itrackable.addProp(10, "true");
        itrackable.addEvar(10, "true");
        if (true) goto _L4; else goto _L7
_L7:
    }

    public String getName()
    {
        return "OMNITURE TRACKER";
    }

    public void setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
    }

    public void trackAdBreakEnd(ITrackable itrackable)
    {
    }

    public void trackAdBreakStart(ITrackable itrackable)
    {
    }

    public void trackAdEnd(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackAdEnd could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 301
    //                   1 193
    //                   2 234;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_234;
_L4:
        populateVideoTags(itrackable);
        LogUtils.LOGD(getName(), "trackAdEnd");
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event20");
        obj = String.format("%s:%s:video ad end", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        itrackable.addEvent("event20");
        obj = String.format("%s:%s:feed ad end", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackAdError(ITrackable itrackable)
    {
    }

    public void trackAdFirstQuartile(ITrackable itrackable)
    {
    }

    public void trackAdMidpoint(ITrackable itrackable)
    {
    }

    public void trackAdStart(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackAdStart could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 301
    //                   1 193
    //                   2 234;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_234;
_L4:
        populateVideoTags(itrackable);
        LogUtils.LOGD(getName(), "trackAdStart");
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event19");
        obj = String.format("%s:%s:video ad start", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        itrackable.addEvent("event19");
        obj = String.format("%s:%s:feed ad start", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackAdThirdQuartile(ITrackable itrackable)
    {
    }

    public void trackAuthZFailure(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackAuthZFailure could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 301
    //                   1 193
    //                   2 234;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_234;
_L4:
        populateVideoTags(itrackable);
        LogUtils.LOGD(getName(), "trackAuthZFailure");
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event3");
        obj = String.format("%s:%s:video playback:authorization fail", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        itrackable.addEvent("event3");
        obj = String.format("%s:%s:feed:authorization fail", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackAuthZStarted(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackAuthZStarted could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 291
    //                   1 183
    //                   2 224;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_224;
_L4:
        populateVideoTags(itrackable);
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event2");
        obj = String.format("%s:%s:video playback:authorization attempt", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        itrackable.addEvent("event2");
        obj = String.format("%s:%s:feed:authorization attempt", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackAuthZSuccess(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackAuthZSuccess could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 301
    //                   1 193
    //                   2 234;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_234;
_L4:
        populateVideoTags(itrackable);
        LogUtils.LOGD(getName(), "trackAuthZSuccess");
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event4");
        obj = String.format("%s:%s:video playback:authorization success", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        itrackable.addEvent("event4");
        obj = String.format("%s:%s:feed:authorization success", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackLink(String s, String s1, ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        Object obj;
        Object obj1;
        try
        {
            if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            obj1 = itrackable.getContextData().get("activity");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtils.LOGE(getName(), String.format("trackLink could not be executed : %s", new Object[] {
                s.getMessage()
            }));
            return;
        }
        obj = obj1;
        if (obj1 instanceof Fragment)
        {
            obj = ((Fragment)obj1).getActivity();
        }
        obj = ADMS_Measurement.sharedInstance((Activity)obj);
        populate(((ADMS_Measurement) (obj)), itrackable);
        ((ADMS_Measurement) (obj)).trackLink(null, s, s1, null, null);
        ((ADMS_Measurement) (obj)).clearVars();
    }

    public void trackMediaComplete(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaComplete could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 301
    //                   1 193
    //                   2 243;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_243;
_L4:
        populateVideoTags(itrackable);
        LogUtils.LOGD(getName(), "trackMediaComplete");
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event11");
        itrackable.addEvent("event18");
        obj = String.format("%s:%s:video playback:episode complete", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        obj = String.format("%s:%s:feed:done", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackMediaError(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        Object obj;
        Object obj1;
        String s;
        try
        {
            if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
            {
                break MISSING_BLOCK_LABEL_205;
            }
            obj1 = itrackable.getContextData().get("activity");
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaError could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        obj = obj1;
        if (obj1 instanceof Fragment)
        {
            obj = ((Fragment)obj1).getActivity();
        }
        obj = (Activity)obj;
        if (itrackable.getContextData().get("error") != null)
        {
            obj1 = (String)itrackable.getContextData().get("trackCode");
            s = (String)itrackable.getContextData().get("error");
            itrackable.addProp(49, ((String) (obj1)));
            itrackable.addEvar(49, ((String) (obj1)));
            itrackable.addProp(50, s);
            itrackable.addEvar(50, s);
            LogUtils.LOGD(getName(), "trackMediaError");
            trackLink("o", String.format("%s:%s", new Object[] {
                ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
            }), itrackable);
        }
    }

    public void trackMediaFirstQuarter(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaFirstQuarter could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = ((VPMedia) (obj1)).getMediaType().getTypes();
        itrackable.addEvent("event8");
        populateVideoTags(itrackable);
        obj = String.format("%s:%s:video playback:25 complete", new Object[] {
            ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), obj1
        });
        LogUtils.LOGD(getName(), "trackMediaFirstQuarter");
        trackLink("o", ((String) (obj)), itrackable);
    }

    public void trackMediaForward(ITrackable itrackable)
    {
    }

    public void trackMediaMidpoint(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaMidpoint could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = ((VPMedia) (obj1)).getMediaType().getTypes();
        itrackable.addEvent("event9");
        populateVideoTags(itrackable);
        obj = String.format("%s:%s:video playback:50 complete", new Object[] {
            ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), obj1
        });
        LogUtils.LOGD(getName(), "trackMediaMidpoint");
        trackLink("o", ((String) (obj)), itrackable);
    }

    public void trackMediaPaused(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaResumed could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj1 = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        s = ((VPMedia) (obj1)).getMediaType().getTypes();
        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[((VPMedia) (obj1)).getMediaType().ordinal()])
        {
        case 1: // '\001'
            itrackable.addEvent("event12");
            obj = String.format("%s:%s:video playback:pause button click", new Object[] {
                ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
            });
            populateVideoTags(itrackable);
            LogUtils.LOGD(getName(), "trackMediaPaused");
            trackLink("o", ((String) (obj)), itrackable);
            return;
        }
    }

    public void trackMediaResumed(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaResumed could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        obj1 = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        s = ((VPMedia) (obj1)).getMediaType().getTypes();
        itrackable.addEvent("event1");
        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[((VPMedia) (obj1)).getMediaType().ordinal()])
        {
        case 1: // '\001'
            itrackable.addEvent("event13");
            obj = String.format("%s:%s:video playback:episode resume", new Object[] {
                ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
            });
            populateVideoTags(itrackable);
            LogUtils.LOGD(getName(), "trackMediaResumed");
            trackLink("o", ((String) (obj)), itrackable);
            return;
        }
    }

    public void trackMediaRewind(ITrackable itrackable)
    {
    }

    public void trackMediaStarted(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        VPMedia vpmedia;
        String s;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj1 = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaStarted could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        vpmedia = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (vpmedia == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        s = vpmedia.getMediaType().getTypes();
        obj = "";
        itrackable.addEvent("event1");
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[vpmedia.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 309
    //                   1 201
    //                   2 242;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_242;
_L4:
        populateVideoTags(itrackable);
        LogUtils.LOGD(getName(), "trackMediaStarted");
        trackLink("o", ((String) (obj)), itrackable);
        return;
_L2:
        itrackable.addEvent("event14");
        obj = String.format("%s:%s:video playback:episode start", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
        itrackable.addEvent("event15");
        obj = String.format("%s:%s:feed:start", new Object[] {
            ((Activity) (obj1)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), s
        });
          goto _L4
    }

    public void trackMediaStateUpdated(ITrackable itrackable)
    {
    }

    public void trackMediaStopped(ITrackable itrackable)
    {
    }

    public void trackMediaThirdQuarter(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaThirdQuarter could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = (VPMedia)itrackable.getContextData().get("currentMedia");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = ((VPMedia) (obj1)).getMediaType().getTypes();
        itrackable.addEvent("event10");
        populateVideoTags(itrackable);
        obj = String.format("%s:%s:video playback:75 complete", new Object[] {
            ((Activity) (obj)).getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.omniture_prefix), obj1
        });
        LogUtils.LOGD(getName(), "trackMediaThirdQuarter");
        trackLink("o", ((String) (obj)), itrackable);
    }

    public void trackPing(ITrackable itrackable)
    {
    }
}
