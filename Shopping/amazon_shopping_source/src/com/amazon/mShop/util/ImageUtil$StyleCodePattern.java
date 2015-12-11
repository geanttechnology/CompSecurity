// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.mShop.util:
//            ImageUtil

public static class mPattern
{

    private static final Pattern PATTERN_MSA_APPEND = Pattern.compile("(\\._.+?)(_{0,1}\\.\\w+$)");
    private static final Pattern PATTERN_MSA_INSERT_START = Pattern.compile("(\\._)(.+\\.\\w+$)");
    private Pattern mPattern;
    private String mStyleCode;

    public String appendTo(String s)
    {
        return appendTo(s, "");
    }

    public String appendTo(String s, String s1)
    {
        s1 = transformValue(s1);
        Matcher matcher = PATTERN_MSA_APPEND.matcher(s);
        if (matcher.find())
        {
            return matcher.replaceAll((new StringBuilder()).append("$1_").append(mStyleCode).append(s1).append("$2").toString());
        } else
        {
            return ImageUtil.access$000().matcher(s).replaceAll((new StringBuilder()).append("._").append(mStyleCode).append(s1).append("_$1").toString());
        }
    }

    public String insertAtStart(String s, String s1)
    {
        s1 = transformValue(s1);
        Matcher matcher = PATTERN_MSA_INSERT_START.matcher(s);
        if (matcher.find())
        {
            return matcher.replaceAll((new StringBuilder()).append("$1").append(mStyleCode).append(s1).append("_$2").toString());
        } else
        {
            return ImageUtil.access$000().matcher(s).replaceAll((new StringBuilder()).append("._").append(mStyleCode).append(s1).append("_$1").toString());
        }
    }

    public String replaceIn(String s, String s1)
    {
        return replaceIn(s, s1, false);
    }

    public String replaceIn(String s, String s1, boolean flag)
    {
        Matcher matcher = mPattern.matcher(s);
        if (matcher.find())
        {
            return matcher.replaceAll((new StringBuilder()).append("$1").append(transformValue(s1)).append("$3").toString());
        }
        if (flag)
        {
            return insertAtStart(s, s1);
        } else
        {
            return appendTo(s, s1);
        }
    }

    protected String transformValue(String s)
    {
        return s;
    }


    public (String s)
    {
        mStyleCode = s;
        mPattern = Pattern.compile((new StringBuilder()).append("(_").append(s).append(")([^_\\.]*)(_|_?\\.\\w+$)").toString());
    }
}
