// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;


// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericData

public static final class  extends Enum
{

    private static final Utf8 $VALUES[];
    public static final Utf8 CharSequence;
    public static final Utf8 String;
    public static final Utf8 Utf8;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flurry/org/apache/avro/generic/GenericData$StringType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CharSequence = new <init>("CharSequence", 0);
        String = new <init>("String", 1);
        Utf8 = new <init>("Utf8", 2);
        $VALUES = (new .VALUES[] {
            CharSequence, String, Utf8
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
