// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types, Base16, Base64Encoder, 
//            Log

class EncodeMacro extends FunctionCallImplementation
{

    private static final String ARG0;
    private static final String DEFAULT_INPUT_FORMAT = "text";
    private static final String DEFAULT_OUTPUT_FORMAT = "base16";
    private static final String ID;
    private static final String INPUT_FORMAT;
    private static final String NO_PADDING;
    private static final String OUTPUT_FORMAT;

    public EncodeMacro()
    {
        super(ID, new String[] {
            ARG0
        });
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        Object obj;
        String s;
        String s1;
        int i;
        obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ARG0);
        if (obj == null || obj == Types.getDefaultValue())
        {
            return Types.getDefaultValue();
        }
        s1 = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(INPUT_FORMAT);
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value;
        boolean flag;
        if (obj == null)
        {
            s = "text";
        } else
        {
            s = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        }
        obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(OUTPUT_FORMAT);
        if (obj == null)
        {
            obj = "base16";
        } else
        {
            obj = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        }
        value = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(INPUT_FORMAT);
        flag = false;
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(NO_PADDING);
        i = ((flag) ? 1 : 0);
        if (map != null)
        {
            i = ((flag) ? 1 : 0);
            if (Types.valueToBoolean(map).booleanValue())
            {
                i = false | true;
            }
        }
        if (!"text".equals(s)) goto _L2; else goto _L1
_L1:
        map = s1.getBytes();
_L8:
        if (!"base16".equals(obj)) goto _L4; else goto _L3
_L3:
        map = Base16.encode(map);
_L6:
        return Types.objectToValue(map);
_L2:
        if ("base16".equals(s))
        {
            map = Base16.decode(s1);
            continue; /* Loop/switch isn't completed */
        }
        if ("base64".equals(s))
        {
            map = Base64Encoder.decode(s1, i);
            continue; /* Loop/switch isn't completed */
        }
        if ("base64url".equals(s))
        {
            map = Base64Encoder.decode(s1, i | 2);
            continue; /* Loop/switch isn't completed */
        } else
        {
            try
            {
                Log.e((new StringBuilder()).append("Encode: unknown input format: ").append(s).toString());
                map = Types.getDefaultValue();
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                Log.e("Encode: invalid input:");
                return Types.getDefaultValue();
            }
            return map;
        }
_L4:
        if ("base64".equals(obj))
        {
            map = Base64Encoder.encodeToString(map, i);
            continue; /* Loop/switch isn't completed */
        }
        if (!"base64url".equals(obj))
        {
            break; /* Loop/switch isn't completed */
        }
        map = Base64Encoder.encodeToString(map, i | 2);
        if (true) goto _L6; else goto _L5
_L5:
        Log.e((new StringBuilder()).append("Encode: unknown output format: ").append(((String) (obj))).toString());
        return Types.getDefaultValue();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.ENCODE.toString();
        ARG0 = Key.ARG0.toString();
        NO_PADDING = Key.NO_PADDING.toString();
        INPUT_FORMAT = Key.INPUT_FORMAT.toString();
        OUTPUT_FORMAT = Key.OUTPUT_FORMAT.toString();
    }
}
