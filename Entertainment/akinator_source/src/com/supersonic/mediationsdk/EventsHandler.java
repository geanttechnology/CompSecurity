// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.supersonic.mediationsdk.sdk.GeneralProperties;
import com.supersonic.mediationsdk.server.HttpFunctions;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class EventsHandler
{
    private class EventsSender
        implements Runnable
    {

        private String mEventsToSend;
        private String mEventsUrl;
        final EventsHandler this$0;

        public void run()
        {
            HttpFunctions.getStringFromPost(mEventsUrl, mEventsToSend);
        }

        public EventsSender(String s, String s1)
        {
            this$0 = EventsHandler.this;
            super();
            mEventsUrl = s;
            mEventsToSend = s1;
        }
    }


    private static EventsHandler mInstance;
    private static boolean mIsEventsSent = false;
    private static boolean mShouldDeleteEvents = false;
    private final int AVAILABILITY_CHANGED = 7;
    private final int DEFAULT_BACKUP_THRESHOLD = 20;
    private final String DEFAULT_EVENTS_URL = "http://delivery.supersonicads.com/mediation/";
    private final int DEFAULT_MAX_NUMBER_OF_EVENTS = 100;
    private final int INIT_REWARDED_VIDEO_CODE = 1;
    private final int INIT_REWARDED_VIDEO_RESULT = 4;
    private final int IS_REWARDED_VIDEO_AVAILABLE_CODE = 3;
    private final String KEY_EVENTS = "events";
    private final String KEY_EVENT_ID = "eventId";
    private final String KEY_PROVIDER = "provider";
    private final String KEY_SESSION_ID = "sessionId";
    private final String KEY_STATUS = "status";
    private final String KEY_TIMESTAMP = "timestamp";
    private final int PAUSE_CODE = 13;
    private final int RELEASE_CODE = 11;
    private final int RESUME_CODE = 12;
    private final int REWARDED_VIDEO_AD_CLOSED = 6;
    private final int REWARDED_VIDEO_AD_OPENED = 5;
    private final String SESSION_DEPTH = "sessionDepth";
    private final String SHARED_PREFERENCES_EVENTS_KEY = "mediation_cached_events";
    private final String SHARED_PREFERENCES_NAME = "Mediation_Shared_Preferences";
    private final int SHOW_REWARDED_VIDEO_CODE = 2;
    private final int VIDEO_AD_CLICKED = 14;
    private final int VIDEO_AD_REWARDED = 10;
    private final int VIDEO_END = 9;
    private final int VIDEO_START = 8;
    private int mBackupThreshold;
    private JSONArray mCollectedEvents;
    private String mEventsUrl;
    private boolean mIsEventsEnabled;
    private int mMaxNumberOfEvents;
    private int mNumOfEventsFromLastSave;
    private int mSessionDepth;
    private String mSessionId;

    private EventsHandler()
    {
        mIsEventsEnabled = true;
        mMaxNumberOfEvents = 100;
        mBackupThreshold = 20;
        mEventsUrl = "http://delivery.supersonicads.com/mediation/";
        initializeState();
    }

    private String createDataToSend(String s)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = GeneralProperties.getProperties().toJSON();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        if (!TextUtils.isEmpty(mSessionId))
        {
            jsonobject.put("sessionId", mSessionId);
        }
        if (!TextUtils.isEmpty(getTimeStamp()))
        {
            jsonobject.put("timestamp", getTimeStamp());
        }
        jsonobject.put("events", s);
        s = jsonobject.toString();
        return s;
    }

    private void createEventWithProvider(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        createEventWithProvider(s, i, null);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void createEventWithProvider(String s, int i, Context context)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsEventsEnabled;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("provider", (new StringBuilder()).append("").append(s).toString());
            setGeneralAttributesAndAdd(jsonobject, i, context);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    private void createEventWithProviderAndStatus(String s, int i, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mIsEventsEnabled;
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("provider", (new StringBuilder()).append("").append(s).toString());
            jsonobject.put("status", flag);
            setGeneralAttributesAndAdd(jsonobject, i, null);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    private String generateUUID()
    {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return (new StringBuilder()).append(s).append(getTimeStamp()).toString();
    }

    public static EventsHandler getHandler()
    {
        com/supersonic/mediationsdk/EventsHandler;
        JVM INSTR monitorenter ;
        EventsHandler eventshandler;
        if (mInstance == null)
        {
            mInstance = new EventsHandler();
        }
        eventshandler = mInstance;
        com/supersonic/mediationsdk/EventsHandler;
        JVM INSTR monitorexit ;
        return eventshandler;
        Exception exception;
        exception;
        throw exception;
    }

    private String getTimeStamp()
    {
        return String.valueOf(System.currentTimeMillis());
    }

    private boolean hasIdAndProvider(JSONObject jsonobject, int i, String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        flag = flag1;
        boolean flag2;
        try
        {
            if (!jsonobject.has("eventId"))
            {
                break MISSING_BLOCK_LABEL_75;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return false;
        }
        flag = flag1;
        if (jsonobject.optInt("eventId") != i)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        flag = flag1;
        if (!jsonobject.has("provider"))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        flag2 = jsonobject.optString("provider").equals(s);
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
    }

    private void initializeState()
    {
        mCollectedEvents = new JSONArray();
        mSessionId = generateUUID();
        mSessionDepth = 1;
        mNumOfEventsFromLastSave = 0;
    }

    private void initializeStateAfterSend()
    {
        mCollectedEvents = new JSONArray();
        mNumOfEventsFromLastSave = 0;
    }

    private boolean isShowRewardedVideoFromMediation(JSONObject jsonobject)
    {
        return hasIdAndProvider(jsonobject, 2, "Mediation");
    }

    private void sendEvents(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(mEventsUrl);
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        mIsEventsSent = true;
        mShouldDeleteEvents = true;
        SupersonicUtils.createAndStartWorker(new EventsSender(mEventsUrl, s), "EventsSender");
        if (true) goto _L2; else goto _L4
_L4:
        s;
        throw s;
    }

    private void setGeneralAttributesAndAdd(JSONObject jsonobject, int i, Context context)
    {
        jsonobject.put("eventId", i);
        jsonobject.put("timestamp", getTimeStamp());
        jsonobject.put("sessionDepth", mSessionDepth);
        mCollectedEvents.put(jsonobject);
        mNumOfEventsFromLastSave = mNumOfEventsFromLastSave + 1;
        if (shouldIncreaseSessionDepth(jsonobject))
        {
            mSessionDepth = mSessionDepth + 1;
        }
        if (shouldSendEvents(jsonobject))
        {
            sendEvents(createDataToSend(mCollectedEvents.toString()));
            initializeStateAfterSend();
            return;
        }
        if (context != null)
        {
            try
            {
                if (shouldSaveEvents(jsonobject))
                {
                    saveEvents(context, createDataToSend(mCollectedEvents.toString()));
                    mNumOfEventsFromLastSave = 0;
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        return;
    }

    private boolean shouldIncreaseSessionDepth(JSONObject jsonobject)
    {
        return hasIdAndProvider(jsonobject, 6, "Mediation");
    }

    private boolean shouldReadAndSendEvents()
    {
        return (mCollectedEvents == null || mCollectedEvents.length() == 0) && !mIsEventsSent;
    }

    private boolean shouldSaveEvents(JSONObject jsonobject)
    {
        boolean flag1 = false;
        if (mCollectedEvents != null && mCollectedEvents.length() > 0)
        {
            boolean flag = flag1;
            if (mNumOfEventsFromLastSave > mBackupThreshold)
            {
                flag = flag1;
                if (hasIdAndProvider(jsonobject, 13, "Mediation"))
                {
                    flag = true;
                }
            }
            return flag;
        } else
        {
            initializeState();
            return false;
        }
    }

    private boolean shouldSendEvents(JSONObject jsonobject)
    {
        return hasIdAndProvider(jsonobject, 6, "Mediation") || mCollectedEvents.length() >= mMaxNumberOfEvents;
    }

    public String getCachedEvents(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        try
        {
            context = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("mediation_cached_events", "");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = "";
        }
        finally
        {
            this;
        }
        return context;
        throw context;
    }

    public void notifyInitRewardedVideo(String s)
    {
        createEventWithProvider(s, 1);
    }

    public void notifyInitRewardedVideoResult(String s, boolean flag)
    {
        createEventWithProviderAndStatus(s, 4, flag);
    }

    public void notifyIsRewardedVideoAvailable(String s, boolean flag)
    {
        createEventWithProviderAndStatus(s, 3, flag);
    }

    public void notifyPause(Context context, String s)
    {
        createEventWithProvider(s, 13, context);
    }

    public void notifyRelease(String s)
    {
        createEventWithProvider(s, 11);
    }

    public void notifyResume(Context context, String s)
    {
        if (!mShouldDeleteEvents) goto _L2; else goto _L1
_L1:
        saveEvents(context, "");
        mShouldDeleteEvents = false;
_L4:
        createEventWithProvider(s, 12);
        return;
_L2:
        if (shouldReadAndSendEvents())
        {
            String s1 = getCachedEvents(context);
            if (!TextUtils.isEmpty(s1))
            {
                sendEvents(s1);
                saveEvents(context, "");
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void notifyShowRewardedVideo(String s)
    {
        createEventWithProvider(s, 2);
    }

    public void notifyVideoAdClicked(String s)
    {
        createEventWithProvider(s, 14);
    }

    public void notifyVideoAdClosed(String s)
    {
        createEventWithProvider(s, 6);
    }

    public void notifyVideoAdOpened(String s)
    {
        createEventWithProvider(s, 5);
    }

    public void notifyVideoAdRewarded(String s)
    {
        createEventWithProvider(s, 10);
    }

    public void notifyVideoAvailabilityChanged(String s, boolean flag)
    {
        createEventWithProviderAndStatus(s, 7, flag);
    }

    public void notifyVideoEnd(String s)
    {
        createEventWithProvider(s, 9);
    }

    public void notifyVideoStart(String s)
    {
        createEventWithProvider(s, 8);
    }

    public void saveEvents(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        try
        {
            context = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            context.putString("mediation_cached_events", s);
            context.apply();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally
        {
            this;
        }
        return;
        throw context;
    }

    public void setBackupThreshold(int i)
    {
        if (i > 0)
        {
            mBackupThreshold = i;
        }
    }

    public void setEventsUrl(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            mEventsUrl = s;
        }
    }

    public void setIsEventsEnabled(boolean flag)
    {
        mIsEventsEnabled = flag;
    }

    public void setMaxNumberOfEvents(int i)
    {
        if (i > 0)
        {
            mMaxNumberOfEvents = i;
        }
    }

}
