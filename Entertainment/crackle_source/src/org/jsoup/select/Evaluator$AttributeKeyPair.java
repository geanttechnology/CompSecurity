// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import org.jsoup.helper.Validate;

// Referenced classes of package org.jsoup.select:
//            Evaluator

public static abstract class value extends Evaluator
{

    String key;
    String value;

    public (String s, String s1)
    {
        Validate.notEmpty(s);
        Validate.notEmpty(s1);
        key = s.trim().toLowerCase();
        value = s1.trim().toLowerCase();
    }
}
