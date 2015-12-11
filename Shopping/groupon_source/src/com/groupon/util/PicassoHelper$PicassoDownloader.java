// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.imageservice.ImageServiceHelper;
import com.squareup.picasso.OkHttpDownloader;
import com.twinprime.TwinPrimeSDK.TPURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.util:
//            PicassoHelper

private static class isTwinPrimeEnabled extends OkHttpDownloader
{

    private boolean isTwinPrimeEnabled;
    private Logger logger;

    public com.squareup.picasso.inPrimeEnabled load(Uri uri, boolean flag)
        throws IOException
    {
        long l = SystemClock.elapsedRealtime();
        com.squareup.picasso.inPrimeEnabled inprimeenabled = super.load(uri, flag);
        long l1 = SystemClock.elapsedRealtime();
        Logger logger1 = logger;
        String s = PicassoHelper.access$000();
        if (isTwinPrimeEnabled)
        {
            uri = PicassoHelper.access$100();
        } else
        {
            uri = PicassoHelper.access$200();
        }
        logger1.logGeneralEvent(s, uri, null, (int)(l1 - l), null);
        return inprimeenabled;
    }

    protected HttpURLConnection openConnection(Uri uri)
        throws IOException
    {
        if (isTwinPrimeEnabled)
        {
            uri = (HttpURLConnection)TPURLConnection.openConnection(uri.toString());
        } else
        {
            uri = super.openConnection(uri);
        }
        PicassoHelper.access$300().addImageServiceAuthenticationHeader(uri);
        return uri;
    }

    public (Context context, boolean flag)
    {
        super(context);
        logger = (Logger)RoboGuice.getInjector(context).getInstance(com/groupon/tracking/mobile/sdk/Logger);
        isTwinPrimeEnabled = flag;
    }
}
