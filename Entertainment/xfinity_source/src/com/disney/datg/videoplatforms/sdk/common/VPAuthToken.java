// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.common;

import java.util.HashMap;
import java.util.Map;

public class VPAuthToken
{

    private Map tokenParameters;

    public VPAuthToken()
    {
        tokenParameters = new HashMap();
    }

    public Map getTokenParameters()
    {
        return tokenParameters;
    }

    public void setTokenParameters(Map map)
    {
        tokenParameters = map;
    }
}
