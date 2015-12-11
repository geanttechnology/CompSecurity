// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import android.util.Log;
import org.json.JSONArray;

// Referenced classes of package com.omniata.android.sdk:
//            OmniataChannelResponseHandler

public class OmniataChannelEngine
    implements OmniataChannelResponseHandler
{

    private static String TAG = "OmniataChannelEngine";
    public static JSONArray channelMessage = null;

    public OmniataChannelEngine()
    {
    }

    public void onError(int i, Exception exception)
    {
        Log.i("Omniata Log", "Channel info retrieved failed");
        Log.e("Omniata Log", exception.toString());
    }

    public void onSuccess(int i, JSONArray jsonarray)
    {
        channelMessage = jsonarray;
    }

}
