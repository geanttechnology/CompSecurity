// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.net.URI;

public interface RedirectHandler
{

    public abstract URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException;

    public abstract boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext);
}
