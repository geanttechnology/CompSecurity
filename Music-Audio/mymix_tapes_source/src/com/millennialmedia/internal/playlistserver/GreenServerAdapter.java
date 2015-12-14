// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.playlistserver;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.millennialmedia.AppInfo;
import com.millennialmedia.MMLog;
import com.millennialmedia.MMSDK;
import com.millennialmedia.TestInfo;
import com.millennialmedia.UserData;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.PlayList;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.playlistserver:
//            PlayListServerAdapter

public class GreenServerAdapter extends PlayListServerAdapter
{

    private static final String TAG = com/millennialmedia/internal/playlistserver/GreenServerAdapter.getSimpleName();

    public GreenServerAdapter()
    {
    }

    private static void addParameter(StringBuilder stringbuilder, String s, Object obj)
    {
        String s1 = null;
        if (obj != null)
        {
            s1 = obj.toString();
        }
        if (obj == null || TextUtils.isEmpty(s1))
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Unable to add parameter due to empty value for key <").append(s).append("> and value <").append(obj).append(">").toString());
            }
        } else
        {
            try
            {
                s = String.format("%s=%s", new Object[] {
                    s, URLEncoder.encode(s1, "UTF-8")
                });
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (StringBuilder stringbuilder) { }
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Error occurred when trying to inject ad url request parameter", stringbuilder);
                return;
            }
        }
    }

    private static String buildAdRequestUrl(Map map)
    {
        Object obj = new StringBuilder();
        addParameter(((StringBuilder) (obj)), "dm", Build.MODEL);
        addParameter(((StringBuilder) (obj)), "dv", (new StringBuilder()).append("Android").append(android.os.Build.VERSION.RELEASE).toString());
        addParameter(((StringBuilder) (obj)), "ua", EnvironmentUtils.getUserAgent());
        Object obj1 = EnvironmentUtils.getAdInfo();
        String s1 = EnvironmentUtils.getAaid(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)));
        if (s1 != null)
        {
            addParameter(((StringBuilder) (obj)), "aaid", s1);
            boolean flag;
            if (!EnvironmentUtils.isLimitAdTrackingEnabled(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            addParameter(((StringBuilder) (obj)), "ate", Boolean.toString(flag));
        } else
        {
            String s = EnvironmentUtils.getHashedDeviceId("MD5");
            String s2 = EnvironmentUtils.getHashedDeviceId("SHA1");
            if (s != null && s2 != null)
            {
                addParameter(((StringBuilder) (obj)), "mmdid", (new StringBuilder()).append("mmh_").append(s).append("_").append(s2).toString());
            }
        }
        addParameter(((StringBuilder) (obj)), "density", Float.toString(EnvironmentUtils.getDisplayDensity()));
        addParameter(((StringBuilder) (obj)), "hpx", Integer.toString(EnvironmentUtils.getDisplayHeight()));
        addParameter(((StringBuilder) (obj)), "wpx", Integer.toString(EnvironmentUtils.getDisplayWidth()));
        addParameter(((StringBuilder) (obj)), "do", EnvironmentUtils.getCurrentConfigOrientationString());
        addParameter(((StringBuilder) (obj)), "olock", "false");
        addParameter(((StringBuilder) (obj)), "sk", "false");
        addParameter(((StringBuilder) (obj)), "vol", Integer.valueOf(EnvironmentUtils.getVolume(3)));
        addParameter(((StringBuilder) (obj)), "headphones", Boolean.valueOf(EnvironmentUtils.areHeadphonesPluggedIn()));
        if (EnvironmentUtils.hasMicrophone())
        {
            addParameter(((StringBuilder) (obj)), "mic", Boolean.toString(EnvironmentUtils.hasMicrophonePermission()));
        }
        addParameter(((StringBuilder) (obj)), "language", EnvironmentUtils.getLocaleLanguage());
        addParameter(((StringBuilder) (obj)), "country", EnvironmentUtils.getLocaleCountry());
        addParameter(((StringBuilder) (obj)), "pkid", EnvironmentUtils.getApplicationContext().getPackageName());
        addParameter(((StringBuilder) (obj)), "pknm", EnvironmentUtils.getApplicationName());
        addParameter(((StringBuilder) (obj)), "bl", EnvironmentUtils.getBatteryLevel());
        addParameter(((StringBuilder) (obj)), "plugged", Boolean.toString(EnvironmentUtils.isDevicePlugged()));
        addParameter(((StringBuilder) (obj)), "space", Long.toString(EnvironmentUtils.getAvailableStorageSize()));
        addParameter(((StringBuilder) (obj)), "conn", EnvironmentUtils.getNetworkConnectionType());
        addParameter(((StringBuilder) (obj)), "celldbm", EnvironmentUtils.getCellSignalDbm());
        obj1 = EnvironmentUtils.getMcc();
        if (obj1 != null)
        {
            addParameter(((StringBuilder) (obj)), "mcc", Integer.toString(((Integer) (obj1)).intValue()));
        }
        obj1 = EnvironmentUtils.getMnc();
        if (obj1 != null)
        {
            addParameter(((StringBuilder) (obj)), "mnc", Integer.toString(((Integer) (obj1)).intValue()));
        }
        addParameter(((StringBuilder) (obj)), "pip", EnvironmentUtils.getIpAddress());
        obj1 = EnvironmentUtils.getNetworkOperatorName();
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            addParameter(((StringBuilder) (obj)), "cn", obj1);
        }
        obj1 = EnvironmentUtils.getLocation();
        if (obj1 != null && MMSDK.locationEnabled)
        {
            addParameter(((StringBuilder) (obj)), "lat", Double.toString(((Location) (obj1)).getLatitude()));
            addParameter(((StringBuilder) (obj)), "long", Double.toString(((Location) (obj1)).getLongitude()));
            if (((Location) (obj1)).hasAccuracy())
            {
                addParameter(((StringBuilder) (obj)), "ha", Float.toString(((Location) (obj1)).getAccuracy()));
            }
            if (((Location) (obj1)).hasSpeed())
            {
                addParameter(((StringBuilder) (obj)), "spd", Float.toString(((Location) (obj1)).getSpeed()));
            }
            if (((Location) (obj1)).hasBearing())
            {
                addParameter(((StringBuilder) (obj)), "brg", Float.toString(((Location) (obj1)).getBearing()));
            }
            if (((Location) (obj1)).hasAltitude())
            {
                addParameter(((StringBuilder) (obj)), "alt", Double.toString(((Location) (obj1)).getAltitude()));
            }
            addParameter(((StringBuilder) (obj)), "tslr", Long.toString(((Location) (obj1)).getTime() / 1000L));
            addParameter(((StringBuilder) (obj)), "loc", "true");
            addParameter(((StringBuilder) (obj)), "lsrc", ((Location) (obj1)).getProvider());
        } else
        {
            addParameter(((StringBuilder) (obj)), "loc", "false");
        }
        addParameter(((StringBuilder) (obj)), "sdkversion", "6.1.0-5323db4.a");
        addParameter(((StringBuilder) (obj)), "video", "true");
        addParameter(((StringBuilder) (obj)), "cachedvideo", "true");
        obj1 = MMSDK.getAppInfo();
        if (obj1 != null)
        {
            addParameter(((StringBuilder) (obj)), "vendor", ((AppInfo) (obj1)).getMediator());
            addParameter(((StringBuilder) (obj)), "coppa", ((AppInfo) (obj1)).getCoppa());
        }
        obj1 = map.get("placementId");
        if (obj1 instanceof String)
        {
            addParameter(((StringBuilder) (obj)), "apid", (String)obj1);
        }
        obj1 = map.get("placementType");
        if ((obj1 instanceof String) && ((String)obj1).equals("interstitial"))
        {
            addParameter(((StringBuilder) (obj)), "at", "i");
            addParameter(((StringBuilder) (obj)), "reqtype", "fetch");
        } else
        {
            addParameter(((StringBuilder) (obj)), "at", "b");
            addParameter(((StringBuilder) (obj)), "reqtype", "getad");
        }
        obj1 = map.get("width");
        if ((obj1 instanceof Integer) && ((Integer)obj1).intValue() > 0)
        {
            addParameter(((StringBuilder) (obj)), "hswd", Integer.valueOf(ViewUtils.convertPixelsToDips(((Integer)obj1).intValue())));
        }
        obj1 = map.get("height");
        if ((obj1 instanceof Integer) && ((Integer)obj1).intValue() > 0)
        {
            addParameter(((StringBuilder) (obj)), "hsht", Integer.valueOf(ViewUtils.convertPixelsToDips(((Integer)obj1).intValue())));
        }
        addParameter(((StringBuilder) (obj)), "refreshrate", map.get("refreshRate"));
        map = ((Map) (map.get("keywords")));
        if (map instanceof String)
        {
            addParameter(((StringBuilder) (obj)), "keywords", (String)map);
        }
        map = MMSDK.getUserData();
        if (map != null)
        {
            addParameter(((StringBuilder) (obj)), "age", map.getAge());
            addParameter(((StringBuilder) (obj)), "children", map.getChildren());
            addParameter(((StringBuilder) (obj)), "education", map.getEducation());
            addParameter(((StringBuilder) (obj)), "ethnicity", map.getEthnicity());
            addParameter(((StringBuilder) (obj)), "gender", map.getGender());
            addParameter(((StringBuilder) (obj)), "income", map.getIncome());
            addParameter(((StringBuilder) (obj)), "marital", map.getMarital());
            addParameter(((StringBuilder) (obj)), "politics", map.getPolitics());
            addParameter(((StringBuilder) (obj)), "zip", map.getPostalCode());
            addParameter(((StringBuilder) (obj)), "state", map.getState());
            obj1 = map.getDob();
            if (obj1 != null)
            {
                addParameter(((StringBuilder) (obj)), "dob", (new SimpleDateFormat("yyyyMMdd")).format(((java.util.Date) (obj1))));
            }
            addParameter(((StringBuilder) (obj)), "dma", map.getDma());
        }
        addParameter(((StringBuilder) (obj)), "appsids", TextUtils.join(",", Handshake.getExistingIds()));
        map = MMSDK.getTestInfo();
        if (map != null)
        {
            addParameter(((StringBuilder) (obj)), "acid", ((TestInfo) (map)).creativeId);
        }
        map = ((StringBuilder) (obj)).toString();
        if (TextUtils.isEmpty(map))
        {
            return null;
        }
        obj = Handshake.getActivePlaylistServerBaseUrl();
        if (obj == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(((String) (obj))).append(map).toString();
        }
    }

    static PlayList parsePlayListResponse(String s)
    {
        String s1 = Long.toString(System.currentTimeMillis() / 1000L);
        PlayList playlist = new PlayList();
        playlist.playListVersion = "1";
        playlist.handshakeConfig = (new StringBuilder()).append("handshakeId_").append(s1).toString();
        playlist.responseId = (new StringBuilder()).append("response_").append(s1).toString();
        playlist.placementId = (new StringBuilder()).append("placementId_").append(s1).toString();
        playlist.placementName = (new StringBuilder()).append("placementName_").append(s1).toString();
        playlist.siteId = (new StringBuilder()).append("siteId_").append(s1).toString();
        playlist.addItem(new com.millennialmedia.internal.PlayList.AdContentPlayListItem("itemId", s));
        return playlist;
    }

    public void loadPlayList(final Map adPlacementMetadata, final PlayListServerAdapter.AdapterLoadListener adapterLoadListener)
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final GreenServerAdapter this$0;
            final Map val$adPlacementMetadata;
            final PlayListServerAdapter.AdapterLoadListener val$adapterLoadListener;

            public void run()
            {
                Object obj = GreenServerAdapter.buildAdRequestUrl(adPlacementMetadata);
                if (obj == null)
                {
                    adapterLoadListener.loadFailed(new RuntimeException("Unable to create post request data"));
                    return;
                }
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(GreenServerAdapter.TAG, (new StringBuilder()).append("Ad request url: ").append(((String) (obj))).toString());
                }
                obj = HttpUtils.getContentFromGetRequest(((String) (obj)));
                if (TextUtils.isEmpty(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content))
                {
                    adapterLoadListener.loadFailed(new RuntimeException("Get request failed to get ad"));
                    return;
                }
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(GreenServerAdapter.TAG, (new StringBuilder()).append("Ad response content: ").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content).toString());
                }
                obj = GreenServerAdapter.parsePlayListResponse(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content);
                if (obj == null)
                {
                    adapterLoadListener.loadFailed(new RuntimeException("Unable to get valid playlist"));
                    return;
                } else
                {
                    adapterLoadListener.loadSucceeded(((PlayList) (obj)));
                    return;
                }
            }

            
            {
                this$0 = GreenServerAdapter.this;
                adPlacementMetadata = map;
                adapterLoadListener = adapterloadlistener;
                super();
            }
        });
    }



}
