// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.text.TextUtils;
import java.io.Serializable;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            PinyinUtils

public class Country
    implements Serializable, Comparable
{

    public static final String CHINA_CODE = "0086";
    private static final long serialVersionUID = 0L;
    private String code;
    private String mccs[];
    private String name;
    private String pinyin;

    public Country()
    {
    }

    public Country(String s, String s1)
    {
        name = s;
        code = s1;
    }

    public int compareTo(Country country)
    {
        if (TextUtils.isEmpty(pinyin))
        {
            return -1;
        }
        if (country == null || TextUtils.isEmpty(country.pinyin))
        {
            return 1;
        } else
        {
            return pinyin.compareTo(country.pinyin);
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Country)obj);
    }

    public String getCode()
    {
        return code;
    }

    public String[] getMccs()
    {
        return mccs;
    }

    public String getName()
    {
        return name;
    }

    public String getPinyin()
    {
        return PinyinUtils.getObject().getPinyin(name).toLowerCase();
    }

    public void setCode(String s)
    {
        code = s;
    }

    public void setMccs(String as[])
    {
        mccs = as;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPinyin(String s)
    {
        pinyin = s;
    }
}
