// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import android.net.Uri;
import com.rhythmnewmedia.sdk.display.AdView;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            k, h, i

public class l extends k
    implements h
{

    public l()
    {
    }

    public final i a(Uri uri, Context context, AdView adview, String s, String s1)
    {
        if (!"rhythm.sdk".equals(uri.getHost()) || uri.getQueryParameter("cmd") == null)
        {
            return null;
        } else
        {
            return b(uri, context, adview, s, s1);
        }
    }

    public final i a(Uri uri, AdView adview, String s, String s1)
    {
        Context context;
        if (adview != null)
        {
            context = adview.getContext();
        } else
        {
            context = null;
        }
        return a(uri, context, adview, s, s1);
    }

    public final String a()
    {
        return "net.rnmd.sdk.rhythmAPI";
    }

    public final void a(AdView adview)
    {
        adview.injectJavascript(String.format("net.rnmd.sdk.version='%s';", new Object[] {
            "5.0.1"
        }));
    }

    public final boolean a(String s, AdView adview)
    {
        adview.handleClick(s);
        return true;
    }

    public final void b(AdView adview)
    {
    }

    public final void c(AdView adview)
    {
        adview.injectJavascript("net.rnmd.sdk.rhythmAdDisplayed();");
    }

    public final void d(AdView adview)
    {
    }
}
