// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.constants;

import java.util.UUID;

public final class WebConstants
{

    private static volatile String sWebViewUrlKey = null;

    private WebConstants()
    {
    }

    public static String getWebViewUrlKey()
    {
        com/amazon/mobile/mash/constants/WebConstants;
        JVM INSTR monitorenter ;
        String s;
        if (sWebViewUrlKey == null)
        {
            sWebViewUrlKey = UUID.randomUUID().toString();
        }
        s = sWebViewUrlKey;
        com/amazon/mobile/mash/constants/WebConstants;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

}
