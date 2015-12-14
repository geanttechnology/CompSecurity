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
        mName amname[] = values();
        int j = amname.length;
        for (int i = 0; i < j; i++)
        {
            mName mname = amname[i];
            if (mname.toString().equalsIgnoreCase(s))
            {
                return mname;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("str: \"").append(s).append("\", cannot be parsed").toString());
    }

    public static toString valueOf(String s)
    {
        return (toString)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$DirectConnection, s);
    }

    public static toString[] values()
    {
        return (toString[])$VALUES.clone();
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
