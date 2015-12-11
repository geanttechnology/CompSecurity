// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.exception.PushWooshException;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push:
//            SendPushTagsAbstractAsyncTask, SendPushTagsCallBack

class SendPushTagsAsyncTask extends SendPushTagsAbstractAsyncTask
{

    private SendPushTagsCallBack mCallBack;

    public SendPushTagsAsyncTask(Context context, SendPushTagsCallBack sendpushtagscallback)
    {
        super(context);
        mCallBack = sendpushtagscallback;
    }

    public void onSentTagsError(PushWooshException pushwooshexception)
    {
        if (mCallBack != null)
        {
            mCallBack.onSentTagsError(pushwooshexception);
        }
    }

    public void onSentTagsSuccess(Map map)
    {
        if (mCallBack != null)
        {
            mCallBack.onSentTagsSuccess(map);
        }
    }

    public void taskStarted()
    {
        if (mCallBack != null)
        {
            mCallBack.taskStarted();
        }
    }
}
