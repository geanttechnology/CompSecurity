// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.VolleyOAuth2RdioService;
import com.rdio.android.core.reporting.BaseEventUploader;
import com.rdio.android.core.util.Logging;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventUploader extends BaseEventUploader
{
    private class UploadResponseListener
        implements com.rdio.android.core.RdioService_Api.ResponseListener
    {

        public boolean isSuccess;
        final EventUploader this$0;

        public void onResponse(RdioApiResponse rdioapiresponse)
        {
            if (!rdioapiresponse.isSuccess())
            {
                break MISSING_BLOCK_LABEL_34;
            }
            rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
            if (!rdioapiresponse.has("success"))
            {
                break MISSING_BLOCK_LABEL_64;
            }
            isSuccess = rdioapiresponse.getBoolean("success");
            return;
            rdioapiresponse;
            
// JavaClassFileOutputException: get_constant: invalid tag

        private UploadResponseListener()
        {
            this$0 = EventUploader.this;
            super();
        }

    }


    private String playbackToken;
    private VolleyOAuth2RdioService rdioService;
    private UploadResponseListener responseListener;

    public EventUploader(VolleyOAuth2RdioService volleyoauth2rdioservice, e e, Logging logging)
    {
        BaseEventUploader(e, logging);
        responseListener = new UploadResponseListener();
        rdioService = volleyoauth2rdioservice;
    }

    public void setPlaybackToken(String s)
    {
        playbackToken = s;
    }

    protected boolean uploadEvents(JSONArray jsonarray)
    {
        try
        {
            Object obj = jsonarray.toString();
            jsonarray = new RdioApiRequestArg("method", "uploadEventsWithPlaybackToken");
            RdioApiRequestArg rdioapirequestarg = new RdioApiRequestArg("playback_token", playbackToken);
            obj = new RdioApiRequestArg("event_data", obj);
            VolleyOAuth2RdioService volleyoauth2rdioservice = rdioService;
            UploadResponseListener uploadresponselistener = responseListener;
            volleyoauth2rdioservice.postRequest(new RdioApiRequestArg[] {
                jsonarray, rdioapirequestarg, obj
            }, uploadresponselistener);
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            logging.logException(jsonarray, true);
            return false;
        }
        return true;
    }

}
