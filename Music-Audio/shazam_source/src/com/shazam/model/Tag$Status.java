// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


// Referenced classes of package com.shazam.model:
//            Tag

public static final class dbString extends Enum
{

    private static final VISUAL $VALUES[];
    public static final VISUAL BEAMED;
    public static final VISUAL FROM_BACKUP;
    public static final VISUAL MANUALLY_ADDED;
    public static final VISUAL SUCCESSFUL;
    public static final VISUAL UNKNOWN;
    public static final VISUAL UNSUBMITTED;
    public static final VISUAL UNSUCCESSFUL;
    public static final VISUAL VISUAL;
    private final String dbString;

    public static dbString getStatusForName(String s, dbString dbstring)
    {
        dbString adbstring[] = values();
        int j = adbstring.length;
        int i = 0;
        do
        {
label0:
            {
                dbString dbstring1 = dbstring;
                if (i < j)
                {
                    dbstring1 = adbstring[i];
                    if (!dbstring1.dbString.equals(s))
                    {
                        break label0;
                    }
                }
                return dbstring1;
            }
            i++;
        } while (true);
    }

    public static dbString valueOf(String s)
    {
        return (dbString)Enum.valueOf(com/shazam/model/Tag$Status, s);
    }

    public static dbString[] values()
    {
        return (dbString[])$VALUES.clone();
    }

    public final String getDbString()
    {
        return dbString;
    }

    public final boolean isLyricPlayAllowed()
    {
        return this == SUCCESSFUL;
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, "UNKNOWN");
        BEAMED = new <init>("BEAMED", 1, "BEAMED");
        UNSUBMITTED = new <init>("UNSUBMITTED", 2, "UNSUBMITTED");
        SUCCESSFUL = new <init>("SUCCESSFUL", 3, "SUCCESSFUL");
        UNSUCCESSFUL = new <init>("UNSUCCESSFUL", 4, "UNSUCCESSFUL");
        MANUALLY_ADDED = new <init>("MANUALLY_ADDED", 5, "MANUALLY_ADDED");
        FROM_BACKUP = new <init>("FROM_BACKUP", 6, "FROM_BACKUP");
        VISUAL = new <init>("VISUAL", 7, "VISUAL");
        $VALUES = (new .VALUES[] {
            UNKNOWN, BEAMED, UNSUBMITTED, SUCCESSFUL, UNSUCCESSFUL, MANUALLY_ADDED, FROM_BACKUP, VISUAL
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        dbString = s1;
    }
}
