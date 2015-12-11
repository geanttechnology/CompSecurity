// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.error.VideoError;
import com.amazon.mobile.mash.util.Util;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHVideoPlaybackPlugin

class val.callbackContext
    implements Runnable
{

    final MASHVideoPlaybackPlugin this$0;
    final JSONArray val$args;
    final CallbackContext val$callbackContext;

    public void run()
    {
        Object obj = new Intent("android.intent.action.VIEW");
        Object obj1;
        try
        {
            obj1 = val$args.getString(0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            MASHVideoPlaybackPlugin.access$000(MASHVideoPlaybackPlugin.this, (new StringBuilder()).append("Malformed parameters: ").append(val$args).toString());
            return;
        }
        if (Util.isUrlMalformed(((String) (obj1))))
        {
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            MASHVideoPlaybackPlugin.access$000(MASHVideoPlaybackPlugin.this, (new StringBuilder()).append("Malformed parameters: ").append(val$args).toString());
            return;
        }
        ((Intent) (obj)).setDataAndType(Uri.parse(((String) (obj1))), "video/mp4");
        obj1 = webView.getContext().getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000);
        if (obj1 == null || ((List) (obj1)).isEmpty())
        {
            val$callbackContext.error(VideoError.NO_VIDEO_PLAYER_FOUND.toJSONObject());
            MASHVideoPlaybackPlugin.access$000(MASHVideoPlaybackPlugin.this, "No video players installed.");
            return;
        }
        boolean flag1 = false;
        Iterator iterator = ((List) (obj1)).iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
            if (!resolveinfo.activityInfo.packageName.equalsIgnoreCase("com.sec.android.app.videoplayer"))
            {
                continue;
            }
            ((Intent) (obj)).setPackage(resolveinfo.activityInfo.packageName);
            flag = true;
            break;
        } while (true);
        if (!flag)
        {
            ((Intent) (obj)).setPackage(((ResolveInfo)((List) (obj1)).get(0)).activityInfo.packageName);
        }
        cordova.getActivity().startActivity(((Intent) (obj)));
        val$callbackContext.success();
        MASHVideoPlaybackPlugin.access$000(MASHVideoPlaybackPlugin.this, "MASH API PlayVideo has been started succeccfully.");
    }

    ()
    {
        this$0 = final_mashvideoplaybackplugin;
        val$args = jsonarray;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
