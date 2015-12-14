// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;


// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Data

public static final class  extends Enum
{

    public static final HISTORY CONTACTS;
    public static final HISTORY CUSTOMWORDS;
    public static final HISTORY HISTORY;
    private static final HISTORY a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/nuance/nmdp/speechkit/util/dataupload/Data$DataType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        CONTACTS = new <init>("CONTACTS", 0);
        CUSTOMWORDS = new <init>("CUSTOMWORDS", 1);
        HISTORY = new <init>("HISTORY", 2);
        a = (new a[] {
            CONTACTS, CUSTOMWORDS, HISTORY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
