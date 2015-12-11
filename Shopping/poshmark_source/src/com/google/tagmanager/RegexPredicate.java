// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.google.tagmanager:
//            StringPredicate, Types

class RegexPredicate extends StringPredicate
{

    private static final String ID;
    private static final String IGNORE_CASE;

    public RegexPredicate()
    {
        super(ID);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public static String getIgnoreCaseKey()
    {
        return IGNORE_CASE;
    }

    protected boolean evaluateString(String s, String s1, Map map)
    {
        int i = 64;
        if (Types.valueToBoolean((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(IGNORE_CASE)).booleanValue())
        {
            i = 0x40 | 2;
        }
        boolean flag;
        try
        {
            flag = Pattern.compile(s1, i).matcher(s).find();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    static 
    {
        ID = FunctionType.REGEX.toString();
        IGNORE_CASE = Key.IGNORE_CASE.toString();
    }
}
