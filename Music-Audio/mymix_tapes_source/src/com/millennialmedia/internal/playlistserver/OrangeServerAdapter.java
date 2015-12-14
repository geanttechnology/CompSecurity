// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.playlistserver;

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
import com.millennialmedia.internal.utils.JSONUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal.playlistserver:
//            PlayListServerAdapter

public class OrangeServerAdapter extends PlayListServerAdapter
{

    public static String PLAYLIST_REQUEST_PATH = "/admax/sdk/playlist/1";
    private static final String TAG = com/millennialmedia/internal/playlistserver/OrangeServerAdapter.getSimpleName();

    public OrangeServerAdapter()
    {
    }

    private static String buildAdRequest(Map map)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("ver", "1");
            jsonobject.put("app", buildAppInfoJSON());
            jsonobject.put("env", buildEnvironmentInfoJSON());
            jsonobject.put("req", buildRequestInfoJSON(map));
            jsonobject.put("user", buildUserInfoJSON());
            jsonobject.put("testing", buildTestingJSON());
            map = jsonobject.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            MMLog.e(TAG, "Error creating JSON request", map);
            return null;
        }
        return map;
    }

    private static JSONObject buildAppInfoJSON()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("appId", EnvironmentUtils.getAppId());
        jsonobject.put("name", EnvironmentUtils.getApplicationName());
        return jsonobject;
    }

    private static JSONObject buildEnvironmentInfoJSON()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("os", "android");
        jsonobject.put("osv", android.os.Build.VERSION.RELEASE);
        jsonobject.put("model", Build.MODEL);
        jsonobject.put("sdkVer", "6.1.0-5323db4");
        if (!MMSDK.registeredPlugins.isEmpty())
        {
            jsonobject.put("sdkPlugins", JSONUtils.buildFromMap(MMSDK.registeredPlugins));
        }
        jsonobject.put("mcc", EnvironmentUtils.getMcc());
        jsonobject.put("mnc", EnvironmentUtils.getMnc());
        jsonobject.put("lang", EnvironmentUtils.getLocaleLanguage());
        jsonobject.put("country", EnvironmentUtils.getLocaleCountry());
        jsonobject.put("ua", EnvironmentUtils.getUserAgent());
        Object obj = EnvironmentUtils.getAdInfo();
        Object obj1 = EnvironmentUtils.getAaid(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)));
        if (obj1 != null)
        {
            jsonobject.put("ifa", obj1);
            jsonobject.put("lmt", EnvironmentUtils.isLimitAdTrackingEnabled(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj))));
        } else
        {
            jsonobject.put("dpidmd5", EnvironmentUtils.getHashedDeviceId("MD5"));
            jsonobject.put("dpidsha1", EnvironmentUtils.getHashedDeviceId("SHA1"));
        }
        jsonobject.put("w", EnvironmentUtils.getDisplayWidth());
        jsonobject.put("h", EnvironmentUtils.getDisplayHeight());
        jsonobject.put("screenScale", EnvironmentUtils.getDisplayDensity());
        jsonobject.put("ppi", EnvironmentUtils.getDisplayDensityDpi());
        jsonobject.put("natOrient", EnvironmentUtils.getNaturalConfigOrientationString());
        jsonobject.put("storage", EnvironmentUtils.getAvailableStorageSize());
        jsonobject.put("vol", EnvironmentUtils.getVolume(3));
        jsonobject.put("headphones", EnvironmentUtils.areHeadphonesPluggedIn());
        jsonobject.put("charging", EnvironmentUtils.isDevicePlugged());
        jsonobject.put("charge", EnvironmentUtils.getBatteryLevel());
        jsonobject.put("connectionType", EnvironmentUtils.getNetworkConnectionType());
        jsonobject.put("cellSignalDbm", EnvironmentUtils.getCellSignalDbm());
        jsonobject.put("carrier", EnvironmentUtils.getNetworkOperatorName());
        jsonobject.put("ip", EnvironmentUtils.getIpAddress());
        jsonobject.put("apMac", EnvironmentUtils.getMacAddress());
        obj = EnvironmentUtils.getLocation();
        if (obj != null && MMSDK.locationEnabled)
        {
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("lat", ((Location) (obj)).getLatitude());
            ((JSONObject) (obj1)).put("lon", ((Location) (obj)).getLongitude());
            ((JSONObject) (obj1)).put("src", ((Location) (obj)).getProvider());
            ((JSONObject) (obj1)).put("ts", ((Location) (obj)).getTime() / 1000L);
            if (((Location) (obj)).hasAccuracy())
            {
                ((JSONObject) (obj1)).put("horizAcc", ((Location) (obj)).getAccuracy());
            }
            if (((Location) (obj)).hasSpeed())
            {
                ((JSONObject) (obj1)).put("speed", ((Location) (obj)).getSpeed());
            }
            if (((Location) (obj)).hasBearing())
            {
                ((JSONObject) (obj1)).put("bearing", ((Location) (obj)).getBearing());
            }
            if (((Location) (obj)).hasAltitude())
            {
                ((JSONObject) (obj1)).put("alt", ((Location) (obj)).getAltitude());
            }
            jsonobject.put("loc", obj1);
        }
        obj = new JSONObject();
        obj1 = EnvironmentUtils.getAvailableCameras();
        if (((com.millennialmedia.internal.utils.EnvironmentUtils.AvailableCameras) (obj1)).frontCamera)
        {
            ((JSONObject) (obj)).put("cameraFront", "true");
        }
        if (((com.millennialmedia.internal.utils.EnvironmentUtils.AvailableCameras) (obj1)).backCamera)
        {
            ((JSONObject) (obj)).put("cameraRear", "true");
        }
        if (EnvironmentUtils.hasNfc())
        {
            ((JSONObject) (obj)).put("nfc", Boolean.toString(EnvironmentUtils.hasNfcPermission()));
        }
        if (EnvironmentUtils.hasBluetooth())
        {
            ((JSONObject) (obj)).put("bt", Boolean.toString(EnvironmentUtils.hasBluetoothPermission()));
        }
        if (EnvironmentUtils.hasMicrophone())
        {
            ((JSONObject) (obj)).put("mic", Boolean.toString(EnvironmentUtils.hasMicrophonePermission()));
        }
        if (EnvironmentUtils.hasGps())
        {
            ((JSONObject) (obj)).put("gps", Boolean.toString(EnvironmentUtils.hasFineLocationPermission()));
        }
        jsonobject.put("deviceFeatures", obj);
        obj = Handshake.getExistingIds();
        if (!((List) (obj)).isEmpty())
        {
            jsonobject.put("existIds", JSONUtils.buildFromList(((List) (obj))));
        }
        return jsonobject;
    }

    private static JSONObject buildRequestInfoJSON(Map map)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        AppInfo appinfo = MMSDK.getAppInfo();
        if (appinfo != null)
        {
            jsonobject.put("coppa", appinfo.getCoppa());
            jsonobject.put("dcn", appinfo.getSiteId());
            jsonobject.put("mediator", appinfo.getMediator());
        }
        if (map != null)
        {
            jsonobject.put("posType", map.get("placementType"));
            jsonobject.put("orients", JSONUtils.buildFromList((List)map.get("supportedOrientations")));
            jsonobject.put("keywords", JSONUtils.buildFromList(Utils.splitCommaSeparateString((String)map.get("keywords"))));
            jsonobject.put("posId", map.get("placementId"));
            Object obj = map.get("width");
            if ((obj instanceof Integer) && ((Integer)obj).intValue() > 0)
            {
                jsonobject.put("w", ViewUtils.convertPixelsToDips(((Integer)obj).intValue()));
            }
            obj = map.get("height");
            if ((obj instanceof Integer) && ((Integer)obj).intValue() > 0)
            {
                jsonobject.put("h", ViewUtils.convertPixelsToDips(((Integer)obj).intValue()));
            }
            jsonobject.put("refreshRate", map.get("refreshRate"));
            if (map.containsKey("nativeTypes"))
            {
                JSONObject jsonobject1 = new JSONObject();
                jsonobject1.put("nativeType", JSONUtils.buildFromList((List)map.get("nativeTypes")));
                jsonobject.put("posTypeAttrs", jsonobject1);
            }
        }
        jsonobject.put("curOrient", EnvironmentUtils.getCurrentConfigOrientationString());
        return jsonobject;
    }

    private static JSONObject buildTestingJSON()
        throws JSONException
    {
        TestInfo testinfo = MMSDK.getTestInfo();
        if (testinfo != null)
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("bidder", testinfo.bidder);
            jsonobject.put("creativeId", testinfo.creativeId);
            return jsonobject;
        } else
        {
            return null;
        }
    }

    private static JSONObject buildUserInfoJSON()
        throws JSONException
    {
        UserData userdata = MMSDK.getUserData();
        if (userdata != null)
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("age", userdata.getAge());
            jsonobject.put("kids", userdata.getChildren());
            jsonobject.put("hhi", userdata.getIncome());
            jsonobject.put("edu", userdata.getEducation());
            jsonobject.put("eth", userdata.getEthnicity());
            jsonobject.put("gender", userdata.getGender());
            jsonobject.put("keywords", JSONUtils.buildFromList(Utils.splitCommaSeparateString(userdata.getKeywords())));
            jsonobject.put("marital", userdata.getMarital());
            jsonobject.put("politics", userdata.getPolitics());
            jsonobject.put("zip", userdata.getPostalCode());
            java.util.Date date = userdata.getDob();
            if (date != null)
            {
                jsonobject.put("dob", (new SimpleDateFormat("yyyyMMdd")).format(date));
            }
            jsonobject.put("state", userdata.getState());
            jsonobject.put("country", userdata.getCountry());
            jsonobject.put("dma", userdata.getDma());
            return jsonobject;
        } else
        {
            return null;
        }
    }

    static PlayList parsePlayListResponse(String s)
    {
        Object obj;
        obj = new JSONObject(s);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("playlist = \n").append(((JSONObject) (obj)).toString(2)).toString());
        }
        s = new PlayList();
        s.playListVersion = ((JSONObject) (obj)).getString("ver");
        if (((PlayList) (s)).playListVersion.equals("1"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        MMLog.e(TAG, "Playlist response does not match requested version");
        return null;
        s.handshakeConfig = ((JSONObject) (obj)).optString("config", null);
        if (((PlayList) (s)).handshakeConfig != null && !((PlayList) (s)).handshakeConfig.equals(Handshake.getConfig()))
        {
            Handshake.request(true);
        }
        s.responseId = ((JSONObject) (obj)).getString("id");
        s.placementId = ((JSONObject) (obj)).getString("posId");
        s.placementName = ((JSONObject) (obj)).getString("pos");
        s.siteId = ((JSONObject) (obj)).getString("dcn");
        if ("DoNotReport".equals(((PlayList) (s)).siteId)) goto _L2; else goto _L1
_L1:
        s.enableReporting();
_L13:
        obj = ((JSONObject) (obj)).getJSONArray("playlist");
        int i = 0;
_L7:
        Object obj1;
        JSONObject jsonobject;
        String s1;
        int j;
        try
        {
            j = ((JSONArray) (obj)).length();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(TAG, "Unable to parse play list", s);
            return null;
        }
        if (i >= j) goto _L4; else goto _L3
_L3:
        jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        s1 = jsonobject.getString("type");
        obj1 = jsonobject.getString("item");
        if (!s1.equals("client_mediation")) goto _L6; else goto _L5
_L5:
        s1 = jsonobject.getString("adnet");
        jsonobject = jsonobject.getJSONObject("req");
        s.addItem(new com.millennialmedia.internal.PlayList.ClientMediationPlayListItem(((String) (obj1)), s1, jsonobject.getString("site"), jsonobject.getString("posId")));
_L8:
        i++;
          goto _L7
_L2:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "Playlist dcn is <DoNotReport> -- reporting disabled");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!s1.equals("server_mediation"))
        {
            break MISSING_BLOCK_LABEL_442;
        }
        jsonobject = jsonobject.getJSONObject("req");
        obj1 = new com.millennialmedia.internal.PlayList.ServerMediationPlayListItem(((String) (obj1)), jsonobject.getString("url"));
        obj1.validateRegex = jsonobject.optString("validRegex", null);
        obj1.postBody = jsonobject.optString("postBody", null);
        obj1.postContentType = jsonobject.optString("postType", null);
        s.addItem(((com.millennialmedia.internal.PlayList.PlayListItem) (obj1)));
          goto _L8
        obj1;
        MMLog.e(TAG, (new StringBuilder()).append("Unable to parse play list item<").append(i).append(">").toString(), ((Throwable) (obj1)));
          goto _L8
        if (!s1.equals("exchange")) goto _L10; else goto _L9
_L9:
        jsonobject = jsonobject.getJSONObject("req");
        obj1 = new com.millennialmedia.internal.PlayList.ExchangeMediationPlayListItem(((String) (obj1)), jsonobject.getString("url"));
        obj1.postBody = jsonobject.optString("postBody", null);
        obj1.postContentType = jsonobject.optString("postType", null);
        s.addItem(((com.millennialmedia.internal.PlayList.PlayListItem) (obj1)));
          goto _L8
_L10:
        if (!s1.equals("ad_content")) goto _L8; else goto _L11
_L11:
        s.addItem(new com.millennialmedia.internal.PlayList.AdContentPlayListItem(((String) (obj1)), jsonobject.getString("value")));
          goto _L8
_L4:
        return s;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void loadPlayList(final Map adPlacementMetadata, final PlayListServerAdapter.AdapterLoadListener adapterLoadListener)
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final OrangeServerAdapter this$0;
            final Map val$adPlacementMetadata;
            final PlayListServerAdapter.AdapterLoadListener val$adapterLoadListener;

            public void run()
            {
                Object obj = OrangeServerAdapter.buildAdRequest(adPlacementMetadata);
                if (obj == null)
                {
                    adapterLoadListener.loadFailed(new RuntimeException("Unable to create post request data"));
                    return;
                }
                String s = Handshake.getActivePlaylistServerBaseUrl();
                if (s == null)
                {
                    adapterLoadListener.loadFailed(new RuntimeException("Unable to determine base url for request"));
                    return;
                }
                s = s.concat(OrangeServerAdapter.PLAYLIST_REQUEST_PATH);
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(OrangeServerAdapter.TAG, (new StringBuilder()).append("Request\n\turl: ").append(s).append("\n\tpost data: ").append(((String) (obj))).toString());
                }
                obj = HttpUtils.getContentFromPostRequest(s, ((String) (obj)), "application/json");
                if (TextUtils.isEmpty(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content))
                {
                    adapterLoadListener.loadFailed(new RuntimeException("Post request failed to get ad"));
                    return;
                }
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(OrangeServerAdapter.TAG, (new StringBuilder()).append("Response content:\n").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content).toString());
                }
                obj = OrangeServerAdapter.parsePlayListResponse(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content);
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
                this$0 = OrangeServerAdapter.this;
                adPlacementMetadata = map;
                adapterLoadListener = adapterloadlistener;
                super();
            }
        });
    }



}
