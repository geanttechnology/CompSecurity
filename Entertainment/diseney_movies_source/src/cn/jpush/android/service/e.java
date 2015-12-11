// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.api.m;

// Referenced classes of package cn.jpush.android.service:
//            DownloadService

final class e extends Handler
{

    final DownloadService a;

    e(DownloadService downloadservice)
    {
        a = downloadservice;
        super();
    }

    public final void handleMessage(Message message)
    {
        super.handleMessage(message);
        m.a(a, message.what);
    }
}
