// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.logging;

import android.util.Log;
import com.amazon.logging.Logger;
import com.amazon.mas.client.SysPropHelper;

class AndroidLogger extends Logger
{
    private static final class Level extends Enum
    {

        private static final Level $VALUES[];
        private static final SysPropHelper HELPER = SysPropHelper.get("mas.log_level");
        private static final String TAG = com/amazon/android/logging/AndroidLogger$Level.getSimpleName();
        public static final Level debug;
        public static final Level error;
        public static final Level informational;
        public static final Level none;
        public static final Level verbose;
        public static final Level warning;
        private final int level;

        public static Level valueOf(String s)
        {
            return (Level)Enum.valueOf(com/amazon/android/logging/AndroidLogger$Level, s);
        }

        public static Level[] values()
        {
            return (Level[])$VALUES.clone();
        }

        public boolean isEnabled()
        {
            boolean flag = false;
            int j;
            int k;
            try
            {
                j = Integer.parseInt(HELPER.getValue(AndroidLogger.defaultLevel));
                k = level;
            }
            catch (NumberFormatException numberformatexception)
            {
                Log.e(TAG, "Error attempting to determine system configured log level ", numberformatexception);
                return false;
            }
            if (k <= j)
            {
                flag = true;
            }
            return flag;
        }

        static 
        {
            none = new Level("none", 0, 0);
            error = new Level("error", 1, 1);
            warning = new Level("warning", 2, 2);
            informational = new Level("informational", 3, 3);
            debug = new Level("debug", 4, 4);
            verbose = new Level("verbose", 5, 5);
            $VALUES = (new Level[] {
                none, error, warning, informational, debug, verbose
            });
        }

        private Level(String s, int j, int k)
        {
            super(s, j);
            level = k;
        }
    }


    private static String defaultLevel = "3";
    private final String tag;

    AndroidLogger(String s)
    {
        tag = s;
    }

    protected static void setIsDebugBuild(boolean flag)
    {
        if (flag)
        {
            defaultLevel = "5";
            return;
        } else
        {
            defaultLevel = "3";
            return;
        }
    }

    public void d(String s)
    {
        if (Level.debug.isEnabled())
        {
            Log.d(tag, s);
        }
    }

    public void d(String s, Throwable throwable)
    {
        if (Level.debug.isEnabled())
        {
            Log.d(tag, s, throwable);
        }
    }

    public void e(String s)
    {
        if (Level.error.isEnabled())
        {
            Log.e(tag, s);
        }
    }

    public void e(String s, Throwable throwable)
    {
        if (Level.error.isEnabled())
        {
            Log.e(tag, s, throwable);
        }
    }

    public void i(String s)
    {
        if (Level.informational.isEnabled())
        {
            Log.i(tag, s);
        }
    }

    public void i(String s, Throwable throwable)
    {
        if (Level.informational.isEnabled())
        {
            Log.i(tag, s, throwable);
        }
    }

    public boolean isDebugEnabled()
    {
        return Level.debug.isEnabled();
    }

    public boolean isVerboseEnabled()
    {
        return Level.verbose.isEnabled();
    }

    public void v(String s)
    {
        if (Level.verbose.isEnabled())
        {
            Log.v(tag, s);
        }
    }

    public void v(String s, Throwable throwable)
    {
        if (Level.verbose.isEnabled())
        {
            Log.v(tag, s, throwable);
        }
    }

    public void w(String s)
    {
        if (Level.warning.isEnabled())
        {
            Log.w(tag, s);
        }
    }

    public void w(String s, Throwable throwable)
    {
        if (Level.warning.isEnabled())
        {
            Log.w(tag, s, throwable);
        }
    }


}
