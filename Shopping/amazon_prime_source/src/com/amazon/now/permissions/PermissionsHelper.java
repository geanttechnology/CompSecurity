// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.permissions;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import com.amazon.now.AmazonActivity;
import com.amazon.shopapp.voice.search.VoiceSearchController;

public class PermissionsHelper
{

    public PermissionsHelper()
    {
    }

    public static void handlePermissionRequestResult(AmazonActivity amazonactivity, int i, String as[], int ai[])
    {
        i;
        JVM INSTR tableswitch 9551 9551: default 20
    //                   9551 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (ai.length > 0 && ai[0] == 0)
        {
            VoiceSearchController.startVoiceSearch(amazonactivity, false);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static void launchVoiceSearch(AmazonActivity amazonactivity)
    {
        if (ContextCompat.checkSelfPermission(amazonactivity, "android.permission.RECORD_AUDIO") == 0)
        {
            VoiceSearchController.startVoiceSearch(amazonactivity, false);
            return;
        } else
        {
            requestPermission(amazonactivity, "android.permission.RECORD_AUDIO", 9551);
            return;
        }
    }

    private static void requestPermission(AmazonActivity amazonactivity, String s, int i)
    {
        ActivityCompat.requestPermissions(amazonactivity, new String[] {
            s
        }, i);
    }
}
