// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;


final class  extends Enum
{

    private static final STOPPED $VALUES[];
    public static final STOPPED IDLE;
    public static final STOPPED LISTENING;
    public static final STOPPED STOPPED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/speech/RecognizerImpl$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        LISTENING = new <init>("LISTENING", 1);
        STOPPED = new <init>("STOPPED", 2);
        $VALUES = (new .VALUES[] {
            IDLE, LISTENING, STOPPED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
