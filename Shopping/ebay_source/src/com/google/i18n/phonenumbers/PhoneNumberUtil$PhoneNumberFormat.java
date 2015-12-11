// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.i18n.phonenumbers;


// Referenced classes of package com.google.i18n.phonenumbers:
//            PhoneNumberUtil

public static final class  extends Enum
{

    private static final RFC3966 $VALUES[];
    public static final RFC3966 E164;
    public static final RFC3966 INTERNATIONAL;
    public static final RFC3966 NATIONAL;
    public static final RFC3966 RFC3966;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/i18n/phonenumbers/PhoneNumberUtil$PhoneNumberFormat, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        E164 = new <init>("E164", 0);
        INTERNATIONAL = new <init>("INTERNATIONAL", 1);
        NATIONAL = new <init>("NATIONAL", 2);
        RFC3966 = new <init>("RFC3966", 3);
        $VALUES = (new .VALUES[] {
            E164, INTERNATIONAL, NATIONAL, RFC3966
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
