// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;


// Referenced classes of package net.singular.sdk:
//            KeyValueStore

public static final class  extends Enum
{

    private static final BOOLEAN $VALUES[];
    public static final BOOLEAN BOOLEAN;
    public static final BOOLEAN LONG;
    public static final BOOLEAN STRING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(net/singular/sdk/KeyValueStore$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STRING = new <init>("STRING", 0);
        LONG = new <init>("LONG", 1);
        BOOLEAN = new <init>("BOOLEAN", 2);
        $VALUES = (new .VALUES[] {
            STRING, LONG, BOOLEAN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
