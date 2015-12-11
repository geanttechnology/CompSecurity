// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.logging;

import android.util.Log;
import com.amazon.mas.client.SysPropHelper;

// Referenced classes of package com.amazon.android.logging:
//            AndroidLogger

private static final class level extends Enum
{

    private static final verbose $VALUES[];
    private static final SysPropHelper HELPER = SysPropHelper.get("mas.log_level");
    private static final String TAG = com/amazon/android/logging/AndroidLogger$Level.getSimpleName();
    public static final verbose debug;
    public static final verbose error;
    public static final verbose informational;
    public static final verbose none;
    public static final verbose verbose;
    public static final verbose warning;
    private final int level;

    public static level valueOf(String s)
    {
        return (level)Enum.valueOf(com/amazon/android/logging/AndroidLogger$Level, s);
    }

    public static level[] values()
    {
        return (level[])$VALUES.clone();
    }

    public boolean isEnabled()
    {
        boolean flag = false;
        int i;
        int j;
        try
        {
            i = Integer.parseInt(HELPER.getValue(AndroidLogger.access$000()));
            j = level;
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.e(TAG, "Error attempting to determine system configured log level ", numberformatexception);
            return false;
        }
        if (j <= i)
        {
            flag = true;
        }
        return flag;
    }

    static 
    {
        none = new <init>("none", 0, 0);
        error = new <init>("error", 1, 1);
        warning = new <init>("warning", 2, 2);
        informational = new <init>("informational", 3, 3);
        debug = new <init>("debug", 4, 4);
        verbose = new <init>("verbose", 5, 5);
        $VALUES = (new .VALUES[] {
            none, error, warning, informational, debug, verbose
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        level = j;
    }
}
