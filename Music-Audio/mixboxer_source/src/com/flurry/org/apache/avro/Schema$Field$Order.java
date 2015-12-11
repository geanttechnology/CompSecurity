// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;


// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

public static final class name extends Enum
{

    private static final IGNORE $VALUES[];
    public static final IGNORE ASCENDING;
    public static final IGNORE DESCENDING;
    public static final IGNORE IGNORE;
    private String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/flurry/org/apache/avro/Schema$Field$Order, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        ASCENDING = new <init>("ASCENDING", 0);
        DESCENDING = new <init>("DESCENDING", 1);
        IGNORE = new <init>("IGNORE", 2);
        $VALUES = (new .VALUES[] {
            ASCENDING, DESCENDING, IGNORE
        });
    }


    private (String s, int i)
    {
        super(s, i);
        name = name().toLowerCase();
    }
}
