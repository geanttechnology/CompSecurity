// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpResponseHandler

static final class a extends Handler
{

    private final WeakReference a;

    public final void handleMessage(Message message)
    {
        AsyncHttpResponseHandler asynchttpresponsehandler = (AsyncHttpResponseHandler)a.get();
        if (asynchttpresponsehandler != null)
        {
            asynchttpresponsehandler.handleMessage(message);
        }
    }

    (AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        a = new WeakReference(asynchttpresponsehandler);
    }
}
