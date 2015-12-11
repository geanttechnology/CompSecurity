// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;


// Referenced classes of package com.rdio.android.core.remote:
//            RemoteClientPresenceEvent

public static final class  extends Enum
{

    private static final Part $VALUES[];
    public static final Part Join;
    public static final Part Part;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/remote/RemoteClientPresenceEvent$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Join = new <init>("Join", 0);
        Part = new <init>("Part", 1);
        $VALUES = (new .VALUES[] {
            Join, Part
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
