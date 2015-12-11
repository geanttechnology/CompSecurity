// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.drafts;


// Referenced classes of package org.java_websocket.drafts:
//            Draft

public static final class  extends Enum
{

    private static final NOT_MATCHED $VALUES[];
    public static final NOT_MATCHED MATCHED;
    public static final NOT_MATCHED NOT_MATCHED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/java_websocket/drafts/Draft$HandshakeState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MATCHED = new <init>("MATCHED", 0);
        NOT_MATCHED = new <init>("NOT_MATCHED", 1);
        $VALUES = (new .VALUES[] {
            MATCHED, NOT_MATCHED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
