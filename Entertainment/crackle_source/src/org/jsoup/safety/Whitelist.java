// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.safety;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class Whitelist
{
    static class AttributeKey extends TypedValue
    {

        static AttributeKey valueOf(String s)
        {
            return new AttributeKey(s);
        }

        AttributeKey(String s)
        {
            super(s);
        }
    }

    static class AttributeValue extends TypedValue
    {

        static AttributeValue valueOf(String s)
        {
            return new AttributeValue(s);
        }

        AttributeValue(String s)
        {
            super(s);
        }
    }

    static class Protocol extends TypedValue
    {

        static Protocol valueOf(String s)
        {
            return new Protocol(s);
        }

        Protocol(String s)
        {
            super(s);
        }
    }

    static class TagName extends TypedValue
    {

        static TagName valueOf(String s)
        {
            return new TagName(s);
        }

        TagName(String s)
        {
            super(s);
        }
    }

    static abstract class TypedValue
    {

        private String value;

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (TypedValue)obj;
            if (value != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((TypedValue) (obj)).value == null) goto _L1; else goto _L3
_L3:
            return false;
            if (value.equals(((TypedValue) (obj)).value)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int i;
            if (value == null)
            {
                i = 0;
            } else
            {
                i = value.hashCode();
            }
            return i + 31;
        }

        public String toString()
        {
            return value;
        }

        TypedValue(String s)
        {
            Validate.notNull(s);
            value = s;
        }
    }


    private Map attributes;
    private Map enforcedAttributes;
    private boolean preserveRelativeLinks;
    private Map protocols;
    private Set tagNames;

    public Whitelist()
    {
        tagNames = new HashSet();
        attributes = new HashMap();
        enforcedAttributes = new HashMap();
        protocols = new HashMap();
        preserveRelativeLinks = false;
    }

    public static Whitelist basic()
    {
        return (new Whitelist()).addTags(new String[] {
            "a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em", 
            "i", "li", "ol", "p", "pre", "q", "small", "strike", "strong", "sub", 
            "sup", "u", "ul"
        }).addAttributes("a", new String[] {
            "href"
        }).addAttributes("blockquote", new String[] {
            "cite"
        }).addAttributes("q", new String[] {
            "cite"
        }).addProtocols("a", "href", new String[] {
            "ftp", "http", "https", "mailto"
        }).addProtocols("blockquote", "cite", new String[] {
            "http", "https"
        }).addProtocols("cite", "cite", new String[] {
            "http", "https"
        }).addEnforcedAttribute("a", "rel", "nofollow");
    }

    public static Whitelist basicWithImages()
    {
        return basic().addTags(new String[] {
            "img"
        }).addAttributes("img", new String[] {
            "align", "alt", "height", "src", "title", "width"
        }).addProtocols("img", "src", new String[] {
            "http", "https"
        });
    }

    public static Whitelist none()
    {
        return new Whitelist();
    }

    public static Whitelist relaxed()
    {
        return (new Whitelist()).addTags(new String[] {
            "a", "b", "blockquote", "br", "caption", "cite", "code", "col", "colgroup", "dd", 
            "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6", 
            "i", "img", "li", "ol", "p", "pre", "q", "small", "strike", "strong", 
            "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", 
            "ul"
        }).addAttributes("a", new String[] {
            "href", "title"
        }).addAttributes("blockquote", new String[] {
            "cite"
        }).addAttributes("col", new String[] {
            "span", "width"
        }).addAttributes("colgroup", new String[] {
            "span", "width"
        }).addAttributes("img", new String[] {
            "align", "alt", "height", "src", "title", "width"
        }).addAttributes("ol", new String[] {
            "start", "type"
        }).addAttributes("q", new String[] {
            "cite"
        }).addAttributes("table", new String[] {
            "summary", "width"
        }).addAttributes("td", new String[] {
            "abbr", "axis", "colspan", "rowspan", "width"
        }).addAttributes("th", new String[] {
            "abbr", "axis", "colspan", "rowspan", "scope", "width"
        }).addAttributes("ul", new String[] {
            "type"
        }).addProtocols("a", "href", new String[] {
            "ftp", "http", "https", "mailto"
        }).addProtocols("blockquote", "cite", new String[] {
            "http", "https"
        }).addProtocols("img", "src", new String[] {
            "http", "https"
        }).addProtocols("q", "cite", new String[] {
            "http", "https"
        });
    }

    public static Whitelist simpleText()
    {
        return (new Whitelist()).addTags(new String[] {
            "b", "em", "i", "strong", "u"
        });
    }

    private boolean testValidProtocol(Element element, Attribute attribute, Set set)
    {
        String s = element.absUrl(attribute.getKey());
        element = s;
        if (s.length() == 0)
        {
            element = attribute.getValue();
        }
        if (!preserveRelativeLinks)
        {
            attribute.setValue(element);
        }
        for (attribute = set.iterator(); attribute.hasNext();)
        {
            set = (Protocol)attribute.next();
            set = (new StringBuilder()).append(set.toString()).append(":").toString();
            if (element.toLowerCase().startsWith(set))
            {
                return true;
            }
        }

        return false;
    }

    public transient Whitelist addAttributes(String s, String as[])
    {
        Validate.notEmpty(s);
        Validate.notNull(as);
        HashSet hashset;
        int j;
        boolean flag;
        if (as.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag, "No attributes supplied.");
        s = TagName.valueOf(s);
        if (!tagNames.contains(s))
        {
            tagNames.add(s);
        }
        hashset = new HashSet();
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = as[i];
            Validate.notEmpty(s1);
            hashset.add(AttributeKey.valueOf(s1));
        }

        if (attributes.containsKey(s))
        {
            ((Set)attributes.get(s)).addAll(hashset);
            return this;
        } else
        {
            attributes.put(s, hashset);
            return this;
        }
    }

    public Whitelist addEnforcedAttribute(String s, String s1, String s2)
    {
        Validate.notEmpty(s);
        Validate.notEmpty(s1);
        Validate.notEmpty(s2);
        s = TagName.valueOf(s);
        if (!tagNames.contains(s))
        {
            tagNames.add(s);
        }
        s1 = AttributeKey.valueOf(s1);
        s2 = AttributeValue.valueOf(s2);
        if (enforcedAttributes.containsKey(s))
        {
            ((Map)enforcedAttributes.get(s)).put(s1, s2);
            return this;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put(s1, s2);
            enforcedAttributes.put(s, hashmap);
            return this;
        }
    }

    public transient Whitelist addProtocols(String s, String s1, String as[])
    {
        Validate.notEmpty(s);
        Validate.notEmpty(s1);
        Validate.notNull(as);
        TagName tagname = TagName.valueOf(s);
        AttributeKey attributekey = AttributeKey.valueOf(s1);
        int j;
        if (protocols.containsKey(tagname))
        {
            s = (Map)protocols.get(tagname);
        } else
        {
            s = new HashMap();
            protocols.put(tagname, s);
        }
        if (s.containsKey(attributekey))
        {
            s = (Set)s.get(attributekey);
        } else
        {
            s1 = new HashSet();
            s.put(attributekey, s1);
            s = s1;
        }
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            s1 = as[i];
            Validate.notEmpty(s1);
            s.add(Protocol.valueOf(s1));
        }

        return this;
    }

    public transient Whitelist addTags(String as[])
    {
        Validate.notNull(as);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            Validate.notEmpty(s);
            tagNames.add(TagName.valueOf(s));
        }

        return this;
    }

    Attributes getEnforcedAttributes(String s)
    {
        Attributes attributes1 = new Attributes();
        s = TagName.valueOf(s);
        if (enforcedAttributes.containsKey(s))
        {
            java.util.Map.Entry entry;
            for (s = ((Map)enforcedAttributes.get(s)).entrySet().iterator(); s.hasNext(); attributes1.put(((AttributeKey)entry.getKey()).toString(), ((AttributeValue)entry.getValue()).toString()))
            {
                entry = (java.util.Map.Entry)s.next();
            }

        }
        return attributes1;
    }

    boolean isSafeAttribute(String s, Element element, Attribute attribute)
    {
        boolean flag = true;
        TagName tagname = TagName.valueOf(s);
        AttributeKey attributekey = AttributeKey.valueOf(attribute.getKey());
        if (attributes.containsKey(tagname) && ((Set)attributes.get(tagname)).contains(attributekey))
        {
            if (protocols.containsKey(tagname))
            {
                s = (Map)protocols.get(tagname);
                if (!s.containsKey(attributekey) || testValidProtocol(element, attribute, (Set)s.get(attributekey)))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        } else
        if (s.equals(":all") || !isSafeAttribute(":all", element, attribute))
        {
            return false;
        }
        return flag;
    }

    boolean isSafeTag(String s)
    {
        return tagNames.contains(TagName.valueOf(s));
    }

    public Whitelist preserveRelativeLinks(boolean flag)
    {
        preserveRelativeLinks = flag;
        return this;
    }
}
