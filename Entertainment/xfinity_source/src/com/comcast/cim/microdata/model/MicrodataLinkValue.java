// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import java.net.URI;
import java.util.Map;

public interface MicrodataLinkValue
{

    public abstract String getBaseUrl();

    public abstract String getContentType();

    public abstract String getHref();

    public abstract String getName();

    public abstract String getTitle();

    public abstract boolean isTemplated();

    public abstract URI resolve();

    public abstract URI resolve(Map map);
}
