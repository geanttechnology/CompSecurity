// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

// Referenced classes of package com.loopj.android.http:
//            SimpleMultipartEntity

public class RequestParams
{
    private static class FileWrapper
    {

        public String contentType;
        public String fileName;
        public InputStream inputStream;

        public String getFileName()
        {
            if (fileName != null)
            {
                return fileName;
            } else
            {
                return "nofilename";
            }
        }

        public FileWrapper(InputStream inputstream, String s, String s1)
        {
            inputStream = inputstream;
            fileName = s;
            contentType = s1;
        }
    }


    private static String ENCODING = "UTF-8";
    protected ConcurrentHashMap fileParams;
    protected ConcurrentHashMap urlParams;
    protected ConcurrentHashMap urlParamsWithArray;

    public RequestParams()
    {
        init();
    }

    public RequestParams(String s, String s1)
    {
        init();
        put(s, s1);
    }

    public RequestParams(Map map)
    {
        init();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public transient RequestParams(Object aobj[])
    {
        init();
        int j = aobj.length;
        if (j % 2 != 0)
        {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < j; i += 2)
        {
            put(String.valueOf(aobj[i]), String.valueOf(aobj[i + 1]));
        }

    }

    private void init()
    {
        urlParams = new ConcurrentHashMap();
        fileParams = new ConcurrentHashMap();
        urlParamsWithArray = new ConcurrentHashMap();
    }

    public HttpEntity getEntity()
    {
        Object obj;
        if (!fileParams.isEmpty())
        {
            SimpleMultipartEntity simplemultipartentity = new SimpleMultipartEntity();
            java.util.Map.Entry entry;
            for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); simplemultipartentity.addPart((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            int j = fileParams.entrySet().size();
            obj = fileParams.entrySet().iterator();
            int i = 0;
            while (((Iterator) (obj)).hasNext()) 
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                FileWrapper filewrapper = (FileWrapper)entry1.getValue();
                if (filewrapper.inputStream != null)
                {
                    boolean flag;
                    if (i == j - 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (filewrapper.contentType != null)
                    {
                        simplemultipartentity.addPart((String)entry1.getKey(), filewrapper.getFileName(), filewrapper.inputStream, filewrapper.contentType, flag);
                    } else
                    {
                        simplemultipartentity.addPart((String)entry1.getKey(), filewrapper.getFileName(), filewrapper.inputStream, flag);
                    }
                }
                i++;
            }
            Iterator iterator1 = urlParamsWithArray.entrySet().iterator();
            do
            {
                obj = simplemultipartentity;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj = (java.util.Map.Entry)iterator1.next();
                Iterator iterator2 = ((ArrayList)((java.util.Map.Entry) (obj)).getValue()).iterator();
                while (iterator2.hasNext()) 
                {
                    String s = (String)iterator2.next();
                    simplemultipartentity.addPart((String)((java.util.Map.Entry) (obj)).getKey(), s);
                }
            } while (true);
        } else
        {
            try
            {
                obj = new UrlEncodedFormEntity(getParamsList(), ENCODING);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
                return null;
            }
        }
        return ((HttpEntity) (obj));
    }

    protected String getParamString()
    {
        return URLEncodedUtils.format(getParamsList(), ENCODING);
    }

    protected List getParamsList()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        for (Iterator iterator1 = urlParamsWithArray.entrySet().iterator(); iterator1.hasNext();)
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            Iterator iterator2 = ((ArrayList)entry1.getValue()).iterator();
            while (iterator2.hasNext()) 
            {
                String s = (String)iterator2.next();
                linkedlist.add(new BasicNameValuePair((String)entry1.getKey(), s));
            }
        }

        return linkedlist;
    }

    public void put(String s, File file)
        throws FileNotFoundException
    {
        put(s, ((InputStream) (new FileInputStream(file))), file.getName());
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
            fileParams.put(s, new FileWrapper(inputstream, s1, s2));
        }
    }

    public void put(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            urlParams.put(s, s1);
        }
    }

    public void put(String s, ArrayList arraylist)
    {
        if (s != null && arraylist != null)
        {
            urlParamsWithArray.put(s, arraylist);
        }
    }

    public void remove(String s)
    {
        urlParams.remove(s);
        fileParams.remove(s);
        urlParamsWithArray.remove(s);
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

        for (Iterator iterator1 = fileParams.entrySet().iterator(); iterator1.hasNext(); stringbuilder.append("FILE"))
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry1.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator2 = urlParamsWithArray.entrySet().iterator(); iterator2.hasNext();)
        {
            java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            ArrayList arraylist = (ArrayList)entry2.getValue();
            Iterator iterator3 = arraylist.iterator();
            while (iterator3.hasNext()) 
            {
                String s = (String)iterator3.next();
                if (arraylist.indexOf(s) != 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append((String)entry2.getKey());
                stringbuilder.append("=");
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

}
