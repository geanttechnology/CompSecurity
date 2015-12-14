// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package opens.components.http;


public final class EOnlineDownType extends Enum
{

    private static final EOnlineDownType $VALUES[];
    public static final EOnlineDownType FILTERDOWNLOAD;
    public static final EOnlineDownType NEWCOUNT;
    public static final EOnlineDownType NEWCOUNTCHECKER;
    public static final EOnlineDownType UPDATE;

    private EOnlineDownType(String s, int i)
    {
        super(s, i);
    }

    public static EOnlineDownType valueOf(String s)
    {
        return (EOnlineDownType)Enum.valueOf(opens/components/http/EOnlineDownType, s);
    }

    public static EOnlineDownType[] values()
    {
        return (EOnlineDownType[])$VALUES.clone();
    }

    static 
    {
        UPDATE = new EOnlineDownType("UPDATE", 0);
        NEWCOUNT = new EOnlineDownType("NEWCOUNT", 1);
        FILTERDOWNLOAD = new EOnlineDownType("FILTERDOWNLOAD", 2);
        NEWCOUNTCHECKER = new EOnlineDownType("NEWCOUNTCHECKER", 3);
        $VALUES = (new EOnlineDownType[] {
            UPDATE, NEWCOUNT, FILTERDOWNLOAD, NEWCOUNTCHECKER
        });
    }
}
