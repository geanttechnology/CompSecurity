// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public interface Request
{

    public abstract void addHeader(String s, String s1);

    public abstract HttpMethod getHttpMethod();

    public abstract Class getResponseType();

    public abstract URI getServiceUri();

    public abstract void setHeaders(HttpHeaders httpheaders);
}
