// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            TypedNumber, Log

class Types
{

    private static Boolean DEFAULT_BOOLEAN = new Boolean(false);
    private static Double DEFAULT_DOUBLE = new Double(0.0D);
    private static Long DEFAULT_INT64 = new Long(0L);
    private static List DEFAULT_LIST = new ArrayList(0);
    private static Map DEFAULT_MAP = new HashMap();
    private static TypedNumber DEFAULT_NUMBER = TypedNumber.numberWithInt64(0L);
    private static final Object DEFAULT_OBJECT = null;
    private static String DEFAULT_STRING;
    private static com.google.analytics.midtier.proto.containertag.TypeSystem.Value DEFAULT_VALUE;

    private Types()
    {
    }

    public static com.google.analytics.midtier.proto.containertag.TypeSystem.Value functionIdToValue(String s)
    {
        return com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder().setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.FUNCTION_ID).setFunctionId(s).build();
    }

    public static Boolean getDefaultBoolean()
    {
        return DEFAULT_BOOLEAN;
    }

    public static Double getDefaultDouble()
    {
        return DEFAULT_DOUBLE;
    }

    public static Long getDefaultInt64()
    {
        return DEFAULT_INT64;
    }

    public static List getDefaultList()
    {
        return DEFAULT_LIST;
    }

    public static Map getDefaultMap()
    {
        return DEFAULT_MAP;
    }

    public static TypedNumber getDefaultNumber()
    {
        return DEFAULT_NUMBER;
    }

    public static Object getDefaultObject()
    {
        return DEFAULT_OBJECT;
    }

    public static String getDefaultString()
    {
        return DEFAULT_STRING;
    }

    public static com.google.analytics.midtier.proto.containertag.TypeSystem.Value getDefaultValue()
    {
        return DEFAULT_VALUE;
    }

    private static double getDouble(Object obj)
    {
        if (obj instanceof Number)
        {
            return ((Number)obj).doubleValue();
        } else
        {
            Log.e("getDouble received non-Number");
            return 0.0D;
        }
    }

    private static long getInt64(Object obj)
    {
        if (obj instanceof Number)
        {
            return ((Number)obj).longValue();
        } else
        {
            Log.e("getInt64 received non-Number");
            return 0L;
        }
    }

    private static boolean isDoubleableNumber(Object obj)
    {
        return (obj instanceof Double) || (obj instanceof Float) || (obj instanceof TypedNumber) && ((TypedNumber)obj).isDouble();
    }

    private static boolean isInt64ableNumber(Object obj)
    {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof TypedNumber) && ((TypedNumber)obj).isInt64();
    }

    public static transient com.google.analytics.midtier.proto.containertag.TypeSystem.Value macroReferenceToValue(String s, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping aescaping[])
    {
        s = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder().setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MACRO_REFERENCE).setMacroReference(s).setContainsReferences(true);
        int j = aescaping.length;
        for (int i = 0; i < j; i++)
        {
            s.addEscaping(aescaping[i]);
        }

        return s.build();
    }

    public static Boolean objectToBoolean(Object obj)
    {
        if (obj instanceof Boolean)
        {
            return (Boolean)obj;
        } else
        {
            return parseBoolean(objectToString(obj));
        }
    }

    public static Double objectToDouble(Object obj)
    {
        if (isDoubleableNumber(obj))
        {
            return Double.valueOf(getDouble(obj));
        } else
        {
            return parseDouble(objectToString(obj));
        }
    }

    public static Long objectToInt64(Object obj)
    {
        if (isInt64ableNumber(obj))
        {
            return Long.valueOf(getInt64(obj));
        } else
        {
            return parseInt64(objectToString(obj));
        }
    }

    public static TypedNumber objectToNumber(Object obj)
    {
        if (obj instanceof TypedNumber)
        {
            return (TypedNumber)obj;
        }
        if (isInt64ableNumber(obj))
        {
            return TypedNumber.numberWithInt64(getInt64(obj));
        }
        if (isDoubleableNumber(obj))
        {
            return TypedNumber.numberWithDouble(Double.valueOf(getDouble(obj)));
        } else
        {
            return parseNumber(objectToString(obj));
        }
    }

    public static String objectToString(Object obj)
    {
        if (obj == null)
        {
            return DEFAULT_STRING;
        } else
        {
            return obj.toString();
        }
    }

    public static com.google.analytics.midtier.proto.containertag.TypeSystem.Value objectToValue(Object obj)
    {
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder;
        boolean flag;
        boolean flag1;
        boolean flag3;
        builder = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder();
        flag1 = false;
        flag3 = false;
        flag = false;
        if (obj instanceof com.google.analytics.midtier.proto.containertag.TypeSystem.Value)
        {
            return (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)obj;
        }
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        builder.setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.STRING).setString((String)obj);
_L4:
        if (flag)
        {
            builder.setContainsReferences(true);
        }
        return builder.build();
_L2:
        if (obj instanceof List)
        {
            builder.setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.LIST);
            obj = ((List)obj).iterator();
            do
            {
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                com.google.analytics.midtier.proto.containertag.TypeSystem.Value value = objectToValue(((Iterator) (obj)).next());
                if (value == DEFAULT_VALUE)
                {
                    return DEFAULT_VALUE;
                }
                if (flag1 || value.getContainsReferences())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                builder.addListItem(value);
            } while (true);
        }
        if (obj instanceof Map)
        {
            builder.setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP);
            obj = ((Map)obj).entrySet().iterator();
            boolean flag2 = flag3;
            do
            {
                flag = flag2;
                if (!((Iterator) (obj)).hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                com.google.analytics.midtier.proto.containertag.TypeSystem.Value value1 = objectToValue(((java.util.Map.Entry) (obj1)).getKey());
                obj1 = objectToValue(((java.util.Map.Entry) (obj1)).getValue());
                if (value1 == DEFAULT_VALUE || obj1 == DEFAULT_VALUE)
                {
                    return DEFAULT_VALUE;
                }
                if (flag2 || value1.getContainsReferences() || ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj1)).getContainsReferences())
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                builder.addMapKey(value1);
                builder.addMapValue(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj1)));
            } while (true);
        }
        if (isDoubleableNumber(obj))
        {
            builder.setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.STRING).setString(obj.toString());
            continue; /* Loop/switch isn't completed */
        }
        if (isInt64ableNumber(obj))
        {
            builder.setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.INTEGER).setInteger(getInt64(obj));
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof Boolean))
        {
            break; /* Loop/switch isn't completed */
        }
        builder.setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.BOOLEAN).setBoolean(((Boolean)obj).booleanValue());
        if (true) goto _L4; else goto _L3
_L3:
        StringBuilder stringbuilder = (new StringBuilder()).append("Converting to Value from unknown object type: ");
        if (obj == null)
        {
            obj = "null";
        } else
        {
            obj = obj.getClass().toString();
        }
        Log.e(stringbuilder.append(((String) (obj))).toString());
        return DEFAULT_VALUE;
    }

    private static Boolean parseBoolean(String s)
    {
        if ("true".equalsIgnoreCase(s))
        {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(s))
        {
            return Boolean.FALSE;
        } else
        {
            return DEFAULT_BOOLEAN;
        }
    }

    private static Double parseDouble(String s)
    {
        s = parseNumber(s);
        if (s == DEFAULT_NUMBER)
        {
            return DEFAULT_DOUBLE;
        } else
        {
            return Double.valueOf(s.doubleValue());
        }
    }

    private static Long parseInt64(String s)
    {
        s = parseNumber(s);
        if (s == DEFAULT_NUMBER)
        {
            return DEFAULT_INT64;
        } else
        {
            return Long.valueOf(s.longValue());
        }
    }

    private static TypedNumber parseNumber(String s)
    {
        TypedNumber typednumber;
        try
        {
            typednumber = TypedNumber.numberWithString(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.e((new StringBuilder()).append("Failed to convert '").append(s).append("' to a number.").toString());
            return DEFAULT_NUMBER;
        }
        return typednumber;
    }

    public static transient com.google.analytics.midtier.proto.containertag.TypeSystem.Value templateToValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value avalue[])
    {
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder().setType(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.TEMPLATE);
        boolean flag = false;
        int j = avalue.length;
        int i = 0;
        while (i < j) 
        {
            com.google.analytics.midtier.proto.containertag.TypeSystem.Value value = avalue[i];
            builder.addTemplateToken(value);
            if (flag || value.getContainsReferences())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i++;
        }
        if (flag)
        {
            builder.setContainsReferences(true);
        }
        return builder.build();
    }

    public static Boolean valueToBoolean(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        return objectToBoolean(valueToObject(value));
    }

    public static Double valueToDouble(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        return objectToDouble(valueToObject(value));
    }

    public static Long valueToInt64(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        return objectToInt64(valueToObject(value));
    }

    public static TypedNumber valueToNumber(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        return objectToNumber(valueToObject(value));
    }

    public static Object valueToObject(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        if (value != null) goto _L2; else goto _L1
_L1:
        value = ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (DEFAULT_OBJECT));
_L13:
        return value;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[];

            static 
            {
                $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.values().length];
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.LIST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MACRO_REFERENCE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.FUNCTION_ID.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.INTEGER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.TEMPLATE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.BOOLEAN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type[value.getType().ordinal()];
        JVM INSTR tableswitch 1 8: default 68
    //                   1 98
    //                   2 103
    //                   3 169
    //                   4 292
    //                   5 302
    //                   6 312
    //                   7 320
    //                   8 385;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        Log.e((new StringBuilder()).append("Failed to convert a value of type: ").append(value.getType()).toString());
        return DEFAULT_OBJECT;
_L4:
        return value.getString();
_L5:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList(value.getListItemCount());
        iterator = value.getListItemList().iterator();
_L14:
        value = arraylist;
        if (!iterator.hasNext()) goto _L13; else goto _L12
_L12:
        value = ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (valueToObject((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)iterator.next())));
        if (value == DEFAULT_OBJECT)
        {
            return DEFAULT_OBJECT;
        }
        arraylist.add(value);
          goto _L14
          goto _L13
_L6:
        if (value.getMapKeyCount() != value.getMapValueCount())
        {
            Log.e((new StringBuilder()).append("Converting an invalid value to object: ").append(value.toString()).toString());
            return DEFAULT_OBJECT;
        }
        HashMap hashmap = new HashMap(value.getMapValueCount());
        for (int i = 0; i < value.getMapKeyCount(); i++)
        {
            Object obj = valueToObject(value.getMapKey(i));
            Object obj1 = valueToObject(value.getMapValue(i));
            if (obj == DEFAULT_OBJECT || obj1 == DEFAULT_OBJECT)
            {
                return DEFAULT_OBJECT;
            }
            hashmap.put(obj, obj1);
        }

        return hashmap;
_L7:
        Log.e("Trying to convert a macro reference to object");
        return DEFAULT_OBJECT;
_L8:
        Log.e("Trying to convert a function id to object");
        return DEFAULT_OBJECT;
_L9:
        return Long.valueOf(value.getInteger());
_L10:
        StringBuffer stringbuffer = new StringBuffer();
        String s;
        for (value = value.getTemplateTokenList().iterator(); value.hasNext(); stringbuffer.append(s))
        {
            s = valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)value.next());
            if (s == DEFAULT_STRING)
            {
                return DEFAULT_OBJECT;
            }
        }

        return stringbuffer.toString();
_L11:
        return Boolean.valueOf(value.getBoolean());
    }

    public static String valueToString(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        return objectToString(valueToObject(value));
    }

    static 
    {
        DEFAULT_STRING = new String("");
        DEFAULT_VALUE = objectToValue(DEFAULT_STRING);
    }
}
