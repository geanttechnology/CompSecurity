// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.client;

import com.comcast.cim.microdata.exception.MicrodataConversionException;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.io.InputStream;

public interface HypermediaClient
{

    public abstract boolean isAutomaticNetworkLoadingEnabled();

    public abstract MicrodataItem parseResource(String s, InputStream inputstream, String s1)
        throws MicrodataConversionException;
}
