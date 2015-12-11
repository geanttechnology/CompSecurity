// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            ApiKeyDecoded

public static final class id extends Enum
{

    private static final RPC_ANALYTICS $VALUES[];
    public static final RPC_ANALYTICS RPC_ANALYTICS;
    public static final RPC_ANALYTICS SDK_ANDROID;
    public byte id;

    public static id valueOf(byte byte0)
    {
        id aid[] = values();
        int j = aid.length;
        for (int i = 0; i < j; i++)
        {
            id id1 = aid[i];
            if (id1.id == byte0)
            {
                return id1;
            }
        }

        return null;
    }

    public static id valueOf(String s)
    {
        return (id)Enum.valueOf(com/tapjoy/internal/ApiKeyDecoded$KeyUsage, s);
    }

    public static id[] values()
    {
        return (id[])$VALUES.clone();
    }

    static 
    {
        SDK_ANDROID = new <init>("SDK_ANDROID", 0, (byte)2);
        RPC_ANALYTICS = new <init>("RPC_ANALYTICS", 1, (byte)49);
        $VALUES = (new .VALUES[] {
            SDK_ANDROID, RPC_ANALYTICS
        });
    }

    private (String s, int i, byte byte0)
    {
        super(s, i);
        id = byte0;
    }
}
