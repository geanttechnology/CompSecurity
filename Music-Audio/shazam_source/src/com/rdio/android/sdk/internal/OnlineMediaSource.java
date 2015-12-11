// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.audioplayer.sources.RdioMediaSource;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.RdioService_Api;
import com.rdio.android.sdk.RdioListener;
import com.rdio.android.sdk.model.Track;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PlayerManagerInternal

public class OnlineMediaSource extends RdioMediaSource
{

    private RdioListener listener;
    private String playbackToken;
    private PlayerManagerInternal playerManager;
    private RdioService_Api rdioService;
    private com.rdio.android.audioplayer.sources.RdioMediaSource.PlaybackInfoRequestArgs requestArgs;
    private Track track;

    public OnlineMediaSource(RdioService_Api rdioservice_api, RdioListener rdiolistener, PlayerManagerInternal playermanagerinternal, com.rdio.android.audioplayer.sources.RdioMediaSource.PlaybackInfoRequestArgs playbackinforequestargs, String s, int i)
    {
        super(i);
        listener = rdiolistener;
        track = null;
        playerManager = playermanagerinternal;
        rdioService = rdioservice_api;
        playbackToken = s;
        requestArgs = playbackinforequestargs;
        start();
    }

    public Track getTrack()
    {
        return track;
    }

    protected void onPrepareUri()
    {
        RdioApiRequestArg rdioapirequestarg = new RdioApiRequestArg("method", "getPlaybackInfo");
        RdioApiRequestArg rdioapirequestarg1 = new RdioApiRequestArg("key", requestArgs.trackKey);
        RdioApiRequestArg rdioapirequestarg2 = new RdioApiRequestArg("sourceKey", requestArgs.parentKey);
        RdioApiRequestArg rdioapirequestarg3 = new RdioApiRequestArg("type", requestArgs.streamQuality);
        RdioApiRequestArg rdioapirequestarg4 = new RdioApiRequestArg("playerName", requestArgs.playerName);
        RdioApiRequestArg rdioapirequestarg5 = new RdioApiRequestArg("manualPlay", Boolean.valueOf(requestArgs.manualPlay));
        RdioApiRequestArg rdioapirequestarg6 = new RdioApiRequestArg("playbackToken", playbackToken);
        RdioApiRequestArg rdioapirequestarg7 = new RdioApiRequestArg("requiresUnlimited", Boolean.valueOf(true));
        RdioService_Api rdioservice_api = rdioService;
        com.rdio.android.core.RdioService_Api.ResponseListener responselistener = new com.rdio.android.core.RdioService_Api.ResponseListener() {

            final OnlineMediaSource this$0;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (!rdioapiresponse.isSuccess())
                {
                    playerManager.updateCurrentState(PlaybackStateChangedEvent.State.Error);
                    listener.onError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("There was an error trying to retrieve playback info for ")).append(requestArgs.trackKey).toString());
                    return;
                }
                rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
                track = Track.extractTrack(rdioapiresponse);
                com.rdio.android.audioplayer.sources.RdioMediaSource.PlaybackInfo playbackinfo = new com.rdio.android.audioplayer.sources.RdioMediaSource.PlaybackInfo();
                boolean flag;
                try
                {
                    playbackinfo.uri = rdioapiresponse.getString("surl");
                    playbackinfo.trackDuration = rdioapiresponse.getInt("duration");
                    playbackinfo.streamType = rdioapiresponse.getString("streamType");
                    flag = rdioapiresponse.getBoolean("canStream");
                }
                // Misplaced declaration of an exception variable
                catch (RdioApiResponse rdioapiresponse)
                {
                    playerManager.updateCurrentState(PlaybackStateChangedEvent.State.Error);
                    listener.onError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("Error encountered when trying to read metadata for track key ")).append(requestArgs.trackKey).append(" : ").append(rdioapiresponse).toString());
                    return;
                }
                if (playbackinfo.uri == null)
                {
                    destroy();
                    playerManager.updateCurrentState(PlaybackStateChangedEvent.State.Error);
                    listener.onError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("No uri provided when looking up track key ")).append(requestArgs.trackKey).toString());
                    return;
                }
                if (!flag)
                {
                    playerManager.updateCurrentState(PlaybackStateChangedEvent.State.Error);
                    listener.onError(com.rdio.android.sdk.Rdio.RdioError.CANNOT_STREAM, (new StringBuilder("Track key ")).append(requestArgs.trackKey).append(" is not not streamable for this user").toString());
                    return;
                } else
                {
                    onUriPrepared(playbackinfo.uri, playbackinfo.streamType, playbackinfo.trackDuration);
                    return;
                }
            }

            
            {
                this$0 = OnlineMediaSource.this;
                super();
            }
        };
        rdioservice_api.postRequest(new RdioApiRequestArg[] {
            rdioapirequestarg, rdioapirequestarg1, rdioapirequestarg2, rdioapirequestarg3, rdioapirequestarg4, rdioapirequestarg5, rdioapirequestarg6, rdioapirequestarg7
        }, responselistener);
    }





/*
    static Track access$302(OnlineMediaSource onlinemediasource, Track track1)
    {
        onlinemediasource.track = track1;
        return track1;
    }

*/

}
