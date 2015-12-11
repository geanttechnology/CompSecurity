// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;


// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchView

private static final class mLocaleString extends Enum
{

    private static final EN_US $VALUES[];
    public static final EN_US DE_DE;
    public static final EN_US EN_CA;
    public static final EN_US EN_GB;
    public static final EN_US EN_IN;
    public static final EN_US EN_US;
    public static final EN_US ES_ES;
    public static final EN_US FR_CA;
    public static final EN_US FR_FR;
    public static final EN_US IT_IT;
    public static final EN_US JA_JP;
    public static final EN_US ZH_CN;
    private int mIconDrawableId;
    private String mLocaleString;

    public static mLocaleString valueOf(String s)
    {
        return (mLocaleString)Enum.valueOf(com/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem, s);
    }

    public static mLocaleString[] values()
    {
        return (mLocaleString[])$VALUES.clone();
    }

    public int getIconDrawableId()
    {
        return mIconDrawableId;
    }

    public String getLocaleString()
    {
        return mLocaleString;
    }

    static 
    {
        EN_CA = new <init>("EN_CA", 0, com.amazon.mShop.android.lib., "en_CA");
        FR_CA = new <init>("FR_CA", 1, com.amazon.mShop.android.lib., "fr_CA");
        ZH_CN = new <init>("ZH_CN", 2, com.amazon.mShop.android.lib., "zh_CN");
        DE_DE = new <init>("DE_DE", 3, com.amazon.mShop.android.lib., "de_DE");
        ES_ES = new <init>("ES_ES", 4, com.amazon.mShop.android.lib., "es_ES");
        FR_FR = new <init>("FR_FR", 5, com.amazon.mShop.android.lib., "fr_FR");
        EN_IN = new <init>("EN_IN", 6, com.amazon.mShop.android.lib., "en_IN");
        IT_IT = new <init>("IT_IT", 7, com.amazon.mShop.android.lib., "it_IT");
        JA_JP = new <init>("JA_JP", 8, com.amazon.mShop.android.lib., "ja_JP");
        EN_GB = new <init>("EN_GB", 9, com.amazon.mShop.android.lib., "en_GB");
        EN_US = new <init>("EN_US", 10, com.amazon.mShop.android.lib., "en_US");
        $VALUES = (new .VALUES[] {
            EN_CA, FR_CA, ZH_CN, DE_DE, ES_ES, FR_FR, EN_IN, IT_IT, JA_JP, EN_GB, 
            EN_US
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mIconDrawableId = j;
        mLocaleString = s1;
    }
}
