// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


// Referenced classes of package amazon.communication.connection:
//            ConnectionPolicy

public static final class  extends Enum
{

    private static final NOT_ALLOWED $VALUES[];
    public static final NOT_ALLOWED ALLOWED;
    public static final NOT_ALLOWED NOT_ALLOWED;
    public static final NOT_ALLOWED REQUIRED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(amazon/communication/connection/ConnectionPolicy$CompressionOption, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REQUIRED = new <init>("REQUIRED", 0);
        ALLOWED = new <init>("ALLOWED", 1);
        NOT_ALLOWED = new <init>("NOT_ALLOWED", 2);
        $VALUES = (new .VALUES[] {
            REQUIRED, ALLOWED, NOT_ALLOWED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
