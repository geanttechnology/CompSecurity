// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;


// Referenced classes of package com.target.ui.util:
//            i

public static final class prefValue extends Enum
{

    private static final UAT $VALUES[];
    public static final UAT Production;
    public static final UAT Stage;
    public static final UAT UAT;
    public String prefValue;

    static prefValue a(String s)
    {
        prefValue aprefvalue[] = values();
        int k = aprefvalue.length;
        for (int j = 0; j < k; j++)
        {
            prefValue prefvalue = aprefvalue[j];
            if (prefvalue.prefValue.equalsIgnoreCase(s))
            {
                return prefvalue;
            }
        }

        return UAT;
    }

    public static UAT valueOf(String s)
    {
        return (UAT)Enum.valueOf(com/target/ui/util/i$a, s);
    }

    public static UAT[] values()
    {
        return (UAT[])$VALUES.clone();
    }

    static 
    {
        Production = new <init>("Production", 0, "Production");
        Stage = new <init>("Stage", 1, "Stage");
        UAT = new <init>("UAT", 2, "UAT");
        $VALUES = (new .VALUES[] {
            Production, Stage, UAT
        });
    }

    private (String s, int j, String s1)
    {
        super(s, j);
        prefValue = s1;
    }
}
