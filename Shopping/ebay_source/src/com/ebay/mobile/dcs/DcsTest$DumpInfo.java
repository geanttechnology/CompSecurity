// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import java.util.Map;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsTest

private static final class key
{

    private static final String NOT_SET = "[Not set]";
    public String configurationValue;
    public Object defaultValue;
    public Object evaluatedValue;
    public final String key;

    public static key get(Map map, String s)
    {
        key key2 = (key)map.get(s);
        key key1 = key2;
        if (key2 == null)
        {
            key1 = new <init>(s);
            map.put(s, key1);
        }
        return key1;
    }

    public static <init> remove(Map map, String s)
    {
        <init> <init>1 = (<init>)map.remove(s);
        map = <init>1;
        if (<init>1 == null)
        {
            map = new <init>(s);
        }
        return map;
    }

    public String toString()
    {
        return (new StringBuilder()).append(key).append("\n{\n  default:").append(defaultValue).append("\n  evaluated:").append(evaluatedValue).append("\n  configValue:").append(configurationValue).append("\n}").toString();
    }

    public (String s)
    {
        defaultValue = "[Not set]";
        evaluatedValue = "[Not set]";
        configurationValue = "[Not set]";
        key = s;
    }
}
