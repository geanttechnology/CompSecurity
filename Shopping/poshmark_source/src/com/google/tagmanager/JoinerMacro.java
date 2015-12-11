// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, ValueEscapeUtil, Log, Types

class JoinerMacro extends FunctionCallImplementation
{
    private static final class EscapeType extends Enum
    {

        private static final EscapeType $VALUES[];
        public static final EscapeType BACKSLASH;
        public static final EscapeType NONE;
        public static final EscapeType URL;

        public static EscapeType valueOf(String s)
        {
            return (EscapeType)Enum.valueOf(com/google/tagmanager/JoinerMacro$EscapeType, s);
        }

        public static EscapeType[] values()
        {
            return (EscapeType[])$VALUES.clone();
        }

        static 
        {
            NONE = new EscapeType("NONE", 0);
            URL = new EscapeType("URL", 1);
            BACKSLASH = new EscapeType("BACKSLASH", 2);
            $VALUES = (new EscapeType[] {
                NONE, URL, BACKSLASH
            });
        }

        private EscapeType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String ARG0;
    private static final String DEFAULT_ITEM_SEPARATOR = "";
    private static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";
    private static final String ESCAPE;
    private static final String ID;
    private static final String ITEM_SEPARATOR;
    private static final String KEY_VALUE_SEPARATOR;

    public JoinerMacro()
    {
        super(ID, new String[] {
            ARG0
        });
    }

    private void addTo(Set set, String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            set.add(Character.valueOf(s.charAt(i)));
        }

    }

    private void append(StringBuilder stringbuilder, String s, EscapeType escapetype, Set set)
    {
        stringbuilder.append(escape(s, escapetype, set));
    }

    private String escape(String s, EscapeType escapetype, Set set)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[];
            static final int $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[];

            static 
            {
                $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType = new int[EscapeType.values().length];
                try
                {
                    $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[EscapeType.URL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[EscapeType.BACKSLASH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[EscapeType.NONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.values().length];
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.google.tagmanager.JoinerMacro.EscapeType[escapetype.ordinal()])
        {
        default:
            return s;

        case 1: // '\001'
            try
            {
                escapetype = ValueEscapeUtil.urlEncode(s);
            }
            // Misplaced declaration of an exception variable
            catch (EscapeType escapetype)
            {
                Log.e("Joiner: unsupported encoding", escapetype);
                return s;
            }
            return escapetype;

        case 2: // '\002'
            s = s.replace("\\", "\\\\");
            escapetype = set.iterator();
            break;
        }
        while (escapetype.hasNext()) 
        {
            set = ((Character)escapetype.next()).toString();
            s = s.replace(set, (new StringBuilder()).append("\\").append(set).toString());
        }
        return s;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        Object obj;
        Object obj1;
        Object obj2;
        StringBuilder stringbuilder;
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value1;
        value1 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ARG0);
        if (value1 == null)
        {
            return Types.getDefaultValue();
        }
        obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ITEM_SEPARATOR);
        EscapeType escapetype;
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value2;
        if (obj != null)
        {
            obj = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        } else
        {
            obj = "";
        }
        obj1 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(KEY_VALUE_SEPARATOR);
        if (obj1 != null)
        {
            obj1 = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj1)));
        } else
        {
            obj1 = "=";
        }
        escapetype = EscapeType.NONE;
        value2 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ESCAPE);
        stringbuilder = null;
        obj2 = stringbuilder;
        map = escapetype;
        if (value2 != null)
        {
            map = Types.valueToString(value2);
            if ("url".equals(map))
            {
                map = EscapeType.URL;
                obj2 = stringbuilder;
            } else
            if ("backslash".equals(map))
            {
                map = EscapeType.BACKSLASH;
                obj2 = new HashSet();
                addTo(((Set) (obj2)), ((String) (obj)));
                addTo(((Set) (obj2)), ((String) (obj1)));
                ((Set) (obj2)).remove(Character.valueOf('\\'));
            } else
            {
                Log.e((new StringBuilder()).append("Joiner: unsupported escape type: ").append(map).toString());
                return Types.getDefaultValue();
            }
        }
        stringbuilder = new StringBuilder();
        _cls1..SwitchMap.com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type[value1.getType().ordinal()];
        JVM INSTR tableswitch 1 2: default 168
    //                   1 281
    //                   2 347;
           goto _L1 _L2 _L3
_L1:
        append(stringbuilder, Types.valueToString(value1), map, ((Set) (obj2)));
_L5:
        return Types.objectToValue(stringbuilder.toString());
_L2:
        boolean flag = true;
        obj1 = value1.getListItemList().iterator();
        while (((Iterator) (obj1)).hasNext()) 
        {
            com.google.analytics.midtier.proto.containertag.TypeSystem.Value value = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)((Iterator) (obj1)).next();
            if (!flag)
            {
                stringbuilder.append(((String) (obj)));
            }
            flag = false;
            append(stringbuilder, Types.valueToString(value), map, ((Set) (obj2)));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        int i = 0;
        while (i < value1.getMapKeyCount()) 
        {
            if (i > 0)
            {
                stringbuilder.append(((String) (obj)));
            }
            String s = Types.valueToString(value1.getMapKey(i));
            String s1 = Types.valueToString(value1.getMapValue(i));
            append(stringbuilder, s, map, ((Set) (obj2)));
            stringbuilder.append(((String) (obj1)));
            append(stringbuilder, s1, map, ((Set) (obj2)));
            i++;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.JOINER.toString();
        ARG0 = Key.ARG0.toString();
        ITEM_SEPARATOR = Key.ITEM_SEPARATOR.toString();
        KEY_VALUE_SEPARATOR = Key.KEY_VALUE_SEPARATOR.toString();
        ESCAPE = Key.ESCAPE.toString();
    }
}
