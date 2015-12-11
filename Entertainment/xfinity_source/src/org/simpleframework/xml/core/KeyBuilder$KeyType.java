// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            KeyBuilder

private static final class  extends Enum
{

    private static final ELEMENT $VALUES[];
    public static final ELEMENT ATTRIBUTE;
    public static final ELEMENT ELEMENT;
    public static final ELEMENT TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/simpleframework/xml/core/KeyBuilder$KeyType, s);
    }

    public static final [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TEXT = new <init>("TEXT", 0);
        ATTRIBUTE = new <init>("ATTRIBUTE", 1);
        ELEMENT = new <init>("ELEMENT", 2);
        $VALUES = (new .VALUES[] {
            TEXT, ATTRIBUTE, ELEMENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
