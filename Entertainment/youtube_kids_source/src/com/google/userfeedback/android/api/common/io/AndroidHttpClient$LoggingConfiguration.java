// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import android.util.Log;

class <init>
{

    private final int level;
    private final String tag;

    private boolean isLoggable()
    {
        return Log.isLoggable(tag, level);
    }

    private void println(String s)
    {
        Log.println(level, tag, s);
    }



    private (String s, int i)
    {
        tag = s;
        level = i;
    }

    level(String s, int i, level level1)
    {
        this(s, i);
    }
}
