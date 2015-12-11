// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import java.io.IOException;
import java.net.URI;

public interface ResponseHandlerInterface
{

    public abstract Header[] getRequestHeaders();

    public abstract URI getRequestURI();

    public abstract Object getTag();

    public abstract boolean getUsePoolThread();

    public abstract boolean getUseSynchronousMode();

    public abstract void onPostProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse);

    public abstract void onPreProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse);

    public abstract void sendCancelMessage();

    public abstract void sendFailureMessage(int i, Header aheader[], byte abyte0[], Throwable throwable);

    public abstract void sendFinishMessage();

    public abstract void sendProgressMessage(long l, long l1);

    public abstract void sendResponseMessage(HttpResponse httpresponse)
        throws IOException;

    public abstract void sendRetryMessage(int i);

    public abstract void sendStartMessage();

    public abstract void sendSuccessMessage(int i, Header aheader[], byte abyte0[]);

    public abstract void setRequestHeaders(Header aheader[]);

    public abstract void setRequestURI(URI uri);

    public abstract void setTag(Object obj);

    public abstract void setUsePoolThread(boolean flag);

    public abstract void setUseSynchronousMode(boolean flag);
}
