// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            Defines

public static final class key extends Enum
{

    private static final Data $VALUES[];
    public static final Data Alias;
    public static final Data Channel;
    public static final Data Data;
    public static final Data Duration;
    public static final Data Feature;
    public static final Data Stage;
    public static final Data Tags;
    public static final Data Type;
    private String key;

    public static key valueOf(String s)
    {
        return (key)Enum.valueOf(io/branch/referral/Defines$LinkParam, s);
    }

    public static key[] values()
    {
        return (key[])$VALUES.clone();
    }

    public String getKey()
    {
        return key;
    }

    public String toString()
    {
        return key;
    }

    static 
    {
        Tags = new <init>("Tags", 0, "tags");
        Alias = new <init>("Alias", 1, "alias");
        Type = new <init>("Type", 2, "type");
        Duration = new <init>("Duration", 3, "duration");
        Channel = new <init>("Channel", 4, "channel");
        Feature = new <init>("Feature", 5, "feature");
        Stage = new <init>("Stage", 6, "stage");
        Data = new <init>("Data", 7, "data");
        $VALUES = (new .VALUES[] {
            Tags, Alias, Type, Duration, Channel, Feature, Stage, Data
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        key = "";
        key = s1;
    }
}
