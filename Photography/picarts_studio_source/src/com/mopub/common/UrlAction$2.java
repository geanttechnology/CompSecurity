// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.common:
//            UrlAction, UrlHandler

final class nit> extends UrlAction
{

    protected final void performAction(Context context, Uri uri, UrlHandler urlhandler)
    {
        MoPubLog.d("Link to about page ignored.");
    }

    public final boolean shouldTryHandlingUrl(Uri uri)
    {
        return "about".equals(uri.getScheme());
    }

    bLog(String s, int i, boolean flag)
    {
        super(s, i, flag, null);
    }
}
