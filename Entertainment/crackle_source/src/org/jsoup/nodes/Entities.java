// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entities
{
    public static final class EscapeMode extends Enum
    {

        private static final EscapeMode $VALUES[];
        public static final EscapeMode base;
        public static final EscapeMode extended;
        public static final EscapeMode xhtml;
        private Map map;

        public static EscapeMode valueOf(String s)
        {
            return (EscapeMode)Enum.valueOf(org/jsoup/nodes/Entities$EscapeMode, s);
        }

        public static EscapeMode[] values()
        {
            return (EscapeMode[])$VALUES.clone();
        }

        public Map getMap()
        {
            return map;
        }

        static 
        {
            xhtml = new EscapeMode("xhtml", 0, Entities.xhtmlByVal);
            base = new EscapeMode("base", 1, Entities.baseByVal);
            extended = new EscapeMode("extended", 2, Entities.fullByVal);
            $VALUES = (new EscapeMode[] {
                xhtml, base, extended
            });
        }

        private EscapeMode(String s, int i, Map map1)
        {
            super(s, i);
            map = map1;
        }
    }


    private static final Map baseByVal = toCharacterKey(loadEntities("entities-base.properties"));
    private static final Map full;
    private static final Map fullByVal;
    private static final Pattern strictUnescapePattern = Pattern.compile("&(#(x|X)?([0-9a-fA-F]+)|[a-zA-Z]+\\d*);");
    private static final Pattern unescapePattern = Pattern.compile("&(#(x|X)?([0-9a-fA-F]+)|[a-zA-Z]+\\d*);?");
    private static final Object xhtmlArray[][] = {
        {
            "quot", Integer.valueOf(34)
        }, {
            "amp", Integer.valueOf(38)
        }, {
            "apos", Integer.valueOf(39)
        }, {
            "lt", Integer.valueOf(60)
        }, {
            "gt", Integer.valueOf(62)
        }
    };
    private static final Map xhtmlByVal;

    private Entities()
    {
    }

    static String escape(String s, CharsetEncoder charsetencoder, EscapeMode escapemode)
    {
        StringBuilder stringbuilder = new StringBuilder(s.length() * 2);
        escapemode = escapemode.getMap();
        int i = 0;
        while (i < s.length()) 
        {
            Character character = Character.valueOf(s.charAt(i));
            if (escapemode.containsKey(character))
            {
                stringbuilder.append('&').append((String)escapemode.get(character)).append(';');
            } else
            if (charsetencoder.canEncode(character.charValue()))
            {
                stringbuilder.append(character.charValue());
            } else
            {
                stringbuilder.append("&#").append(character.charValue()).append(';');
            }
            i++;
        }
        return stringbuilder.toString();
    }

    static String escape(String s, Document.OutputSettings outputsettings)
    {
        return escape(s, outputsettings.encoder(), outputsettings.escapeMode());
    }

    public static Character getCharacterByName(String s)
    {
        return (Character)full.get(s);
    }

    public static boolean isNamedEntity(String s)
    {
        return full.containsKey(s);
    }

    private static Map loadEntities(String s)
    {
        Object obj1 = new Properties();
        Object obj = new HashMap();
        char c;
        try
        {
            InputStream inputstream = org/jsoup/nodes/Entities.getResourceAsStream(s);
            ((Properties) (obj1)).load(inputstream);
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new MissingResourceException((new StringBuilder()).append("Error loading entities resource: ").append(((IOException) (obj)).getMessage()).toString(), "Entities", s);
        }
        for (s = ((Properties) (obj1)).entrySet().iterator(); s.hasNext(); ((Map) (obj)).put((String)((java.util.Map.Entry) (obj1)).getKey(), Character.valueOf(c)))
        {
            obj1 = (java.util.Map.Entry)s.next();
            c = (char)Integer.parseInt((String)((java.util.Map.Entry) (obj1)).getValue(), 16);
        }

        return ((Map) (obj));
    }

    private static Map toCharacterKey(Map map)
    {
        HashMap hashmap = new HashMap();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            Character character = (Character)((java.util.Map.Entry) (obj)).getValue();
            obj = (String)((java.util.Map.Entry) (obj)).getKey();
            if (hashmap.containsKey(character))
            {
                if (((String) (obj)).toLowerCase().equals(obj))
                {
                    hashmap.put(character, obj);
                }
            } else
            {
                hashmap.put(character, obj);
            }
        } while (true);
        return hashmap;
    }

    static String unescape(String s)
    {
        return unescape(s, false);
    }

    static String unescape(String s, boolean flag)
    {
        Matcher matcher;
        byte byte0;
        if (!s.contains("&"))
        {
            return s;
        }
        String s1;
        if (flag)
        {
            matcher = strictUnescapePattern.matcher(s);
        } else
        {
            matcher = unescapePattern.matcher(s);
        }
        s = new StringBuffer(s.length());
_L3:
        if (!matcher.find())
        {
            break MISSING_BLOCK_LABEL_187;
        }
        byte0 = -1;
        s1 = matcher.group(3);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        int i;
        if (matcher.group(2) != null)
        {
            i = 16;
        } else
        {
            i = 10;
        }
        String s2;
        try
        {
            i = Integer.valueOf(s1, i).intValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            i = byte0;
        }
        if (i != -1 || i > 65535)
        {
            matcher.appendReplacement(s, Matcher.quoteReplacement(Character.toString((char)i)));
        } else
        {
            matcher.appendReplacement(s, Matcher.quoteReplacement(matcher.group(0)));
        }
        if (true) goto _L3; else goto _L2
_L2:
        s2 = matcher.group(1);
        i = byte0;
        if (full.containsKey(s2))
        {
            i = ((Character)full.get(s2)).charValue();
        }
        break MISSING_BLOCK_LABEL_78;
        matcher.appendTail(s);
        return s.toString();
    }

    static 
    {
        xhtmlByVal = new HashMap();
        full = loadEntities("entities-full.properties");
        fullByVal = toCharacterKey(full);
        Object aobj[][] = xhtmlArray;
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Object aobj1[] = aobj[i];
            char c = (char)((Integer)aobj1[1]).intValue();
            xhtmlByVal.put(Character.valueOf(c), (String)aobj1[0]);
        }

    }



}
