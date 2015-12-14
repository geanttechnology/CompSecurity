// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;
import java.util.concurrent.Callable;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

// Referenced classes of package com.parse:
//            ParseRequest, ProgressCallback

class k
    implements Callable
{

    final ParseRequest this$0;
    final ProgressCallback val$progressCallback;

    public Object call()
        throws Exception
    {
        Object obj;
        try
        {
            obj = ParseRequest.access$100(ParseRequest.this).execute(ParseRequest.access$000(ParseRequest.this));
            obj = onResponse(((org.apache.http.HttpResponse) (obj)), val$progressCallback);
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            throw connectionFailed("bad protocol", clientprotocolexception);
        }
        catch (IOException ioexception)
        {
            throw connectionFailed("i/o failure", ioexception);
        }
        return obj;
    }

    k()
    {
        this$0 = final_parserequest;
        val$progressCallback = ProgressCallback.this;
        super();
    }
}
