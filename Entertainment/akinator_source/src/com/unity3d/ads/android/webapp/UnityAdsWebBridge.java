// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.unity3d.ads.android.webapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.unity3d.ads.android.UnityAdsDeviceLog;
import com.unity3d.ads.android.properties.UnityAdsProperties;
import org.json.JSONObject;

// Referenced classes of package com.unity3d.ads.android.webapp:
//            b, a, IUnityAdsWebBridgeListener

public class UnityAdsWebBridge
{

    private IUnityAdsWebBridgeListener a;

    public UnityAdsWebBridge(IUnityAdsWebBridgeListener iunityadswebbridgelistener)
    {
        a = null;
        a = iunityadswebbridgelistener;
    }

    private static b a(String s)
    {
        b ab[] = b.values();
        int j = ab.length;
        for (int i = 0; i < j; i++)
        {
            b b1 = ab[i];
            if (b1.toString().equals(s))
            {
                return b1;
            }
        }

        return null;
    }

    public boolean handleWebEvent(String s, String s1)
    {
        Object obj1;
        obj1 = null;
        UnityAdsDeviceLog.debug((new StringBuilder()).append(s).append(", ").append(s1).toString());
        if (a != null && s1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s1 = new JSONObject(s1);
        Object obj = s1.getJSONObject("data");
_L15:
        if (s1 == null || s == null) goto _L1; else goto _L3
_L3:
        s = a(s);
        if (s == null) goto _L1; else goto _L4
_L4:
        a.a[s.ordinal()];
        JVM INSTR tableswitch 1 9: default 132
    //                   1 165
    //                   2 178
    //                   3 191
    //                   4 204
    //                   5 217
    //                   6 230
    //                   7 243
    //                   8 256
    //                   9 341;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L5:
        return true;
        obj;
        s1 = null;
_L16:
        UnityAdsDeviceLog.error((new StringBuilder("Error while parsing parameters: ")).append(((Exception) (obj)).getMessage()).toString());
        obj = obj1;
          goto _L15
_L6:
        a.onPlayVideo(((JSONObject) (obj)));
          goto _L5
_L7:
        a.onPauseVideo(((JSONObject) (obj)));
          goto _L5
_L8:
        a.onCloseAdsView(((JSONObject) (obj)));
          goto _L5
_L9:
        a.onWebAppLoadComplete(((JSONObject) (obj)));
          goto _L5
_L10:
        a.onWebAppInitComplete(((JSONObject) (obj)));
          goto _L5
_L11:
        a.onOrientationRequest(((JSONObject) (obj)));
          goto _L5
_L12:
        a.onOpenPlayStore(((JSONObject) (obj)));
          goto _L5
_L13:
        if (((JSONObject) (obj)).has("clickUrl"))
        {
            try
            {
                s = ((JSONObject) (obj)).getString("clickUrl");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                UnityAdsDeviceLog.error("Error fetching clickUrl");
                return false;
            }
            if (s != null)
            {
                try
                {
                    s1 = new Intent("android.intent.action.VIEW");
                    s1.setData(Uri.parse(s));
                    UnityAdsProperties.getCurrentActivity().startActivity(s1);
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    UnityAdsDeviceLog.error((new StringBuilder("Could not start activity for opening URL: ")).append(s).append(", maybe malformed URL?").toString());
                }
            }
        }
          goto _L5
_L14:
        a.onLaunchIntent(((JSONObject) (obj)));
          goto _L5
        obj;
          goto _L16
    }
}
