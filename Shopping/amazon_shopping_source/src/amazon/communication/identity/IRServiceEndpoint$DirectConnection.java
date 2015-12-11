// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


// Referenced classes of package amazon.communication.identity:
//            IRServiceEndpoint

public static final class mName extends Enum
{

    private static final NOT_ALLOWED $VALUES[];
    public static final NOT_ALLOWED ALLOWED;
    public static final NOT_ALLOWED NOT_ALLOWED;
    public static final NOT_ALLOWED REQUIRED;
    private final String mName;

    public static mName parse(String s)
    {
        if (s == null || s.trim().length() == 0)
        {
            throw new IllegalArgumentException("str must not be null or empty");
        }
        mName mname = NOT_ALLOWED;
        if (s.equalsIgnoreCase(REQUIRED.toString()))
        {
            return REQUIRED;
        }
        if (s.equalsIgnoreCase(ALLOWED.toString()))
        {
            return ALLOWED;
        }
        if (s.equalsIgnoreCase(NOT_ALLOWED.toString()))
        {
            return NOT_ALLOWED;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("str: ").append(s).append(", cannot be parsed").toString());
        }
    }

    public static NOT_ALLOWED valueOf(String s)
    {
        return (NOT_ALLOWED)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$DirectConnection, s);
    }

    public static NOT_ALLOWED[] values()
    {
        return (NOT_ALLOWED[])$VALUES.clone();
    }

    public String toString()
    {
        return mName;
    }

    static 
    {
        REQUIRED = new <init>("REQUIRED", 0, "required");
        ALLOWED = new <init>("ALLOWED", 1, "allowed");
        NOT_ALLOWED = new <init>("NOT_ALLOWED", 2, "not-allowed");
        $VALUES = (new .VALUES[] {
            REQUIRED, ALLOWED, NOT_ALLOWED
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}
