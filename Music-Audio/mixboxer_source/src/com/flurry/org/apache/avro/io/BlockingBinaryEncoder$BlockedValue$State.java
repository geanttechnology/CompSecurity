// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;


// Referenced classes of package com.flurry.org.apache.avro.io:
//            BlockingBinaryEncoder

public static final class  extends Enum
{

    private static final OVERFLOW $VALUES[];
    public static final OVERFLOW OVERFLOW;
    public static final OVERFLOW REGULAR;
    public static final OVERFLOW ROOT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flurry/org/apache/avro/io/BlockingBinaryEncoder$BlockedValue$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ROOT = new <init>("ROOT", 0);
        REGULAR = new <init>("REGULAR", 1);
        OVERFLOW = new <init>("OVERFLOW", 2);
        $VALUES = (new .VALUES[] {
            ROOT, REGULAR, OVERFLOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
