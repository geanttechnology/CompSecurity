// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            Configuration

public static final class name extends Enum
{

    private static final EXTERNAL $VALUES[];
    public static final EXTERNAL DROPBOX;
    public static final EXTERNAL EXTERNAL;
    public static final EXTERNAL NONE;
    public static final EXTERNAL PRIVATE_DATA;
    private String name;

    public static name fromString(String s)
    {
        name name1 = NONE;
        if (DROPBOX.getName().equalsIgnoreCase(s))
        {
            name1 = DROPBOX;
        } else
        {
            if (PRIVATE_DATA.getName().equalsIgnoreCase(s))
            {
                return PRIVATE_DATA;
            }
            if (EXTERNAL.getName().equalsIgnoreCase(s))
            {
                return EXTERNAL;
            }
        }
        return name1;
    }

    public static EXTERNAL valueOf(String s)
    {
        return (EXTERNAL)Enum.valueOf(com/amazon/sdk/availability/Configuration$PersistenceFormat, s);
    }

    public static EXTERNAL[] values()
    {
        return (EXTERNAL[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        NONE = new <init>("NONE", 0, "None");
        DROPBOX = new <init>("DROPBOX", 1, "DropBox");
        PRIVATE_DATA = new <init>("PRIVATE_DATA", 2, "PrivateData");
        EXTERNAL = new <init>("EXTERNAL", 3, "External");
        $VALUES = (new .VALUES[] {
            NONE, DROPBOX, PRIVATE_DATA, EXTERNAL
        });
    }

    private A(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
