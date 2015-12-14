// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.content.SharedPreferences;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.AesEncrypt;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            WbAppActivator, CmdInfo

class val.sdkSp
    implements Runnable
{

    final WbAppActivator this$0;
    private final SharedPreferences val$sdkSp;

    public void run()
    {
        Object obj;
        Object obj1;
        Object obj2;
        LogUtil.v(WbAppActivator.access$0(), (new StringBuilder("mLock.isLocked()--->")).append(WbAppActivator.access$1(WbAppActivator.this).isLocked()).toString());
        if (!WbAppActivator.access$1(WbAppActivator.this).tryLock())
        {
            return;
        }
        obj1 = null;
        obj2 = null;
        obj = obj1;
        String s = WbAppActivator.access$4(WbAppActivator.access$2(WbAppActivator.this), WbAppActivator.access$3(WbAppActivator.this));
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        obj1 = new CmdInfo(AesEncrypt.Decrypt(s));
        WbAppActivator.access$5(WbAppActivator.this, ((CmdInfo) (obj1)).getInstallCmds());
        WbAppActivator.access$6(WbAppActivator.this, ((CmdInfo) (obj1)).getInvokeCmds());
_L7:
        WbAppActivator.access$1(WbAppActivator.this).unlock();
        if (obj1 != null)
        {
            equencyHelper.saveFrequency(WbAppActivator.access$2(WbAppActivator.this), val$sdkSp, ((CmdInfo) (obj1)).getFrequency());
            equencyHelper.saveLastTime(WbAppActivator.access$2(WbAppActivator.this), val$sdkSp, System.currentTimeMillis());
        }
        LogUtil.v(WbAppActivator.access$0(), (new StringBuilder("after unlock \n mLock.isLocked()--->")).append(WbAppActivator.access$1(WbAppActivator.this).isLocked()).toString());
        return;
        obj;
        obj1 = obj2;
        obj2 = obj;
_L5:
        obj = obj1;
        LogUtil.e(WbAppActivator.access$0(), ((WeiboException) (obj2)).getMessage());
        WbAppActivator.access$1(WbAppActivator.this).unlock();
        if (obj1 != null)
        {
            equencyHelper.saveFrequency(WbAppActivator.access$2(WbAppActivator.this), val$sdkSp, ((CmdInfo) (obj1)).getFrequency());
            equencyHelper.saveLastTime(WbAppActivator.access$2(WbAppActivator.this), val$sdkSp, System.currentTimeMillis());
        }
        LogUtil.v(WbAppActivator.access$0(), (new StringBuilder("after unlock \n mLock.isLocked()--->")).append(WbAppActivator.access$1(WbAppActivator.this).isLocked()).toString());
        return;
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L4:
        WbAppActivator.access$1(WbAppActivator.this).unlock();
        if (obj1 != null)
        {
            equencyHelper.saveFrequency(WbAppActivator.access$2(WbAppActivator.this), val$sdkSp, ((CmdInfo) (obj1)).getFrequency());
            equencyHelper.saveLastTime(WbAppActivator.access$2(WbAppActivator.this), val$sdkSp, System.currentTimeMillis());
        }
        LogUtil.v(WbAppActivator.access$0(), (new StringBuilder("after unlock \n mLock.isLocked()--->")).append(WbAppActivator.access$1(WbAppActivator.this).isLocked()).toString());
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        if (true) goto _L5; else goto _L2
_L2:
        obj1 = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    ion()
    {
        this$0 = final_wbappactivator;
        val$sdkSp = SharedPreferences.this;
        super();
    }
}
