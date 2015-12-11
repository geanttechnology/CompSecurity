// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Error $VALUES[];
    public static final Error Allow;
    public static final Error Error;
    public static final Error Ignore;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$AddToPlaylist_duplicateHandling, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Ignore = new <init>("Ignore", 0);
        Allow = new <init>("Allow", 1);
        Error = new <init>("Error", 2);
        $VALUES = (new .VALUES[] {
            Ignore, Allow, Error
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
