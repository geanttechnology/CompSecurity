// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            WebResponseParser

private static final class  extends Enum
{

    private static final Completed $VALUES[];
    public static final Completed Before_Parse;
    public static final Completed Begin_Parse;
    public static final Completed Completed;
    public static final Completed Parsing;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Before_Parse = new <init>("Before_Parse", 0);
        Begin_Parse = new <init>("Begin_Parse", 1);
        Parsing = new <init>("Parsing", 2);
        Completed = new <init>("Completed", 3);
        $VALUES = (new .VALUES[] {
            Before_Parse, Begin_Parse, Parsing, Completed
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
