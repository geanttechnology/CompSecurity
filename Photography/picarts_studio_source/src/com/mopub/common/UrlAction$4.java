// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

// Referenced classes of package com.mopub.common:
//            UrlAction, UrlHandler

final class nit> extends UrlAction
{

    protected final void performAction(Context context, Uri uri, UrlHandler urlhandler)
    {
        urlhandler = (new StringBuilder("Unable to load mopub native browser url: ")).append(uri).toString();
        try
        {
            Intents.launchIntentForUserClick(context, Intents.intentForNativeBrowserScheme(uri), urlhandler);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IntentNotResolvableException((new StringBuilder()).append(urlhandler).append("\n\t").append(context.getMessage()).toString());
        }
    }

    public final boolean shouldTryHandlingUrl(Uri uri)
    {
        return "mopubnativebrowser".equals(uri.getScheme());
    }

    Exception(String s, int i, boolean flag)
    {
        super(s, i, flag, null);
    }
}
