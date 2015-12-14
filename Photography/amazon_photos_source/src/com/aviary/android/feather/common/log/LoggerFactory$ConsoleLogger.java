// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.log;

import android.util.Log;

// Referenced classes of package com.aviary.android.feather.common.log:
//            LoggerFactory

static class it> extends it>
{

    public void error(String s)
    {
        Log.e(tag, s);
    }

    public transient void error(String s, Object aobj[])
    {
        Log.e(tag, String.format(s, aobj));
    }

    public void info(String s)
    {
        Log.i(tag, s);
    }

    public transient void info(String s, Object aobj[])
    {
        Log.i(tag, String.format(s, aobj));
    }

    public void log(String s)
    {
        Log.d(tag, s);
    }

    public transient void log(String s, Object aobj[])
    {
        Log.d(tag, String.format(s, aobj));
    }

    public transient void verbose(String s, Object aobj[])
    {
        Log.v(tag, String.format(s, aobj));
    }

    public void warn(String s)
    {
        Log.w(tag, s);
    }

    public transient void warn(String s, Object aobj[])
    {
        Log.w(tag, String.format(s, aobj));
    }

    public (String s)
    {
        super(s);
    }
}
