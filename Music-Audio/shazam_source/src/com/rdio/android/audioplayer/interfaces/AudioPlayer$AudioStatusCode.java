// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioPlayer

public static final class value extends Enum
{

    private static final Unknown $VALUES[];
    public static final Unknown Error;
    public static final Unknown ErrorBadValue;
    public static final Unknown ErrorInvalidOperation;
    public static final Unknown Success;
    public static final Unknown Unknown;
    private int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioPlayer$AudioStatusCode, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        Success = new <init>("Success", 0, 0);
        Error = new <init>("Error", 1, -1);
        ErrorBadValue = new <init>("ErrorBadValue", 2, -2);
        ErrorInvalidOperation = new <init>("ErrorInvalidOperation", 3, -3);
        Unknown = new <init>("Unknown", 4, -4);
        $VALUES = (new .VALUES[] {
            Success, Error, ErrorBadValue, ErrorInvalidOperation, Unknown
        });
    }

    private I(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
