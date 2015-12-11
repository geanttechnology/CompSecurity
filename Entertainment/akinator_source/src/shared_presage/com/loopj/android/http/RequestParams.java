// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            r, t, ResponseHandlerInterface

public class RequestParams
{
    private static final class a
    {

        public File a;
        public String b;

        public a(File file, String s)
        {
            a = file;
            b = s;
        }
    }

    private static final class b
    {

        public InputStream a;
        public String b;
        public String c;

        public b(InputStream inputstream, String s, String s1)
        {
            a = inputstream;
            b = s;
            c = s1;
        }
    }


    protected ConcurrentHashMap fileParams;
    protected boolean isRepeatable;
    protected ConcurrentHashMap streamParams;
    protected ConcurrentHashMap urlParams;
    protected ConcurrentHashMap urlParamsWithObjects;

    public RequestParams()
    {
        this(((Map) (null)));
    }

    public RequestParams(String s, String s1)
    {
        this(((Map) (new r(s, s1))));
    }

    public RequestParams(Map map)
    {
        isRepeatable = false;
        init();
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); put((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
    }

    public transient RequestParams(Object aobj[])
    {
        int i = 0;
        super();
        isRepeatable = false;
        init();
        int j = aobj.length;
        if (j % 2 != 0)
        {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (; i < j; i += 2)
        {
            put(String.valueOf(aobj[i]), String.valueOf(aobj[i + 1]));
        }

    }

    private HttpEntity createFormEntity()
    {
        UrlEncodedFormEntity urlencodedformentity;
        try
        {
            urlencodedformentity = new UrlEncodedFormEntity(getParamsList(), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return null;
        }
        return urlencodedformentity;
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface responsehandlerinterface)
    {
        responsehandlerinterface = new t(responsehandlerinterface);
        responsehandlerinterface.a(isRepeatable);
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); responsehandlerinterface.a((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        BasicNameValuePair basicnamevaluepair;
        for (Iterator iterator1 = getParamsList(null, urlParamsWithObjects).iterator(); iterator1.hasNext(); responsehandlerinterface.a(basicnamevaluepair.getName(), basicnamevaluepair.getValue()))
        {
            basicnamevaluepair = (BasicNameValuePair)iterator1.next();
        }

        Iterator iterator2 = streamParams.entrySet().iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator2.next();
            b b1 = (b)entry1.getValue();
            if (b1.a != null)
            {
                responsehandlerinterface.a((String)entry1.getKey(), b1.b, b1.a, b1.c);
            }
        } while (true);
        java.util.Map.Entry entry2;
        a a1;
        for (Iterator iterator3 = fileParams.entrySet().iterator(); iterator3.hasNext(); responsehandlerinterface.a((String)entry2.getKey(), a1.a, a1.b))
        {
            entry2 = (java.util.Map.Entry)iterator3.next();
            a1 = (a)entry2.getValue();
        }

        return responsehandlerinterface;
    }

    private List getParamsList(String s, Object obj)
    {
        LinkedList linkedlist = new LinkedList();
        if (obj instanceof Map)
        {
            Map map = (Map)obj;
            obj = new ArrayList(map.keySet());
            Collections.sort(((List) (obj)));
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (String)iterator.next();
                Object obj3 = map.get(obj);
                if (obj3 != null)
                {
                    if (s != null)
                    {
                        obj = String.format("%s[%s]", new Object[] {
                            s, obj
                        });
                    }
                    linkedlist.addAll(getParamsList(((String) (obj)), obj3));
                }
            } while (true);
        } else
        if (obj instanceof List)
        {
            Object obj1;
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); linkedlist.addAll(getParamsList(String.format("%s[]", new Object[] {
    s
}), obj1)))
            {
                obj1 = ((Iterator) (obj)).next();
            }

        } else
        if (obj instanceof Object[])
        {
            obj = ((Object) ((Object[])obj));
            int j = obj.length;
            for (int i = 0; i < j; i++)
            {
                Object obj2 = obj[i];
                linkedlist.addAll(getParamsList(String.format("%s[]", new Object[] {
                    s
                }), obj2));
            }

        } else
        if (obj instanceof Set)
        {
            for (obj = ((Set)obj).iterator(); ((Iterator) (obj)).hasNext(); linkedlist.addAll(getParamsList(s, ((Iterator) (obj)).next()))) { }
        } else
        if (obj instanceof String)
        {
            linkedlist.add(new BasicNameValuePair(s, (String)obj));
        }
        return linkedlist;
    }

    private void init()
    {
        urlParams = new ConcurrentHashMap();
        streamParams = new ConcurrentHashMap();
        fileParams = new ConcurrentHashMap();
        urlParamsWithObjects = new ConcurrentHashMap();
    }

    public void add(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            Object obj1 = urlParamsWithObjects.get(s);
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = new HashSet();
                put(s, obj);
            }
            if (obj instanceof List)
            {
                ((List)obj).add(s1);
            } else
            if (obj instanceof Set)
            {
                ((Set)obj).add(s1);
                return;
            }
        }
    }

    public HttpEntity getEntity(ResponseHandlerInterface responsehandlerinterface)
    {
        if (streamParams.isEmpty() && fileParams.isEmpty())
        {
            return createFormEntity();
        } else
        {
            return createMultipartEntity(responsehandlerinterface);
        }
    }

    protected String getParamString()
    {
        return URLEncodedUtils.format(getParamsList(), "UTF-8");
    }

    protected List getParamsList()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        linkedlist.addAll(getParamsList(null, urlParamsWithObjects));
        return linkedlist;
    }

    public void put(String s, File file)
    {
        put(s, file, null);
    }

    public void put(String s, File file, String s1)
    {
        if (s != null && file != null)
        {
            fileParams.put(s, new a(file, s1));
        }
    }

    public void put(String s, InputStream inputstream)
    {
        put(s, inputstream, null);
    }

    public void put(String s, InputStream inputstream, String s1)
    {
        put(s, inputstream, s1, null);
    }

    public void put(String s, InputStream inputstream, String s1, String s2)
    {
        if (s != null && inputstream != null)
        {
            streamParams.put(s, new b(inputstream, s1, s2));
        }
    }

    public void put(String s, Object obj)
    {
        if (s != null && obj != null)
        {
            urlParamsWithObjects.put(s, obj);
        }
    }

    public void put(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            urlParams.put(s, s1);
        }
    }

    public void remove(String s)
    {
        urlParams.remove(s);
        streamParams.remove(s);
        fileParams.remove(s);
        urlParamsWithObjects.remove(s);
    }

    public void setHttpEntityIsRepeatable(boolean flag)
    {
        isRepeatable = flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator1 = streamParams.entrySet().iterator(); iterator1.hasNext(); stringbuilder.append("STREAM"))
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry1.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator2 = fileParams.entrySet().iterator(); iterator2.hasNext(); stringbuilder.append("FILE"))
        {
            java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry2.getKey());
            stringbuilder.append("=");
        }

        BasicNameValuePair basicnamevaluepair;
        for (Iterator iterator3 = getParamsList(null, urlParamsWithObjects).iterator(); iterator3.hasNext(); stringbuilder.append(basicnamevaluepair.getValue()))
        {
            basicnamevaluepair = (BasicNameValuePair)iterator3.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(basicnamevaluepair.getName());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }
}
