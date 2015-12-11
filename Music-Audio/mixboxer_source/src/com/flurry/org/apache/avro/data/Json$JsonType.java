// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.data;


// Referenced classes of package com.flurry.org.apache.avro.data:
//            Json

private static final class  extends Enum
{

    private static final OBJECT $VALUES[];
    public static final OBJECT ARRAY;
    public static final OBJECT BOOLEAN;
    public static final OBJECT DOUBLE;
    public static final OBJECT LONG;
    public static final OBJECT NULL;
    public static final OBJECT OBJECT;
    public static final OBJECT STRING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flurry/org/apache/avro/data/Json$JsonType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LONG = new <init>("LONG", 0);
        DOUBLE = new <init>("DOUBLE", 1);
        STRING = new <init>("STRING", 2);
        BOOLEAN = new <init>("BOOLEAN", 3);
        NULL = new <init>("NULL", 4);
        ARRAY = new <init>("ARRAY", 5);
        OBJECT = new <init>("OBJECT", 6);
        $VALUES = (new .VALUES[] {
            LONG, DOUBLE, STRING, BOOLEAN, NULL, ARRAY, OBJECT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
