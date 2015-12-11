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
//            OAuth2RdioService, OAuth2Session, RdioApiResponse

class onseListener
    implements Callable
{

    final OAuth2RdioService this$0;
    final onseListener val$listener;
    final p val$request;

    public volatile Object call()
    {
        return call();
    }

    public JSONObject call()
    {
        try
        {
            final s response = val$request.a();
            final JSONObject jsonResponse = new JSONObject(response.e());
            OAuth2RdioService.access$000(OAuth2RdioService.this).dispatchAsyncResult(new Runnable() {

                final OAuth2RdioService._cls2 this$1;
                final JSONObject val$jsonResponse;
                final s val$response;

                public void run()
                {
                    if (listener != null)
                    {
                        listener.onResponse(RdioApiResponse.responseFactory(response.c, jsonResponse, response.e.c));
                    }
                }

            
            {
                this$1 = OAuth2RdioService._cls2.this;
                response = s1;
                jsonResponse = jsonobject;
                super();
            }
            });
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

    onseListener()
    {
        this$0 = final_oauth2rdioservice;
        val$request = p1;
        val$listener = onseListener.this;
        super();
    }
}
