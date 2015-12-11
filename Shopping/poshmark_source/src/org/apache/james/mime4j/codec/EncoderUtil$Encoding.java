// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;


// Referenced classes of package org.apache.james.mime4j.codec:
//            EncoderUtil

public static final class  extends Enum
{

    private static final Q $VALUES[];
    public static final Q B;
    public static final Q Q;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/apache/james/mime4j/codec/EncoderUtil$Encoding, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        B = new <init>("B", 0);
        Q = new <init>("Q", 1);
        $VALUES = (new .VALUES[] {
            B, Q
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
