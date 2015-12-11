// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSQuestionFragment, g, o

class a extends Handler
{

    final HSQuestionFragment a;

    public void handleMessage(Message message)
    {
        message = (g)message.obj;
        if (a.isResumed())
        {
            HSQuestionFragment.a(a, message);
        }
        if (HSQuestionFragment.b(a).booleanValue())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        HSQuestionFragment.a(a, message.a());
        message = new JSONObject();
        message.put("id", HSQuestionFragment.c(a));
        o.a("f", message);
        HSQuestionFragment.a(a, Boolean.valueOf(true));
        return;
        message;
        Log.d("HelpShiftDebug", "JSONException", message);
        return;
    }

    (HSQuestionFragment hsquestionfragment)
    {
        a = hsquestionfragment;
        super();
    }
}
