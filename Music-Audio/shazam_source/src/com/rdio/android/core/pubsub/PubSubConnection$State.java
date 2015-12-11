// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;


// Referenced classes of package com.rdio.android.core.pubsub:
//            PubSubConnection

public static final class _cls9 extends Enum
{

    private static final Connected $VALUES[];
    public static final Connected Connected;
    public static final Connected Connecting;
    public static final Connected Disconnected;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/rdio/android/core/pubsub/PubSubConnection$State, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        Disconnected = new <init>("Disconnected", 0);
        Connecting = new <init>("Connecting", 1);
        Connected = new <init>("Connected", 2);
        $VALUES = (new .VALUES[] {
            Disconnected, Connecting, Connected
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
