// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.log;

import android.util.Log;

// Referenced classes of package uk.co.senab.photoview.log:
//            Logger

public class LoggerDefault
    implements Logger
{

    public LoggerDefault()
    {
    }

    public int d(String s, String s1)
    {
        return Log.d(s, s1);
    }

    public int i(String s, String s1)
    {
        return Log.i(s, s1);
    }
}
