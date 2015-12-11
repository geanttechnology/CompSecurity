// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioPlayer

public static final class  extends Enum
{

    private static final Uninitialized $VALUES[];
    public static final Uninitialized Completed;
    public static final Uninitialized Error;
    public static final Uninitialized Prepared;
    public static final Uninitialized Preparing;
    public static final Uninitialized Ready;
    public static final Uninitialized Reset;
    public static final Uninitialized Resetting;
    public static final Uninitialized Uninitialized;
    public static final Uninitialized Uninitializing;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioPlayer$AudioPlayerState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Resetting = new <init>("Resetting", 0);
        Reset = new <init>("Reset", 1);
        Ready = new <init>("Ready", 2);
        Preparing = new <init>("Preparing", 3);
        Prepared = new <init>("Prepared", 4);
        Completed = new <init>("Completed", 5);
        Error = new <init>("Error", 6);
        Uninitializing = new <init>("Uninitializing", 7);
        Uninitialized = new <init>("Uninitialized", 8);
        $VALUES = (new .VALUES[] {
            Resetting, Reset, Ready, Preparing, Prepared, Completed, Error, Uninitializing, Uninitialized
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
