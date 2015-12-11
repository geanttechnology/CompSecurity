// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


public final class KeepAlive extends Enum
{

    private static final KeepAlive $VALUES[];
    public static final KeepAlive ADAPTIVE;
    public static final KeepAlive NONE;
    public static final KeepAlive STATIC;

    private KeepAlive(String s, int i)
    {
        super(s, i);
    }

    public static KeepAlive valueOf(String s)
    {
        return (KeepAlive)Enum.valueOf(amazon/communication/connection/KeepAlive, s);
    }

    public static KeepAlive[] values()
    {
        return (KeepAlive[])$VALUES.clone();
    }

    static 
    {
        NONE = new KeepAlive("NONE", 0);
        STATIC = new KeepAlive("STATIC", 1);
        ADAPTIVE = new KeepAlive("ADAPTIVE", 2);
        $VALUES = (new KeepAlive[] {
            NONE, STATIC, ADAPTIVE
        });
    }
}
