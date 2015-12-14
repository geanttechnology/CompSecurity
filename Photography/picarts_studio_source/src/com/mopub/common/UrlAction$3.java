// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.util.Intents;

// Referenced classes of package com.mopub.common:
//            UrlAction, UrlHandler

final class nit> extends UrlAction
{

    protected final void performAction(Context context, Uri uri, UrlHandler urlhandler)
    {
        Intents.launchActionViewIntent(context, uri, (new StringBuilder("Could not handle intent with URI: ")).append(uri).append("\n\tIs this intent supported on your phone?").toString());
    }

    public final boolean shouldTryHandlingUrl(Uri uri)
    {
        uri = uri.getScheme();
        return "tel".equals(uri) || "voicemail".equals(uri) || "sms".equals(uri) || "mailto".equals(uri) || "geo".equals(uri) || "google.streetview".equals(uri);
    }

    (String s, int i, boolean flag)
    {
        super(s, i, flag, null);
    }
}
