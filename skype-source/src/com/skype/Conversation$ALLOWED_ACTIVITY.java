// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype;

import android.support.v4.util.j;

// Referenced classes of package com.skype:
//            Conversation

public static final class value extends Enum
{

    private static final value $VALUES[];
    public static final value ADD_CONSUMERS;
    public static final value DELETE_OTHERS_MESSAGES;
    public static final value SET_META;
    public static final value SPEAK;
    public static final value SPEAK_AND_WRITE;
    public static final value WRAPPER_UNKNOWN_VALUE;
    private static final j intToTypeMap;
    private final int value;

    public static value fromInt(int i)
    {
        value value1 = (value)intToTypeMap.a(i);
        if (value1 != null)
        {
            return value1;
        } else
        {
            return WRAPPER_UNKNOWN_VALUE;
        }
    }

    public static WRAPPER_UNKNOWN_VALUE valueOf(String s)
    {
        return (WRAPPER_UNKNOWN_VALUE)Enum.valueOf(com/skype/Conversation$ALLOWED_ACTIVITY, s);
    }

    public static WRAPPER_UNKNOWN_VALUE[] values()
    {
        return (WRAPPER_UNKNOWN_VALUE[])$VALUES.clone();
    }

    public final int toInt()
    {
        return value;
    }

    static 
    {
        SET_META = new <init>("SET_META", 0, 1);
        ADD_CONSUMERS = new <init>("ADD_CONSUMERS", 1, 2);
        SPEAK = new <init>("SPEAK", 2, 4);
        SPEAK_AND_WRITE = new <init>("SPEAK_AND_WRITE", 3, 8);
        DELETE_OTHERS_MESSAGES = new <init>("DELETE_OTHERS_MESSAGES", 4, 16);
        WRAPPER_UNKNOWN_VALUE = new <init>("WRAPPER_UNKNOWN_VALUE", 5, 0x7fffffff);
        $VALUES = (new .VALUES[] {
            SET_META, ADD_CONSUMERS, SPEAK, SPEAK_AND_WRITE, DELETE_OTHERS_MESSAGES, WRAPPER_UNKNOWN_VALUE
        });
        intToTypeMap = new j();
        value avalue[] = values();
        int k = avalue.length;
        for (int i = 0; i < k; i++)
        {
            value value1 = avalue[i];
            intToTypeMap.a(value1.value, value1);
        }

    }

    private (String s, int i, int k)
    {
        super(s, i);
        value = k;
    }
}
