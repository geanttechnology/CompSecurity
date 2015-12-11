// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.util;

import android.util.Log;

// Referenced classes of package com.rdio.android.core.util:
//            Logging

public class AndroidLogging
    implements Logging
{

    private final String TAG = "AndroidLogging";

    public AndroidLogging()
    {
    }

    public void log(int i, String s, String s1)
    {
        Log.println(i, s, s1);
    }

    public void logException(Throwable throwable, boolean flag)
    {
        Log.e("AndroidLogging", (new StringBuilder("Caught Exception: ")).append(throwable.getMessage()).toString(), throwable);
    }
}
