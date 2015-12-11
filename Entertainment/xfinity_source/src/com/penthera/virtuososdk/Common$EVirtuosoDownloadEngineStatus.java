// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk;


// Referenced classes of package com.penthera.virtuososdk:
//            Common

public static final class  extends Enum
{

    private static final kVDE_AuthenticationFailure ENUM$VALUES[];
    public static final kVDE_AuthenticationFailure kVDE_AuthenticationFailure;
    public static final kVDE_AuthenticationFailure kVDE_Blocked;
    public static final kVDE_AuthenticationFailure kVDE_Disabled;
    public static final kVDE_AuthenticationFailure kVDE_Downloading;
    public static final kVDE_AuthenticationFailure kVDE_Errors;
    public static final kVDE_AuthenticationFailure kVDE_Idle;
    public static final kVDE_AuthenticationFailure kVDE_Paused;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        kVDE_Downloading = new <init>("kVDE_Downloading", 0);
        kVDE_Idle = new <init>("kVDE_Idle", 1);
        kVDE_Paused = new <init>("kVDE_Paused", 2);
        kVDE_Disabled = new <init>("kVDE_Disabled", 3);
        kVDE_Blocked = new <init>("kVDE_Blocked", 4);
        kVDE_Errors = new <init>("kVDE_Errors", 5);
        kVDE_AuthenticationFailure = new <init>("kVDE_AuthenticationFailure", 6);
        ENUM$VALUES = (new ENUM.VALUES[] {
            kVDE_Downloading, kVDE_Idle, kVDE_Paused, kVDE_Disabled, kVDE_Blocked, kVDE_Errors, kVDE_AuthenticationFailure
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
