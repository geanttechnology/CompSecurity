// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.parse:
//            ManifestInfo, ParseInstallation

class ParsePushChannelsController
{

    static final String V2_PUSH_NOT_CONFIGURED = "In order to use the ParsePush.subscribe or ParsePush.unsubscribe methods you must add the following to your AndroidManifest.xml: \n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"\n  android:exported=\"false\">\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>\n(Replace \"com.parse.ParsePushBroadcastReceiver\" with your own implementation if you choose to extend ParsePushBroadcastReceiver)";

    ParsePushChannelsController()
    {
    }

    static void checkForManifestAndThrowExceptionIfNeeded()
    {
        if (!ManifestInfo.getPushUsesBroadcastReceivers())
        {
            throw new IllegalStateException("In order to use the ParsePush.subscribe or ParsePush.unsubscribe methods you must add the following to your AndroidManifest.xml: \n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"\n  android:exported=\"false\">\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>\n(Replace \"com.parse.ParsePushBroadcastReceiver\" with your own implementation if you choose to extend ParsePushBroadcastReceiver)");
        } else
        {
            return;
        }
    }

    public cu subscribeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Can't subscribe to null channel.");
        }
        checkForManifestAndThrowExceptionIfNeeded();
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        List list = parseinstallation.getList("channels");
        if (list == null || parseinstallation.isDirty("channels") || !list.contains(s))
        {
            parseinstallation.addUnique("channels", s);
            return parseinstallation.saveInBackground();
        } else
        {
            return cu.a(null);
        }
    }

    public cu unsubscribeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Can't unsubscribe from null channel.");
        }
        checkForManifestAndThrowExceptionIfNeeded();
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        List list = parseinstallation.getList("channels");
        if (list != null && list.contains(s))
        {
            parseinstallation.removeAll("channels", Arrays.asList(new String[] {
                s
            }));
            return parseinstallation.saveInBackground();
        } else
        {
            return cu.a(null);
        }
    }
}
