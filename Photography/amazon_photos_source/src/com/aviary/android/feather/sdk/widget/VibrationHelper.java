// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;

public class VibrationHelper
{
    static class VibrationHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 101 101: default 24
        //                       101 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            if (VibrationHelper.mVibrator != null)
            {
                try
                {
                    VibrationHelper.mVibrator.vibrate(message.arg1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    message.printStackTrace();
                }
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        VibrationHandler()
        {
        }
    }


    private static final String LOG_TAG = "VibrationHelper";
    private static final int MSG_VIBRATE = 101;
    private static Vibrator mVibrator;
    private boolean mEnabled;
    private VibrationHandler mHandler;

    public VibrationHelper(Context context, boolean flag)
    {
        mHandler = new VibrationHandler();
        initialize(context);
        setEnabled(flag);
        if (!isAvailable())
        {
            setEnabled(false);
        }
    }

    private void initialize(Context context)
    {
        com/aviary/android/feather/sdk/widget/VibrationHelper;
        JVM INSTR monitorenter ;
        Vibrator vibrator = mVibrator;
        if (vibrator != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        mVibrator = (Vibrator)context.getSystemService("vibrator");
_L1:
        com/aviary/android/feather/sdk/widget/VibrationHelper;
        JVM INSTR monitorexit ;
        return;
        context;
        Log.e("VibrationHelper", context.toString());
          goto _L1
        context;
        com/aviary/android/feather/sdk/widget/VibrationHelper;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean enabled()
    {
        return mEnabled;
    }

    public boolean isAvailable()
    {
        if (mVibrator != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                return mVibrator.hasVibrator();
            } else
            {
                return true;
            }
        } else
        {
            return false;
        }
    }

    public void setEnabled(boolean flag)
    {
        Log.i("VibrationHelper", (new StringBuilder()).append("setEnabled: ").append(flag).toString());
        if (flag && mVibrator != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mEnabled = flag;
    }

    public void vibrate(int i)
    {
        if (mEnabled && mHandler != null)
        {
            mHandler.removeMessages(101);
            Message message = mHandler.obtainMessage(101);
            message.arg1 = i;
            mHandler.sendMessage(message);
        }
    }

}
