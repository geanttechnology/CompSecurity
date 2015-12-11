// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, SendPushTagsAsyncTask, SendPushTagsCallBack

static final class val.tags
    implements Runnable
{

    final SendPushTagsCallBack val$callBack;
    final Context val$context;
    final Map val$tags;

    public void run()
    {
        (new SendPushTagsAsyncTask(val$context, val$callBack)).execute(new Map[] {
            val$tags
        });
    }

    llBack(Context context1, SendPushTagsCallBack sendpushtagscallback, Map map)
    {
        val$context = context1;
        val$callBack = sendpushtagscallback;
        val$tags = map;
        super();
    }
}
