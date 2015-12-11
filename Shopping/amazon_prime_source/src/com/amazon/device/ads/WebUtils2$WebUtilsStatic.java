// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            WebUtils2, WebUtils

private static class <init>
{

    String encloseHtml(String s, boolean flag)
    {
        return WebUtils.encloseHtml(s, flag);
    }

    void executeWebRequestInThread(String s, boolean flag)
    {
        WebUtils.executeWebRequestInThread(s, flag);
    }

    String getScheme(String s)
    {
        return WebUtils.getScheme(s);
    }

    String getURLDecodedString(String s)
    {
        return WebUtils.getURLDecodedString(s);
    }

    String getURLEncodedString(String s)
    {
        return WebUtils.getURLEncodedString(s);
    }

    boolean launchActivityForIntentLink(String s, Context context)
    {
        return WebUtils.launchActivityForIntentLink(s, context);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
