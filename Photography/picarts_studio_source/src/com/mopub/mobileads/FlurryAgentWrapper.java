// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;
import java.util.WeakHashMap;

public final class FlurryAgentWrapper
{

    private static FlurryAgentWrapper sWrapper;
    private final WeakHashMap mContextMap = new WeakHashMap();

    private FlurryAgentWrapper()
    {
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.setLogLevel(4);
        FlurryAgent.addOrigin("Flurry_Mopub_Android", "5.4.0.r1");
    }

    public static FlurryAgentWrapper getInstance()
    {
        com/mopub/mobileads/FlurryAgentWrapper;
        JVM INSTR monitorenter ;
        FlurryAgentWrapper flurryagentwrapper;
        if (sWrapper == null)
        {
            sWrapper = new FlurryAgentWrapper();
        }
        flurryagentwrapper = sWrapper;
        com/mopub/mobileads/FlurryAgentWrapper;
        JVM INSTR monitorexit ;
        return flurryagentwrapper;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onEndSession(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (android.os.Build.VERSION.SDK_INT >= 14 || mContextMap.get(context) == null) goto _L1; else goto _L3
_L3:
        int i = ((Integer)mContextMap.get(context)).intValue() - 1;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        mContextMap.remove(context);
        FlurryAgent.onEndSession(context);
          goto _L1
        context;
        throw context;
        mContextMap.put(context, Integer.valueOf(i));
          goto _L1
    }

    public final void onStartSession(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        FlurryAgent.init(context, s);
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            if (mContextMap.get(context) == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            int i = ((Integer)mContextMap.get(context)).intValue();
            mContextMap.put(context, Integer.valueOf(i + 1));
        }
          goto _L2
        context;
        throw context;
        mContextMap.put(context, Integer.valueOf(1));
        FlurryAgent.onStartSession(context);
          goto _L2
    }
}
