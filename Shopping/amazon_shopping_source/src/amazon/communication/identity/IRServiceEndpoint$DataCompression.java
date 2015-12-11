// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


// Referenced classes of package amazon.communication.identity:
//            IRServiceEndpoint

public static final class mName extends Enum
{

    private static final NOT_NEEDED $VALUES[];
    public static final NOT_NEEDED NEEDED;
    public static final NOT_NEEDED NOT_NEEDED;
    private final String mName;

    public static mName parse(String s)
    {
        if (s == null || s.trim().length() == 0)
        {
            throw new IllegalArgumentException("str must not be null or empty");
        }
        mName mname = NOT_NEEDED;
        if (s.equalsIgnoreCase(NEEDED.toString()))
        {
            return NEEDED;
        }
        if (s.equalsIgnoreCase(NOT_NEEDED.toString()))
        {
            return NOT_NEEDED;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("str: ").append(s).append(", cannot be parsed").toString());
        }
    }

    public static NOT_NEEDED valueOf(String s)
    {
        return (NOT_NEEDED)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$DataCompression, s);
    }

    public static NOT_NEEDED[] values()
    {
        return (NOT_NEEDED[])$VALUES.clone();
    }

    public String toString()
    {
        return mName;
    }

    static 
    {
        NEEDED = new <init>("NEEDED", 0, "needed");
        NOT_NEEDED = new <init>("NOT_NEEDED", 1, "not-needed");
        $VALUES = (new .VALUES[] {
            NEEDED, NOT_NEEDED
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}
