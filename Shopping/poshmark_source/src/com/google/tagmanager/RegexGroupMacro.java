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
//            FunctionCallImplementation, Types

class RegexGroupMacro extends FunctionCallImplementation
{

    private static final String GROUP;
    private static final String ID;
    private static final String IGNORE_CASE;
    private static final String REGEX;
    private static final String TO_MATCH;

    public RegexGroupMacro()
    {
        super(ID, new String[] {
            TO_MATCH, REGEX
        });
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        Object obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(TO_MATCH);
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(REGEX);
        if (obj == null || obj == Types.getDefaultValue() || value == null || value == Types.getDefaultValue())
        {
            return Types.getDefaultValue();
        }
        int i = 64;
        if (Types.valueToBoolean((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(IGNORE_CASE)).booleanValue())
        {
            i = 0x40 | 2;
        }
        int j = 1;
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(GROUP);
        if (map != null)
        {
            map = Types.valueToInt64(map);
            if (map == Types.getDefaultInt64())
            {
                return Types.getDefaultValue();
            }
            int k = map.intValue();
            j = k;
            if (k < 0)
            {
                return Types.getDefaultValue();
            }
        }
        try
        {
            map = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
            obj = Types.valueToString(value);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return Types.getDefaultValue();
        }
        value = null;
        obj = Pattern.compile(((String) (obj)), i).matcher(map);
        map = value;
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_188;
        }
        map = value;
        if (((Matcher) (obj)).groupCount() >= j)
        {
            map = ((Matcher) (obj)).group(j);
        }
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        return Types.getDefaultValue();
        map = Types.objectToValue(map);
        return map;
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.REGEX_GROUP.toString();
        TO_MATCH = Key.ARG0.toString();
        REGEX = Key.ARG1.toString();
        IGNORE_CASE = Key.IGNORE_CASE.toString();
        GROUP = Key.GROUP.toString();
    }
}
