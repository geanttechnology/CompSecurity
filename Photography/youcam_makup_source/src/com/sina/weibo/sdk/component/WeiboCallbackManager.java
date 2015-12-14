// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import java.util.HashMap;
import java.util.Map;

public class WeiboCallbackManager
{

    private static WeiboCallbackManager sInstance;
    private Context mContext;
    private Map mWeiboAuthListenerMap;
    private Map mWidgetRequestCallbackMap;

    private WeiboCallbackManager(Context context)
    {
        mContext = context;
        mWeiboAuthListenerMap = new HashMap();
        mWidgetRequestCallbackMap = new HashMap();
    }

    public static WeiboCallbackManager getInstance(Context context)
    {
        com/sina/weibo/sdk/component/WeiboCallbackManager;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new WeiboCallbackManager(context);
        }
        context = sInstance;
        com/sina/weibo/sdk/component/WeiboCallbackManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public String genCallbackKey()
    {
        return String.valueOf(System.currentTimeMillis());
    }

    public WeiboAuthListener getWeiboAuthListener(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (WeiboAuthListener)mWeiboAuthListenerMap.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public WidgetRequestParam.WidgetRequestCallback getWidgetRequestCallback(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (WidgetRequestParam.WidgetRequestCallback)mWidgetRequestCallbackMap.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void removeWeiboAuthListener(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mWeiboAuthListenerMap.remove(s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public void removeWidgetRequestCallback(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mWidgetRequestCallbackMap.remove(s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public void setWeiboAuthListener(String s, WeiboAuthListener weiboauthlistener)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag && weiboauthlistener != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mWeiboAuthListenerMap.put(s, weiboauthlistener);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public void setWidgetRequestCallback(String s, WidgetRequestParam.WidgetRequestCallback widgetrequestcallback)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag && widgetrequestcallback != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mWidgetRequestCallbackMap.put(s, widgetrequestcallback);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }
}
