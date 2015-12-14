// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.AesEncrypt;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            AppInvokeCmdExecutor, AppInstallCmdExecutor, AppInstallCmd, AppInvokeCmd, 
//            CmdInfo

public class WbAppActivator
{

    private static final String TAG = com/sina/weibo/sdk/cmd/WbAppActivator.getName();
    private static WbAppActivator mInstance;
    private String mAppkey;
    private Context mContext;
    private AppInstallCmdExecutor mInstallExecutor;
    private AppInvokeCmdExecutor mInvokeExecutor;
    private volatile ReentrantLock mLock;

    private WbAppActivator(Context context, String s)
    {
        mLock = new ReentrantLock(true);
        mContext = context.getApplicationContext();
        mInvokeExecutor = new AppInvokeCmdExecutor(mContext);
        mInstallExecutor = new AppInstallCmdExecutor(mContext);
        mAppkey = s;
    }

    public static WbAppActivator getInstance(Context context, String s)
    {
        com/sina/weibo/sdk/cmd/WbAppActivator;
        JVM INSTR monitorenter ;
        if (mInstance == null)
        {
            mInstance = new WbAppActivator(context, s);
        }
        context = mInstance;
        com/sina/weibo/sdk/cmd/WbAppActivator;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void handleInstallCmd(List list)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        mInstallExecutor.start();
        list = list.iterator();
_L6:
        if (list.hasNext()) goto _L4; else goto _L3
_L3:
        mInstallExecutor.stop();
_L2:
        return;
_L4:
        AppInstallCmd appinstallcmd = (AppInstallCmd)list.next();
        mInstallExecutor.doExecutor(appinstallcmd);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void handleInvokeCmd(List list)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        list = list.iterator();
_L5:
        if (list.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        AppInvokeCmd appinvokecmd = (AppInvokeCmd)list.next();
        mInvokeExecutor.doExecutor(appinvokecmd);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static String requestCmdInfo(Context context, String s)
    {
        String s1 = context.getPackageName();
        String s2 = Utility.getSign(context, s1);
        WeiboParameters weiboparameters = new WeiboParameters(s);
        weiboparameters.put("appkey", s);
        weiboparameters.put("packagename", s1);
        weiboparameters.put("key_hash", s2);
        weiboparameters.put("version", "0031205000");
        return NetUtils.internalHttpRequest(context, "http://api.weibo.cn/2/client/common_config", "GET", weiboparameters);
    }

    public void activateApp()
    {
        final SharedPreferences sdkSp = FrequencyHelper.getWeiboSdkSp(mContext);
        long l = FrequencyHelper.getFrequency(mContext, sdkSp);
        long l1 = FrequencyHelper.getLastTime(mContext, sdkSp);
        l1 = System.currentTimeMillis() - l1;
        if (l1 < l)
        {
            LogUtil.v(TAG, String.format("it's only %d ms from last time get cmd", new Object[] {
                Long.valueOf(l1)
            }));
            return;
        } else
        {
            (new Thread(new Runnable() {

                final WbAppActivator this$0;
                private final SharedPreferences val$sdkSp;

                public void run()
                {
                    Object obj;
                    Object obj1;
                    Object obj2;
                    LogUtil.v(WbAppActivator.TAG, (new StringBuilder("mLock.isLocked()--->")).append(mLock.isLocked()).toString());
                    if (!mLock.tryLock())
                    {
                        return;
                    }
                    obj1 = null;
                    obj2 = null;
                    obj = obj1;
                    String s = WbAppActivator.requestCmdInfo(mContext, mAppkey);
                    if (s == null) goto _L2; else goto _L1
_L1:
                    obj = obj1;
                    obj1 = new CmdInfo(AesEncrypt.Decrypt(s));
                    handleInstallCmd(((CmdInfo) (obj1)).getInstallCmds());
                    handleInvokeCmd(((CmdInfo) (obj1)).getInvokeCmds());
_L7:
                    mLock.unlock();
                    if (obj1 != null)
                    {
                        FrequencyHelper.saveFrequency(mContext, sdkSp, ((CmdInfo) (obj1)).getFrequency());
                        FrequencyHelper.saveLastTime(mContext, sdkSp, System.currentTimeMillis());
                    }
                    LogUtil.v(WbAppActivator.TAG, (new StringBuilder("after unlock \n mLock.isLocked()--->")).append(mLock.isLocked()).toString());
                    return;
                    obj;
                    obj1 = obj2;
                    obj2 = obj;
_L5:
                    obj = obj1;
                    LogUtil.e(WbAppActivator.TAG, ((WeiboException) (obj2)).getMessage());
                    mLock.unlock();
                    if (obj1 != null)
                    {
                        FrequencyHelper.saveFrequency(mContext, sdkSp, ((CmdInfo) (obj1)).getFrequency());
                        FrequencyHelper.saveLastTime(mContext, sdkSp, System.currentTimeMillis());
                    }
                    LogUtil.v(WbAppActivator.TAG, (new StringBuilder("after unlock \n mLock.isLocked()--->")).append(mLock.isLocked()).toString());
                    return;
                    Exception exception;
                    exception;
                    obj1 = obj;
                    obj = exception;
_L4:
                    mLock.unlock();
                    if (obj1 != null)
                    {
                        FrequencyHelper.saveFrequency(mContext, sdkSp, ((CmdInfo) (obj1)).getFrequency());
                        FrequencyHelper.saveLastTime(mContext, sdkSp, System.currentTimeMillis());
                    }
                    LogUtil.v(WbAppActivator.TAG, (new StringBuilder("after unlock \n mLock.isLocked()--->")).append(mLock.isLocked()).toString());
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

            
            {
                this$0 = WbAppActivator.this;
                sdkSp = sharedpreferences;
                super();
            }
            })).start();
            return;
        }
    }









    private class FrequencyHelper
    {

        private static final int DEFAULT_FREQUENCY = 0x36ee80;
        private static final String KEY_FREQUENCY = "frequency_get_cmd";
        private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
        private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";

        public static long getFrequency(Context context, SharedPreferences sharedpreferences)
        {
            long l = 0x36ee80L;
            if (sharedpreferences != null)
            {
                l = sharedpreferences.getLong("frequency_get_cmd", 0x36ee80L);
            }
            return l;
        }

        public static long getLastTime(Context context, SharedPreferences sharedpreferences)
        {
            long l = 0L;
            if (sharedpreferences != null)
            {
                l = sharedpreferences.getLong("last_time_get_cmd", 0L);
            }
            return l;
        }

        public static SharedPreferences getWeiboSdkSp(Context context)
        {
            return context.getSharedPreferences("com_sina_weibo_sdk", 0);
        }

        public static void saveFrequency(Context context, SharedPreferences sharedpreferences, long l)
        {
            if (sharedpreferences != null && l > 0L)
            {
                context = sharedpreferences.edit();
                context.putLong("frequency_get_cmd", l);
                context.commit();
            }
        }

        public static void saveLastTime(Context context, SharedPreferences sharedpreferences, long l)
        {
            if (sharedpreferences != null)
            {
                context = sharedpreferences.edit();
                context.putLong("last_time_get_cmd", l);
                context.commit();
            }
        }

        private FrequencyHelper()
        {
        }
    }

}
