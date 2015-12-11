// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.d.p;
import com.google.api.a.d.s;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core:
//            RdioApiResponse, OAuth2RdioService, OAuth2Session

class val.jsonResponse
    implements Runnable
{

    final val.response this$1;
    final JSONObject val$jsonResponse;
    final s val$response;

    public void run()
    {
        if (listener != null)
        {
            listener.onResponse(RdioApiResponse.responseFactory(val$response.c, val$jsonResponse, val$response.e.c));
        }
    }

    seListener()
    {
        this$1 = final_selistener;
        val$response = s1;
        val$jsonResponse = JSONObject.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/core/OAuth2RdioService$2

/* anonymous class */
    class OAuth2RdioService._cls2
        implements Callable
    {

        final OAuth2RdioService this$0;
        final RdioService_Api.ResponseListener val$listener;
        final p val$request;

        public volatile Object call()
        {
            return call();
        }

        public JSONObject call()
        {
            try
            {
                final s response = request.a();
                JSONObject jsonobject = new JSONObject(response.e());
                OAuth2RdioService.access$000(OAuth2RdioService.this).dispatchAsyncResult(jsonobject. new OAuth2RdioService._cls2._cls1());
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            return null;
        }

            
            {
                this$0 = final_oauth2rdioservice;
                request = p1;
                listener = RdioService_Api.ResponseListener.this;
                super();
            }
    }

}
