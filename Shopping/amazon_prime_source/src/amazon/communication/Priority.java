// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;


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
        return (Priority)Enum.valueOf(amazon/communication/Priority, s);
    }

    public static Priority[] values()
    {
        return (Priority[])$VALUES.clone();
    }

    public amazon.communication.connection.Priority convertToConnectionPriority()
    {
        static class _cls1
        {

            static final int $SwitchMap$amazon$communication$Priority[];

            static 
            {
                $SwitchMap$amazon$communication$Priority = new int[Priority.values().length];
                try
                {
                    $SwitchMap$amazon$communication$Priority[Priority.PRIORITY_HIGH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$amazon$communication$Priority[Priority.PRIORITY_NORMAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.amazon.communication.Priority[ordinal()])
        {
        default:
            return amazon.communication.connection.Priority.PRIORITY_LOW;

        case 1: // '\001'
            return amazon.communication.connection.Priority.PRIORITY_HIGH;

        case 2: // '\002'
            return amazon.communication.connection.Priority.PRIORITY_NORMAL;
        }
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
