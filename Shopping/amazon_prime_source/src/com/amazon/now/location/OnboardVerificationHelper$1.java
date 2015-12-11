// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.location;

import android.util.Log;
import com.amazon.now.platform.TaskCallback;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.location:
//            OnboardVerificationHelper

static final class val.callback
    implements com.amazon.now.net.er._cls1
{

    final TaskCallback val$callback;

    public void response(String s)
    {
        boolean flag = false;
        boolean flag1 = (new JSONObject(s)).optBoolean("success", false);
        flag = flag1;
_L1:
        if (flag)
        {
            val$callback.success();
            return;
        } else
        {
            val$callback.failure();
            return;
        }
        s;
        Log.e(OnboardVerificationHelper.access$000(), s.toString(), s);
          goto _L1
    }

    _cls9(TaskCallback taskcallback)
    {
        val$callback = taskcallback;
        super();
    }
}
