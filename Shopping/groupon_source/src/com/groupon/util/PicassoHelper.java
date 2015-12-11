// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import com.groupon.service.core.AbTestService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.imageservice.ImageServiceHelper;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.twinprime.TwinPrimeSDK.TPURLConnection;
import com.twinprime.TwinPrimeSDK.TwinPrimeSDK;
import java.io.IOException;
import java.net.HttpURLConnection;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class PicassoHelper
{
    private static class PicassoDownloader extends OkHttpDownloader
    {

        private boolean isTwinPrimeEnabled;
        private Logger logger;

        public com.squareup.picasso.Downloader.Response load(Uri uri, boolean flag)
            throws IOException
        {
            long l = SystemClock.elapsedRealtime();
            com.squareup.picasso.Downloader.Response response = super.load(uri, flag);
            long l1 = SystemClock.elapsedRealtime();
            Logger logger1 = logger;
            String s = PicassoHelper.TWIN_PRIME_EVENT_CATEGORY;
            if (isTwinPrimeEnabled)
            {
                uri = PicassoHelper.TWIN_PRIME_ON;
            } else
            {
                uri = PicassoHelper.TWIN_PRIME_OFF;
            }
            logger1.logGeneralEvent(s, uri, null, (int)(l1 - l), null);
            return response;
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
            PicassoHelper.imageServiceHelper.addImageServiceAuthenticationHeader(uri);
            return uri;
        }

        public PicassoDownloader(Context context, boolean flag)
        {
            super(context);
            logger = (Logger)RoboGuice.getInjector(context).getInstance(com/groupon/tracking/mobile/sdk/Logger);
            isTwinPrimeEnabled = flag;
        }
    }


    private static String TWIN_PRIME_EVENT_CATEGORY = "TwinPrimeTest";
    private static String TWIN_PRIME_OFF = "off";
    private static String TWIN_PRIME_ON = "on";
    private static ImageServiceHelper imageServiceHelper;
    private static volatile Picasso picasso = null;

    public PicassoHelper()
    {
    }

    public static Picasso getPicasso(Context context)
    {
        byte byte0 = 0;
        if (picasso != null) goto _L2; else goto _L1
_L1:
        com/squareup/picasso/Picasso;
        JVM INSTR monitorenter ;
        SharedPreferences sharedpreferences;
        boolean flag;
        if (picasso != null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        AbTestService abtestservice = (AbTestService)RoboGuice.getInjector(context).getInstance(com/groupon/service/core/AbTestService);
        sharedpreferences = (SharedPreferences)RoboGuice.getInjector(context).getInstance(android/content/SharedPreferences);
        flag = abtestservice.isVariantEnabled("twinPrime1509", "on");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        new TwinPrimeSDK(context, "532c0ddd-eaae-4eb8-951b-97111406e4c4-14b41c9-1e");
        if (sharedpreferences.getBoolean("debugLogging", false))
        {
            byte0 = 5;
        }
        TwinPrimeSDK.setLogLevel(byte0);
        picasso = (new com.squareup.picasso.Picasso.Builder(context)).downloader(new PicassoDownloader(context, flag)).build();
        imageServiceHelper = new ImageServiceHelper((Application)context.getApplicationContext(), "andcon", "22c71c933564d8e703820d087c71b1d49db4f2ad");
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
_L2:
        return picasso;
        context;
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static RequestCreator request565Bitmap(RequestCreator requestcreator, String s)
    {
        if (s.toLowerCase().endsWith(".jpg"))
        {
            requestcreator.config(android.graphics.Bitmap.Config.RGB_565);
        }
        return requestcreator;
    }





}
