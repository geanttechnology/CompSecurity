// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.webkit.WebSettings;

// Referenced classes of package android.support.v7:
//            tq

static class gs extends gs
{

    public String a(Context context)
    {
        return WebSettings.getDefaultUserAgent(context);
    }

    public boolean a(Context context, WebSettings websettings)
    {
        super.a(context, websettings);
        websettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    gs()
    {
    }
}
