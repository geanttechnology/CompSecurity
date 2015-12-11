// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.common;


public final class TranslateToObfuscatedCustomerIdFrom extends Enum
{

    private static final TranslateToObfuscatedCustomerIdFrom $VALUES[];
    public static final TranslateToObfuscatedCustomerIdFrom DIRECTED_ID;
    public static final TranslateToObfuscatedCustomerIdFrom NO_TRANSLATION;
    private final String mType;

    private TranslateToObfuscatedCustomerIdFrom(String s, int i, String s1)
    {
        super(s, i);
        mType = s1;
    }

    public static TranslateToObfuscatedCustomerIdFrom fromSerializedForm(String s)
    {
        Object obj = null;
        TranslateToObfuscatedCustomerIdFrom atranslatetoobfuscatedcustomeridfrom[] = values();
        int j = atranslatetoobfuscatedcustomeridfrom.length;
        int i = 0;
        do
        {
label0:
            {
                TranslateToObfuscatedCustomerIdFrom translatetoobfuscatedcustomeridfrom = obj;
                if (i < j)
                {
                    translatetoobfuscatedcustomeridfrom = atranslatetoobfuscatedcustomeridfrom[i];
                    if (!translatetoobfuscatedcustomeridfrom.toSerializedForm().equals(s))
                    {
                        break label0;
                    }
                }
                return translatetoobfuscatedcustomeridfrom;
            }
            i++;
        } while (true);
    }

    public static TranslateToObfuscatedCustomerIdFrom valueOf(String s)
    {
        return (TranslateToObfuscatedCustomerIdFrom)Enum.valueOf(com/amazon/bluefront/api/common/TranslateToObfuscatedCustomerIdFrom, s);
    }

    public static TranslateToObfuscatedCustomerIdFrom[] values()
    {
        return (TranslateToObfuscatedCustomerIdFrom[])$VALUES.clone();
    }

    public String toSerializedForm()
    {
        return mType;
    }

    static 
    {
        DIRECTED_ID = new TranslateToObfuscatedCustomerIdFrom("DIRECTED_ID", 0, "DIRECTED_ID");
        NO_TRANSLATION = new TranslateToObfuscatedCustomerIdFrom("NO_TRANSLATION", 1, "NO_TRANSLATION");
        $VALUES = (new TranslateToObfuscatedCustomerIdFrom[] {
            DIRECTED_ID, NO_TRANSLATION
        });
    }
}
