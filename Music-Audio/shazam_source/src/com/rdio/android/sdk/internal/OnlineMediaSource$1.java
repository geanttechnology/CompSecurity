// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.sdk.RdioListener;
import com.rdio.android.sdk.model.Track;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            OnlineMediaSource, PlayerManagerInternal

class this._cls0
    implements com.rdio.android.core.onseListener
{

    final OnlineMediaSource this$0;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (!rdioapiresponse.isSuccess())
        {
            OnlineMediaSource.access$000(OnlineMediaSource.this).updateCurrentState(Event.State.Error);
            OnlineMediaSource.access$200(OnlineMediaSource.this).onError(com.rdio.android.sdk._LOOKUP, (new StringBuilder("There was an error trying to retrieve playback info for ")).append(OnlineMediaSource.access$100(OnlineMediaSource.this).trackKey).toString());
            return;
        }
        rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
        OnlineMediaSource.access$302(OnlineMediaSource.this, Track.extractTrack(rdioapiresponse));
        com.rdio.android.audioplayer.sources.backInfo backinfo = new com.rdio.android.audioplayer.sources.backInfo();
        boolean flag;
        try
        {
            backinfo.uri = rdioapiresponse.getString("surl");
            backinfo.trackDuration = rdioapiresponse.getInt("duration");
            backinfo.streamType = rdioapiresponse.getString("streamType");
            flag = rdioapiresponse.getBoolean("canStream");
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiResponse rdioapiresponse)
        {
            OnlineMediaSource.access$000(OnlineMediaSource.this).updateCurrentState(Event.State.Error);
            OnlineMediaSource.access$200(OnlineMediaSource.this).onError(com.rdio.android.sdk._LOOKUP, (new StringBuilder("Error encountered when trying to read metadata for track key ")).append(OnlineMediaSource.access$100(OnlineMediaSource.this).trackKey).append(" : ").append(rdioapiresponse).toString());
            return;
        }
        if (backinfo.uri == null)
        {
            destroy();
            OnlineMediaSource.access$000(OnlineMediaSource.this).updateCurrentState(Event.State.Error);
            OnlineMediaSource.access$200(OnlineMediaSource.this).onError(com.rdio.android.sdk._LOOKUP, (new StringBuilder("No uri provided when looking up track key ")).append(OnlineMediaSource.access$100(OnlineMediaSource.this).trackKey).toString());
            return;
        }
        if (!flag)
        {
            OnlineMediaSource.access$000(OnlineMediaSource.this).updateCurrentState(Event.State.Error);
            OnlineMediaSource.access$200(OnlineMediaSource.this).onError(com.rdio.android.sdk.T_STREAM, (new StringBuilder("Track key ")).append(OnlineMediaSource.access$100(OnlineMediaSource.this).trackKey).append(" is not not streamable for this user").toString());
            return;
        } else
        {
            OnlineMediaSource.access$400(OnlineMediaSource.this, backinfo.uri, backinfo.streamType, backinfo.trackDuration);
            return;
        }
    }

    ce.PlaybackInfo()
    {
        this$0 = OnlineMediaSource.this;
        super();
    }
}
