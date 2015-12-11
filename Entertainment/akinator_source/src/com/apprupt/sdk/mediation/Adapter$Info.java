// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.mediation;


// Referenced classes of package com.apprupt.sdk.mediation:
//            Adapter

public static final class  extends Enum
{

    private static final CLIPKIT $VALUES[];
    public static final CLIPKIT ADCOLONY;
    public static final CLIPKIT ADMOB;
    public static final CLIPKIT APPRUPT;
    public static final CLIPKIT CLIPKIT;
    public static final CLIPKIT DOUBLECLICK;
    public static final CLIPKIT MOPUB;

    public static String[] defaultOrder()
    {
        String as[] = new String[values().length];
        as[0] = ADCOLONY.toString();
        as[1] = APPRUPT.toString();
        as[2] = ADMOB.toString();
        as[3] = DOUBLECLICK.toString();
        as[4] = MOPUB.toString();
        as[5] = CLIPKIT.toString();
        return as;
    }

    public static String[] names()
    {
        toString atostring[] = values();
        String as[] = new String[atostring.length];
        int j = 0;
        int k = atostring.length;
        for (int i = 0; i < k; i++)
        {
            as[j] = atostring[i].toString();
            j++;
        }

        return as;
    }

    public static toString valueOf(String s)
    {
        return (toString)Enum.valueOf(com/apprupt/sdk/mediation/Adapter$Info, s);
    }

    public static toString[] values()
    {
        return (toString[])$VALUES.clone();
    }

    public o_3B_.clone fromString(String s)
    {
        o_3B_.clone aclone[] = values();
        int j = aclone.length;
        for (int i = 0; i < j; i++)
        {
            o_3B_.clone clone = aclone[i];
            if (clone.toString().equals(s))
            {
                return clone;
            }
        }

        return null;
    }

    public String toClassName()
    {
        switch (itchMap.com.apprupt.sdk.mediation.Adapter.Info[ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return "com.apprupt.sdk.CvAdapter";

        case 2: // '\002'
            return "com.apprupt.sdk.AdColonyAdapter";

        case 3: // '\003'
            return "com.apprupt.mediation.mopub.Adapter";

        case 4: // '\004'
            return "com.apprupt.mediation.google.AdMobAdapter";

        case 5: // '\005'
            return "com.apprupt.mediation.google.DoubleclickAdapter";

        case 6: // '\006'
            return "com.apprupt.mediation.clipkit.Adapter";
        }
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }

    static 
    {
        APPRUPT = new <init>("APPRUPT", 0);
        ADCOLONY = new <init>("ADCOLONY", 1);
        MOPUB = new <init>("MOPUB", 2);
        ADMOB = new <init>("ADMOB", 3);
        DOUBLECLICK = new <init>("DOUBLECLICK", 4);
        CLIPKIT = new <init>("CLIPKIT", 5);
        $VALUES = (new .VALUES[] {
            APPRUPT, ADCOLONY, MOPUB, ADMOB, DOUBLECLICK, CLIPKIT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
