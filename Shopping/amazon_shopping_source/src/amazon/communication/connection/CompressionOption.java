// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


public final class CompressionOption extends Enum
{

    private static final CompressionOption $VALUES[];
    public static final CompressionOption ALLOWED;
    public static final CompressionOption NOT_ALLOWED;
    public static final CompressionOption REQUIRED;

    private CompressionOption(String s, int i)
    {
        super(s, i);
    }

    public static CompressionOption valueOf(String s)
    {
        return (CompressionOption)Enum.valueOf(amazon/communication/connection/CompressionOption, s);
    }

    public static CompressionOption[] values()
    {
        return (CompressionOption[])$VALUES.clone();
    }

    static 
    {
        REQUIRED = new CompressionOption("REQUIRED", 0);
        ALLOWED = new CompressionOption("ALLOWED", 1);
        NOT_ALLOWED = new CompressionOption("NOT_ALLOWED", 2);
        $VALUES = (new CompressionOption[] {
            REQUIRED, ALLOWED, NOT_ALLOWED
        });
    }
}
