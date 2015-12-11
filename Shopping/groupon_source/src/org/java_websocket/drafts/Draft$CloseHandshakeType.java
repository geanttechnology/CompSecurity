// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.drafts;


// Referenced classes of package org.java_websocket.drafts:
//            Draft

public static final class  extends Enum
{

    private static final TWOWAY $VALUES[];
    public static final TWOWAY NONE;
    public static final TWOWAY ONEWAY;
    public static final TWOWAY TWOWAY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/java_websocket/drafts/Draft$CloseHandshakeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        ONEWAY = new <init>("ONEWAY", 1);
        TWOWAY = new <init>("TWOWAY", 2);
        $VALUES = (new .VALUES[] {
            NONE, ONEWAY, TWOWAY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
