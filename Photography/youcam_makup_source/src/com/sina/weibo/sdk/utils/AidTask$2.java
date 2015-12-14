// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import com.sina.weibo.sdk.exception.WeiboException;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            AidTask, LogUtil

class this._cls0
    implements Runnable
{

    final AidTask this$0;

    public void run()
    {
        Object obj;
        if (!AidTask.access$1(AidTask.this).tryLock())
        {
            LogUtil.e("AidTask", "tryLock : false, return");
            return;
        }
        obj = AidTask.access$2(AidTask.this);
        if (obj != null) goto _L2; else goto _L1
_L1:
        int i = 1;
_L4:
        int j = i + 1;
        obj = AidTask.access$3(AidTask.this);
        dInfo dinfo = dInfo.parseJson(((String) (obj)));
        AidTask.access$4(AidTask.this, ((String) (obj)));
        AidTask.access$5(AidTask.this, dinfo);
_L3:
        AidTask.access$1(AidTask.this).unlock();
        return;
        obj;
        LogUtil.e("AidTask", (new StringBuilder("AidTaskInit WeiboException Msg : ")).append(((WeiboException) (obj)).getMessage()).toString());
        i = j;
        if (j < 3) goto _L4; else goto _L3
_L2:
        AidTask.access$5(AidTask.this, ((dInfo) (obj)));
          goto _L3
    }

    xception()
    {
        this$0 = AidTask.this;
        super();
    }
}
