// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.Collection;
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

public class MediaType
    implements Comparable
{

    public static final MediaType ALL = valueOf("*/*");
    public static final MediaType APPLICATION_ATOM_XML = valueOf("application/atom+xml");
    public static final MediaType APPLICATION_FORM_URLENCODED = valueOf("application/x-www-form-urlencoded");
    public static final MediaType APPLICATION_JSON = valueOf("application/json");
    public static final MediaType APPLICATION_OCTET_STREAM = valueOf("application/octet-stream");
    public static final MediaType APPLICATION_RSS_XML = valueOf("application/rss+xml");
    public static final MediaType APPLICATION_WILDCARD_XML = valueOf("application/*+xml");
    public static final MediaType APPLICATION_XHTML_XML = valueOf("application/xhtml+xml");
    public static final MediaType APPLICATION_XML = valueOf("application/xml");
    public static final MediaType IMAGE_GIF = valueOf("image/gif");
    public static final MediaType IMAGE_JPEG = valueOf("image/jpeg");
    public static final MediaType IMAGE_PNG = valueOf("image/png");
    public static final MediaType MULTIPART_FORM_DATA = valueOf("multipart/form-data");
    public static final Comparator QUALITY_VALUE_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((MediaType)obj, (MediaType)obj1);
        }

        public int compare(MediaType mediatype, MediaType mediatype1)
        {
            int j;
            byte byte0;
            byte0 = -1;
            double d = mediatype.getQualityValue();
            j = Double.compare(mediatype1.getQualityValue(), d);
            if (j == 0) goto _L2; else goto _L1
_L1:
            return j;
_L2:
            if (mediatype.isWildcardType() && !mediatype1.isWildcardType())
            {
                return 1;
            }
            if (!mediatype1.isWildcardType())
            {
                break; /* Loop/switch isn't completed */
            }
            j = byte0;
            if (!mediatype.isWildcardType()) goto _L1; else goto _L3
_L3:
            if (!mediatype.getType().equals(mediatype1.getType()))
            {
                return 0;
            }
            if (mediatype.isWildcardSubtype() && !mediatype1.isWildcardSubtype())
            {
                return 1;
            }
            if (!mediatype1.isWildcardSubtype())
            {
                break; /* Loop/switch isn't completed */
            }
            j = byte0;
            if (!mediatype.isWildcardSubtype()) goto _L1; else goto _L4
_L4:
            if (!mediatype.getSubtype().equals(mediatype1.getSubtype()))
            {
                return 0;
            }
            int k = mediatype.parameters.size();
            int l = mediatype1.parameters.size();
            j = byte0;
            if (l >= k)
            {
                return l != k ? 1 : 0;
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

    };
    public static final Comparator SPECIFICITY_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((MediaType)obj, (MediaType)obj1);
        }

        public int compare(MediaType mediatype, MediaType mediatype1)
        {
            byte byte0 = -1;
            if (!mediatype.isWildcardType() || mediatype1.isWildcardType()) goto _L2; else goto _L1
_L1:
            int j = 1;
_L4:
            return j;
_L2:
            if (!mediatype1.isWildcardType())
            {
                break; /* Loop/switch isn't completed */
            }
            j = byte0;
            if (!mediatype.isWildcardType()) goto _L4; else goto _L3
_L3:
            if (!mediatype.getType().equals(mediatype1.getType()))
            {
                return 0;
            }
            if (mediatype.isWildcardSubtype() && !mediatype1.isWildcardSubtype())
            {
                return 1;
            }
            if (!mediatype1.isWildcardSubtype())
            {
                break; /* Loop/switch isn't completed */
            }
            j = byte0;
            if (!mediatype.isWildcardSubtype()) goto _L4; else goto _L5
_L5:
            if (!mediatype.getSubtype().equals(mediatype1.getSubtype()))
            {
                return 0;
            }
            double d = mediatype.getQualityValue();
            j = Double.compare(mediatype1.getQualityValue(), d);
            if (j != 0)
            {
                return j;
            }
            int k = mediatype.parameters.size();
            int l = mediatype1.parameters.size();
            j = byte0;
            if (l >= k)
            {
                return l != k ? 1 : 0;
            }
            if (true) goto _L4; else goto _L6
_L6:
        }

    };
    public static final MediaType TEXT_HTML = valueOf("text/html");
    public static final MediaType TEXT_PLAIN = valueOf("text/plain");
    public static final MediaType TEXT_XML = valueOf("text/xml");
    private static final BitSet TOKEN;
    private final Map parameters;
    private final String subtype;
    private final String type;

    public MediaType(String s, String s1)
    {
        this(s, s1, Collections.emptyMap());
    }

    public MediaType(String s, String s1, Charset charset)
    {
        this(s, s1, Collections.singletonMap("charset", charset.displayName()));
    }

    public MediaType(String s, String s1, Map map)
    {
        Assert.hasLength(s, "'type' must not be empty");
        Assert.hasLength(s1, "'subtype' must not be empty");
        checkToken(s);
        checkToken(s1);
        type = s.toLowerCase(Locale.ENGLISH);
        subtype = s1.toLowerCase(Locale.ENGLISH);
        if (!CollectionUtils.isEmpty(map))
        {
            s = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
            Object obj;
            for (s1 = map.entrySet().iterator(); s1.hasNext(); s.put(map, obj))
            {
                obj = (java.util.Map.Entry)s1.next();
                map = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                checkParameters(map, ((String) (obj)));
            }

            parameters = Collections.unmodifiableMap(s);
            return;
        } else
        {
            parameters = Collections.emptyMap();
            return;
        }
    }

    public MediaType(MediaType mediatype, Map map)
    {
        this(mediatype.getType(), mediatype.getSubtype(), map);
    }

    private void appendTo(StringBuilder stringbuilder)
    {
        stringbuilder.append(type);
        stringbuilder.append('/');
        stringbuilder.append(subtype);
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
        {
            if ("charset".equals(s))
            {
                Charset.forName(unquote(s1));
                return;
            }
            if (!isQuotedString(s1))
            {
                checkToken(s1);
                return;
            }
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

    public static MediaType parseMediaType(String s)
    {
        Assert.hasLength(s, "'mediaType' must not be empty");
        String as[] = StringUtils.tokenizeToStringArray(s, ";");
        String s2 = as[0].trim();
        String s1 = s2;
        if ("*".equals(s2))
        {
            s1 = "*/*";
        }
        int i = s1.indexOf('/');
        if (i == -1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("\"").append(s).append("\" does not contain '/'").toString());
        }
        if (i == s1.length() - 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("\"").append(s).append("\" does not contain subtype after '/'").toString());
        }
        s2 = s1.substring(0, i);
        String s3 = s1.substring(i + 1, s1.length());
        if ("*".equals(s2) && !"*".equals(s3))
        {
            throw new IllegalArgumentException("A wildcard type is legal only in '*/*' (all media types).");
        }
        s = null;
        if (as.length > 1)
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap(as.length - 1);
            int j = 1;
            do
            {
                s = linkedhashmap;
                if (j >= as.length)
                {
                    break;
                }
                s = as[j];
                int k = s.indexOf('=');
                if (k != -1)
                {
                    linkedhashmap.put(s.substring(0, k), s.substring(k + 1, s.length()));
                }
                j++;
            } while (true);
        }
        return new MediaType(s2, s3, s);
    }

    public static void sortBySpecificity(List list)
    {
        Assert.notNull(list, "'mediaTypes' must not be null");
        if (list.size() > 1)
        {
            Collections.sort(list, SPECIFICITY_COMPARATOR);
        }
    }

    public static String toString(Collection collection)
    {
        StringBuilder stringbuilder = new StringBuilder();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            ((MediaType)collection.next()).appendTo(stringbuilder);
            if (collection.hasNext())
            {
                stringbuilder.append(", ");
            }
        } while (true);
        return stringbuilder.toString();
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

    public static MediaType valueOf(String s)
    {
        return parseMediaType(s);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MediaType)obj);
    }

    public int compareTo(MediaType mediatype)
    {
        int i = type.compareToIgnoreCase(mediatype.type);
        if (i != 0)
        {
            return i;
        }
        i = subtype.compareToIgnoreCase(mediatype.subtype);
        if (i != 0)
        {
            return i;
        }
        i = parameters.size() - mediatype.parameters.size();
        if (i != 0)
        {
            return i;
        }
        TreeSet treeset1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeset1.addAll(parameters.keySet());
        TreeSet treeset = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeset.addAll(mediatype.parameters.keySet());
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
            s1 = (String)mediatype.parameters.get(s);
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
            if (!(obj instanceof MediaType))
            {
                return false;
            }
            obj = (MediaType)obj;
            if (!type.equalsIgnoreCase(((MediaType) (obj)).type) || !subtype.equalsIgnoreCase(((MediaType) (obj)).subtype) || !parameters.equals(((MediaType) (obj)).parameters))
            {
                return false;
            }
        }
        return true;
    }

    public Charset getCharSet()
    {
        String s = getParameter("charset");
        if (s != null)
        {
            return Charset.forName(unquote(s));
        } else
        {
            return null;
        }
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
            return Double.parseDouble(unquote(s));
        } else
        {
            return 1.0D;
        }
    }

    public String getSubtype()
    {
        return subtype;
    }

    public String getType()
    {
        return type;
    }

    public int hashCode()
    {
        return (type.hashCode() * 31 + subtype.hashCode()) * 31 + parameters.hashCode();
    }

    public boolean includes(MediaType mediatype)
    {
        if (mediatype != null)
        {
            if (isWildcardType())
            {
                return true;
            }
            if (type.equals(mediatype.type))
            {
                if (subtype.equals(mediatype.subtype) || isWildcardSubtype())
                {
                    return true;
                }
                int i = subtype.indexOf('+');
                int j = mediatype.subtype.indexOf('+');
                if (i != -1 && j != -1)
                {
                    String s = subtype.substring(0, i);
                    if (subtype.substring(i + 1).equals(mediatype.subtype.substring(j + 1)) && "*".equals(s))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCompatibleWith(MediaType mediatype)
    {
        if (mediatype != null)
        {
            if (isWildcardType() || mediatype.isWildcardType())
            {
                return true;
            }
            if (type.equals(mediatype.type))
            {
                if (subtype.equals(mediatype.subtype) || isWildcardSubtype() || mediatype.isWildcardSubtype())
                {
                    return true;
                }
                int i = subtype.indexOf('+');
                int j = mediatype.subtype.indexOf('+');
                if (i != -1 && j != -1)
                {
                    String s = subtype.substring(0, i);
                    String s1 = mediatype.subtype.substring(0, j);
                    if (subtype.substring(i + 1).equals(mediatype.subtype.substring(j + 1)) && ("*".equals(s) || "*".equals(s1)))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isWildcardSubtype()
    {
        return "*".equals(subtype);
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
