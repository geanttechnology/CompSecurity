// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.database.Cursor;
import com.espn.androidplayersdk.playbackmanager.EPPlaybackManagerListener;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            ESPNPlayerSdk, DataManager, FeedsDB, EPVideoTrackingManager, 
//            EPPlayerTrackingManager, PlaybackSession, EPCatalogManager, EPEvents, 
//            EPSDKPrefs, FeedsManagerAPI, FeedsCommListener

public class EPPlaybackManager
{

    static final String platform = "&platform=android";
    static final String sdkVersion;
    static final String version = "&v=2.0.0";
    private String affiliateID;
    EPPlaybackManagerListener playbackManagerLsnr;
    PlaybackSession playbackSession;

    public EPPlaybackManager(EPPlaybackManagerListener epplaybackmanagerlistener)
    {
        affiliateID = null;
        playbackManagerLsnr = epplaybackmanagerlistener;
    }

    public static String getDefaultStartSessionUrl(String s)
    {
        Utils.sdkLog("EPPlaybackManager.getDefaultStartSessionUrl:", 3, null);
        Object obj = null;
        String as[] = DataManager.feedsDbConn.getVideoInfo(s, "videoURLDefault", "events");
        if (as != null)
        {
            s = as[0];
        } else
        {
            String as1[] = DataManager.feedsDbConn.getVideoInfo(s, "videoURLDefault", "featuredEvents");
            s = obj;
            if (as1 != null)
            {
                return as1[0];
            }
        }
        return s;
    }

    private void initiateStartSessionRequest(String s, final boolean pollSessionForLinearNetwork)
    {
        String as[] = getVideoInfoForDevice(s);
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        s = createEventForTracking(s);
        EPVideoTrackingManager.setEventObj(s);
        EPPlayerTrackingManager.setEventObj(s);
        String s1;
        String s2;
        s = as[0];
        s2 = as[1];
        s1 = as[2];
        if (s2.equalsIgnoreCase("live") && s1.equalsIgnoreCase("linear"))
        {
            pollSessionForLinearNetwork = true;
        }
        if (playbackSession == null)
        {
            playbackSession = new PlaybackSession(s, playbackManagerLsnr, this, pollSessionForLinearNetwork);
            playbackSession.start();
            return;
        }
        try
        {
            playbackSession.updateVideoUrlForSessionChange(s);
            playbackSession.initiateStartSessionRequest();
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("PlaybackManager")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, exception);
        playbackManagerLsnr.streamDidFailAuthorizationWithMessage("Event can not be found");
        return;
        (new EPCatalogManager()).getEventByID(s, new EPCatalogManager.Callback() {

            final EPPlaybackManager this$0;
            private final boolean val$pollSessionForLinearNetwork;

            public void onEventRetrivalError(int i)
            {
                playbackManagerLsnr.streamDidFailAuthorizationWithMessage("Event can not be found");
            }

            public void onEventUpdate(EPEvents epevents)
            {
                EPVideoTrackingManager.setEventObj(epevents);
                EPPlayerTrackingManager.setEventObj(epevents);
                String as1[] = getVideoInfoForDevice(epevents.getEventId());
                epevents = as1[0];
                String s3 = as1[1];
                String s4 = as1[2];
                boolean flag;
                if (s3.equalsIgnoreCase("live") && s4.equalsIgnoreCase("linear"))
                {
                    flag = true;
                } else
                {
                    flag = pollSessionForLinearNetwork;
                }
                if (playbackSession == null)
                {
                    playbackSession = new PlaybackSession(epevents, playbackManagerLsnr, EPPlaybackManager.this, flag);
                    playbackSession.start();
                    return;
                } else
                {
                    playbackSession.updateVideoUrlForSessionChange(epevents);
                    playbackSession.initiateStartSessionRequest();
                    return;
                }
            }

            
            {
                this$0 = EPPlaybackManager.this;
                pollSessionForLinearNetwork = flag;
                super();
            }
        });
        return;
    }

    EPEvents createEventForTracking(String s)
    {
        s = DataManager.feedsDbConn.getEventById(s);
        if (s.getCount() <= 0 || !s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_536;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("eventName", s.getString(s.getColumnIndex("eventName")));
        hashmap.put("eventId", s.getString(s.getColumnIndex("eventId")));
        hashmap.put("simulcastAiringId", s.getString(s.getColumnIndex("simulcastAiringId")));
        hashmap.put("eventType", s.getString(s.getColumnIndex("eventType")));
        hashmap.put("showName", s.getString(s.getColumnIndex("showName")));
        hashmap.put("broadcastStartTime", s.getString(s.getColumnIndex("broadcastStartTime")));
        hashmap.put("startTime", s.getString(s.getColumnIndex("startTime")));
        hashmap.put("endTime", s.getString(s.getColumnIndex("endTime")));
        hashmap.put("imageLarge", s.getString(s.getColumnIndex("imageLarge")));
        hashmap.put("imageMed", s.getString(s.getColumnIndex("imageMed")));
        hashmap.put("imageSmall", s.getString(s.getColumnIndex("imageSmall")));
        hashmap.put("parentalRating", s.getString(s.getColumnIndex("parentalRating")));
        hashmap.put("seekInSeconds", s.getString(s.getColumnIndex("seekInSeconds")));
        hashmap.put("networkCode", s.getString(s.getColumnIndex("networkCode")));
        hashmap.put("description", s.getString(s.getColumnIndex("description")));
        hashmap.put("networkName", s.getString(s.getColumnIndex("networkName")));
        hashmap.put("league", s.getString(s.getColumnIndex("league")));
        hashmap.put("leagueName", s.getString(s.getColumnIndex("leagueName")));
        hashmap.put("SPORT", s.getString(s.getColumnIndex("SPORT")));
        hashmap.put("sportCode", s.getString(s.getColumnIndex("sportCode")));
        hashmap.put("programingCode", s.getString(s.getColumnIndex("programingCode")));
        hashmap.put("coverageType", s.getString(s.getColumnIndex("coverageType")));
        hashmap.put("networkResourceId", s.getString(s.getColumnIndex("networkResourceId")));
        s = new EPEvents(hashmap);
        return s;
        s;
        Utils.sdkLog("PlaybackManager:Unable to set event for tracking", 5, s);
        return null;
    }

    protected String getAffiliateID()
    {
        return affiliateID;
    }

    String[] getVideoInfoForDevice(String s)
    {
        Object obj;
        if ((new EPSDKPrefs()).getBooleanField("config", "deviceOverride", false))
        {
            return DataManager.feedsDbConn.getVideoInfo(s, "videoURLDefault", "events");
        }
        obj = Utils.isTablet(ESPNPlayerSdk.mCtx);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (((Boolean) (obj)).booleanValue())
        {
            obj = "videoURLLarge";
        } else
        {
            obj = "videoURLMed";
        }
        try
        {
            return DataManager.feedsDbConn.getVideoInfo(s, ((String) (obj)), "events");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.sdkLog("PlaybackManager:Error: Default to medium bitrate stream ", 5, ((Exception) (obj)));
        }
        break MISSING_BLOCK_LABEL_79;
        obj = "videoURLSmall";
        break MISSING_BLOCK_LABEL_52;
        return DataManager.feedsDbConn.getVideoInfo(s, "videoURLMed", "events");
    }

    public void initWithAdobePassContentProviderId(String s, String s1)
    {
        (new EPSDKPrefs()).putField("startSession", "adobepasscontentproviderid", s);
        (new EPSDKPrefs()).putField("startSession", "resource", s1);
        (new EPSDKPrefs()).putField("startSession", "tokenType", "ADOBEPASS");
        (new EPSDKPrefs()).putField("startSession", "inittype", "3");
        (new EPSDKPrefs()).putField("startSession", "startsessioncookie", "");
    }

    public void initWithToken(String s)
    {
        (new EPSDKPrefs()).putField("startSession", "token", s);
        (new EPSDKPrefs()).putField("startSession", "inittype", "2");
        (new EPSDKPrefs()).putField("startSession", "startsessioncookie", "");
    }

    public void initWithUDID(String s, String s1)
    {
        (new EPSDKPrefs()).putField("startSession", "udid", s);
        (new EPSDKPrefs()).putField("startSession", "startsessioncookie", s1);
        (new EPSDKPrefs()).putField("startSession", "tokenType", "DEVICE");
        (new EPSDKPrefs()).putField("startSession", "inittype", "1");
    }

    public void initiateLiveEventSessionForLinearNetwork(String s)
    {
        if (s.equalsIgnoreCase("espn1") || s.equalsIgnoreCase("espn2") || s.equalsIgnoreCase("espnu") || s.equalsIgnoreCase("espnews") || s.equalsIgnoreCase("espndeportes") || s.equalsIgnoreCase("sec") || s.equalsIgnoreCase("longhorn"))
        {
            (new FeedsManagerAPI(new FeedsCommListener() {

                final EPPlaybackManager this$0;

                public void handleError(int i)
                {
                    playbackManagerLsnr.streamDidFailAuthorizationWithMessage("Unable to retrive live event for linear network");
                }

                public void update(HttpEntity httpentity, String s1)
                {
                }

                public void update(JSONObject jsonobject, String s1, HashMap hashmap)
                {
                    jsonobject = parse(jsonobject);
                    if (jsonobject != null)
                    {
                        initiateStartSessionRequest(jsonobject, true);
                        return;
                    } else
                    {
                        playbackManagerLsnr.streamDidFailAuthorizationWithMessage("Unable to retrive live event for linear network");
                        return;
                    }
                }

            
            {
                this$0 = EPPlaybackManager.this;
                super();
            }
            })).getLiveEventForLinearNetwork(s);
            return;
        } else
        {
            playbackManagerLsnr.streamDidFailAuthorizationWithMessage("Invalid network id");
            return;
        }
    }

    public void initiateStartSessionRequest(String s)
    {
        initiateStartSessionRequest(s, false);
    }

    String parse(JSONObject jsonobject)
    {
        Object obj = null;
        Utils.sdkLog("EPPlaybackManager.parse:", 3, null);
        Object obj1;
        try
        {
            obj1 = jsonobject.getJSONArray("listings");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Utils.sdkLog("EPPlaybackManager.parse: Enable to parse linear event for network", 5, jsonobject);
            return null;
        }
        jsonobject = obj;
        if (((JSONArray) (obj1)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj1 = ((JSONArray) (obj1)).getJSONObject(0);
        jsonobject = obj;
        if (!((JSONObject) (obj1)).has("id"))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        jsonobject = obj;
        if (!((JSONObject) (obj1)).isNull("id"))
        {
            jsonobject = ((JSONObject) (obj1)).getString("id");
        }
        return jsonobject;
    }

    public void releaseSession()
    {
        if (playbackSession != null)
        {
            playbackSession.removeMaintainRequest();
        }
        EPVideoTrackingManager.setEventObj(null);
        EPVideoTrackingManager.setStreamObj(null);
        EPPlayerTrackingManager.setEventObj(null);
    }

    public void setAffiliateID(String s)
    {
        affiliateID = s;
    }

    public void updateAdobePassParamenter(String s, String s1)
    {
        initWithAdobePassContentProviderId(s, s1);
        if (playbackSession != null)
        {
            playbackSession.releaseWaitForUpdateToken();
        }
    }

    public void updateAffiliateToken(String s)
    {
        initWithToken(s);
        if (playbackSession != null)
        {
            playbackSession.releaseWaitForUpdateToken();
        }
    }

    static 
    {
        sdkVersion = (new StringBuilder("&sdkVersion=")).append(ESPNPlayerSdk.SDK_VERSION_FOR_API).toString();
    }

}
