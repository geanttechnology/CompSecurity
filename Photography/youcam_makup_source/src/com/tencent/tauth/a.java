// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public interface a
{

    public abstract void a(com.tencent.open.utils.HttpUtils.HttpStatusException httpstatusexception);

    public abstract void a(com.tencent.open.utils.HttpUtils.NetworkUnavailableException networkunavailableexception);

    public abstract void a(IOException ioexception);

    public abstract void a(Exception exception);

    public abstract void a(MalformedURLException malformedurlexception);

    public abstract void a(SocketTimeoutException sockettimeoutexception);

    public abstract void a(ConnectTimeoutException connecttimeoutexception);

    public abstract void a(JSONException jsonexception);

    public abstract void a(JSONObject jsonobject);
}
