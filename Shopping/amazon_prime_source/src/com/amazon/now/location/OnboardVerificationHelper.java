// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.location;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.amazon.now.net.JsonFetcher;
import com.amazon.now.platform.TaskCallback;
import com.amazon.now.util.AppUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class OnboardVerificationHelper
{

    private static final String TAG = com/amazon/now/location/OnboardVerificationHelper.getSimpleName();

    public OnboardVerificationHelper()
    {
    }

    public static void verify(Context context, TaskCallback taskcallback)
    {
        if (taskcallback == null)
        {
            throw new RuntimeException("TaskCallback cannot be null");
        } else
        {
            context = Uri.parse(AppUtils.getServiceUrl(context)).buildUpon();
            context.appendPath("onboard").appendPath("verify");
            (new JsonFetcher(context.toString(), new com.amazon.now.net.JsonFetcher.JsonCallback(taskcallback) {

                final TaskCallback val$callback;

                public void response(String s)
                {
                    boolean flag = false;
                    boolean flag1 = (new JSONObject(s)).optBoolean("success", false);
                    flag = flag1;
_L1:
                    if (flag)
                    {
                        callback.success();
                        return;
                    } else
                    {
                        callback.failure();
                        return;
                    }
                    s;
                    Log.e(OnboardVerificationHelper.TAG, s.toString(), s);
                      goto _L1
                }

            
            {
                callback = taskcallback;
                super();
            }
            })).fetch();
            return;
        }
    }


}
