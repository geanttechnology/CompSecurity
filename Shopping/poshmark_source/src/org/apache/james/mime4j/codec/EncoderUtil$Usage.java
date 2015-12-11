// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;


// Referenced classes of package org.apache.james.mime4j.codec:
//            EncoderUtil

public static final class  extends Enum
{

    private static final WORD_ENTITY $VALUES[];
    public static final WORD_ENTITY TEXT_TOKEN;
    public static final WORD_ENTITY WORD_ENTITY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/apache/james/mime4j/codec/EncoderUtil$Usage, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TEXT_TOKEN = new <init>("TEXT_TOKEN", 0);
        WORD_ENTITY = new <init>("WORD_ENTITY", 1);
        $VALUES = (new .VALUES[] {
            TEXT_TOKEN, WORD_ENTITY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
