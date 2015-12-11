// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.edisonwang.android.slog.SLog;

public class MuteUtil
{

    public static final String ACTION_CHANGED_TO_MUTE = (new StringBuilder()).append(SLog.getAuthority()).append(".muted").toString();
    public static final String ACTION_CHANGED_TO_UNMUTE = (new StringBuilder()).append(SLog.getAuthority()).append(".un_muted").toString();
    public static final String BROADCAST_PERMISSION = "co.vine.android.BROADCAST";
    public static final IntentFilter MUTE_INTENT_FILTER;
    private static final String PREF_MUTE = "mute";
    private static SharedPreferences sp;

    public MuteUtil()
    {
    }

    public static boolean isMuted(Context context)
    {
        co/vine/android/util/MuteUtil;
        JVM INSTR monitorenter ;
        boolean flag;
        if (sp == null)
        {
            sp = context.getSharedPreferences("mute", 0);
        }
        flag = sp.getBoolean("mute", false);
        co/vine/android/util/MuteUtil;
        JVM INSTR monitorexit ;
        return flag;
        context;
        throw context;
    }

    public static void setMuted(Context context, boolean flag)
    {
        co/vine/android/util/MuteUtil;
        JVM INSTR monitorenter ;
        if (sp == null)
        {
            sp = context.getSharedPreferences("mute", 0);
        }
        sp.edit().putBoolean("mute", flag).commit();
        SLog.d("Mute state change send.");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        String s = ACTION_CHANGED_TO_MUTE;
_L1:
        context.sendBroadcast(new Intent(s), "co.vine.android.BROADCAST");
        co/vine/android/util/MuteUtil;
        JVM INSTR monitorexit ;
        return;
        s = ACTION_CHANGED_TO_UNMUTE;
          goto _L1
        context;
        throw context;
    }

    static 
    {
        MUTE_INTENT_FILTER = new IntentFilter();
        MUTE_INTENT_FILTER.addAction(ACTION_CHANGED_TO_MUTE);
        MUTE_INTENT_FILTER.addAction(ACTION_CHANGED_TO_UNMUTE);
    }
}
