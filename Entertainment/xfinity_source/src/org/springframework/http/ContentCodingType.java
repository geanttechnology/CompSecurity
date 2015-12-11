// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.util.StringUtils;

public class ContentCodingType
    implements Comparable
{

    public static final ContentCodingType ALL = valueOf("*");
    public static final ContentCodingType GZIP = valueOf("gzip");
    public static final ContentCodingType IDENTITY = valueOf("identity");
    public static final Comparator QUALITY_VALUE_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((ContentCodingType)obj, (ContentCodingType)obj1);
        }

        public int compare(ContentCodingType contentcodingtype, ContentCodingType contentcodingtype1)
        {
            double d = contentcodingtype.getQualityValue();
            int j = Double.compare(contentcodingtype1.getQualityValue(), d);
            if (j != 0)
            {
                return j;
            }
            if (contentcodingtype.isWildcardType() && !contentcodingtype1.isWildcardType())
            {
                return 1;
            }
            if (contentcodingtype1.isWildcardType() && !contentcodingtype.isWildcardType())
            {
                return -1;
            }
            return contentcodingtype.getType().equals(contentcodingtype1.getType()) ? 0 : 0;
        }

    };
    private static final BitSet TOKEN;
    private final Map parameters;
    private final String type;

    public ContentCodingType(String s, Map map)
    {
        Assert.hasLength(s, "'type' must not be empty");
        checkToken(s);
        type = s.toLowerCase(Locale.ENGLISH);
        if (!CollectionUtils.isEmpty(map))
        {
            s = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
            String s1;
            Object obj;
            for (map = map.entrySet().iterator(); map.hasNext(); s.put(s1, unquote(((String) (obj)))))
            {
                obj = (java.util.Map.Entry)map.next();
                s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                checkParameters(s1, ((String) (obj)));
            }

            parameters = Collections.unmodifiableMap(s);
            return;
        } else
        {
            parameters = Collections.emptyMap();
            return;
        }
    }

    private void appendTo(StringBuilder stringbuilder)
    {
        stringbuilder.append(type);
        appendTo(parameters, stringbuilder);
    }

    private void appendTo(Map map, StringBuilder stringbuilder)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            stringbuilder.append(';');
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append('=');
        }

    }

    private void checkParameters(String s, String s1)
    {
        Assert.hasLength(s, "parameter attribute must not be empty");
        Assert.hasLength(s1, "parameter value must not be empty");
        checkToken(s);
        if ("q".equals(s))
        {
            s = unquote(s1);
            double d = Double.parseDouble(s);
            boolean flag;
            if (d >= 0.0D && d <= 1.0D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assert.isTrue(flag, (new StringBuilder()).append("Invalid quality value \"").append(s).append("\": should be between 0.0 and 1.0").toString());
        } else
        if (!isQuotedString(s1))
        {
            checkToken(s1);
            return;
        }
    }

    private void checkToken(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!TOKEN.get(c))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid token character '").append(c).append("' in token \"").append(s).append("\"").toString());
            }
        }

    }

    private boolean isQuotedString(String s)
    {
        return s.length() > 1 && s.startsWith("\"") && s.endsWith("\"");
    }

    public static ContentCodingType parseCodingType(String s)
    {
        Assert.hasLength(s, "'codingType' must not be empty");
        String as[] = StringUtils.tokenizeToStringArray(s, ";");
        String s1 = as[0].trim();
        s = null;
        if (as.length > 1)
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap(as.length - 1);
            int i = 1;
            do
            {
                s = linkedhashmap;
                if (i >= as.length)
                {
                    break;
                }
                s = as[i];
                int j = s.indexOf('=');
                if (j != -1)
                {
                    linkedhashmap.put(s.substring(0, j), s.substring(j + 1, s.length()));
                }
                i++;
            } while (true);
        }
        return new ContentCodingType(s1, s);
    }

    public static List parseCodingTypes(String s)
    {
        if (StringUtils.hasLength(s)) goto _L2; else goto _L1
_L1:
        s = Collections.emptyList();
_L4:
        return s;
_L2:
        String as[] = s.split(",");
        ArrayList arraylist = new ArrayList(as.length);
        int j = as.length;
        int i = 0;
        do
        {
            s = arraylist;
            if (i >= j)
            {
                continue;
            }
            arraylist.add(parseCodingType(as[i]));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String unquote(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = s;
            if (isQuotedString(s))
            {
                return s.substring(1, s.length() - 1);
            }
        }
        return s1;
    }

    public static ContentCodingType valueOf(String s)
    {
        return parseCodingType(s);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ContentCodingType)obj);
    }

    public int compareTo(ContentCodingType contentcodingtype)
    {
        int i = type.compareToIgnoreCase(contentcodingtype.type);
        if (i != 0)
        {
            return i;
        }
        i = parameters.size() - contentcodingtype.parameters.size();
        if (i != 0)
        {
            return i;
        }
        TreeSet treeset1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeset1.addAll(parameters.keySet());
        TreeSet treeset = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeset.addAll(contentcodingtype.parameters.keySet());
        Iterator iterator = treeset1.iterator();
        Iterator iterator1 = treeset.iterator();
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            String s = (String)iterator1.next();
            int j = s1.compareToIgnoreCase(s);
            if (j != 0)
            {
                return j;
            }
            String s2 = (String)parameters.get(s1);
            s1 = (String)contentcodingtype.parameters.get(s);
            s = s1;
            if (s1 == null)
            {
                s = "";
            }
            j = s2.compareTo(s);
            if (j != 0)
            {
                return j;
            }
        }
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ContentCodingType))
            {
                return false;
            }
            obj = (ContentCodingType)obj;
            if (!type.equalsIgnoreCase(((ContentCodingType) (obj)).type) || !parameters.equals(((ContentCodingType) (obj)).parameters))
            {
                return false;
            }
        }
        return true;
    }

    public String getParameter(String s)
    {
        return (String)parameters.get(s);
    }

    public double getQualityValue()
    {
        String s = getParameter("q");
        if (s != null)
        {
            return Double.parseDouble(s);
        } else
        {
            return 1.0D;
        }
    }

    public String getType()
    {
        return type;
    }

    public int hashCode()
    {
        return type.hashCode() * 31 + parameters.hashCode();
    }

    public boolean isWildcardType()
    {
        return "*".equals(type);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        appendTo(stringbuilder);
        return stringbuilder.toString();
    }

    static 
    {
        BitSet bitset = new BitSet(128);
        for (int i = 0; i <= 31; i++)
        {
            bitset.set(i);
        }

        bitset.set(127);
        BitSet bitset1 = new BitSet(128);
        bitset1.set(40);
        bitset1.set(41);
        bitset1.set(60);
        bitset1.set(62);
        bitset1.set(64);
        bitset1.set(44);
        bitset1.set(59);
        bitset1.set(58);
        bitset1.set(92);
        bitset1.set(34);
        bitset1.set(47);
        bitset1.set(91);
        bitset1.set(93);
        bitset1.set(63);
        bitset1.set(61);
        bitset1.set(123);
        bitset1.set(125);
        bitset1.set(32);
        bitset1.set(9);
        TOKEN = new BitSet(128);
        TOKEN.set(0, 128);
        TOKEN.andNot(bitset);
        TOKEN.andNot(bitset1);
    }
}
