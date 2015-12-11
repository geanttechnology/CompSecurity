// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.dispatcher;


final class  extends Enum
{

    private static final RUNNING $VALUES[];
    public static final RUNNING IDLE;
    public static final RUNNING RUNNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/speech/dispatcher/RecognitionDispatcher$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        RUNNING = new <init>("RUNNING", 1);
        $VALUES = (new .VALUES[] {
            IDLE, RUNNING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
