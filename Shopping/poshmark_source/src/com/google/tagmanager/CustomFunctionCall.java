// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types, Log

class CustomFunctionCall extends FunctionCallImplementation
{
    public static interface CustomEvaluator
    {

        public abstract Object evaluate(String s, Map map);
    }


    private static final String ADDITIONAL_PARAMS;
    private static final String FUNCTION_CALL_NAME;
    private static final String ID;
    private final CustomEvaluator mFunctionCallEvaluator;

    public CustomFunctionCall(CustomEvaluator customevaluator)
    {
        super(ID, new String[] {
            FUNCTION_CALL_NAME
        });
        mFunctionCallEvaluator = customevaluator;
    }

    public static String getAdditionalParamsKey()
    {
        return ADDITIONAL_PARAMS;
    }

    public static String getFunctionCallNameKey()
    {
        return FUNCTION_CALL_NAME;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        String s = Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(FUNCTION_CALL_NAME));
        HashMap hashmap = new HashMap();
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ADDITIONAL_PARAMS);
        if (map != null)
        {
            map = ((Map) (Types.valueToObject(map)));
            if (!(map instanceof Map))
            {
                Log.w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return Types.getDefaultValue();
            }
            java.util.Map.Entry entry;
            for (map = ((Map)map).entrySet().iterator(); map.hasNext(); hashmap.put(entry.getKey().toString(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        try
        {
            map = Types.objectToValue(mFunctionCallEvaluator.evaluate(s, hashmap));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.w((new StringBuilder()).append("Custom macro/tag ").append(s).append(" threw exception ").append(map.getMessage()).toString());
            return Types.getDefaultValue();
        }
        return map;
    }

    public boolean isCacheable()
    {
        return false;
    }

    static 
    {
        ID = FunctionType.FUNCTION_CALL.toString();
        FUNCTION_CALL_NAME = Key.FUNCTION_CALL_NAME.toString();
        ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
    }
}
