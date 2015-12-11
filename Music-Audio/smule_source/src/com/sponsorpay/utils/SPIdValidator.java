// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.sponsorpay.utils:
//            StringUtils, SPIdException

public class SPIdValidator
{

    private static Pattern PATTERN = Pattern.compile("^[A-Z0-9_]+$");

    public SPIdValidator()
    {
    }

    public static void validate(String s)
    {
        if (StringUtils.nullOrEmpty(s))
        {
            throw new SPIdException("An ID cannot be null or empty.");
        }
        if (!PATTERN.matcher(s).find())
        {
            throw new SPIdException("An ID can only contain uppercase letters, numbers and the _ underscore symbol.");
        } else
        {
            return;
        }
    }

}
