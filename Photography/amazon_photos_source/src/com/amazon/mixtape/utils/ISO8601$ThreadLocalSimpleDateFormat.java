// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

// Referenced classes of package com.amazon.mixtape.utils:
//            ISO8601

private static class <init> extends ThreadLocal
{

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected SimpleDateFormat initialValue()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
