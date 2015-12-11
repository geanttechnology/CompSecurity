// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.rating.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.module.rating.IRatingProvider;
import java.util.Map;

public class GooglePlayRatingProvider
    implements IRatingProvider
{

    public GooglePlayRatingProvider()
    {
    }

    public String activityNotFoundMessage(Context context)
    {
        return context.getString(com.apptentive.android.sdk.R.string.apptentive_rating_provider_no_google_play);
    }

    public void startRating(Context context, Map map)
    {
        if (!map.containsKey("package"))
        {
            String s = context.getPackageName();
            Log.w("Rating provider args did not contain package name. Adding default package: \"%s\"", new Object[] {
                s
            });
            map.put("package", s);
        }
        map = Uri.parse((new StringBuilder("market://details?id=")).append((String)map.get("package")).toString());
        Log.i("Opening app store for rating with URI: \"%s\"", new Object[] {
            map
        });
        map = new Intent("android.intent.action.VIEW", map);
        map.setFlags(0x50080000);
        context.startActivity(map);
    }
}
