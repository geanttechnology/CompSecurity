// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.os.Message;

// Referenced classes of package com.targetspot.android.sdk.util:
//            HttpUtil

static final class val.handler
    implements Runnable
{

    final tpHandler val$handler;
    final boolean val$isCompressed;
    final String val$url;

    public void run()
    {
        try
        {
            String s = HttpUtil.readUrl(val$url, val$isCompressed);
            if (val$handler != null)
            {
                Message.obtain(val$handler, 1, s).sendToTarget();
            }
            return;
        }
        catch (Throwable throwable)
        {
            if (val$handler != null)
            {
                Message.obtain(val$handler, 0, throwable).sendToTarget();
                return;
            } else
            {
                throwable.printStackTrace();
                return;
            }
        }
    }

    tpHandler(String s, boolean flag, tpHandler tphandler)
    {
        val$url = s;
        val$isCompressed = flag;
        val$handler = tphandler;
        super();
    }
}
