// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.os.Handler;
import com.espn.androidplayersdk.playbackmanager.EPPlaybackManagerListener;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsCommListener, FeedsManagerAPI, EPSDKPrefs, EPStream, 
//            EPPlayerTrackingManager, EPPlaybackManager

class ProgramingChangeTask
    implements FeedsCommListener
{

    final int defaultInterval = 60000;
    private boolean didProgramChanged;
    EPPlaybackManager epPlaybackManager;
    EPPlaybackManagerListener epPlaybackManagerListener;
    EPStream epStream;
    FeedsManagerAPI feedsManager;
    int pollingInterval;
    private boolean poolingTaskCancelled;
    Runnable programingChangeTask;
    Handler programingChangeTaskHandler;

    ProgramingChangeTask(EPStream epstream, EPPlaybackManagerListener epplaybackmanagerlistener, Handler handler, EPPlaybackManager epplaybackmanager)
    {
        didProgramChanged = false;
        poolingTaskCancelled = false;
        pollingInterval = 0;
        programingChangeTask = new Runnable() {

            final ProgramingChangeTask this$0;

            public void run()
            {
                try
                {
                    feedsManager.getProgramingChangeResponse((new StringBuilder(String.valueOf(epStream.getProgramChangeUrl()))).append("&").append(EPSDKPrefs.getApiKey()).append("&v=2.0.0").toString());
                    return;
                }
                catch (Exception exception)
                {
                    Utils.sdkLog("URL encoding failed", 5, exception);
                }
            }

            
            {
                this$0 = ProgramingChangeTask.this;
                super();
            }
        };
        feedsManager = new FeedsManagerAPI(this);
        epStream = epstream;
        epPlaybackManagerListener = epplaybackmanagerlistener;
        programingChangeTaskHandler = handler;
        epPlaybackManager = epplaybackmanager;
    }

    void cancel()
    {
        poolingTaskCancelled = true;
        programingChangeTaskHandler.removeCallbacks(programingChangeTask);
    }

    boolean didProgramChanged()
    {
        return didProgramChanged;
    }

    int getPollingInterval()
    {
        int i;
        try
        {
            i = Integer.parseInt(EPSDKPrefs.getApiConfigPoolingInterval());
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Unable to retrive polling interval. Setting to default", 5, exception);
            return 60000;
        }
        return i * 1000;
    }

    public void handleError(int i)
    {
        programingChangeTaskHandler.postDelayed(programingChangeTask, pollingInterval);
    }

    void monitorProgramingChange()
    {
        try
        {
            pollingInterval = getPollingInterval();
            programingChangeTaskHandler.postDelayed(programingChangeTask, pollingInterval);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("checkForProgramingChange", 5, exception);
        }
    }

    String parseEvent(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("listings"))
        {
            jsonobject = jsonobject.getJSONArray("listings");
            if (jsonobject.length() > 0)
            {
                jsonobject = jsonobject.getJSONObject(0);
                if (jsonobject.has("id"))
                {
                    return jsonobject.getString("id");
                }
            }
        }
        return null;
    }

    void resetProgramChangedFlag()
    {
        didProgramChanged = false;
    }

    void update(EPStream epstream)
    {
        if (didProgramChanged)
        {
            programingChangeTaskHandler.removeCallbacks(programingChangeTask);
            epStream = epstream;
            programingChangeTaskHandler.postDelayed(programingChangeTask, pollingInterval);
        }
    }

    public void update(HttpEntity httpentity, String s)
    {
    }

    public void update(JSONObject jsonobject, String s, HashMap hashmap)
    {
        jsonobject = parseEvent(jsonobject);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (!epStream.getEventId().equalsIgnoreCase(jsonobject))
        {
            EPPlayerTrackingManager.getInstance().trackEventConcluded();
            didProgramChanged = true;
            epPlaybackManager.initiateStartSessionRequest(jsonobject);
            return;
        }
        try
        {
            if (!poolingTaskCancelled)
            {
                programingChangeTaskHandler.postDelayed(programingChangeTask, pollingInterval);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Utils.sdkLog("URL encoding failed", 5, jsonobject);
            programingChangeTaskHandler.postDelayed(programingChangeTask, pollingInterval);
        }
        return;
    }
}
