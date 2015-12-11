// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.groupon.service.AttributionService;
import com.groupon.tracking.mobile.sdk.Logger;
import oauth.signpost.OAuth;
import oauth.signpost.http.HttpParameters;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class InstallTracker extends BroadcastReceiver
{

    private AttributionService attributionService;
    private Logger logger;
    private SharedPreferences sharedPreferences;

    public InstallTracker()
    {
    }

    protected String getFacebookAttributionId(Context context)
    {
        String s;
        boolean flag;
        try
        {
            Uri uri = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            context = context.getContentResolver().query(uri, new String[] {
                "aid"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Ln.e(context);
            return null;
        }
        if (context == null)
        {
            return null;
        }
        flag = context.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        context.close();
        return null;
        s = context.getString(context.getColumnIndex("aid"));
        context.close();
        return s;
        Exception exception;
        exception;
        context.close();
        throw exception;
    }

    public void onReceive(Context context, Intent intent)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        if (intent == null || !Strings.equalsIgnoreCase("com.android.vending.INSTALL_REFERRER", intent.getAction()))
        {
            return;
        }
        String s1 = intent.getStringExtra("referrer");
        HttpParameters httpparameters = OAuth.decodeForm(s1);
        String s = httpparameters.getFirst("grpn_dl");
        intent = s;
        if (Strings.notEmpty(s))
        {
            intent = (new StringBuilder()).append("grpn_dl:").append(s).toString();
        }
        s = getFacebookAttributionId(context);
        context = s;
        if (Strings.notEmpty(s))
        {
            context = (new StringBuilder()).append("fbAttributionId:").append(s).toString();
        }
        context = Strings.join(",", new String[] {
            context, intent
        });
        attributionService.setDownloadAttribution(s1, context, httpparameters.getFirst("cid"));
        logger.logGeneralEvent("download_attribution_set", s1, "", 0, Logger.NULL_NST_FIELD);
        logger.logFirstLaunchAfterDownload("", attributionService.getAttributionDownloadUrl(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), "true", Logger.NULL_NST_FIELD);
        logger.forceLogRotate();
        sharedPreferences.edit().putBoolean("attributionFirstLaunchRecorded", true).apply();
    }
}
