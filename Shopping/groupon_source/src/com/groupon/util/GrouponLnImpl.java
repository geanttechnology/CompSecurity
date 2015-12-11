// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.SharedPreferences;
import roboguice.util.LnImpl;

public class GrouponLnImpl extends LnImpl
{

    private static final String DOGFOOD = "dogfood";

    public GrouponLnImpl(Application application, SharedPreferences sharedpreferences)
    {
        byte byte0 = 2;
        super(application);
        if (application.getPackageName().contains("dogfood"))
        {
            setLoggingLevel(2);
        } else
        if (sharedpreferences.contains("debugLogging"))
        {
            if (!sharedpreferences.getBoolean("debugLogging", false))
            {
                byte0 = 4;
            }
            setLoggingLevel(byte0);
            return;
        }
    }
}
