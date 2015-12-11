// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonConsoleMessage

public static final class A extends Enum
{

    private static final WARNING $VALUES[];
    public static final WARNING DEBUG;
    public static final WARNING ERROR;
    public static final WARNING LOG;
    public static final WARNING TIP;
    public static final WARNING WARNING;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/amazon/android/webkit/AmazonConsoleMessage$MessageLevel, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        ERROR = new <init>("ERROR", 0);
        DEBUG = new <init>("DEBUG", 1);
        LOG = new <init>("LOG", 2);
        TIP = new <init>("TIP", 3);
        WARNING = new <init>("WARNING", 4);
        $VALUES = (new .VALUES[] {
            ERROR, DEBUG, LOG, TIP, WARNING
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
