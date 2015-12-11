// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.springframework.util.Assert;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.util.MultiValueMap;

// Referenced classes of package org.springframework.http:
//            ContentCodingType, MediaType

public class HttpHeaders
    implements MultiValueMap
{

    private static final String DATE_FORMATS[] = {
        "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM dd HH:mm:ss yyyy"
    };
    private static TimeZone GMT = TimeZone.getTimeZone("GMT");
    private final Map headers;

    public HttpHeaders()
    {
        this(((Map) (new LinkedCaseInsensitiveMap(8, Locale.ENGLISH))), false);
    }

    private HttpHeaders(Map map, boolean flag)
    {
        Assert.notNull(map, "'headers' must not be null");
        if (flag)
        {
            LinkedCaseInsensitiveMap linkedcaseinsensitivemap = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
            java.util.Map.Entry entry;
            List list;
            for (map = map.entrySet().iterator(); map.hasNext(); linkedcaseinsensitivemap.put(entry.getKey(), list))
            {
                entry = (java.util.Map.Entry)map.next();
                list = Collections.unmodifiableList((List)entry.getValue());
            }

            headers = Collections.unmodifiableMap(linkedcaseinsensitivemap);
            return;
        } else
        {
            headers = map;
            return;
        }
    }

    public static HttpHeaders readOnlyHttpHeaders(HttpHeaders httpheaders)
    {
        return new HttpHeaders(httpheaders, true);
    }

    public volatile void add(Object obj, Object obj1)
    {
        add((String)obj, (String)obj1);
    }

    public void add(String s, String s1)
    {
        List list = (List)headers.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new LinkedList();
            headers.put(s, obj);
        }
        ((List) (obj)).add(s1);
    }

    public void clear()
    {
        headers.clear();
    }

    public boolean containsKey(Object obj)
    {
        return headers.containsKey(obj);
    }

    public boolean containsValue(Object obj)
    {
        return headers.containsValue(obj);
    }

    public Set entrySet()
    {
        return headers.entrySet();
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof HttpHeaders))
        {
            return false;
        } else
        {
            obj = (HttpHeaders)obj;
            return headers.equals(((HttpHeaders) (obj)).headers);
        }
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public List get(Object obj)
    {
        return (List)headers.get(obj);
    }

    public List getContentEncoding()
    {
        String s = getFirst("Content-Encoding");
        if (s != null)
        {
            return ContentCodingType.parseCodingTypes(s);
        } else
        {
            return Collections.emptyList();
        }
    }

    public long getContentLength()
    {
        String s = getFirst("Content-Length");
        if (s != null)
        {
            return Long.parseLong(s);
        } else
        {
            return -1L;
        }
    }

    public MediaType getContentType()
    {
        String s = getFirst("Content-Type");
        if (s != null)
        {
            return MediaType.parseMediaType(s);
        } else
        {
            return null;
        }
    }

    public String getFirst(String s)
    {
        s = (List)headers.get(s);
        if (s != null)
        {
            return (String)s.get(0);
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        return headers.hashCode();
    }

    public boolean isEmpty()
    {
        return headers.isEmpty();
    }

    public Set keySet()
    {
        return headers.keySet();
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, (List)obj1);
    }

    public List put(String s, List list)
    {
        return (List)headers.put(s, list);
    }

    public void putAll(Map map)
    {
        headers.putAll(map);
    }

    public volatile Object remove(Object obj)
    {
        return remove(obj);
    }

    public List remove(Object obj)
    {
        return (List)headers.remove(obj);
    }

    public void set(String s, String s1)
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(s1);
        headers.put(s, linkedlist);
    }

    public void setAccept(List list)
    {
        set("Accept", MediaType.toString(list));
    }

    public void setAcceptCharset(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            stringbuilder.append(((Charset)list.next()).name().toLowerCase(Locale.ENGLISH));
            if (list.hasNext())
            {
                stringbuilder.append(", ");
            }
        } while (true);
        set("Accept-Charset", stringbuilder.toString());
    }

    public void setContentDispositionFormData(String s, String s1)
    {
        Assert.notNull(s, "'name' must not be null");
        StringBuilder stringbuilder = new StringBuilder("form-data; name=\"");
        stringbuilder.append(s).append('"');
        if (s1 != null)
        {
            stringbuilder.append("; filename=\"");
            stringbuilder.append(s1).append('"');
        }
        set("Content-Disposition", stringbuilder.toString());
    }

    public void setContentLength(long l)
    {
        set("Content-Length", Long.toString(l));
    }

    public void setContentType(MediaType mediatype)
    {
        boolean flag1 = true;
        boolean flag;
        if (!mediatype.isWildcardType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.isTrue(flag, "'Content-Type' cannot contain wildcard type '*'");
        if (!mediatype.isWildcardSubtype())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assert.isTrue(flag, "'Content-Type' cannot contain wildcard subtype '*'");
        set("Content-Type", mediatype.toString());
    }

    public int size()
    {
        return headers.size();
    }

    public String toString()
    {
        return headers.toString();
    }

    public Collection values()
    {
        return headers.values();
    }

}
