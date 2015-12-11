// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


public final class Priority extends Enum
{

    private static final Priority $VALUES[];
    public static final Priority PRIORITY_HIGH;
    public static final Priority PRIORITY_LOW;
    public static final Priority PRIORITY_NORMAL;

    private Priority(String s, int i)
    {
        super(s, i);
    }

    public static Priority valueOf(String s)
    {
        return (Priority)Enum.valueOf(amazon/communication/connection/Priority, s);
    }

    public static Priority[] values()
    {
        return (Priority[])$VALUES.clone();
    }

    static 
    {
        PRIORITY_HIGH = new Priority("PRIORITY_HIGH", 0);
        PRIORITY_NORMAL = new Priority("PRIORITY_NORMAL", 1);
        PRIORITY_LOW = new Priority("PRIORITY_LOW", 2);
        $VALUES = (new Priority[] {
            PRIORITY_HIGH, PRIORITY_NORMAL, PRIORITY_LOW
        });
    }
}
