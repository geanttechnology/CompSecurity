// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.os.Handler;
import android.os.Looper;
import com.espn.androidplayersdk.objects.EPAuthError;
import com.espn.androidplayersdk.playbackmanager.EPPlaybackManagerListener;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPSDKPrefs, EPPlaybackManager, FeedsManagerAPI, MaintainSession, 
//            ProgramingChangeTask, FeedsCommListener, StartSessionParser, EPVideoTrackingManager, 
//            EPPlayerTrackingManager

class PlaybackSession extends Thread
{

    EPPlaybackManager epPlaybackManager;
    private boolean isSessionCancelled;
    Handler mHandler;
    MaintainSession maintainSession;
    EPPlaybackManagerListener playBackManagerLsnr;
    PlaybackSession playbackSessioMonitor;
    private boolean pollProgramChange;
    ProgramingChangeTask programingChange;
    FeedsCommListener startSessionListener;
    String videoUrl;
    long wait;

    PlaybackSession(String s, EPPlaybackManagerListener epplaybackmanagerlistener, EPPlaybackManager epplaybackmanager, boolean flag)
    {
        pollProgramChange = false;
        isSessionCancelled = false;
        wait = 30000L;
        startSessionListener = new FeedsCommListener() {

            final PlaybackSession this$0;

            public void handleError(int i)
            {
                playBackManagerLsnr.streamDidFailAuthorizationWithMessage("Session authorization failed");
            }

            public void update(HttpEntity httpentity, String s1)
            {
            }

            public void update(JSONObject jsonobject, String s1, HashMap hashmap)
            {
                if (jsonobject == null)
                {
                    break MISSING_BLOCK_LABEL_361;
                }
                s1 = new StartSessionParser();
                hashmap = s1.parse(jsonobject, hashmap);
                if (isSessionCancelled || hashmap == null)
                {
                    break MISSING_BLOCK_LABEL_280;
                }
                jsonobject = s1.getFWToken(hashmap);
                EPVideoTrackingManager.setStreamObj(jsonobject);
                if (maintainSession == null)
                {
                    playBackManagerLsnr.streamAuthorizationSucceeded(jsonobject);
                    maintainSession = new MaintainSession(jsonobject, playBackManagerLsnr, this);
                    maintainSession.maintain();
                    if (pollProgramChange)
                    {
                        programingChange = new ProgramingChangeTask(jsonobject, playBackManagerLsnr, mHandler, epPlaybackManager);
                        programingChange.monitorProgramingChange();
                        return;
                    }
                    break MISSING_BLOCK_LABEL_361;
                }
                try
                {
                    playBackManagerLsnr.streamCookieUpdated(jsonobject);
                    maintainSession.update(jsonobject);
                    if (programingChange != null)
                    {
                        programingChange.update(jsonobject);
                        if (programingChange.didProgramChanged())
                        {
                            EPPlayerTrackingManager.getInstance().trackVideoStart();
                            programingChange.resetProgramChangedFlag();
                            return;
                        }
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    if ((new StringBuilder("PlaybackSession")).append(s1.getMessage()).toString() != null)
                    {
                        jsonobject = s1.getMessage();
                    } else
                    {
                        jsonobject = "";
                    }
                    Utils.sdkLog(jsonobject, 5, s1);
                    playBackManagerLsnr.streamDidFailAuthorizationWithMessage("Session authorization failed");
                    return;
                }
                break MISSING_BLOCK_LABEL_361;
                if (isSessionCancelled)
                {
                    break MISSING_BLOCK_LABEL_361;
                }
                jsonobject = s1.generateErrorObject(jsonobject);
                if (jsonobject == null)
                {
                    break MISSING_BLOCK_LABEL_340;
                }
                if (jsonobject.getType().equalsIgnoreCase("blackout"))
                {
                    playBackManagerLsnr.streamDidEnterBlackout(jsonobject);
                    return;
                }
                playBackManagerLsnr.streamAuthorizationFailedWithError(jsonobject);
                return;
                playBackManagerLsnr.streamDidFailAuthorizationWithMessage("Session authorization failed");
                return;
            }

            
            {
                this$0 = PlaybackSession.this;
                super();
            }
        };
        videoUrl = s;
        playBackManagerLsnr = epplaybackmanagerlistener;
        epPlaybackManager = epplaybackmanager;
        playbackSessioMonitor = this;
        pollProgramChange = flag;
    }

    String getStartSessionParameters()
        throws UnsupportedEncodingException
    {
        String s = (new StringBuilder(String.valueOf((new StringBuilder("&v=2.0.0&platform=")).append(EPSDKPrefs.getPlatformForStartSession()).append(EPPlaybackManager.sdkVersion).append("&partner=").append(EPSDKPrefs.getApiPartnerName()).toString()))).append("&affiliateID=").toString();
        String s1;
        String s2;
        if (epPlaybackManager.getAffiliateID() != null)
        {
            s = (new StringBuilder(String.valueOf(s))).append(epPlaybackManager.getAffiliateID()).toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(s))).append(EPSDKPrefs.getApiPartnerName()).toString();
        }
        s2 = (new EPSDKPrefs()).getField("startSession", "inittype");
        if ("1".equals(s2))
        {
            s1 = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s))).append("&token=").append(Utils.toBase64fromString((new EPSDKPrefs()).getField("startSession", "udid"))).toString()))).append("&tokenType=").append((new EPSDKPrefs()).getField("startSession", "tokenType")).toString();
        } else
        {
            if ("2".equals(s2))
            {
                return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s))).append("&token=").append(Utils.toBase64fromString((new EPSDKPrefs()).getField("startSession", "token"))).toString()))).append("&tokenType=").append((new EPSDKPrefs()).getField("startSession", "affiliate")).toString();
            }
            s1 = s;
            if ("3".equals(s2))
            {
                return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s))).append("&token=").append(Utils.toBase64fromString((new EPSDKPrefs()).getField("startSession", "adobepasscontentproviderid"))).toString()))).append("&tokenType=").append((new EPSDKPrefs()).getField("startSession", "tokenType")).toString()))).append("&resource=").append(Utils.toBase64fromString((new EPSDKPrefs()).getField("startSession", "resource"))).toString();
            }
        }
        return s1;
    }

    protected void initiateStartSessionRequest()
    {
        PlaybackSession playbacksession = playbackSessioMonitor;
        playbacksession;
        JVM INSTR monitorenter ;
        if (playBackManagerLsnr.shouldWaitForUpdatedAdobePassParams() || playBackManagerLsnr.shouldWaitForUpdatedAffiliateToken())
        {
            Utils.sdkLog("Waiting for updated AuthZtoken", 2, null);
            wait(wait);
        }
          goto _L1
        exception1;
        playbackSessioMonitor.notifyAll();
        if ((new StringBuilder("PlaybackSession")).append(exception1.getMessage()).toString() == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        obj = exception1.getMessage();
_L2:
        Utils.sdkLog(((String) (obj)), 5, exception1);
          goto _L1
        obj;
        playbacksession;
        JVM INSTR monitorexit ;
        throw obj;
_L1:
        {
            Object obj;
            Exception exception1;
            try
            {
                videoUrl = (new StringBuilder(String.valueOf(videoUrl))).append(getStartSessionParameters()).toString();
                (new FeedsManagerAPI(startSessionListener)).getStartSessionResponse(videoUrl);
                return;
            }
            catch (Exception exception)
            {
                if ((new StringBuilder("PlaybackSession")).append(exception.getMessage()).toString() != null)
                {
                    obj = exception.getMessage();
                } else
                {
                    obj = "";
                }
            }
            Utils.sdkLog(((String) (obj)), 5, exception);
            playBackManagerLsnr.streamDidFailAuthorizationWithMessage("Session authorization failed");
            return;
        }
        obj = "";
          goto _L2
    }

    protected void releaseWaitForUpdateToken()
    {
        if (playbackSessioMonitor != null)
        {
            synchronized (playbackSessioMonitor)
            {
                playbackSessioMonitor.notifyAll();
            }
            return;
        } else
        {
            return;
        }
        exception;
        playbacksession;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void removeMaintainRequest()
    {
        String s;
        try
        {
            isSessionCancelled = true;
            if (maintainSession != null)
            {
                maintainSession.cancel();
            }
            if (programingChange != null)
            {
                programingChange.cancel();
            }
            if (Looper.myLooper() != null)
            {
                mHandler.post(new Runnable() {

                    final PlaybackSession this$0;

                    public void run()
                    {
                        Looper.myLooper().quit();
                    }

            
            {
                this$0 = PlaybackSession.this;
                super();
            }
                });
            }
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("PlaybackSession")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, exception);
    }

    public void run()
    {
        super.run();
        String s;
        try
        {
            Looper.prepare();
            mHandler = new Handler();
            initiateStartSessionRequest();
            Looper.loop();
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("PlaybackSession")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, exception);
    }

    void updateVideoUrlForSessionChange(String s)
    {
        videoUrl = s;
    }


}
